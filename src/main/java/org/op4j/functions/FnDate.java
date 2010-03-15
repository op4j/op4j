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
public final class FnDate {

    
    private static final Function<Date,Calendar> TO_CALENDAR = new ToCalendar();

    
    private static final Function<Timestamp,Date> TIMESTAMP_TO_DATE = new TimestampToDate();
    private static final Function<Long,Date> TIME_IN_MILLIS_TO_DATE = new TimeInMillisToDate();
    
    private static final Function<List<Integer>,Date> FIELD_INTEGER_LIST_TO_DATE = new FieldIntegerListToDate();
    private static final Function<Integer[],Date> FIELD_INTEGER_ARRAY_TO_DATE = new FieldIntegerArrayToDate();
    private static final Function<List<String>,Date> FIELD_STRING_LIST_TO_DATE = new FieldStringListToDate();
    private static final Function<String[],Date> FIELD_STRING_ARRAY_TO_DATE = new FieldStringArrayToCalendar();


    
	private FnDate() {
		super();           
	}
	

    
    
    public static final Function<Date,Calendar> toCalendar() {
        return TO_CALENDAR;
    }
    
    public static final Function<Date,Calendar> toCalendar(final int truncateField) {
        return new ToCalendar(truncateField);
    }
	
	
	

	public static final Function<Date,Date> add(final int calendarField, final int amount) {
        return new Add(calendarField, amount);
    }
	
    public static final Function<Date,Date> addDays(final int amount) {
        return new Add(Calendar.DATE, amount);
    }
    
    public static final Function<Date,Date> addHours(final int amount) {
        return new Add(Calendar.HOUR, amount);
    }
    
    public static final Function<Date,Date> addMilliseconds(final int amount) {
        return new Add(Calendar.MILLISECOND, amount);
    }
    
    public static final Function<Date,Date> addMinutes(final int amount) {
        return new Add(Calendar.MINUTE, amount);
    }
    
    public static final Function<Date,Date> addMonths(final int amount) {
        return new Add(Calendar.MONTH, amount);
    }
    
    public static final Function<Date,Date> addWeeks(final int amount) {
        return new Add(Calendar.WEEK_OF_YEAR, amount);
    }
    
    public static final Function<Date,Date> addYears(final int amount) {
        return new Add(Calendar.YEAR, amount);
    }

    public static final Function<Date,Date> set(final int calendarField, final int value) {
        return new Set(calendarField, value);
    }
    
    public static final Function<Date,Date> setDay(final int value) {
        return new Set(Calendar.DATE, value);
    }
    
    public static final Function<Date,Date> setHour(final int value) {
        return new Set(Calendar.HOUR, value);
    }
    
    public static final Function<Date,Date> setMillisecond(final int value) {
        return new Set(Calendar.MILLISECOND, value);
    }
    
    public static final Function<Date,Date> setMinute(final int value) {
        return new Set(Calendar.MINUTE, value);
    }
    
    public static final Function<Date,Date> setMonth(final int value) {
        return new Set(Calendar.MONTH, value);
    }
    
    public static final Function<Date,Date> setWeek(final int value) {
        return new Set(Calendar.WEEK_OF_YEAR, value);
    }
    
    public static final Function<Date,Date> setYear(final int value) {
        return new Set(Calendar.YEAR, value);
    }

    public static final Function<Date,Date> round(final int calendarField) {
        return new Round(calendarField);
    }

    public static final Function<Date,Date> truncate(final int calendarField) {
        return new Truncate(calendarField);
    }

    public static final Function<Date,Boolean> before(final Date date) {
        return new Before(date);
    }

    public static final Function<Date,Boolean> after(final Date date) {
        return new After(date);
    }
    
    
    
    public static final Function<Date,String> toStr(final String pattern) {
        return new ToString(pattern);
    }
    
    public static final Function<Date,String> toStr(final String pattern, final Locale locale) {
        return new ToString(pattern, locale);
    }
    
    public static final Function<Date,String> toStr(final String pattern, final String locale) {
        return new ToString(pattern, locale);
    }
    
    public static final Function<Date,String> toStr(final DateStyle dateStyle, final TimeStyle timeStyle) {
        return new ToString(dateStyle, timeStyle);
    }
    
    public static final Function<Date,String> toStr(final DateStyle dateStyle, final TimeStyle timeStyle, final Locale locale) {
        return new ToString(dateStyle, timeStyle, locale);
    }
    
    public static final Function<Date,String> toStr(final DateStyle dateStyle, final TimeStyle timeStyle, final String locale) {
        return new ToString(dateStyle, timeStyle, locale);
    }
    

    
    
    
    
    
    
    
    
    
    
    public static final Function<Timestamp,Date> timestampToDate() {
        return TIMESTAMP_TO_DATE;
    }
    
    public static final Function<Timestamp,Date> timestampToDate(final int truncateField) {
        return new TimestampToDate(truncateField);
    }
    
    
    
    public static final Function<Long,Date> timeInMillisToDate() {
        return TIME_IN_MILLIS_TO_DATE;
    }
    
    public static final Function<Long,Date> timeInMillisToDate(final int truncateField) {
        return new TimeInMillisToDate(truncateField);
    }
    
    
    
    
    
    
    
    
    public static final Function<List<Integer>, Date> fieldIntegerListToDate() {
        return FIELD_INTEGER_LIST_TO_DATE;
    }
    
    
    
    public static final Function<Integer[], Date> fieldIntegerArrayToDate() {
        return FIELD_INTEGER_ARRAY_TO_DATE;
    }
    
    
    
    public static final Function<List<String>, Date> fieldStringListToDate() {
        return FIELD_STRING_LIST_TO_DATE;
    }
    
    
    
    public static final Function<String[], Date> fieldStringArrayToDate() {
        return FIELD_STRING_ARRAY_TO_DATE;
    }
    

    
    public static final Function<Date,Boolean> eq(final Date object) {
        return new Equals(object);
    }
    
    public static final Function<Date,Boolean> notEq(final Date object) {
        return new NotEquals(object);
    }
    
    
    
    
    
    public static final Function<Object,Boolean> isNull() {
        return FnObject.isNull();
    }
    
    public static final Function<Object,Boolean> isNotNull() {
        return FnObject.isNotNull();
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

    
    
    
    

    
    static final class ToCalendar extends AbstractNullAsNullFunction<Date,Calendar>  {
    
        private Integer truncateField = null;
        
        ToCalendar() {
            super();
        }
        
        ToCalendar(final int truncateField) {
            super();
            this.truncateField = Integer.valueOf(truncateField);
        }

        @Override
        protected Calendar nullAsNullExecute(final Date object, final ExecCtx ctx) throws Exception {
            
            final Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(object.getTime());
            
            if (this.truncateField == null) {
                return calendar;
            }
            return DateUtils.truncate(calendar, this.truncateField.intValue());
            
        }
        
    }
    

    
    
    
    
    
    static final class TimestampToDate extends AbstractNullAsNullFunction<Timestamp,Date>  {
    
        private Integer truncateField = null;
        
        TimestampToDate() {
            super();
        }
        
        TimestampToDate(final int truncateField) {
            super();
            this.truncateField = Integer.valueOf(truncateField);
        }

        @Override
        protected Date nullAsNullExecute(final Timestamp object, final ExecCtx ctx) throws Exception {
            
            final Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(object.getTime());
            
            if (this.truncateField == null) {
                return calendar.getTime();
            }
            return DateUtils.truncate(calendar, this.truncateField.intValue()).getTime();
            
        }
        
    }
    

    
    static final class TimeInMillisToDate extends AbstractNullAsNullFunction<Long,Date>  {
    
        private Integer truncateField = null;
        
        TimeInMillisToDate() {
            super();
        }
        
        TimeInMillisToDate(final int truncateField) {
            super();
            this.truncateField = Integer.valueOf(truncateField);
        }

        @Override
        protected Date nullAsNullExecute(final Long object, final ExecCtx ctx) throws Exception {
            
            final Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(object.longValue());
            
            if (this.truncateField == null) {
                return calendar.getTime();
            }
            return DateUtils.truncate(calendar, this.truncateField.intValue()).getTime();
            
        }
        
    }
    
 
    
    
    
    
    protected static Date fromInts(final Integer year, final Integer month, final Integer day, 
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
            calendar.setTime(sdf.parse(yearAsString));
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
        
        return result.getTime();
    }

    
    
    
    
    static final class FieldIntegerListToDate extends AbstractNullAsNullFunction<List<Integer>,Date>  {
        
        
        FieldIntegerListToDate() {
            super();
        }

        @Override
        protected Date nullAsNullExecute(final List<Integer> object, final ExecCtx ctx) throws Exception {
            
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

    
    
    
    static final class FieldIntegerArrayToDate extends AbstractNullAsNullFunction<Integer[],Date>  {
        
        
        FieldIntegerArrayToDate() {
            super();
        }

        @Override
        protected Date nullAsNullExecute(final Integer[] object, final ExecCtx ctx) throws Exception {
            
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

    
    
    static final class FieldStringListToDate extends AbstractNullAsNullFunction<List<String>,Date>  {
        
        
        FieldStringListToDate() {
            super();
        }

        @Override
        protected Date nullAsNullExecute(final List<String> object, final ExecCtx ctx) throws Exception {
            
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

    
    
    
    static final class FieldStringArrayToCalendar extends AbstractNullAsNullFunction<String[],Date>  {
        
        
        FieldStringArrayToCalendar() {
            super();
        }

        @Override
        protected Date nullAsNullExecute(final String[] object, final ExecCtx ctx) throws Exception {
            
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
    
    
    
    
    
    
    
    static final class Equals extends Function<Date,Boolean> {

        private final Date object;
        
        Equals(final Date object) {
            super();
            this.object = object;
        }

        public Boolean execute(final Date input, final ExecCtx ctx) throws Exception {
            if (input == null) {
                return Boolean.valueOf(this.object == null);
            }
            return Boolean.valueOf(input.equals(this.object));
        }
        
    }
    
    
    static final class NotEquals extends Function<Date,Boolean> {

        private final Date object;
        
        NotEquals(final Date object) {
            super();
            this.object = object;
        }

        public Boolean execute(final Date input, final ExecCtx ctx) throws Exception {
            if (input == null) {
                return Boolean.valueOf(this.object == null);
            }
            return Boolean.valueOf(!input.equals(this.object));
        }
        
    }
        
    
}
