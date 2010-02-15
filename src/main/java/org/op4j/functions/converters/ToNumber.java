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

package org.op4j.functions.converters;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.Validate;
import org.op4j.functions.AbstractNullAsNullFunc;
import org.op4j.functions.ExecCtx;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ToNumber {
    
    
    private ToNumber() {
        super();
    }
    
    final static class Delegated {
        
        public static Delegated DELEGATED = new Delegated();
        
        private Delegated() {
            super();
        }
    }
    
    
    static abstract class ToNumberFunction<X extends Number, T> extends AbstractNullAsNullFunc<X, T> {
        
        ToNumberFunction() {
            super();
        }

        protected abstract X fromNumber(final Number number);
        protected abstract X fromString(final String string);
        
    }
    

    
    
    
    static abstract class FromNumber<X extends Number> extends ToNumberFunction<X, Number> {


        private static enum ExecType 
                { FROM_NUMBER, DELEGATED } 
        
        private final ExecType execType;

        
        protected FromNumber() {
            super();
            this.execType = ExecType.FROM_NUMBER;
        }
        
        
        protected FromNumber(final Delegated delegated) {
            super();
            Validate.notNull(delegated, "Parameter \"delegated\" cannot be null");
            this.execType = ExecType.DELEGATED;
        }

        @Override
        public X nullAsNullExecute(final Number object, final ExecCtx ctx) throws Exception {
            switch (this.execType) {
                case DELEGATED:
                    return numberExecute(object);
                case FROM_NUMBER:
                    return fromNumber(object);
            }
            // This will never be reached
            throw new IllegalStateException("Execution type did not match!");
        }

        protected abstract X numberExecute(final Number object) throws Exception;
        
    }
    
    

    
    static abstract class FromBoolean<X extends Number> extends ToNumberFunction<X, Boolean> {

        protected FromBoolean() {
            super();
        }

        @Override
        public X nullAsNullExecute(Boolean object, final ExecCtx ctx) throws Exception {
            return fromNumber(BooleanUtils.toIntegerObject(object));
        }
        
    }
    
    

    
    static abstract class FromString<X extends Number> extends ToNumberFunction<X, String> {

        private static enum ExecType 
                { FROM_STRING, FROM_STRING_LOCALE, FROM_STRING_DECIMALPOINT, DELEGATED } 
            
        private final ExecType execType;
        private DecimalFormat decimalFormat = null;
        private DecimalPoint decimalPoint = null;
        
        
        protected FromString(final Delegated delegated) {
            super();
            this.execType = ExecType.DELEGATED;
        }
        
        
        protected FromString() {
            super();
            this.execType = ExecType.FROM_STRING;
        }
        
        
        protected FromString(final Locale locale) {
            super();
            Validate.notNull(locale, "A locale must be specified");
            this.execType = ExecType.FROM_STRING_LOCALE;
            this.decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
            this.decimalFormat.setParseBigDecimal(true);
        }
        
        
        protected FromString(final String locale) {
            super();
            Validate.notNull(locale, "A locale must be specified");
            this.execType = ExecType.FROM_STRING_LOCALE;
            this.decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(LocaleUtils.toLocale(locale));
            this.decimalFormat.setParseBigDecimal(true);
        }
        
        
        protected FromString(final DecimalPoint decimalPoint) {
            super();
            Validate.notNull(decimalPoint, "A decimal point type must be specified");
            this.execType = ExecType.FROM_STRING_DECIMALPOINT;
            this.decimalPoint = decimalPoint;
        }

        
        @Override
        public final X nullAsNullExecute(final String object, final ExecCtx ctx) throws Exception {
            switch (this.execType) {
                case DELEGATED:
                    return numberExecute(object);
                case FROM_STRING:
                    return fromString(object);
                case FROM_STRING_LOCALE:
                    return fromNumber(this.decimalFormat.parse(object));
                case FROM_STRING_DECIMALPOINT:
                    try {
                        return fromString(rebuildNumberString(object, this.decimalPoint));
                    } catch (NumberFormatException e) {
                        // original input could have been modified, so raise the right exception
                        throw new NumberFormatException("For input string: \"" + object + "\"");
                    }
            }
            // This will never be reached
            throw new IllegalStateException("Execution type did not match!");
        }
        
        
        public abstract X numberExecute(final String object) throws Exception;

        
        protected static final String rebuildNumberString(final String original, final DecimalPoint decimalPoint) {
            
            if (DecimalPoint.CAN_BE_POINT_OR_COMMA.equals(decimalPoint)) {
                final int lastPoint = original.lastIndexOf(".");
                final int lastComma = original.lastIndexOf(",");
                if (lastPoint >= lastComma) {
                    return rebuildNumberString(original, DecimalPoint.IS_POINT);
                }
                return rebuildNumberString(original, DecimalPoint.IS_COMMA);
            }
            
            if (DecimalPoint.IS_POINT.equals(decimalPoint)) {
                return original;
            }
            
            /*
             * Java's standard decimal point for valueOf operations is point,
             * so the decimal comma will have to be replaced by a point.
             */
            final int lastPos = original.lastIndexOf(",");
            if (lastPos == -1) {
                // This is to avoid that things like "12.34" are valid if decimal is comma
                return original + ".0";
            }
            return original.substring(0, lastPos) + "." +
                    (lastPos + 1 < original.length()? original.substring(lastPos + 1) : "");
            
        }

        
        
    }
    
}
