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

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.op4j.type.Type;


/**
 * <p>
 * This is the central and basic factory class for {@link TypeScheme} objects. Every
 * <tt>TypeScheme</tt> object should be exclusively obtained by means of this 
 * class's methods.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class TypeSchemes {

    /**
     * Type scheme constant: ""
     */
    public static final TypeScheme EMPTY_TYPESCHEME = forName("");
    
    /**
     * Type scheme constant: "java.lang.Object"
     */
    public static final TypeScheme OBJECT_TYPESCHEME = forName("Object");
    
    /**
     * Type scheme constant: "java.lang.Class"
     */
    public static final TypeScheme CLASS_TYPESCHEME = forName("Class");
    
    /**
     * Type scheme constant: "java.lang.String"
     */
    public static final TypeScheme STRING_TYPESCHEME = forName("String");
    
    /**
     * Type scheme constant: "java.lang.Number"
     */
    public static final TypeScheme NUMBER_TYPESCHEME = forName("Number");
    
    /**
     * Type scheme constant: "java.lang.Double"
     */
    public static final TypeScheme DOUBLE_TYPESCHEME = forName("Double");
    
    /**
     * Type scheme constant: "java.lang.Float"
     */
    public static final TypeScheme FLOAT_TYPESCHEME = forName("Float");
    
    /**
     * Type scheme constant: "java.lang.Byte"
     */
    public static final TypeScheme BYTE_TYPESCHEME = forName("Byte");
    
    /**
     * Type scheme constant: "java.lang.Short"
     */
    public static final TypeScheme SHORT_TYPESCHEME = forName("Short");
    
    /**
     * Type scheme constant: "java.lang.Integer"
     */
    public static final TypeScheme INTEGER_TYPESCHEME = forName("Integer");
    
    /**
     * Type scheme constant: "java.lang.Long"
     */
    public static final TypeScheme LONG_TYPESCHEME = forName("Long");
    
    /**
     * Type scheme constant: "java.math.BigInteger"
     */
    public static final TypeScheme BIGINTEGER_TYPESCHEME = forName("java.math.BigInteger");
    
    /**
     * Type scheme constant: "java.math.BigDecimal"
     */
    public static final TypeScheme BIGDECIMAL_TYPESCHEME = forName("java.math.BigDecimal");
    
    /**
     * Type scheme constant: "java.lang.Boolean"
     */
    public static final TypeScheme BOOLEAN_TYPESCHEME = forName("Boolean");
    
    /**
     * Type scheme constant: "java.util.Locale"
     */
    public static final TypeScheme LOCALE_TYPESCHEME = forName("Locale");
    
    /**
     * Type scheme constant: "java.lang.Object[]"
     */
    public static final TypeScheme OBJECTARRAY_TYPESCHEME = forName("Object[]");
    
    /**
     * Type scheme constant: "java.util.List"
     */
    public static final TypeScheme LIST_TYPESCHEME = forName("List");
    
    /**
     * Type scheme constant: "java.util.Set"
     */
    public static final TypeScheme SET_TYPESCHEME = forName("Set");
    
    /**
     * Type scheme constant: "java.util.Iterable"
     */
    public static final TypeScheme ITERABLE_TYPESCHEME = forName("Iterable");
    
    /**
     * Type scheme constant: "java.util.Date"
     */
    public static final TypeScheme JAVAUTILDATE_TYPESCHEME = forName("java.util.Date");
    
    /**
     * Type scheme constant: "java.sql.Date"
     */
    public static final TypeScheme JAVASQLDATE_TYPESCHEME = forName("java.sql.Date");
    
    /**
     * Type scheme constant: "java.sql.Timestamp"
     */
    public static final TypeScheme TIMESTAMP_TYPESCHEME = forName("java.sql.Timestamp");
    
    /**
     * Type scheme constant: "java.util.Calendar"
     */
    public static final TypeScheme CALENDAR_TYPESCHEME = forName("java.util.Calendar");
    
    
    
    /**
     * <p>
     * Retrieves a <tt>TypeScheme</tt> by its name. A type scheme's name
     * is its String representation (for example: <tt>String;Integer;'COMMAND'</tt>.
     * </p>
     * 
     * @param typeSchemeName the name of the typescheme
     * @return the type scheme, possibly retrieved from the synchronized cache
     */
    public static TypeScheme forName(final String typeSchemeName) {
        Validate.notNull(typeSchemeName, "Type scheme name cannot be null");
        final TypeSchemeRegistry typeSchemeRegistry = TypeSchemeRegistry.getInstance();
        return typeSchemeRegistry.forName(typeSchemeName);
    }
    
    
    /**
     * <p>
     * Retrieves a <tt>TypeScheme</tt> which contains only one component
     * with the {@link Type} passed as a parameter.
     * </p>
     * 
     * @param type the type to be included in the type scheme's unique component.
     * @return the type scheme
     */
    public static TypeScheme forSingleType(final Type type) {
        Validate.notNull(type, "Type cannot be null");
        return forTypes(type);
    }
    
    
    /**
     * <p>
     * Retrieves a <tt>TypeScheme</tt> which contains only one component
     * with the {@link Type} passed as a parameter, repeated a number of times.
     * </p>
     * 
     * @param type the type to be included in the type scheme's unique component.
     * @param times the number of times the type should be repeated
     * @return the type scheme
     */
    public static TypeScheme forSingleType(final Type type, int times) {
        Validate.notNull(type, "Type cannot be null");
        final Type[] types = new Type[times];
        Arrays.fill(types, type);
        return forTypes(types);
    }
    
    
    /**
     * <p>
     * Retrieves a <tt>TypeScheme</tt> which contains only one component
     * with the raw {@link Type} associated to the <tt>Class</tt> passed 
     * as a parameter.
     * </p>
     * 
     * @param singleTypeSchemeClass the type to be included in the type scheme's unique component.
     * @return the type scheme
     */
    public static TypeScheme forSingleClass(final Class<?> singleTypeSchemeClass) {
        Validate.notNull(singleTypeSchemeClass, "Class cannot be null");
        return forName(TypeSchemeUtil.createNameFromRawClasses(singleTypeSchemeClass));
    }
    
    
    /**
     * <p>
     * Retrieves a <tt>TypeScheme</tt> which contains only one component
     * with the raw {@link Type} associated to the <tt>Class</tt> passed 
     * as a parameter, repeated a number of times.
     * </p>
     * 
     * @param singleTypeSchemeClass the type to be included in the type scheme's unique component.
     * @param times the number of times the type should be repeated
     * @return the type scheme
     */
    public static TypeScheme forSingleClass(final Class<?> singleTypeSchemeClass, int times) {
        Validate.notNull(singleTypeSchemeClass, "Class cannot be null");
        final Class<?>[] classes = new Class[times];
        Arrays.fill(classes, singleTypeSchemeClass);
        return forName(TypeSchemeUtil.createNameFromRawClasses(classes));
    }
    
    
    /**
     * <p>
     * Retrieves a <tt>TypeScheme</tt> which contains the 
     * {@link Type}s passed as a parameter, in the same order.
     * </p>
     * 
     * @param types the types to be included in the type scheme.
     * @return the type scheme
     */
    public static TypeScheme forTypes(final Type... types) {
        Validate.notNull(types, "Types cannot be null");
        return forTypeList(Arrays.asList(types));
    }
    
    
    /**
     * <p>
     * Retrieves a <tt>TypeScheme</tt> which contains the 
     * {@link Type}s passed as a parameter, in the same order.
     * </p>
     * 
     * @param typeList the list containing the types to be included in the type scheme.
     * @return the type scheme
     */
    public static TypeScheme forTypeList(final List<Type> typeList) {
        Validate.notNull(typeList, "Type list cannot be null");
        Validate.isTrue(typeList.size() > 0, "At least one type must be specified");
        Validate.isTrue(!typeList.contains(null), "Cannot create type scheme containing a null type");
        return forName(TypeSchemeUtil.createNameFromTypeList(typeList));
    }
    
    
    /**
     * <p>
     * Retrieves a <tt>TypeScheme</tt> which contains the 
     * raw {@link Type}s for the <tt>Class</tt>es passed as a parameter, 
     * in the same order.
     * </p>
     * 
     * @param classes the list containing the classes to be included in the type scheme.
     * @return the type scheme
     */
    public static TypeScheme forClasses(final Class<?>... classes) {
        Validate.notNull(classes, "Classes cannot be null");
        Validate.isTrue(classes.length > 0, "At least one class must be specified");
        return forName(TypeSchemeUtil.createNameFromRawClasses(classes));
    }
    
    
    private TypeSchemes() {
        super();
    }
    
}
