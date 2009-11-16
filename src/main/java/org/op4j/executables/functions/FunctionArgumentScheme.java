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
package org.op4j.executables.functions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.ParameterSpecRecognitionException;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class FunctionArgumentScheme implements Serializable {
    
    private static final long serialVersionUID = -1994818419805211076L;

    static final char PARAMETER_SPEC_TYPE_PARAMETRIZATION_START_SYMBOL = '<';
    static final char PARAMETER_SPEC_TYPE_PARAMETRIZATION_END_SYMBOL = '>';
    static final char PARAMETER_SPEC_SEPARATOR_SYMBOL = ',';
    static final char PARAMETER_SPEC_LITERAL_DELIMITER = '\'';
    
    
    private final Type<?> targetType;
    private final List<FunctionParameterSpec> parameterSpecs;
    private final String description;
    
    
    
    
    public static FunctionArgumentScheme from(final Type<?> targetType) {
        return new FunctionArgumentScheme(null, targetType, null);
    }
    
    public static FunctionArgumentScheme from(final String description, final Type<?> targetType) {
        return new FunctionArgumentScheme(description, targetType, null);
    }
    
    public static FunctionArgumentScheme from(final String description, final Type<?> targetType, final String parameterSpec) {
        return new FunctionArgumentScheme(description, targetType, parameterSpec);
    }
    
    public static FunctionArgumentScheme from(final Type<?> targetType, final String parameterSpec) {
        return new FunctionArgumentScheme(null, targetType, parameterSpec);
    }
    
    
    private FunctionArgumentScheme(final String description, final Type<?> targetType, final String parameterSpec) {
        
        super();
        
        Validate.notNull(targetType, "Target type cannot be null");
    
        this.description = description;
        this.targetType = targetType;
        this.parameterSpecs = parseParameterSpec(parameterSpec);
        
    }
    
    
    public boolean hasDescription() {
        return this.description != null;
    }
    
    public String getDescription() {
        return this.description;
    }



    public Type<?> getTargetType() {
        return this.targetType;
    }

    
    public List<FunctionParameterSpec> getParameterSpecs() {
        return Collections.unmodifiableList(this.parameterSpecs);
    }
    
    
    
    
    public boolean matches(final FunctionArguments functionArguments) {
    	
    	Validate.notNull(functionArguments);
    	
    	if (functionArguments.getParameterCount() != this.parameterSpecs.size()) {
    		return false;
    	}
    	
    	final Class<?> argumentsTargetClass = functionArguments.getTargetClass();
    	if (argumentsTargetClass != null && !this.targetType.getRawClass().isAssignableFrom(argumentsTargetClass)) {
    	    return false;
    	}
    	
    	final List<Class<?>> argumentsParameterClasses = functionArguments.getParameterClasses();
    	for (int i = 0, n = argumentsParameterClasses.size(); i < n; i++) {
            final Class<?> argumentsParameterClass = argumentsParameterClasses.get(i);
            final FunctionParameterSpec parameterSpec = this.parameterSpecs.get(i); 
    	    if (parameterSpec.isLiteral()) {
    	        if (argumentsParameterClass == null || !argumentsParameterClass.equals(String.class)) {
    	            return false;
    	        }
    	        final String strParam = (String) functionArguments.getParameter(i);
    	        if (!parameterSpec.getLiteral().equals(strParam)) {
    	            return false;
    	        }
    	    } else {
    	        // parameter spec is for a non-literal
                if (argumentsParameterClass != null && !parameterSpec.getType().getRawClass().isAssignableFrom(argumentsParameterClass)) {
                    return false;
                }
    	    }
    	}
    	
    	return true;
    	
    }



    public String getStringRepresentation() {
        final StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[" + this.targetType.getName() + "]");
    	final List<String> parameterNames = new ArrayList<String>();
    	for (final FunctionParameterSpec parameterSpec : this.parameterSpecs) {
    		parameterNames.add(parameterSpec.getStringRepresentation());
    	}
    	if (!parameterNames.isEmpty()) {
    	    strBuilder.append(" ");
    	    strBuilder.append(StringUtils.join(parameterNames, PARAMETER_SPEC_SEPARATOR_SYMBOL));
    	}
        return strBuilder.toString(); 
    }


    @Override
    public String toString() {
        return getStringRepresentation();
    }
    

    
    
    
    private final static List<FunctionParameterSpec> parseParameterSpec(final String parameterSpec) {
        
        try {

            if (StringUtils.isBlank(parameterSpec)) {
                return new ArrayList<FunctionParameterSpec>();
            }
            
            final String spec = parameterSpec.trim();

            final ParameterSpecTokenizer tokenizer = new ParameterSpecTokenizer(spec);
            final String[] tokens = tokenizer.getTokens();
            
            final List<FunctionParameterSpec> parameterSpecs = new ArrayList<FunctionParameterSpec>();
            
            for (int i = 0; i < tokens.length; i++) {

                if (tokens[i].startsWith("" + PARAMETER_SPEC_LITERAL_DELIMITER) &&
                            tokens[i].endsWith("" + PARAMETER_SPEC_LITERAL_DELIMITER)) {
                    
                    parameterSpecs.add(FunctionParameterSpec.forLiteral(
                                tokens[i].substring(1, tokens[i].length() - 1)));
                    
                } else {
                    
                    /*
                     * We look for "Type componentName" definitions, but as spaces can happen
                     * inside type parameterizations (like "Map<Integer, String>"), we should
                     * be sure we only use 'level 0' tokens.
                     */
                    final List<String> tokenParts = new ArrayList<String>();
                    int currentTokenStart = 0;
                    int typeParamLevel = 0;
                    for (int j = 0; j < tokens[i].length(); j++) {
                        if (tokens[i].charAt(j) == '<') {
                            typeParamLevel++;
                        } else if (tokens[i].charAt(j) == '>') {
                            typeParamLevel--;
                        } else if (tokens[i].charAt(j) == ' ') {
                            if (typeParamLevel == 0 && currentTokenStart != j) {
                                tokenParts.add(tokens[i].substring(currentTokenStart, j));
                                currentTokenStart = j + 1;
                            } else if (typeParamLevel == 0 && currentTokenStart == j) {
                                currentTokenStart = j + 1;
                            }
                        }
                    }
                    tokenParts.add(tokens[i].substring(currentTokenStart));
                    
                    switch (tokenParts.size()) {
                        case 1:  
                            // no name specified for the component
                            parameterSpecs.add(FunctionParameterSpec.forType(Types.forName(tokenParts.get(0))));
                            break;
                        case 2:
                            // a name was specified for the component
                            parameterSpecs.add(FunctionParameterSpec.forType(Types.forName(tokenParts.get(0)), tokenParts.get(1)));
                            break;
                        default:
                            throw new ParameterSpecRecognitionException(tokens[i]);
                    }
                    
                }
                
            }

            return parameterSpecs;
            
        } catch (ParameterSpecRecognitionException e) {
            throw e;
        } catch (Exception e) {
            throw new ParameterSpecRecognitionException(parameterSpec, e);
        }
        
    }
    
    
    
    public final static class FunctionParameterSpec implements Serializable {
        
        private static final long serialVersionUID = -6705771580131769035L;
        
        
        private final Type<?> type;
        private final String name;
        private final String literal;

        
        static FunctionParameterSpec forType(final Type<?> type) {
            return new FunctionParameterSpec(type, null, null);
        }
        
        static FunctionParameterSpec forType(final Type<?> type, final String name) {
            return new FunctionParameterSpec(type, name, null);
        }
        
        static FunctionParameterSpec forLiteral(final String literal) {
            return new FunctionParameterSpec(null, null, literal);
        }
        
        
        private FunctionParameterSpec(final Type<?> type, final String name, final String literal) {
            super();
            this.type = type;
            this.name = name;
            this.literal = literal;
        }
        
        public boolean isLiteral() {
            return this.literal != null;
        }
        
        public boolean hasName() {
            return this.name != null;
        }

        public Type<?> getType() {
            return this.type;
        }
        
        public String getName() {
            return this.name;
        }

        public String getLiteral() {
            return this.literal;
        }
        
        public String getStringRepresentation() {
            return (isLiteral()? 
                    PARAMETER_SPEC_LITERAL_DELIMITER + this.literal + PARAMETER_SPEC_LITERAL_DELIMITER :
                    (this.type.getName() + (hasName()? " " + this.name : "")));
        }
        
        @Override
        public String toString() {
            return getStringRepresentation();
        }
        
    }
    
    
    private final static class ParameterSpecTokenizer {
        
        private final String[] tokens;
        
        ParameterSpecTokenizer(final String parameterSpec) {

            final List<String> tokenList = new ArrayList<String>();
            
            int index = 0;
            int lastStartIndex = 0;
            boolean literalOpen = false;
            int typeParametrizationDepth = 0;
            while (index < parameterSpec.length()) {
                
                char c = parameterSpec.charAt(index);
                if (c == PARAMETER_SPEC_SEPARATOR_SYMBOL) {
                    if ((!literalOpen) && (typeParametrizationDepth == 0)) {
                        tokenList.add(
                                parameterSpec.substring(lastStartIndex, index).trim());
                        lastStartIndex = index + 1;
                    }
                } else if (c == PARAMETER_SPEC_LITERAL_DELIMITER) {
                    if (!literalOpen) {
                        literalOpen = true;
                    } else if ((index + 1) < parameterSpec.length()) { 
                        final String remaining = parameterSpec.substring(index + 1).trim();
                        if (remaining.startsWith(""+PARAMETER_SPEC_SEPARATOR_SYMBOL)) {
                            literalOpen = false;
                        }
                    }
                } else if (c == PARAMETER_SPEC_TYPE_PARAMETRIZATION_START_SYMBOL) {
                    if (!literalOpen) {
                        typeParametrizationDepth++;
                    }
                } else if (c == PARAMETER_SPEC_TYPE_PARAMETRIZATION_END_SYMBOL) {
                    if (!literalOpen) {
                        typeParametrizationDepth--;
                    }
                }
                
                index++;
                
            }
            tokenList.add(
                    parameterSpec.substring(lastStartIndex, index).trim());
            
            this.tokens = tokenList.toArray(new String[tokenList.size()]);
            
        }
        
        
        String[] getTokens() {
            return this.tokens;
        }
        
    }
    

    
    
    
}
