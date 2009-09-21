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
package org.op4j.type;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;

/**
 * <p>
 * This class centralizes the methods for obtaining {@link Type} instances.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Types {

    /**
     * <p>
     * java.lang.Object type
     * </p>
     */
    public static final Type OBJECT = getRawTypeForClass(Object.class);
    
    /**
     * <p>
     * java.lang.Object[] type
     * </p>
     */
    public static final Type OBJECT_ARRAY = forName("Object[]");
    
    /**
     * <p>
     * java.lang.Byte type
     * </p>
     */
    public static final Type BYTE = getRawTypeForClass(Byte.class);
    
    /**
     * <p>
     * java.lang.Short type
     * </p>
     */
    public static final Type SHORT = getRawTypeForClass(Short.class);
    
    /**
     * <p>
     * java.lang.Integer type
     * </p>
     */
    public static final Type INTEGER = getRawTypeForClass(Integer.class);
    
    /**
     * <p>
     * java.lang.Long type
     * </p>
     */
    public static final Type LONG = getRawTypeForClass(Long.class);
    
    /**
     * <p>
     * java.lang.Float type
     * </p>
     */
    public static final Type FLOAT = getRawTypeForClass(Float.class);
    
    /**
     * <p>
     * java.lang.Double type
     * </p>
     */
    public static final Type DOUBLE = getRawTypeForClass(Double.class);
    
    /**
     * <p>
     * java.lang.Boolean type
     * </p>
     */
    public static final Type BOOLEAN = getRawTypeForClass(Boolean.class);
    
    /**
     * <p>
     * java.lang.String type
     * </p>
     */
    public static final Type STRING = getRawTypeForClass(String.class);
    
    /**
     * <p>
     * java.lang.Calendar type
     * </p>
     */
    public static final Type CALENDAR = getRawTypeForClass(Calendar.class);
    
    /**
     * <p>
     * java.lang.BigDecimal type
     * </p>
     */
    public static final Type BIG_DECIMAL = getRawTypeForClass(BigDecimal.class);
    
    /**
     * <p>
     * java.lang.BigInteger type
     * </p>
     */
    public static final Type BIG_INTEGER = getRawTypeForClass(BigInteger.class);
    
    /**
     * <p>
     * java.util.List<?> type
     * </p>
     */
    public static final Type LIST = getRawTypeForClass(List.class);
    
    /**
     * <p>
     * java.util.Set<?> type
     * </p>
     */
    public static final Type SET = getRawTypeForClass(Set.class);
    
    /**
     * <p>
     * java.util.Map<?,?> type
     * </p>
     */
    public static final Type MAP = getRawTypeForClass(Map.class);
    
    /**
     * <p>
     * java.util.Map<?,List<?>> type
     * </p>
     */
    public static final Type LIST_MAP = forName("Map<?,List<?>>");
    
    /**
     * <p>
     * java.util.Map<?,Set<?>> type
     * </p>
     */
    public static final Type SET_MAP = forName("Map<?,Set<?>>");
    
    /**
     * <p>
     * java.util.Map.Entry<?,?> type
     * </p>
     */
    public static final Type MAP_ENTRY = getRawTypeForClass(Map.Entry.class);

    
    
    /**
     * <p>
     * Returns a <tt>Type</tt> object from its name.
     * </p>
     * <p>
     * For naming a type, some class names can be abbreviated, as is the case
     * with classes in the <tt>java.lang</tt> and <tt>java.util</tt> packages. Any class
     * in those packages (like <tt>java.util.Set&lt;?&gt;</tt>) can be specified
     * without its package name (like "<tt>Set&lt;?&gt;</tt>").
     * </p>
     * 
     * @param typeName the name of the type which has to be returned
     * @return the desired type
     */
    public static Type forName(final String typeName) {
        Validate.notNull(typeName, "Type name cannot be null");
        final TypeRegistry typeRegistry = TypeRegistry.getInstance();
        return typeRegistry.forName(typeName);
    }

    
    /**
     * <p>
     * Given an object, returns the type composed by the object's raw class.
     * The object cannot be null.
     * </p>
     * <p>
     * For example, if <tt>obj</tt> is a <tt>List&lt;String&gt;</tt>,
     * this method will return the "<tt>List&lt;?&gt;</tt> type. Type
     * parameterization information is lost because it is not present
     * at runtime (only at compile-tyime).
     * </p>
     * 
     * @param object the object which raw class's type will be returned.
     * @return the desired type
     */
    public static Type getRawTypeForObject(final Object object) {
        Validate.notNull(object, "Object cannot be null");
        return getRawTypeForClass(object.getClass());
    }

    
    /**
     * <p>
     * Retrieves the <tt>Type</tt> object composed by the specified class.
     * </p>
     * 
     * @param typeClass the component class for the type
     * @return the desired type
     */
    public static Type getRawTypeForClass(final Class<?> typeClass) {
        Validate.notNull(typeClass, "Type class cannot be null");
        final TypeRegistry typeRegistry = TypeRegistry.getInstance();
        return typeRegistry.getRawTypeForClass(typeClass);
    }

    
    /**
     * <p>
     * Retrieves the <tt>Type</tt> object composed by the specified class, with
     * the specified array dimensions.
     * </p>
     * 
     * @param typeClass the component class for the type
     * @param arrayDimensions the array dimensions
     * @return the desired type
     */
    public static Type getRawTypeForClass(
            final Class<?> typeClass, final int arrayDimensions) {
        Validate.notNull(typeClass, "Type class cannot be null");
        Validate.isTrue(arrayDimensions >= 0, "Array dimensions must be greater of equal to zero");
        final StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < arrayDimensions; i++) {
            strBuilder.append("[]");
        }
        final TypeRegistry typeRegistry = TypeRegistry.getInstance();
        return typeRegistry.forName(typeClass.getName() + strBuilder.toString());
    }

    
    /**
     * <p>
     * Returns the correspondent raw version of a <tt>Type</tt>.
     * For example, for <tt>List&lt;String&gt;</tt> it will
     * return <tt>List&lt;?&gt;</tt>.
     * </p>
     * 
     * @param type the original type
     * @return the desired type
     */
    public static Type getRawTypeForType(final Type type) {
        Validate.notNull(type, "Type cannot be null");
        return TypeUtil.getRawTypeForType(type);
    }
    
    
    /**
     * <p>
     * Returns a <tt>Set</tt> with all the <tt>Type</tt>s that
     * are extended by the Type passed as a parameter.
     * </p>
     * 
     * @param type the type for which the extended types are required
     * @return the <tt>Set</tt> with the resultsbv
     */
    public static Set<Type> getExtendedTypes(final Type type) {
        Validate.notNull(type, "Type cannot be null");
        final TypeRegistry typeRegistry = TypeRegistry.getInstance();
        return typeRegistry.getExtendedTypes(type);
    }
    
    
    
    
    private Types() {
        super();
    }

    
}

