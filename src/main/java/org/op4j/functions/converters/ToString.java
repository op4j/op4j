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

package org.op4j.functions.converters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.op4j.functions.AbstractNullAsNullFunction;
import org.op4j.functions.DateStyle;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.TimeStyle;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class ToString {

	private ToString() {
		super();
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
	
	
	
	public static final class FromDate extends AbstractNullAsNullFunction<java.util.Date,String>  {

		private DateStyle dateStyle = null;	
		private TimeStyle timeStyle = null;	
		private Locale locale = null;
		private String pattern = null;
		
		public FromDate(String pattern) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			
			this.pattern = pattern;
		}
		
		public FromDate(String pattern, Locale locale) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notNull(locale, "locale can't be null");
			
			this.pattern = pattern;
			this.locale = locale;			
		}
		
		public FromDate(String pattern, String locale) {
			super();
			
			Validate.notEmpty(pattern, "pattern can't be neither empty nor null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.pattern = pattern;
			this.locale = LocaleUtils.toLocale(locale);
		}
				
		public FromDate(DateStyle dateStyle, TimeStyle timeStyle) {
			super();
			
			Validate.notNull(dateStyle, "dateStyle can't be null");
			Validate.notNull(timeStyle, "timeStyle can't be null");
			
			this.dateStyle = dateStyle;
			this.timeStyle = timeStyle;
		}
		
		public FromDate(DateStyle dateStyle, TimeStyle timeStyle, Locale locale) {
			super();
			
			Validate.notNull(dateStyle, "dateStyle can't be null");
			Validate.notNull(timeStyle, "timeStyle can't be null");
			Validate.notNull(locale, "locale can't be null");
			
			this.dateStyle = dateStyle;
			this.timeStyle = timeStyle;
			this.locale = locale;
		}
		
		public FromDate(DateStyle dateStyle, TimeStyle timeStyle, String locale) {
			super();
			
			Validate.notNull(dateStyle, "dateStyle can't be null");
			Validate.notNull(timeStyle, "timeStyle can't be null");
			Validate.notEmpty(locale, "locale can't be neither empty nor null");
			
			this.dateStyle = dateStyle;
			this.timeStyle = timeStyle;
			this.locale = LocaleUtils.toLocale(locale);
		}

        @Override
		public String nullAsNullExecute(final Date date, final ExecCtx ctx) throws Exception {
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
