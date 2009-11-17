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

package org.op4j.executables.functions.conversion;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import org.apache.commons.lang.LocaleUtils;
import org.op4j.executables.functions.conversion.ToNumber.Delegated;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ToDecimalNumber {

    
    private ToDecimalNumber() {
        super();
    }
    


    
    
    
    
    
    static abstract class FromNumber<X extends Number> extends ToNumber.FromNumber<X> {

        private int scale = 0;
        private RoundingMode roundingMode = null;
        
        public FromNumber() {
            super();
        }

        public FromNumber(final int scale, final RoundingMode roundingMode) {
            super(Delegated.DELEGATED);
            this.scale = scale;
            this.roundingMode = roundingMode;
        }

        @Override
        protected X numberExecute(final Number object) throws Exception {
            return fromNumber(object, this.scale, this.roundingMode);
        }
        

        
        protected final X fromNumber(
                final Number number, final int withScale, final RoundingMode withRoundingMode) throws Exception {
            BigDecimal bigDecimal = null;
            if (number instanceof BigDecimal) {
                bigDecimal = (BigDecimal) number;
            } else if (number instanceof BigInteger) {
                bigDecimal = new BigDecimal((BigInteger) number);
            } else {
                bigDecimal = new BigDecimal(number.doubleValue());
            }
            bigDecimal = bigDecimal.setScale(withScale, withRoundingMode);
            return fromNumber(bigDecimal);
        }

        
        protected final X fromString(
                final String string, final int withScale, final RoundingMode withRoundingMode) throws Exception {
            return fromNumber(fromString(string), withScale, withRoundingMode);
        }
        
    }

    
    
    
    
    
    static abstract class FromString<X extends Number> extends ToNumber.FromString<X> {

        private static enum ExecType 
                { FROM_STRING_SCALE_ROUNDINGMODE, FROM_STRING_SCALE_ROUNDINGMODE_LOCALE, FROM_STRING_SCALE_ROUNDINGMODE_DECIMALPOINT } 
            
        private ExecType execType = null;
        private int scale = 0;
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

        
        public FromString(final int scale, final RoundingMode roundingMode) {
            super(ToNumber.Delegated.DELEGATED);
            this.execType = ExecType.FROM_STRING_SCALE_ROUNDINGMODE;
            this.scale = scale;
            this.roundingMode = roundingMode;
        }

        
        public FromString(final int scale, final RoundingMode roundingMode, final Locale locale) {
            super(ToNumber.Delegated.DELEGATED);
            this.execType = ExecType.FROM_STRING_SCALE_ROUNDINGMODE_LOCALE;
            this.scale = scale;
            this.roundingMode = roundingMode;
            this.decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
            this.decimalFormat.setParseBigDecimal(true);
        }

        
        public FromString(final int scale, final RoundingMode roundingMode, final String locale) {
            super(ToNumber.Delegated.DELEGATED);
            this.execType = ExecType.FROM_STRING_SCALE_ROUNDINGMODE_LOCALE;
            this.scale = scale;
            this.roundingMode = roundingMode;
            this.decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(LocaleUtils.toLocale(locale));
            this.decimalFormat.setParseBigDecimal(true);
        }

        
        public FromString(final int scale, final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
            super(ToNumber.Delegated.DELEGATED);
            this.execType = ExecType.FROM_STRING_SCALE_ROUNDINGMODE_DECIMALPOINT;
            this.scale = scale;
            this.roundingMode = roundingMode;
            this.decimalPoint = decimalPoint;
        }



        @Override
        public X numberExecute(final String object) throws Exception {
            switch (this.execType) {
                case FROM_STRING_SCALE_ROUNDINGMODE:
                    return fromString(object, this.scale, this.roundingMode);
                case FROM_STRING_SCALE_ROUNDINGMODE_LOCALE:
                    return fromNumber(this.decimalFormat.parse(object), this.scale, this.roundingMode);
                case FROM_STRING_SCALE_ROUNDINGMODE_DECIMALPOINT:
                    try {
                        return fromString(rebuildNumberString(object, this.decimalPoint), this.scale, this.roundingMode);
                    } catch (NumberFormatException e) {
                        // original input could have been modified, so raise the right exception
                        throw new NumberFormatException("For input string: \"" + object + "\"");
                    }
            }
            // This will never be reached
            throw new IllegalStateException("Execution type did not match!");
        }
        

        
        protected final X fromNumber(
                final Number number, final int withScale, final RoundingMode withRoundingMode) throws Exception {
            BigDecimal bigDecimal = null;
            if (number instanceof BigDecimal) {
                bigDecimal = (BigDecimal) number;
            } else if (number instanceof BigInteger) {
                bigDecimal = new BigDecimal((BigInteger) number);
            } else {
                bigDecimal = new BigDecimal(number.doubleValue());
            }
            bigDecimal = bigDecimal.setScale(withScale, withRoundingMode);
            return fromNumber(bigDecimal);
        }

        
        protected final X fromString(
                final String string, final int withScale, final RoundingMode withRoundingMode) throws Exception {
            return fromNumber(fromString(string), withScale, withRoundingMode);
        }
        
    }
    
    
}
