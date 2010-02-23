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

    public static final Set set(final int calendarField, final int amount) {
        return new Set(calendarField, amount);
    }
    
    public static final Set setDays(final int amount) {
        return new Set(Calendar.DATE, amount);
    }
    
    public static final Set setHours(final int amount) {
        return new Set(Calendar.HOUR, amount);
    }
    
    public static final Set setMilliseconds(final int amount) {
        return new Set(Calendar.MILLISECOND, amount);
    }
    
    public static final Set setMinutes(final int amount) {
        return new Set(Calendar.MINUTE, amount);
    }
    
    public static final Set setMonths(final int amount) {
        return new Set(Calendar.MONTH, amount);
    }
    
    public static final Set setWeeks(final int amount) {
        return new Set(Calendar.WEEK_OF_YEAR, amount);
    }
    
    public static final Set setYears(final int amount) {
        return new Set(Calendar.YEAR, amount);
    }

    public static final Round round(final int calendarField) {
        return new Round(calendarField);
    }

    public static final Truncate truncate(final int calendarField) {
        return new Truncate(calendarField);
    }
    

	

	
	public static final class Add implements IFunction<Calendar,Calendar> {

	    private final int calendarField;
	    private final int amount;
	    
		public Add(final int calendarField, final int amount) {
			super();
			this.calendarField = calendarField;
			this.amount = amount;
		}

        public Calendar execute(final Calendar input, final ExecCtx ctx) throws Exception {
            final Calendar result = (Calendar) input.clone();
			result.add(this.calendarField, this.amount);
			return result;
		}		
        
	}

    
	
    public static final class Set implements IFunction<Calendar,Calendar> {

        private final int calendarField;
        private final int value;
        
        public Set(final int calendarField, final int value) {
            super();
            this.calendarField = calendarField;
            this.value = value;
        }

        public Calendar execute(final Calendar input, final ExecCtx ctx) throws Exception {
            final Calendar result = (Calendar) input.clone();
            result.set(this.calendarField, this.value);
            return result;
        }       
        
    }

	
    
    public static final class Round implements IFunction<Calendar,Calendar> {

        private final int calendarField;
        
        public Round(final int calendarField) {
            super();
            this.calendarField = calendarField;
        }

        public Calendar execute(final Calendar input, final ExecCtx ctx) throws Exception {
            Calendar result = (Calendar) input.clone();
            result = DateUtils.round(result, this.calendarField);
            return result;
        }       
        
    }

    
    
    public static final class Truncate implements IFunction<Calendar,Calendar> {

        private final int calendarField;
        
        public Truncate(final int calendarField) {
            super();
            this.calendarField = calendarField;
        }

        public Calendar execute(final Calendar input, final ExecCtx ctx) throws Exception {
            Calendar result = (Calendar) input.clone();
            result = DateUtils.truncate(result, this.calendarField);
            return result;
        }       
        
    }
	
}
