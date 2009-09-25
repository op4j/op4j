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
package org.op4j.typescheme;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrBuilder;
import org.op4j.exceptions.TypeSchemeRecognitionException;
import org.op4j.objectscheme.ObjectScheme;
import org.op4j.objectscheme.ObjectSchemeComponent;
import org.op4j.type.Type;
import org.op4j.type.Types;

/*
 * (non-javadoc)
 * 
 * This class contains internal algorithms for TypeScheme processing and
 * handling.
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class TypeSchemeUtil {
    
    
    
    final static TypeScheme forName(final String typeSchemeName, boolean canonical) {
        
        try {

            final String name = typeSchemeName.trim();

            if (StringUtils.isEmpty(name)) {
                
                // The TypeScheme has no components
                final TypeSchemeComponent[] typeSchemeComponents = new TypeSchemeComponent[0];
                return new TypeScheme(typeSchemeComponents);
                
            }

            final TypeSchemeNameTokenizer tokenizer = new TypeSchemeNameTokenizer(name);
            final String[] tokens = tokenizer.getTokens();
            
            final TypeSchemeComponent[] typeSchemeComponents = 
                new TypeSchemeComponent[tokens.length];
            
            for (int i = 0; i < tokens.length; i++) {

                if (tokens[i].startsWith("" + TypeSchemeNaming.TYPE_SCHEME_NAME_LITERAL_DELIMITER) &&
                            tokens[i].endsWith("" + TypeSchemeNaming.TYPE_SCHEME_NAME_LITERAL_DELIMITER)) {
                    
                    typeSchemeComponents[i] = 
                        new TypeSchemeComponent(
                                tokens[i].substring(1, tokens[i].length() - 1));
                    
                } else {
                    
                    final String[] tokenParts = StringUtils.split(tokens[i], " ");
                    switch (tokenParts.length) {
                        case 1:  
                            // no name specified for the component
                            typeSchemeComponents[i] = new TypeSchemeComponent(Types.forName(tokenParts[0]));
                            break;
                        case 2:
                            // a name was specified for the component
                            typeSchemeComponents[i] = new TypeSchemeComponent(Types.forName(tokenParts[0]), tokenParts[1]);
                            break;
                        default:
                            throw new TypeSchemeRecognitionException(typeSchemeName);
                    }
                    
                }
                
            }
            
            if (!canonical) {
                /*
                 * A TypeScheme can have more than one name, like "String" and "java.lang.String",
                 * so in order to avoid creating more than one object, before creating it it has
                 * to be looked up by its canonical name.
                 */ 
                final TypeSchemeRegistry typeSchemeRegistry = TypeSchemeRegistry.getInstance();
                return typeSchemeRegistry.forCanonicalName(createName(typeSchemeComponents));
            }
            return new TypeScheme(typeSchemeComponents);
            
        } catch (TypeSchemeRecognitionException e) {
            throw e;
        } catch (Exception e) {
            throw new TypeSchemeRecognitionException(typeSchemeName, e);
        }
        
    }

    
    final static boolean isAssignableFrom(
            final TypeScheme typeScheme, final TypeScheme fromTypeScheme) {

        if (typeScheme.getTypeSchemeComponentsArray().length != 
            fromTypeScheme.getTypeSchemeComponentsArray().length) {
            return false;
        }
        
        final TypeSchemeComponent[] typeSchemeComponents = 
            typeScheme.getTypeSchemeComponentsArray();
        final TypeSchemeComponent[] fromTypeSchemeComponents = 
            fromTypeScheme.getTypeSchemeComponentsArray();
        
        for (int i = 0; i < typeSchemeComponents.length; i++) {
            
            final TypeSchemeComponent currentTypeSchemeComponent = typeSchemeComponents[i];
            final TypeSchemeComponent fromCurrentTypeSchemeComponent = fromTypeSchemeComponents[i];
            
            if ((currentTypeSchemeComponent.isLiteral() && !fromCurrentTypeSchemeComponent.isLiteral()) ||
                (!currentTypeSchemeComponent.isLiteral() && fromCurrentTypeSchemeComponent.isLiteral())) {
                return false;
            }
            if (currentTypeSchemeComponent.isLiteral() && fromCurrentTypeSchemeComponent.isLiteral()) {
                if (!currentTypeSchemeComponent.getLiteral().equals(fromCurrentTypeSchemeComponent.getLiteral())) {
                    return false;
                }
            } else {
                if (!currentTypeSchemeComponent.getType().isAssignableFrom(fromCurrentTypeSchemeComponent.getType())) {
                    return false;
                }
            }

        }
        
        return true;
        
    }

    
    final static boolean isAssignableFrom(
            final TypeScheme typeScheme, final ObjectScheme objectScheme) {
        
        final TypeSchemeComponent[] typeSchemeComponents = 
            typeScheme.getTypeSchemeComponentsArray();
        final ObjectSchemeComponent[] objectSchemeComponents = 
            objectScheme.getObjectSchemeComponentsArray();
        
        if (typeSchemeComponents.length != objectSchemeComponents.length) {
            return false;
        }
        
        
        for (int i = 0; i < typeSchemeComponents.length; i++) {
            
            final TypeSchemeComponent currentTypeSchemeComponent = typeSchemeComponents[i];
            final ObjectSchemeComponent currentObjectSchemeComponent = objectSchemeComponents[i];
            
            if (currentObjectSchemeComponent == null) {
                
                // Everything can be assigned from null. Except for a literal.
                if (currentTypeSchemeComponent.isLiteral()) {
                    return false;
                }
                
            } else {

                if (currentTypeSchemeComponent.isLiteral()) {

                    if (currentObjectSchemeComponent.getObject() == null) {
                        return false;
                    }
                    if (!currentTypeSchemeComponent.getLiteral().equals(
                            currentObjectSchemeComponent.getObject().toString())) {
                        return false;
                    }
                    
                } else {

                    if (!currentTypeSchemeComponent.getType().isAssignableFrom(
                            currentObjectSchemeComponent.getType())) {
                        return false;
                    }
                    
                }
            
            }
            
        }
        
        return true;
        
    }
    

    
    final static String createNameFromTypeList(final List<Type> typeList) {
        final StrBuilder strBuilder = new StrBuilder();
        for (int i = 0; i < typeList.size(); i++) {
            if (i > 0) {
                strBuilder.append(TypeSchemeNaming.TYPE_SCHEME_NAME_SEPARATOR_SYMBOL);
            }
            strBuilder.append(typeList.get(i).getName()); 
        }
        return strBuilder.toString();
    }

    
    final static String createNameFromRawClasses(final Class<?>... classes) {
        final StrBuilder strBuilder = new StrBuilder();
        for (int i = 0; i < classes.length; i++) {
            if (i > 0) {
                strBuilder.append(TypeSchemeNaming.TYPE_SCHEME_NAME_SEPARATOR_SYMBOL);
            }
            strBuilder.append(classes[i].getName()); 
        }
        return strBuilder.toString();
    }

    
    final static String createName(final TypeSchemeComponent[] typeSchemeComponents) {
        final StrBuilder strBuilder = new StrBuilder();
        for (int i = 0; i < typeSchemeComponents.length; i++) {
            if (i > 0) {
                strBuilder.append(TypeSchemeNaming.TYPE_SCHEME_NAME_SEPARATOR_SYMBOL);
            }
            strBuilder.append(typeSchemeComponents[i].getStringRepresentation()); 
        }
        return strBuilder.toString();
    }

    
    
    final static String createTypeComponentStringRepresentation(final Type type, final String componentName) {
        return type.getName() + (StringUtils.isEmpty(componentName)? "" : " " + componentName);
    }

    
    
    final static String createLiteralComponentStringRepresentation(final String literal) {
        return TypeSchemeNaming.TYPE_SCHEME_NAME_LITERAL_DELIMITER + literal + 
                TypeSchemeNaming.TYPE_SCHEME_NAME_LITERAL_DELIMITER;
    }

    
    
    private final static class TypeSchemeNameTokenizer {
        
        private final String[] tokens;
        
        TypeSchemeNameTokenizer(final String name) {

            final List<String> tokenList = new ArrayList<String>();
            
            int index = 0;
            int lastStartIndex = 0;
            boolean literalOpen = false;
            int typeParametrizationDepth = 0;
            while (index < name.length()) {
                
                char c = name.charAt(index);
                if (c == TypeSchemeNaming.TYPE_SCHEME_NAME_SEPARATOR_SYMBOL) {
                    if ((!literalOpen) && (typeParametrizationDepth == 0)) {
                        tokenList.add(
                                name.substring(lastStartIndex, index).trim());
                        lastStartIndex = index + 1;
                    }
                } else if (c == TypeSchemeNaming.TYPE_SCHEME_NAME_LITERAL_DELIMITER) {
                    if (!literalOpen) {
                        literalOpen = true;
                    } else if ((index + 1) < name.length()) { 
                        final String remaining = name.substring(index + 1).trim();
                        if (remaining.startsWith(""+TypeSchemeNaming.TYPE_SCHEME_NAME_SEPARATOR_SYMBOL)) {
                            literalOpen = false;
                        }
                    }
                } else if (c == TypeSchemeNaming.TYPE_SCHEME_NAME_TYPE_PARAMETRIZATION_START_SYMBOL) {
                    if (!literalOpen) {
                        typeParametrizationDepth++;
                    }
                } else if (c == TypeSchemeNaming.TYPE_SCHEME_NAME_TYPE_PARAMETRIZATION_END_SYMBOL) {
                    if (!literalOpen) {
                        typeParametrizationDepth--;
                    }
                }
                
                index++;
                
            }
            tokenList.add(
                    name.substring(lastStartIndex, index).trim());
            
            this.tokens = tokenList.toArray(new String[tokenList.size()]);
            
        }
        
        String[] getTokens() {
            return this.tokens;
        }
        
    }



    private TypeSchemeUtil() {
        super();
    }
    
}
