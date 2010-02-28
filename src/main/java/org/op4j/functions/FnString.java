/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.time.DateUtils;
import org.op4j.functions.FnStringAuxNumberConverters.ToBigDecimal;
import org.op4j.functions.FnStringAuxNumberConverters.ToBigInteger;
import org.op4j.functions.FnStringAuxNumberConverters.ToByte;
import org.op4j.functions.FnStringAuxNumberConverters.ToDouble;
import org.op4j.functions.FnStringAuxNumberConverters.ToFloat;
import org.op4j.functions.FnStringAuxNumberConverters.ToInteger;
import org.op4j.functions.FnStringAuxNumberConverters.ToLong;
import org.op4j.functions.FnStringAuxNumberConverters.ToShort;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class FnString {

	private static IFunction<String,String> ESCAPE_CSV_STRING_FUNC = new EscapeCSV();
	private static IFunction<String,String> UNESCAPE_CSV_STRING_FUNC = new UnescapeCSV();
	private static IFunction<String,String> ESCAPE_XML_STRING_FUNC = new EscapeXML();
	private static IFunction<String,String> UNESCAPE_XML_STRING_FUNC = new UnescapeXML();
	private static IFunction<String,String> ESCAPE_HTML_STRING_FUNC = new EscapeHTML();
	private static IFunction<String,String> UNESCAPE_HTML_STRING_FUNC = new UnescapeHTML();
	private static IFunction<String,String> ESCAPE_JAVASCRIPT_STRING_FUNC = new EscapeJavaScript();
	private static IFunction<String,String> UNESCAPE_JAVASCRIPT_STRING_FUNC = new UnescapeJavaScript();
	private static IFunction<String,String> TO_UPPER_CASE_STRING_FUNC = new ToUpperCase();
	private static IFunction<String,String> TO_LOWER_CASE_STRING_FUNC = new ToLowerCase();
	private static IFunction<String,String> UN_CAPITALIZE_STRING_FUNC = new UnCapitalize();
	private static IFunction<String,String> CAPITALIZE_STRING_FUNC = new Capitalize();
	private static IFunction<String,String> TRIM_STRING_FUNC = new Trim();
	private static IFunction<String,String> STRIP_STRING_FUNC = new Strip();
	
	private static IFunction<String,BigDecimal> TO_BIG_DECIMAL = new ToBigDecimal();
    private static IFunction<String,BigInteger> TO_BIG_INTEGER = new ToBigInteger();
    private static IFunction<String,Double> TO_DOUBLE = new ToDouble();
    private static IFunction<String,Float> TO_FLOAT = new ToFloat();
    private static IFunction<String,Long> TO_LONG = new ToLong();
    private static IFunction<String,Integer> TO_INTEGER = new ToInteger();
    private static IFunction<String,Short> TO_SHORT = new ToShort();
    private static IFunction<String,Byte> TO_BYTE = new ToByte();
	
    private static IFunction<String,Boolean> TO_BOOLEAN = new ToBoolean();
	

    
    
	
	private FnString() {
		super();           
	}

	
    
    public static final IFunction<String,BigDecimal> toBigDecimal() {
        return TO_BIG_DECIMAL;
    }
    
    public static final IFunction<String,BigDecimal> toBigDecimal(final Locale locale) {
        return new ToBigDecimal(locale);
    }
    
    public static final IFunction<String,BigDecimal> toBigDecimal(final String locale) {
        return new ToBigDecimal(locale);
    }
    
    public static final IFunction<String,BigDecimal> toBigDecimal(final DecimalPoint decimalPoint) {
        return new ToBigDecimal(decimalPoint);
    }
    
    public static final IFunction<String,BigDecimal> toBigDecimal(final int scale, final RoundingMode roundingMode) {
        return new ToBigDecimal(scale, roundingMode);
    }
    
    public static final IFunction<String,BigDecimal> toBigDecimal(final int scale, final RoundingMode roundingMode, final Locale locale) {
        return new ToBigDecimal(scale, roundingMode, locale);
    }
    
    public static final IFunction<String,BigDecimal> toBigDecimal(final int scale, final RoundingMode roundingMode, final String locale) {
        return new ToBigDecimal(scale, roundingMode, locale);
    }
    
    public static final IFunction<String,BigDecimal> toBigDecimal(final int scale, final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
        return new ToBigDecimal(scale, roundingMode, decimalPoint);
    }
    
    
    public static final IFunction<String,BigInteger> toBigInteger() {
        return TO_BIG_INTEGER;
    }
    
    public static final IFunction<String,BigInteger> toBigInteger(final Locale locale) {
        return new ToBigInteger(locale);
    }
    
    public static final IFunction<String,BigInteger> toBigInteger(final String locale) {
        return new ToBigInteger(locale);
    }
    
    public static final IFunction<String,BigInteger> toBigInteger(final DecimalPoint decimalPoint) {
        return new ToBigInteger(decimalPoint);
    }
    
    public static final IFunction<String,BigInteger> toBigInteger(final int radix) {
        return new ToBigInteger(Integer.valueOf(radix));
    }
    
    public static final IFunction<String,BigInteger> toBigInteger(final RoundingMode roundingMode) {
        return new ToBigInteger(roundingMode);
    }
    
    public static final IFunction<String,BigInteger> toBigInteger(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
        return new ToBigInteger(roundingMode, decimalPoint);
    }
    
    public static final IFunction<String,BigInteger> toBigInteger(final RoundingMode roundingMode, final Locale locale) {
        return new ToBigInteger(roundingMode, locale);
    }
    
    public static final IFunction<String,BigInteger> toBigInteger(final RoundingMode roundingMode, final String locale) {
        return new ToBigInteger(roundingMode, locale);
    }
    
    
    public static final IFunction<String,Double> toDouble() {
        return TO_DOUBLE;
    }
    
    public static final IFunction<String,Double> toDouble(final Locale locale) {
        return new ToDouble(locale);
    }
    
    public static final IFunction<String,Double> toDouble(final String locale) {
        return new ToDouble(locale);
    }
    
    public static final IFunction<String,Double> toDouble(final DecimalPoint decimalPoint) {
        return new ToDouble(decimalPoint);
    }
    
    public static final IFunction<String,Double> toDouble(final int scale, final RoundingMode roundingMode) {
        return new ToDouble(scale, roundingMode);
    }
    
    public static final IFunction<String,Double> toDouble(final int scale, final RoundingMode roundingMode, final Locale locale) {
        return new ToDouble(scale, roundingMode, locale);
    }
    
    public static final IFunction<String,Double> toDouble(final int scale, final RoundingMode roundingMode, final String locale) {
        return new ToDouble(scale, roundingMode, locale);
    }
    
    public static final IFunction<String,Double> toDouble(final int scale, final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
        return new ToDouble(scale, roundingMode, decimalPoint);
    }
    
    
    public static final IFunction<String,Float> toFloat() {
        return TO_FLOAT;
    }
    
    public static final IFunction<String,Float> toFloat(final Locale locale) {
        return new ToFloat(locale);
    }
    
    public static final IFunction<String,Float> toFloat(final String locale) {
        return new ToFloat(locale);
    }
    
    public static final IFunction<String,Float> toFloat(final DecimalPoint decimalPoint) {
        return new ToFloat(decimalPoint);
    }
    
    public static final IFunction<String,Float> toFloat(final int scale, final RoundingMode roundingMode) {
        return new ToFloat(scale, roundingMode);
    }
    
    public static final IFunction<String,Float> toFloat(final int scale, final RoundingMode roundingMode, final Locale locale) {
        return new ToFloat(scale, roundingMode, locale);
    }
    
    public static final IFunction<String,Float> toFloat(final int scale, final RoundingMode roundingMode, final String locale) {
        return new ToFloat(scale, roundingMode, locale);
    }
    
    public static final IFunction<String,Float> toFloat(final int scale, final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
        return new ToFloat(scale, roundingMode, decimalPoint);
    }
    
    
    public static final IFunction<String,Long> toLong() {
        return TO_LONG;
    }
    
    public static final IFunction<String,Long> toLong(final Locale locale) {
        return new ToLong(locale);
    }
    
    public static final IFunction<String,Long> toLong(final String locale) {
        return new ToLong(locale);
    }
    
    public static final IFunction<String,Long> toLong(final DecimalPoint decimalPoint) {
        return new ToLong(decimalPoint);
    }
    
    public static final IFunction<String,Long> toLong(final int radix) {
        return new ToLong(Integer.valueOf(radix));
    }
    
    public static final IFunction<String,Long> toLong(final RoundingMode roundingMode) {
        return new ToLong(roundingMode);
    }
    
    public static final IFunction<String,Long> toLong(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
        return new ToLong(roundingMode, decimalPoint);
    }
    
    public static final IFunction<String,Long> toLong(final RoundingMode roundingMode, final Locale locale) {
        return new ToLong(roundingMode, locale);
    }
    
    public static final IFunction<String,Long> toLong(final RoundingMode roundingMode, final String locale) {
        return new ToLong(roundingMode, locale);
    }
    
    
    public static final IFunction<String,Integer> toInteger() {
        return TO_INTEGER;
    }
    
    public static final IFunction<String,Integer> toInteger(final Locale locale) {
        return new ToInteger(locale);
    }
    
    public static final IFunction<String,Integer> toInteger(final String locale) {
        return new ToInteger(locale);
    }
    
    public static final IFunction<String,Integer> toInteger(final DecimalPoint decimalPoint) {
        return new ToInteger(decimalPoint);
    }
    
    public static final IFunction<String,Integer> toInteger(final int radix) {
        return new ToInteger(Integer.valueOf(radix));
    }
    
    public static final IFunction<String,Integer> toInteger(final RoundingMode roundingMode) {
        return new ToInteger(roundingMode);
    }
    
    public static final IFunction<String,Integer> toInteger(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
        return new ToInteger(roundingMode, decimalPoint);
    }
    
    public static final IFunction<String,Integer> toInteger(final RoundingMode roundingMode, final Locale locale) {
        return new ToInteger(roundingMode, locale);
    }
    
    public static final IFunction<String,Integer> toInteger(final RoundingMode roundingMode, final String locale) {
        return new ToInteger(roundingMode, locale);
    }
    
    
    public static final IFunction<String,Short> toShort() {
        return TO_SHORT;
    }
    
    public static final IFunction<String,Short> toShort(final Locale locale) {
        return new ToShort(locale);
    }
    
    public static final IFunction<String,Short> toShort(final String locale) {
        return new ToShort(locale);
    }
    
    public static final IFunction<String,Short> toShort(final DecimalPoint decimalPoint) {
        return new ToShort(decimalPoint);
    }
    
    public static final IFunction<String,Short> toShort(final int radix) {
        return new ToShort(Integer.valueOf(radix));
    }
    
    public static final IFunction<String,Short> toShort(final RoundingMode roundingMode) {
        return new ToShort(roundingMode);
    }
    
    public static final IFunction<String,Short> toShort(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
        return new ToShort(roundingMode, decimalPoint);
    }
    
    public static final IFunction<String,Short> toShort(final RoundingMode roundingMode, final Locale locale) {
        return new ToShort(roundingMode, locale);
    }
    
    public static final IFunction<String,Short> toShort(final RoundingMode roundingMode, final String locale) {
        return new ToShort(roundingMode, locale);
    }
    
    
    public static final IFunction<String,Byte> toByte() {
        return TO_BYTE;
    }
    
    public static final IFunction<String,Byte> toByte(final Locale locale) {
        return new ToByte(locale);
    }
    
    public static final IFunction<String,Byte> toByte(final String locale) {
        return new ToByte(locale);
    }
    
    public static final IFunction<String,Byte> toByte(final DecimalPoint decimalPoint) {
        return new ToByte(decimalPoint);
    }
    
    public static final IFunction<String,Byte> toByte(final int radix) {
        return new ToByte(Integer.valueOf(radix));
    }
    
    public static final IFunction<String,Byte> toByte(final RoundingMode roundingMode) {
        return new ToByte(roundingMode);
    }
    
    public static final IFunction<String,Byte> toByte(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
        return new ToByte(roundingMode, decimalPoint);
    }
    
    public static final IFunction<String,Byte> toByte(final RoundingMode roundingMode, final Locale locale) {
        return new ToByte(roundingMode, locale);
    }
    
    public static final IFunction<String,Byte> toByte(final RoundingMode roundingMode, final String locale) {
        return new ToByte(roundingMode, locale);
    }
	
	
    
    
    public static final IFunction<String,Boolean> toBoolean() {
        return TO_BOOLEAN;
    }
    
    
	
	
	public static final IFunction<String,String> escapeCSV() {
        return ESCAPE_CSV_STRING_FUNC;
    }
	public static final IFunction<String,String> unescapeCSV() {
        return UNESCAPE_CSV_STRING_FUNC;
    }	

	public static final IFunction<String,String> escapeXML() {
        return ESCAPE_XML_STRING_FUNC;
    }
	public static final IFunction<String,String> unescapeXML() {
        return UNESCAPE_XML_STRING_FUNC;
    }
	
	public static final IFunction<String,String> escapeHTML() {
        return ESCAPE_HTML_STRING_FUNC;
    }
	public static final IFunction<String,String> unescapeHTML() {
        return UNESCAPE_HTML_STRING_FUNC;
    }
	
	public static final IFunction<String,String> escapeJavaScript() {
        return ESCAPE_JAVASCRIPT_STRING_FUNC;
    }
	public static final IFunction<String,String> unescapeJavaScript() {
        return UNESCAPE_JAVASCRIPT_STRING_FUNC;
    }
	
	public static final IFunction<String,String> toBase64(Charset charset) {
        return new ToBase64(charset);
    }
	public static final IFunction<String,String> fromBase64(Charset charset) {
        return new FromBase64(charset);
    }
	
	public static final IFunction<String,String> toHexadecimal(Charset charset) {
        return new ToHexadecimal(charset);
    }
	public static final IFunction<String,String> fromHexadecimal(Charset charset) {
        return new FromHexadecimal(charset);
    }
	
	public static final IFunction<String,String> toUpperCase() {
        return TO_UPPER_CASE_STRING_FUNC;
    }
	public static final IFunction<String,String> toLowerCase() {
        return TO_LOWER_CASE_STRING_FUNC;
    }
	
	public static final IFunction<String,String> unCapitalize() {
        return UN_CAPITALIZE_STRING_FUNC;
    }
	public static final IFunction<String,String> capitalize() {
        return CAPITALIZE_STRING_FUNC;
    }
	
	public static final IFunction<String,String> trim() {
        return TRIM_STRING_FUNC;
    }
	
	public static final IFunction<String,String> strip() {
        return STRIP_STRING_FUNC;
    }
	


	
    
    public static final IFunction<String,Calendar> toCalendar(final String pattern) {
        return new ToCalendar(pattern);
    }
    
    public static final IFunction<String,Calendar> toCalendar(final String pattern, final Locale locale) {
        return new ToCalendar(pattern, locale);
    }
    
    public static final IFunction<String,Calendar> toCalendar(final String pattern, final String locale) {
        return new ToCalendar(pattern, locale);
    }
	
    
    
	
    
    public static final IFunction<String,Date> toDate(final String pattern) {
        return new ToDate(pattern);
    }
    
    public static final IFunction<String,Date> toDate(final String pattern, final Locale locale) {
        return new ToDate(pattern, locale);
    }
    
    public static final IFunction<String,Date> toDate(final String pattern, final String locale) {
        return new ToDate(pattern, locale);
    }

    
    
    
	
	
	
	
	
	/**
	 * The String is returned in a way it can be used to fill in a CSV column as StringEscapeUtils does
	 *
	 */
	static final class EscapeCSV implements IFunction<String,String> {
		
		EscapeCSV() {
			super();
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.escapeCsv(input);
		}		
	}

	/**
	 * The String is returned without the escape characters used to
	 * include it in a CSV column (i.e. no quotes enclosing it, no escaped quotes) 
	 * as StringEscapeUtils does
	 *
	 */
	static final class UnescapeCSV implements IFunction<String,String> {
		UnescapeCSV() {
			super();
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.unescapeCsv(input);
		}		
	}

	/**
	 * The String is returned with the XML characters escaped as StringEscapeUtils does
	 *
	 */
	static final class EscapeXML implements IFunction<String,String> {
		EscapeXML() {
			super();
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.escapeXml(input);
		}		
	}

	/**
	 * The String is returned without the XML escape characters as StringEscapeUtils does
	 *
	 */
	static final class UnescapeXML implements IFunction<String,String> {
		UnescapeXML() {
			super();
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.unescapeXml(input);
		}		
	}

	/**
	 * It escapes the given String using HTML entities (as StringEscapeUtils does)
	 *
	 */
	static final class EscapeHTML implements IFunction<String,String> {
		EscapeHTML() {
			super();
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.escapeHtml(input);
		}		
	}

	/**
	 * It unescapes the given String and converts its HTML entity escapes into 
	 * their unicode characters (as StringEscapeUtils does)
	 *
	 */
	static final class UnescapeHTML implements IFunction<String,String> {
		UnescapeHTML() {
			super();
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.unescapeHtml(input);
		}		
	}

	/**
	 * It converts the given String into a JavaScript valid one (as StringEscapeUtils does)
	 *
	 */
	static final class EscapeJavaScript implements IFunction<String,String> {
		EscapeJavaScript() {
			super();
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.escapeJavaScript(input);
		}		
	}

	/**
	 * It unescapes the given JavaScript valid String (as StringEscapeUtils does)
	 *
	 */
	static final class UnescapeJavaScript implements IFunction<String,String> {
		UnescapeJavaScript() {
			super();
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.unescapeJavaScript(input);
		}		
	}

	/**
	 * It converts the given String into a base64 encoded one
	 *
	 */
	static final class ToBase64 extends AbstractNullAsNullFunction<String,String> {

		private Charset charset = null;

		ToBase64(Charset charset) {
			super();
			this.charset = charset;
		}

        @Override
        protected String nullAsNullExecute(final String input, final ExecCtx ctx) throws Exception {
			Validate.notNull(this.charset, "Charset can't be null");
			return new String(new Base64().encode(input.getBytes(
					this.charset.name())), "US-ASCII");
		}		
	}

	/**
	 * It decodes the given base64 encoded String
	 *
	 */
	static final class FromBase64 extends AbstractNullAsNullFunction<String,String> {

		private Charset charset = null;

		FromBase64(Charset charset) {
			super();
			this.charset = charset;
		}

        @Override
        protected String nullAsNullExecute(final String input, final ExecCtx ctx) throws Exception {
			Validate.notNull(this.charset, "Charset can't be null");
			return new String(new Base64().decode(input.getBytes("US-ASCII")), 
					this.charset.name()); 
		}		
	}

	/**
	 * It converts the given String into its Hexadecimal representation using the specified Charset
	 *
	 */
	static final class ToHexadecimal extends AbstractNullAsNullFunction<String,String> {

		private Charset charset = null;

		ToHexadecimal(Charset charset) {
			super();
			this.charset = charset;
		}

        @Override
        protected String nullAsNullExecute(final String input, final ExecCtx ctx) throws Exception {
			Validate.notNull(this.charset, "Charset can't be null");

			final byte[] inputAsByteArray = input.getBytes(this.charset.name());
			final StringBuffer output = new StringBuffer();
			for (byte i = 0; i < inputAsByteArray.length; i++) {
				output.append(Integer.toHexString(inputAsByteArray[i]));
			}
			return output.toString();      
		}		
	}

	/**
	 * The given String is converted from its Hexadecimal representation to a String using the specified Charset
	 *
	 */
	static final class FromHexadecimal extends AbstractNullAsNullFunction<String,String> {

		private Charset charset = null;

		FromHexadecimal(Charset charset) {
			super();
			this.charset = charset;
		}

        @Override
		protected String nullAsNullExecute(final String input, final ExecCtx ctx) throws Exception {
			Validate.notNull(this.charset, "Charset can't be null");

			final StringBuffer output = new StringBuffer();            
			for (int i = 0; i < input.length(); i = i + 2) {
				final byte current = 
					(byte) Integer.parseInt(String.valueOf(input.charAt(i))
							+ String.valueOf(input.charAt(i + 1)), 16);

				output.append(new String(new byte[] {current},
						this.charset.name()));
			}            
			return output.toString();       
		}		
	}

	/**
	 * It converts the given String to uppercase
	 *
	 */
	static final class ToUpperCase implements IFunction<String,String> {

		ToUpperCase() {
			super();			
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringUtils.upperCase(input);
		}		
	}
	
	/**
	 * It converts the given String to lowercase
	 *
	 */
	static final class ToLowerCase implements IFunction<String,String> {

		ToLowerCase() {
			super();			
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringUtils.lowerCase(input);
		}		
	}

	/**
	 * It converts the first letter of the given String to lowercase
	 *
	 */
	static final class UnCapitalize implements IFunction<String,String> {

		UnCapitalize() {
			super();			
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringUtils.uncapitalize(input);
		}		
	}
	/**
	 * It converts the first letter of the given String to uppercase
	 *
	 */
	static final class Capitalize implements IFunction<String,String> {

		Capitalize() {
			super();			
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringUtils.capitalize(input);
		}		
	}	

	/**
	 * Removes control characters (char <= 32) from both ends of the given String
	 *
	 */
	static final class Trim implements IFunction<String,String> {

		Trim() {
			super();			
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringUtils.trim(input);
		}		
	}	
	
	/**
	 * Strips whitespace from both sides of the given String
	 *
	 */
	static final class Strip implements IFunction<String,String> {

		Strip() {
			super();			
		}

        public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringUtils.strip(input);
		}		
	}	
	
	
	
    
    static final class ToBoolean extends AbstractNullAsNullFunction<String,Boolean>  {
        
        ToBoolean() {
            super();
        }

        @Override
        protected Boolean nullAsNullExecute(final String string, final ExecCtx ctx) throws Exception {
            return BooleanUtils.toBooleanObject(string);
        }
        
    }
	
    
    
    
    
    
    static final class ToCalendar extends AbstractNullAsNullFunction<String,Calendar>  {

        private final SimpleDateFormat simpleDateFormat;

        
        ToCalendar(final String pattern) {
            super();
            Validate.notNull(pattern, "A pattern must be specified");
            if (StringUtils.contains(pattern, "MMM")) {
                throw new IllegalArgumentException("The use of MMM or MMMM as part of the date pattern requires a Locale");
            }
            if (StringUtils.contains(pattern, "EEE")) {
                throw new IllegalArgumentException("The use of EEE or EEEE as part of the date pattern requires a Locale");
            }
            this.simpleDateFormat = new SimpleDateFormat(pattern);            
        }
        
        ToCalendar(final String pattern, final Locale locale) {
            super();
            Validate.notNull(pattern, "A pattern must be specified");
            Validate.notNull(locale, "A locale must be specified");
            this.simpleDateFormat = new SimpleDateFormat(pattern, locale);
        }
        
        ToCalendar(final String pattern, final String locale) {
            super();
            Validate.notNull(pattern, "A pattern must be specified");
            Validate.notNull(locale, "A locale must be specified");
            this.simpleDateFormat = new SimpleDateFormat(pattern, LocaleUtils.toLocale(locale));
        }


        @Override
        protected Calendar nullAsNullExecute(final String object, final ExecCtx ctx) throws Exception {
            // Calendar is truncated to YEAR to ensure all fields are set to zero before 
            // parsing the string into the new calendar object
            final Calendar calendar = 
                DateUtils.truncate(Calendar.getInstance(), Calendar.YEAR);
            calendar.setTime(this.simpleDateFormat.parse(object));
            return calendar;
        }
        
    }
    
    
    
    
    
    
    static final class ToDate extends AbstractNullAsNullFunction<String,Date>  {

        private final SimpleDateFormat simpleDateFormat;

        
        ToDate(final String pattern) {
            super();
            Validate.notNull(pattern, "A pattern must be specified");
            if (StringUtils.contains(pattern, "MMM")) {
                throw new IllegalArgumentException("The use of MMM or MMMM as part of the date pattern requires a Locale");
            }
            if (StringUtils.contains(pattern, "EEE")) {
                throw new IllegalArgumentException("The use of EEE or EEEE as part of the date pattern requires a Locale");
            }
            this.simpleDateFormat = new SimpleDateFormat(pattern);            
        }
        
        ToDate(final String pattern, final Locale locale) {
            super();
            Validate.notNull(pattern, "A pattern must be specified");
            Validate.notNull(locale, "A locale must be specified");
            this.simpleDateFormat = new SimpleDateFormat(pattern, locale);
        }
        
        ToDate(final String pattern, final String locale) {
            super();
            Validate.notNull(pattern, "A pattern must be specified");
            Validate.notNull(locale, "A locale must be specified");
            this.simpleDateFormat = new SimpleDateFormat(pattern, LocaleUtils.toLocale(locale));
        }


        @Override
        protected Date nullAsNullExecute(final String object, final ExecCtx ctx) throws Exception {
            // Calendar is truncated to YEAR to ensure all fields are set to zero before 
            // parsing the string into the new calendar object
            final Calendar calendar = 
                DateUtils.truncate(Calendar.getInstance(), Calendar.YEAR);
            calendar.setTime(this.simpleDateFormat.parse(object));
            return calendar.getTime();
        }
        
    }
    
    
}
