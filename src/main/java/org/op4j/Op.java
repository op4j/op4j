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
package org.op4j;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.Validate;
import org.op4j.executables.Eval;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ListFunc;
import org.op4j.operators.impl.array.Level0ArrayOperator;
import org.op4j.operators.impl.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.impl.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.impl.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.impl.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.list.Level0ListOperator;
import org.op4j.operators.impl.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.impl.listoflist.Level0ListOfListOperator;
import org.op4j.operators.impl.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.impl.listofset.Level0ListOfSetOperator;
import org.op4j.operators.impl.map.Level0MapOperator;
import org.op4j.operators.impl.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.impl.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.impl.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.impl.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.impl.set.Level0SetOperator;
import org.op4j.operators.impl.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.impl.setoflist.Level0SetOfListOperator;
import org.op4j.operators.impl.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.impl.setofset.Level0SetOfSetOperator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericMultiOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Op {

    private static final String OP4J_INITIALIZATION_CLASS_NAME =
        "org.op4j.executables.functions.FunctionsInitialization";

    private static final String OP4J_CONTRIB_INITIALIZATION_CLASS_NAME =
        "org.op4j.contrib.operations.OperationsInitialization";

    private static final String INITIALIZATION_METHOD_NAME = "declareAndInitializeOperations";
    
    
    static {
        
        /*
         * Initialize basic op4j operators. This is done this way instead of
         * accessing the class directly to allow OperationsInitialization to
         * be non-public (and non-visible) and still be in the correct package. 
         */
        try {
            
            Class<?> clazz =
                Thread.currentThread().getContextClassLoader().loadClass(
                    OP4J_INITIALIZATION_CLASS_NAME);
            Method initializerMethod =
                clazz.getDeclaredMethod(INITIALIZATION_METHOD_NAME);
            initializerMethod.setAccessible(true);
            initializerMethod.invoke(null);
            initializerMethod.setAccessible(false);
            
        } catch (Exception impossible) {
            throw new RuntimeException(
                    "Broken library: could not initialize op4j", impossible);
        }
        
        
        /*
         * Try to initialize the "contrib" package, if it is present
         * in the classpath.
         */
        try {
            
            Class<?> clazz =
                Thread.currentThread().getContextClassLoader().loadClass(
                    OP4J_CONTRIB_INITIALIZATION_CLASS_NAME);
            Method initializerMethod =
                clazz.getDeclaredMethod(INITIALIZATION_METHOD_NAME);
            initializerMethod.setAccessible(true);
            initializerMethod.invoke(null);
            initializerMethod.setAccessible(false);
            
        } catch (Exception ignored) {
            // it wasn't
        }
        
    }
    
    
    private Op() {
        super();
    }

    
    public static <T> ILevel0GenericUniqOperator<T> on(final T target) {
        return new Level0GenericUniqOperator<T>(Target.forObject(target));
    }

    
    public static <T> ILevel0GenericMultiOperator<T> onAll(final T... targets) {
        return null;
    }

    
    public static ILevel0GenericMultiOperator<?> onAllObjs(final Object... targets) {
        return null;
    }

    
    public static <T> ILevel0GenericMultiOperator<T> onAll(final Of<T> of, final T... targets) {
        return null;
    }

    
    public static <T> ILevel0ArrayOperator<T> onArray(final Of<T> of, final T[] target) {
        Validate.notNull(of, "Array component cannot be null");
        return new Level0ArrayOperator<T>(of, Target.forObject(target));
    }

    
    public static <T> ILevel0ArrayOfArrayOperator<T> onArrayOfArray(final Of<T> of, final T[][] target) {
        Validate.notNull(of, "Array component cannot be null");
        return new Level0ArrayOfArrayOperator<T>(of, Target.forObject(target));
    }

    
    public static <T> ILevel0ArrayOfListOperator<T> onArrayOfList(final List<T>[] target) {
        return new Level0ArrayOfListOperator<T>(Target.forObject(target));
    }

    
    public static <K,V> ILevel0ArrayOfMapOperator<K,V> onArrayOfMap(final Map<K,V>[] target) {
        return new Level0ArrayOfMapOperator<K,V>(Target.forObject(target));
    }

    
    public static <T> ILevel0ArrayOfSetOperator<T> onArrayOfSet(final Set<T>[] target) {
        return new Level0ArrayOfSetOperator<T>(Target.forObject(target));
    }

    
    public static <T> ILevel0ListOperator<T> onList(final List<T> target) {
        return new Level0ListOperator<T>(Target.forObject(target));
    }

    
    public static <T> ILevel0ListOfArrayOperator<T> onListOfArray(final Of<T> of, final List<? extends T[]> target) {
        Validate.notNull(of, "Array component cannot be null");
        return new Level0ListOfArrayOperator<T>(of, Target.forObject(target));
    }

    
    public static <T> ILevel0ListOfListOperator<T> onListOfList(final List<? extends List<T>> target) {
        return new Level0ListOfListOperator<T>(Target.forObject(target));
    }

    
    public static <K,V> ILevel0ListOfMapOperator<K,V> onListOfMap(final List<? extends Map<K,V>> target) {
        return new Level0ListOfMapOperator<K,V>(Target.forObject(target));
    }

    
    public static <T> ILevel0ListOfSetOperator<T> onListOfSet(final List<? extends Set<T>> target) {
        return new Level0ListOfSetOperator<T>(Target.forObject(target));
    }

    
    public static <K,V> ILevel0MapOperator<K,V> onMap(final Map<K,V> target) {
        return new Level0MapOperator<K,V>(Target.forObject(target));
    }

    
    public static <K,V> ILevel0MapOfArrayOperator<K,V> onMapOfArray(final Of<V> of, final Map<K,V[]> target) {
        Validate.notNull(of, "Array component cannot be null");
        return new Level0MapOfArrayOperator<K,V>(of, Target.forObject(target));
    }

    
    public static <K,V> ILevel0MapOfListOperator<K,V> onMapOfList(final Map<K,? extends List<V>> target) {
        return new Level0MapOfListOperator<K,V>(Target.forObject(target));
    }

    
    public static <K1,K2,V> ILevel0MapOfMapOperator<K1,K2,V> onMapOfMap(final Map<K1,? extends Map<K2,V>> target) {
        return new Level0MapOfMapOperator<K1,K2,V>(Target.forObject(target));
    }

    
    public static <K,V> ILevel0MapOfSetOperator<K,V> onMapOfSet(final Map<K,? extends Set<V>> target) {
        return new Level0MapOfSetOperator<K,V>(Target.forObject(target));
    }

    
    public static <T> ILevel0SetOperator<T> onSet(final Set<T> target) {
        return new Level0SetOperator<T>(Target.forObject(target));
    }

    
    public static <T> ILevel0SetOfArrayOperator<T> onSetOfArray(final Of<T> of, final Set<? extends T[]> target) {
        Validate.notNull(of, "Array component cannot be null");
        return new Level0SetOfArrayOperator<T>(of, Target.forObject(target));
    }

    
    public static <T> ILevel0SetOfListOperator<T> onSetOfList(final Set<? extends List<T>> target) {
        return new Level0SetOfListOperator<T>(Target.forObject(target));
    }

    
    public static <K,V> ILevel0SetOfMapOperator<K,V> onSetOfMap(final Set<? extends Map<K,V>> target) {
        return new Level0SetOfMapOperator<K,V>(Target.forObject(target));
    }

    
    public static <T> ILevel0SetOfSetOperator<T> onSetOfSet(final Set<? extends Set<T>> target) {
        return new Level0SetOfSetOperator<T>(Target.forObject(target));
    }


    
    
    public static void main(String[] args) {
        


        final String[] stringsArr1 = new String[] {"Hello", "Goodbye", null};
        final List<String> stringsList1 = Arrays.asList(stringsArr1);
        
        final String[][] stringsStrings1 = new String[][] { new String[] {"Hello!","Goodbye!"}, new String[]{"¡Hola!","¡Adiós!"}};
        final List<String>[] stringsListStrings1 = (List<String>[]) new List<?>[] { Arrays.asList(new String[] {"Hello!","Goodbye!"}), Arrays.asList(new String[]{"¡Hola!","¡Adiós!"})};
        final List<List<String>> stringsListStringsList1 = Arrays.asList(stringsListStrings1);
        
        final Map<String,String> map1 = new LinkedHashMap<String,String>();
        map1.put("es", "¡Hola!");
        map1.put("en", "Hello!");
        map1.put("gl", "Ola!");
        map1.put("ca", "Hola!");
        
        final Map<String,String> map2 = new LinkedHashMap<String,String>();
        map2.put("es", "¡Adiós!");
        map2.put("en", "Goodbye!");
        map2.put("gl", "Adéus!");
        map2.put("ca", "Adéu!");
        map2.put("fr", "Adieu!");
        
        final Map<String,String>[] maps1 = (Map<String, String>[]) new Map<?,?>[] { map1, map2 };

        
        System.out.println(Op.onList(stringsList1).get());
        System.out.println(Op.onList(stringsList1).forEach().get());
        System.out.println(Op.onList(stringsList1).forEachNotNull().eval(Eval.stringExp("toUpperCase()")).get());
        
        
        System.out.println(Op.onArrayOfArray(Of.STRING, stringsStrings1).forEach().forEach().eval(Eval.integerExp("length()")).get());
        
        System.out.println(Arrays.asList(Op.onArrayOfList(stringsListStrings1).forEach().forEach().eval(Eval.stringExp("toUpperCase()")).get()));

        System.out.println(Arrays.asList(Op.onArrayOfMap(maps1).forEach("size() > 6").forEachEntry().onValue().eval(Eval.stringExp("toUpperCase()"))));
        
        System.out.println(Arrays.asList(Op.onArrayOfArray(Of.STRING, stringsStrings1).forEach().forEach("length() > 6").eval(Eval.stringExp("toUpperCase()")).get()[0]));
        
        System.out.println(Op.onListOfList(stringsListStringsList1).forEach().forEach().get());
        
        System.out.println(Op.onListOfList(stringsListStringsList1).forEach().forEach().callInteger("length").get());
        
        
        System.out.println(Op.onListOfList(stringsListStringsList1).forEach().forEach().callInteger("length").convToString().convToString("TO_UPPERCASE").get());
        
        System.out.println(Op.on(Calendar.getInstance()).convToString("dd/MMM, yyyy").get());
        
        System.out.println(Op.onListOfList(stringsListStringsList1).forEach().forEach().callInteger("length").convToString().convToInteger().get());
        
        System.out.println(Op.on(Float.valueOf(3455234.6325f)).convToInteger(RoundingMode.CEILING).get());
        
        System.out.println(Op.on(Float.valueOf(3455234.6325f)).convToBigInteger(RoundingMode.FLOOR).get());
        
        System.out.println(Op.on(Double.valueOf(3455234.6325343252454353)).convToBigDecimal(8, RoundingMode.HALF_UP).get());
        
        final BigDecimal bd = new BigDecimal("3455234.6325");
        final Float f = Float.valueOf(3455234.6325f);
        final Double d = Double.valueOf(3455234.6325);
        
        System.out.println(bd.doubleValue());
        System.out.println(f);
        System.out.println(d);
        
        System.out.println(Op.on(new Integer[] {2009, 11, 25, 13, 20, 50}).convToCalendar().convToString(LocaleUtils.toLocale("gl_ES")).get());
        
        System.out.println(Op.onList(Arrays.asList(new Integer[] {2,3,4,1,2,2,4,5,2,3,5,6,87,45,2,3,34,1})).get());
        System.out.println(Op.onList(Arrays.asList(new Integer[] {2,3,4,1,2,2,4,5,2,3,5,6,87,45,2,3,34,1})).distinct().get());
        
        final List<List<String>> listOfListOfString1 = 
        	Arrays.asList((List<String>[]) new List<?>[] { Arrays.asList(new String[] {"a", "b", "a"}), Arrays.asList(new String[] {"a", "b", "a"})});
        
        final String[][] arrayOfArrayOfString1 = 
        	new String[][] { new String[] {"a", "b", "a"}, new String[] {"a", "b", "a"}};
        
        System.out.println(Op.onListOfList(listOfListOfString1).get());
        System.out.println(Op.onListOfList(listOfListOfString1).distinct().get());
        System.out.println(Op.onListOfList(listOfListOfString1).forEach().distinct().get());
        
        System.out.println(printArray(Op.onArrayOfArray(Of.STRING,arrayOfArrayOfString1).get()));
        System.out.println(printArray(Op.onArrayOfArray(Of.STRING,arrayOfArrayOfString1).distinct().get()));
        System.out.println(printArray(Op.onArrayOfArray(Of.STRING,arrayOfArrayOfString1).forEach().distinct().get()));
     
        System.out.println(Op.onList(stringsList1).add("World!").get());
        System.out.println(Op.onList(stringsList1).add(1,"World!").get());
        System.out.println(Op.onList(stringsList1).addAllValues("World!", "Mars!").get());
        System.out.println(Op.onList(stringsList1).addAllValues(1, "World!", "Mars!").get());
        System.out.println(Op.onList(stringsList1).addAll(stringsList1).get());
        System.out.println(Op.onListOfList(listOfListOfString1).add(Collections.singletonList("Uhey!")).distinct().get());
        System.out.println("---");
        System.out.println(Op.onList(stringsList1).get());
        System.out.println(Op.onList(stringsList1).remove(1).get());
        System.out.println(Op.onList(stringsList1).removeValue(null).get());
        System.out.println(Op.onList(stringsList1).removeValue("Goodbye").get());
        System.out.println(Op.onList(stringsList1).removeAll(0,2).get());
        System.out.println(Op.onList(stringsList1).removeAllNot(0).get());
        System.out.println(Op.onList(stringsList1).removeAllNot(0,2).get());
        System.out.println(Op.onList(stringsList1).removeAllValuesNot("Hello").get());
        System.out.println(Op.onList(stringsList1).removeAllValuesNot((String)null).get());
        System.out.println(Op.onList(stringsList1).removeAll("#target eq 'Hello'").get());
        System.out.println(Op.onList(stringsList1).removeAll(new ISelect<String>() {

			public boolean eval(String target) {
				return target == null;
			}
        	
        }).get());
        System.out.println(Op.onList(stringsList1).removeAllNull().get());
        System.out.println(Op.onList(stringsList1).removeAllNotNullAnd("length() > 5").get());
        System.out.println(Op.onList(stringsList1).removeAllNullOr("length() > 5").get());
            
        System.out.println(Op.onListOfList(listOfListOfString1).forEach(1).add("c").get());
    }
    
    
    private static String printArray(Object[] array) {
    	final List<Object> components = new ArrayList<Object>();
    	for (final Object component : array) {
    		if (component instanceof Object[]) {
    			components.add(printArray((Object[])component));
    		} else {
    			components.add(component);
    		}
    	}
    	return components.toString();
    }
    
}
