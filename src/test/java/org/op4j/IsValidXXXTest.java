package org.op4j;


import java.math.BigDecimal;
import java.util.Locale;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.op4j.functions.FnString;

@SuppressWarnings (value = "cast")
public class IsValidXXXTest extends TestCase {

    private String biggerThanInteger = String.valueOf((long)Integer.MAX_VALUE + 1);
    private String smallerThanInteger = String.valueOf((long)Integer.MIN_VALUE - 1);

    private String biggerThanShort = String.valueOf((int)Short.MAX_VALUE + 1);
    private String smallerThanShort = String.valueOf((int)Short.MIN_VALUE - 1);

    private String biggerThanByte = String.valueOf((short)Byte.MAX_VALUE + 1);
    private String smallerThanByte = String.valueOf((short)Byte.MIN_VALUE - 1);

    private String biggerThanLong = "9223372036854775808";
    private String smallerThanLong = "-9223372036854775809";

    private String biggerThanFloat = "3.4028236E38";
    private String smallerThanFloat = "1.3E-45";

    private String biggerThanDouble = "1.7976931348623158E308";
    private String smallerThanDouble = "4.8E-324";

    private String minInt = String.valueOf(Integer.MIN_VALUE);
    private String maxInt = String.valueOf(Integer.MAX_VALUE);

    private String minShort = String.valueOf(Short.MIN_VALUE);
    private String maxShort = String.valueOf(Short.MAX_VALUE);

    private String minByte = String.valueOf(Byte.MIN_VALUE);
    private String maxByte = String.valueOf(Byte.MAX_VALUE);

    private String minLong = String.valueOf(Long.MIN_VALUE);
    private String maxLong = String.valueOf(Long.MAX_VALUE);

    private String minFloat = new BigDecimal(Float.MIN_VALUE).toString();
    private String maxFloat = new BigDecimal(Float.MAX_VALUE).toString();

    private String minDouble = String.valueOf(Double.MIN_VALUE);
    private String maxDouble = String.valueOf(Double.MAX_VALUE);

    private String intWithPoint = "12.300";
    private String intWithComma = "12,300";

    private String shortWithPoint = "12.300";
    private String shortWithComma = "12,300";

    private String byteWithPoint = "1.2";
    private String byteWithComma = "1,2";

    private String longWithPoint = "199999999.2";
    private String longWithComma = "199999999,2";

    private String anyString = "12h";

    private String negativeInteger = "-2";
    
    @Override
    @Before
    public void setUp() throws Exception {
    }

    @SuppressWarnings({ "boxing" })
    @Test
    public void testIsValidInteger() {
        Boolean result = Op.on(this.biggerThanInteger).exec(FnString.isValidInteger()).get();
        assertFalse(result);	
        result = Op.on(this.smallerThanInteger).exec(FnString.isValidInteger()).get();
        assertFalse(result);    

        result = Op.on(this.maxInt).exec(FnString.isValidInteger()).get();
        assertTrue(result);    
        result = Op.on(this.minInt).exec(FnString.isValidInteger()).get();
        assertTrue(result);    

        result = Op.on(this.intWithComma).exec(FnString.isValidInteger(Locale.ENGLISH)).get();
        assertTrue(result);    
        result = Op.on(this.intWithPoint).exec(FnString.isValidInteger(Locale.ENGLISH)).get();
        assertFalse(result);    

        result = Op.on(this.anyString).exec(FnString.isValidInteger()).get();
        assertFalse(result);    

    }

    @SuppressWarnings({ "boxing" })
    @Test
    public void testIsValidShort() {
        Boolean result = Op.on(this.biggerThanShort).exec(FnString.isValidShort()).get();
        assertFalse(result);    
        result = Op.on(this.smallerThanShort).exec(FnString.isValidShort()).get();
        assertFalse(result);    

        result = Op.on(this.maxShort).exec(FnString.isValidShort()).get();
        assertTrue(result);    
        result = Op.on(this.minShort).exec(FnString.isValidShort()).get();
        assertTrue(result);    

        result = Op.on(this.shortWithComma).exec(FnString.isValidShort(Locale.ENGLISH)).get();
        assertTrue(result);    
        result = Op.on(this.shortWithPoint).exec(FnString.isValidShort(Locale.ENGLISH)).get();
        assertFalse(result);    

        result = Op.on(this.anyString).exec(FnString.isValidShort()).get();
        assertFalse(result);    

    }


    @SuppressWarnings({ "boxing" })
    @Test
    public void testIsValidByte() {
        Boolean result = Op.on(this.biggerThanByte).exec(FnString.isValidByte()).get();
        assertFalse(result);    
        result = Op.on(this.smallerThanByte).exec(FnString.isValidByte()).get();
        assertFalse(result);    

        result = Op.on(this.maxByte).exec(FnString.isValidByte()).get();
        assertTrue(result);    
        result = Op.on(this.minByte).exec(FnString.isValidByte()).get();
        assertTrue(result);    

        result = Op.on(this.byteWithComma).exec(FnString.isValidByte(Locale.ENGLISH)).get();
        assertTrue(result);    
        result = Op.on(this.byteWithPoint).exec(FnString.isValidByte(Locale.ENGLISH)).get();
        assertFalse(result);    

        result = Op.on(this.anyString).exec(FnString.isValidByte()).get();
        assertFalse(result);    

    }
    
    @SuppressWarnings({ "boxing" })
    @Test
    public void testIsValidLong() {
        Boolean result = Op.on(this.biggerThanLong).exec(FnString.isValidLong()).get();
        assertFalse(result);    
        result = Op.on(this.smallerThanLong).exec(FnString.isValidLong()).get();
        assertFalse(result);    

        result = Op.on(this.maxLong).exec(FnString.isValidLong()).get();
        assertTrue(result);    
        result = Op.on(this.minLong).exec(FnString.isValidLong()).get();
        assertTrue(result);    

        result = Op.on(this.longWithComma).exec(FnString.isValidLong(Locale.ENGLISH)).get();
        assertTrue(result);    
        result = Op.on(this.longWithPoint).exec(FnString.isValidLong(Locale.ENGLISH)).get();
        assertFalse(result);    

        result = Op.on(this.anyString).exec(FnString.isValidLong()).get();
        assertFalse(result);    

    }
    
    @SuppressWarnings({ "boxing" })
    @Test
    public void testIsValidBigInteger() {
        Boolean result = Op.on(this.biggerThanLong).exec(FnString.isValidBigInteger()).get();
        assertTrue(result);    
        result = Op.on(this.smallerThanLong).exec(FnString.isValidBigInteger()).get();
        assertTrue(result);    

        result = Op.on(this.maxLong).exec(FnString.isValidBigInteger()).get();
        assertTrue(result);    
        result = Op.on(this.minLong).exec(FnString.isValidBigInteger()).get();
        assertTrue(result);    

        result = Op.on(this.longWithComma).exec(FnString.isValidBigInteger(Locale.ENGLISH)).get();
        assertTrue(result);    
        result = Op.on(this.longWithPoint).exec(FnString.isValidBigInteger(Locale.ENGLISH)).get();
        assertFalse(result);    

        result = Op.on(this.anyString).exec(FnString.isValidBigInteger()).get();
        assertFalse(result);    

    }
    
    @SuppressWarnings({ "boxing" })
    @Test
    public void testIsValidFloat() {
        Boolean result = Op.on(this.biggerThanFloat).exec(FnString.isValidFloat()).get();
        assertFalse(result);    
        result = Op.on(this.smallerThanFloat).exec(FnString.isValidFloat()).get();
        assertFalse(result);    

        result = Op.on(this.maxFloat).exec(FnString.isValidFloat()).get();
        assertTrue(result);    
        result = Op.on(this.minFloat).exec(FnString.isValidFloat()).get();
        assertTrue(result);    

        result = Op.on(this.longWithComma).exec(FnString.isValidFloat(Locale.ENGLISH)).get();
        assertTrue(result);    
        result = Op.on(this.longWithPoint).exec(FnString.isValidFloat(Locale.ENGLISH)).get();
        assertTrue(result);    

        result = Op.on(this.anyString).exec(FnString.isValidFloat()).get();
        assertFalse(result);    

    }

    @SuppressWarnings({ "boxing" })
    @Test
    public void testIsValidDouble() {
        Boolean result = Op.on(this.biggerThanDouble).exec(FnString.isValidDouble()).get();
        assertFalse(result);    
        result = Op.on(this.smallerThanDouble).exec(FnString.isValidDouble()).get();
        assertFalse(result);    

        result = Op.on(this.maxDouble).exec(FnString.isValidDouble()).get();
        assertTrue(result);    
        result = Op.on(this.minDouble).exec(FnString.isValidDouble()).get();
        assertTrue(result);    

        result = Op.on(this.longWithComma).exec(FnString.isValidDouble(Locale.ENGLISH)).get();
        assertTrue(result);    
        result = Op.on(this.longWithPoint).exec(FnString.isValidDouble(Locale.ENGLISH)).get();
        assertTrue(result);    

        result = Op.on(this.anyString).exec(FnString.isValidDouble()).get();
        assertFalse(result);    

        result = Op.on(this.negativeInteger).exec(FnString.isValidDouble()).get();
        assertFalse(result);    

    }

    @SuppressWarnings({ "boxing" })
    @Test
    public void testIsValidBigDecimal() {
        Boolean result = Op.on(this.biggerThanDouble).exec(FnString.isValidBigDecimal()).get();
        assertTrue(result);    
        result = Op.on(this.smallerThanDouble).exec(FnString.isValidBigDecimal()).get();
        assertTrue(result);    

        result = Op.on(this.maxDouble).exec(FnString.isValidBigDecimal()).get();
        assertTrue(result);    
        result = Op.on(this.minDouble).exec(FnString.isValidBigDecimal()).get();
        assertTrue(result);    

        result = Op.on(this.longWithComma).exec(FnString.isValidBigDecimal(Locale.ENGLISH)).get();
        assertTrue(result);    
        result = Op.on(this.longWithPoint).exec(FnString.isValidBigDecimal(Locale.ENGLISH)).get();
        assertTrue(result);    

        result = Op.on(this.anyString).exec(FnString.isValidBigDecimal()).get();
        assertFalse(result);    

    }

}
