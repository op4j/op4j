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

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.executables.functions.IFunc;
import org.op4j.executables.functions.conversion.ToString.FromNumber.NumberFormatType;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class ToString {

	private static final FromObject FROM_OBJECT = new FromObject();

	private ToString() {
		super();
	}
	
	
	public static final FromObject fromObject() {
		return FROM_OBJECT;
	}
	
	public static final FromCalendar fromCalendar(final String pattern) {
		return new FromCalendar(pattern);
	}
	
	public static final FromCalendar fromCalendar(final String pattern, final Locale locale) {
		return new FromCalendar(pattern, locale);
	}
	
	public static final FromCalendar fromCalendar(final String pattern, final String locale) {
		return new FromCalendar(pattern, locale);
	}
	
	public static final FromCalendar fromCalendar(final DateStyle dateStyle, final TimeStyle timeStyle) {
		return new FromCalendar(dateStyle, timeStyle);
	}
	
	public static final FromCalendar fromCalendar(final DateStyle dateStyle, final TimeStyle timeStyle, final Locale locale) {
		return new FromCalendar(dateStyle, timeStyle, locale);
	}
	
	public static final FromCalendar fromCalendar(final DateStyle dateStyle, final TimeStyle timeStyle, final String locale) {
		return new FromCalendar(dateStyle, timeStyle, locale);
	}
	
	public static final FromDate fromDate(final String pattern) {
		return new FromDate(pattern);
	}
	
	public static final FromDate fromDate(final String pattern, final Locale locale) {
		return new FromDate(pattern, locale);
	}
	
	public static final FromDate fromDate(final String pattern, final String locale) {
		return new FromDate(pattern, locale);
	}
	
	public static final FromDate fromDate(final DateStyle dateStyle, final TimeStyle timeStyle) {
		return new FromDate(dateStyle, timeStyle);
	}
	
	public static final FromDate fromDate(final DateStyle dateStyle, final TimeStyle timeStyle, final Locale locale) {
		return new FromDate(dateStyle, timeStyle, locale);
	}
	
	public static final FromDate fromDate(final DateStyle dateStyle, final TimeStyle timeStyle, final String locale) {
		return new FromDate(dateStyle, timeStyle, locale);
	}
	
	public static final FromNumber fromNumber() {
		return new FromNumber();
	}	
	public static final FromNumber fromNumber(boolean groupingUsed) {
		return new FromNumber(Boolean.valueOf(groupingUsed));
	}
	public static final FromNumber fromNumber(Locale locale) {
		return new FromNumber(locale);
	}
	public static final FromNumber fromNumber(String locale) {
		return new FromNumber(locale);
	}
	public static final FromNumber fromNumber(Locale locale, boolean groupingUsed) {
		return new FromNumber(locale, Boolean.valueOf(groupingUsed));
	}
	
	public static final FromNumber fromNumber(String locale, boolean groupingUsed) {
		return new FromNumber(locale, Boolean.valueOf(groupingUsed));
	}
	public static final FromNumber fromNumber(Locale locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
		return new FromNumber(NumberFormatType.NUMBER, locale, 
				Integer.valueOf(minIntegerDigits), Integer.valueOf(Integer.MAX_VALUE), 
				Integer.valueOf(minFractionDigits), Integer.valueOf(maxFractionDigits),
				Boolean.valueOf(groupingUsed));
	}
	public static final FromNumber fromNumber(String locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
		return new FromNumber(NumberFormatType.NUMBER, locale, 
				Integer.valueOf(minIntegerDigits), Integer.valueOf(Integer.MAX_VALUE), 
				Integer.valueOf(minFractionDigits), Integer.valueOf(maxFractionDigits),
				Boolean.valueOf(groupingUsed));
	}
	public static final FromNumber fromNumber(Locale locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
			char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
		return new FromNumber(NumberFormatType.NUMBER, locale, 
				Integer.valueOf(minIntegerDigits), Integer.valueOf(Integer.MAX_VALUE), 
				Integer.valueOf(minFractionDigits), Integer.valueOf(maxFractionDigits),
				Boolean.valueOf(groupingUsed), Character.valueOf(groupingSeparator), Character.valueOf(decimalSeparator), 
				Boolean.valueOf(decimalSeparatorAlwaysShown));
	}
	public static final FromNumber fromNumber(String locale, int minIntegerDigits, 
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
			char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
		return new FromNumber(NumberFormatType.NUMBER, locale, 
				Integer.valueOf(minIntegerDigits), Integer.valueOf(Integer.MAX_VALUE), 
				Integer.valueOf(minFractionDigits), Integer.valueOf(maxFractionDigits), 
				Boolean.valueOf(groupingUsed), Character.valueOf(groupingSeparator), Character.valueOf(decimalSeparator), 
				Boolean.valueOf(decimalSeparatorAlwaysShown));
	}
	
	
	
	public static final FromNumber fromCurrency() {
		return new FromNumber(NumberFormatType.CURRENCY, null, null, null, null, null);
	}
	public static final FromNumber fromCurrency(boolean groupingUsed) {
		return new FromNumber(NumberFormatType.CURRENCY, null, null, null, null, Boolean.valueOf(groupingUsed));
	}
	public static final FromNumber fromCurrency(Locale locale) {
		return new FromNumber(NumberFormatType.CURRENCY, locale, null, null, null, null, null);
	}
	public static final FromNumber fromCurrency(String locale) {
		return new FromNumber(NumberFormatType.CURRENCY, locale, null, null, null, null, null);
	}
	public static final FromNumber fromCurrency(Locale locale, boolean groupingUsed) {
		return new FromNumber(NumberFormatType.CURRENCY, locale, null, null, null, null, Boolean.valueOf(groupingUsed));
	}
	public static final FromNumber fromCurrency(String locale, boolean groupingUsed) {
		return new FromNumber(NumberFormatType.CURRENCY, locale, null, null, null, null, Boolean.valueOf(groupingUsed));
	}
	public static final FromNumber fromCurrency(Locale locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
		return new FromNumber(NumberFormatType.CURRENCY, locale, 
				Integer.valueOf(minIntegerDigits), Integer.valueOf(Integer.MAX_VALUE), 
				Integer.valueOf(minFractionDigits), Integer.valueOf(maxFractionDigits),
				Boolean.valueOf(groupingUsed));
	}
	public static final FromNumber fromCurrency(String locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
		return new FromNumber(NumberFormatType.CURRENCY, locale, 
				Integer.valueOf(minIntegerDigits), Integer.valueOf(Integer.MAX_VALUE), 
				Integer.valueOf(minFractionDigits), Integer.valueOf(maxFractionDigits),
				Boolean.valueOf(groupingUsed));
	}
	public static final FromNumber fromCurrency(Locale locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
			char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
		return new FromNumber(NumberFormatType.CURRENCY, locale, 
				Integer.valueOf(minIntegerDigits), Integer.valueOf(Integer.MAX_VALUE), 
				Integer.valueOf(minFractionDigits), Integer.valueOf(maxFractionDigits),
				Boolean.valueOf(groupingUsed), Character.valueOf(groupingSeparator), Character.valueOf(decimalSeparator), 
				Boolean.valueOf(decimalSeparatorAlwaysShown));
	}
	public static final FromNumber fromCurrency(String locale, int minIntegerDigits, 
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
			char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
		return new FromNumber(NumberFormatType.CURRENCY, locale, 
				Integer.valueOf(minIntegerDigits), Integer.valueOf(Integer.MAX_VALUE), 
				Integer.valueOf(minFractionDigits), Integer.valueOf(maxFractionDigits), 
				Boolean.valueOf(groupingUsed), Character.valueOf(groupingSeparator), Character.valueOf(decimalSeparator), 
				Boolean.valueOf(decimalSeparatorAlwaysShown));
	}
	
	
	
	public static final FromNumber fromPercent() {
		return new FromNumber(NumberFormatType.PERCENT, null, null, null, null, null);
	}
	public static final FromNumber fromPercent(boolean groupingUsed) {
		return new FromNumber(NumberFormatType.PERCENT, null, null, null, null, Boolean.valueOf(groupingUsed));
	}
	public static final FromNumber fromPercent(Locale locale) {
		return new FromNumber(NumberFormatType.PERCENT, locale, null, null, null, null, null);
	}
	public static final FromNumber fromPercent(String locale) {
		return new FromNumber(NumberFormatType.PERCENT, locale, null, null, null, null, null);
	}
	public static final FromNumber fromPercent(Locale locale, boolean groupingUsed) {
		return new FromNumber(NumberFormatType.PERCENT, locale, null, null, null, null, Boolean.valueOf(groupingUsed));
	}
	
	public static final FromNumber fromPercent(String locale, boolean groupingUsed) {
		return new FromNumber(NumberFormatType.PERCENT, locale, null, null, null, null, Boolean.valueOf(groupingUsed));
	}
	public static final FromNumber fromPercent(Locale locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
		return new FromNumber(NumberFormatType.PERCENT, locale, 
				Integer.valueOf(minIntegerDigits), Integer.valueOf(Integer.MAX_VALUE), 
				Integer.valueOf(minFractionDigits), Integer.valueOf(maxFractionDigits),
				Boolean.valueOf(groupingUsed));
	}
	public static final FromNumber fromPercent(String locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
		return new FromNumber(NumberFormatType.PERCENT, locale, 
				Integer.valueOf(minIntegerDigits), Integer.valueOf(Integer.MAX_VALUE), 
				Integer.valueOf(minFractionDigits), Integer.valueOf(maxFractionDigits),
				Boolean.valueOf(groupingUsed));
	}
	public static final FromNumber fromPercent(Locale locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
			char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
		return new FromNumber(NumberFormatType.PERCENT, locale, 
				Integer.valueOf(minIntegerDigits), Integer.valueOf(Integer.MAX_VALUE), 
				Integer.valueOf(minFractionDigits), Integer.valueOf(maxFractionDigits),
				Boolean.valueOf(groupingUsed), Character.valueOf(groupingSeparator), Character.valueOf(decimalSeparator), 
				Boolean.valueOf(decimalSeparatorAlwaysShown));
	}
	public static final FromNumber fromPercent(String locale, int minIntegerDigits, 
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
			char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
		return new FromNumber(NumberFormatType.PERCENT, locale, 
				Integer.valueOf(minIntegerDigits), Integer.valueOf(Integer.MAX_VALUE), 
				Integer.valueOf(minFractionDigits), Integer.valueOf(maxFractionDigits), 
				Boolean.valueOf(groupingUsed), Character.valueOf(groupingSeparator), Character.valueOf(decimalSeparator), 
				Boolean.valueOf(decimalSeparatorAlwaysShown));
	}
	
	
	
	public static final class FromObject implements IFunc<String,Object> {

		public FromObject() {
			super();
		}
		
		public Type<? super String> getResultType() {
			return Types.STRING;
		}

		public String execute(final Object object) throws Exception {
			return object.toString();
		}
		
	}
	
	public static final class FromNumber implements IFunc<String, Number> {

		private Locale locale = null;
		private NumberFormatType numberFormatType = NumberFormatType.NUMBER;
		private Integer minIntegerDigits = null;
		private Integer maxIntegerDigits = null;
		private Integer minFractionDigits = null;
		private Integer maxFractionDigits = null;
		private Boolean groupingUsed = null;
		private Character groupingSeparator = null;
		private Character decimalSeparator = null;
		private Boolean decimalSeparatorAlwaysShown = null;
		
		public FromNumber() {
			super();				
		}
		
		public FromNumber(Boolean groupingUsed) {
			super();	
			this.groupingUsed = groupingUsed;
		}
		
		public FromNumber(Locale locale) {
			super();
			this.locale = locale;			
		}
		
		public FromNumber(Locale locale, Boolean groupingUsed) {
			super();
			this.locale = locale;	
			this.groupingUsed = groupingUsed;
		}
		
		public FromNumber(String locale) {
			super();
			this.locale = LocaleUtils.toLocale(locale);			
		}
		
		public FromNumber(String locale, Boolean groupingUsed) {
			super();
			this.locale = LocaleUtils.toLocale(locale);	
			this.groupingUsed = groupingUsed;
		}
		
		public FromNumber(NumberFormatType numberFormatType, Integer minIntegerDigits, Integer maxIntegerDigits,
				Integer minFractionDigits, Integer maxFractionDigits, Boolean groupingUsed) {
			super();
			this.numberFormatType = numberFormatType;	
			this.minIntegerDigits = minIntegerDigits;
			this.maxIntegerDigits = maxIntegerDigits;
			this.minFractionDigits = minFractionDigits;
			this.maxFractionDigits = maxFractionDigits;
			this.groupingUsed = groupingUsed;
		}
		
		public FromNumber(NumberFormatType numberFormatType, Integer minIntegerDigits, Integer maxIntegerDigits,
				Integer minFractionDigits, Integer maxFractionDigits, Boolean groupingUsed,
				Character groupingSeparator, Character decimalSeparator, Boolean decimalSeparatorAlwaysShown) {
			super();
			this.numberFormatType = numberFormatType;	
			this.minIntegerDigits = minIntegerDigits;
			this.maxIntegerDigits = maxIntegerDigits;
			this.minFractionDigits = minFractionDigits;
			this.maxFractionDigits = maxFractionDigits;
			this.groupingUsed = groupingUsed;
			this.groupingSeparator = groupingSeparator;
			this.decimalSeparator = decimalSeparator;
			this.decimalSeparatorAlwaysShown = decimalSeparatorAlwaysShown;
		}
		
		public FromNumber(NumberFormatType numberFormatType, Locale locale, Integer minIntegerDigits, Integer maxIntegerDigits,
				Integer minFractionDigits, Integer maxFractionDigits, Boolean groupingUsed) {
			super();
			this.numberFormatType = numberFormatType;
			this.locale = locale;
			this.numberFormatType = numberFormatType;	
			this.minIntegerDigits = minIntegerDigits;
			this.maxIntegerDigits = maxIntegerDigits;
			this.minFractionDigits = minFractionDigits;
			this.maxFractionDigits = maxFractionDigits;
			this.groupingUsed = groupingUsed;
		}
		
		public FromNumber(NumberFormatType numberFormatType, Locale locale, Integer minIntegerDigits, Integer maxIntegerDigits,
				Integer minFractionDigits, Integer maxFractionDigits, Boolean groupingUsed,
				Character groupingSeparator, Character decimalSeparator, Boolean decimalSeparatorAlwaysShown) {
			super();
			this.numberFormatType = numberFormatType;
			this.locale = locale;
			this.numberFormatType = numberFormatType;	
			this.minIntegerDigits = minIntegerDigits;
			this.maxIntegerDigits = maxIntegerDigits;
			this.minFractionDigits = minFractionDigits;
			this.maxFractionDigits = maxFractionDigits;
			this.groupingUsed = groupingUsed;
			this.groupingSeparator = groupingSeparator;
			this.decimalSeparator = decimalSeparator;
			this.decimalSeparatorAlwaysShown = decimalSeparatorAlwaysShown;
		}
		
		public FromNumber(NumberFormatType numberFormatType, String locale, Integer minIntegerDigits, Integer maxIntegerDigits,
				Integer minFractionDigits, Integer maxFractionDigits, Boolean groupingUsed) {
			super();
			this.numberFormatType = numberFormatType;
			this.locale = LocaleUtils.toLocale(locale);
			this.numberFormatType = numberFormatType;	
			this.minIntegerDigits = minIntegerDigits;
			this.maxIntegerDigits = maxIntegerDigits;
			this.minFractionDigits = minFractionDigits;
			this.maxFractionDigits = maxFractionDigits;
			this.groupingUsed = groupingUsed;
		}
			
		public FromNumber(NumberFormatType numberFormatType, String locale, Integer minIntegerDigits, Integer maxIntegerDigits,
				Integer minFractionDigits, Integer maxFractionDigits, Boolean groupingUsed,
				Character groupingSeparator, Character decimalSeparator, Boolean decimalSeparatorAlwaysShown) {
			super();
			this.numberFormatType = numberFormatType;
			this.locale = LocaleUtils.toLocale(locale);
			this.numberFormatType = numberFormatType;	
			this.minIntegerDigits = minIntegerDigits;
			this.maxIntegerDigits = maxIntegerDigits;
			this.minFractionDigits = minFractionDigits;
			this.maxFractionDigits = maxFractionDigits;
			this.groupingUsed = groupingUsed;
			this.groupingSeparator = groupingSeparator;
			this.decimalSeparator = decimalSeparator;
			this.decimalSeparatorAlwaysShown = decimalSeparatorAlwaysShown;
		}
		
		public Type<? super String> getResultType() {
			return Types.STRING;
		}

		public String execute(final Number number) throws Exception {
			return fromNumber(number);						
		}
		
		private String fromNumber(final Number number) {
	    	
			NumberFormat nf = null;
			switch (this.numberFormatType) {
				case CURRENCY :
					nf = NumberFormat.getCurrencyInstance((this.locale != null) ? this.locale : Locale.getDefault());
					break;
				case PERCENT :
					nf = NumberFormat.getPercentInstance((this.locale != null) ? this.locale : Locale.getDefault());
					break;
				case NUMBER :
					nf = NumberFormat.getNumberInstance((this.locale != null) ? this.locale : Locale.getDefault());
					break;
				default :
					nf = NumberFormat.getNumberInstance((this.locale != null) ? this.locale : Locale.getDefault());					
			}
			if (nf instanceof DecimalFormat) {
				DecimalFormat asDecimalFormat = (DecimalFormat) nf;
				// It returns a clone of decimalFormatSymbols
				DecimalFormatSymbols decimalFormatSymbols = asDecimalFormat.getDecimalFormatSymbols();
				if (this.groupingSeparator != null) {
					decimalFormatSymbols.setGroupingSeparator(this.groupingSeparator.charValue());	
				}
				if (this.decimalSeparator != null) {
					decimalFormatSymbols.setDecimalSeparator(this.decimalSeparator.charValue());	
				}
				if (this.decimalSeparatorAlwaysShown != null) {
					asDecimalFormat.setDecimalSeparatorAlwaysShown(this.decimalSeparatorAlwaysShown.booleanValue());
				}
				// Update decimalFormatSymbols
				asDecimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
			}
			if (this.minIntegerDigits != null) {
				nf.setMinimumIntegerDigits(this.minIntegerDigits.intValue());
			}
			if (this.maxIntegerDigits != null) {
				nf.setMaximumIntegerDigits(this.maxIntegerDigits.intValue());
			}
			if (this.minFractionDigits != null) {
				nf.setMinimumFractionDigits(this.minFractionDigits.intValue());
			}
			if (this.maxFractionDigits != null) {
				nf.setMaximumFractionDigits(this.maxFractionDigits.intValue());
			}
			if (this.groupingUsed != null) {
				nf.setGroupingUsed(this.groupingUsed.booleanValue());
			}
	    	return nf.format(number);
	    }		
		
		public static enum NumberFormatType {
			CURRENCY,
			NUMBER,
			PERCENT			
		}
	}
	
	public static enum DateStyle {
		SHORT {
			@Override
			public String toString() {
				return String.valueOf(DateFormat.SHORT);
			}				
		},
		MEDIUM {
			@Override
			public String toString() {
				return String.valueOf(DateFormat.MEDIUM);
			}				
		},
		LONG {
			@Override
			public String toString() {
				return String.valueOf(DateFormat.LONG);
			}				
		},
		FULL {
			@Override
			public String toString() {
				return String.valueOf(DateFormat.FULL);
			}				
		},
		NONE
	}
	
	public static enum TimeStyle {
		SHORT {
			@Override
			public String toString() {
				return String.valueOf(DateFormat.SHORT);
			}				
		},
		MEDIUM {
			@Override
			public String toString() {
				return String.valueOf(DateFormat.MEDIUM);
			}				
		},
		LONG {
			@Override
			public String toString() {
				return String.valueOf(DateFormat.LONG);
			}				
		},
		FULL {
			@Override
			public String toString() {
				return String.valueOf(DateFormat.FULL);
			}				
		},
		NONE
	}		
	
	public static final class FromCalendar implements IFunc<String, Calendar> {

		private DateStyle dateStyle = null;	
		private TimeStyle timeStyle = null;	
		private Locale locale = null;
		private String pattern = null;
		
		public FromCalendar(String pattern) {
			super();
			this.pattern = pattern;
		}
		
		public FromCalendar(String pattern, Locale locale) {
			super();
			this.pattern = pattern;
			this.locale = locale;			
		}
		
		public FromCalendar(String pattern, String locale) {
			super();
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
		}
				
		public FromCalendar(DateStyle dateStyle, TimeStyle timeStyle) {
			super();
			this.dateStyle = dateStyle;
			this.timeStyle = timeStyle;
		}
		
		public FromCalendar(DateStyle dateStyle, TimeStyle timeStyle, Locale locale) {
			super();
			this.dateStyle = dateStyle;
			this.timeStyle = timeStyle;
			this.locale = locale;
		}
		
		public FromCalendar(DateStyle dateStyle, TimeStyle timeStyle, String locale) {
			super();
			this.dateStyle = dateStyle;
			this.timeStyle = timeStyle;
			this.locale = LocaleUtils.toLocale(locale);
		}
						
		public Type<? super String> getResultType() {
			return Types.STRING;
		}

		public String execute(final Calendar calendar) throws Exception {
			if (StringUtils.isNotEmpty(this.pattern)) {
				return fromCalendar(calendar, this.pattern, this.locale);
			} 
			return fromCalendar(calendar, this.dateStyle, this.timeStyle, this.locale);						
		}
		
		private String fromCalendar(final Calendar calendar, final String thePattern, final Locale theLocale) {
	    	
			Validate.isTrue((StringUtils.isNotEmpty(thePattern))
					|| (theLocale != null && thePattern != null),
	    			"Either pattern or locale and pattern must be set");
	    	
	    	DateFormat sdf = new SimpleDateFormat(thePattern, 
	    			(theLocale == null) ? Locale.getDefault() : theLocale);	    		
	    		    	
	    	return sdf.format(calendar.getTime());
	    }		
		
		@SuppressWarnings("null")
		private String fromCalendar(final Calendar calendar, final DateStyle theDateStyle,
				final TimeStyle theTimeStyle, final Locale theLocale) {
	    	
	    	Validate.isTrue((theDateStyle != null && theTimeStyle != null)
	    			&& (DateStyle.NONE.compareTo(theDateStyle) != 0
	    					|| TimeStyle.NONE.compareTo(theTimeStyle) != 0),
	    			"At least one of dateStyle and timeStyle must have a value different from NONE");
	    	
	    	DateFormat sdf = null;
	    	if (DateStyle.NONE.compareTo(theDateStyle) != 0 && (TimeStyle.NONE.compareTo(theTimeStyle) != 0)) {
	    		sdf = DateFormat.getDateTimeInstance(Integer.parseInt(theDateStyle.toString()), 
	    				Integer.parseInt(theTimeStyle.toString()),
	    				(theLocale == null) ? Locale.getDefault() : theLocale);
	    	} else if (DateStyle.NONE.compareTo(theDateStyle) != 0) {
	    		sdf = DateFormat.getDateInstance(Integer.parseInt(theDateStyle.toString()),
	    				(theLocale == null) ? Locale.getDefault() : theLocale);
	    	} else {
	    		sdf = DateFormat.getTimeInstance(Integer.parseInt(theTimeStyle.toString()),
	    				(theLocale == null) ? Locale.getDefault() : theLocale);
	    	}	      		
	    	
	    	return sdf.format(calendar.getTime());
	    }		
	}
	
	public static final class FromDate implements IFunc<String, java.util.Date> {

		private DateStyle dateStyle = null;	
		private TimeStyle timeStyle = null;	
		private Locale locale = null;
		private String pattern = null;
		
		public FromDate(String pattern) {
			super();
			this.pattern = pattern;
		}
		
		public FromDate(String pattern, Locale locale) {
			super();
			this.pattern = pattern;
			this.locale = locale;			
		}
		
		public FromDate(String pattern, String locale) {
			super();
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
		}
				
		public FromDate(DateStyle dateStyle, TimeStyle timeStyle) {
			super();
			this.dateStyle = dateStyle;
			this.timeStyle = timeStyle;
		}
		
		public FromDate(DateStyle dateStyle, TimeStyle timeStyle, Locale locale) {
			super();
			this.dateStyle = dateStyle;
			this.timeStyle = timeStyle;
			this.locale = locale;
		}
		
		public FromDate(DateStyle dateStyle, TimeStyle timeStyle, String locale) {
			super();
			this.dateStyle = dateStyle;
			this.timeStyle = timeStyle;
			this.locale = LocaleUtils.toLocale(locale);
		}
						
		public Type<? super String> getResultType() {
			return Types.STRING;
		}

		public String execute(final Date date) throws Exception {
			if (StringUtils.isNotEmpty(this.pattern)) {
				return fromDate(date, this.pattern, this.locale);
			} 
			return fromDate(date, this.dateStyle, this.timeStyle, this.locale);						
		}
		
		private String fromDate(final Date date, final String thePattern, final Locale theLocale) {
	    	
			Validate.isTrue((StringUtils.isNotEmpty(thePattern))
					|| (theLocale != null && thePattern != null),
	    			"Either pattern or locale and pattern must be set");
	    	
	    	DateFormat sdf = new SimpleDateFormat(thePattern, 
	    			(theLocale == null) ? Locale.getDefault() : theLocale);	    		
	    		    	
	    	return sdf.format(date);
	    }		
		
		@SuppressWarnings("null")
		private String fromDate(final Date date, final DateStyle theDateStyle,
				final TimeStyle theTimeStyle, final Locale theLocale) {
	    	
	    	Validate.isTrue((theDateStyle != null && theTimeStyle != null)
	    			&& (DateStyle.NONE.compareTo(theDateStyle) != 0
	    					|| TimeStyle.NONE.compareTo(theTimeStyle) != 0),
	    			"At least one of dateStyle and timeStyle must have a value different from NONE");
	    	
	    	DateFormat sdf = null;
	    	if (DateStyle.NONE.compareTo(theDateStyle) != 0 && (TimeStyle.NONE.compareTo(theTimeStyle) != 0)) {
	    		sdf = DateFormat.getDateTimeInstance(Integer.parseInt(theDateStyle.toString()), 
	    				Integer.parseInt(theTimeStyle.toString()),
	    				(theLocale == null) ? Locale.getDefault() : theLocale);
	    	} else if (DateStyle.NONE.compareTo(theDateStyle) != 0) {
	    		sdf = DateFormat.getDateInstance(Integer.parseInt(theDateStyle.toString()),
	    				(theLocale == null) ? Locale.getDefault() : theLocale);
	    	} else {
	    		sdf = DateFormat.getTimeInstance(Integer.parseInt(theTimeStyle.toString()),
	    				(theLocale == null) ? Locale.getDefault() : theLocale);
	    	}	      		
	    	
	    	return sdf.format(date);
	    }		
	}
}
