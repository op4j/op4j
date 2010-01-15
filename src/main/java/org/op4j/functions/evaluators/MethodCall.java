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
package org.op4j.functions.evaluators;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.MethodInvocationException;
import org.op4j.functions.ExecCtx;
import org.op4j.util.VarArgsUtil;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class MethodCall<R,T> implements IEvaluator<R,T> {
    
    
    private final Type<R> resultType;
    private final String methodName;
    private final List<Object> parameters;
    private final List<Class<?>> parameterClasses;
    
    
    
    public static MethodCall<?,Object> forObject(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Object,Object>(Types.OBJECT, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static <R> MethodCall<R,Object> forObjectOfType(final Type<R> resultType, final String methodName, final Object... optionalParameters) {
        return new MethodCall<R,Object>(resultType, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }


    
    public static MethodCall<BigInteger,Object> forBigInteger(final String methodName, final Object... optionalParameters) {
        return new MethodCall<BigInteger,Object>(Types.BIG_INTEGER, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static MethodCall<BigDecimal,Object> forBigDecimal(final String methodName, final Object... optionalParameters) {
        return new MethodCall<BigDecimal,Object>(Types.BIG_DECIMAL, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static MethodCall<Boolean,Object> forBoolean(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Boolean,Object>(Types.BOOLEAN, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static MethodCall<Byte,Object> forByte(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Byte,Object>(Types.BYTE, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static MethodCall<Character,Object> forCharacter(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Character,Object>(Types.CHARACTER, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static MethodCall<Calendar,Object> forCalendar(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Calendar,Object>(Types.CALENDAR, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static MethodCall<Date,Object> forDate(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Date,Object>(Types.DATE, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static MethodCall<Double,Object> forDouble(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Double,Object>(Types.DOUBLE, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static MethodCall<Float,Object> forFloat(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Float,Object>(Types.FLOAT, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static MethodCall<Integer,Object> forInteger(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Integer,Object>(Types.INTEGER, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static MethodCall<Long,Object> forLong(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Long,Object>(Types.LONG, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static MethodCall<Short,Object> forShort(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Short,Object>(Types.SHORT, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static MethodCall<String,Object> forString(final String methodName, final Object... optionalParameters) {
        return new MethodCall<String,Object>(Types.STRING, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    
    
    
    
    
    
    
    private MethodCall(final Type<R> resultType, final String methodName, final List<Object> parameters) {
    	Validate.notNull(resultType, "Result type cannot be null");
    	Validate.notNull(methodName, "Method name cannot be null");
        this.resultType = resultType;
        this.methodName = methodName;
        this.parameters = parameters;
        this.parameterClasses = extractParameterClasses(this.parameters);
    }
    
    private MethodCall(final Class<R> resultClass, final String methodName, final List<Object> parameters) {
    	Validate.notNull(resultClass, "Result class cannot be null");
    	Validate.notNull(methodName, "Method name cannot be null");
        this.resultType = Types.forClass(resultClass);
        this.methodName = methodName;
        this.parameters = parameters;
        this.parameterClasses = extractParameterClasses(this.parameters);
    }
    
    
    
    public Type<? extends R> getResultType(final Type<? extends T> targetType) {
    	return this.resultType;
    }

    
	
    @SuppressWarnings("unchecked")
	public R execute(final T input, final ExecCtx ctx) throws Exception {
    	
    	if (input == null) {
    		throw new NullPointerException("Cannot call methods on null object");
    	}

    	final Method method = resolveMethod(input.getClass(), this.methodName, this.parameterClasses);

    	Object result;
		try {
			
			result = method.invoke(input, this.parameters.toArray(new Object[0]));
			
		} catch (IllegalArgumentException e) {
			throw new MethodInvocationException(this.methodName, input.getClass(), this.parameterClasses, e);
		} catch (IllegalAccessException e) {
			throw new MethodInvocationException(this.methodName, input.getClass(), this.parameterClasses, e);
		} catch (InvocationTargetException e) {
			throw new MethodInvocationException(this.methodName, input.getClass(), this.parameterClasses, e);
		}
    	
		if (result == null) {
			return (R) result;
		}
		
		if (!(this.resultType.getRawClass().isAssignableFrom(result.getClass()))) {
			throw new MethodInvocationException(this.methodName, input.getClass(), this.parameterClasses, this.resultType.getRawClass());
		}
		
        return (R) result;
    }
 
	
	private static Method resolveMethod(final Class<?> targetClass, final String methodName, final List<Class<?>> parameterClasses) {
    	
    	final List<Method> methods = new ArrayList<Method>();
    	for (final Method currentMethod : targetClass.getMethods()) {
    		if (currentMethod.getName().equals(methodName) && 
    				parametersMatch(parameterClasses, currentMethod.getParameterTypes())) {
				methods.add(currentMethod);
    		}
    	}
    	
    	if (methods.size() == 1) {
    		return methods.get(0);
    	}
    	
		throw new MethodInvocationException(methodName, targetClass, parameterClasses);
		
	}

	
	private static List<Class<?>> extractParameterClasses(final List<Object> parameters) {
		
		final List<Class<?>> parameterClasses = new ArrayList<Class<?>>();
		for (int i = 0; i < parameters.size(); i++) {
			final Object parameter = parameters.get(i);
			if (parameter == null) {
				parameterClasses.add(null);
			} else {
				parameterClasses.add(parameter.getClass());
			}
		}
		return parameterClasses;
	}
	
	
	private static boolean parametersMatch(final List<Class<?>> parameterClasses, final Class<?>[] methodParameterTypes) {
		
		if (parameterClasses.size() != methodParameterTypes.length) {
			return false;
		}
		
		boolean match = true;
		for (int i = 0; i < methodParameterTypes.length; i++) {
			if (parameterClasses.get(i) != null) {
				if (!methodParameterTypes[0].isAssignableFrom(parameterClasses.get(i))) {
					match = false;
				}
			}
		}
		
		return match;
	}
	
}
