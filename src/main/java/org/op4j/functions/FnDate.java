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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.time.DateUtils;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class FnDate {


    
	private FnDate() {
		super();           
	}
	
	

	public static final IFunction<Date,Date> add(final int calendarField, final int amount) {
        return new Add(calendarField, amount);
    }
	
    public static final IFunction<Date,Date> addDays(final int amount) {
        return new Add(Calendar.DATE, amount);
    }
    
    public static final IFunction<Date,Date> addHours(final int amount) {
        return new Add(Calendar.HOUR, amount);
    }
    
    public static final IFunction<Date,Date> addMilliseconds(final int amount) {
        return new Add(Calendar.MILLISECOND, amount);
    }
    
    public static final IFunction<Date,Date> addMinutes(final int amount) {
        return new Add(Calendar.MINUTE, amount);
    }
    
    public static final IFunction<Date,Date> addMonths(final int amount) {
        return new Add(Calendar.MONTH, amount);
    }
    
    public static final IFunction<Date,Date> addWeeks(final int amount) {
        return new Add(Calendar.WEEK_OF_YEAR, amount);
    }
    
    public static final IFunction<Date,Date> addYears(final int amount) {
        return new Add(Calendar.YEAR, amount);
    }

    public static final IFunction<Date,Date> set(final int calendarField, final int value) {
        return new Set(calendarField, value);
    }
    
    public static final IFunction<Date,Date> setDay(final int value) {
        return new Set(Calendar.DATE, value);
    }
    
    public static final IFunction<Date,Date> setHour(final int value) {
        return new Set(Calendar.HOUR, value);
    }
    
    public static final IFunction<Date,Date> setMillisecond(final int value) {
        return new Set(Calendar.MILLISECOND, value);
    }
    
    public static final IFunction<Date,Date> setMinute(final int value) {
        return new Set(Calendar.MINUTE, value);
    }
    
    public static final IFunction<Date,Date> setMonth(final int value) {
        return new Set(Calendar.MONTH, value);
    }
    
    public static final IFunction<Date,Date> setWeek(final int value) {
        return new Set(Calendar.WEEK_OF_YEAR, value);
    }
    
    public static final IFunction<Date,Date> setYear(final int value) {
        return new Set(Calendar.YEAR, value);
    }

    public static final IFunction<Date,Date> round(final int calendarField) {
        return new Round(calendarField);
    }

    public static final IFunction<Date,Date> truncate(final int calendarField) {
        return new Truncate(calendarField);
    }

    public static final IFunction<Date,Boolean> before(final Date date) {
        return new Before(date);
    }

    public static final IFunction<Date,Boolean> after(final Date date) {
        return new After(date);
    }
    
    
    
    public static final IFunction<Date,String> toStr(final String pattern) {
        return new ToString(pattern);
    }
    
    public static final IFunction<Date,String> toStr(final String pattern, final Locale locale) {
        return new ToString(pattern, locale);
    }
    
    public static final IFunction<Date,String> toStr(final String pattern, final String locale) {
        return new ToString(pattern, locale);
    }
    
    public static final IFunction<Date,String> toStr(final DateStyle dateStyle, final TimeStyle timeStyle) {
        return new ToString(dateStyle, timeStyle);
    }
    
    public static final IFunction<Date,String> toStr(final DateStyle dateStyle, final TimeStyle timeStyle, final Locale locale) {
        return new ToString(dateStyle, timeStyle, locale);
    }
    
    public static final IFunction<Date,String> toStr(final DateStyle dateStyle, final TimeStyle timeStyle, final String locale) {
        return new ToString(dateStyle, timeStyle, locale);
    }
    

    
    
    
	

	
	static final class Add extends AbstractNotNullFunction<Date,Date> {

	    private final int calendarField;
	    private final int amount;
	    
		Add(final int calendarField, final int amount) {
			super();
			this.calendarField = calendarField;
			this.amount = amount;
		}

        @Override
        public Date notNullExecute(final Date input, final ExecCtx ctx) throws Exception {
            final Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(input.getTime());
			cal.add(this.calendarField, this.amount);
			return cal.getTime();
		}		
        
	}

    
    static final class Roll extends AbstractNotNullFunction<Date,Date> {

        private final int calendarField;
        private final int amount;
        
        Roll(final int calendarField, final int amount) {
            super();
            this.calendarField = calendarField;
            this.amount = amount;
        }

        @Override
        public Date notNullExecute(final Date input, final ExecCtx ctx) throws Exception {
            final Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(input.getTime());
            cal.roll(this.calendarField, this.amount);
            return cal.getTime();
        }       
        
    }

    
	
    static final class Set extends AbstractNotNullFunction<Date,Date> {

        private final int calendarField;
        private final int value;
        
        Set(final int calendarField, final int value) {
            super();
            this.calendarField = calendarField;
            this.value = value;
        }

        @Override
        public Date notNullExecute(final Date input, final ExecCtx ctx) throws Exception {
            final Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(input.getTime());
            cal.set(this.calendarField, this.value);
            return cal.getTime();
        }       
        
    }

	
    
    static final class Round extends AbstractNotNullFunction<Date,Date> {

        private final int calendarField;
        
        Round(final int calendarField) {
            super();
            this.calendarField = calendarField;
        }

        @Override
        public Date notNullExecute(final Date input, final ExecCtx ctx) throws Exception {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(input.getTime());
            cal = DateUtils.round(cal, this.calendarField);
            return cal.getTime();
        }       
        
    }

    
    
    static final class Truncate extends AbstractNotNullFunction<Date,Date> {

        private final int calendarField;
        
        Truncate(final int calendarField) {
            super();
            this.calendarField = calendarField;
        }

        @Override
        public Date notNullExecute(final Date input, final ExecCtx ctx) throws Exception {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(input.getTime());
            cal = DateUtils.truncate(cal, this.calendarField);
            return cal.getTime();
        }       
        
    }
    
    
    static final class Before extends AbstractNotNullFunction<Date,Boolean> {

        private final Date date;
        
        Before(final Date date) {
            super();
            Validate.notNull(date, "Specified calendar cannot be null");
            this.date = date;
        }

        @Override
        public Boolean notNullExecute(final Date input, final ExecCtx ctx) throws Exception {
            return Boolean.valueOf(input.before(this.date));
        }       
        
    }
    
    
    static final class After extends AbstractNotNullFunction<Date,Boolean> {

        private final Date date;
        
        After(final Date date) {
            super();
            Validate.notNull(date, "Specified calendar cannot be null");
            this.date = date;
        }

        @Override
        public Boolean notNullExecute(final Date input, final ExecCtx ctx) throws Exception {
            return Boolean.valueOf(input.after(this.date));
        }       
        
    }
    
    
    
    static final class ToString extends AbstractNullAsNullFunction<Date,String>  {

        private DateStyle dateStyle = null; 
        private TimeStyle timeStyle = null; 
        private Locale locale = null;
        private String pattern = null;
        
        ToString(String pattern) {
            super();
            
            Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
            
            this.pattern = pattern;
        }
        
        ToString(String pattern, Locale locale) {
            super();
            
            Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
            Validate.notNull(locale, "locale can't be null");
            
            this.pattern = pattern;
            this.locale = locale;           
        }
        
        ToString(String pattern, String locale) {
            super();
            
            Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
            Validate.notEmpty(locale, "locale can't be neither empty nor null");
            
            this.pattern = pattern;
            this.locale = LocaleUtils.toLocale(locale);
        }
                
        ToString(DateStyle dateStyle, TimeStyle timeStyle) {
            super();
            
            Validate.notNull(dateStyle, "dateStyle can't be null");
            Validate.notNull(timeStyle, "timeStyle can't be null");
            
            this.dateStyle = dateStyle;
            this.timeStyle = timeStyle;
        }
        
        ToString(DateStyle dateStyle, TimeStyle timeStyle, Locale locale) {
            super();
            
            Validate.notNull(dateStyle, "dateStyle can't be null");
            Validate.notNull(timeStyle, "timeStyle can't be null");
            Validate.notNull(locale, "locale can't be null");
            
            this.dateStyle = dateStyle;
            this.timeStyle = timeStyle;
            this.locale = locale;
        }
        
        ToString(DateStyle dateStyle, TimeStyle timeStyle, String locale) {
            super();
            
            Validate.notNull(dateStyle, "dateStyle can't be null");
            Validate.notNull(timeStyle, "timeStyle can't be null");
            Validate.notEmpty(locale, "locale can't be neither empty nor null");
            
            this.dateStyle = dateStyle;
            this.timeStyle = timeStyle;
            this.locale = LocaleUtils.toLocale(locale);
        }

        @Override
        protected String nullAsNullExecute(final Date date, final ExecCtx ctx) throws Exception {
            if (StringUtils.isNotEmpty(this.pattern)) {
                return fromDate(date, this.pattern, this.locale);
            } 
            if (this.dateStyle != null) {
                return fromDate(date, this.dateStyle, this.timeStyle, this.locale); 
            }
            return null;
        }
        
        private String fromDate(final Date date, final String thePattern, final Locale theLocale) {
            
            Validate.isTrue((StringUtils.isNotEmpty(thePattern))
                    || (theLocale != null && thePattern != null),
                    "Either pattern or locale and pattern must be set");
            
            DateFormat sdf = new SimpleDateFormat(thePattern, 
                    (theLocale == null) ? Locale.getDefault() : theLocale);             
                        
            return sdf.format(date);
        }       
        

        private String fromDate(final Date date, final DateStyle theDateStyle,
                final TimeStyle theTimeStyle, final Locale theLocale) {

            Validate.notNull(theDateStyle, "Date style cannot be null");
            Validate.notNull(theTimeStyle, "Time style cannot be null");
            Validate.isTrue(theDateStyle != DateStyle.NONE || theTimeStyle != TimeStyle.NONE,
                    "At least one of dateStyle and timeStyle must have a value different from NONE");
            
            DateFormat sdf = null;
            if (theDateStyle != DateStyle.NONE && theTimeStyle != TimeStyle.NONE) {
                sdf = DateFormat.getDateTimeInstance(Integer.parseInt(theDateStyle.toString()), 
                        Integer.parseInt(theTimeStyle.toString()),
                        (theLocale == null) ? Locale.getDefault() : theLocale);
            } else if (theDateStyle != DateStyle.NONE) {
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
