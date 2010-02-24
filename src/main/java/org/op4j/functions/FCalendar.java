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

import java.util.Calendar;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.time.DateUtils;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class FCalendar {


    
	private FCalendar() {
		super();           
	}
	
	

	public static final Add add(final int calendarField, final int amount) {
        return new Add(calendarField, amount);
    }
	
    public static final Add addDays(final int amount) {
        return new Add(Calendar.DATE, amount);
    }
    
    public static final Add addHours(final int amount) {
        return new Add(Calendar.HOUR, amount);
    }
    
    public static final Add addMilliseconds(final int amount) {
        return new Add(Calendar.MILLISECOND, amount);
    }
    
    public static final Add addMinutes(final int amount) {
        return new Add(Calendar.MINUTE, amount);
    }
    
    public static final Add addMonths(final int amount) {
        return new Add(Calendar.MONTH, amount);
    }
    
    public static final Add addWeeks(final int amount) {
        return new Add(Calendar.WEEK_OF_YEAR, amount);
    }
    
    public static final Add addYears(final int amount) {
        return new Add(Calendar.YEAR, amount);
    }

    public static final Set set(final int calendarField, final int value) {
        return new Set(calendarField, value);
    }
    
    public static final Set setDay(final int value) {
        return new Set(Calendar.DATE, value);
    }
    
    public static final Set setHour(final int value) {
        return new Set(Calendar.HOUR, value);
    }
    
    public static final Set setMillisecond(final int value) {
        return new Set(Calendar.MILLISECOND, value);
    }
    
    public static final Set setMinute(final int value) {
        return new Set(Calendar.MINUTE, value);
    }
    
    public static final Set setMonth(final int value) {
        return new Set(Calendar.MONTH, value);
    }
    
    public static final Set setWeek(final int value) {
        return new Set(Calendar.WEEK_OF_YEAR, value);
    }
    
    public static final Set setYear(final int value) {
        return new Set(Calendar.YEAR, value);
    }

    public static final Round round(final int calendarField) {
        return new Round(calendarField);
    }

    public static final Truncate truncate(final int calendarField) {
        return new Truncate(calendarField);
    }

    public static final Before before(final Calendar calendar) {
        return new Before(calendar);
    }

    public static final After after(final Calendar calendar) {
        return new After(calendar);
    }
    

	

	
	public static final class Add extends AbstractNotNullFunction<Calendar,Calendar> {

	    private final int calendarField;
	    private final int amount;
	    
		public Add(final int calendarField, final int amount) {
			super();
			this.calendarField = calendarField;
			this.amount = amount;
		}

        public Calendar notNullExecute(final Calendar input, final ExecCtx ctx) throws Exception {
            final Calendar result = (Calendar) input.clone();
			result.add(this.calendarField, this.amount);
			return result;
		}		
        
	}

    
    public static final class Roll extends AbstractNotNullFunction<Calendar,Calendar> {

        private final int calendarField;
        private final int amount;
        
        public Roll(final int calendarField, final int amount) {
            super();
            this.calendarField = calendarField;
            this.amount = amount;
        }

        public Calendar notNullExecute(final Calendar input, final ExecCtx ctx) throws Exception {
            final Calendar result = (Calendar) input.clone();
            result.roll(this.calendarField, this.amount);
            return result;
        }       
        
    }

    
	
    public static final class Set extends AbstractNotNullFunction<Calendar,Calendar> {

        private final int calendarField;
        private final int value;
        
        public Set(final int calendarField, final int value) {
            super();
            this.calendarField = calendarField;
            this.value = value;
        }

        public Calendar notNullExecute(final Calendar input, final ExecCtx ctx) throws Exception {
            final Calendar result = (Calendar) input.clone();
            result.set(this.calendarField, this.value);
            return result;
        }       
        
    }

	
    
    public static final class Round extends AbstractNotNullFunction<Calendar,Calendar> {

        private final int calendarField;
        
        public Round(final int calendarField) {
            super();
            this.calendarField = calendarField;
        }

        public Calendar notNullExecute(final Calendar input, final ExecCtx ctx) throws Exception {
            Calendar result = (Calendar) input.clone();
            result = DateUtils.round(result, this.calendarField);
            return result;
        }       
        
    }

    
    
    public static final class Truncate extends AbstractNotNullFunction<Calendar,Calendar> {

        private final int calendarField;
        
        public Truncate(final int calendarField) {
            super();
            this.calendarField = calendarField;
        }

        public Calendar notNullExecute(final Calendar input, final ExecCtx ctx) throws Exception {
            Calendar result = (Calendar) input.clone();
            result = DateUtils.truncate(result, this.calendarField);
            return result;
        }       
        
    }
    
    
    public static final class Before extends AbstractNotNullFunction<Calendar,Boolean> {

        private final Calendar calendar;
        
        public Before(final Calendar calendar) {
            super();
            Validate.notNull(calendar, "Specified calendar cannot be null");
            this.calendar = calendar;
        }

        public Boolean notNullExecute(final Calendar input, final ExecCtx ctx) throws Exception {
            return input.before(calendar);
        }       
        
    }
    
    
    public static final class After extends AbstractNotNullFunction<Calendar,Boolean> {

        private final Calendar calendar;
        
        public After(final Calendar calendar) {
            super();
            Validate.notNull(calendar, "Specified calendar cannot be null");
            this.calendar = calendar;
        }

        public Boolean notNullExecute(final Calendar input, final ExecCtx ctx) throws Exception {
            return input.after(calendar);
        }       
        
    }
    
}
