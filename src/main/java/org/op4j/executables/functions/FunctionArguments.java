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
package org.op4j.executables.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class FunctionArguments {
    
    private final Object target;
    private final List<Object> parameters;
    private final Class<?> targetClass;
    private final List<Class<?>> parameterClasses;
    
    
    
    public static FunctionArguments fromObjects(final Object target, final List<Object> parameters) {
        return new FunctionArguments(target, parameters);
    }
    
    
    
    private FunctionArguments(final Object target, final List<Object> parameters) {
        
        super();

        this.target = target;
        this.parameters = new ArrayList<Object>(parameters);
        this.targetClass = (target != null? target.getClass() : null);
        this.parameterClasses = new ArrayList<Class<?>>();
        for (final Object object : this.parameters) {
        	this.parameterClasses.add((object != null? object.getClass() : null));
        }
        
    }
    
    
    public int getParameterCount() {
        return this.parameters.size();
    }

    
    public Class<?> getTargetClass() {
        return this.targetClass;
    }

    
    public List<Class<?>> getParameterClasses() {
        return this.parameterClasses;
    }
    
    
    public boolean isTargetNull() {
        return (this.target == null);
    }
    
    

    public Object getTarget() {
        return this.target;
    }
    
    
    public String getTargetAsString() {
    	if (this.target == null || this.target instanceof String) {
    		return (String) this.target;
    	}
        throw new IllegalArgumentException("Target is not a String (" + this.target.getClass() + ")");
    }
    

    public Byte getTargetAsByte() {
    	if (this.target == null || this.target instanceof Byte) {
    		return (Byte) this.target;
    	}
        throw new IllegalArgumentException("Target is not a Byte (" + this.target.getClass() + ")");
    }
    

    public Short getShortTarget(final int index) {
    	if (this.target == null || this.target instanceof Short) {
    		return (Short) this.target;
    	}
        throw new IllegalArgumentException("Target is not a Short (" + this.target.getClass() + ")");
    }

    
    public Integer getIntegerTarget(final int index) {
    	if (this.target == null || this.target instanceof Integer) {
    		return (Integer) this.target;
    	}
        throw new IllegalArgumentException("Target is not a Integer (" + this.target.getClass() + ")");
    }
    

    public Long getLongTarget(final int index) {
    	if (this.target == null || this.target instanceof Long) {
    		return (Long) this.target;
    	}
        throw new IllegalArgumentException("Target is not a Long (" + this.target.getClass() + ")");
    }
    

    public Float getFloatTarget(final int index) {
    	if (this.target == null || this.target instanceof Float) {
    		return (Float) this.target;
    	}
        throw new IllegalArgumentException("Target is not a Float (" + this.target.getClass() + ")");
    }
    

    public Double getDoubleTarget(final int index) {
    	if (this.target == null || this.target instanceof Double) {
    		return (Double) this.target;
    	}
        throw new IllegalArgumentException("Target is not a Double (" + this.target.getClass() + ")");
    }
    

    public Number getNumberTarget(final int index) {
    	if (this.target == null || this.target instanceof Number) {
    		return (Number) this.target;
    	}
        throw new IllegalArgumentException("Target is not a Number (" + this.target.getClass() + ")");
    }
    

    public Boolean getBooleanTarget(final int index) {
    	if (this.target == null || this.target instanceof Boolean) {
    		return (Boolean) this.target;
    	}
        throw new IllegalArgumentException("Target is not a Boolean (" + this.target.getClass() + ")");
    }
    

    public Locale getLocaleTarget(final int index) {
    	if (this.target == null || this.target instanceof Locale) {
    		return (Locale) this.target;
    	}
        throw new IllegalArgumentException("Target is not a Locale (" + this.target.getClass() + ")");
    }
    

    public Character getCharacterTarget(final int index) {
    	if (this.target == null || this.target instanceof Character) {
    		return (Character) this.target;
    	}
        throw new IllegalArgumentException("Target is not a Character (" + this.target.getClass() + ")");
    }
    

    public Class<?> getClassTarget(final int index) {
    	if (this.target == null || this.target instanceof Class<?>) {
    		return (Class<?>) this.target;
    	}
        throw new IllegalArgumentException("Target is not a Class<?> (" + this.target.getClass() + ")");
    }

    
    public Object getParameter(final int index) {
        if (index >= this.parameters.size()) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.size());
        }
        return this.parameters.get(index);
    }
    

    public String getStringParameter(final int index) {
        if (index >= this.parameters.size()) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.size());
        }
        final Object param = this.parameters.get(index);
    	if (param == null || param instanceof String) {
    		return (String) param;
    	}
        throw new IllegalArgumentException("Parameter " + index + " is not a String (" + this.target.getClass() + ")");
    }
    

    public Byte getByteParameter(final int index) {
        if (index >= this.parameters.size()) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.size());
        }
        final Object param = this.parameters.get(index);
    	if (param == null || param instanceof Byte) {
    		return (Byte) param;
    	}
        throw new IllegalArgumentException("Parameter " + index + " is not a Byte (" + this.target.getClass() + ")");
    }
    

    public Short getShortParameter(final int index) {
        if (index >= this.parameters.size()) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.size());
        }
        final Object param = this.parameters.get(index);
    	if (param == null || param instanceof Short) {
    		return (Short) param;
    	}
        throw new IllegalArgumentException("Parameter " + index + " is not a Short (" + this.target.getClass() + ")");
    }
    

    public Integer getIntegerParameter(final int index) {
        if (index >= this.parameters.size()) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.size());
        }
        final Object param = this.parameters.get(index);
    	if (param == null || param instanceof Integer) {
    		return (Integer) param;
    	}
        throw new IllegalArgumentException("Parameter " + index + " is not a Integer (" + this.target.getClass() + ")");
    }
    

    public Long getLongParameter(final int index) {
        if (index >= this.parameters.size()) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.size());
        }
        final Object param = this.parameters.get(index);
    	if (param == null || param instanceof Long) {
    		return (Long) param;
    	}
        throw new IllegalArgumentException("Parameter " + index + " is not a Long (" + this.target.getClass() + ")");
    }
    

    public Float getFloatParameter(final int index) {
        if (index >= this.parameters.size()) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.size());
        }
        final Object param = this.parameters.get(index);
    	if (param == null || param instanceof Float) {
    		return (Float) param;
    	}
        throw new IllegalArgumentException("Parameter " + index + " is not a Float (" + this.target.getClass() + ")");
    }
    

    public Double getDoubleParameter(final int index) {
        if (index >= this.parameters.size()) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.size());
        }
        final Object param = this.parameters.get(index);
    	if (param == null || param instanceof Double) {
    		return (Double) param;
    	}
        throw new IllegalArgumentException("Parameter " + index + " is not a Double (" + this.target.getClass() + ")");
    }
    

    public Number getNumberParameter(final int index) {
        if (index >= this.parameters.size()) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.size());
        }
        final Object param = this.parameters.get(index);
    	if (param == null || param instanceof Number) {
    		return (Number) param;
    	}
        throw new IllegalArgumentException("Parameter " + index + " is not a Number (" + this.target.getClass() + ")");
    }
    

    public Boolean getBooleanParameter(final int index) {
        if (index >= this.parameters.size()) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.size());
        }
        final Object param = this.parameters.get(index);
    	if (param == null || param instanceof Boolean) {
    		return (Boolean) param;
    	}
        throw new IllegalArgumentException("Parameter " + index + " is not a Boolean (" + this.target.getClass() + ")");
    }
    

    public Locale getLocaleParameter(final int index) {
        if (index >= this.parameters.size()) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.size());
        }
        final Object param = this.parameters.get(index);
    	if (param == null || param instanceof Locale) {
    		return (Locale) param;
    	}
        throw new IllegalArgumentException("Parameter " + index + " is not a Locale (" + this.target.getClass() + ")");
    }
    

    public Character getCharacterParameter(final int index) {
        if (index >= this.parameters.size()) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.size());
        }
        final Object param = this.parameters.get(index);
    	if (param == null || param instanceof Character) {
    		return (Character) param;
    	}
        throw new IllegalArgumentException("Parameter " + index + " is not a Character (" + this.target.getClass() + ")");
    }
    

    public Class<?> getRawClassParameter(final int index) {
        if (index >= this.parameters.size()) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.size());
        }
        final Object param = this.parameters.get(index);
    	if (param == null || param instanceof Class<?>) {
    		return (Class<?>) param;
    	}
        throw new IllegalArgumentException("Parameter " + index + " is not a Class<?> (" + this.target.getClass() + ")");
    }



    public String getStringRepresentation() {
    	final List<String> classNames = new ArrayList<String>();
    	for (final Class<?> parameterClass : this.parameterClasses) {
    		classNames.add(parameterClass.getCanonicalName());
    	}
        return StringUtils.join(classNames, ","); 
    }


    @Override
    public String toString() {
        return getStringRepresentation();
    }
    
}
