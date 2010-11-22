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
package org.op4j.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.javaruntype.type.Type;
import org.javatuples.Decade;
import org.javatuples.Ennead;
import org.javatuples.KeyValue;
import org.javatuples.LabelValue;
import org.javatuples.Octet;
import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Septet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;
import org.javatuples.Tuple;
import org.javatuples.Unit;
import org.javatuples.valueintf.IValue0;
import org.javatuples.valueintf.IValue1;
import org.javatuples.valueintf.IValue2;
import org.javatuples.valueintf.IValue3;
import org.javatuples.valueintf.IValue4;
import org.javatuples.valueintf.IValue5;
import org.javatuples.valueintf.IValue6;
import org.javatuples.valueintf.IValue7;
import org.javatuples.valueintf.IValue8;
import org.javatuples.valueintf.IValue9;
import org.javatuples.valueintf.IValueKey;
import org.javatuples.valueintf.IValueLabel;
import org.javatuples.valueintf.IValueValue;
import org.op4j.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class FnTuple {
    
	
	private FnTuple() {
		super();           
	}

    
    
    public static final <X,A> Function<X,Unit<A>> unitWith(
            final Function<? super X,A> value0Function) {
        return new ToUnit<X,A>(
                value0Function);
    }

    
    
    public static final <X,A,B> Function<X,Pair<A,B>> pairWith(
            final Function<? super X,A> value0Function,
            final Function<? super X,B> value1Function) {
        return new ToPair<X,A,B>(
                value0Function, value1Function);
    }

    
    
    public static final <X,A,B> Function<X,KeyValue<A,B>> keyValueWith(
            final Function<? super X,A> value0Function,
            final Function<? super X,B> value1Function) {
        return new ToKeyValue<X,A,B>(
                value0Function, value1Function);
    }

    
    
    public static final <X,A,B> Function<X,LabelValue<A,B>> labelValueWith(
            final Function<? super X,A> value0Function,
            final Function<? super X,B> value1Function) {
        return new ToLabelValue<X,A,B>(
                value0Function, value1Function);
    }


    
    
    
    public static final <X,A,B,C> Function<X,Triplet<A,B,C>> tripletWith(
            final Function<? super X,A> value0Function,
            final Function<? super X,B> value1Function,
            final Function<? super X,C> value2Function) {
        return new ToTriplet<X,A,B,C>(
                value0Function, value1Function,
                value2Function);
    }
    
    
    
    
    
    public static final <X,A,B,C,D> Function<X,Quartet<A,B,C,D>> quartetWith(
            final Function<? super X,A> value0Function,
            final Function<? super X,B> value1Function,
            final Function<? super X,C> value2Function,
            final Function<? super X,D> value3Function) {
        return new ToQuartet<X,A,B,C,D>(
                value0Function, value1Function,
                value2Function, value3Function);
    }
    
    
    
    
    public static final <X,A,B,C,D,E> Function<X,Quintet<A,B,C,D,E>> quintetWith(
            final Function<? super X,A> value0Function,
            final Function<? super X,B> value1Function,
            final Function<? super X,C> value2Function,
            final Function<? super X,D> value3Function,
            final Function<? super X,E> value4Function) {
        return new ToQuintet<X,A,B,C,D,E>(
                value0Function, value1Function,
                value2Function, value3Function,
                value4Function);
    }
    

    
    
    
    public static final <X,A,B,C,D,E,F> Function<X,Sextet<A,B,C,D,E,F>> sextetWith(
            final Function<? super X,A> value0Function,
            final Function<? super X,B> value1Function,
            final Function<? super X,C> value2Function,
            final Function<? super X,D> value3Function,
            final Function<? super X,E> value4Function,
            final Function<? super X,F> value5Function) {
        return new ToSextet<X,A,B,C,D,E,F>(
                value0Function, value1Function,
                value2Function, value3Function,
                value4Function, value5Function);
    }
    
    
    
    
    public static final <X,A,B,C,D,E,F,G> Function<X,Septet<A,B,C,D,E,F,G>> septetWith(
            final Function<? super X,A> value0Function,
            final Function<? super X,B> value1Function,
            final Function<? super X,C> value2Function,
            final Function<? super X,D> value3Function,
            final Function<? super X,E> value4Function,
            final Function<? super X,F> value5Function,
            final Function<? super X,G> value6Function) {
        return new ToSeptet<X,A,B,C,D,E,F,G>(
                value0Function, value1Function,
                value2Function, value3Function,
                value4Function, value5Function,
                value6Function);
    }
    
    
    
    
    public static final <X,A,B,C,D,E,F,G,H> Function<X,Octet<A,B,C,D,E,F,G,H>> octetWith(
            final Function<? super X,A> value0Function,
            final Function<? super X,B> value1Function,
            final Function<? super X,C> value2Function,
            final Function<? super X,D> value3Function,
            final Function<? super X,E> value4Function,
            final Function<? super X,F> value5Function,
            final Function<? super X,G> value6Function,
            final Function<? super X,H> value7Function) {
        return new ToOctet<X,A,B,C,D,E,F,G,H>(
                value0Function, value1Function,
                value2Function, value3Function,
                value4Function, value5Function,
                value6Function, value7Function);
    }
    
    
    
    
    public static final <X,A,B,C,D,E,F,G,H,I> Function<X,Ennead<A,B,C,D,E,F,G,H,I>> enneadWith(
            final Function<? super X,A> value0Function,
            final Function<? super X,B> value1Function,
            final Function<? super X,C> value2Function,
            final Function<? super X,D> value3Function,
            final Function<? super X,E> value4Function,
            final Function<? super X,F> value5Function,
            final Function<? super X,G> value6Function,
            final Function<? super X,H> value7Function,
            final Function<? super X,I> value8Function) {
        return new ToEnnead<X,A,B,C,D,E,F,G,H,I>(
                value0Function, value1Function,
                value2Function, value3Function,
                value4Function, value5Function,
                value6Function, value7Function,
                value8Function);
    }
    
    
    
    public static final <X,A,B,C,D,E,F,G,H,I,J> Function<X,Decade<A,B,C,D,E,F,G,H,I,J>> decadeWith(
            final Function<? super X,A> value0Function,
            final Function<? super X,B> value1Function,
            final Function<? super X,C> value2Function,
            final Function<? super X,D> value3Function,
            final Function<? super X,E> value4Function,
            final Function<? super X,F> value5Function,
            final Function<? super X,G> value6Function,
            final Function<? super X,H> value7Function,
            final Function<? super X,I> value8Function,
            final Function<? super X,J> value9Function) {
        return new ToDecade<X,A,B,C,D,E,F,G,H,I,J>(
                value0Function, value1Function,
                value2Function, value3Function,
                value4Function, value5Function,
                value6Function, value7Function,
                value8Function, value9Function);
    }
    
    
    
    public static final <X extends Tuple> Function<X,Object[]> toArray() {
        return new ToArray<X>();
    }
    
    
    
    public static final <X extends Tuple> Function<X,List<Object>> toList() {
        return new ToList<X>();
    }
    
    
    
    public static final <X extends Tuple> Function<X,Integer> getSize() {
        return new Size<X>();
    }
    
    
    
    public static final <X extends Tuple> Function<X,Boolean> contains(final Object value) {
        return new Contains<X>(value);
    }
    
    
    
    public static final <X extends Tuple> Function<X,Boolean> containsAll(final Collection<?> collection) {
        return new ContainsAll<X>(collection);
    }
    
    
    
    public static final <X extends Tuple> Function<X,Boolean> containsAll(final Object... values) {
        return new ContainsAll<X>(values);
    }
    
    
    
    public static final <Y,X extends IValue0<Y>> Function<X,Y> getValue0Of(final Type<Y> type) {
        return new GetValue0<Y,X>();
    }
    
    
    
    public static final <Y,X extends IValue1<Y>> Function<X,Y> getValue1Of(final Type<Y> type) {
        return new GetValue1<Y,X>();
    }
    
    
    
    public static final <Y,X extends IValue2<Y>> Function<X,Y> getValue2Of(final Type<Y> type) {
        return new GetValue2<Y,X>();
    }
    
    
    
    public static final <Y,X extends IValue3<Y>> Function<X,Y> getValue3Of(final Type<Y> type) {
        return new GetValue3<Y,X>();
    }
    
    
    
    public static final <Y,X extends IValue4<Y>> Function<X,Y> getValue4Of(final Type<Y> type) {
        return new GetValue4<Y,X>();
    }
    
    
    
    public static final <Y,X extends IValue5<Y>> Function<X,Y> getValue5Of(final Type<Y> type) {
        return new GetValue5<Y,X>();
    }
    
    
    
    public static final <Y,X extends IValue6<Y>> Function<X,Y> getValue6Of(final Type<Y> type) {
        return new GetValue6<Y,X>();
    }
    
    
    
    public static final <Y,X extends IValue7<Y>> Function<X,Y> getValue7Of(final Type<Y> type) {
        return new GetValue7<Y,X>();
    }
    
    
    
    public static final <Y,X extends IValue8<Y>> Function<X,Y> getValue8Of(final Type<Y> type) {
        return new GetValue8<Y,X>();
    }
    
    
    
    public static final <Y,X extends IValue9<Y>> Function<X,Y> getValue9Of(final Type<Y> type) {
        return new GetValue9<Y,X>();
    }
    
    
    
    public static final <Y,X extends IValueKey<Y>> Function<X,Y> getKeyOf(final Type<Y> type) {
        return new GetKey<Y,X>();
    }
    
    
    
    public static final <Y,X extends IValueValue<Y>> Function<X,Y> getValueOf(final Type<Y> type) {
        return new GetValue<Y,X>();
    }
    
    
    
    public static final <Y,X extends IValueLabel<Y>> Function<X,Y> getLabelOf(final Type<Y> type) {
        return new GetLabel<Y,X>();
    }
    
    
    
    
    
    
    
    

    
    
    static final class ToUnit<X,A> extends AbstractNotNullFunction<X,Unit<A>> {
        
        private final IFunction<? super X,A> value0Function;
        
        
        ToUnit(
                final Function<? super X,A> value0Function) {
            
            super();
            
            this.value0Function = value0Function;
            
        }
        

        @Override
        public Unit<A> notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return Unit.with(
                    this.value0Function.execute(input, ctx)); 
        }       
        
    }
    
    

    

    
    
    static final class ToPair<X,A,B> extends AbstractNotNullFunction<X,Pair<A,B>> {
        
        private final IFunction<? super X,A> value0Function;
        private final IFunction<? super X,B> value1Function;
        
        
        ToPair(
                final Function<? super X,A> value0Function,
                final Function<? super X,B> value1Function) {
            
            super();
            
            this.value0Function = value0Function;
            this.value1Function = value1Function;
            
        }
        

        @Override
        public Pair<A,B> notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return Pair.with(
                    this.value0Function.execute(input, ctx), 
                    this.value1Function.execute(input, ctx)); 
        }       
        
    }
    
    
    

    
    
    static final class ToKeyValue<X,A,B> extends AbstractNotNullFunction<X,KeyValue<A,B>> {
        
        private final IFunction<? super X,A> value0Function;
        private final IFunction<? super X,B> value1Function;
        
        
        ToKeyValue(
                final Function<? super X,A> value0Function,
                final Function<? super X,B> value1Function) {
            
            super();
            
            this.value0Function = value0Function;
            this.value1Function = value1Function;
            
        }
        

        @Override
        public KeyValue<A,B> notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return KeyValue.with(
                    this.value0Function.execute(input, ctx), 
                    this.value1Function.execute(input, ctx)); 
        }       
        
    }
    

    

    
    
    static final class ToLabelValue<X,A,B> extends AbstractNotNullFunction<X,LabelValue<A,B>> {
        
        private final IFunction<? super X,A> value0Function;
        private final IFunction<? super X,B> value1Function;
        
        
        ToLabelValue(
                final Function<? super X,A> value0Function,
                final Function<? super X,B> value1Function) {
            
            super();
            
            this.value0Function = value0Function;
            this.value1Function = value1Function;
            
        }
        

        @Override
        public LabelValue<A,B> notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return LabelValue.with(
                    this.value0Function.execute(input, ctx), 
                    this.value1Function.execute(input, ctx)); 
        }       
        
    }
    
    

    
    
    static final class ToTriplet<X,A,B,C> extends AbstractNotNullFunction<X,Triplet<A,B,C>> {
        
        private final IFunction<? super X,A> value0Function;
        private final IFunction<? super X,B> value1Function;
        private final IFunction<? super X,C> value2Function;
        
        
        ToTriplet(
                final Function<? super X,A> value0Function,
                final Function<? super X,B> value1Function,
                final Function<? super X,C> value2Function) {
            
            super();
            
            this.value0Function = value0Function;
            this.value1Function = value1Function;
            this.value2Function = value2Function;
            
        }
        

        @Override
        public Triplet<A,B,C> notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return Triplet.with(
                    this.value0Function.execute(input, ctx), 
                    this.value1Function.execute(input, ctx), 
                    this.value2Function.execute(input, ctx));
        }       
        
    }
    
    

    
    
    static final class ToQuartet<X,A,B,C,D> extends AbstractNotNullFunction<X,Quartet<A,B,C,D>> {
        
        private final IFunction<? super X,A> value0Function;
        private final IFunction<? super X,B> value1Function;
        private final IFunction<? super X,C> value2Function;
        private final IFunction<? super X,D> value3Function;
        
        
        ToQuartet(
                final Function<? super X,A> value0Function,
                final Function<? super X,B> value1Function,
                final Function<? super X,C> value2Function,
                final Function<? super X,D> value3Function) {
            
            super();
            
            this.value0Function = value0Function;
            this.value1Function = value1Function;
            this.value2Function = value2Function;
            this.value3Function = value3Function;
            
        }
        

        @Override
        public Quartet<A,B,C,D> notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return Quartet.with(
                    this.value0Function.execute(input, ctx), 
                    this.value1Function.execute(input, ctx), 
                    this.value2Function.execute(input, ctx), 
                    this.value3Function.execute(input, ctx));
        }       
        
    }
    
    
    

    
    
    static final class ToQuintet<X,A,B,C,D,E> extends AbstractNotNullFunction<X,Quintet<A,B,C,D,E>> {
        
        private final IFunction<? super X,A> value0Function;
        private final IFunction<? super X,B> value1Function;
        private final IFunction<? super X,C> value2Function;
        private final IFunction<? super X,D> value3Function;
        private final IFunction<? super X,E> value4Function;
        
        
        ToQuintet(
                final Function<? super X,A> value0Function,
                final Function<? super X,B> value1Function,
                final Function<? super X,C> value2Function,
                final Function<? super X,D> value3Function,
                final Function<? super X,E> value4Function) {
            
            super();
            
            this.value0Function = value0Function;
            this.value1Function = value1Function;
            this.value2Function = value2Function;
            this.value3Function = value3Function;
            this.value4Function = value4Function;
            
        }
        

        @Override
        public Quintet<A,B,C,D,E> notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return Quintet.with(
                    this.value0Function.execute(input, ctx), 
                    this.value1Function.execute(input, ctx), 
                    this.value2Function.execute(input, ctx), 
                    this.value3Function.execute(input, ctx), 
                    this.value4Function.execute(input, ctx));
        }       
        
    }
    
    

    
    
    static final class ToSextet<X,A,B,C,D,E,F> extends AbstractNotNullFunction<X,Sextet<A,B,C,D,E,F>> {
        
        private final IFunction<? super X,A> value0Function;
        private final IFunction<? super X,B> value1Function;
        private final IFunction<? super X,C> value2Function;
        private final IFunction<? super X,D> value3Function;
        private final IFunction<? super X,E> value4Function;
        private final IFunction<? super X,F> value5Function;
        
        
        ToSextet(
                final Function<? super X,A> value0Function,
                final Function<? super X,B> value1Function,
                final Function<? super X,C> value2Function,
                final Function<? super X,D> value3Function,
                final Function<? super X,E> value4Function,
                final Function<? super X,F> value5Function) {
            
            super();
            
            this.value0Function = value0Function;
            this.value1Function = value1Function;
            this.value2Function = value2Function;
            this.value3Function = value3Function;
            this.value4Function = value4Function;
            this.value5Function = value5Function;
            
        }
        

        @Override
        public Sextet<A,B,C,D,E,F> notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return Sextet.with(
                    this.value0Function.execute(input, ctx), 
                    this.value1Function.execute(input, ctx), 
                    this.value2Function.execute(input, ctx), 
                    this.value3Function.execute(input, ctx), 
                    this.value4Function.execute(input, ctx), 
                    this.value5Function.execute(input, ctx));
        }       
        
    }
    
    
    
    

    
    
    static final class ToSeptet<X,A,B,C,D,E,F,G> extends AbstractNotNullFunction<X,Septet<A,B,C,D,E,F,G>> {
        
        private final IFunction<? super X,A> value0Function;
        private final IFunction<? super X,B> value1Function;
        private final IFunction<? super X,C> value2Function;
        private final IFunction<? super X,D> value3Function;
        private final IFunction<? super X,E> value4Function;
        private final IFunction<? super X,F> value5Function;
        private final IFunction<? super X,G> value6Function;
        
        
        ToSeptet(
                final Function<? super X,A> value0Function,
                final Function<? super X,B> value1Function,
                final Function<? super X,C> value2Function,
                final Function<? super X,D> value3Function,
                final Function<? super X,E> value4Function,
                final Function<? super X,F> value5Function,
                final Function<? super X,G> value6Function) {
            
            super();
            
            this.value0Function = value0Function;
            this.value1Function = value1Function;
            this.value2Function = value2Function;
            this.value3Function = value3Function;
            this.value4Function = value4Function;
            this.value5Function = value5Function;
            this.value6Function = value6Function;
            
        }
        

        @Override
        public Septet<A,B,C,D,E,F,G> notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return Septet.with(
                    this.value0Function.execute(input, ctx), 
                    this.value1Function.execute(input, ctx), 
                    this.value2Function.execute(input, ctx), 
                    this.value3Function.execute(input, ctx), 
                    this.value4Function.execute(input, ctx), 
                    this.value5Function.execute(input, ctx), 
                    this.value6Function.execute(input, ctx));
        }       
        
    }
    
    
    
    
    
    

    
    
    static final class ToOctet<X,A,B,C,D,E,F,G,H> extends AbstractNotNullFunction<X,Octet<A,B,C,D,E,F,G,H>> {
        
        private final IFunction<? super X,A> value0Function;
        private final IFunction<? super X,B> value1Function;
        private final IFunction<? super X,C> value2Function;
        private final IFunction<? super X,D> value3Function;
        private final IFunction<? super X,E> value4Function;
        private final IFunction<? super X,F> value5Function;
        private final IFunction<? super X,G> value6Function;
        private final IFunction<? super X,H> value7Function;
        
        
        ToOctet(
                final Function<? super X,A> value0Function,
                final Function<? super X,B> value1Function,
                final Function<? super X,C> value2Function,
                final Function<? super X,D> value3Function,
                final Function<? super X,E> value4Function,
                final Function<? super X,F> value5Function,
                final Function<? super X,G> value6Function,
                final Function<? super X,H> value7Function) {
            
            super();
            
            this.value0Function = value0Function;
            this.value1Function = value1Function;
            this.value2Function = value2Function;
            this.value3Function = value3Function;
            this.value4Function = value4Function;
            this.value5Function = value5Function;
            this.value6Function = value6Function;
            this.value7Function = value7Function;
            
        }
        

        @Override
        public Octet<A,B,C,D,E,F,G,H> notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return Octet.with(
                    this.value0Function.execute(input, ctx), 
                    this.value1Function.execute(input, ctx), 
                    this.value2Function.execute(input, ctx), 
                    this.value3Function.execute(input, ctx), 
                    this.value4Function.execute(input, ctx), 
                    this.value5Function.execute(input, ctx), 
                    this.value6Function.execute(input, ctx), 
                    this.value7Function.execute(input, ctx));
        }       
        
    }
    
    
    
    
    
    
    
    
	static final class ToEnnead<X,A,B,C,D,E,F,G,H,I> extends AbstractNotNullFunction<X,Ennead<A,B,C,D,E,F,G,H,I>> {
		
	    private final IFunction<? super X,A> value0Function;
        private final IFunction<? super X,B> value1Function;
        private final IFunction<? super X,C> value2Function;
        private final IFunction<? super X,D> value3Function;
        private final IFunction<? super X,E> value4Function;
        private final IFunction<? super X,F> value5Function;
        private final IFunction<? super X,G> value6Function;
        private final IFunction<? super X,H> value7Function;
        private final IFunction<? super X,I> value8Function;
        
	    
        ToEnnead(
	            final Function<? super X,A> value0Function,
                final Function<? super X,B> value1Function,
                final Function<? super X,C> value2Function,
                final Function<? super X,D> value3Function,
                final Function<? super X,E> value4Function,
                final Function<? super X,F> value5Function,
                final Function<? super X,G> value6Function,
                final Function<? super X,H> value7Function,
                final Function<? super X,I> value8Function) {
	        
			super();
			
			this.value0Function = value0Function;
            this.value1Function = value1Function;
            this.value2Function = value2Function;
            this.value3Function = value3Function;
            this.value4Function = value4Function;
            this.value5Function = value5Function;
            this.value6Function = value6Function;
            this.value7Function = value7Function;
            this.value8Function = value8Function;
            
		}
	    

        @Override
		public Ennead<A,B,C,D,E,F,G,H,I> notNullExecute(final X input, final ExecCtx ctx) throws Exception {
			return Ennead.with(
			        this.value0Function.execute(input, ctx), 
                    this.value1Function.execute(input, ctx), 
                    this.value2Function.execute(input, ctx), 
                    this.value3Function.execute(input, ctx), 
                    this.value4Function.execute(input, ctx), 
                    this.value5Function.execute(input, ctx), 
                    this.value6Function.execute(input, ctx), 
                    this.value7Function.execute(input, ctx), 
                    this.value8Function.execute(input, ctx));
		}		
		
	}
    
    
    
    
    
    static final class ToDecade<X,A,B,C,D,E,F,G,H,I,J> extends AbstractNotNullFunction<X,Decade<A,B,C,D,E,F,G,H,I,J>> {
        
        private final IFunction<? super X,A> value0Function;
        private final IFunction<? super X,B> value1Function;
        private final IFunction<? super X,C> value2Function;
        private final IFunction<? super X,D> value3Function;
        private final IFunction<? super X,E> value4Function;
        private final IFunction<? super X,F> value5Function;
        private final IFunction<? super X,G> value6Function;
        private final IFunction<? super X,H> value7Function;
        private final IFunction<? super X,I> value8Function;
        private final IFunction<? super X,J> value9Function;
        
        
        ToDecade(
                final Function<? super X,A> value0Function,
                final Function<? super X,B> value1Function,
                final Function<? super X,C> value2Function,
                final Function<? super X,D> value3Function,
                final Function<? super X,E> value4Function,
                final Function<? super X,F> value5Function,
                final Function<? super X,G> value6Function,
                final Function<? super X,H> value7Function,
                final Function<? super X,I> value8Function,
                final Function<? super X,J> value9Function) {
            
            super();
            
            this.value0Function = value0Function;
            this.value1Function = value1Function;
            this.value2Function = value2Function;
            this.value3Function = value3Function;
            this.value4Function = value4Function;
            this.value5Function = value5Function;
            this.value6Function = value6Function;
            this.value7Function = value7Function;
            this.value8Function = value8Function;
            this.value9Function = value9Function;
            
        }
        

        @Override
        public Decade<A,B,C,D,E,F,G,H,I,J> notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return Decade.with(
                    this.value0Function.execute(input, ctx), 
                    this.value1Function.execute(input, ctx), 
                    this.value2Function.execute(input, ctx), 
                    this.value3Function.execute(input, ctx), 
                    this.value4Function.execute(input, ctx), 
                    this.value5Function.execute(input, ctx), 
                    this.value6Function.execute(input, ctx), 
                    this.value7Function.execute(input, ctx), 
                    this.value8Function.execute(input, ctx), 
                    this.value9Function.execute(input, ctx));
        }       
        
    }
    
    
    
    
    
    static final class ToArray<X extends Tuple> extends AbstractNotNullFunction<X,Object[]> {
        
        ToArray() {
            super();
        }
        

        @Override
        public Object[] notNullExecute(final Tuple input, final ExecCtx ctx) throws Exception {
            return input.toArray();
        }       
        
    }
    
    
    
    
    
    static final class ToList<X extends Tuple> extends AbstractNotNullFunction<X,List<Object>> {
        
        ToList() {
            super();
        }
        

        @Override
        public List<Object> notNullExecute(final Tuple input, final ExecCtx ctx) throws Exception {
            return input.toList();
        }       
        
    }
    
    
    
    
    
    static final class Size<X extends Tuple> extends AbstractNotNullFunction<X,Integer> {
        
        Size() {
            super();
        }
        

        @Override
        public Integer notNullExecute(final Tuple input, final ExecCtx ctx) throws Exception {
            return Integer.valueOf(input.getSize());
        }       
        
    }
    
    
    
    
    
    static final class Contains<X extends Tuple> extends AbstractNotNullFunction<X,Boolean> {
        
        private final Object contained;
        
        Contains(final Object contained) {
            super();
            this.contained = contained;
        }
        

        @Override
        public Boolean notNullExecute(final Tuple input, final ExecCtx ctx) throws Exception {
            return Boolean.valueOf(input.contains(this.contained));
        }       
        
    }
    
    
    
    
    
    static final class ContainsAll<X extends Tuple> extends AbstractNotNullFunction<X,Boolean> {
        
        private final List<Object> contained;
        
        ContainsAll(final Collection<?> contained) {
            super();
            this.contained = new ArrayList<Object>(contained);
        }
        
        ContainsAll(final Object... contained) {
            super();
            this.contained = VarArgsUtil.asRequiredObjectList(contained);
        }
        

        @Override
        public Boolean notNullExecute(final Tuple input, final ExecCtx ctx) throws Exception {
            return Boolean.valueOf(input.containsAll(this.contained));
        }       
        
    }
    


    
    
    static final class GetValue0<Y,X extends IValue0<Y>> extends AbstractNotNullFunction<X,Y> {
        
        GetValue0() {
            super();
        }
        

        @Override
        public Y notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return input.getValue0();
        }       
        
    }
    


    
    
    static final class GetValue1<Y,X extends IValue1<Y>> extends AbstractNotNullFunction<X,Y> {
        
        GetValue1() {
            super();
        }
        

        @Override
        public Y notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return input.getValue1();
        }       
        
    }
    


    
    
    static final class GetValue2<Y,X extends IValue2<Y>> extends AbstractNotNullFunction<X,Y> {
        
        GetValue2() {
            super();
        }
        

        @Override
        public Y notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return input.getValue2();
        }       
        
    }
    


    
    
    static final class GetValue3<Y,X extends IValue3<Y>> extends AbstractNotNullFunction<X,Y> {
        
        GetValue3() {
            super();
        }
        

        @Override
        public Y notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return input.getValue3();
        }       
        
    }
    


    
    
    static final class GetValue4<Y,X extends IValue4<Y>> extends AbstractNotNullFunction<X,Y> {
        
        GetValue4() {
            super();
        }
        

        @Override
        public Y notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return input.getValue4();
        }       
        
    }
    


    
    
    static final class GetValue5<Y,X extends IValue5<Y>> extends AbstractNotNullFunction<X,Y> {
        
        GetValue5() {
            super();
        }
        

        @Override
        public Y notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return input.getValue5();
        }       
        
    }
    


    
    
    static final class GetValue6<Y,X extends IValue6<Y>> extends AbstractNotNullFunction<X,Y> {
        
        GetValue6() {
            super();
        }
        

        @Override
        public Y notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return input.getValue6();
        }       
        
    }
    


    
    
    static final class GetValue7<Y,X extends IValue7<Y>> extends AbstractNotNullFunction<X,Y> {
        
        GetValue7() {
            super();
        }
        

        @Override
        public Y notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return input.getValue7();
        }       
        
    }
    


    
    
    static final class GetValue8<Y,X extends IValue8<Y>> extends AbstractNotNullFunction<X,Y> {
        
        GetValue8() {
            super();
        }
        

        @Override
        public Y notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return input.getValue8();
        }       
        
    }
    


    
    
    static final class GetValue9<Y,X extends IValue9<Y>> extends AbstractNotNullFunction<X,Y> {
        
        GetValue9() {
            super();
        }
        

        @Override
        public Y notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return input.getValue9();
        }       
        
    }
    


    
    
    static final class GetKey<Y,X extends IValueKey<Y>> extends AbstractNotNullFunction<X,Y> {
        
        GetKey() {
            super();
        }
        

        @Override
        public Y notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return input.getKey();
        }       
        
    }
    


    
    
    static final class GetValue<Y,X extends IValueValue<Y>> extends AbstractNotNullFunction<X,Y> {
        
        GetValue() {
            super();
        }
        

        @Override
        public Y notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return input.getValue();
        }       
        
    }
    


    
    
    static final class GetLabel<Y,X extends IValueLabel<Y>> extends AbstractNotNullFunction<X,Y> {
        
        GetLabel() {
            super();
        }
        

        @Override
        public Y notNullExecute(final X input, final ExecCtx ctx) throws Exception {
            return input.getLabel();
        }       
        
    }

	
}
