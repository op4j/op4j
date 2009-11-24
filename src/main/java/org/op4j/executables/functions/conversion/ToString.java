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
		return new FromNumber(groupingUsed);
	}
	public static final FromNumber fromNumber(Locale locale) {
		return new FromNumber(locale);
	}
	public static final FromNumber fromNumber(String locale) {
		return new FromNumber(locale);
	}
	public static final FromNumber fromNumber(Locale locale, boolean groupingUsed) {
		return new FromNumber(locale, groupingUsed);
	}	
	public static final FromNumber fromNumber(String locale, boolean groupingUsed) {
		return new FromNumber(locale, groupingUsed);
	}
	public static final FromNumber fromNumber(Locale locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
		return new FromNumber(NumberFormatType.NUMBER, locale, 
				minIntegerDigits, Integer.MAX_VALUE, 
				minFractionDigits, maxFractionDigits,
				groupingUsed);
	}
	public static final FromNumber fromNumber(String locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
		return new FromNumber(NumberFormatType.NUMBER, locale, 
				minIntegerDigits, Integer.MAX_VALUE, 
				minFractionDigits, maxFractionDigits,
				groupingUsed);
	}
	public static final FromNumber fromNumber(Locale locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, 
			char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
		return new FromNumber(NumberFormatType.NUMBER, locale, 
				minIntegerDigits, Integer.MAX_VALUE, 
				minFractionDigits, maxFractionDigits,
				true, groupingSeparator, decimalSeparator, 
				decimalSeparatorAlwaysShown);
	}
	public static final FromNumber fromNumber(Locale locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
			char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
		return new FromNumber(NumberFormatType.NUMBER, locale, 
				minIntegerDigits, Integer.MAX_VALUE, 
				minFractionDigits, maxFractionDigits,
				groupingUsed, decimalSeparator, 
				decimalSeparatorAlwaysShown);
	}
	public static final FromNumber fromNumber(String locale, int minIntegerDigits, 
			int minFractionDigits, int maxFractionDigits, 
			char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
		return new FromNumber(NumberFormatType.NUMBER, locale, 
				minIntegerDigits, Integer.MAX_VALUE, 
				minFractionDigits, maxFractionDigits, 
				true, groupingSeparator, decimalSeparator, 
				decimalSeparatorAlwaysShown);
	}
	public static final FromNumber fromNumber(String locale, int minIntegerDigits, 
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
			char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
		return new FromNumber(NumberFormatType.NUMBER, locale, 
				minIntegerDigits, Integer.MAX_VALUE, 
				minFractionDigits, maxFractionDigits, 
				groupingUsed, decimalSeparator, 
				decimalSeparatorAlwaysShown);
	}
	
	
	
	public static final FromNumber fromCurrency() {
		return new FromNumber(NumberFormatType.CURRENCY);
	}
	public static final FromNumber fromCurrency(boolean groupingUsed) {
		return new FromNumber(NumberFormatType.CURRENCY, groupingUsed);
	}
	public static final FromNumber fromCurrency(Locale locale) {
		return new FromNumber(NumberFormatType.CURRENCY, locale);
	}
	public static final FromNumber fromCurrency(String locale) {
		return new FromNumber(NumberFormatType.CURRENCY, locale);
	}
	public static final FromNumber fromCurrency(Locale locale, boolean groupingUsed) {
		return new FromNumber(NumberFormatType.CURRENCY, locale, groupingUsed);
	}
	public static final FromNumber fromCurrency(String locale, boolean groupingUsed) {
		return new FromNumber(NumberFormatType.CURRENCY, locale, groupingUsed);
	}
	public static final FromNumber fromCurrency(Locale locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
		return new FromNumber(NumberFormatType.CURRENCY, locale, 
				minIntegerDigits, Integer.MAX_VALUE, 
				minFractionDigits, maxFractionDigits,
				groupingUsed);
	}
	public static final FromNumber fromCurrency(String locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
		return new FromNumber(NumberFormatType.CURRENCY, locale, 
				minIntegerDigits, Integer.MAX_VALUE, 
				minFractionDigits, maxFractionDigits,
				groupingUsed);
	}
	public static final FromNumber fromCurrency(Locale locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, 
			char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
		return new FromNumber(NumberFormatType.CURRENCY, locale, 
				minIntegerDigits, Integer.MAX_VALUE, 
				minFractionDigits, maxFractionDigits,
				true, groupingSeparator, decimalSeparator, 
				decimalSeparatorAlwaysShown);
	}
	public static final FromNumber fromCurrency(Locale locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
			char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
		return new FromNumber(NumberFormatType.CURRENCY, locale, 
				minIntegerDigits, Integer.MAX_VALUE, 
				minFractionDigits, maxFractionDigits,
				groupingUsed, decimalSeparator, 
				decimalSeparatorAlwaysShown);
	}
	public static final FromNumber fromCurrency(String locale, int minIntegerDigits, 
			int minFractionDigits, int maxFractionDigits, 
			char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
		return new FromNumber(NumberFormatType.CURRENCY, locale, 
				minIntegerDigits, Integer.MAX_VALUE, 
				minFractionDigits, maxFractionDigits, 
				true, groupingSeparator, decimalSeparator, 
				decimalSeparatorAlwaysShown);
	}
	public static final FromNumber fromCurrency(String locale, int minIntegerDigits, 
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
			char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
		return new FromNumber(NumberFormatType.CURRENCY, locale, 
				minIntegerDigits, Integer.MAX_VALUE, 
				minFractionDigits, maxFractionDigits, 
				groupingUsed, decimalSeparator, 
				decimalSeparatorAlwaysShown);
	}
	
	
	
	public static final FromNumber fromPercent() {
		return new FromNumber(NumberFormatType.PERCENT);
	}
	public static final FromNumber fromPercent(boolean groupingUsed) {
		return new FromNumber(NumberFormatType.PERCENT, groupingUsed);
	}
	public static final FromNumber fromPercent(Locale locale) {
		return new FromNumber(NumberFormatType.PERCENT, locale);
	}
	public static final FromNumber fromPercent(String locale) {
		return new FromNumber(NumberFormatType.PERCENT, locale);
	}
	public static final FromNumber fromPercent(Locale locale, boolean groupingUsed) {
		return new FromNumber(NumberFormatType.PERCENT, locale, groupingUsed);
	}	
	public static final FromNumber fromPercent(String locale, boolean groupingUsed) {
		return new FromNumber(NumberFormatType.PERCENT, locale, groupingUsed);
	}
	public static final FromNumber fromPercent(Locale locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
		return new FromNumber(NumberFormatType.PERCENT, locale, 
				minIntegerDigits, Integer.MAX_VALUE, 
				minFractionDigits, maxFractionDigits,
				groupingUsed);
	}
	public static final FromNumber fromPercent(String locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
		return new FromNumber(NumberFormatType.PERCENT, locale, 
				minIntegerDigits, Integer.MAX_VALUE, 
				minFractionDigits, maxFractionDigits,
				groupingUsed);
	}
	public static final FromNumber fromPercent(Locale locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, 
			char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
		return new FromNumber(NumberFormatType.PERCENT, locale, 
				minIntegerDigits, Integer.MAX_VALUE, 
				minFractionDigits, maxFractionDigits,
				true, groupingSeparator, decimalSeparator, 
				decimalSeparatorAlwaysShown);
	}
	public static final FromNumber fromPercent(Locale locale, int minIntegerDigits,
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
			char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
		return new FromNumber(NumberFormatType.PERCENT, locale, 
				minIntegerDigits, Integer.MAX_VALUE, 
				minFractionDigits, maxFractionDigits,
				groupingUsed, decimalSeparator, 
				decimalSeparatorAlwaysShown);
	}
	public static final FromNumber fromPercent(String locale, int minIntegerDigits, 
			int minFractionDigits, int maxFractionDigits, 
			char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
		return new FromNumber(NumberFormatType.PERCENT, locale, 
				minIntegerDigits, Integer.MAX_VALUE, 
				minFractionDigits, maxFractionDigits, 
				true, groupingSeparator, decimalSeparator, 
				decimalSeparatorAlwaysShown);
	}
	public static final FromNumber fromPercent(String locale, int minIntegerDigits, 
			int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
			char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
		return new FromNumber(NumberFormatType.PERCENT, locale, 
				minIntegerDigits, Integer.MAX_VALUE, 
				minFractionDigits, maxFractionDigits, 
				groupingUsed, decimalSeparator, 
				decimalSeparatorAlwaysShown);
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

		private final NumberFormat numberFormat;
		
		public FromNumber() {
			super();
			this.numberFormat = getNumberFormat(NumberFormatType.NUMBER, null);
		}
		
		public FromNumber(NumberFormatType numberFormatType, boolean groupingUsed) {
			super();	
			this.numberFormat = getNumberFormat(numberFormatType, null);
			setGroupingUsed(groupingUsed);			
		}
		
		public FromNumber(boolean groupingUsed) {
			super();	
			this.numberFormat = getNumberFormat(NumberFormatType.NUMBER, null);
			setGroupingUsed(groupingUsed);
		}
		
		public FromNumber(Locale locale) {
			super();
			this.numberFormat = getNumberFormat(NumberFormatType.NUMBER, locale);
		}
		
		public FromNumber(NumberFormatType numberFormatType, Locale locale) {
			super();	
			this.numberFormat = getNumberFormat(numberFormatType, locale);
		}
		
		public FromNumber(NumberFormatType numberFormatType, String locale) {
			super();	
			this.numberFormat = getNumberFormat(numberFormatType, LocaleUtils.toLocale(locale));
		}
		
		public FromNumber(NumberFormatType numberFormatType, Locale locale, boolean groupingUsed) {
			super();	
			this.numberFormat = getNumberFormat(numberFormatType, locale);
			setGroupingUsed(groupingUsed);
		}
		
		public FromNumber(NumberFormatType numberFormatType, String locale, boolean groupingUsed) {
			super();	
			this.numberFormat = getNumberFormat(numberFormatType, LocaleUtils.toLocale(locale));
			setGroupingUsed(groupingUsed);
		}
		
		public FromNumber(Locale locale, boolean groupingUsed) {
			super();
			this.numberFormat = getNumberFormat(NumberFormatType.NUMBER, locale);
			setGroupingUsed(groupingUsed);
		}
		
		public FromNumber(String locale) {
			super();
			this.numberFormat = getNumberFormat(NumberFormatType.NUMBER, LocaleUtils.toLocale(locale));
		}
		
		public FromNumber(String locale, boolean groupingUsed) {
			super();
			this.numberFormat = getNumberFormat(NumberFormatType.NUMBER, LocaleUtils.toLocale(locale));
			setGroupingUsed(groupingUsed);
		}
		public FromNumber(NumberFormatType numberFormatType) {
			super();
			this.numberFormat = getNumberFormat(numberFormatType, null);
		}		
		
		public FromNumber(NumberFormatType numberFormatType, int minIntegerDigits, int maxIntegerDigits,
				int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
			super();
			this.numberFormat = getNumberFormat(numberFormatType, null);
			setMinAndMaxDigits(minIntegerDigits, maxIntegerDigits, minFractionDigits, maxFractionDigits);
			setGroupingUsed(groupingUsed);
		}
		
		public FromNumber(NumberFormatType numberFormatType, int minIntegerDigits, int maxIntegerDigits,
				int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
				char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
			super();
			this.numberFormat = getNumberFormat(numberFormatType, null);
			setMinAndMaxDigits(minIntegerDigits, maxIntegerDigits, minFractionDigits, maxFractionDigits);
			setGroupingUsed(groupingUsed);
			setGroupingSeparator(groupingSeparator);
			setDecimalSeparator(decimalSeparator, decimalSeparatorAlwaysShown);
		}
		
		public FromNumber(NumberFormatType numberFormatType, Locale locale, int minIntegerDigits, int maxIntegerDigits,
				int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
			super();
			this.numberFormat = getNumberFormat(numberFormatType, locale);
			setMinAndMaxDigits(minIntegerDigits, maxIntegerDigits, minFractionDigits, maxFractionDigits);
			setGroupingUsed(groupingUsed);
		}
		
		public FromNumber(NumberFormatType numberFormatType, Locale locale, int minIntegerDigits, int maxIntegerDigits,
				int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
				char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
			super();
			this.numberFormat = getNumberFormat(numberFormatType, locale);
			setMinAndMaxDigits(minIntegerDigits, maxIntegerDigits, minFractionDigits, maxFractionDigits);
			setGroupingUsed(groupingUsed);
			setDecimalSeparator(decimalSeparator, decimalSeparatorAlwaysShown);
		}
		
		public FromNumber(NumberFormatType numberFormatType, Locale locale, int minIntegerDigits, int maxIntegerDigits,
				int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
				char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
			super();
			this.numberFormat = getNumberFormat(numberFormatType, locale);
			setMinAndMaxDigits(minIntegerDigits, maxIntegerDigits, minFractionDigits, maxFractionDigits);
			setGroupingUsed(groupingUsed);
			setGroupingSeparator(groupingSeparator);
			setDecimalSeparator(decimalSeparator, decimalSeparatorAlwaysShown);
		}
		
		public FromNumber(NumberFormatType numberFormatType, String locale, int minIntegerDigits, int maxIntegerDigits,
				int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
			super();
			this.numberFormat = getNumberFormat(numberFormatType, LocaleUtils.toLocale(locale));
			setMinAndMaxDigits(minIntegerDigits, maxIntegerDigits, minFractionDigits, maxFractionDigits);
			setGroupingUsed(groupingUsed);			
		}
		
		public FromNumber(NumberFormatType numberFormatType, String locale, int minIntegerDigits, int maxIntegerDigits,
				int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
				char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
			super();
			this.numberFormat = getNumberFormat(numberFormatType, LocaleUtils.toLocale(locale));
			setMinAndMaxDigits(minIntegerDigits, maxIntegerDigits, minFractionDigits, maxFractionDigits);
			setGroupingUsed(groupingUsed);
			setDecimalSeparator(decimalSeparator, decimalSeparatorAlwaysShown);
		}
			
		public FromNumber(NumberFormatType numberFormatType, String locale, int minIntegerDigits, int maxIntegerDigits,
				int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
				char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
			super();
			this.numberFormat = getNumberFormat(numberFormatType, LocaleUtils.toLocale(locale));
			setMinAndMaxDigits(minIntegerDigits, maxIntegerDigits, minFractionDigits, maxFractionDigits);
			setGroupingUsed(groupingUsed);
			setGroupingSeparator(groupingSeparator);
			setDecimalSeparator(decimalSeparator, decimalSeparatorAlwaysShown);
		}
		
		public Type<? super String> getResultType() {
			return Types.STRING;
		}

		public String execute(final Number number) throws Exception {
			return fromNumber(number);						
		}
		
		private NumberFormat getNumberFormat(NumberFormatType numberFormatType, Locale locale) {
			NumberFormat nf = null;
			switch (numberFormatType) {
				case CURRENCY :
					nf = NumberFormat.getCurrencyInstance((locale != null) ? locale : Locale.getDefault());
					break;
				case PERCENT :
					nf = NumberFormat.getPercentInstance((locale != null) ? locale : Locale.getDefault());
					break;
				case NUMBER :
					nf = NumberFormat.getNumberInstance((locale != null) ? locale : Locale.getDefault());
					break;
				default :
					nf = NumberFormat.getNumberInstance((locale != null) ? locale : Locale.getDefault());					
			}
			return nf;
		}
		
		private void setMinAndMaxDigits(int minIntegerDigits, int maxIntegerDigits, 
				int minFractionDigits, int maxFractionDigits) {
			this.numberFormat.setMinimumIntegerDigits(minIntegerDigits);
			this.numberFormat.setMaximumIntegerDigits(maxIntegerDigits);
			this.numberFormat.setMinimumFractionDigits(minFractionDigits);
			this.numberFormat.setMaximumFractionDigits(maxFractionDigits);
		}
		
		private void setDecimalSeparator(char decimalSeparator, 
				boolean decimalSeparatorAlwaysShown) {
			if (this.numberFormat instanceof DecimalFormat) {
				DecimalFormat asDecimalFormat = (DecimalFormat) this.numberFormat;
				// It returns a clone of decimalFormatSymbols
				DecimalFormatSymbols decimalFormatSymbols = asDecimalFormat.getDecimalFormatSymbols();
				decimalFormatSymbols.setDecimalSeparator(decimalSeparator);	
				asDecimalFormat.setDecimalSeparatorAlwaysShown(decimalSeparatorAlwaysShown);
				// Update decimalFormatSymbols
				asDecimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
			}
		}
		
		private boolean setGroupingSeparator(char groupingSeparator) {
			if (this.numberFormat instanceof DecimalFormat) {
				DecimalFormat asDecimalFormat = (DecimalFormat) this.numberFormat;
				// It returns a clone of decimalFormatSymbols
				DecimalFormatSymbols decimalFormatSymbols = asDecimalFormat.getDecimalFormatSymbols();
				decimalFormatSymbols.setGroupingSeparator(groupingSeparator);	
				// Update decimalFormatSymbols
				asDecimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
				return true;
			}	
			return false;
		}
		
		private void setGroupingUsed(boolean groupingUsed) {
			this.numberFormat.setGroupingUsed(groupingUsed);
		}
		
		private String fromNumber(final Number number) {	
	    	return this.numberFormat.format(number);
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
