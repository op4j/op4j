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

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.ArrayUtils;
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
public final class FnCalendar {

    
    private static final Function<Timestamp,Calendar> TIMESTAMP_TO_CALENDAR = new TimestampToCalendar();
    private static final Function<Long,Calendar> TIME_IN_MILLIS_TO_CALENDAR = new TimeInMillisToCalendar();
    
    private static final Function<List<Integer>,Calendar> FIELD_INTEGER_LIST_TO_CALENDAR = new FieldIntegerListToCalendar();
    private static final Function<Integer[],Calendar> FIELD_INTEGER_ARRAY_TO_CALENDAR = new FieldIntegerArrayToCalendar();
    private static final Function<List<String>,Calendar> FIELD_STRING_LIST_TO_CALENDAR = new FieldStringListToCalendar();
    private static final Function<String[],Calendar> FIELD_STRING_ARRAY_TO_CALENDAR = new FieldStringArrayToCalendar();

    
    
	private FnCalendar() {
		super();           
	}
	
	

	/**
	 * <p>
	 * Modifies a Calendar by adding a positive or negative amount to one of its
	 * fields. 
	 * </p>
	 * <p>
	 * Fields are specified by means of <tt>java.util.Calendar</tt> constants, like
	 * <tt>FnCalendar.add(Calendar.DAY_OF_MONTH, 1)</tt>.
	 * </p>
	 * 
	 * @param calendarField the field that will be modified (java.util.Calendar constant).
	 * @param amount the positive or negative amount to be added
	 * @return the modified Calendar
	 */
	public static final Function<Calendar,Calendar> add(final int calendarField, final int amount) {
        return new Add(calendarField, amount);
    }

	
    /**
     * <p>
     * Modifies a Calendar by adding a positive or negative amount to one the
     * "day" property (<tt>java.util.Calendar.DATE</tt>). 
     * </p>
     * 
     * @param amount the positive or negative amount to be added
     * @return the modified Calendar
     */
    public static final Function<Calendar,Calendar> addDays(final int amount) {
        return new Add(Calendar.DATE, amount);
    }
    

    /**
     * <p>
     * Modifies a Calendar by adding a positive or negative amount to one the
     * "hour" property (<tt>java.util.Calendar.HOUR</tt>). 
     * </p>
     * 
     * @param amount the positive or negative amount to be added
     * @return the modified Calendar
     */
    public static final Function<Calendar,Calendar> addHours(final int amount) {
        return new Add(Calendar.HOUR, amount);
    }

    
    /**
     * <p>
     * Modifies a Calendar by adding a positive or negative amount to one the
     * "millisecond" property (<tt>java.util.Calendar.MILLISECOND</tt>). 
     * </p>
     * 
     * @param amount the positive or negative amount to be added
     * @return the modified Calendar
     */
    public static final Function<Calendar,Calendar> addMilliseconds(final int amount) {
        return new Add(Calendar.MILLISECOND, amount);
    }

    
    /**
     * <p>
     * Modifies a Calendar by adding a positive or negative amount to one the
     * "minute" property (<tt>java.util.Calendar.MINUTE</tt>). 
     * </p>
     * 
     * @param amount the positive or negative amount to be added
     * @return the modified Calendar
     */
    public static final Function<Calendar,Calendar> addMinutes(final int amount) {
        return new Add(Calendar.MINUTE, amount);
    }

    
    /**
     * <p>
     * Modifies a Calendar by adding a positive or negative amount to one the
     * "month" property (<tt>java.util.Calendar.MONTH</tt>). 
     * </p>
     * 
     * @param amount the positive or negative amount to be added
     * @return the modified Calendar
     */
    public static final Function<Calendar,Calendar> addMonths(final int amount) {
        return new Add(Calendar.MONTH, amount);
    }

    
    /**
     * <p>
     * Modifies a Calendar by adding a positive or negative amount to one the
     * "week" property (<tt>java.util.Calendar.WEEK_OF_YEAR</tt>). 
     * </p>
     * 
     * @param amount the positive or negative amount to be added
     * @return the modified Calendar
     */
    public static final Function<Calendar,Calendar> addWeeks(final int amount) {
        return new Add(Calendar.WEEK_OF_YEAR, amount);
    }

    
    /**
     * <p>
     * Modifies a Calendar by adding a positive or negative amount to one the
     * "year" property (<tt>java.util.Calendar.YEAR</tt>). 
     * </p>
     * 
     * @param amount the positive or negative amount to be added
     * @return the modified Calendar
     */
    public static final Function<Calendar,Calendar> addYears(final int amount) {
        return new Add(Calendar.YEAR, amount);
    }

    
    /**
     * <p>
     * Modifies a Calendar by setting one of its to the specified value. 
     * </p>
     * <p>
     * Fields are specified by means of <tt>java.util.Calendar</tt> constants, like
     * <tt>FnCalendar.set(Calendar.DAY_OF_MONTH, 12)</tt>.
     * </p>
     * 
     * @param calendarField the field that will be modified (java.util.Calendar constant).
     * @param value the new value
     * @return the modified Calendar
     */
    public static final Function<Calendar,Calendar> set(final int calendarField, final int value) {
        return new Set(calendarField, value);
    }
    
    
    /**
     * <p>
     * Modifies a Calendar by setting the "day" property (<tt>java.util.Calendar.DATE</tt>)
     * to the specified value. 
     * </p>
     * 
     * @param value the new value for the property
     * @return the modified Calendar
     */
    public static final Function<Calendar,Calendar> setDay(final int value) {
        return new Set(Calendar.DATE, value);
    }

    
    /**
     * <p>
     * Modifies a Calendar by setting the "hour" property (<tt>java.util.Calendar.HOUR</tt>)
     * to the specified value. 
     * </p>
     * 
     * @param value the new value for the property
     * @return the modified Calendar
     */
    public static final Function<Calendar,Calendar> setHour(final int value) {
        return new Set(Calendar.HOUR, value);
    }

    
    /**
     * <p>
     * Modifies a Calendar by setting the "millisecond" property (<tt>java.util.Calendar.MILLISECOND</tt>)
     * to the specified value. 
     * </p>
     * 
     * @param value the new value for the property
     * @return the modified Calendar
     */
    public static final Function<Calendar,Calendar> setMillisecond(final int value) {
        return new Set(Calendar.MILLISECOND, value);
    }

    
    /**
     * <p>
     * Modifies a Calendar by setting the "minute" property (<tt>java.util.Calendar.MINUTE</tt>)
     * to the specified value. 
     * </p>
     * 
     * @param value the new value for the property
     * @return the modified Calendar
     */
    public static final Function<Calendar,Calendar> setMinute(final int value) {
        return new Set(Calendar.MINUTE, value);
    }

    
    /**
     * <p>
     * Modifies a Calendar by setting the "month" property (<tt>java.util.Calendar.MONTH</tt>)
     * to the specified value. 
     * </p>
     * 
     * @param value the new value for the property
     * @return the modified Calendar
     */
    public static final Function<Calendar,Calendar> setMonth(final int value) {
        return new Set(Calendar.MONTH, value);
    }

    
    /**
     * <p>
     * Modifies a Calendar by setting the "week" property (<tt>java.util.Calendar.WEEK_OF_YEAR</tt>)
     * to the specified value. 
     * </p>
     * 
     * @param value the new value for the property
     * @return the modified Calendar
     */
    public static final Function<Calendar,Calendar> setWeek(final int value) {
        return new Set(Calendar.WEEK_OF_YEAR, value);
    }

    
    /**
     * <p>
     * Modifies a Calendar by setting the "year" property (<tt>java.util.Calendar.YEAR</tt>)
     * to the specified value. 
     * </p>
     * 
     * @param value the new value for the property
     * @return the modified Calendar
     */
    public static final Function<Calendar,Calendar> setYear(final int value) {
        return new Set(Calendar.YEAR, value);
    }

    
    /**
     * <p>
     * Rounds the target Calendar, setting the specified field as the 
     * most significant field.
     * </p>
     * <p>
     * Based on <tt>org.apache.commons.lang.time.DateUtils.round()</tt>.
     * </p>
     * 
     * @param calendarField the field on which the calendar will be rounded (<tt>java.util.Calendar</tt> field).
     * @return the resulting Calendar
     */
    public static final Function<Calendar,Calendar> round(final int calendarField) {
        return new Round(calendarField);
    }
    

    /**
     * <p>
     * Truncates the target Calendar, setting the specified field as the 
     * most significant field.
     * </p>
     * <p>
     * Based on <tt>org.apache.commons.lang.time.DateUtils.truncate()</tt>.
     * </p>
     * 
     * @param calendarField the field on which the calendar will be truncated (<tt>java.util.Calendar</tt> field).
     * @return the resulting Calendar
     */
    public static final Function<Calendar,Calendar> truncate(final int calendarField) {
        return new Truncate(calendarField);
    }

    
    /**
     * <p>
     * Determines whether the target Calendar represents a moment in time before the
     * Calendar specified as a parameter.
     * </p>
     * 
     * @param calendar the calendar to compare to
     * @return true if target is before, false otherwise
     */
    public static final Function<Calendar,Boolean> before(final Calendar calendar) {
        return new Before(calendar);
    }

    
    /**
     * <p>
     * Determines whether the target Calendar represents a moment in time after the
     * Calendar specified as a parameter.
     * </p>
     * 
     * @param calendar the calendar to compare to
     * @return true if target is after, false otherwise
     */
    public static final Function<Calendar,Boolean> after(final Calendar calendar) {
        return new After(calendar);
    }
    
    
    /**
     * <p>
     * Converts the target Calendar into a String using the specified <tt>pattern</tt>.
     * The pattern has to be written in the <tt>java.text.SimpleDateFormat</tt> format.
     * </p>
     * <p>
     * As no locale is specified, if pattern includes locale-dependent texts 
     * like month names (<tt>MMM</tt>) or week days (<tt>EEE</tt>), the default locale
     * will be used for resolving these components.  
     * </p>
     * 
     * @param pattern the pattern to be used, as specified by <tt>java.text.SimpleDateFormat</tt>.
     * @return the String representation of the target Calendar.
     */
    public static final Function<Calendar,String> toStr(final String pattern) {
        return new ToString(pattern);
    }
    

    /**
     * <p>
     * Converts the target Calendar into a String using the specified <tt>pattern</tt>.
     * The pattern has to be written in the <tt>java.text.SimpleDateFormat</tt> format, 
     * and the specified locale will be used for text-based pattern components (like
     * month names or week days).
     * </p>
     * 
     * @param pattern the pattern to be used, as specified by <tt>java.text.SimpleDateFormat</tt>.
     * @param locale the locale to be used for text-based pattern components
     * @return the String representation of the target Calendar.
     */
    public static final Function<Calendar,String> toStr(final String pattern, final Locale locale) {
        return new ToString(pattern, locale);
    }

    
    /**
     * <p>
     * Converts the target Calendar into a String using the specified <tt>pattern</tt>.
     * The pattern has to be written in the <tt>java.text.SimpleDateFormat</tt> format, 
     * and the specified locale will be used for text-based pattern components (like
     * month names or week days).
     * </p>
     * 
     * @param pattern the pattern to be used, as specified by <tt>java.text.SimpleDateFormat</tt>.
     * @param locale the locale to be used for text-based pattern components
     * @return the String representation of the target Calendar.
     */
    public static final Function<Calendar,String> toStr(final String pattern, final String locale) {
        return new ToString(pattern, locale);
    }
    

    /**
     * <p>
     * Converts the target Calendar into a String using the specified date ({@link DateStyle}) 
     * and time ({@link TimeStyle}) styles. 
     * </p>
     * 
     * @param dateStyle the date style to be used
     * @param timeStyle the time style to be used
     * @return the String representation of the Calendar.
     */
    public static final Function<Calendar,String> toStr(final DateStyle dateStyle, final TimeStyle timeStyle) {
        return new ToString(dateStyle, timeStyle);
    }
    
    
    /**
     * <p>
     * Converts the target Calendar into a String using the specified date ({@link DateStyle}) 
     * and time ({@link TimeStyle}) styles, and resolving text-based components like month names
     * using the specified locale. 
     * </p>
     * 
     * @param dateStyle the date style to be used
     * @param timeStyle the time style to be used
     * @param locale the locale to be used
     * @return the String representation of the Calendar.
     */
    public static final Function<Calendar,String> toStr(final DateStyle dateStyle, final TimeStyle timeStyle, final Locale locale) {
        return new ToString(dateStyle, timeStyle, locale);
    }

    
    /**
     * <p>
     * Converts the target Calendar into a String using the specified date ({@link DateStyle}) 
     * and time ({@link TimeStyle}) styles, and resolving text-based components like month names
     * using the specified locale. 
     * </p>
     * 
     * @param dateStyle the date style to be used
     * @param timeStyle the time style to be used
     * @param locale the locale to be used
     * @return the String representation of the Calendar.
     */
    public static final Function<Calendar,String> toStr(final DateStyle dateStyle, final TimeStyle timeStyle, final String locale) {
        return new ToString(dateStyle, timeStyle, locale);
    }
    

    
    
    
    
    /**
     * <p>
     * Converts the target <tt>java.sql.Timestamp</tt> into a Calendar. 
     * </p>
     * 
     * @return the resulting Calendar.
     */
    public static final Function<Timestamp,Calendar> timestampToCalendar() {
        return TIMESTAMP_TO_CALENDAR;
    }
    
    
    /**
     * <p>
     * Converts the target <tt>java.sql.Timestamp</tt> into a Calendar, truncating by the
     * specified field (<tt>java.util.Calendar</tt> constant field).
     * </p>
     * 
     * @return the resulting Calendar.
     */
    public static final Function<Timestamp,Calendar> timestampToCalendar(final int truncateField) {
        return new TimestampToCalendar(truncateField);
    }
    
    
    
    /**
     * <p>
     * Converts the target Long (representing a time in milliseconds) into a Calendar. 
     * </p>
     * 
     * @return the resulting Calendar.
     */
    public static final Function<Long,Calendar> timeInMillisToCalendar() {
        return TIME_IN_MILLIS_TO_CALENDAR;
    }
    
    
    /**
     * <p>
     * Converts the target Long (representing a time in milliseconds) into a Calendar,
     * truncating by the specified field (<tt>java.util.Calendar</tt> constant field). 
     * </p>
     * 
     * @return the resulting Calendar.
     */
    public static final Function<Long,Calendar> timeInMillisToCalendar(final int truncateField) {
        return new TimeInMillisToCalendar(truncateField);
    }
    
    
    
    
    
    
    
    
    /**
     * <p>
     * Converts a List&lt;Integer&gt; containing the components of a date to a 
     * <tt>java.util.Calendar</tt> object.
     * </p>
     * <p>
     * The target list can contain the following combinations of elements, 
     * in the specified order:
     * </p>
     * <ul>
     *   <li>year, month, day</li>
     *   <li>year, month, day, hour, minute</li>
     *   <li>year, month, day, hour, minute, second</li>
     *   <li>year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * 
     * @return the resulting Calendar
     */
    public static final Function<List<Integer>, Calendar> fieldIntegerListToCalendar() {
        return FIELD_INTEGER_LIST_TO_CALENDAR;
    }
    
    
    
    /**
     * <p>
     * Converts an Integer[] containing the components of a date to a 
     * <tt>java.util.Calendar</tt> object.
     * </p>
     * <p>
     * The target array can contain the following combinations of elements, in
     * the specified order:
     * </p>
     * <ul>
     *   <li>year, month, day</li>
     *   <li>year, month, day, hour, minute</li>
     *   <li>year, month, day, hour, minute, second</li>
     *   <li>year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * 
     * @return the resulting Calendar
     */
    public static final Function<Integer[], Calendar> fieldIntegerArrayToCalendar() {
        return FIELD_INTEGER_ARRAY_TO_CALENDAR;
    }
    
    
    
    /**
     * <p>
     * Converts a List&lt;String&gt; containing the components of a date to a 
     * <tt>java.util.Calendar</tt> object.
     * </p>
     * <p>
     * The target list can contain the following combinations of elements, 
     * all of them in numeric format, in the specified order:
     * </p>
     * <ul>
     *   <li>year, month, day</li>
     *   <li>year, month, day, hour, minute</li>
     *   <li>year, month, day, hour, minute, second</li>
     *   <li>year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * 
     * @return the resulting Calendar
     */
    public static final Function<List<String>, Calendar> fieldStringListToCalendar() {
        return FIELD_STRING_LIST_TO_CALENDAR;
    }
    
    
    
    /**
     * <p>
     * Converts a String[] containing the components of a date to a 
     * <tt>java.util.Calendar</tt> object.
     * </p>
     * <p>
     * The target array can contain the following combinations of elements, 
     * all of them in numeric format, in the specified order:
     * </p>
     * <ul>
     *   <li>year, month, day</li>
     *   <li>year, month, day, hour, minute</li>
     *   <li>year, month, day, hour, minute, second</li>
     *   <li>year, month, day, hour, minute, second, millisecond</li>
     * </ul>
     * 
     * @return the resulting Calendar
     */
    public static final Function<String[], Calendar> fieldStringArrayToCalendar() {
        return FIELD_STRING_ARRAY_TO_CALENDAR;
    }
    
    
    

    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Object,Boolean> eq(final Calendar object) {
        return FnObject.eq(object);
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Object,Boolean> notEq(final Calendar object) {
        return FnObject.notEq(object);
    }
    
    
    
    
    
    
    

    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return true if the target object is null, false if not.
     */
    public static final Function<Object,Boolean> isNull() {
        return FnObject.isNull();
    }
    
    

    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return false if the target object is null, true if not.
     */
    public static final Function<Object,Boolean> isNotNull() {
        return FnObject.isNotNull();
    }
    
    
    
    
    
    
    
    
    
    
	

	
	static final class Add extends AbstractNotNullFunction<Calendar,Calendar> {

	    private final int calendarField;
	    private final int amount;
	    
		Add(final int calendarField, final int amount) {
			super();
			this.calendarField = calendarField;
			this.amount = amount;
		}

        @Override
        public Calendar notNullExecute(final Calendar input, final ExecCtx ctx) throws Exception {
            final Calendar result = (Calendar) input.clone();
			result.add(this.calendarField, this.amount);
			return result;
		}		
        
	}

    
    static final class Roll extends AbstractNotNullFunction<Calendar,Calendar> {

        private final int calendarField;
        private final int amount;
        
        Roll(final int calendarField, final int amount) {
            super();
            this.calendarField = calendarField;
            this.amount = amount;
        }

        @Override
        public Calendar notNullExecute(final Calendar input, final ExecCtx ctx) throws Exception {
            final Calendar result = (Calendar) input.clone();
            result.roll(this.calendarField, this.amount);
            return result;
        }       
        
    }

    
	
    static final class Set extends AbstractNotNullFunction<Calendar,Calendar> {

        private final int calendarField;
        private final int value;
        
        Set(final int calendarField, final int value) {
            super();
            this.calendarField = calendarField;
            this.value = value;
        }

        @Override
        public Calendar notNullExecute(final Calendar input, final ExecCtx ctx) throws Exception {
            final Calendar result = (Calendar) input.clone();
            result.set(this.calendarField, this.value);
            return result;
        }       
        
    }

	
    
    static final class Round extends AbstractNotNullFunction<Calendar,Calendar> {

        private final int calendarField;
        
        Round(final int calendarField) {
            super();
            this.calendarField = calendarField;
        }

        @Override
        public Calendar notNullExecute(final Calendar input, final ExecCtx ctx) throws Exception {
            Calendar result = (Calendar) input.clone();
            result = DateUtils.round(result, this.calendarField);
            return result;
        }       
        
    }

    
    
    static final class Truncate extends AbstractNotNullFunction<Calendar,Calendar> {

        private final int calendarField;
        
        Truncate(final int calendarField) {
            super();
            this.calendarField = calendarField;
        }

        @Override
        public Calendar notNullExecute(final Calendar input, final ExecCtx ctx) throws Exception {
            Calendar result = (Calendar) input.clone();
            result = DateUtils.truncate(result, this.calendarField);
            return result;
        }       
        
    }
    
    
    static final class Before extends AbstractNotNullFunction<Calendar,Boolean> {

        private final Calendar calendar;
        
        Before(final Calendar calendar) {
            super();
            Validate.notNull(calendar, "Specified calendar cannot be null");
            this.calendar = calendar;
        }

        @Override
        public Boolean notNullExecute(final Calendar input, final ExecCtx ctx) throws Exception {
            return Boolean.valueOf(input.before(this.calendar));
        }       
        
    }
    
    
    static final class After extends AbstractNotNullFunction<Calendar,Boolean> {

        private final Calendar calendar;
        
        After(final Calendar calendar) {
            super();
            Validate.notNull(calendar, "Specified calendar cannot be null");
            this.calendar = calendar;
        }

        @Override
        public Boolean notNullExecute(final Calendar input, final ExecCtx ctx) throws Exception {
            return Boolean.valueOf(input.after(this.calendar));
        }       
        
    }
    
    
    
    static final class ToString extends AbstractNullAsNullFunction<Calendar,String>  {

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
        protected String nullAsNullExecute(final Calendar calendar, final ExecCtx ctx) throws Exception {
            if (StringUtils.isNotEmpty(this.pattern)) {
                return fromCalendar(calendar, this.pattern, this.locale);
            } 
            if (this.dateStyle != null) {
                return fromCalendar(calendar, this.dateStyle, this.timeStyle, this.locale); 
            }
            return null;
        }
        
        private String fromCalendar(final Calendar calendar, final String thePattern, final Locale theLocale) {
            
            Validate.isTrue((StringUtils.isNotEmpty(thePattern))
                    || (theLocale != null && thePattern != null),
                    "Either pattern or locale and pattern must be set");
            
            DateFormat sdf = new SimpleDateFormat(thePattern, 
                    (theLocale == null) ? Locale.getDefault() : theLocale);             
                        
            return sdf.format(calendar.getTime());
        }       
        

        private String fromCalendar(final Calendar calendar, final DateStyle theDateStyle,
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
            
            return sdf.format(calendar.getTime());
        }       
    }
    
    
    
    
    
    
    
    static final class TimestampToCalendar extends AbstractNullAsNullFunction<Timestamp,Calendar>  {
    
        private Integer truncateField = null;
        
        TimestampToCalendar() {
            super();
        }
        
        TimestampToCalendar(final int truncateField) {
            super();
            this.truncateField = Integer.valueOf(truncateField);
        }

        @Override
        protected Calendar nullAsNullExecute(final Timestamp object, final ExecCtx ctx) throws Exception {
            
            final Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(object.getTime());
            
            if (this.truncateField == null) {
                return calendar;
            }
            return DateUtils.truncate(calendar, this.truncateField.intValue());
            
        }
        
    }
    

    
    static final class TimeInMillisToCalendar extends AbstractNullAsNullFunction<Long,Calendar>  {
    
        private Integer truncateField = null;
        
        TimeInMillisToCalendar() {
            super();
        }
        
        TimeInMillisToCalendar(final int truncateField) {
            super();
            this.truncateField = Integer.valueOf(truncateField);
        }

        @Override
        protected Calendar nullAsNullExecute(final Long object, final ExecCtx ctx) throws Exception {
            
            final Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(object.longValue());
            
            if (this.truncateField == null) {
                return calendar;
            }
            return DateUtils.truncate(calendar, this.truncateField.intValue());
            
        }
        
    }
    
 
    
    
    
    
    protected static Calendar fromInts(final Integer year, final Integer month, final Integer day, 
            final Integer hour, final Integer minute, final Integer second, final Integer milli) 
        throws Exception {

        /*
         * None of the Integers can be null 
         */
        Validate.notNull(year);
        Validate.notNull(month);
        Validate.notNull(day);
        Validate.notNull(hour);
        Validate.notNull(minute);
        Validate.notNull(second);
        Validate.notNull(milli);
        
        Integer safeYear = year;    
        String yearAsString = year.toString();
        if ((safeYear.intValue() >= 0) && (yearAsString.length() <= 2)) {
            final SimpleDateFormat sdf = new SimpleDateFormat("yy");
            final Calendar calendar = Calendar.getInstance();
            
            //It uses ParsePosition to make sure the whole 
            //string has been converted into a number
            ParsePosition pp = new ParsePosition(0);
            Date date = sdf.parse(yearAsString, pp);
            if (pp.getIndex() != yearAsString.length()) {
                throw new ParseException("The whole input String does not represent a valid Date", 
                        pp.getIndex());
            }            
            calendar.setTime(date);
            safeYear = Integer.valueOf(calendar.get(Calendar.YEAR));
        }      
            
        final Calendar result = Calendar.getInstance();
        result.set(Calendar.YEAR, safeYear.intValue());
        result.set(Calendar.MONTH, month.intValue() - 1);
        result.set(Calendar.DAY_OF_MONTH, day.intValue());
        result.set(Calendar.HOUR_OF_DAY, hour.intValue());
        result.set(Calendar.MINUTE, minute.intValue());
        result.set(Calendar.SECOND, second.intValue());
        result.set(Calendar.MILLISECOND, milli.intValue());
        
        return result;      
    }

    
    
    
    
    static final class FieldIntegerListToCalendar extends AbstractNullAsNullFunction<List<Integer>,Calendar>  {
        
        
        FieldIntegerListToCalendar() {
            super();
        }

        @Override
        protected Calendar nullAsNullExecute(final List<Integer> object, final ExecCtx ctx) throws Exception {
            
            if (object.size() != 3 &&  // year, month, day
                object.size() != 5 &&  // year, month, day, hour, minute
                object.size() != 6 &&  // year, month, day, hour, minute, second
                object.size() != 7) {  // year month, day, hour, minute, second, millisecond
                throw new IllegalArgumentException(
                        "Integer arguments array for Calendar conversion should of sizes " +
                        "3 (day,month,year), 5 (+hour,minute), 6 (+second) or 7 (+millisecond). " +
                        "Size " + object.size() + " is not valid.");
            }
            if (object.contains(null)) {
                throw new IllegalArgumentException(
                        "Integer arguments array for Calendar conversion should not contain nulls.");
            }
            return fromInts(
                    object.get(0),
                    object.get(1),
                    object.get(2),
                    (object.size() >= 5? object.get(3) : Integer.valueOf(0)), 
                    (object.size() >= 5? object.get(4) : Integer.valueOf(0)),
                    (object.size() >= 6? object.get(5) : Integer.valueOf(0)),
                    (object.size() == 7? object.get(6) : Integer.valueOf(0)));
            
        }
        
    }

    
    
    
    static final class FieldIntegerArrayToCalendar extends AbstractNullAsNullFunction<Integer[],Calendar>  {
        
        
        FieldIntegerArrayToCalendar() {
            super();
        }

        @Override
        protected Calendar nullAsNullExecute(final Integer[] object, final ExecCtx ctx) throws Exception {
            
            if (object.length != 3 &&  // year, month, day
                object.length != 5 &&  // year, month, day, hour, minute
                object.length != 6 &&  // year, month, day, hour, minute, second
                object.length != 7) {  // year month, day, hour, minute, second, millisecond
                throw new IllegalArgumentException(
                        "Integer arguments array for Calendar conversion should of sizes " +
                        "3 (day,month,year), 5 (+hour,minute), 6 (+second) or 7 (+millisecond). " +
                        "Size " + object.length + " is not valid.");
            }
            if (ArrayUtils.contains(object,null)) {
                throw new IllegalArgumentException(
                        "Integer arguments array for Calendar conversion should not contain nulls.");
            }
            return fromInts(
                    object[0],
                    object[1],
                    object[2],
                    (object.length >= 5? object[3] : Integer.valueOf(0)), 
                    (object.length >= 5? object[4] : Integer.valueOf(0)),
                    (object.length >= 6? object[5] : Integer.valueOf(0)),
                    (object.length == 7? object[6] : Integer.valueOf(0)));
            
        }
        
    }

    
    
    static final class FieldStringListToCalendar extends AbstractNullAsNullFunction<List<String>,Calendar>  {
        
        
        FieldStringListToCalendar() {
            super();
        }

        @Override
        protected Calendar nullAsNullExecute(final List<String> object, final ExecCtx ctx) throws Exception {
            
            if (object.size() != 3 &&  // year, month, day
                object.size() != 5 &&  // year, month, day, hour, minute
                object.size() != 6 &&  // year, month, day, hour, minute, second
                object.size() != 7) {  // year month, day, hour, minute, second, millisecond
                throw new IllegalArgumentException(
                        "Integer arguments array for Calendar conversion should of sizes " +
                        "3 (day,month,year), 5 (+hour,minute), 6 (+second) or 7 (+millisecond). " +
                        "Size " + object.size() + " is not valid.");
            }
            if (object.contains(null)) {
                throw new IllegalArgumentException(
                        "Integer arguments array for Calendar conversion should not contain nulls.");
            }
            return fromInts(
                    Integer.valueOf(object.get(0)),
                    Integer.valueOf(object.get(1)),
                    Integer.valueOf(object.get(2)),
                    (object.size() >= 5? Integer.valueOf(object.get(3)) : Integer.valueOf(0)), 
                    (object.size() >= 5? Integer.valueOf(object.get(4)) : Integer.valueOf(0)),
                    (object.size() >= 6? Integer.valueOf(object.get(5)) : Integer.valueOf(0)),
                    (object.size() == 7? Integer.valueOf(object.get(6)) : Integer.valueOf(0)));
            
        }
        
    }

    
    
    
    static final class FieldStringArrayToCalendar extends AbstractNullAsNullFunction<String[],Calendar>  {
        
        
        FieldStringArrayToCalendar() {
            super();
        }

        @Override
        protected Calendar nullAsNullExecute(final String[] object, final ExecCtx ctx) throws Exception {
            
            if (object.length != 3 &&  // year, month, day
                object.length != 5 &&  // year, month, day, hour, minute
                object.length != 6 &&  // year, month, day, hour, minute, second
                object.length != 7) {  // year month, day, hour, minute, second, millisecond
                throw new IllegalArgumentException(
                        "Integer arguments array for Calendar conversion should of sizes " +
                        "3 (day,month,year), 5 (+hour,minute), 6 (+second) or 7 (+millisecond). " +
                        "Size " + object.length + " is not valid.");
            }
            if (ArrayUtils.contains(object,null)) {
                throw new IllegalArgumentException(
                        "Integer arguments array for Calendar conversion should not contain nulls.");
            }
            return fromInts(
                    Integer.valueOf(object[0]),
                    Integer.valueOf(object[1]),
                    Integer.valueOf(object[2]),
                    (object.length >= 5? Integer.valueOf(object[3]) : Integer.valueOf(0)), 
                    (object.length >= 5? Integer.valueOf(object[4]) : Integer.valueOf(0)),
                    (object.length >= 6? Integer.valueOf(object[5]) : Integer.valueOf(0)),
                    (object.length == 7? Integer.valueOf(object[6]) : Integer.valueOf(0)));
            
        }
        
    }
    
    
    
    
    
        
    
}
