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
package org.op4j.executables;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.op4j.IOf;
import org.op4j.Of;
import org.op4j.exceptions.MethodInvocationException;
import org.op4j.util.VarArgsUtil;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Call<X,T> implements ICall<X,T> {
    
    
    private final IOf<X> resultOf;
    private final String methodName;
    private final List<Object> parameters;
    private final List<Class<?>> parameterClasses;
    
    
    
    public static Call<?,Object> method(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Object>(Of.OBJECT, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static <X> Call<X,Object> method(final Of<X> of, final String methodName, final Object... optionalParameters) {
        return new Call<X,Object>(of, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static <X> Call<X,Object> method(final Class<X> ofClass, final String methodName, final Object... optionalParameters) {
        return new Call<X,Object>(ofClass, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }

    
    public static Call<BigInteger,Object> aBigIntegerMethod(final String methodName, final Object... optionalParameters) {
        return new Call<BigInteger,Object>(Of.BIG_INTEGER, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Call<BigDecimal,Object> aBigDecimalMethod(final String methodName, final Object... optionalParameters) {
        return new Call<BigDecimal,Object>(Of.BIG_DECIMAL, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Call<Boolean,Object> aBooleanMethod(final String methodName, final Object... optionalParameters) {
        return new Call<Boolean,Object>(Of.BOOLEAN, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Call<Byte,Object> aByteMethod(final String methodName, final Object... optionalParameters) {
        return new Call<Byte,Object>(Of.BYTE, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Call<Calendar,Object> aCalendarMethod(final String methodName, final Object... optionalParameters) {
        return new Call<Calendar,Object>(Of.CALENDAR, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Call<Double,Object> aDoubleMethod(final String methodName, final Object... optionalParameters) {
        return new Call<Double,Object>(Of.DOUBLE, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Call<Float,Object> aFloatMethod(final String methodName, final Object... optionalParameters) {
        return new Call<Float,Object>(Of.FLOAT, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Call<Integer,Object> aIntegerMethod(final String methodName, final Object... optionalParameters) {
        return new Call<Integer,Object>(Of.INTEGER, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Call<Long,Object> aLongMethod(final String methodName, final Object... optionalParameters) {
        return new Call<Long,Object>(Of.LONG, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Call<Short,Object> aShortMethod(final String methodName, final Object... optionalParameters) {
        return new Call<Short,Object>(Of.SHORT, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Call<String,Object> aStringMethod(final String methodName, final Object... optionalParameters) {
        return new Call<String,Object>(Of.STRING, methodName, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    
    private Call(final IOf<X> resultOf, final String methodName, final List<Object> parameters) {
    	Validate.notNull(resultOf, "Result characterization cannot be null");
    	Validate.notNull(methodName, "Method name cannot be null");
        this.resultOf = resultOf;
        this.methodName = methodName;
        this.parameters = parameters;
        this.parameterClasses = extractParameterClasses(this.parameters);
    }
    
    private Call(final Class<X> resultOfClass, final String methodName, final List<Object> parameters) {
    	Validate.notNull(resultOfClass, "Result characterization cannot be null");
    	Validate.notNull(methodName, "Method name cannot be null");
        this.resultOf = Of.clazz(resultOfClass);
        this.methodName = methodName;
        this.parameters = parameters;
        this.parameterClasses = extractParameterClasses(this.parameters);
    }
    
    
    public IOf<X> getResultOf() {
    	return this.resultOf;
    }

	
    @SuppressWarnings("unchecked")
	public X execute(final T input) {
    	
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
			return (X) result;
		}
		
		if (!(this.resultOf.getComponentClass().isAssignableFrom(result.getClass()))) {
			throw new MethodInvocationException(this.methodName, input.getClass(), this.parameterClasses, this.resultOf.getComponentClass());
		}
		
        return (X) result;
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
