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

package org.op4j.executables.functions.conversion;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.apache.commons.lang.BooleanUtils;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.executables.functions.AbstractNullAsNullFunc;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class ToBoolean {

	private static final FromBoolean FROM_BOOLEAN = new FromBoolean();
	private static final FromString FROM_STRING = new FromString();
	private static final FromNumber FROM_NUMBER = new FromNumber();
	
	
	private ToBoolean() {
		super();
	}
	
	
	public static FromBoolean fromBoolean() {
		return FROM_BOOLEAN;
	}
	
	
	public static FromString fromString() {
		return FROM_STRING;
	}
	
	
	public static FromNumber fromNumber() {
		return FROM_NUMBER;
	}
	
	
	
	
	public static class FromBoolean extends AbstractNullAsNullFunc<Boolean, Boolean> {
		
		public FromBoolean() {
			super();
		}
		
		public Type<? super Boolean> getResultType() {
			return Types.BOOLEAN;
		}

		@Override
        public Boolean nullAsNullExecute(final Boolean object) throws Exception {
			return Boolean.valueOf(object.booleanValue());
		}
		
	}

	
	

	public static class FromString extends AbstractNullAsNullFunc<Boolean, String> {
		
		public FromString() {
			super();
		}

		public Type<? super Boolean> getResultType() {
			return Types.BOOLEAN;
		}

		@Override
        public Boolean nullAsNullExecute(final String object) throws Exception {
			return BooleanUtils.toBooleanObject(object);
		}
		
		
	}
	
	
	
	
	public static class FromNumber extends AbstractNullAsNullFunc<Boolean, Number> {

		public FromNumber() {
			super();
		}
		
		public Type<? super Boolean> getResultType() {
			return Types.BOOLEAN;
		}

		@Override
        public Boolean nullAsNullExecute(final Number object) throws Exception {
            boolean result = false;
            if (object instanceof BigDecimal) {
                result = (((BigDecimal)object).unscaledValue().compareTo(BigInteger.ZERO) != 0);
            } else if (object instanceof BigInteger) {
                result = (((BigInteger)object).compareTo(BigInteger.ZERO) != 0);
            } else {
                result = (object.doubleValue() != 0.0);
            }
            return Boolean.valueOf(result);
		}
		
	}
	
	
}
