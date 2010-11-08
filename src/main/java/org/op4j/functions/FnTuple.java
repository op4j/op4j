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
import org.javatuples.Unit;

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
    

    
    

    
    
    static final class ToUnit<X,A> extends Function<X,Unit<A>> {
        
        private final IFunction<? super X,A> value0Function;
        
        
        ToUnit(
                final Function<? super X,A> value0Function) {
            
            super();
            
            this.value0Function = value0Function;
            
        }
        

        public Unit<A> execute(final X input, final ExecCtx ctx) throws Exception {
            return Unit.with(
                    this.value0Function.execute(input, ctx)); 
        }       
        
    }
    
    

    

    
    
    static final class ToPair<X,A,B> extends Function<X,Pair<A,B>> {
        
        private final IFunction<? super X,A> value0Function;
        private final IFunction<? super X,B> value1Function;
        
        
        ToPair(
                final Function<? super X,A> value0Function,
                final Function<? super X,B> value1Function) {
            
            super();
            
            this.value0Function = value0Function;
            this.value1Function = value1Function;
            
        }
        

        public Pair<A,B> execute(final X input, final ExecCtx ctx) throws Exception {
            return Pair.with(
                    this.value0Function.execute(input, ctx), 
                    this.value1Function.execute(input, ctx)); 
        }       
        
    }
    
    
    

    
    
    static final class ToKeyValue<X,A,B> extends Function<X,KeyValue<A,B>> {
        
        private final IFunction<? super X,A> value0Function;
        private final IFunction<? super X,B> value1Function;
        
        
        ToKeyValue(
                final Function<? super X,A> value0Function,
                final Function<? super X,B> value1Function) {
            
            super();
            
            this.value0Function = value0Function;
            this.value1Function = value1Function;
            
        }
        

        public KeyValue<A,B> execute(final X input, final ExecCtx ctx) throws Exception {
            return KeyValue.with(
                    this.value0Function.execute(input, ctx), 
                    this.value1Function.execute(input, ctx)); 
        }       
        
    }
    

    

    
    
    static final class ToLabelValue<X,A,B> extends Function<X,LabelValue<A,B>> {
        
        private final IFunction<? super X,A> value0Function;
        private final IFunction<? super X,B> value1Function;
        
        
        ToLabelValue(
                final Function<? super X,A> value0Function,
                final Function<? super X,B> value1Function) {
            
            super();
            
            this.value0Function = value0Function;
            this.value1Function = value1Function;
            
        }
        

        public LabelValue<A,B> execute(final X input, final ExecCtx ctx) throws Exception {
            return LabelValue.with(
                    this.value0Function.execute(input, ctx), 
                    this.value1Function.execute(input, ctx)); 
        }       
        
    }
    
    

    
    
    static final class ToTriplet<X,A,B,C> extends Function<X,Triplet<A,B,C>> {
        
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
        

        public Triplet<A,B,C> execute(final X input, final ExecCtx ctx) throws Exception {
            return Triplet.with(
                    this.value0Function.execute(input, ctx), 
                    this.value1Function.execute(input, ctx), 
                    this.value2Function.execute(input, ctx));
        }       
        
    }
    
    

    
    
    static final class ToQuartet<X,A,B,C,D> extends Function<X,Quartet<A,B,C,D>> {
        
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
        

        public Quartet<A,B,C,D> execute(final X input, final ExecCtx ctx) throws Exception {
            return Quartet.with(
                    this.value0Function.execute(input, ctx), 
                    this.value1Function.execute(input, ctx), 
                    this.value2Function.execute(input, ctx), 
                    this.value3Function.execute(input, ctx));
        }       
        
    }
    
    
    

    
    
    static final class ToQuintet<X,A,B,C,D,E> extends Function<X,Quintet<A,B,C,D,E>> {
        
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
        

        public Quintet<A,B,C,D,E> execute(final X input, final ExecCtx ctx) throws Exception {
            return Quintet.with(
                    this.value0Function.execute(input, ctx), 
                    this.value1Function.execute(input, ctx), 
                    this.value2Function.execute(input, ctx), 
                    this.value3Function.execute(input, ctx), 
                    this.value4Function.execute(input, ctx));
        }       
        
    }
    
    

    
    
    static final class ToSextet<X,A,B,C,D,E,F> extends Function<X,Sextet<A,B,C,D,E,F>> {
        
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
        

        public Sextet<A,B,C,D,E,F> execute(final X input, final ExecCtx ctx) throws Exception {
            return Sextet.with(
                    this.value0Function.execute(input, ctx), 
                    this.value1Function.execute(input, ctx), 
                    this.value2Function.execute(input, ctx), 
                    this.value3Function.execute(input, ctx), 
                    this.value4Function.execute(input, ctx), 
                    this.value5Function.execute(input, ctx));
        }       
        
    }
    
    
    
    

    
    
    static final class ToSeptet<X,A,B,C,D,E,F,G> extends Function<X,Septet<A,B,C,D,E,F,G>> {
        
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
        

        public Septet<A,B,C,D,E,F,G> execute(final X input, final ExecCtx ctx) throws Exception {
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
    
    
    
    
    
    

    
    
    static final class ToOctet<X,A,B,C,D,E,F,G,H> extends Function<X,Octet<A,B,C,D,E,F,G,H>> {
        
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
        

        public Octet<A,B,C,D,E,F,G,H> execute(final X input, final ExecCtx ctx) throws Exception {
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
    
    
    
    
    
    
    
    
	static final class ToEnnead<X,A,B,C,D,E,F,G,H,I> extends Function<X,Ennead<A,B,C,D,E,F,G,H,I>> {
		
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
	    

		public Ennead<A,B,C,D,E,F,G,H,I> execute(final X input, final ExecCtx ctx) throws Exception {
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
    
    
    
    
    
    static final class ToDecade<X,A,B,C,D,E,F,G,H,I,J> extends Function<X,Decade<A,B,C,D,E,F,G,H,I,J>> {
        
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
        

        public Decade<A,B,C,D,E,F,G,H,I,J> execute(final X input, final ExecCtx ctx) throws Exception {
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

	
}
