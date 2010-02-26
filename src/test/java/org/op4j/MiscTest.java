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

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.time.StopWatch;
import org.javaruntype.type.Types;
import org.junit.Test;
import org.op4j.functions.DecimalPoint;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.FnCalendar;
import org.op4j.functions.FnString;
import org.op4j.functions.IFunction;
import org.op4j.functions.Ognl;
import org.op4j.functions.converters.ToCalendar;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToMapOfArray;
import org.op4j.functions.structures.FArray;
import org.op4j.functions.structures.FList;
import org.op4j.functions.structures.FSet;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class MiscTest {

    
    
    
    @Test
    public void test() {
        
        
final StopWatch watch = new StopWatch();
watch.start();
        


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
        System.out.println(Op.onList(stringsList1).forEach().ifNotNull().exec(Ognl.asString("toUpperCase()")).get());
        
        
        
        final BigDecimal bd = new BigDecimal("3455234.6325");
        final Float f = Float.valueOf(3455234.6325f);
        final Double d = Double.valueOf(3455234.6325);
        
        System.out.println(bd.doubleValue());
        System.out.println(f);
        System.out.println(d);
        
        System.out.println(Op.onList(Arrays.asList(new Integer[] {2,3,4,1,2,2,4,5,2,3,5,6,87,45,2,3,34,1})).get());
        System.out.println(Op.onList(Arrays.asList(new Integer[] {2,3,4,1,2,2,4,5,2,3,5,6,87,45,2,3,34,1})).distinct().get());
        
        final List<List<String>> listOfListOfString1 = 
            Arrays.asList((List<String>[]) new List<?>[] { Arrays.asList(new String[] {"a", "b", "a"}), Arrays.asList(new String[] {"a", "b", "a"})});
        
        final Set<Set<String>> setOfsetOfString1 = 
            new LinkedHashSet<Set<String>>(Arrays.asList((Set<String>[]) new Set<?>[] { new LinkedHashSet<String>(Arrays.asList(new String[] {"a", "b", "a"})), new LinkedHashSet<String>(Arrays.asList(new String[] {"a", "b", "a"}))}));
        
        final String[][] arrayOfArrayOfString1 = 
            new String[][] { new String[] {"a", "b", "a"}, new String[] {"a", "b", "a"}};
     
        System.out.println(Op.onList(stringsList1).addAll("World!", "Mars!").get());
        System.out.println(Op.onList(stringsList1).insertAll(1, "World!", "Mars!").get());
        System.out.println(Op.onList(stringsList1).addAll(stringsList1).get());
        System.out.println(Op.onList(stringsList1).get());
        System.out.println(Op.onList(stringsList1).removeAllIndexes(0,2).get());
        System.out.println(Op.onList(stringsList1).removeAllIndexesNot(0).get());
        System.out.println(Op.onList(stringsList1).removeAllIndexesNot(0,2).get());
        System.out.println(Op.onList(stringsList1).removeAllTrue(Ognl.asBoolean("#target eq 'Hello'")).get());
        System.out.println(Op.onList(stringsList1).removeAllTrue(new IFunction<String,Boolean>() {

            public Boolean execute(String target, final ExecCtx ctx) {
                return Boolean.valueOf(target == null);
            }
            
        }).get());
        System.out.println(Op.onList(stringsList1).removeAllNull().get());
        System.out.println(Op.onList(stringsList1).removeAllNotNullAndTrue(Ognl.asBoolean("length() > 5")).get());
            
        System.out.println("================");
        
        
        final Set<String> stringSet1 = new LinkedHashSet<String>(stringsList1);
        System.out.println(Op.onSet(stringSet1).addAll("World!", "Mars!").get());
        System.out.println(Op.onSet(stringSet1).insertAll(1, "World!", "Mars!").get());
        System.out.println(Op.onSet(stringSet1).addAll(stringsList1).get());
        System.out.println("---");
        System.out.println(Op.onSet(stringSet1).get());
        System.out.println(Op.onSet(stringSet1).removeAllIndexes(0,2).get());
        System.out.println(Op.onSet(stringSet1).removeAllIndexesNot(0).get());
        System.out.println(Op.onSet(stringSet1).removeAllIndexesNot(0,2).get());
        System.out.println(Op.onSet(stringSet1).removeAllTrue(Ognl.asBoolean("#target eq 'Hello'")).get());
        System.out.println(Op.onSet(stringSet1).removeAllNull().get());
        System.out.println(Op.onSet(stringSet1).removeAllNotNullAndTrue(Ognl.asBoolean("length() > 5")).get());
            
        System.out.println(printArray(Op.onArrayOf(Types.STRING, stringsArr1).insertAll(2,"lalero","lururu").get()));
     
        
        System.out.println(Op.onMap(map1).put("fr", "Allô!").get());
        System.out.println(Op.onMap(map1).insert(0,"fr", "Allô!").get());
        System.out.println(Op.onMap(map1).insert(2,"fr", "Allô!").get());
        System.out.println(Op.onMap(map2).get());
        System.out.println(Op.onMap(map2).putAll(Op.onMap(map1).insert(0,"gl", "Meuuuu!").get()).get());
        System.out.println(Op.onMap(map2).putAll(Op.onMap(map1).insert(0,"gl", "Meuuuu!").get()).removeAllTrue(Ognl.asBoolean("!#target.key.startsWith('e')")).get());
        
        System.out.println(Op.onAll(234,12,231));
        System.out.println(Op.on(234).addAll(10));
        System.out.println(Op.on(234).insert(0,10));
        System.out.println(Op.on(234).addAll(10).insert(1,3));
        System.out.println(Op.on(234).addAll(10).insert(1,3).addAll((Integer)null));
        System.out.println(Op.on(234).addAll(10).insert(1,3).addAll((Integer)null).removeAllNull());
        System.out.println(Op.on(234).addAll(10).insert(1,3).removeAllIndexesNot(1));
        System.out.println(Op.on(234).addAll(10).insert(1,3).removeAllTrue(Ognl.asBoolean("#target > 100")));
        System.out.println(printArray(Op.on(234).addAll(10).insert(1,3).removeAllTrue(Ognl.asBoolean("#target > 100")).buildArrayOf(Types.INTEGER).get()));
        System.out.println(printArray(Op.on(234).buildArrayOf(Types.INTEGER).addAll(8).get()));
        System.out.println(Op.on((List)null).addAll(123));
        System.out.println(Op.on((Object)null).buildList().get());
        System.out.println(Op.on((Object)null).buildSet().get());
        System.out.println(printArray(Op.on((String)null).buildArrayOf(Types.STRING).addAll("a").removeAllNull().removeAllIndexes(0).get()));
        
//        System.out.println(printArray(Op.buildArrayOfArray(Types.STRING).addAll(Op.buildArray(Types.STRING).addAll("a","b").get()).addAll(Op.buildArray(Types.STRING).addAll("1","2","3").get()).get()));
//        System.out.println(Op.buildMap(Types.INTEGER,Types.STRING).put(12,"hello!").get());
        System.out.println(Op.onAll("a",1,"b",3).buildMap().get());
        System.out.println(Op.onAll("hello", "goodbye").buildMap(Ognl.asInteger("length()")).get());
        
        System.out.println(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildMapOfSet(Ognl.asInteger("length()")).get());
        System.out.println(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildMapOfList(Ognl.asInteger("length()")).get());
        
        System.out.println(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildMapOfArrayOf(Types.STRING, Ognl.asInteger("length()")).get());
        
        System.out.println(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildList().sort().get());
        System.out.println(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildSet().sort(new Comparator<String>() {

            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                } else if (o1.length() == o2.length()) {
                    return 0;
                }
                return 1;
            }
            
        }).get());
        
        System.out.println(printArray(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildArrayOf(Types.STRING).sort().get()));
        System.out.println(printArray(Op.onAll("hello", "goodbye", "adios", "ciao", "hola").buildArrayOf(Types.STRING).sort(new Comparator<String>() {

            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                } else if (o1.length() == o2.length()) {
                    return 0;
                }
                return 1;
            }
            
        }).get()));
        
        
        System.out.println(Op.on("12314123.4123").exec(FnString.toInteger(RoundingMode.CEILING, DecimalPoint.IS_POINT)).get());
        System.out.println(Op.on("12314123.4123").exec(FnString.toInteger(RoundingMode.CEILING, DecimalPoint.IS_POINT)).get());
        System.out.println(Op.on("12314123").exec(FnString.toInteger()).get());
        System.out.println(Op.on("12314123").exec(FnString.toLong()).get());
        System.out.println(Op.on("12314123").exec(FnString.toBigInteger()).get());
        System.out.println(Op.on("12314123.4123").exec(FnString.toDouble()).get());
        System.out.println(Op.on("12314123.4123").exec(FnString.toDouble(3, RoundingMode.CEILING)).get());
        System.out.println(Op.on("12314123.4123").exec(FnString.toBigDecimal(3, RoundingMode.CEILING)).get());
        
        final SimpleDateFormat dateFormat = new SimpleDateFormat();
        System.out.println(dateFormat.format(Op.on(Calendar.getInstance()).exec(new ToCalendar.FromCalendar(Calendar.DATE)).get().getTime()));
        
        System.out.println(dateFormat.format(Op.on("25/nov/1979").exec(ToCalendar.fromString("dd/MMM/yyyy", "es")).get().getTime()));
        
//        System.out.println(dateFormat.format(Op.onAll(1979, 11, 25, 12, 30).buildList().exec(ToCalendar.fromString("dd/MMM/yyyy", "es")).get().getTime()));
        System.out.println(dateFormat.format(Op.on(Op.onAll(1979, 11, 25, 12, 30).buildList().get()).exec(ToCalendar.fromIntegerFieldList()).get().getTime()));
        System.out.println(dateFormat.format(Op.on(Op.onAll("1979", "11", "25", "12", "30").buildArrayOf(Types.STRING).get()).exec(ToCalendar.fromStringFieldArray()).get().getTime()));
        
        System.out.println(Op.on(Op.onAll(1979, 11, 25, 12, 30).buildList().get()).exec(new FList.Sort<Integer>()).get());
        System.out.println(Op.on(Op.onAll(1979, 11, 25, 12, 30).buildSet().get()).exec(new FSet.Sort<Integer>()).get());
        System.out.println(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildList().get()).exec(new FList.Distinct<Integer>()).get());
        
        System.out.println(printArray(Op.on(Op.onAll(1979, 11, 25, 12, 30).buildArrayOf(Types.INTEGER).get()).exec(new FArray.Sort<Integer>()).get()));
        System.out.println(printArray(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildArrayOf(Types.INTEGER).get()).exec(new FArray.Distinct<Integer>()).get()));
        
        
        System.out.println(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildList().get()).exec(new FList.Insert<Integer>(2, 1492)).get());
        
        System.out.println(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildList().get()).exec(new FList.Insert<Integer>(2, 1492)).exec(new FList.RemoveAllTrue<Integer>(Ognl.asBoolean("#target < 1000"))).exec(new FList.Sort<Integer>()).get());
        
        
        System.out.println(printArray(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildArrayOf(Types.INTEGER).get()).exec(new FArray.Insert<Integer>(2, 1492)).get()));
        
        System.out.println(printArray(Op.on(Op.onAll(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).buildArrayOf(Types.INTEGER).get()).exec(new FArray.Insert<Integer>(2, 1492)).exec(new FArray.RemoveAllTrue<Integer>(Ognl.asBoolean("#target < 1000"))).exec(new FArray.Sort<Integer>()).get()));
        
        System.out.println(Op.on(Op.onAll("hello", "hola", "ciao", "ola", "olá", "hallô", "hallo", "hej").buildArrayOf(Types.STRING).get()).exec(new ToMap.FromArrayByKeyEval<Integer,String>(Ognl.asInteger("length()"))).get());

        final Map<Integer,String[]> greetingsByLength = 
            Op.on(Op.onAll("hello", "hola", "ciao", "ola", "olá", "hallô", "hallo", "hej").buildArrayOf(Types.STRING).get()).exec(new ToMapOfArray.FromArrayByKeyEval<Integer, String>(Types.STRING, Ognl.asInteger("length()"))).get();
        System.out.println("*** MAP: ");
        for (Map.Entry<Integer,String[]> entry : greetingsByLength.entrySet()) {
            System.out.println(entry.getKey() + " : " + Arrays.asList(entry.getValue()));
        }
        System.out.println("***");


        System.out.println(Op.on("hello").addAll("goodbye"));
        System.out.println(Op.on("hello").buildList().get());
        System.out.println(printArray(Op.on("hello").buildArrayOf(Types.STRING).get()));
        System.out.println(Op.on("hello").buildMap(Ognl.asInteger("length()")).get());
        System.out.println(Op.on("hello").buildMapOfList(Ognl.asInteger("length()")).get());
        System.out.println(Op.onAll(12, "hello", 14, "goodbye").buildMapOfList().get());
        
        
//        System.out.println(Op.buildList(Types.CALENDAR)
//              .addAll(Calendar.getInstance(), Calendar.getInstance())
//              .forEach().exec(ToString.fromCalendar(DateStyle.FULL, TimeStyle.NONE, Locale.UK)).get());
//        
//        System.out.println(Op.buildList(Types.CALENDAR)
//              .addAll(Calendar.getInstance(), Calendar.getInstance())
//              .forEach().exec(ToString.fromCalendar(DateStyle.FULL, TimeStyle.SHORT, Locale.UK)).get());
//        
//        System.out.println(Op.buildList(Types.CALENDAR)
//              .addAll(Calendar.getInstance(), Calendar.getInstance())
//              .forEach().exec(ToString.fromCalendar("dd-MMM-yyyy", Locale.UK)).get());
//            
//        System.out.println(Op.buildList(Types.CALENDAR)
//              .addAll(Calendar.getInstance(), Calendar.getInstance())
//              .forEach().exec(ToString.fromCalendar("dd-MMMM-yyyy")).get());
//        
//        System.out.println(Op.buildList(Types.DATE)
//              .addAll(new java.sql.Date(Calendar.getInstance().getTimeInMillis()))
//              .forEach().exec(ToString.fromDate("dd-MMM-yyyy", Locale.UK)).get());
//        
//        
//        System.out.println(Op.buildList(Types.STRING)
//              .addAll("  Company ", " day ")
//              .forEach().exec(StringFuncs.trim()).get());
//        System.out.println(Op.buildList(Types.STRING)
//              .addAll("  Company ", " day ")
//              .forEach().exec(StringFuncs.trim()).exec(StringFuncs.toUpperCase()).get());
        
        System.out.println(Op.on("Dublin")
                .exec(FnString.toHexadecimal(Charset.forName("ISO-8859-1")))
                .exec(FnString.fromHexadecimal(Charset.forName("ISO-8859-1"))).get());
        
//        System.out.println(Op.buildList(Types.NUMBER)
//                .addAll(45.9, new BigDecimal(34.456))
//                .forEach().exec(ToString.fromCurrency(Locale.getDefault(), 
//                        1, 2, 10, true)).get());
//        System.out.println(Op.buildList(Types.NUMBER)
//                .addAll(45.9, 45, new BigDecimal(34.456))
//                .forEach().exec(ToString.fromCurrency(Locale.getDefault(), 
//                        1, 0, 0, true)).get());
//        
//        System.out.println(Op.buildList(Types.NUMBER)
//                .addAll(45.9, 45, new BigDecimal(34.456), 0, 0.5, 0.211)
//                .forEach().exec(ToString.fromPercent(Locale.getDefault(), 
//                        1, 0, 10, ',', '\'', false)).get());
     
        
        System.out.println(Op.onArrayOf(Types.STRING, stringsArr1).toSet().get());
        
        final List<String[]> listOfStringArray1 = new ArrayList<String[]>();
        listOfStringArray1.add(Op.onAll("Hola", "Hello", "Ciao", "Ola").buildArrayOf(Types.STRING).get());
        listOfStringArray1.add(Op.onAll("Adios", "Goodbye", "Ciao", "Adéus").buildArrayOf(Types.STRING).get());
        
        final List<Set<String>> listOfStringSet1 = new ArrayList<Set<String>>();
        listOfStringSet1.add(Op.onAll("Hola", "Hello", "Ciao", "Ola").buildSet().get());
        listOfStringSet1.add(Op.onAll("Adios", "Goodbye", "Ciao", "Adéus").buildSet().get());
        
        final Set<String[]> setOfStringArray1 = new LinkedHashSet<String[]>();
        setOfStringArray1.add(Op.onAll("Hola", "Hello", "Ciao", "Ola").buildArrayOf(Types.STRING).get());
        setOfStringArray1.add(Op.onAll("Adios", "Goodbye", "Ciao", "Adéus").buildArrayOf(Types.STRING).get());
        
        final Set<List<String>> setOfStringList1 = new LinkedHashSet<List<String>>();
        setOfStringList1.add(Op.onAll("Hola", "Hello", "Ciao", "Ola").buildList().get());
        setOfStringList1.add(Op.onAll("Adios", "Goodbye", "Ciao", "Adéus").buildList().get());
        
        final Set<Set<String>> setOfStringSet1 = new LinkedHashSet<Set<String>>();
        setOfStringSet1.add(Op.onAll("Hola", "Hello", "Ciao", "Ola").buildSet().get());
        setOfStringSet1.add(Op.onAll("Adios", "Goodbye", "Ciao", "Adéus").buildSet().get());
        
        System.out.println(Op.on("http://www.google.es/search?q=op4j&unusedParam=unusedValue '' 2^2 ")
                .exec(FnString.escapeJavaScript()).get());
        System.out.println(Op.on("Body tag is written like \"<body>content here</body>\"")
                .exec(FnString.escapeHTML()).get());
        
        System.out.println(Op.onArrayOf(Types.STRING, stringsArr1).removeAllNull().toMap(Ognl.asInteger("length()")).get());

        System.out.println(Op.onList(stringsList1).removeAllNullOrTrue(Ognl.asBoolean("length() < 6")).get());

        System.out.println("***___****___****");
        System.out.println(Op.onList(stringsList1).forEach().ifNotNull().exec(FnString.toUpperCase()).get());
        System.out.println("***___****___****");
        
        System.out.println(Op.onAll("hello", "goodbye").exec(Ognl.asString("#target + ' world!'")).getAsList());
        
        System.out.println(Op.onList(listOfListOfString1).get());
        
        
//        System.out.println(Op.onMap(map1).forEachEntry().exec(Ognl.forString("'in ' + #target.key + ' you say ' + #target.value")).get());
        
        
        
        System.out.println(Op.onList(stringsList1).removeAllNull().sort().get());
        System.out.println(Op.onList(stringsList1).removeAllNull().forEach().exec(Ognl.asInteger("length()")).get());
        
        System.out.println(Op.on(maps1).exec(Ognl.asInteger("length")).get());
        System.out.println(printArray(Op.onArrayOf(Types.MAP_OF_STRING_STRING, maps1).forEach().exec(Types.INTEGER, Ognl.asInteger("size()")).get()));

//        final List<Map<String,String>> listOfMapOfStringString1 = 
//          Op.buildList(Types.MAP_OF_STRING_STRING).add(map1).add(map2).get();
//        
//        System.out.println(printArray(Op.onListOfMap(listOfMapOfStringString1).toArrayOfMap().get()));
    
        System.out.println(Op.onMap(map1).forEachEntry().exec(Ognl.asString("'<<KEY: ' + #target.key + ' | VALUE: ' + #target.value + '>>'")).get());
        
        System.out.println(Types.LIST_ITERATOR_OF_BOOLEAN.getSimpleName());
        
        
        System.out.println(Op.onList(stringsList1).get());
        System.out.println(Op.onList(stringsList1).forEach().replaceWith("op4j is great!").get());
        System.out.println(Op.onList(stringsList1).forEach().replaceIfNullWith("op4j is great!").get());
        System.out.println(printArray(Op.onArrayOf(Types.STRING, stringsArr1).forEach().replaceIfNullWith("op4j is great!").get()));
        System.out.println(printArray(Op.onArrayOf(Types.STRING, stringsArr1).replaceWith(new String[] {"alpha", "beta"}).forEach().exec(FnString.toUpperCase()).get()));
        
        
//        System.out.println(Op.buildListOfList(Types.STRING).add(stringsList1).add(stringsList1).get());
//        System.out.println(Op.buildListOfList(Types.STRING).addAll(stringsList1, stringsList1).get());


        
        
        watch.stop();
        
        System.out.println("TIME: " + watch.toString());
        
    }
    
    
    
    private static String printArray(Object[] array) {
        if (array == null) {
            return null;
        }
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
