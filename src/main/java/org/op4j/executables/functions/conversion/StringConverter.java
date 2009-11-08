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
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.executables.functions.FunctionArgumentScheme;
import org.op4j.executables.functions.FunctionArguments;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * @author Soraya S&aacute;nchez
 *
 */
public final class StringConverter extends ConverterImplementation<String> {
    
    public static final String ESCAPE_CSV = "'ESCAPE_CSV'";
    public static final String UNESCAPE_CSV = "'UNESCAPE_CSV'";
    public static final String ESCAPE_XML = "'ESCAPE_XML'";
    public static final String UNESCAPE_XML = "'UNESCAPE_XML'";
    public static final String ESCAPE_JAVASCRIPT = "'ESCAPE_JAVASCRIPT'";
    public static final String UNESCAPE_JAVASCRIPT = "'UNESCAPE_JAVASCRIPT'";
    public static final String ESCAPE_HTML = "'ESCAPE_HTML'";
    public static final String UNESCAPE_HTML = "'UNESCAPE_HTML'";
    public static final String TO_BASE64 = "'TO_BASE64'";
    public static final String FROM_BASE64 = "'FROM_BASE64'";
    public static final String TO_HEXADECIMAL = "'TO_HEXADECIMAL'";
    public static final String FROM_HEXADECIMAL = "'FROM_HEXADECIMAL'";
    public static final String TO_JSON = "'TO_JSON'";
    public static final String TO_UPPERCASE = "'TO_UPPERCASE'";  
    public static final String TO_LOWERCASE = "'TO_LOWERCASE'";  
    public static final String UNCAPITALIZE = "'UNCAPITALIZE'";  
    public static final String CAPITALIZE = "'CAPITALIZE'";  
    public static final String TRIM = "'TRIM'";  
    public static final String STRIP = "'STRIP'";  

    
    private static final FunctionArgumentScheme<Object> SCH_OBJECT = 
        FunctionArgumentScheme.from(
            "Conversion is performed by simply calling target.toString(). Null is returned for null input",
            Types.OBJECT);
    
    private static final FunctionArgumentScheme<Calendar> SCH_CALENDAR_STRING = 
        FunctionArgumentScheme.from(
            "The Calendar is converted based on the pattern given as parameter. Null is returned for null input",
            Types.CALENDAR,
            "String pattern");
    
    private static final FunctionArgumentScheme<Calendar> SCH_CALENDAR_LOCALE_STRING = 
        FunctionArgumentScheme.from(
            "The Calendar is converted based on the pattern given as parameter. Null is returned for null input",
            Types.CALENDAR, 
            "Locale locale, String pattern");
    
    private static final FunctionArgumentScheme<Calendar> SCH_CALENDAR_LOCALE = 
        FunctionArgumentScheme.from(
            "The Calendar is converted based on the locale given as parameter. Null is returned for null input",
            Types.CALENDAR,
            "Locale locale");
    
    private static final FunctionArgumentScheme<String> SCH_STRING_ESCAPECSV = 
        FunctionArgumentScheme.from(
            "The String is returned in a way it can be used to fill in a CSV column as StringEscapeUtils does",
            Types.STRING, 
            ESCAPE_CSV);
    
    private static final FunctionArgumentScheme<String> SCH_STRING_UNESCAPECSV = 
        FunctionArgumentScheme.from(
            "The String is returned without the escape characters used to " +
            " include it in a CSV column (i.e. no quotes enclosing it, no escaped quotes) as StringEscapeUtils does",
            Types.STRING, 
            UNESCAPE_CSV);
    
    private static final FunctionArgumentScheme<String> SCH_STRING_ESCAPEXML = 
        FunctionArgumentScheme.from(
            "The String is returned with the XML characters escaped as StringEscapeUtils does",
            Types.STRING, 
            ESCAPE_XML);
    
    private static final FunctionArgumentScheme<String> SCH_STRING_UNESCAPEXML = 
        FunctionArgumentScheme.from(
            "The String is returned without the XML escape characters as StringEscapeUtils does",
            Types.STRING, 
            UNESCAPE_XML);
    
    private static final FunctionArgumentScheme<String> SCH_STRING_ESCAPEHTML = 
        FunctionArgumentScheme.from(
            "It escapes the given String using HTML entities (as StringEscapeUtils does)",
            Types.STRING, 
            ESCAPE_HTML);
    
    private static final FunctionArgumentScheme<String> SCH_STRING_UNESCAPEHTML = 
        FunctionArgumentScheme.from(
            "It unescapes the given String and converts its HTML entity escapes into their unicode characters (as StringEscapeUtils does)",
            Types.STRING, 
            UNESCAPE_HTML);
    
    private static final FunctionArgumentScheme<String> SCH_STRING_ESCAPEJS = 
        FunctionArgumentScheme.from(
            "It converts the given String into a JavaScript valid one (as StringEscapeUtils does)",
            Types.STRING, 
            ESCAPE_JAVASCRIPT);
    
    private static final FunctionArgumentScheme<String> SCH_STRING_UNESCAPEJS = 
        FunctionArgumentScheme.from(
            "It unescapes the given JavaScript valid String (as StringEscapeUtils does)",
            Types.STRING, 
            UNESCAPE_JAVASCRIPT);
    
    private static final FunctionArgumentScheme<String> SCH_STRING_CHARSET_TOBASE64 = 
        FunctionArgumentScheme.from(
            "It converts the given String into a base64 encoded one",
            Types.STRING, 
            "java.nio.charset.Charset," + TO_BASE64);
    
    private static final FunctionArgumentScheme<String> SCH_STRING_CHARSET_FROMBASE64 = 
        FunctionArgumentScheme.from(
            "It decodes the given base64 encoded String",
            Types.STRING, 
            "java.nio.charset.Charset," + FROM_BASE64);
    
    private static final FunctionArgumentScheme<String> SCH_STRING_CHARSET_TOHEXADECIMAL = 
        FunctionArgumentScheme.from(
            "It converts the given String into its Hexadecimal representation using the specified Charset",
            Types.STRING, 
            "java.nio.charset.Charset," + TO_HEXADECIMAL);
    
    private static final FunctionArgumentScheme<String> SCH_STRING_CHARSET_FROMHEXADECIMAL = 
        FunctionArgumentScheme.from(
            "The given String is converted from its Hexadecimal representation to a String using the specified Charset",
            Types.STRING, 
            "java.nio.charset.Charset," + FROM_HEXADECIMAL);
        
    private static final FunctionArgumentScheme<String> SCH_STRING_TOUPPERCASE = 
        FunctionArgumentScheme.from(
            "It converts the given String to uppercase",
            Types.STRING, 
            TO_UPPERCASE);
    
    private static final FunctionArgumentScheme<String> SCH_STRING_TOLOWERCASE = 
        FunctionArgumentScheme.from(
            "It converts the given String to lowercase",
            Types.STRING, 
            TO_LOWERCASE);
    
    private static final FunctionArgumentScheme<String> SCH_STRING_UNCAPITALIZE = 
        FunctionArgumentScheme.from(
            "It converts the first letter of the given String to lowercase",
            Types.STRING, 
            UNCAPITALIZE);
    
    private static final FunctionArgumentScheme<String> SCH_STRING_CAPITALIZE = 
        FunctionArgumentScheme.from(
            "It converts the first letter of the given String to uppercase",
            Types.STRING, 
            CAPITALIZE);
    
    private static final FunctionArgumentScheme<String> SCH_STRING_TRIM = 
        FunctionArgumentScheme.from(
            "Removes control characters (char <= 32) from both ends of the given String",
            Types.STRING, 
            TRIM);
    
    private static final FunctionArgumentScheme<String> SCH_STRING_STRIP = 
        FunctionArgumentScheme.from(
            "Strips whitespace from both sides of the given String",
            Types.STRING, 
            STRIP);
    
    
    
    public StringConverter() {
        super();
    }


    
    
    @Override
    protected Set<FunctionArgumentScheme<? extends Object>> registerMatchedSchemes() {
        Set<FunctionArgumentScheme<? extends Object>> matched = new LinkedHashSet<FunctionArgumentScheme<? extends Object>>();
        matched.add(SCH_OBJECT);
        matched.add(SCH_CALENDAR_STRING);
        matched.add(SCH_CALENDAR_LOCALE);
        matched.add(SCH_CALENDAR_LOCALE_STRING);
        matched.add(SCH_STRING_ESCAPECSV);
        matched.add(SCH_STRING_UNESCAPECSV);
        matched.add(SCH_STRING_ESCAPEHTML);
        matched.add(SCH_STRING_UNESCAPEHTML);
        matched.add(SCH_STRING_ESCAPEJS);
        matched.add(SCH_STRING_UNESCAPEJS);
        matched.add(SCH_STRING_ESCAPEXML);
        matched.add(SCH_STRING_UNESCAPEXML);
        matched.add(SCH_STRING_CHARSET_TOBASE64);
        matched.add(SCH_STRING_CHARSET_FROMBASE64);
        matched.add(SCH_STRING_CHARSET_TOHEXADECIMAL);
        matched.add(SCH_STRING_CHARSET_FROMHEXADECIMAL);
        matched.add(SCH_STRING_TOUPPERCASE);
        matched.add(SCH_STRING_TOLOWERCASE);
        matched.add(SCH_STRING_UNCAPITALIZE);
        matched.add(SCH_STRING_CAPITALIZE);
        matched.add(SCH_STRING_TRIM);
        matched.add(SCH_STRING_STRIP);
        return matched;
    }


    @Override
    protected Type<String> registerResultType() {
        return Types.STRING;
    }

    

    
    
    @Override
    public String execute(FunctionArguments arguments) throws Exception {
        
        if (arguments.isTargetNull()) {
            return null;
        }       
        
        if (SCH_CALENDAR_STRING.matches(arguments)) {
            return fromCalendar(
                    (java.util.Calendar)arguments.getTarget(),
                    null, 
                    arguments.getStringParameter(0));
        }
        
        if (SCH_CALENDAR_LOCALE.matches(arguments)) {
            return fromCalendar((java.util.Calendar)arguments.getTarget(),
                    arguments.getLocaleParameter(0), 
                    null);
        }
        
        if (SCH_CALENDAR_LOCALE_STRING.matches(arguments)) {            
            return fromCalendar((java.util.Calendar)arguments.getTarget(),
                    arguments.getLocaleParameter(0), 
                    arguments.getStringParameter(1));
        }
        
        if (SCH_STRING_ESCAPECSV.matches(arguments)) {
            return StringEscapeUtils.escapeCsv(arguments.getTargetAsString());
        }
        if (SCH_STRING_UNESCAPECSV.matches(arguments)) {
            return StringEscapeUtils.unescapeCsv(arguments.getTargetAsString());
        }
        if (SCH_STRING_ESCAPEHTML.matches(arguments)) {
            return StringEscapeUtils.escapeHtml(arguments.getTargetAsString());
        }
        if (SCH_STRING_UNESCAPEHTML.matches(arguments)) {
            return StringEscapeUtils.unescapeHtml(arguments.getTargetAsString());
        }
        if (SCH_STRING_ESCAPEJS.matches(arguments)) {
            return StringEscapeUtils.escapeJavaScript(arguments.getTargetAsString());
        }
        if (SCH_STRING_UNESCAPEJS.matches(arguments)) {
            return StringEscapeUtils.unescapeJavaScript(arguments.getTargetAsString());
        }
        if (SCH_STRING_ESCAPEXML.matches(arguments)) {
            return StringEscapeUtils.escapeXml(arguments.getTargetAsString());
        }
        if (SCH_STRING_UNESCAPEXML.matches(arguments)) {
            return StringEscapeUtils.unescapeXml(arguments.getTargetAsString());
        }
        
        if (SCH_STRING_CHARSET_TOBASE64.matches(arguments)) {
            return new String(new Base64().encode(arguments.getTargetAsString().getBytes(
                    ((Charset) arguments.getParameter(0)).name())), "US-ASCII");           
        }
        
        if (SCH_STRING_CHARSET_FROMBASE64.matches(arguments)) {
            return new String(new Base64().decode(arguments.getTargetAsString().getBytes("US-ASCII")), 
                    ((Charset) arguments.getParameter(0)).name()); 
        }
        
        if (SCH_STRING_CHARSET_TOHEXADECIMAL.matches(arguments)) {
            final byte[] input = arguments.getTargetAsString()
                .getBytes(((Charset) arguments.getParameter(0)).name());
            final StringBuffer output = new StringBuffer();
            
            for (byte i = 0; i < input.length; i++) {
                output.append(Integer.toHexString(input[i]));
            }
            
            return output.toString();        
        }
        
        if (SCH_STRING_CHARSET_FROMHEXADECIMAL.matches(arguments)) {
            final String input = arguments.getTargetAsString();
            final StringBuffer output = new StringBuffer();
            
            for (int i = 0; i < input.length(); i = i + 2) {
                final byte current = 
                    (byte) Integer.parseInt(String.valueOf(input.charAt(i))
                        + String.valueOf(input.charAt(i + 1)), 16);
                
                output.append(new String(new byte[] {current},
                        ((Charset) arguments.getParameter(0)).name()));
            }
            
            return output.toString();        
        }
        
        if (SCH_STRING_TOUPPERCASE.matches(arguments)) {
            return StringUtils.upperCase(arguments.getTargetAsString());
        }
        
        if (SCH_STRING_TOLOWERCASE.matches(arguments)) {
            return StringUtils.lowerCase(arguments.getTargetAsString());
        }
        
        if (SCH_STRING_UNCAPITALIZE.matches(arguments)) {
            return StringUtils.uncapitalize(arguments.getTargetAsString());
        }
        
        if (SCH_STRING_CAPITALIZE.matches(arguments)) {
            return StringUtils.capitalize(arguments.getTargetAsString());
        }
        
        if (SCH_STRING_TRIM.matches(arguments)) {
            return StringUtils.trim(arguments.getTargetAsString());
        }
        
        if (SCH_STRING_STRIP.matches(arguments)) {
            return StringUtils.strip(arguments.getTargetAsString());
        }
        
        return arguments.getTarget().toString();
        
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
