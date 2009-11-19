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

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.executables.functions.IFunc;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class ToString {

	private static final FromObject FROM_OBJECT = new FromObject();

	
	private ToString() {
		super();
	}
	
	
	public static final FromObject fromObject() {
		return FROM_OBJECT;
	}
	
	public static final FromCalendar fromCalendar(String pattern) {
		return new FromCalendar(pattern);
	}
	
	public static final FromCalendar fromCalendar(Locale locale) {
		return new FromCalendar(locale);
	}
	
	public static final FromCalendar fromCalendar(Locale locale, String pattern) {
		return new FromCalendar(locale, pattern);
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

		private Locale locale = null;
		private String pattern = null;
		
		public FromCalendar(String pattern) {
			super();
			this.pattern = pattern;
		}
		
		public FromCalendar(Locale locale) {
			super();
			this.locale = locale;
		}
		
		public FromCalendar(Locale locale, String pattern) {
			super();
			this.locale = locale;
			this.pattern = pattern;
		}
		
		public Type<? super String> getResultType() {
			return Types.STRING;
		}

		public String execute(final Calendar calendar) throws Exception {
			return fromCalendar(
                    calendar,
                    this.locale, 
                    this.pattern);
		}
		
		private String fromCalendar(final Calendar calendar, final Locale locale, final String pattern) {
	    	
	    	Validate.isTrue((locale != null) 
	    			|| (StringUtils.isNotEmpty(pattern)),
	    			"Either locale or pattern must be set...both are also valid");
	    	
	    	DateFormat sdf = null;
	    	if (locale == null) {
	    		sdf = new SimpleDateFormat(pattern);
	    	} else {
	    		if (StringUtils.isEmpty(pattern)) {
	    			sdf = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    		} else {
	    			sdf = new SimpleDateFormat(pattern, locale);
	    		}
	    	}
	    	
	    	return sdf.format(calendar.getTime());
	    }		
	}
}
