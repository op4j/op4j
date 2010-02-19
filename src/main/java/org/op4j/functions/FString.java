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

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class FString {

	private static EscapeCSV ESCAPE_CSV_STRING_FUNC = new EscapeCSV();
	private static UnescapeCSV UNESCAPE_CSV_STRING_FUNC = new UnescapeCSV();
	private static EscapeXML ESCAPE_XML_STRING_FUNC = new EscapeXML();
	private static UnescapeXML UNESCAPE_XML_STRING_FUNC = new UnescapeXML();
	private static EscapeHTML ESCAPE_HTML_STRING_FUNC = new EscapeHTML();
	private static UnescapeHTML UNESCAPE_HTML_STRING_FUNC = new UnescapeHTML();
	private static EscapeJavaScript ESCAPE_JAVASCRIPT_STRING_FUNC = new EscapeJavaScript();
	private static UnescapeJavaScript UNESCAPE_JAVASCRIPT_STRING_FUNC = new UnescapeJavaScript();
	private static ToUpperCase TO_UPPER_CASE_STRING_FUNC = new ToUpperCase();
	private static ToLowerCase TO_LOWER_CASE_STRING_FUNC = new ToLowerCase();
	private static UnCapitalize UN_CAPITALIZE_STRING_FUNC = new UnCapitalize();
	private static Capitalize CAPITALIZE_STRING_FUNC = new Capitalize();
	private static Trim TRIM_STRING_FUNC = new Trim();
	private static Strip STRIP_STRING_FUNC = new Strip();
	
	private FString() {
		super();           
	}

	public static final EscapeCSV escapeCSV() {
        return ESCAPE_CSV_STRING_FUNC;
    }
	public static final UnescapeCSV unescapeCSV() {
        return UNESCAPE_CSV_STRING_FUNC;
    }	

	public static final EscapeXML escapeXML() {
        return ESCAPE_XML_STRING_FUNC;
    }
	public static final UnescapeXML unescapeXML() {
        return UNESCAPE_XML_STRING_FUNC;
    }
	
	public static final EscapeHTML escapeHTML() {
        return ESCAPE_HTML_STRING_FUNC;
    }
	public static final UnescapeHTML unescapeHTML() {
        return UNESCAPE_HTML_STRING_FUNC;
    }
	
	public static final EscapeJavaScript escapeJavaScript() {
        return ESCAPE_JAVASCRIPT_STRING_FUNC;
    }
	public static final UnescapeJavaScript unescapeJavaScript() {
        return UNESCAPE_JAVASCRIPT_STRING_FUNC;
    }
	
	public static final ToBase64 toBase64(Charset charset) {
        return new ToBase64(charset);
    }
	public static final FromBase64 fromBase64(Charset charset) {
        return new FromBase64(charset);
    }
	
	public static final ToHexadecimal toHexadecimal(Charset charset) {
        return new ToHexadecimal(charset);
    }
	public static final FromHexadecimal fromHexadecimal(Charset charset) {
        return new FromHexadecimal(charset);
    }
	
	public static final ToUpperCase toUpperCase() {
        return TO_UPPER_CASE_STRING_FUNC;
    }
	public static final ToLowerCase toLowerCase() {
        return TO_LOWER_CASE_STRING_FUNC;
    }
	
	public static final UnCapitalize unCapitalize() {
        return UN_CAPITALIZE_STRING_FUNC;
    }
	public static final Capitalize capitalize() {
        return CAPITALIZE_STRING_FUNC;
    }
	
	public static final Trim trim() {
        return TRIM_STRING_FUNC;
    }
	
	public static final Strip strip() {
        return STRIP_STRING_FUNC;
    }
	
	static abstract class BaseStringFunc<X> extends AbstractNotNullFunction<String, X> {
	    
		public BaseStringFunc() {
			super();			
		}

        }
	
	/**
	 * The String is returned in a way it can be used to fill in a CSV column as StringEscapeUtils does
	 *
	 */
	public static final class EscapeCSV extends BaseStringFunc<String> {
		
		public EscapeCSV() {
			super();
		}

        @Override
		public String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.escapeCsv(input);
		}		
	}

	/**
	 * The String is returned without the escape characters used to
	 * include it in a CSV column (i.e. no quotes enclosing it, no escaped quotes) 
	 * as StringEscapeUtils does
	 *
	 */
	public static final class UnescapeCSV extends BaseStringFunc<String> {
		public UnescapeCSV() {
			super();
		}

        @Override
		public String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.unescapeCsv(input);
		}		
	}

	/**
	 * The String is returned with the XML characters escaped as StringEscapeUtils does
	 *
	 */
	public static final class EscapeXML extends BaseStringFunc<String> {
		public EscapeXML() {
			super();
		}

        @Override
		public String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.escapeXml(input);
		}		
	}

	/**
	 * The String is returned without the XML escape characters as StringEscapeUtils does
	 *
	 */
	public static final class UnescapeXML extends BaseStringFunc<String> {
		public UnescapeXML() {
			super();
		}

        @Override
		public String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.unescapeXml(input);
		}		
	}

	/**
	 * It escapes the given String using HTML entities (as StringEscapeUtils does)
	 *
	 */
	public static final class EscapeHTML extends BaseStringFunc<String> {
		public EscapeHTML() {
			super();
		}

        @Override
		public String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.escapeHtml(input);
		}		
	}

	/**
	 * It unescapes the given String and converts its HTML entity escapes into 
	 * their unicode characters (as StringEscapeUtils does)
	 *
	 */
	public static final class UnescapeHTML extends BaseStringFunc<String> {
		public UnescapeHTML() {
			super();
		}

        @Override
		public String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.unescapeHtml(input);
		}		
	}

	/**
	 * It converts the given String into a JavaScript valid one (as StringEscapeUtils does)
	 *
	 */
	public static final class EscapeJavaScript extends BaseStringFunc<String> {
		public EscapeJavaScript() {
			super();
		}

        @Override
		public String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.escapeJavaScript(input);
		}		
	}

	/**
	 * It unescapes the given JavaScript valid String (as StringEscapeUtils does)
	 *
	 */
	public static final class UnescapeJavaScript extends BaseStringFunc<String> {
		public UnescapeJavaScript() {
			super();
		}

        @Override
		public String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.unescapeJavaScript(input);
		}		
	}

	/**
	 * It converts the given String into a base64 encoded one
	 *
	 */
	public static final class ToBase64 extends BaseStringFunc<String> {

		private Charset charset = null;

		public ToBase64(Charset charset) {
			super();
			this.charset = charset;
		}

        @Override
		public String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
			Validate.notNull(this.charset, "Charset can't be null");
			return new String(new Base64().encode(input.getBytes(
					this.charset.name())), "US-ASCII");
		}		
	}

	/**
	 * It decodes the given base64 encoded String
	 *
	 */
	public static final class FromBase64 extends BaseStringFunc<String> {

		private Charset charset = null;

		public FromBase64(Charset charset) {
			super();
			this.charset = charset;
		}

        @Override
		public String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
			Validate.notNull(this.charset, "Charset can't be null");
			return new String(new Base64().decode(input.getBytes("US-ASCII")), 
					this.charset.name()); 
		}		
	}

	/**
	 * It converts the given String into its Hexadecimal representation using the specified Charset
	 *
	 */
	public static final class ToHexadecimal extends BaseStringFunc<String> {

		private Charset charset = null;

		public ToHexadecimal(Charset charset) {
			super();
			this.charset = charset;
		}

        @Override
		public String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
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
	public static final class FromHexadecimal extends BaseStringFunc<String> {

		private Charset charset = null;

		public FromHexadecimal(Charset charset) {
			super();
			this.charset = charset;
		}

        @Override
		public String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
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
	public static final class ToUpperCase extends BaseStringFunc<String> {

		public ToUpperCase() {
			super();			
		}

        @Override
		public String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
			return StringUtils.upperCase(input);
		}		
	}
	
	/**
	 * It converts the given String to lowercase
	 *
	 */
	public static final class ToLowerCase extends BaseStringFunc<String> {

		public ToLowerCase() {
			super();			
		}

        @Override
		public String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
			return StringUtils.lowerCase(input);
		}		
	}

	/**
	 * It converts the first letter of the given String to lowercase
	 *
	 */
	public static final class UnCapitalize extends BaseStringFunc<String> {

		public UnCapitalize() {
			super();			
		}

        @Override
		public String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
			return StringUtils.uncapitalize(input);
		}		
	}
	/**
	 * It converts the first letter of the given String to uppercase
	 *
	 */
	public static final class Capitalize extends BaseStringFunc<String> {

		public Capitalize() {
			super();			
		}

        @Override
		public String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
			return StringUtils.capitalize(input);
		}		
	}	

	/**
	 * Removes control characters (char <= 32) from both ends of the given String
	 *
	 */
	public static final class Trim extends BaseStringFunc<String> {

		public Trim() {
			super();			
		}

        @Override
		public String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
			return StringUtils.trim(input);
		}		
	}	
	
	/**
	 * Strips whitespace from both sides of the given String
	 *
	 */
	public static final class Strip extends BaseStringFunc<String> {

		public Strip() {
			super();			
		}

		@Override
        public String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
			return StringUtils.strip(input);
		}		
	}	
}
