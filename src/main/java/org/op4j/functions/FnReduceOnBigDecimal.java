package org.op4j.functions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

/**
 * @deprecated This class will be removed in version 1.2 
 */
@Deprecated
public final class FnReduceOnBigDecimal extends FnReduceOn<BigDecimal> {

    private static final Function<ValuePair<Number,Number>,BigDecimal> SUM = new Sum();
    private static final Function<ValuePair<Number,Number>,BigDecimal> AVG = new Avg();
    private static final Function<ValuePair<Number,Number>,BigDecimal> SUBT = new Subt();
    private static final Function<ValuePair<Number,Number>,BigDecimal> MULT = new Mult();
    private static final Function<ValuePair<Number,Number>,BigDecimal> DIV = new Div();
    private static final Function<ValuePair<Number,Number>,BigDecimal> REMAINDER = new Remainder();

    
    public final Function<ValuePair<Number,Number>,BigDecimal> sum() {
        return SUM;
    }
    
    public final Function<ValuePair<Number,Number>,BigDecimal> avg() {
        return AVG;
    }
    
    public final Function<ValuePair<Number,Number>,BigDecimal> avg(final RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }
    
    public final Function<ValuePair<Number,Number>,BigDecimal> avg(final MathContext mathContext) {
        return new Avg(mathContext);
    }
    
    public final Function<ValuePair<Number,Number>,BigDecimal> subt() {
        return SUBT;
    }
    
    public final Function<ValuePair<Number,Number>,BigDecimal> mult() {
        return MULT;
    }
    
    public final Function<ValuePair<Number,Number>,BigDecimal> div() {
        return DIV;
    }
    
    public final Function<ValuePair<Number,Number>,BigDecimal> div(final RoundingMode roundingMode) {
        return new Div(roundingMode);
    }
    
    public final Function<ValuePair<Number,Number>,BigDecimal> div(final MathContext mathContext) {
        return new Div(mathContext);
    }
    
    public final Function<ValuePair<Number,Number>,BigDecimal> remainder() {
        return REMAINDER;
    }
    
    public final Function<ValuePair<Number,Number>,BigDecimal> remainder(final MathContext mathContext) {
        return new Remainder(mathContext);
    }
    

    
    FnReduceOnBigDecimal() {
        super(Types.BIG_DECIMAL);
    }

    
    
    static BigDecimal fromNumber(final Number number) {
        if (number instanceof BigDecimal) {
            return (BigDecimal) number;
        }
        if (number instanceof BigInteger) {
            return new BigDecimal((BigInteger)number);
        }
        return BigDecimal.valueOf(number.doubleValue());
    }
    
    
    
    
    
    static final class Sum extends FnReduceOnNumber.DecimalSum<BigDecimal> {

        public Sum() {
            super();
        }

        @Override
        protected BigDecimal fromNumber(final Number number) {
            return FnReduceOnBigDecimal.fromNumber(number);
        }
        
    }

    
    static final class Subt extends FnReduceOnNumber.DecimalSubt<BigDecimal> {

        public Subt() {
            super();
        }

        @Override
        protected BigDecimal fromNumber(final Number number) {
            return FnReduceOnBigDecimal.fromNumber(number);
        }
        
    }

    
    static final class Mult extends FnReduceOnNumber.DecimalMult<BigDecimal> {

        public Mult() {
            super();
        }

        @Override
        protected BigDecimal fromNumber(final Number number) {
            return FnReduceOnBigDecimal.fromNumber(number);
        }
        
    }

    
    static final class Div extends FnReduceOnNumber.DecimalDiv<BigDecimal> {

        public Div() {
            super();
        }

        public Div(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public Div(final MathContext mathContext) {
            super(mathContext);
        }

        @Override
        protected BigDecimal fromNumber(final Number number) {
            return FnReduceOnBigDecimal.fromNumber(number);
        }
        
    }

    
    static final class Remainder extends FnReduceOnNumber.DecimalRemainder<BigDecimal> {

        public Remainder() {
            super();
        }

        public Remainder(final MathContext mathContext) {
            super(mathContext);
        }

        @Override
        protected BigDecimal fromNumber(final Number number) {
            return FnReduceOnBigDecimal.fromNumber(number);
        }
        
    }

    
    static final class Avg extends FnReduceOnNumber.DecimalAvg<BigDecimal> {

        public Avg() {
            super();
        }

        public Avg(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public Avg(final MathContext mathContext) {
            super(mathContext);
        }

        @Override
        protected BigDecimal fromNumber(final Number number) {
            return FnReduceOnBigDecimal.fromNumber(number);
        }
        
    }
    
    
}
