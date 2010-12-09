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

package org.op4j;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.time.StopWatch;
import org.javaruntype.type.Types;
import org.javatuples.Pair;
import org.junit.Test;
import org.op4j.functions.Call;
import org.op4j.functions.DecimalPoint;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.Fn;
import org.op4j.functions.FnArray;
import org.op4j.functions.FnBigDecimal;
import org.op4j.functions.FnBigInteger;
import org.op4j.functions.FnBoolean;
import org.op4j.functions.FnCalendar;
import org.op4j.functions.FnDouble;
import org.op4j.functions.FnFunc;
import org.op4j.functions.FnInteger;
import org.op4j.functions.FnList;
import org.op4j.functions.FnNumber;
import org.op4j.functions.FnObject;
import org.op4j.functions.FnSet;
import org.op4j.functions.FnString;
import org.op4j.functions.FnTuple;
import org.op4j.functions.Function;
import org.op4j.functions.Get;
import org.op4j.functions.IFunction;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class MiscTest {

    
    
    
    @Test
    public void test() throws Exception {
        
        
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
        System.out.println(Op.onList(stringsList1).removeAllTrue(new IFunction<String,Boolean>() {

            public Boolean execute(String target, final ExecCtx ctx) {
                return Boolean.valueOf(target == null);
            }
            
        }).get());
        System.out.println(Op.onList(stringsList1).removeAllNull().get());
            
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
        System.out.println(Op.onSet(stringSet1).removeAllNull().get());
            
        System.out.println(printArray(Op.onArrayOf(Types.STRING, stringsArr1).insertAll(2,"lalero","lururu").get()));
     
        
        System.out.println(Op.onMap(map1).put("fr", "Allô!").get());
        System.out.println(Op.onMap(map1).insert(0,"fr", "Allô!").get());
        System.out.println(Op.onMap(map1).insert(2,"fr", "Allô!").get());
        System.out.println(Op.onMap(map2).get());
        System.out.println(Op.onMap(map2).putAll(Op.onMap(map1).insert(0,"gl", "Meuuuu!").get()).get());
        
        System.out.println(Op.onListFor(234,12,231));
        System.out.println(Op.onListFor(234).addAll(10));
        System.out.println(Op.onListFor(234).insert(0,10));
        System.out.println(Op.onListFor(234).addAll(10).insert(1,3));
        System.out.println(Op.onListFor(234).addAll(10).insert(1,3).addAll((Integer)null));
        System.out.println(Op.onListFor(234).addAll(10).insert(1,3).addAll((Integer)null).removeAllNull());
        System.out.println(Op.onListFor(234).addAll(10).insert(1,3).removeAllIndexesNot(1));
        System.out.println(printArray(Op.on(234).intoSingletonArrayOf(Types.INTEGER).addAll(8).get()));
        System.out.println(Op.on((List)null).addAll(123));
        System.out.println(Op.on((Object)null).intoSingletonList().get());
        System.out.println(Op.on((Object)null).intoSingletonSet().get());
        System.out.println(printArray(Op.on((String)null).intoSingletonArrayOf(Types.STRING).addAll("a").removeAllNull().removeAllIndexes(0).get()));
        
//        System.out.println(printArray(Op.buildArrayOfArray(Types.STRING).addAll(Op.buildArray(Types.STRING).addAll("a","b").get()).addAll(Op.buildArray(Types.STRING).addAll("1","2","3").get()).get()));
//        System.out.println(Op.buildMap(Types.INTEGER,Types.STRING).put(12,"hello!").get());
        System.out.println(Op.onListFor("a",1,"b",3).couple().get());
        
        System.out.println(Op.onListFor("hello", "goodbye", "adios", "ciao", "hola").sort().get());
        System.out.println(Op.onListFor("hello", "goodbye", "adios", "ciao", "hola").toSet().sort(new Comparator<String>() {

            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                } else if (o1.length() == o2.length()) {
                    return 0;
                }
                return 1;
            }
            
        }).get());
        
        System.out.println(printArray(Op.onListFor("hello", "goodbye", "adios", "ciao", "hola").toArrayOf(Types.STRING).sort().get()));
        System.out.println(printArray(Op.onListFor("hello", "goodbye", "adios", "ciao", "hola").toArrayOf(Types.STRING).sort(new Comparator<String>() {

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
        System.out.println(dateFormat.format(Op.on(Calendar.getInstance()).exec(FnCalendar.truncate(Calendar.DATE)).get().getTime()));
        
        System.out.println(dateFormat.format(Op.on("25/nov/1979").exec(FnString.toCalendar("dd/MMM/yyyy", "es")).get().getTime()));
        
//        System.out.println(dateFormat.format(Op.onAll(1979, 11, 25, 12, 30).buildList().exec(ToCalendar.fromString("dd/MMM/yyyy", "es")).get().getTime()));
        System.out.println(dateFormat.format(Op.on(Op.onListFor(1979, 11, 25, 12, 30).get()).exec(FnCalendar.fieldIntegerListToCalendar()).get().getTime()));
        System.out.println(dateFormat.format(Op.on(Op.onListFor("1979", "11", "25", "12", "30").get()).toArrayOf(Types.STRING).exec(FnCalendar.fieldStringArrayToCalendar()).get().getTime()));
        
        System.out.println(Op.on(Op.onListFor(1979, 11, 25, 12, 30).get()).exec(FnList.ofInteger().sort()).get());
        System.out.println(Op.on(Op.onSetFor(1979, 11, 25, 12, 30).get()).exec(FnSet.ofInteger().sort()).get());
        System.out.println(Op.on(Op.onListFor(1979, 11, 25, 12, 30, 1980, 2, 43, 12, 11).get()).exec(FnList.ofInteger().distinct()).get());
        
        

        System.out.println(Op.on("hello").intoSingletonList().get());
        System.out.println(printArray(Op.on("hello").intoSingletonArrayOf(Types.STRING).get()));
        
        
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
        listOfStringArray1.add(Op.onListFor("Hola", "Hello", "Ciao", "Ola").toArrayOf(Types.STRING).get());
        listOfStringArray1.add(Op.onListFor("Adios", "Goodbye", "Ciao", "Adéus").toArrayOf(Types.STRING).get());
        
        final List<Set<String>> listOfStringSet1 = new ArrayList<Set<String>>();
        listOfStringSet1.add(Op.onListFor("Hola", "Hello", "Ciao", "Ola").toSet().get());
        listOfStringSet1.add(Op.onListFor("Adios", "Goodbye", "Ciao", "Adéus").toSet().get());
        
        final Set<String[]> setOfStringArray1 = new LinkedHashSet<String[]>();
        setOfStringArray1.add(Op.onListFor("Hola", "Hello", "Ciao", "Ola").toArrayOf(Types.STRING).get());
        setOfStringArray1.add(Op.onListFor("Adios", "Goodbye", "Ciao", "Adéus").toArrayOf(Types.STRING).get());
        
        final Set<List<String>> setOfStringList1 = new LinkedHashSet<List<String>>();
        setOfStringList1.add(Op.onArrayFor("Hola", "Hello", "Ciao", "Ola").toList().get());
        setOfStringList1.add(Op.onArrayFor("Adios", "Goodbye", "Ciao", "Adéus").toList().get());
        
        final Set<Set<String>> setOfStringSet1 = new LinkedHashSet<Set<String>>();
        setOfStringSet1.add(Op.onListFor("Hola", "Hello", "Ciao", "Ola").toSet().get());
        setOfStringSet1.add(Op.onListFor("Adios", "Goodbye", "Ciao", "Adéus").toSet().get());
        
        System.out.println(Op.on("http://www.google.es/search?q=op4j&unusedParam=unusedValue '' 2^2 ")
                .exec(FnString.escapeJavaScript()).get());
        System.out.println(Op.on("Body tag is written like \"<body>content here</body>\"")
                .exec(FnString.escapeHTML()).get());
        

        System.out.println("***___****___****");
        System.out.println(Op.onList(stringsList1).forEach().ifNotNull().exec(FnString.toUpperCase()).get());
        System.out.println("***___****___****");
        
        
        System.out.println(Op.onList(listOfListOfString1).get());
        
        
//        System.out.println(Op.onMap(map1).forEachEntry().exec(Ognl.forString("'in ' + #target.key + ' you say ' + #target.value")).get());
        
        
        
        System.out.println(Op.onList(stringsList1).removeAllNull().sort().get());
        

//        final List<Map<String,String>> listOfMapOfStringString1 = 
//          Op.buildList(Types.MAP_OF_STRING_STRING).add(map1).add(map2).get();
//        
//        System.out.println(printArray(Op.onListOfMap(listOfMapOfStringString1).toArrayOfMap().get()));
    
        
        System.out.println(Types.LIST_ITERATOR_OF_BOOLEAN.getSimpleName());
        
        
        System.out.println(Op.onList(stringsList1).get());
        System.out.println(Op.onList(stringsList1).forEach().replaceWith("op4j is great!").get());
        System.out.println(Op.onList(stringsList1).forEach().replaceIfNullWith("op4j is great!").get());
        System.out.println(printArray(Op.onArrayOf(Types.STRING, stringsArr1).forEach().replaceIfNullWith("op4j is great!").get()));
        System.out.println(printArray(Op.onArrayOf(Types.STRING, stringsArr1).replaceWith(new String[] {"alpha", "beta"}).forEach().exec(FnString.toUpperCase()).get()));
        
        
//        System.out.println(Op.buildListOfList(Types.STRING).add(stringsList1).add(stringsList1).get());
//        System.out.println(Op.buildListOfList(Types.STRING).addAll(stringsList1, stringsList1).get());


        Op.on(Integer.valueOf(12)).exec(FnObject.intoSingletonArrayOf(Types.INTEGER)).get();
        
        watch.stop();
        
        System.out.println("TIME: " + watch.toString());
        
        
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");
        System.out.println("**********************");

        
        List<String> list = Arrays.asList(new String[] { "12/10/1492", "6/12/1978", "15/07/2045", null });
        
        Set<String> set1 = new LinkedHashSet<String>(list);
        Set<String> set2 = Op.on(list).toSet().get();

        System.out.println("set1 : " + set1);
        System.out.println("set2 : " + set2);

        Set<Calendar> set3 = 
            Op.on(list).toSet().forEach().exec(FnString.toCalendar("dd/MM/yyyy")).get();

        System.out.println("set3asStr : " + Op.on(set3).map(FnCalendar.toStr("EEEE dd MMMM yyyy")).get());
        
        Set<Calendar> set4 = 
            Op.on(list).toSet().removeAllNull().forEach().exec(FnString.toCalendar("dd/MM/yyyy")).get();
        
        System.out.println("set4asStr : " + Op.on(set4).map(FnCalendar.toStr("EEEE dd MMMM yyyy", new Locale("en"))).get());

        Set<Calendar> set5 = 
            Op.on(list).toSet().removeAllNull().map(FnString.toCalendar("dd/MM/yyyy")).get();
        
        System.out.println("set5asStr : " + Op.on(set5).map(FnCalendar.toStr("EEEE dd MMMM yyyy", new Locale("en"))).get());
     
        Calendar now = Calendar.getInstance();
        Set<Calendar> set6 = 
            Op.on(list).toSet().map(FnString.toCalendar("dd/MM/yyyy")).removeAllNullOrTrue(FnCalendar.after(now)).get();
        
        System.out.println("set6asStr : " + Op.on(set6).map(FnCalendar.toStr("EEEE dd MMMM yyyy HH:mm:ss", new Locale("en"))).get());

        
        // ****************************
        // WARNING: Non-op4j code!!
        // ****************************
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        Set<Calendar> set = new LinkedHashSet<Calendar>();
        for (String element : list) {
          if (element != null) {
              Date date = null;
              try {
                  date = dateFormat1.parse(element);
              } catch (ParseException e) {
                  throw new RuntimeException(e);
              }
              Calendar calendar = Calendar.getInstance();
              calendar.setTimeInMillis(date.getTime());
              if (!calendar.after(now)) {
                  set.add(calendar);
              }
          }
        }

        
        System.out.println("setasStr : " + Op.on(set).map(FnCalendar.toStr("EEEE dd MMMM yyyy HH:mm:ss", new Locale("en"))).get());
        

        Function<List<String>,Set<Calendar>> conversionFunction = 
            Fn.onListOf(Types.STRING).toSet().map(FnString.toCalendar("dd/MM/yyyy")).removeAllNullOrTrue(FnCalendar.after(now)).get();

        System.out.println("setFnasStr : " + Op.on(conversionFunction.execute(list)).map(FnCalendar.toStr("EEEE dd MMMM yyyy HH:mm:ss", new Locale("en"))).get());
     
        
        int[] v1 = new int[] {3,2,1,3};
        long[] v2 = new long[] {3,2,1,3};
        
        Op.on(1).get();
        List<Integer> iL = Op.onListFor(2,1,4,213).get();
        System.out.println(iL);
        
        System.out.println(Arrays.asList(Op.on(v1).forEach().exec(FnInteger.add(Integer.valueOf(10))).get()));
        
        Op.on(v2).forEach().get();
        
        
        Op.on(123).exec(new IFunction<Integer,String>() {
            public String execute(Integer input, ExecCtx ctx) throws Exception {
                return "The input number is: " + input;
            }
        }).get();
        
        
                
            
        
        System.out.println(Op.on(23.24).exec(FnDouble.add(43)).get());
        
        System.out.println(Op.on(BigDecimal.valueOf(23.24)).exec(FnBigDecimal.add(1.2)).get());
        
        System.out.println(Op.onListFor(30,30,40).map(FnNumber.toBigInteger()).exec(FnBigInteger.avg(RoundingMode.CEILING)).get());
        
        System.out.println(Op.on(10).exec(FnInteger.divideBy(3,RoundingMode.CEILING)).get());
        
        
        
        Function<Integer,Boolean> fnAnd1 = FnBoolean.and(FnObject.eq("lala"), FnNumber.notEq(534));
        
        System.out.println(
                Op.on(233).exec(FnBoolean.and(FnNumber.greaterThan(44), FnObject.lessThan(534))).get());
        
        System.out.println(
                Op.on(1233).ifTrue(FnBoolean.not(FnBoolean.and(FnNumber.greaterThan(44), FnObject.lessThan(534)))).exec(FnInteger.add(10)).get());
        
        System.out.println(
                Op.on(1233).exec(FnFunc.chain(FnInteger.add(10), FnNumber.greaterThan(1200))).get());

        System.out.println(Op.onListFor(1,2,3,4).exec(FnList.ofInteger().containsAny(12,3)).get());
        
    
        String[] arr231 = new String[] { "be", "a", "31aa", "31_l", "31A" };
        
        System.out.println(Arrays.asList(FnArray.ofString().sort().execute(arr231)));
        System.out.println(Arrays.asList(FnArray.ofString().sortBy(Call.methodForInteger("length")).execute(arr231)));

        System.out.println(FnList.ofString().sortBy(Call.methodForInteger("length")).execute(Arrays.asList(arr231)));

        
        String[] datesStr = new String[] {"12-10-1492", "06-12-1978" };

        List<Calendar> dates = 
            Op.on(datesStr).toList().map(FnString.toCalendar("dd-MM-yyyy")).get();

        System.out.println(Op.on(dates).map(FnCalendar.toStr("yyyy, MMMM dd", new Locale("gl","ES"))).get());

        
        Function<Integer,Boolean> afnb1 = new Function<Integer, Boolean>() {

            public Boolean execute(Integer input, ExecCtx ctx) throws Exception {
                return Boolean.TRUE;
            }
        };
        
        Function<Number,Boolean> afnb2 =  new Function<Number, Boolean>() {

            public Boolean execute(Number input, ExecCtx ctx) throws Exception {
                return Boolean.TRUE;
            }
        };
        
        Function<Integer,Boolean> afnb = FnBoolean.and(afnb1,afnb2);
        
        Function<Number,Boolean> bfnb1 = new Function<Number, Boolean>() {
            public Boolean execute(Number input, ExecCtx ctx) throws Exception {
                return Boolean.TRUE;
            }
        };
        Function<Integer,Boolean> bfnb2 = new Function<Integer, Boolean>() {
            public Boolean execute(Integer input, ExecCtx ctx) throws Exception {
                return Boolean.TRUE;
            }
        };
        Function<Integer,Boolean> bfnb = FnBoolean.and(bfnb1,bfnb2);
    
        Op.on(231).ifTrue(afnb).get();
        Op.on(231).ifTrue(bfnb).get();
        
        Op.on(231).ifTrue(FnBoolean.and(afnb1,afnb2)).get();
        Op.on(231).ifTrue(FnBoolean.and(bfnb1,bfnb2)).get();
        
        Function<Object,Boolean> cfnb1 = new Function<Object, Boolean>() {

            public Boolean execute(Object input, ExecCtx ctx) throws Exception {
                return Boolean.TRUE;
            }
        };
        
        Function<Number,Boolean> cfnb2 = new Function<Number, Boolean>() {

            public Boolean execute(Number input, ExecCtx ctx) throws Exception {
                return Boolean.TRUE;
            }
        };
        Function<Number,Boolean> cfnb = FnBoolean.and(cfnb1,cfnb2);
        
        Function<Number,Boolean> dfnb1 = new Function<Number, Boolean>() {

            public Boolean execute(Number input, ExecCtx ctx) throws Exception {
                return Boolean.TRUE;
            }
        };
        Function<Object,Boolean> dfnb2 = new Function<Object, Boolean>() {

            public Boolean execute(Object input, ExecCtx ctx) throws Exception {
                return Boolean.TRUE;
            }
        };
        Function<Number,Boolean> dfnb = FnBoolean.and(dfnb1,dfnb2);
    
        Op.on(231.2).ifTrue(cfnb).get();
        Op.on(231.1).ifTrue(dfnb).get();
        
        Op.on(231.2).ifTrue(FnBoolean.and(cfnb1,cfnb2)).get();
        Op.on(231.1).ifTrue(FnBoolean.and(dfnb1,dfnb2)).get();
    
        
        Function<Number,Integer> fnz1 = new Function<Number, Integer>() {

            public Integer execute(Number input, ExecCtx ctx) throws Exception {
                // TODO Auto-generated method stub
                return null;
            }
        };
        
        Function<Integer,Integer> fnn1 = 
            FnFunc.ifTrueThen(Types.INTEGER, FnNumber.greaterThan(2),fnz1);
        
        Fn.on(Types.INTEGER).exec(FnFunc.ifTrueThen(Types.NUMBER, FnNumber.greaterThan(2),fnz1)).get();
        
        
        
        
        
        
        
        BigInteger biValue = BigInteger.valueOf(-1256565646);
        
        System.out.println("Starting value = " + biValue);

        BigInteger biOpResult =
            Op.on(biValue).
                exec(FnBigInteger.divideBy(BigInteger.valueOf(23))).
                exec(FnBigInteger.pow(3)).
                exec(FnBigInteger.subtract(BigInteger.valueOf(5))).
                exec(FnBigInteger.abs()).get();

        System.out.println("With op4j:    " + biOpResult);
        
        BigInteger biNorResult =
            biValue.divide(BigInteger.valueOf(23))
                .pow(3).subtract(BigInteger.valueOf(5)).abs();

        System.out.println("Without op4j: " + biNorResult);

        BigInteger biOpResult1 =
            Op.on(biValue).
                exec(FnBigInteger.divideBy(BigInteger.valueOf(23))).get();

        System.out.println("[1] With op4j:    " + biOpResult1);
        
        BigInteger biNorResult1 =
            biValue.divide(BigInteger.valueOf(23));

        System.out.println("[1] Without op4j: " + biNorResult1);

        BigDecimal biOpResult1d =
            Op.on(new BigDecimal(biValue)).
                exec(FnBigDecimal.divideBy(BigDecimal.valueOf(23.0), RoundingMode.DOWN)).get();

        System.out.println("[1D] With op4j:    " + biOpResult1d);
        
        BigDecimal biNorResult1d =
            new BigDecimal(biValue).divide(BigDecimal.valueOf(23.0), RoundingMode.DOWN);

        System.out.println("[1D] Without op4j: " + biNorResult1d);
        
        

        
        System.out.println(
                Op.on(Types.STRING,null).exec(FnFunc.ifTrueThen(Types.STRING, FnBoolean.or(FnObject.isNull(), FnBoolean.and(FnObject.isNotNull(), FnFunc.chain(FnString.toInteger(),FnNumber.greaterThan(100)))), FnObject.replaceWith("lelo"))).get());
        

        
        
        System.out.println(Arrays.asList(Op.onArrayFor(4,2).get()));
        
        
        System.out.println(Op.on("hello").zipKey(98).get());

        
        System.out.println(
                Op.onListFor("en", "en", "es", "gl", "fr").
                zipAndGroupValues("hello", "goodbye", "hola", "ola", "allô").get());
        
        System.out.println(
                Op.onListFor("hello", "goodbye", "hola", "ola", "allô").
                zipAndGroupKeys("en", "en", "es", "gl", "fr").get());
        
        System.out.println(
                Op.onArrayFor("hello", "goodbye", "hola", "ola", "allô").
                zipAndGroupKeys("en", "en", "es", "gl", "fr").get());
     
        
        System.out.println(
                Op.onMapFor(23, "twenty-three").and(43, "forty-three").and(10,"ten").sort().get());
        
        System.out.println(
                    Arrays.asList(Op.onArrayFor(1,2,1,2,2).zipAndGroupValues(Types.STRING, "a","b","c","d","e").get().get(1)));
    

        
        System.out.println(Op.on("hello").ifTrue(FnString.notEq("uncapitalizable")).exec(FnString.toUpperCase()).get());
        System.out.println(Op.on("uncapitalizable").ifTrue(FnString.notEq("uncapitalizable")).exec(FnString.toUpperCase()).get());
        
        
        Map<String,Integer> agesByName =
            Op.onListFor(27, 49, 19).zipKeys("John", "Mary", "Derek").get();
        
        System.out.println(agesByName);
        
        Map<String,String> capitals =
            Op.onListFor("Spain", "Madrid", "United Kingdom", "London", "France", "Paris").couple().get();
        
        System.out.println(capitals);
        
        String date = "06/12/1978";
        Calendar cal =
            Op.on(date).exec(FnString.toCalendar("dd/MM/yyyy")).get();
            
        System.out.println(dateFormat.format(cal.getTime()));
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dt = sdf.parse("06/12/1978");
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        System.out.println(dateFormat.format(c.getTime()));
        
        
        
        System.out.println(Op.onListFor(2,12,42,5,9,24).mapIfTrue(FnNumber.lessOrEqTo(10), FnObject.replaceWith("<"), FnObject.replaceWith(">")).get());
        
        
        System.out.println(Op.on("LO E ÇÀ IÑÆ NÜß ÞOR! añeçáíéóú").exec(FnString.asciify()).get());
        System.out.println(Op.on("ßß ßß a ßß nuß NUß nußß NUßß ßß").exec(FnString.asciify()).get());
        System.out.println(Op.on("ß").exec(FnString.asciify()).get());
        
        
        
        Pair<Integer,Integer> p = 
            Op.on(dt).exec(FnTuple.pairWith(Call.i("getYear"),Get.i("month"))).get();
        System.out.println(p);
        
        Integer i10 = 
            Op.on(dt).exec(FnTuple.pairWith(Call.i("getYear"),Get.i("month"))).exec(FnTuple.getValue1Of(Types.INTEGER)).get();
        System.out.println(i10);
        
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
