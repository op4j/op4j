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
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.time.DateUtils;
import org.op4j.executables.functions.conversion.exceptions.ConversionException;
import org.op4j.operation.Arguments;
import org.op4j.operation.ArgumentsTypeScheme;
import org.op4j.operation.Result;
import org.op4j.type.Type;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeScheme;
import org.op4j.typescheme.TypeSchemes;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class CalendarConverter extends Converter {

	private static final long serialVersionUID = 234124839280883047L;

	private static final TypeScheme INT_STRINGPARAM_TYPESCHEME =
		TypeSchemes.forName("Integer,'TRUNCATE'");

    private static final ArgumentsTypeScheme ATS_STRING_PATTERN = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.STRING_TYPESCHEME, 
                "It converts the given String into a Calendar using the given pattern parameter. If" +
                " the pattern includes either, the name of the month or day of week, a conversion" +
                " accepting a Locale must be used instead");
    
    private static final ArgumentsTypeScheme ATS_STRING_PATTERN_LOCALE = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("String, Locale"), 
                "It converts the given String into a Calendar usign the given pattern and Locale parameters");
        
    private static final ArgumentsTypeScheme ATS_JAVAUTILDATE_LOCALE = 
        new ArgumentsTypeScheme(
            TypeSchemes.JAVAUTILDATE_TYPESCHEME, 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given java.util.Date is converted into a Calendar");
    
    private static final ArgumentsTypeScheme ATS_JAVASQLDATE_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.JAVASQLDATE_TYPESCHEME, 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given java.sql.Date is converted into a Calendar");
    
    private static final ArgumentsTypeScheme ATS_TIMESTAMP_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.TIMESTAMP_TYPESCHEME, 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given java.sql.Timestamp is converted into a Calendar");
    
    private static final ArgumentsTypeScheme ATS_LONGTIMESTAMP_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.LONG_TYPESCHEME, 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "The given long representing the time in millis is converted into a Calendar");
    
    private static final ArgumentsTypeScheme ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "A Calendar is created from the given year, month and day. The hour, minute, second and millisecond will be set to 0");
    
    private static final ArgumentsTypeScheme ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "A Calendar is created from the given year, month and day. The hour, minute, second and millisecond will be set to 0");
    
    private static final ArgumentsTypeScheme ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer, Integer"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "A Calendar is created from the given year, month, day, hour and minute. The second and millisecond will be set to 0");
    
    private static final ArgumentsTypeScheme ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String, String"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "A Calendar is created from the given year, month, day, hour and minute. The second and millisecond will be set to 0");
    
    private static final ArgumentsTypeScheme ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer, Integer, Integer"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "A Calendar is created from the given year, month, day, hour, minute and second. The millisecond will be set to 0");
    
    private static final ArgumentsTypeScheme ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String, String, String"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "A Calendar is created from the given year, month, day, hour, minute and second. The millisecond will be set to 0");
    
    private static final ArgumentsTypeScheme ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("Integer, Integer, Integer, Integer, Integer, Integer, Integer"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "A Calendar is created from the given year, month, day, hour, minute, second and millisecond");
    
    private static final ArgumentsTypeScheme ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.forName("String, String, String, String, String, String, String"), 
            TypeSchemes.EMPTY_TYPESCHEME, 
                "A Calendar is created from the given year, month, day, hour, minute, second and millisecond");

    private static final ArgumentsTypeScheme ATS_JAVAUTILDATE_INT_STRINGPARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.JAVAUTILDATE_TYPESCHEME, 
            INT_STRINGPARAM_TYPESCHEME, 
            "It truncates a Date in order to leave the given field as" +
            " the most significant one");
    
    private static final ArgumentsTypeScheme ATS_CALENDAR_INT_STRINGPARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.CALENDAR_TYPESCHEME, 
            INT_STRINGPARAM_TYPESCHEME, 
                "It truncates a Calendar in order to leave the given field as" +
                " the most significant one");
    
    private static final ArgumentsTypeScheme ATS_JAVASQLDATE_INT_STRINGPARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.JAVASQLDATE_TYPESCHEME, 
            INT_STRINGPARAM_TYPESCHEME, 
                "It truncates a Date in order to leave the given field as" +
                " the most significant one");
	
    private static final ArgumentsTypeScheme ATS_TIMESTAMP_INT_STRINGPARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.TIMESTAMP_TYPESCHEME, 
            INT_STRINGPARAM_TYPESCHEME, 
                "It truncates a Timestamp in order to leave the given field as" +
                " the most significant one");
    
    public CalendarConverter() {
        super();
    }

    
    @Override
    protected Set<ArgumentsTypeScheme> registerMatchedArgumentTypeSchemes() {
        final Set<ArgumentsTypeScheme> matched = new LinkedHashSet<ArgumentsTypeScheme>();
        matched.add(ATS_STRING_PATTERN);
        matched.add(ATS_STRING_PATTERN_LOCALE);
        matched.add(ATS_JAVAUTILDATE_LOCALE);
        matched.add(ATS_JAVASQLDATE_EMPTY);
        matched.add(ATS_TIMESTAMP_EMPTY);
        matched.add(ATS_LONGTIMESTAMP_EMPTY);
        matched.add(ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_EMPTY);
        matched.add(ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_EMPTY);
        matched.add(ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_EMPTY);
        matched.add(ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_EMPTY);
        matched.add(ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_EMPTY);
        matched.add(ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_EMPTY);
        matched.add(ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_EMPTY);
        matched.add(ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_EMPTY);
        matched.add(ATS_JAVAUTILDATE_INT_STRINGPARAM);
        matched.add(ATS_CALENDAR_INT_STRINGPARAM);
        matched.add(ATS_JAVASQLDATE_INT_STRINGPARAM);
        matched.add(ATS_TIMESTAMP_INT_STRINGPARAM);
        return matched;
    }
    
    
    
    @Override
    public Type getResultType() {
        return Types.CALENDAR;
    }
    

    @Override
	protected Result doExecute(final Arguments arguments) throws Exception {
		    	    
        if (arguments.areAllTargetsNull()) {
            return createUniqResult((Object[])null);
        }
		
		if (ATS_STRING_PATTERN.matches(arguments)) {
            return createUniqResult(fromString(arguments.getStringTarget(0), arguments.getStringParameter(0), null));
        }
		
		if (ATS_STRING_PATTERN_LOCALE.matches(arguments)) {
            return createUniqResult(fromString(arguments.getStringTarget(0), arguments.getStringParameter(0), arguments.getLocaleParameter(1)));
        }
        
        if (ATS_JAVAUTILDATE_LOCALE.matches(arguments)) {
            return createUniqResult(fromLong(((java.util.Date)arguments.getTarget(0)).getTime()));
        }
		
		if (ATS_JAVASQLDATE_EMPTY.matches(arguments)) {
            return createUniqResult(fromLong(((java.sql.Date)arguments.getTarget(0)).getTime()));
        }
		
		if (ATS_TIMESTAMP_EMPTY.matches(arguments)) {
            return createUniqResult(fromLong(((java.sql.Timestamp)arguments.getTarget(0)).getTime()));
        }
		
		if (ATS_LONGTIMESTAMP_EMPTY.matches(arguments)) {
            return createUniqResult(fromLong(arguments.getLongTarget(0).longValue()));
        }
		
		if (ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					Integer.valueOf(0), 
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(0)));
        }
		if (ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(arguments.getStringTarget(2)),
					Integer.valueOf(0), 
					Integer.valueOf(0),
					Integer.valueOf(0),
					Integer.valueOf(0)));
        }
		
		if (ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					arguments.getIntegerTarget(3),
					arguments.getIntegerTarget(4),
					Integer.valueOf(0),
					Integer.valueOf(0)));
        }
		if (ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(arguments.getStringTarget(2)),
					Integer.valueOf(arguments.getStringTarget(3)),
					Integer.valueOf(arguments.getStringTarget(4)),
					Integer.valueOf(0),
					Integer.valueOf(0)));
        }
		
		if (ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					arguments.getIntegerTarget(3),
					arguments.getIntegerTarget(4),
					arguments.getIntegerTarget(5),
					Integer.valueOf(0)));
        }
		if (ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					Integer.valueOf(arguments.getStringTarget(0)),
					Integer.valueOf(arguments.getStringTarget(1)),
					Integer.valueOf(arguments.getStringTarget(2)),
					Integer.valueOf(arguments.getStringTarget(3)),
					Integer.valueOf(arguments.getStringTarget(4)),
					Integer.valueOf(arguments.getStringTarget(5)),
					Integer.valueOf(0)));
        }
		
		if (ATS_INTEGERYEAR_INTEGERMONTH_INTEGERDAY_INTEGERHOUR_INTEGERMINUTE_INTEGERSECOND_INTEGERMILLISECOND_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
					arguments.getIntegerTarget(0),
					arguments.getIntegerTarget(1),
					arguments.getIntegerTarget(2),
					arguments.getIntegerTarget(3),
					arguments.getIntegerTarget(4),
					arguments.getIntegerTarget(5),
					arguments.getIntegerTarget(6)));
        }
		if (ATS_STRINGYEAR_STRINGMONTH_STRINGDAY_STRINGHOUR_STRINGMINUTE_STRINGSECOND_STRINGMILLISECOND_EMPTY.matches(arguments)) {
			return createUniqResult(fromInts(
			        Integer.valueOf(arguments.getStringTarget(0)),
			        Integer.valueOf(arguments.getStringTarget(1)),
			        Integer.valueOf(arguments.getStringTarget(2)),
			        Integer.valueOf(arguments.getStringTarget(3)),
			        Integer.valueOf(arguments.getStringTarget(4)),
			        Integer.valueOf(arguments.getStringTarget(5)),
			        Integer.valueOf(arguments.getStringTarget(6))));
        }
		
		if (ATS_JAVAUTILDATE_INT_STRINGPARAM.matches(arguments)) {
		    final Date javaUtilDate = (Date) arguments.getTarget(0);
		    final Calendar calendar = Calendar.getInstance();
			calendar.setTime(javaUtilDate);
			
			return createUniqResult(truncateFromCalendar(calendar, 
					arguments.getIntegerParameter(0).intValue()));
		}
		if (ATS_CALENDAR_INT_STRINGPARAM.matches(arguments)) {
			return createUniqResult(truncateFromCalendar((Calendar) arguments.getTarget(0), 
					arguments.getIntegerParameter(0).intValue()));
		}
		if (ATS_JAVASQLDATE_INT_STRINGPARAM.matches(arguments)) {
		    final java.sql.Date javaSqlDate = (java.sql.Date) arguments.getTarget(0);
		    final Calendar calendar = Calendar.getInstance();
			calendar.setTime(javaSqlDate);
			
			return createUniqResult(truncateFromCalendar(calendar, 
					arguments.getIntegerParameter(0).intValue()));
		}
		if (ATS_TIMESTAMP_INT_STRINGPARAM.matches(arguments)) {
		    final Timestamp timestamp = (Timestamp) arguments.getTarget(0);
		    final Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(timestamp.getTime());
			
			return createUniqResult(truncateFromCalendar(calendar, 
					arguments.getIntegerParameter(0).intValue()));
		}
        
		return null;
	}
	
    private Calendar truncateFromCalendar(final Calendar calendar, final int field) {
    	return DateUtils.truncate(calendar, field);
    }
    
	private Calendar fromString(final String asString, final String pattern, final Locale locale) 
		throws Exception {
		
	    SimpleDateFormat sdf = null;
	    if (locale == null) {
	        if (StringUtils.contains(pattern, "MMM")) {
                throw new ConversionException("The use of MMM or MMMM as part of the date pattern requires a Locale");
            }
	        if (StringUtils.contains(pattern, "EEE")) {
	            throw new ConversionException("The use of EEE or EEEE as part of the date pattern requires a Locale");
	        }
	        sdf = new SimpleDateFormat(pattern);            
	    } else {    
	        sdf = new SimpleDateFormat(pattern, locale);
	    }
	    
		Calendar result = Calendar.getInstance();
		result = DateUtils.truncate(result, Calendar.YEAR);
		
		result.setTime(sdf.parse(asString));
		
		return result;		
	}
		
	private Calendar fromLong(final long asLong) 
		throws Exception {

	    final Calendar result = Calendar.getInstance();

		result.setTimeInMillis(asLong);

		return result;		
	}
	
	private Calendar fromInts(final Integer year, final Integer month, final Integer day, 
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
		setIntoCalendar(result,Calendar.YEAR, safeYear);
		setIntoCalendar(result,Calendar.MONTH, month);
		setIntoCalendar(result,Calendar.DAY_OF_MONTH, day);
		setIntoCalendar(result,Calendar.HOUR_OF_DAY, hour);
		setIntoCalendar(result,Calendar.MINUTE, minute);
		setIntoCalendar(result,Calendar.SECOND, second);
		setIntoCalendar(result,Calendar.MILLISECOND, milli);
		
		return result;		
	}

	
	private void setIntoCalendar(final Calendar calendar, final int field, final Integer value) {
	    if (value != null) {
	        if (field == Calendar.MONTH) {
                calendar.set(field, value.intValue() - 1);
	        } else {
	            calendar.set(field, value.intValue());
	        }
	    }
	}
	
}
