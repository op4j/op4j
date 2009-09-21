package org.op4j.type;

import junit.framework.TestCase;

import org.op4j.exceptions.TypeRecognitionException;
import org.op4j.type.Type;
import org.op4j.type.Types;

public class TypesTest extends TestCase {

    
    public void testA() throws Exception {
        
    }
    
    public void atestForName() throws Exception {
        
        checkValidName("String");
        checkValidName("java.lang.String");
        checkInvalidName("Strin");
        checkInvalidName("String<?>");
        checkInvalidName("java.util.String<?>");
        checkInvalidName("String<Integer>");
        checkInvalidName("java.lang.String<Integer>");
        checkValidName("ArrayList");
        checkValidName("java.util.ArrayList");
        checkValidName("ArrayList<?>");
        checkValidName("java.util.ArrayList<?>");
        checkValidName("ArrayList<String>");
        checkValidName("ArrayList<Integer>");
        checkValidName("ArrayList<Number>");
        checkValidName("ArrayList<? extends Number>");
        checkValidName("ArrayList<? super Integer>");
        checkInvalidName("ArrayList<?,?>");
        checkInvalidName("ArrayList<Integer,Integer>");
        checkValidName("List<String>");
        checkValidName("List<Integer>");
        checkValidName("List<Number>");
        checkValidName("List<? extends Number>");
        checkValidName("List<? super Integer>");
        checkInvalidName("List<?,?>");
        checkInvalidName("List<Integer,Integer>");
        checkValidName("org.op4j.type.testtypes.TestEnum");
        checkValidName("List<org.op4j.type.testtypes.TestEnum>");
        checkInvalidName("org.op4j.type.testtypes.TestEnum<String>");
        checkValidName("List<org.op4j.type.testtypes.TestEnum[][]>");
        checkValidName("Map");
        checkValidName("Map<?,?>");
        checkValidName("Map<String,String>");
        checkValidName("Map<Integer,String>");
        checkValidName("Map<Object,?>");
        checkValidName("EnumMap<org.op4j.type.testtypes.TestEnum,String[]>");
        checkInvalidName("EnumMap<String,String[]>");
        checkValidName("HashMap<String,Integer>");
        checkValidName("AbstractMap<String,List<? extends Number>>");
        checkValidName("LinkedHashMap<String[],List<? extends Number[][]>[]>[]");
        checkValidName("org.op4j.type.testtypes.TestType");
        checkInvalidName("org.op4j.type.testtypes.TestType<?>");
        checkInvalidName("org.op4j.type.testtypes.TestType<?,?>");
        checkValidName("org.op4j.type.testtypes.TestType<?,?,?>");
        checkInvalidName("org.op4j.type.testtypes.TestType<?,?,?,?>");
        checkValidName("org.op4j.type.testtypes.TestType<Number,?,Double>");
        checkInvalidName("org.op4j.type.testtypes.TestType<Number,?,String>");
        checkValidName("org.op4j.type.testtypes.TestType<List<Number>,?,List<Number>>");
        checkValidName("org.op4j.type.testtypes.TestType<List<Number>,?,ArrayList<Number>>");
        checkInvalidName("org.op4j.type.testtypes.TestType<List<Number>,?,List<Integer>>");
        checkInvalidName("org.op4j.type.testtypes.TestType<List<Number>,?,ArrayList<Integer>>");
        checkValidName("org.op4j.type.testtypes.TestType<List<? extends Number>,?,List<Integer>>");
        checkValidName("org.op4j.type.testtypes.TestType<List<? extends Number>,?,ArrayList<Integer>>");
        checkInvalidName("org.op4j.type.testtypes.TestType<List<List<? extends Number>>,?,ArrayList<List<Integer>>>");
        checkValidName("org.op4j.type.testtypes.TestType<List<List<Integer>>,?,ArrayList<List<Integer>>>");
        checkValidName("org.op4j.type.testtypes.TestType<List<List<Integer[]>>,?,ArrayList<List<Integer[]>>>");
        checkValidName("org.op4j.type.testtypes.TestType<List<List<Integer>>,?,ArrayList<List<Integer>>>[]");
        checkValidName("org.op4j.type.testtypes.TestType<List<List<Integer[]>>[][],?,ArrayList<List<Integer[]>>[][]>[][]");
        checkValidName("org.op4j.type.testtypes.TestType<List<List<Integer>[]>[][],?,ArrayList<List<Integer>[]>[][]>[][]");
        checkInvalidName("org.op4j.type.testtypes.TestType<?,Number,?>");
        checkInvalidName("org.op4j.type.testtypes.TestType<?,Integer,?>");
        checkValidName("org.op4j.type.testtypes.TestType<?,Float,?>");
        checkValidName("org.op4j.type.testtypes.TestType<?,Float,?>[]");
        checkValidName("org.op4j.type.testtypes.TestType<List<List<Integer>[]>[][],Float,ArrayList<List<Integer>[]>[][]>[][]");
        checkInvalidName("org.op4j.type.testtypes.TestType<List<List<Integer>[]>[][], Number,ArrayList<List<Integer>[]>[][]>[][]");
        checkValidName("org.op4j.type.testtypes.TestType2<?>");
        checkValidName("org.op4j.type.testtypes.TestType2<?>[]");
        checkValidName("org.op4j.type.testtypes.TestType2<?>[][][]");
        checkValidName("org.op4j.type.testtypes.TestType2<String>");
        checkValidName("org.op4j.type.testtypes.TestType2<String>[][]");
        checkValidName("org.op4j.type.testtypes.TestType2<String[][]>[][]");
        checkValidName("org.op4j.type.testtypes.TestType2<? extends String>");
        checkValidName("org.op4j.type.testtypes.TestType2<? extends String>[]");
        checkValidName("org.op4j.type.testtypes.TestType2<? extends String[]>");
        checkValidName("org.op4j.type.testtypes.TestType2<? extends String[]>[]");
        checkValidName("org.op4j.type.testtypes.TestType2<? extends List<String[]>>");
        checkValidName("org.op4j.type.testtypes.TestType2<? extends List<? extends String[]>>");
        checkValidName("org.op4j.type.testtypes.TestType2<? extends List<? super String[]>>");
        checkValidName("org.op4j.type.testtypes.TestType2<? super String>");
        checkValidName("org.op4j.type.testtypes.TestType2<? super String>[]");
        checkValidName("org.op4j.type.testtypes.TestType2<? super String[]>");
        checkValidName("org.op4j.type.testtypes.TestType2<? super String[]>[]");
        checkValidName("org.op4j.type.testtypes.TestType2<? super List<String[]>>");
        checkValidName("org.op4j.type.testtypes.TestType2<? super List<String[]>>");
        checkValidName("org.op4j.type.testtypes.TestType2<? super List<? extends String[]>>");
        checkValidName("org.op4j.type.testtypes.TestType2<? super List<? super String[]>>");
        checkValidName("org.op4j.type.testtypes.TestType3");
        checkValidName("org.op4j.type.testtypes.TestType3<?,?,?>");
        checkValidName("org.op4j.type.testtypes.TestType3<?,?,Integer>");
        checkInvalidName("org.op4j.type.testtypes.TestType3<?,?,Number>");
        
        
    }

    
    public void atestEquals() throws Exception {
        
        Type stringType1 = Types.forName("String");
        Type stringType2 = Types.forName("java.lang.String");
        assertEquals(stringType1, stringType2);
        
        Type arrayListType1 = Types.forName("java.util.ArrayList<?>");
        Type arrayListType2 = Types.forName("java.util.ArrayList");
        Type arrayListType3 = Types.forName("ArrayList");
        Type arrayListType4 = Types.forName("java.util.ArrayList<String>");
        assertEquals(arrayListType1, arrayListType2);
        assertEquals(arrayListType2, arrayListType1);
        assertEquals(arrayListType1, arrayListType3);
        assertEquals(arrayListType3, arrayListType1);
        assertFalse(arrayListType1.equals(arrayListType4));
        assertFalse(arrayListType4.equals(arrayListType1));

    }
    
    
    public void atestRegistryCache() throws Exception {
        
        Type arrayListType1 = Types.forName("java.util.ArrayList<?>");
        Type arrayListType2 = Types.forName("java.util.ArrayList");
        Type arrayListType3 = Types.forName("ArrayList");
        Type arrayListType4 = Types.forName("java.util.ArrayList<String>");
        assertSame(arrayListType1, arrayListType2);
        assertSame(arrayListType1, arrayListType3);
        assertFalse(arrayListType1 == arrayListType4);
        
    }
    

    
    public void atestAssignable() throws Exception {

        Type serializableType = Types.forName("Serializable");
        Type objectType = Types.forName("Object");
        Type stringType = Types.forName("String");
        Type numberType = Types.forName("Number");
        Type integerType = Types.forName("Integer");
        Type floatType = Types.forName("Float");
        
        assertTrue(serializableType.isAssignableFrom(serializableType));
        assertFalse(serializableType.isAssignableFrom(objectType));
        assertTrue(serializableType.isAssignableFrom(stringType));
        assertTrue(serializableType.isAssignableFrom(numberType));
        assertTrue(serializableType.isAssignableFrom(integerType));
        assertTrue(serializableType.isAssignableFrom(floatType));
        
        assertTrue(objectType.isAssignableFrom(serializableType));
        assertTrue(objectType.isAssignableFrom(objectType));
        assertTrue(objectType.isAssignableFrom(stringType));
        assertTrue(objectType.isAssignableFrom(numberType));
        assertTrue(objectType.isAssignableFrom(integerType));
        assertTrue(objectType.isAssignableFrom(floatType));

        assertFalse(stringType.isAssignableFrom(serializableType));
        assertFalse(stringType.isAssignableFrom(objectType));
        assertTrue(stringType.isAssignableFrom(stringType));
        assertFalse(stringType.isAssignableFrom(numberType));
        assertFalse(stringType.isAssignableFrom(integerType));
        assertFalse(stringType.isAssignableFrom(floatType));

        assertFalse(numberType.isAssignableFrom(serializableType));
        assertFalse(numberType.isAssignableFrom(objectType));
        assertFalse(numberType.isAssignableFrom(stringType));
        assertTrue(numberType.isAssignableFrom(numberType));
        assertTrue(numberType.isAssignableFrom(integerType));
        assertTrue(numberType.isAssignableFrom(floatType));

        assertFalse(integerType.isAssignableFrom(serializableType));
        assertFalse(integerType.isAssignableFrom(objectType));
        assertFalse(integerType.isAssignableFrom(stringType));
        assertFalse(integerType.isAssignableFrom(numberType));
        assertTrue(integerType.isAssignableFrom(integerType));
        assertFalse(integerType.isAssignableFrom(floatType));
        
        
        Type objectAr1Type = Types.forName("Object[]");
        Type stringAr1Type = Types.forName("String[]");
        Type numberAr1Type = Types.forName("Number[]");
        Type integerAr1Type = Types.forName("Integer[]");
        Type floatAr1Type = Types.forName("Float[]");

        assertTrue(objectType.isAssignableFrom(objectAr1Type));
        assertFalse(objectAr1Type.isAssignableFrom(objectType));
        assertTrue(objectAr1Type.isAssignableFrom(objectAr1Type));
        assertTrue(objectAr1Type.isAssignableFrom(stringAr1Type));
        assertTrue(objectAr1Type.isAssignableFrom(numberAr1Type));
        assertTrue(objectAr1Type.isAssignableFrom(integerAr1Type));
        assertTrue(objectAr1Type.isAssignableFrom(floatAr1Type));

        assertFalse(stringAr1Type.isAssignableFrom(objectAr1Type));
        assertTrue(stringAr1Type.isAssignableFrom(stringAr1Type));
        assertFalse(stringAr1Type.isAssignableFrom(numberAr1Type));
        assertFalse(stringAr1Type.isAssignableFrom(integerAr1Type));
        assertFalse(stringAr1Type.isAssignableFrom(floatAr1Type));

        assertFalse(numberAr1Type.isAssignableFrom(objectAr1Type));
        assertFalse(numberAr1Type.isAssignableFrom(stringAr1Type));
        assertTrue(numberAr1Type.isAssignableFrom(numberAr1Type));
        assertTrue(numberAr1Type.isAssignableFrom(integerAr1Type));
        assertTrue(numberAr1Type.isAssignableFrom(floatAr1Type));

        assertFalse(integerAr1Type.isAssignableFrom(objectAr1Type));
        assertFalse(integerAr1Type.isAssignableFrom(stringAr1Type));
        assertFalse(integerAr1Type.isAssignableFrom(numberAr1Type));
        assertTrue(integerAr1Type.isAssignableFrom(integerAr1Type));
        assertFalse(integerAr1Type.isAssignableFrom(floatAr1Type));
        
        Type objectAr2Type = Types.forName("Object[][]");
        Type stringAr2Type = Types.forName("String[][]");
        Type numberAr2Type = Types.forName("Number[][]");
        Type integerAr2Type = Types.forName("Integer[][]");
        Type floatAr2Type = Types.forName("Float[][]");

        assertTrue(objectType.isAssignableFrom(objectAr2Type));
        assertFalse(objectAr2Type.isAssignableFrom(objectType));
        assertFalse(objectAr1Type.isAssignableFrom(objectAr2Type));
        assertFalse(objectAr2Type.isAssignableFrom(objectAr1Type));
        assertTrue(objectAr2Type.isAssignableFrom(objectAr2Type));
        assertTrue(objectAr2Type.isAssignableFrom(stringAr2Type));
        assertTrue(objectAr2Type.isAssignableFrom(numberAr2Type));
        assertTrue(objectAr2Type.isAssignableFrom(integerAr2Type));
        assertTrue(objectAr2Type.isAssignableFrom(floatAr2Type));

        assertFalse(stringAr2Type.isAssignableFrom(objectAr2Type));
        assertTrue(stringAr2Type.isAssignableFrom(stringAr2Type));
        assertFalse(stringAr2Type.isAssignableFrom(numberAr2Type));
        assertFalse(stringAr2Type.isAssignableFrom(integerAr2Type));
        assertFalse(stringAr2Type.isAssignableFrom(floatAr2Type));

        assertFalse(numberAr2Type.isAssignableFrom(objectAr2Type));
        assertFalse(numberAr2Type.isAssignableFrom(stringAr2Type));
        assertTrue(numberAr2Type.isAssignableFrom(numberAr2Type));
        assertTrue(numberAr2Type.isAssignableFrom(integerAr2Type));
        assertTrue(numberAr2Type.isAssignableFrom(floatAr2Type));

        assertFalse(integerAr2Type.isAssignableFrom(objectAr2Type));
        assertFalse(integerAr2Type.isAssignableFrom(stringAr2Type));
        assertFalse(integerAr2Type.isAssignableFrom(numberAr2Type));
        assertTrue(integerAr2Type.isAssignableFrom(integerAr2Type));
        assertFalse(integerAr2Type.isAssignableFrom(floatAr2Type));

        
        Type arrayListRawType = Types.forName("ArrayList<?>");
        Type arrayListObjectType = Types.forName("ArrayList<Object>");
        Type arrayListStringType = Types.forName("ArrayList<String>");
        Type arrayListNumberType = Types.forName("ArrayList<Number>");
        Type arrayListIntegerType = Types.forName("ArrayList<Integer>");
        Type arrayListFloatType = Types.forName("ArrayList<Float>");

        assertTrue(arrayListRawType.isAssignableFrom(arrayListRawType));
        assertTrue(arrayListRawType.isAssignableFrom(arrayListObjectType));
        assertTrue(arrayListRawType.isAssignableFrom(arrayListStringType));
        assertTrue(arrayListRawType.isAssignableFrom(arrayListNumberType));
        assertTrue(arrayListRawType.isAssignableFrom(arrayListIntegerType));
        assertTrue(arrayListRawType.isAssignableFrom(arrayListFloatType));

        assertFalse(arrayListObjectType.isAssignableFrom(arrayListRawType));
        assertTrue(arrayListObjectType.isAssignableFrom(arrayListObjectType));
        assertFalse(arrayListObjectType.isAssignableFrom(arrayListStringType));
        assertFalse(arrayListObjectType.isAssignableFrom(arrayListNumberType));
        assertFalse(arrayListObjectType.isAssignableFrom(arrayListIntegerType));
        assertFalse(arrayListObjectType.isAssignableFrom(arrayListFloatType));

        assertFalse(arrayListStringType.isAssignableFrom(arrayListRawType));
        assertFalse(arrayListStringType.isAssignableFrom(arrayListObjectType));
        assertTrue(arrayListStringType.isAssignableFrom(arrayListStringType));
        assertFalse(arrayListStringType.isAssignableFrom(arrayListNumberType));
        assertFalse(arrayListStringType.isAssignableFrom(arrayListIntegerType));
        assertFalse(arrayListStringType.isAssignableFrom(arrayListFloatType));

        assertFalse(arrayListNumberType.isAssignableFrom(arrayListRawType));
        assertFalse(arrayListNumberType.isAssignableFrom(arrayListObjectType));
        assertFalse(arrayListNumberType.isAssignableFrom(arrayListStringType));
        assertTrue(arrayListNumberType.isAssignableFrom(arrayListNumberType));
        assertFalse(arrayListNumberType.isAssignableFrom(arrayListIntegerType));
        assertFalse(arrayListNumberType.isAssignableFrom(arrayListFloatType));

        assertFalse(arrayListIntegerType.isAssignableFrom(arrayListRawType));
        assertFalse(arrayListIntegerType.isAssignableFrom(arrayListObjectType));
        assertFalse(arrayListIntegerType.isAssignableFrom(arrayListStringType));
        assertFalse(arrayListIntegerType.isAssignableFrom(arrayListNumberType));
        assertTrue(arrayListIntegerType.isAssignableFrom(arrayListIntegerType));
        assertFalse(arrayListIntegerType.isAssignableFrom(arrayListFloatType));

        assertFalse(arrayListFloatType.isAssignableFrom(arrayListRawType));
        assertFalse(arrayListFloatType.isAssignableFrom(arrayListObjectType));
        assertFalse(arrayListFloatType.isAssignableFrom(arrayListStringType));
        assertFalse(arrayListFloatType.isAssignableFrom(arrayListNumberType));
        assertFalse(arrayListFloatType.isAssignableFrom(arrayListIntegerType));
        assertTrue(arrayListFloatType.isAssignableFrom(arrayListFloatType));

        Type arrayListObjectAr1Type = Types.forName("ArrayList<Object[]>");
        Type arrayListNumberAr1Type = Types.forName("ArrayList<Number[]>");
        Type arrayListIntegerAr1Type = Types.forName("ArrayList<Integer[]>");
        
        assertTrue(arrayListRawType.isAssignableFrom(arrayListObjectAr1Type));
        assertTrue(arrayListRawType.isAssignableFrom(arrayListNumberAr1Type));
        assertTrue(arrayListRawType.isAssignableFrom(arrayListIntegerAr1Type));

        assertTrue(arrayListObjectAr1Type.isAssignableFrom(arrayListObjectAr1Type));
        assertFalse(arrayListObjectAr1Type.isAssignableFrom(arrayListNumberAr1Type));
        assertFalse(arrayListObjectAr1Type.isAssignableFrom(arrayListIntegerAr1Type));

        assertFalse(arrayListNumberAr1Type.isAssignableFrom(arrayListObjectAr1Type));
        assertTrue(arrayListNumberAr1Type.isAssignableFrom(arrayListNumberAr1Type));
        assertFalse(arrayListNumberAr1Type.isAssignableFrom(arrayListIntegerAr1Type));

        assertFalse(arrayListIntegerAr1Type.isAssignableFrom(arrayListObjectAr1Type));
        assertFalse(arrayListIntegerAr1Type.isAssignableFrom(arrayListNumberAr1Type));
        assertTrue(arrayListIntegerAr1Type.isAssignableFrom(arrayListIntegerAr1Type));

        
        Type arrayListExtendsObjectType = Types.forName("ArrayList<? extends Object>");

        assertFalse(arrayListExtendsObjectType.isAssignableFrom(arrayListRawType));
        assertTrue(arrayListExtendsObjectType.isAssignableFrom(arrayListObjectType));
        assertTrue(arrayListExtendsObjectType.isAssignableFrom(arrayListStringType));
        assertTrue(arrayListExtendsObjectType.isAssignableFrom(arrayListNumberType));
        assertTrue(arrayListExtendsObjectType.isAssignableFrom(arrayListIntegerType));
        assertTrue(arrayListExtendsObjectType.isAssignableFrom(arrayListFloatType));
        assertTrue(arrayListExtendsObjectType.isAssignableFrom(arrayListExtendsObjectType));

        
        Type arrayListExtendsNumberType = Types.forName("ArrayList<? extends Number>");

        assertFalse(arrayListExtendsNumberType.isAssignableFrom(arrayListRawType));
        assertFalse(arrayListExtendsNumberType.isAssignableFrom(arrayListObjectType));
        assertFalse(arrayListExtendsNumberType.isAssignableFrom(arrayListStringType));
        assertTrue(arrayListExtendsNumberType.isAssignableFrom(arrayListNumberType));
        assertTrue(arrayListExtendsNumberType.isAssignableFrom(arrayListIntegerType));
        assertTrue(arrayListExtendsNumberType.isAssignableFrom(arrayListFloatType));
        assertFalse(arrayListExtendsNumberType.isAssignableFrom(arrayListExtendsObjectType));
        assertTrue(arrayListExtendsNumberType.isAssignableFrom(arrayListExtendsNumberType));

        assertTrue(arrayListRawType.isAssignableFrom(arrayListExtendsNumberType));
        assertFalse(arrayListObjectType.isAssignableFrom(arrayListExtendsNumberType));
        assertFalse(arrayListStringType.isAssignableFrom(arrayListExtendsNumberType));
        assertFalse(arrayListNumberType.isAssignableFrom(arrayListExtendsNumberType));
        assertFalse(arrayListIntegerType.isAssignableFrom(arrayListExtendsNumberType));
        assertFalse(arrayListFloatType.isAssignableFrom(arrayListExtendsNumberType));
        assertTrue(arrayListExtendsObjectType.isAssignableFrom(arrayListExtendsNumberType));
        assertTrue(arrayListExtendsNumberType.isAssignableFrom(arrayListExtendsNumberType));

        
        Type arrayListExtendsIntegerType = Types.forName("ArrayList<? extends Integer>");

        assertFalse(arrayListExtendsIntegerType.isAssignableFrom(arrayListRawType));
        assertFalse(arrayListExtendsIntegerType.isAssignableFrom(arrayListObjectType));
        assertFalse(arrayListExtendsIntegerType.isAssignableFrom(arrayListStringType));
        assertFalse(arrayListExtendsIntegerType.isAssignableFrom(arrayListNumberType));
        assertTrue(arrayListExtendsIntegerType.isAssignableFrom(arrayListIntegerType));
        assertFalse(arrayListExtendsIntegerType.isAssignableFrom(arrayListFloatType));
        assertFalse(arrayListExtendsIntegerType.isAssignableFrom(arrayListExtendsObjectType));
        assertFalse(arrayListExtendsIntegerType.isAssignableFrom(arrayListExtendsNumberType));
        assertTrue(arrayListExtendsIntegerType.isAssignableFrom(arrayListExtendsIntegerType));
       
        assertTrue(arrayListExtendsNumberType.isAssignableFrom(arrayListExtendsIntegerType));

        
        Type listExtendsNumberType = Types.forName("List<? extends Number>");

        assertFalse(listExtendsNumberType.isAssignableFrom(arrayListRawType));
        assertFalse(listExtendsNumberType.isAssignableFrom(arrayListObjectType));
        assertFalse(listExtendsNumberType.isAssignableFrom(arrayListStringType));
        assertTrue(listExtendsNumberType.isAssignableFrom(arrayListNumberType));
        assertTrue(listExtendsNumberType.isAssignableFrom(arrayListIntegerType));
        assertTrue(listExtendsNumberType.isAssignableFrom(arrayListFloatType));
        assertFalse(listExtendsNumberType.isAssignableFrom(arrayListExtendsObjectType));
        assertTrue(listExtendsNumberType.isAssignableFrom(arrayListExtendsNumberType));
        assertFalse(arrayListExtendsNumberType.isAssignableFrom(listExtendsNumberType));
        
        
        Type listExtendsSerializableType = Types.forName("List<? extends Serializable>");

        assertFalse(listExtendsSerializableType.isAssignableFrom(arrayListRawType));
        assertFalse(listExtendsSerializableType.isAssignableFrom(arrayListObjectType));
        assertTrue(listExtendsSerializableType.isAssignableFrom(arrayListStringType));
        assertTrue(listExtendsSerializableType.isAssignableFrom(arrayListNumberType));
        assertTrue(listExtendsSerializableType.isAssignableFrom(arrayListIntegerType));
        assertTrue(listExtendsSerializableType.isAssignableFrom(arrayListFloatType));
        assertFalse(listExtendsSerializableType.isAssignableFrom(arrayListExtendsObjectType));
        assertTrue(listExtendsSerializableType.isAssignableFrom(arrayListExtendsNumberType));

        
        Type listRawType = Types.forName("List<?>");
        Type listListRawType = Types.forName("List<List<?>>");
        Type listListExtendsNumberType = Types.forName("List<List<? extends Number>>");
        Type listExtendsListExtendsNumberType = Types.forName("List<? extends List<? extends Number>>");
        Type listExtendsListNumberType = Types.forName("List<? extends List<Number>>");
        Type listArrayListExtendsNumberType = Types.forName("List<ArrayList<? extends Number>>");
        Type listExtendsArrayListExtendsNumberType = Types.forName("List<? extends ArrayList<? extends Number>>");

        assertTrue(listRawType.isAssignableFrom(arrayListRawType));
        assertFalse(arrayListRawType.isAssignableFrom(listRawType));
        
        assertTrue(listRawType.isAssignableFrom(listRawType));
        assertTrue(listRawType.isAssignableFrom(listListRawType));
        assertTrue(listRawType.isAssignableFrom(listListExtendsNumberType));
        assertTrue(listRawType.isAssignableFrom(listExtendsListExtendsNumberType));
        assertTrue(listRawType.isAssignableFrom(listExtendsListNumberType));
        assertTrue(listRawType.isAssignableFrom(listArrayListExtendsNumberType));
        assertTrue(listRawType.isAssignableFrom(listExtendsArrayListExtendsNumberType));
        
        assertFalse(listListRawType.isAssignableFrom(listRawType));
        assertTrue(listListRawType.isAssignableFrom(listListRawType));
        assertFalse(listListRawType.isAssignableFrom(listListExtendsNumberType));
        assertFalse(listListRawType.isAssignableFrom(listExtendsListExtendsNumberType));
        assertFalse(listListRawType.isAssignableFrom(listExtendsListNumberType));
        assertFalse(listListRawType.isAssignableFrom(listArrayListExtendsNumberType));
        assertFalse(listListRawType.isAssignableFrom(listExtendsArrayListExtendsNumberType));
        
        assertFalse(listListExtendsNumberType.isAssignableFrom(listRawType));
        assertFalse(listListExtendsNumberType.isAssignableFrom(listListRawType));
        assertTrue(listListExtendsNumberType.isAssignableFrom(listListExtendsNumberType));
        assertFalse(listListExtendsNumberType.isAssignableFrom(listExtendsListExtendsNumberType));
        assertFalse(listListExtendsNumberType.isAssignableFrom(listExtendsListNumberType));
        assertFalse(listListExtendsNumberType.isAssignableFrom(listArrayListExtendsNumberType));
        assertFalse(listListExtendsNumberType.isAssignableFrom(listExtendsArrayListExtendsNumberType));
        
        assertFalse(listExtendsListNumberType.isAssignableFrom(listRawType));
        assertFalse(listExtendsListNumberType.isAssignableFrom(listListRawType));
        assertFalse(listExtendsListNumberType.isAssignableFrom(listListExtendsNumberType));
        assertFalse(listExtendsListNumberType.isAssignableFrom(listExtendsListExtendsNumberType));
        assertTrue(listExtendsListNumberType.isAssignableFrom(listExtendsListNumberType));
        assertFalse(listExtendsListNumberType.isAssignableFrom(listArrayListExtendsNumberType));
        assertFalse(listExtendsListNumberType.isAssignableFrom(listExtendsArrayListExtendsNumberType));

        Type enumType = Types.forName("Enum");
        Type listEnumType = Types.forName("List<Enum>");
        Type listExtendsEnumType = Types.forName("List<? extends Enum>");
        Type testEnumType = Types.forName("org.op4j.type.testtypes.TestEnum");
        Type listTestEnumType = Types.forName("List<org.op4j.type.testtypes.TestEnum>");
        
        assertTrue(enumType.isAssignableFrom(testEnumType));
        assertFalse(testEnumType.isAssignableFrom(enumType));
        assertFalse(listEnumType.isAssignableFrom(listTestEnumType));
        assertTrue(listExtendsEnumType.isAssignableFrom(listTestEnumType));
        assertFalse(listTestEnumType.isAssignableFrom(listExtendsEnumType));
        assertFalse(listTestEnumType.isAssignableFrom(listEnumType));
        
        Type enumMapRawRawType = Types.forName("EnumMap<?,?>");
        Type enumMapTestEnumRawType = Types.forName("EnumMap<org.op4j.type.testtypes.TestEnum,?>");

        assertTrue(enumMapRawRawType.isAssignableFrom(enumMapRawRawType));
        assertTrue(enumMapRawRawType.isAssignableFrom(enumMapTestEnumRawType));

        assertFalse(enumMapTestEnumRawType.isAssignableFrom(enumMapRawRawType));
        assertTrue(enumMapTestEnumRawType.isAssignableFrom(enumMapTestEnumRawType));

        
    }
    
    
    private void checkValidName(String name) {
        Type type = Types.forName(name);
        String strType = type.getName();
        Type type2 = Types.forName(strType);
        assertEquals(type, type2);
    }

    private void checkInvalidName(String name) {
        try {
            Types.forName(name);
            assertTrue(false);
        } catch (TypeRecognitionException e) {
            assertTrue(true);
        }
    }
    
}
