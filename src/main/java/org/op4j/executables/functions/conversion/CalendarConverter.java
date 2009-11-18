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

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.time.DateUtils;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.FunctionExecutionException;
import org.op4j.executables.functions.FunctionArgumentScheme;
import org.op4j.executables.functions.FunctionArguments;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class CalendarConverter extends ConverterImplementation<Calendar> {

	private static final long serialVersionUID = 234124839280883047L;

	
	
	
	
    private static final FunctionArgumentScheme SCH_STRING_PATTERN = 
        FunctionArgumentScheme.from(
            "It converts the given String into a Calendar using the given pattern parameter. If" +
            " the pattern includes either, the name of the month or day of week, a conversion" +
            " accepting a Locale must be used instead",
            Types.STRING, 
            "String");
    
    private static final FunctionArgumentScheme SCH_STRING_PATTERN_LOCALE = 
        FunctionArgumentScheme.from(
            "It converts the given String into a Calendar usign the given pattern and Locale parameters",
            Types.STRING, 
            "String, Locale");
        
    private static final FunctionArgumentScheme SCH_JAVAUTILDATE_LOCALE = 
        FunctionArgumentScheme.from(
            "The given java.util.Date is converted into a Calendar",
            Types.DATE);
    
    private static final FunctionArgumentScheme SCH_JAVASQLDATE = 
        FunctionArgumentScheme.from(
            "The given java.sql.Date is converted into a Calendar",
            Types.forClass(java.sql.Date.class));
    
    private static final FunctionArgumentScheme SCH_TIMESTAMP = 
        FunctionArgumentScheme.from(
            "The given java.sql.Timestamp is converted into a Calendar",
            Types.forClass(java.sql.Timestamp.class));
    
    private static final FunctionArgumentScheme SCH_LONGTIMESTAMP = 
        FunctionArgumentScheme.from(
            "The given long representing the time in millis is converted into a Calendar",
            Types.LONG);
    
    private static final FunctionArgumentScheme SCH_INTEGERARRAY = 
        FunctionArgumentScheme.from(
            "A Calendar is created from the given integer array. This can contain: [year, month, day], " +
            "[year, month, day, hour, minute], [year, month, day, hour, minute, second] or " +
            "[year, month, day, hour, minute, second, millisecond]. The unspecified components will be set to 0",
            Types.ARRAY_OF_INTEGER);
    
    private static final FunctionArgumentScheme SCH_STRINGARRAY = 
        FunctionArgumentScheme.from(
            "A Calendar is created from the given integer array. This can contain: [year, month, day], " +
            "[year, month, day, hour, minute], [year, month, day, hour, minute, second] or " +
            "[year, month, day, hour, minute, second, millisecond]. The unspecified components will be set to 0",
            Types.ARRAY_OF_STRING);

    private static final FunctionArgumentScheme SCH_JAVAUTILDATE_INT_STRINGPARAM = 
        FunctionArgumentScheme.from(
            "It truncates a Date in order to leave the given field as" +
            " the most significant one",
            Types.DATE, 
            "Integer,'TRUNCATE'");
    
    private static final FunctionArgumentScheme SCH_CALENDAR_INT_STRINGPARAM = 
        FunctionArgumentScheme.from(
            "It truncates a Calendar in order to leave the given field as" +
            " the most significant one",
            Types.CALENDAR, 
            "Integer,'TRUNCATE'");
    
    private static final FunctionArgumentScheme SCH_JAVASQLDATE_INT_STRINGPARAM = 
        FunctionArgumentScheme.from(
            "It truncates a Date in order to leave the given field as" +
            " the most significant one",
            Types.forClass(java.sql.Date.class), 
            "Integer,'TRUNCATE'");
	
    private static final FunctionArgumentScheme SCH_TIMESTAMP_INT_STRINGPARAM = 
        FunctionArgumentScheme.from(
            "It truncates a Timestamp in order to leave the given field as" +
            " the most significant one",
            Types.forClass(Timestamp.class),
            "Integer,'TRUNCATE'");
    
    
    
    
    
    public CalendarConverter() {
        super();
    }
    

    
    
    
    @Override
    protected Set<FunctionArgumentScheme> registerMatchedSchemes() {
        final Set<FunctionArgumentScheme> matched = new LinkedHashSet<FunctionArgumentScheme>();
        matched.add(SCH_STRING_PATTERN);
        matched.add(SCH_STRING_PATTERN_LOCALE);
        matched.add(SCH_JAVAUTILDATE_LOCALE);
        matched.add(SCH_JAVASQLDATE);
        matched.add(SCH_TIMESTAMP);
        matched.add(SCH_LONGTIMESTAMP);
        matched.add(SCH_INTEGERARRAY);
        matched.add(SCH_STRINGARRAY);
        matched.add(SCH_JAVAUTILDATE_INT_STRINGPARAM);
        matched.add(SCH_CALENDAR_INT_STRINGPARAM);
        matched.add(SCH_JAVASQLDATE_INT_STRINGPARAM);
        matched.add(SCH_TIMESTAMP_INT_STRINGPARAM);
        return matched;
    }
    





    @Override
    protected Type<Calendar> registerResultType() {
        return Types.CALENDAR;
    }


    
    
    @Override
    public Calendar execute(final FunctionArguments arguments) throws Exception {
        
		    	    
        if (arguments.isTargetNull()) {
            return null;
        }
		
		if (SCH_STRING_PATTERN.matches(arguments)) {
            return fromString(arguments.getTargetAsString(), arguments.getStringParameter(0), null);
        }
		
		if (SCH_STRING_PATTERN_LOCALE.matches(arguments)) {
            return fromString(arguments.getTargetAsString(), arguments.getStringParameter(0), arguments.getLocaleParameter(1));
        }
        
        if (SCH_JAVAUTILDATE_LOCALE.matches(arguments)) {
            return fromLong(((java.util.Date)arguments.getTarget()).getTime());
        }
		
		if (SCH_JAVASQLDATE.matches(arguments)) {
            return fromLong(((java.sql.Date)arguments.getTarget()).getTime());
        }
		
		if (SCH_TIMESTAMP.matches(arguments)) {
            return fromLong(((java.sql.Timestamp)arguments.getTarget()).getTime());
        }
		
		if (SCH_LONGTIMESTAMP.matches(arguments)) {
            return fromLong(arguments.getTargetAsLong().longValue());
        }
        
        if (SCH_INTEGERARRAY.matches(arguments)) {
            final Integer[] target = (Integer[]) arguments.getTarget();
            if (target.length != 3 &&  // year, month, day
                target.length != 5 &&  // year, month, day, hour, minute
                target.length != 6 &&  // year, month, day, hour, minute, second
                target.length != 7) {  // year month, day, hour, minute, second, millisecond
                throw new FunctionExecutionException(
                        "Integer arguments array for Calendar conversion should of sizes " +
                        "3 (day,month,year), 5 (+hour,minute), 6 (+second) or 7 (+millisecond). " +
                        "Size " + target.length + " is not valid.");
            }
            if (ArrayUtils.contains(target, null)) {
                throw new FunctionExecutionException(
                        "Integer arguments array for Calendar conversion should not contain nulls.");
            }
            return fromInts(
                    target[0],
                    target[1],
                    target[2],
                    (target.length >= 5? target[3] : Integer.valueOf(0)), 
                    (target.length >= 5? target[4] : Integer.valueOf(0)),
                    (target.length >= 6? target[5] : Integer.valueOf(0)),
                    (target.length == 7? target[6] : Integer.valueOf(0)));
        }
        
        if (SCH_STRINGARRAY.matches(arguments)) {
            final String[] target = (String[]) arguments.getTarget();
            if (target.length != 3 &&  // year, month, day
                target.length != 5 &&  // year, month, day, hour, minute
                target.length != 6 &&  // year, month, day, hour, minute, second
                target.length != 7) {  // year month, day, hour, minute, second, millisecond
                throw new FunctionExecutionException(
                        "String arguments array for Calendar conversion should of sizes " +
                        "3 (day,month,year), 5 (+hour,minute), 6 (+second) or 7 (+millisecond). " +
                        "Size " + target.length + " is not valid.");
            }
            if (ArrayUtils.contains(target, null)) {
                throw new FunctionExecutionException(
                        "String arguments array for Calendar conversion should not contain nulls.");
            }
            return fromInts(
                    Integer.valueOf(target[0]),
                    Integer.valueOf(target[1]),
                    Integer.valueOf(target[2]),
                    (target.length >= 5? Integer.valueOf(target[3]) : Integer.valueOf(0)), 
                    (target.length >= 5? Integer.valueOf(target[4]) : Integer.valueOf(0)),
                    (target.length >= 6? Integer.valueOf(target[5]) : Integer.valueOf(0)),
                    (target.length == 7? Integer.valueOf(target[6]) : Integer.valueOf(0)));
        }
		
		if (SCH_JAVAUTILDATE_INT_STRINGPARAM.matches(arguments)) {
		    final Date javaUtilDate = (Date) arguments.getTarget();
		    final Calendar calendar = Calendar.getInstance();
			calendar.setTime(javaUtilDate);
			
			return truncateFromCalendar(calendar, 
					arguments.getIntegerParameter(0).intValue());
		}
		if (SCH_CALENDAR_INT_STRINGPARAM.matches(arguments)) {
			return truncateFromCalendar((Calendar) arguments.getTarget(), 
					arguments.getIntegerParameter(0).intValue());
		}
		if (SCH_JAVASQLDATE_INT_STRINGPARAM.matches(arguments)) {
		    final java.sql.Date javaSqlDate = (java.sql.Date) arguments.getTarget();
		    final Calendar calendar = Calendar.getInstance();
			calendar.setTime(javaSqlDate);
			
			return truncateFromCalendar(calendar, 
					arguments.getIntegerParameter(0).intValue());
		}
		if (SCH_TIMESTAMP_INT_STRINGPARAM.matches(arguments)) {
		    final Timestamp timestamp = (Timestamp) arguments.getTarget();
		    final Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(timestamp.getTime());
			
			return truncateFromCalendar(calendar, 
					arguments.getIntegerParameter(0).intValue());
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
                throw new FunctionExecutionException("The use of MMM or MMMM as part of the date pattern requires a Locale");
            }
	        if (StringUtils.contains(pattern, "EEE")) {
	            throw new FunctionExecutionException("The use of EEE or EEEE as part of the date pattern requires a Locale");
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
		result.set(Calendar.YEAR, safeYear.intValue());
		result.set(Calendar.MONTH, month.intValue() - 1);
		result.set(Calendar.DAY_OF_MONTH, day.intValue());
		result.set(Calendar.HOUR_OF_DAY, hour.intValue());
		result.set(Calendar.MINUTE, minute.intValue());
		result.set(Calendar.SECOND, second.intValue());
		result.set(Calendar.MILLISECOND, milli.intValue());
		
		return result;		
	}
	
}
