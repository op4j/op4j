/*
 * =============================================================================
 * 
 *   Copyright (c) 2008, The OP4J team (http://www.op4j.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */

package org.op4j.functions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.Validate;
import org.op4j.exceptions.ExecutionException;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ConvertToNonDecimalNumber {

    
    private ConvertToNonDecimalNumber() {
        super();
    }
    
    
    static abstract class FromString<X extends Number> extends ConvertToNumber.FromString<X> {

        private static enum ExecType 
                { FROM_STRING_RADIX, FROM_STRING_ROUNDINGMODE, FROM_STRING_ROUNDINGMODE_LOCALE, FROM_STRING_ROUNDINGMODE_DECIMALPOINT } 
            
        private ExecType execType = null;
        private Integer radix = null;
        private RoundingMode roundingMode = null;
        private DecimalFormat decimalFormat = null;
        private DecimalPoint decimalPoint = null;
        
        
        public FromString() {
            super();
        }

        
        public FromString(final DecimalPoint decimalPoint) {
            super(decimalPoint);
        }

        
        public FromString(final Locale locale) {
            super(locale);
        }

        
        public FromString(final String locale) {
            super(locale);
        }

        
        public FromString(final Integer radix) {
            super(ConvertToNumber.Delegated.DELEGATED);
            Validate.notNull(radix, "A radix must be specified");
            this.execType = ExecType.FROM_STRING_RADIX;
            this.radix = radix;
        }

        
        public FromString(final RoundingMode roundingMode) {
            super(ConvertToNumber.Delegated.DELEGATED);
            Validate.notNull(roundingMode, "A rounding mode must be specified");
            this.execType = ExecType.FROM_STRING_ROUNDINGMODE;
            this.roundingMode = roundingMode;
        }

        
        public FromString(final RoundingMode roundingMode, final Locale locale) {
            super(ConvertToNumber.Delegated.DELEGATED);
            Validate.notNull(roundingMode, "A rounding mode must be specified");
            Validate.notNull(locale, "A locale must be specified");
            this.execType = ExecType.FROM_STRING_ROUNDINGMODE_LOCALE;
            this.roundingMode = roundingMode;
            this.decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
            this.decimalFormat.setParseBigDecimal(true);
        }

        
        public FromString(final RoundingMode roundingMode, final String locale) {
            super(ConvertToNumber.Delegated.DELEGATED);
            Validate.notNull(roundingMode, "A rounding mode must be specified");
            Validate.notNull(locale, "A locale must be specified");
            this.execType = ExecType.FROM_STRING_ROUNDINGMODE_LOCALE;
            this.roundingMode = roundingMode;
            this.decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(LocaleUtils.toLocale(locale));
            this.decimalFormat.setParseBigDecimal(true);
        }

        
        public FromString(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
            super(ConvertToNumber.Delegated.DELEGATED);
            Validate.notNull(roundingMode, "A rounding mode must be specified");
            Validate.notNull(decimalPoint, "A decimal point type must be specified");
            this.execType = ExecType.FROM_STRING_ROUNDINGMODE_DECIMALPOINT;
            this.roundingMode = roundingMode;
            this.decimalPoint = decimalPoint;
        }



        @Override
        public X numberExecute(final String object) {
            switch (this.execType) {
                case FROM_STRING_RADIX:
                    return fromString(object, this.radix.intValue());
                case FROM_STRING_ROUNDINGMODE:
                    return fromString(object, this.roundingMode);
                case FROM_STRING_ROUNDINGMODE_LOCALE:
                    try {
                        return fromNumber(this.decimalFormat.parse(object), this.roundingMode);
                    } catch (final ParseException e) {
                        throw new ExecutionException("Unable to parse: \"" + object + "\"", e);
                    }
                case FROM_STRING_ROUNDINGMODE_DECIMALPOINT:
                    try {
                        return fromString(rebuildNumberString(object, this.decimalPoint), this.roundingMode);
                    } catch (NumberFormatException e) {
                        // original input could have been modified, so raise the right exception
                        throw new NumberFormatException("For input string: \"" + object + "\"");
                    }
            }
            // This will never be reached
            throw new IllegalStateException("Execution type did not match!");
        }

        
        
        
        protected abstract X fromString(final String string, final int withRadix);
        
        
        
        protected final X fromNumber(
                final Number number, final RoundingMode withRoundingMode) {
            BigDecimal bigDecimal = null;
            if (number instanceof BigDecimal) {
                bigDecimal = (BigDecimal) number;
            } else if (number instanceof BigInteger) {
                bigDecimal = new BigDecimal((BigInteger) number);
            } else {
                bigDecimal = new BigDecimal(number.doubleValue());
            }
            bigDecimal = bigDecimal.setScale(0, withRoundingMode); // scale == 0
            return fromNumber(bigDecimal);
        }

        
        protected final X fromString(
                final String string, final RoundingMode withRoundingMode) {
            return fromNumber(new BigDecimal(string), withRoundingMode);
        }
        
    }
    
    
    
    
    
}
