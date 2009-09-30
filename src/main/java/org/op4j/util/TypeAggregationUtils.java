package org.op4j.util;

import java.util.List;

import org.op4j.type.Type;
import org.op4j.type.Types;

public final class TypeAggregationUtils {

    


    public static Type createSetOfType(final Type originalType) {
        return Types.forName(
                "Set<" + 
                ((originalType != null)? originalType.getName() : "?") + 
                ">");
    }


    public static Type createListOfType(final Type originalType) {
        return Types.forName(
                "List<" + 
                ((originalType != null)? originalType.getName() : "?") + 
                ">");
    }


    public static Type createArrayOfType(final Type originalType) {
        return (originalType != null)?
                    originalType.increaseArrayDimensions() :
                    Types.OBJECT_ARRAY;
    }


    public static Type createMapOfType(final Type originalKeyType, final Type originalValueType) {
        return Types.forName(
                "Map<" + 
                ((originalKeyType != null)? originalKeyType.getName() : "?") + 
                "," + 
                ((originalValueType != null)? originalValueType.getName() : "?") + 
                ">");
    }


    public static Type createListMapOfType(final Type originalKeyType, final Type originalValueType) {
        return Types.forName(
                "Map<" + 
                ((originalKeyType != null)? originalKeyType.getName() : "?") + 
                ",List<" + 
                ((originalValueType != null)? originalValueType.getName() : "?") + 
                ">>");
    }


    public static Type createSetMapOfType(final Type originalKeyType, final Type originalValueType) {
        return Types.forName(
                "Map<" + 
                ((originalKeyType != null)? originalKeyType.getName() : "?") + 
                ",Set<" + 
                ((originalValueType != null)? originalValueType.getName() : "?") + 
                ">>");
    }


    public static Type createArrayMapOfType(final Type originalKeyType, final Type originalValueType) {
        return Types.forName(
                "Map<" + 
                ((originalKeyType != null)? originalKeyType.getName() : "?") + 
                "," + 
                ((originalValueType != null)? originalValueType.getName() : "Object") + 
                "[]>");
    }


    public static Type createMapEntryOfType(final Type originalKeyType, final Type originalValueType) {
        return Types.forName(
                "java.util.Map$Entry<" + 
                ((originalKeyType != null)? originalKeyType.getName() : "?") + 
                "," + 
                ((originalValueType != null)? originalValueType.getName() : "?") + 
                ">");
    }
    
    
    public static Type computeMostSpecificCommonClassType(final List<?> objects) {
        
        /*
         * For the new array that is to be created, it is better to be the most
         * specific it is possible, so that the user can perform all the casts
         * he/she thinks he/she can perform.
         * 
         * This means not returning an Object[] instead of a Calendar[], if we
         * can ensure that the array contents are Calendars.
         * 
         */
        Type computedArrayComponentRawType = null;
        for (Object component : objects) {
            if (component != null) {
                Type rawTypeForComponent = Types.getRawTypeForObject(component);
                if (computedArrayComponentRawType == null) {
                    computedArrayComponentRawType = rawTypeForComponent;
                } else {
                    computedArrayComponentRawType =
                        commonSuperTypeOf(computedArrayComponentRawType, rawTypeForComponent);
                }
            }
        }
        if (computedArrayComponentRawType == null) {
            // This can happen if all components in newTarget were null
            computedArrayComponentRawType = Types.OBJECT;
        }
        return computedArrayComponentRawType;
        
    }
    
    
    private static Type commonSuperTypeOf(final Type type1, final Type type2) {

        if (type1.equals(type2)) {
            return type1;
        }
        
        if (type1.equals(Types.OBJECT) || type2.equals(Types.OBJECT)) {
            return Types.OBJECT;
        }
        
        if (type1.isArray() || type2.isArray()) {
            if (type1.getArrayDimensions() == type2.getArrayDimensions()) {
                
                final int arrayDimensions = type1.getArrayDimensions();
                final Type plainType1 = Types.getRawTypeForClass(type1.getComponentClass());
                final Type plainType2 = Types.getRawTypeForClass(type2.getComponentClass());
                final Type common = commonSuperTypeOf(plainType1, plainType2);
                return Types.getRawTypeForClass(common.getComponentClass(), arrayDimensions);
                    
            } else if (type1.getArrayDimensions() > type2.getArrayDimensions()) {
                return Types.getRawTypeForClass(Object.class, type2.getArrayDimensions());
            } else { // (type1.getArrayDimensions() < type2.getArrayDimensions())
                return Types.getRawTypeForClass(Object.class, type1.getArrayDimensions());
            }
        } 

        Type common = type1;
        
        while (!common.equals(Types.OBJECT) && !common.isAssignableFrom(type2)) {
             Class<?> superClass = common.getRawClass().getSuperclass();
             if (superClass == null) {
                 common = Types.OBJECT;
             } else {
                 common = Types.getRawTypeForClass(superClass);
             }
         }

        return common;
        
    }
    
    
    
    private TypeAggregationUtils() {
        super();
    }
    
}
