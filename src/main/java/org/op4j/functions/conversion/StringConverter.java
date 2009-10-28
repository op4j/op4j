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
package org.op4j.functions.conversion;

import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
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
 * @author Daniel Fern&aacute;ndez
 * @author Soraya S&aacute;nchez
 *
 */
public final class StringConverter extends Converter {

    private static final long serialVersionUID = -6827019507219840066L;
    
    public static final String ESCAPE_CSV = "ESCAPE_CSV";
    public static final String UNESCAPE_CSV = "UNESCAPE_CSV";
    public static final String ESCAPE_XML = "ESCAPE_XML";
    public static final String UNESCAPE_XML = "UNESCAPE_XML";
    public static final String ESCAPE_JAVASCRIPT = "ESCAPE_JAVASCRIPT";
    public static final String UNESCAPE_JAVASCRIPT = "UNESCAPE_JAVASCRIPT";
    public static final String ESCAPE_HTML = "ESCAPE_HTML";
    public static final String UNESCAPE_HTML = "UNESCAPE_HTML";
    public static final String TO_BASE64 = "TO_BASE64";
    public static final String FROM_BASE64 = "FROM_BASE64";
    public static final String TO_HEXADECIMAL = "TO_HEXADECIMAL";
    public static final String FROM_HEXADECIMAL = "FROM_HEXADECIMAL";
    public static final String TO_JSON = "TO_JSON";
    public static final String TO_UPPERCASE = "TO_UPPERCASE";  
    public static final String TO_LOWERCASE = "TO_LOWERCASE";  
    public static final String UNCAPITALIZE = "UNCAPITALIZE";  
    public static final String CAPITALIZE = "CAPITALIZE";  
    public static final String TRIM = "TRIM";  
    public static final String STRIP = "STRIP";  
    
    private static final TypeScheme LOCALE_STRING_TYPESCHEME =
    	TypeSchemes.forName("Locale, String");
    
    private static final ArgumentsTypeScheme ATS_OBJECT_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.OBJECT_TYPESCHEME, 
            TypeSchemes.EMPTY_TYPESCHEME, 
            "Conversion is performed by simply calling target.toString(). Null is returned for null input");
    
    private static final ArgumentsTypeScheme ATS_CALENDAR_STRING = 
        new ArgumentsTypeScheme(
            TypeSchemes.CALENDAR_TYPESCHEME, 
            TypeSchemes.STRING_TYPESCHEME, 
            "The Calendar is converted based on the pattern given as parameter. Null is returned for null input");
    
    private static final ArgumentsTypeScheme ATS_CALENDAR_LOCALE_STRING = 
        new ArgumentsTypeScheme(
            TypeSchemes.CALENDAR_TYPESCHEME, 
            LOCALE_STRING_TYPESCHEME, 
            "The Calendar is converted based on the pattern given as parameter. Null is returned for null input");
    
    private static final ArgumentsTypeScheme ATS_CALENDAR_LOCALE = 
        new ArgumentsTypeScheme(
            TypeSchemes.CALENDAR_TYPESCHEME, 
            TypeSchemes.LOCALE_TYPESCHEME, 
            "The Calendar is converted based on the locale given as parameter. Null is returned for null input");
    
    private static final ArgumentsTypeScheme ATS_STRING_ESCAPECSVPARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("'" + ESCAPE_CSV + "'"), 
            "The String is returned in a way it can be used to fill in a CSV column as StringEscapeUtils does");
    
    private static final ArgumentsTypeScheme ATS_STRING_UNESCAPECSVPARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("'" + UNESCAPE_CSV + "'"), 
            "The String is returned without the escape characters used to " +
            " include it in a CSV column (i.e. no quotes enclosing it, no escaped quotes) as StringEscapeUtils does");
    
    private static final ArgumentsTypeScheme ATS_STRING_ESCAPEXMLPARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("'" + ESCAPE_XML + "'"), 
            "The String is returned with the XML characters escaped as StringEscapeUtils does");
    
    private static final ArgumentsTypeScheme ATS_STRING_UNESCAPEXMLPARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("'" + UNESCAPE_XML + "'"), 
            "The String is returned without the XML escape characters as StringEscapeUtils does");
    
    private static final ArgumentsTypeScheme ATS_STRING_ESCAPEHTMLPARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("'" + ESCAPE_HTML + "'"), 
            "It escapes the given String using HTML entities (as StringEscapeUtils does)");
    
    private static final ArgumentsTypeScheme ATS_STRING_UNESCAPEHTMLPARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("'" + UNESCAPE_HTML + "'"), 
            "It unescapes the given String and converts its HTML entity escapes into their unicode characters (as StringEscapeUtils does)");
    
    private static final ArgumentsTypeScheme ATS_STRING_ESCAPEJSPARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("'" + ESCAPE_JAVASCRIPT + "'"), 
            "It converts the given String into a JavaScript valid one (as StringEscapeUtils does)");
    
    private static final ArgumentsTypeScheme ATS_STRING_UNESCAPEJSPARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("'" + UNESCAPE_JAVASCRIPT + "'"), 
            "It unescapes the given JavaScript valid String (as StringEscapeUtils does)");
    
    private static final ArgumentsTypeScheme ATS_STRING_CHARSETPARAM_TOBASE64PARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("java.nio.charset.Charset, '" + TO_BASE64 + "'"), 
            "It converts the given String into a base64 encoded one");
    private static final ArgumentsTypeScheme ATS_STRING_CHARSETPARAM_FROMBASE64PARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("java.nio.charset.Charset, '" + FROM_BASE64 + "'"), 
            "It decodes the given base64 encoded String");
    
    private static final ArgumentsTypeScheme ATS_STRING_CHARSETPARAM_TOHEXADECIMALPARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("java.nio.charset.Charset, '" + TO_HEXADECIMAL + "'"), 
            "It converts the given String into its Hexadecimal representation using the specified Charset");
    private static final ArgumentsTypeScheme ATS_STRING_CHARSETPARAM_FROMHEXADECIMALPARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("java.nio.charset.Charset, '" + FROM_HEXADECIMAL + "'"), 
            "The given String is converted from its Hexadecimal representation to a String using the specified Charset");
        
    private static final ArgumentsTypeScheme ATS_STRING_TOUPPERCASEPARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("'" + TO_UPPERCASE + "'"), 
            "It converts the given String to uppercase");
    private static final ArgumentsTypeScheme ATS_STRING_TOLOWERCASEPARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("'" + TO_LOWERCASE + "'"), 
            "It converts the given String to lowercase");
    private static final ArgumentsTypeScheme ATS_STRING_UNCAPITALIZEPARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("'" + UNCAPITALIZE + "'"), 
            "It converts the first letter of the given String to lowercase");
    private static final ArgumentsTypeScheme ATS_STRING_CAPITALIZEPARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("'" + CAPITALIZE + "'"), 
            "It converts the first letter of the given String to uppercase");
    private static final ArgumentsTypeScheme ATS_STRING_TRIMPARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("'" + TRIM + "'"),
            "Removes control characters (char <= 32) from both ends of" +
            " the given String");
    private static final ArgumentsTypeScheme ATS_STRING_STRIPPARAM = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.forName("'" + STRIP + "'"),
            "Strips whitespace from both sides of" +
            " the given String");
    
    public StringConverter() {
        super();
    }


    @Override
    protected final Set<ArgumentsTypeScheme> registerMatchedArgumentTypeSchemes() {
        Set<ArgumentsTypeScheme> matched = new LinkedHashSet<ArgumentsTypeScheme>();
        matched.add(ATS_OBJECT_EMPTY);
        matched.add(ATS_CALENDAR_STRING);
        matched.add(ATS_CALENDAR_LOCALE);
        matched.add(ATS_CALENDAR_LOCALE_STRING);
        matched.add(ATS_STRING_ESCAPECSVPARAM);
        matched.add(ATS_STRING_UNESCAPECSVPARAM);
        matched.add(ATS_STRING_ESCAPEHTMLPARAM);
        matched.add(ATS_STRING_UNESCAPEHTMLPARAM);
        matched.add(ATS_STRING_ESCAPEJSPARAM);
        matched.add(ATS_STRING_UNESCAPEJSPARAM);
        matched.add(ATS_STRING_ESCAPEXMLPARAM);
        matched.add(ATS_STRING_UNESCAPEXMLPARAM);
        matched.add(ATS_STRING_CHARSETPARAM_TOBASE64PARAM);
        matched.add(ATS_STRING_CHARSETPARAM_FROMBASE64PARAM);
        matched.add(ATS_STRING_CHARSETPARAM_TOHEXADECIMALPARAM);
        matched.add(ATS_STRING_CHARSETPARAM_FROMHEXADECIMALPARAM);
        matched.add(ATS_STRING_TOUPPERCASEPARAM);
        matched.add(ATS_STRING_TOLOWERCASEPARAM);
        matched.add(ATS_STRING_UNCAPITALIZEPARAM);
        matched.add(ATS_STRING_CAPITALIZEPARAM);
        matched.add(ATS_STRING_TRIMPARAM);
        matched.add(ATS_STRING_STRIPPARAM);
        return matched;
    }
    
    @Override
    public Type getResultType() {
        return Types.STRING;
    }
        
	@Override
    public Result doExecute(Arguments arguments) throws Exception {
        
        if (arguments.areAllTargetsNull()) {
            return createUniqResult((Object[])null);
        }       
        
        if (ATS_CALENDAR_STRING.matches(arguments)) {
            return createUniqResult(fromCalendar((java.util.Calendar)arguments.getTarget(0),
            		null, arguments.getStringParameter(0)));
        }
        
        if (ATS_CALENDAR_LOCALE.matches(arguments)) {
        	return createUniqResult(fromCalendar((java.util.Calendar)arguments.getTarget(0),
            		arguments.getLocaleParameter(0), null));
        }
        
        if (ATS_CALENDAR_LOCALE_STRING.matches(arguments)) {        	
            return createUniqResult(fromCalendar((java.util.Calendar)arguments.getTarget(0),
            		arguments.getLocaleParameter(0), arguments.getStringParameter(1)));
        }
        
        if (ATS_STRING_ESCAPECSVPARAM.matches(arguments)) {
        	return createUniqResult(StringEscapeUtils.escapeCsv(
        			arguments.getStringTarget(0)));
        }
        if (ATS_STRING_UNESCAPECSVPARAM.matches(arguments)) {
        	return createUniqResult(StringEscapeUtils.unescapeCsv(
        			arguments.getStringTarget(0)));
        }
        if (ATS_STRING_ESCAPEHTMLPARAM.matches(arguments)) {
        	return createUniqResult(StringEscapeUtils.escapeHtml(
        			arguments.getStringTarget(0)));
        }
        if (ATS_STRING_UNESCAPEHTMLPARAM.matches(arguments)) {
        	return createUniqResult(StringEscapeUtils.unescapeHtml(
        			arguments.getStringTarget(0)));
        }
        if (ATS_STRING_ESCAPEJSPARAM.matches(arguments)) {
        	return createUniqResult(StringEscapeUtils.escapeJavaScript(
        			arguments.getStringTarget(0)));
        }
        if (ATS_STRING_UNESCAPEJSPARAM.matches(arguments)) {
        	return createUniqResult(StringEscapeUtils.unescapeJavaScript(
        			arguments.getStringTarget(0)));
        }
        if (ATS_STRING_ESCAPEXMLPARAM.matches(arguments)) {
        	return createUniqResult(StringEscapeUtils.escapeXml(
        			arguments.getStringTarget(0)));
        }
        if (ATS_STRING_UNESCAPEXMLPARAM.matches(arguments)) {
        	return createUniqResult(StringEscapeUtils.unescapeXml(
        			arguments.getStringTarget(0)));
        }
        
        if (ATS_STRING_CHARSETPARAM_TOBASE64PARAM.matches(arguments)) {
        	return createUniqResult(new String(new Base64().encode(arguments.getStringTarget(0).getBytes(
        			((Charset) arguments.getParameter(0)).name())), "US-ASCII"));        	
        }
        
        if (ATS_STRING_CHARSETPARAM_FROMBASE64PARAM.matches(arguments)) {
        	return createUniqResult(new String(new Base64().decode(arguments.getStringTarget(0).getBytes("US-ASCII")), 
        			((Charset) arguments.getParameter(0)).name())); 
        }
        
        if (ATS_STRING_CHARSETPARAM_TOHEXADECIMALPARAM.matches(arguments)) {
        	final byte[] input = arguments.getStringTarget(0)
        		.getBytes(((Charset) arguments.getParameter(0)).name());
        	final StringBuffer output = new StringBuffer();
        	
        	for (byte i = 0; i < input.length; i++) {
    			output.append(Integer.toHexString(input[i]));
    		}
        	
        	return createUniqResult(output.toString());        
        }
        
        if (ATS_STRING_CHARSETPARAM_FROMHEXADECIMALPARAM.matches(arguments)) {
        	final String input = arguments.getStringTarget(0);
        	final StringBuffer output = new StringBuffer();
        	
        	for (int i = 0; i < input.length(); i = i + 2) {
    			final byte current = 
    			    (byte) Integer.parseInt(String.valueOf(input.charAt(i))
    					+ String.valueOf(input.charAt(i + 1)), 16);
    			
    			output.append(new String(new byte[] {current},
    					((Charset) arguments.getParameter(0)).name()));
    		}
        	
        	return createUniqResult(output.toString());        
        }
        
        if (ATS_STRING_TOUPPERCASEPARAM.matches(arguments)) {
        	return createUniqResult(StringUtils.upperCase(
        			arguments.getStringParameter(0)));
        }
        
        if (ATS_STRING_TOLOWERCASEPARAM.matches(arguments)) {
        	return createUniqResult(StringUtils.lowerCase(
        			arguments.getStringParameter(0)));
        }
        
        if (ATS_STRING_UNCAPITALIZEPARAM.matches(arguments)) {
        	return createUniqResult(StringUtils.uncapitalize(
        			arguments.getStringParameter(0)));
        }
        
        if (ATS_STRING_CAPITALIZEPARAM.matches(arguments)) {
        	return createUniqResult(StringUtils.capitalize(
        			arguments.getStringParameter(0)));
        }
        
        if (ATS_STRING_TRIMPARAM.matches(arguments)) {
        	return createUniqResult(StringUtils.trim(
        			arguments.getStringParameter(0)));
        }
        
        if (ATS_STRING_STRIPPARAM.matches(arguments)) {
        	return createUniqResult(StringUtils.strip(
        			arguments.getStringParameter(0)));
        }
        
        return createUniqResult(arguments.getTarget(0).toString());
    }
    
    private String fromCalendar (Calendar calendar, Locale locale, String pattern) {
    	
    	Validate.isTrue((locale != null) 
    			|| (StringUtils.isNotEmpty(pattern)),
    			"Locale or pattern must be set...both are also valid");
    	
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
