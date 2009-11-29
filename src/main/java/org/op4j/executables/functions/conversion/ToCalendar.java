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

import java.sql.Timestamp;
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
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.FunctionExecutionException;
import org.op4j.executables.functions.AbstractFunc;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class ToCalendar {

	
	private static final FromCalendar FROM_CALENDAR = new FromCalendar();
	private static final FromDate FROM_DATE = new FromDate();
	private static final FromTimestamp FROM_TIMESTAMP = new FromTimestamp();
	private static final FromTimeInMillis FROM_TIMEINMILLIS = new FromTimeInMillis();
	private static final FromIntegerFieldList FROM_INTEGER_FIELD_LIST = new FromIntegerFieldList();
	private static final FromIntegerFieldArray FROM_INTEGER_FIELD_ARRAY = new FromIntegerFieldArray();
	private static final FromStringFieldList FROM_STRING_FIELD_LIST = new FromStringFieldList();
	private static final FromStringFieldArray FROM_STRING_FIELD_ARRAY = new FromStringFieldArray();
	
	
	private ToCalendar() {
		super();
	}
	
	
	
	public static final FromCalendar fromCalendar() {
		return FROM_CALENDAR;
	}
	
	public static final FromCalendar fromCalendar(final int truncateField) {
		return new FromCalendar(truncateField);
	}
	
	
	
	public static final FromDate fromDate() {
		return FROM_DATE;
	}
	
	public static final FromDate fromDate(final int truncateField) {
		return new FromDate(truncateField);
	}
	
	
	
	public static final FromTimestamp fromTimestamp() {
		return FROM_TIMESTAMP;
	}
	
	public static final FromTimestamp fromTimestamp(final int truncateField) {
		return new FromTimestamp(truncateField);
	}
	
	
	
	public static final FromTimeInMillis fromTimeInMillis() {
		return FROM_TIMEINMILLIS;
	}
	
	public static final FromTimeInMillis fromTimeInMillis(final int truncateField) {
		return new FromTimeInMillis(truncateField);
	}
	
	
	
	public static final FromString fromString(final String pattern) {
		return new FromString(pattern);
	}
	
	public static final FromString fromString(final String pattern, final Locale locale) {
		return new FromString(pattern, locale);
	}
	
	public static final FromString fromString(final String pattern, final String locale) {
		return new FromString(pattern, locale);
	}
	
	
	
	public static final FromIntegerFieldList fromIntegerFieldList() {
		return FROM_INTEGER_FIELD_LIST;
	}
	
	
	
	public static final FromIntegerFieldArray fromIntegerFieldArray() {
		return FROM_INTEGER_FIELD_ARRAY;
	}
	
	
	
	public static final FromStringFieldList fromStringFieldList() {
		return FROM_STRING_FIELD_LIST;
	}
	
	
	
	public static final FromStringFieldArray fromStringFieldArray() {
		return FROM_STRING_FIELD_ARRAY;
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
		
		return result;		
	}

	
	
	
	
	public static final class FromCalendar extends AbstractFunc<Calendar, Calendar> {
	
		private Integer truncateField = null;
		
		public FromCalendar() {
			super();
		}
		
		public FromCalendar(final int truncateField) {
			super();
			this.truncateField = Integer.valueOf(truncateField);
		}

		public Type<? super Calendar> getResultType() {
			return Types.CALENDAR;
		}

		@Override
        public Calendar doExecute(final Calendar object) throws Exception {
			if (this.truncateField == null) {
				return (Calendar) object.clone();
			}
			return DateUtils.truncate(object, this.truncateField.intValue());
		}
		
	}
	

	
	public static final class FromDate extends AbstractFunc<Calendar, Date> {
	
		private Integer truncateField = null;
		
		public FromDate() {
			super();
		}
		
		public FromDate(final int truncateField) {
			super();
			this.truncateField = Integer.valueOf(truncateField);
		}

		public Type<? super Calendar> getResultType() {
			return Types.CALENDAR;
		}

		@Override
        public Calendar doExecute(final Date object) throws Exception {
			
			final Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(object.getTime());
			
			if (this.truncateField == null) {
				return calendar;
            }
			return DateUtils.truncate(calendar, this.truncateField.intValue());
			
		}
		
	}
	

	
	public static final class FromTimestamp extends AbstractFunc<Calendar, Timestamp> {
	
		private Integer truncateField = null;
		
		public FromTimestamp() {
			super();
		}
		
		public FromTimestamp(final int truncateField) {
			super();
			this.truncateField = Integer.valueOf(truncateField);
		}

		public Type<? super Calendar> getResultType() {
			return Types.CALENDAR;
		}

		@Override
        public Calendar doExecute(final Timestamp object) throws Exception {
			
			final Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(object.getTime());
			
			if (this.truncateField == null) {
				return calendar;
            }
			return DateUtils.truncate(calendar, this.truncateField.intValue());
			
		}
		
	}
	

	
	public static final class FromTimeInMillis extends AbstractFunc<Calendar, Long> {
	
		private Integer truncateField = null;
		
		public FromTimeInMillis() {
			super();
		}
		
		public FromTimeInMillis(final int truncateField) {
			super();
			this.truncateField = Integer.valueOf(truncateField);
		}

		public Type<? super Calendar> getResultType() {
			return Types.CALENDAR;
		}

		@Override
        public Calendar doExecute(final Long object) throws Exception {
			
			final Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(object.longValue());
			
			if (this.truncateField == null) {
				return calendar;
            }
			return DateUtils.truncate(calendar, this.truncateField.intValue());
			
		}
		
	}
	
	
	
	
	public static final class FromString extends AbstractFunc<Calendar, String> {

		private final SimpleDateFormat simpleDateFormat;

		
		public FromString(final String pattern) {
			super();
	        if (StringUtils.contains(pattern, "MMM")) {
                throw new FunctionExecutionException("The use of MMM or MMMM as part of the date pattern requires a Locale");
            }
	        if (StringUtils.contains(pattern, "EEE")) {
	            throw new FunctionExecutionException("The use of EEE or EEEE as part of the date pattern requires a Locale");
	        }
	        this.simpleDateFormat = new SimpleDateFormat(pattern);            
		}
		
		public FromString(final String pattern, final Locale locale) {
			super();
			this.simpleDateFormat = new SimpleDateFormat(pattern, locale);
		}
		
		public FromString(final String pattern, final String locale) {
			super();
			this.simpleDateFormat = new SimpleDateFormat(pattern, LocaleUtils.toLocale(locale));
		}

		
		public Type<? super Calendar> getResultType() {
			return Types.CALENDAR;
		}

		@Override
        public Calendar doExecute(final String object) throws Exception {
			// Calendar is truncated to YEAR to ensure all fields are set to zero before 
			// parsing the string into the new calendar object
			final Calendar calendar = 
				DateUtils.truncate(Calendar.getInstance(), Calendar.YEAR);
			calendar.setTime(this.simpleDateFormat.parse(object));
			return calendar;
		}
		
	}

	
	
	public static final class FromIntegerFieldList extends AbstractFunc<Calendar, List<Integer>> {
		
		
		public FromIntegerFieldList() {
			super();
		}

		public Type<? super Calendar> getResultType() {
			return Types.CALENDAR;
		}

		@Override
        public Calendar doExecute(final List<Integer> object) throws Exception {
			
            if (object.size() != 3 &&  // year, month, day
        		object.size() != 5 &&  // year, month, day, hour, minute
        		object.size() != 6 &&  // year, month, day, hour, minute, second
        		object.size() != 7) {  // year month, day, hour, minute, second, millisecond
                throw new FunctionExecutionException(
                        "Integer arguments array for Calendar conversion should of sizes " +
                        "3 (day,month,year), 5 (+hour,minute), 6 (+second) or 7 (+millisecond). " +
                        "Size " + object.size() + " is not valid.");
            }
            if (object.contains(null)) {
                throw new FunctionExecutionException(
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

	
	
	
	public static final class FromIntegerFieldArray extends AbstractFunc<Calendar, Integer[]> {
		
		
		public FromIntegerFieldArray() {
			super();
		}

		public Type<? super Calendar> getResultType() {
			return Types.CALENDAR;
		}

		@Override
        public Calendar doExecute(final Integer[] object) throws Exception {
			
            if (object.length != 3 &&  // year, month, day
        		object.length != 5 &&  // year, month, day, hour, minute
        		object.length != 6 &&  // year, month, day, hour, minute, second
        		object.length != 7) {  // year month, day, hour, minute, second, millisecond
                throw new FunctionExecutionException(
                        "Integer arguments array for Calendar conversion should of sizes " +
                        "3 (day,month,year), 5 (+hour,minute), 6 (+second) or 7 (+millisecond). " +
                        "Size " + object.length + " is not valid.");
            }
            if (ArrayUtils.contains(object,null)) {
                throw new FunctionExecutionException(
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

	
	
	public static final class FromStringFieldList extends AbstractFunc<Calendar, List<String>> {
		
		
		public FromStringFieldList() {
			super();
		}

		public Type<? super Calendar> getResultType() {
			return Types.CALENDAR;
		}

		@Override
        public Calendar doExecute(final List<String> object) throws Exception {
			
            if (object.size() != 3 &&  // year, month, day
        		object.size() != 5 &&  // year, month, day, hour, minute
        		object.size() != 6 &&  // year, month, day, hour, minute, second
        		object.size() != 7) {  // year month, day, hour, minute, second, millisecond
                throw new FunctionExecutionException(
                        "Integer arguments array for Calendar conversion should of sizes " +
                        "3 (day,month,year), 5 (+hour,minute), 6 (+second) or 7 (+millisecond). " +
                        "Size " + object.size() + " is not valid.");
            }
            if (object.contains(null)) {
                throw new FunctionExecutionException(
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

	
	
	
	public static final class FromStringFieldArray extends AbstractFunc<Calendar, String[]> {
		
		
		public FromStringFieldArray() {
			super();
		}

		public Type<? super Calendar> getResultType() {
			return Types.CALENDAR;
		}

		@Override
        public Calendar doExecute(final String[] object) throws Exception {
			
            if (object.length != 3 &&  // year, month, day
        		object.length != 5 &&  // year, month, day, hour, minute
        		object.length != 6 &&  // year, month, day, hour, minute, second
        		object.length != 7) {  // year month, day, hour, minute, second, millisecond
                throw new FunctionExecutionException(
                        "Integer arguments array for Calendar conversion should of sizes " +
                        "3 (day,month,year), 5 (+hour,minute), 6 (+second) or 7 (+millisecond). " +
                        "Size " + object.length + " is not valid.");
            }
            if (ArrayUtils.contains(object,null)) {
                throw new FunctionExecutionException(
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
