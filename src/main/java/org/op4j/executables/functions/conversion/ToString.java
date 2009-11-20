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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.executables.functions.IFunc;
import org.op4j.executables.functions.conversion.ToString.FromCalendar.DateStyle;
import org.op4j.executables.functions.conversion.ToString.FromCalendar.TimeStyle;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class ToString {

	private static final FromObject FROM_OBJECT = new FromObject();

	//TODO Add conversions for java.sql.Date, java.util.Date, numbers
	
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
	}
}
