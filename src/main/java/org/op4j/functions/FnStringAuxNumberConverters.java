/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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
import java.text.ParsePosition;
import java.util.Locale;

import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.Validate;
import org.op4j.exceptions.ExecutionException;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * @author Soraya S&aacute;nchez Labandeira
 */
final class FnStringAuxNumberConverters {

	
	private FnStringAuxNumberConverters() {
		super();           
	}


    
    private static final class Delegated {
        
        public static Delegated DELEGATED = new Delegated();
        
        private Delegated() {
            super();
        }
    }
	
	
    
    private static abstract class ToNumber<X extends Number> extends AbstractNullAsNullFunction<String,X> {

        private static enum ExecType 
                { PARAM_NONE, PARAM_LOCALE, PARAM_DECIMALPOINT, DELEGATED } 

        
        private final ExecType execType;
        private final DecimalFormat decimalFormat;
        private final DecimalPoint decimalPoint;

        private final DecimalFormat defaultDecimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        
        private final void configureDefaultDecimalFormat() {
            this.defaultDecimalFormat.setParseBigDecimal(true);
        }
        
        protected ToNumber(final Delegated delegated) {
            super();
            configureDefaultDecimalFormat();
            this.execType = ExecType.DELEGATED;
            this.decimalFormat = null;
            this.decimalPoint = null;
        }
        
        protected ToNumber() {
            super();
            configureDefaultDecimalFormat();
            this.execType = ExecType.PARAM_NONE;
            this.decimalFormat = null;
            this.decimalPoint = null;
        }

        protected ToNumber(final Locale locale) {
            super();
            Validate.notNull(locale, "A locale must be specified");
            configureDefaultDecimalFormat();
            this.execType = ExecType.PARAM_LOCALE;
            this.decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
            this.decimalFormat.setParseBigDecimal(true);
            this.decimalPoint = null;
        }

        protected ToNumber(final String locale) {
            super();
            Validate.notNull(locale, "A locale must be specified");
            configureDefaultDecimalFormat();
            this.execType = ExecType.PARAM_LOCALE;
            this.decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(LocaleUtils.toLocale(locale));
            this.decimalFormat.setParseBigDecimal(true);
            this.decimalPoint = null;
        }

        protected ToNumber(final DecimalPoint decimalPoint) {
            super();
            Validate.notNull(decimalPoint, "A decimal point type must be specified");
            configureDefaultDecimalFormat();
            this.execType = ExecType.PARAM_DECIMALPOINT;
            this.decimalFormat = null;
            this.decimalPoint = decimalPoint;
        }
        

        @Override
        public final X nullAsNullExecute(final String string, final ExecCtx ctx) throws Exception {
            switch (this.execType) {
                case DELEGATED:
                    return numberExecute(string);
                case PARAM_NONE:
                    return fromString(string);
                case PARAM_LOCALE:
                    try {
                        //It uses ParsePosition to make sure the whole 
                        //string has been converted into a number
                        ParsePosition pp = new ParsePosition(0);
                        Number number = this.decimalFormat.parse(string, pp);
                        if (pp.getIndex() != string.length()) {
                            throw new ParseException("The whole input String does not represent a valid number", 
                                    pp.getIndex());
                        }                        
                        return fromNumber(number);
                    } catch (final ParseException e) {
                        throw new ExecutionException("Unable to parse: \"" + string + "\"", e);
                    }
                case PARAM_DECIMALPOINT:
                    try {
                        return fromString(rebuildNumberString(string, this.decimalPoint));
                    } catch (NumberFormatException e) {
                        // original input could have been modified, so raise the right exception
                        throw new NumberFormatException("For input string: \"" + string + "\"");
                    }
            }
            // This will never be reached
            throw new IllegalStateException("Execution type did not match!");
        }

        
        abstract X numberExecute(final String object);
        
        final X fromString(final String string) {
            try {
                //It uses ParsePosition to make sure the whole 
                //string has been converted into a number
                ParsePosition pp = new ParsePosition(0);
                Number number = this.defaultDecimalFormat.parse(string, pp);
                if (pp.getIndex() != string.length()) {
                    throw new ParseException("The whole input String does not represent a valid number", 
                            pp.getIndex());
                }    
                return fromNumber(number);     
            } catch (final ParseException e) {
                throw new ExecutionException("Unable to parse: \"" + string + "\"", e);
            }
        }
        
        abstract X fromNumber(final Number number);

        
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
             * Besides this, the points will be removed from the input string 
             * as they have to be ignored
             */
            String originalWithoutPoints = original.replace(".", "");
            final int lastPos = originalWithoutPoints.lastIndexOf(",");
            if (lastPos == -1) {
                return originalWithoutPoints;
            }
            return originalWithoutPoints.substring(0, lastPos) + "." +
                    (lastPos + 1 < originalWithoutPoints.length()? originalWithoutPoints.substring(lastPos + 1) : "");
            
        }

        
    }
    
    

    
    private static abstract class ToNonDecimalNumber<X extends Number> extends ToNumber<X> {

        private static enum ExecType 
                { PARAM_RADIX, PARAM_ROUNDINGMODE, PARAM_ROUNDINGMODE_LOCALE, PARAM_ROUNDINGMODE_DECIMALPOINT } 
        
        private ExecType execType = null;
        private Integer radix = null;
        private RoundingMode roundingMode = null;
        private DecimalFormat decimalFormat = null;
        private DecimalPoint decimalPoint = null;

        
        protected ToNonDecimalNumber() {
            super();
        }

        protected ToNonDecimalNumber(final Locale locale) {
            super(locale);
        }

        protected ToNonDecimalNumber(final String locale) {
            super(locale);
        }

        protected ToNonDecimalNumber(final DecimalPoint decimalPoint) {
            super(decimalPoint);
        }

        
        public ToNonDecimalNumber(final Integer radix) {
            super(Delegated.DELEGATED);
            Validate.notNull(radix, "A radix must be specified");
            this.execType = ExecType.PARAM_RADIX;
            this.radix = radix;
        }

        
        public ToNonDecimalNumber(final RoundingMode roundingMode) {
            super(Delegated.DELEGATED);
            Validate.notNull(roundingMode, "A rounding mode must be specified");
            this.execType = ExecType.PARAM_ROUNDINGMODE;
            this.roundingMode = roundingMode;
        }

        
        public ToNonDecimalNumber(final RoundingMode roundingMode, final Locale locale) {
            super(Delegated.DELEGATED);
            Validate.notNull(roundingMode, "A rounding mode must be specified");
            Validate.notNull(locale, "A locale must be specified");
            this.execType = ExecType.PARAM_ROUNDINGMODE_LOCALE;
            this.roundingMode = roundingMode;
            this.decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
            this.decimalFormat.setParseBigDecimal(true);
        }

        
        public ToNonDecimalNumber(final RoundingMode roundingMode, final String locale) {
            super(Delegated.DELEGATED);
            Validate.notNull(roundingMode, "A rounding mode must be specified");
            Validate.notNull(locale, "A locale must be specified");
            this.execType = ExecType.PARAM_ROUNDINGMODE_LOCALE;
            this.roundingMode = roundingMode;
            this.decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(LocaleUtils.toLocale(locale));
            this.decimalFormat.setParseBigDecimal(true);
        }

        
        public ToNonDecimalNumber(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
            super(Delegated.DELEGATED);
            Validate.notNull(roundingMode, "A rounding mode must be specified");
            Validate.notNull(decimalPoint, "A decimal point type must be specified");
            this.execType = ExecType.PARAM_ROUNDINGMODE_DECIMALPOINT;
            this.roundingMode = roundingMode;
            this.decimalPoint = decimalPoint;
        }
        
        
        
        @Override
        final X numberExecute(final String string) {
            
            switch (this.execType) {
                case PARAM_RADIX:
                    return fromString(string, this.radix.intValue());
                case PARAM_ROUNDINGMODE:
                    return fromString(string, this.roundingMode);
                case PARAM_ROUNDINGMODE_LOCALE:
                    try {
                        //It uses ParsePosition to make sure the whole 
                        //string has been converted into a number
                        ParsePosition pp = new ParsePosition(0);
                        Number number = this.decimalFormat.parse(string, pp);
                        if (pp.getIndex() != string.length()) {
                            throw new ParseException("The whole input String does not represent a valid number", 
                                    pp.getIndex());
                        }
                        return fromNumber(number, this.roundingMode);
                    } catch (final ParseException e) {
                        throw new ExecutionException("Unable to parse: \"" + string + "\"", e);
                    }
                case PARAM_ROUNDINGMODE_DECIMALPOINT:
                    try {
                        return fromString(rebuildNumberString(string, this.decimalPoint), this.roundingMode);
                    } catch (NumberFormatException e) {
                        // original input could have been modified, so raise the right exception
                        throw new NumberFormatException("For input string: \"" + string + "\"");
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
    

    
    
    private static abstract class ToDecimalNumber<X extends Number> extends ToNumber<X> {

        private static enum ExecType 
                { PARAM_SCALE_ROUNDINGMODE, PARAM_SCALE_ROUNDINGMODE_LOCALE, PARAM_SCALE_ROUNDINGMODE_DECIMALPOINT } 
            
        private ExecType execType = null;
        private int scale = 0;
        private RoundingMode roundingMode = null;
        private DecimalFormat decimalFormat = null;
        private DecimalPoint decimalPoint = null;
        
        
        public ToDecimalNumber() {
            super();
        }

        
        public ToDecimalNumber(final DecimalPoint decimalPoint) {
            super(decimalPoint);
        }

        
        public ToDecimalNumber(final Locale locale) {
            super(locale);
        }

        
        public ToDecimalNumber(final String locale) {
            super(locale);
        }

        
        public ToDecimalNumber(final int scale, final RoundingMode roundingMode) {
            super(Delegated.DELEGATED);
            Validate.notNull(roundingMode, "A rounding mode must be specified");
            this.execType = ExecType.PARAM_SCALE_ROUNDINGMODE;
            this.scale = scale;
            this.roundingMode = roundingMode;
        }

        
        public ToDecimalNumber(final int scale, final RoundingMode roundingMode, final Locale locale) {
            super(Delegated.DELEGATED);
            Validate.notNull(roundingMode, "A rounding mode must be specified");
            Validate.notNull(locale, "A locale must be specified");
            this.execType = ExecType.PARAM_SCALE_ROUNDINGMODE_LOCALE;
            this.scale = scale;
            this.roundingMode = roundingMode;
            this.decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
            this.decimalFormat.setParseBigDecimal(true);
        }

        
        public ToDecimalNumber(final int scale, final RoundingMode roundingMode, final String locale) {
            super(Delegated.DELEGATED);
            Validate.notNull(roundingMode, "A rounding mode must be specified");
            Validate.notNull(locale, "A locale must be specified");
            this.execType = ExecType.PARAM_SCALE_ROUNDINGMODE_LOCALE;
            this.scale = scale;
            this.roundingMode = roundingMode;
            this.decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(LocaleUtils.toLocale(locale));
            this.decimalFormat.setParseBigDecimal(true);
        }

        
        public ToDecimalNumber(final int scale, final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
            super(Delegated.DELEGATED);
            Validate.notNull(roundingMode, "A rounding mode must be specified");
            Validate.notNull(decimalPoint, "A decimal point type must be specified");
            this.execType = ExecType.PARAM_SCALE_ROUNDINGMODE_DECIMALPOINT;
            this.scale = scale;
            this.roundingMode = roundingMode;
            this.decimalPoint = decimalPoint;
        }
        
        
        @Override
        public X numberExecute(final String object) {
            switch (this.execType) {
                case PARAM_SCALE_ROUNDINGMODE:
                    return fromString(object, this.scale, this.roundingMode);
                case PARAM_SCALE_ROUNDINGMODE_LOCALE:
                    try {
                        //It uses ParsePosition to make sure the whole 
                        //string has been converted into a number
                        ParsePosition pp = new ParsePosition(0);
                        Number number = this.decimalFormat.parse(object, pp);
                        if (pp.getIndex() != object.length()) {
                            throw new ParseException("The whole input String does not represent a valid number", 
                                    pp.getIndex());
                        }
                        return fromNumber(number, this.scale, this.roundingMode);
                    } catch (final ParseException e) {
                        throw new ExecutionException("Unable to parse: \"" + object + "\"", e);
                    }
                case PARAM_SCALE_ROUNDINGMODE_DECIMALPOINT:
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
                final Number number, final int withScale, final RoundingMode withRoundingMode) {
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
                final String string, final int withScale, final RoundingMode withRoundingMode) {
            return fromNumber(fromString(string), withScale, withRoundingMode);
        }
        
    }
    
    
    
    
    
    static final class ToBigDecimal extends ToDecimalNumber<BigDecimal> {

        
        public ToBigDecimal() {
            super();
        }

        public ToBigDecimal(final DecimalPoint decimalPoint) {
            super(decimalPoint);
        }

        public ToBigDecimal(final Locale locale) {
            super(locale);
        }

        public ToBigDecimal(final int scale, final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
            super(scale, roundingMode, decimalPoint);
        }

        public ToBigDecimal(final int scale, final RoundingMode roundingMode, final Locale locale) {
            super(scale, roundingMode, locale);
        }

        public ToBigDecimal(final int scale, final RoundingMode roundingMode, final String locale) {
            super(scale, roundingMode, locale);
        }

        public ToBigDecimal(final int scale, final RoundingMode roundingMode) {
            super(scale, roundingMode);
        }

        public ToBigDecimal(final String locale) {
            super(locale);
        }

        
        @Override
        protected BigDecimal fromNumber(final Number number) {
            if (number instanceof BigDecimal) {
                return new BigDecimal(
                        ((BigDecimal)number).unscaledValue(),
                        ((BigDecimal)number).scale());
            } else if (number instanceof BigInteger) {
                return new BigDecimal((BigInteger)number);
            } else {
                return BigDecimal.valueOf(number.doubleValue()); 
            }
        }
    }
    
    
    
    static final class ToDouble extends ToDecimalNumber<Double> {

        final static Double min = Double.valueOf(Double.MIN_VALUE);   
        final static Double max = Double.valueOf(Double.MAX_VALUE);
        
        public ToDouble() {
            super();
        }

        public ToDouble(final DecimalPoint decimalPoint) {
            super(decimalPoint);
        }

        public ToDouble(final Locale locale) {
            super(locale);
        }

        public ToDouble(final int scale, final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
            super(scale, roundingMode, decimalPoint);
        }

        public ToDouble(final int scale, final RoundingMode roundingMode, final Locale locale) {
            super(scale, roundingMode, locale);
        }

        public ToDouble(final int scale, final RoundingMode roundingMode, final String locale) {
            super(scale, roundingMode, locale);
        }

        public ToDouble(final int scale, final RoundingMode roundingMode) {
            super(scale, roundingMode);
        }

        public ToDouble(final String locale) {
            super(locale);
        }

        @Override
        protected Double fromNumber(final Number number) {
            Validate.isTrue(number instanceof BigDecimal || number instanceof BigInteger, 
                "The param number should be either a BigDecimal or BigInteger");

            if (number instanceof BigDecimal || number instanceof BigInteger) {
                BigDecimal numberAsBigDecimal = null;
                if (number instanceof BigDecimal) {
                    numberAsBigDecimal = (BigDecimal) number;                                     
                } else {
                    numberAsBigDecimal = BigDecimal.valueOf(number.longValue());   
                }
                if (numberAsBigDecimal.compareTo(BigDecimal.valueOf(min.doubleValue())) < 0 
                        || numberAsBigDecimal.compareTo(BigDecimal.valueOf(max.doubleValue())) > 0) {
                    throw new ExecutionException("The number to be converted into Double is either lower than " + min
                            + " or greater than " + max);
                }
            } 
            
            return Double.valueOf(number.doubleValue());
        }
    }
    
    
    
    static final class ToFloat extends ToDecimalNumber<Float> {

        final static Float min = Float.valueOf(Float.MIN_VALUE);   
        final static Float max = Float.valueOf(Float.MAX_VALUE);
                
        public ToFloat() {
            super();
        }

        public ToFloat(final DecimalPoint decimalPoint) {
            super(decimalPoint);
        }

        public ToFloat(final Locale locale) {
            super(locale);
        }

        public ToFloat(final int scale, final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
            super(scale, roundingMode, decimalPoint);
        }

        public ToFloat(final int scale, final RoundingMode roundingMode, final Locale locale) {
            super(scale, roundingMode, locale);
        }

        public ToFloat(final int scale, final RoundingMode roundingMode, final String locale) {
            super(scale, roundingMode, locale);
        }

        public ToFloat(final int scale, final RoundingMode roundingMode) {
            super(scale, roundingMode);
        }

        public ToFloat(final String locale) {
            super(locale);
        }

        @Override
        protected Float fromNumber(final Number number) {
            Validate.isTrue(number instanceof BigDecimal || number instanceof BigInteger, 
                "The param number should be either a BigDecimal or BigInteger");

            if (number instanceof BigDecimal || number instanceof BigInteger) {
                BigDecimal numberAsBigDecimal = null;
                if (number instanceof BigDecimal) {
                    numberAsBigDecimal = (BigDecimal) number;                                     
                } else {
                    numberAsBigDecimal = BigDecimal.valueOf(number.longValue());   
                }
                if (numberAsBigDecimal.compareTo(BigDecimal.valueOf(min.floatValue())) < 0 
                        || numberAsBigDecimal.compareTo(BigDecimal.valueOf(max.floatValue())) > 0) {
                    throw new ExecutionException("The number to be converted into Float is either lower than " + min
                            + " or greater than " + max);
                }
            } 
            
            return Float.valueOf(number.floatValue());
        }
    }
    
    
    
    static final class ToBigInteger extends ToNonDecimalNumber<BigInteger> {

        
        public ToBigInteger() {
            super();
        }

        public ToBigInteger(final DecimalPoint decimalPoint) {
            super(decimalPoint);
        }

        public ToBigInteger(final Integer radix) {
            super(radix);
        }

        public ToBigInteger(final Locale locale) {
            super(locale);
        }

        public ToBigInteger(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
            super(roundingMode, decimalPoint);
        }

        public ToBigInteger(final RoundingMode roundingMode, final Locale locale) {
            super(roundingMode, locale);
        }

        public ToBigInteger(final RoundingMode roundingMode, final String locale) {
            super(roundingMode, locale);
        }

        public ToBigInteger(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public ToBigInteger(final String locale) {
            super(locale);
        }

        @Override
        protected BigInteger fromNumber(final Number number) {
            if (number instanceof BigInteger) {
                return new BigInteger(((BigInteger)number).toByteArray());
            } else if (number instanceof BigDecimal) {
                return ((BigDecimal)number).toBigInteger();
            } else if (number instanceof Double) {
                return BigDecimal.valueOf(number.doubleValue()).toBigInteger();
            } else if (number instanceof Float) {
                return BigDecimal.valueOf(number.doubleValue()).toBigInteger();
            }
            return BigInteger.valueOf(number.longValue());
        }

        @Override
        protected BigInteger fromString(final String string, final int radix) {
            // It's directly converted into Long instead of creating a 
            //BigDecimal and removing the decimal part -if present. This
            //way, a decimal string is not valid
            return new BigInteger(string, radix);
        }

    }
    
    
    
    static final class ToLong extends ToNonDecimalNumber<Long> {
        
        final static Long min = Long.valueOf(Long.MIN_VALUE);   
        final static Long max = Long.valueOf(Long.MAX_VALUE);
        
        
        public ToLong() {
            super();
        }

        public ToLong(final DecimalPoint decimalPoint) {
            super(decimalPoint);
        }

        public ToLong(final Integer radix) {
            super(radix);
        }

        public ToLong(final Locale locale) {
            super(locale);
        }

        public ToLong(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
            super(roundingMode, decimalPoint);
        }

        public ToLong(final RoundingMode roundingMode, final Locale locale) {
            super(roundingMode, locale);
        }

        public ToLong(final RoundingMode roundingMode, final String locale) {
            super(roundingMode, locale);
        }

        public ToLong(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public ToLong(final String locale) {
            super(locale);
        }

        @Override
        protected Long fromNumber(final Number number) {
            Validate.isTrue(number instanceof BigDecimal || number instanceof BigInteger, 
                    "The param number should be either a BigDecimal or BigInteger");
            
            if (number instanceof BigDecimal || number instanceof BigInteger) {
                BigInteger numberAsBigInteger = null;
                if (number instanceof BigDecimal) {
                    numberAsBigInteger = ((BigDecimal) number).toBigInteger();                    
                } else {
                    numberAsBigInteger = (BigInteger) number;
                }
                if (numberAsBigInteger.compareTo(BigInteger.valueOf(min.longValue())) < 0 
                        || numberAsBigInteger.compareTo(BigInteger.valueOf(max.longValue())) > 0) {
                    throw new ExecutionException("The number to be converted into Long is either lower than " + min
                            + " or greater than " + max);
                }
            } 
            
            return Long.valueOf(number.longValue());
        }

        @Override
        protected Long fromString(final String string, final int radix) {
            // It's directly converted into Long instead of creating a 
            //BigDecimal and removing the decimal part -if present. This
            //way, a decimal string is not valid
            return Long.valueOf(string, radix);
        }

    }
    
    
    
    static final class ToInteger extends ToNonDecimalNumber<Integer> {
        
        final static Integer min = Integer.valueOf(Integer.MIN_VALUE);   
        final static Integer max = Integer.valueOf(Integer.MAX_VALUE);
                
        public ToInteger() {
            super();
        }

        public ToInteger(final DecimalPoint decimalPoint) {
            super(decimalPoint);
        }

        public ToInteger(final Integer radix) {
            super(radix);
        }

        public ToInteger(final Locale locale) {
            super(locale);
        }

        public ToInteger(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
            super(roundingMode, decimalPoint);
        }

        public ToInteger(final RoundingMode roundingMode, final Locale locale) {
            super(roundingMode, locale);
        }

        public ToInteger(final RoundingMode roundingMode, final String locale) {
            super(roundingMode, locale);
        }

        public ToInteger(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public ToInteger(final String locale) {
            super(locale);
        }

        @Override
        protected Integer fromNumber(final Number number) {
            Validate.isTrue(number instanceof BigDecimal || number instanceof BigInteger, 
                "The param number should be either a BigDecimal or BigInteger");
    
            if (number instanceof BigDecimal || number instanceof BigInteger) {
                BigInteger numberAsBigInteger = null;
                if (number instanceof BigDecimal) {
                    numberAsBigInteger = ((BigDecimal) number).toBigInteger();                    
                } else {
                    numberAsBigInteger = (BigInteger) number;
                }
                if (numberAsBigInteger.compareTo(BigInteger.valueOf(min.intValue())) < 0 
                        || numberAsBigInteger.compareTo(BigInteger.valueOf(max.intValue())) > 0) {
                    throw new ExecutionException("The number to be converted into Integer is either lower than " + min
                            + " or greater than " + max);
                }
            } 
            
            return Integer.valueOf(number.intValue());
        }

        @Override
        protected Integer fromString(final String string, final int radix) {
            // It's directly converted into Long instead of creating a 
            //BigDecimal and removing the decimal part -if present. This
            //way, a decimal string is not valid
            return Integer.valueOf(string, radix);
        }

    }
    
    
    
    static final class ToShort extends ToNonDecimalNumber<Short> {
        
        final static Short min = Short.valueOf(Short.MIN_VALUE);   
        final static Short max = Short.valueOf(Short.MAX_VALUE);
        
        public ToShort() {
            super();
        }

        public ToShort(final DecimalPoint decimalPoint) {
            super(decimalPoint);
        }

        public ToShort(final Integer radix) {
            super(radix);
        }

        public ToShort(final Locale locale) {
            super(locale);
        }

        public ToShort(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
            super(roundingMode, decimalPoint);
        }

        public ToShort(final RoundingMode roundingMode, final Locale locale) {
            super(roundingMode, locale);
        }

        public ToShort(final RoundingMode roundingMode, final String locale) {
            super(roundingMode, locale);
        }

        public ToShort(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public ToShort(final String locale) {
            super(locale);
        }

        @Override
        protected Short fromNumber(final Number number) {
            Validate.isTrue(number instanceof BigDecimal || number instanceof BigInteger, 
                "The param number should be either a BigDecimal or BigInteger");
    
            if (number instanceof BigDecimal || number instanceof BigInteger) {
                BigInteger numberAsBigInteger = null;
                if (number instanceof BigDecimal) {
                    numberAsBigInteger = ((BigDecimal) number).toBigInteger();                    
                } else {
                    numberAsBigInteger = (BigInteger) number;
                }
                if (numberAsBigInteger.compareTo(BigInteger.valueOf(min.intValue())) < 0 
                        || numberAsBigInteger.compareTo(BigInteger.valueOf(max.intValue())) > 0) {
                    throw new ExecutionException("The number to be converted into Short is either lower than " + min
                            + " or greater than " + max);
                }
            } 
            
            return Short.valueOf(number.shortValue());
        }

        @Override
        protected Short fromString(final String string, final int radix) {
            // It's directly converted into Long instead of creating a 
            //BigDecimal and removing the decimal part -if present. This
            //way, a decimal string is not valid
            return Short.valueOf(string, radix);
        }

    }
    
    
    
    static final class ToByte extends ToNonDecimalNumber<Byte> {
        
        final static Byte min = Byte.valueOf(Byte.MIN_VALUE);   
        final static Byte max = Byte.valueOf(Byte.MAX_VALUE);
        
        public ToByte() {
            super();
        }

        public ToByte(final DecimalPoint decimalPoint) {
            super(decimalPoint);
        }

        public ToByte(final Integer radix) {
            super(radix);
        }

        public ToByte(final Locale locale) {
            super(locale);
        }

        public ToByte(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
            super(roundingMode, decimalPoint);
        }

        public ToByte(final RoundingMode roundingMode, final Locale locale) {
            super(roundingMode, locale);
        }

        public ToByte(final RoundingMode roundingMode, final String locale) {
            super(roundingMode, locale);
        }

        public ToByte(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public ToByte(final String locale) {
            super(locale);
        }

        @Override
        protected Byte fromNumber(final Number number) {
            Validate.isTrue(number instanceof BigDecimal || number instanceof BigInteger, 
                "The param number should be either a BigDecimal or BigInteger");
    
            if (number instanceof BigDecimal || number instanceof BigInteger) {
                BigInteger numberAsBigInteger = null;
                if (number instanceof BigDecimal) {
                    numberAsBigInteger = ((BigDecimal) number).toBigInteger();                    
                } else {
                    numberAsBigInteger = (BigInteger) number;
                }
                if (numberAsBigInteger.compareTo(BigInteger.valueOf(min.intValue())) < 0 
                        || numberAsBigInteger.compareTo(BigInteger.valueOf(max.intValue())) > 0) {
                    throw new ExecutionException("The number to be converted into Byte is either lower than " + min
                            + " or greater than " + max);
                }
            } 
            
            return Byte.valueOf(number.byteValue());
        }

        @Override
        protected Byte fromString(final String string, final int radix) {
            // It's directly converted into Long instead of creating a 
            //BigDecimal and removing the decimal part -if present. This
            //way, a decimal string is not valid
            return Byte.valueOf(string, radix);
        }

    }


	
	
}
