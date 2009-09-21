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
package org.op4j.operation;

import java.util.Locale;

import org.apache.commons.lang.ArrayUtils;
import org.op4j.objectscheme.ObjectScheme;
import org.op4j.objectscheme.ObjectSchemes;
import org.op4j.util.CastUtils;

/**
 * <p>
 * This class is a container for all the different inputs needed for an operation:
 * <i>targets</i> and <i>parameters</i>.
 * </p>
 * <p>
 * Alongside targets and parameters, {@link ObjectScheme} objects are computed
 * internally to contain the object's type information.
 * </p>
 * <p>
 * <b>This class should never be instantiated directly, and it should be used only
 * inside custom-developed Operation Implementations</b>
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Arguments {
    
    private final Target<?>[] targets;
    private final Object[] parameters;
    private final ObjectScheme targetScheme;
    private final ObjectScheme parameterScheme;
    
    
    Arguments(final Target<?>[] targets, final Object[] parameters) {
        
        super();

        this.targetScheme = ObjectSchemes.forTargets(targets);
        this.parameterScheme = ObjectSchemes.forParameters(parameters);
        this.targets = (Target<?>[]) ArrayUtils.clone(targets);
        this.parameters = CastUtils.unsafeExtractPossiblyCastedObjects(parameters);
        
    }
    

    /**
     * <p>
     * Retrieve the target object in a specific index.
     * </p>
     * @param index
     * @return the target object
     */
    public Object getTarget(final int index) {
        if (index >= this.targets.length) {
            throw new IllegalArgumentException(
                    "Asked for target " + index + ", but target count is " + this.targets.length);
        }
        return (this.targets[index] == null)? 
                null : this.targets[index].getObject();
    }
    
    /**
     * <p>
     * Retrieve the target object in a specific index, casting it as String
     * </p>
     * @param index
     * @return the target as a String
     */
    public String getStringTarget(final int index) {
        if (index >= this.targets.length) {
            throw new IllegalArgumentException(
                    "Asked for target " + index + ", but target count is " + this.targets.length);
        }
        return (this.targets[index] == null)? 
                null : (String) this.targets[index].getObject();
    }
    
    /**
     * <p>
     * Retrieve the target object in a specific index, casting it as Byte
     * </p>
     * @param index
     * @return the target as a Byte
     */
    public Byte getByteTarget(final int index) {
        if (index >= this.targets.length) {
            throw new IllegalArgumentException(
                    "Asked for target " + index + ", but target count is " + this.targets.length);
        }
        return (this.targets[index] == null)? 
                null : (Byte) this.targets[index].getObject();
    }
    
    /**
     * <p>
     * Retrieve the target object in a specific index, casting it as Short
     * </p>
     * @param index
     * @return the target as a Short
     */
    public Short getShortTarget(final int index) {
        if (index >= this.targets.length) {
            throw new IllegalArgumentException(
                    "Asked for target " + index + ", but target count is " + this.targets.length);
        }
        return (this.targets[index] == null)? 
                null : (Short) this.targets[index].getObject();
    }
    
    /**
     * <p>
     * Retrieve the target object in a specific index, casting it as Integer
     * </p>
     * @param index
     * @return the target as a Integer
     */
    public Integer getIntegerTarget(final int index) {
        if (index >= this.targets.length) {
            throw new IllegalArgumentException(
                    "Asked for target " + index + ", but target count is " + this.targets.length);
        }
        return (this.targets[index] == null)? 
                null : (Integer) this.targets[index].getObject();
    }
    
    /**
     * <p>
     * Retrieve the target object in a specific index, casting it as Long
     * </p>
     * @param index
     * @return the target as a Long
     */
    public Long getLongTarget(final int index) {
        if (index >= this.targets.length) {
            throw new IllegalArgumentException(
                    "Asked for target " + index + ", but target count is " + this.targets.length);
        }
        return (this.targets[index] == null)? 
                null : (Long) this.targets[index].getObject();
    }
    
    /**
     * <p>
     * Retrieve the target object in a specific index, casting it as Float
     * </p>
     * @param index
     * @return the target as a Float
     */
    public Float getFloatTarget(final int index) {
        if (index >= this.targets.length) {
            throw new IllegalArgumentException(
                    "Asked for target " + index + ", but target count is " + this.targets.length);
        }
        return (this.targets[index] == null)? 
                null : (Float) this.targets[index].getObject();
    }
    
    /**
     * <p>
     * Retrieve the target object in a specific index, casting it as Double
     * </p>
     * @param index
     * @return the target as a Double
     */
    public Double getDoubleTarget(final int index) {
        if (index >= this.targets.length) {
            throw new IllegalArgumentException(
                    "Asked for target " + index + ", but target count is " + this.targets.length);
        }
        return (this.targets[index] == null)? 
                null : (Double) this.targets[index].getObject();
    }
    
    /**
     * <p>
     * Retrieve the target object in a specific index, casting it as Number
     * </p>
     * @param index
     * @return the target as a Number
     */
    public Number getNumberTarget(final int index) {
        if (index >= this.targets.length) {
            throw new IllegalArgumentException(
                    "Asked for target " + index + ", but target count is " + this.targets.length);
        }
        return (this.targets[index] == null)? 
                null : (Number) this.targets[index].getObject();
    }
    
    /**
     * <p>
     * Retrieve the target object in a specific index, casting it as Boolean
     * </p>
     * @param index
     * @return the target as a Boolean
     */
    public Boolean getBooleanTarget(final int index) {
        if (index >= this.targets.length) {
            throw new IllegalArgumentException(
                    "Asked for target " + index + ", but target count is " + this.targets.length);
        }
        return (this.targets[index] == null)? 
                null : (Boolean) this.targets[index].getObject();
    }
    
    /**
     * <p>
     * Retrieve the target object in a specific index, casting it as Locale
     * </p>
     * @param index
     * @return the target as a Locale
     */
    public Locale getLocaleTarget(final int index) {
        if (index >= this.targets.length) {
            throw new IllegalArgumentException(
                    "Asked for target " + index + ", but target count is " + this.targets.length);
        }
        return (this.targets[index] == null)? 
                null : (Locale) this.targets[index].getObject();
    }
    
    /**
     * <p>
     * Retrieve the target object in a specific index, casting it as Character
     * </p>
     * @param index
     * @return the target as a Character
     */
    public Character getCharacterTarget(final int index) {
        if (index >= this.targets.length) {
            throw new IllegalArgumentException(
                    "Asked for target " + index + ", but target count is " + this.targets.length);
        }
        return (this.targets[index] == null)? 
                null : (Character) this.targets[index].getObject();
    }
    
    /**
     * <p>
     * Retrieve the target object in a specific index, casting it as Class
     * </p>
     * @param index
     * @return the target as a Class
     */
    public Class<?> getRawClassTarget(final int index) {
        if (index >= this.targets.length) {
            throw new IllegalArgumentException(
                    "Asked for target " + index + ", but target count is " + this.targets.length);
        }
        return (this.targets[index] == null)? 
                null : (Class<?>) this.targets[index].getObject();
    }

    

    /**
     * <p>
     * Retrieve the parameter object in a specific index.
     * </p>
     * @param index
     * @return the parameter object
     */
    public Object getParameter(final int index) {
        if (index >= this.parameters.length) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.length);
        }
        return this.parameters[index];
    }
    
    /**
     * <p>
     * Retrieve the parameter object in a specific index, casting it as String.
     * </p>
     * @param index
     * @return the parameter as a String
     */
    public String getStringParameter(final int index) {
        if (index >= this.parameters.length) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.length);
        }
        return (String) this.parameters[index];
    }
    
    /**
     * <p>
     * Retrieve the parameter object in a specific index, casting it as Byte.
     * </p>
     * @param index
     * @return the parameter as a Byte
     */
    public Byte getByteParameter(final int index) {
        if (index >= this.parameters.length) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.length);
        }
        return (Byte) this.parameters[index];
    }
    
    /**
     * <p>
     * Retrieve the parameter object in a specific index, casting it as Short.
     * </p>
     * @param index
     * @return the parameter as a Short
     */
    public Short getShortParameter(final int index) {
        if (index >= this.parameters.length) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.length);
        }
        return (Short) this.parameters[index];
    }
    
    /**
     * <p>
     * Retrieve the parameter object in a specific index, casting it as Integer.
     * </p>
     * @param index
     * @return the parameter as a Integer
     */
    public Integer getIntegerParameter(final int index) {
        if (index >= this.parameters.length) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.length);
        }
        return (Integer) this.parameters[index];
    }
    
    /**
     * <p>
     * Retrieve the parameter object in a specific index, casting it as Long.
     * </p>
     * @param index
     * @return the parameter as a Long
     */
    public Long getLongParameter(final int index) {
        if (index >= this.parameters.length) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.length);
        }
        return (Long) this.parameters[index];
    }
    
    /**
     * <p>
     * Retrieve the parameter object in a specific index, casting it as Float.
     * </p>
     * @param index
     * @return the parameter as a Float
     */
    public Float getFloatParameter(final int index) {
        if (index >= this.parameters.length) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.length);
        }
        return (Float) this.parameters[index];
    }
    
    /**
     * <p>
     * Retrieve the parameter object in a specific index, casting it as Double.
     * </p>
     * @param index
     * @return the parameter as a Double
     */
    public Double getDoubleParameter(final int index) {
        if (index >= this.parameters.length) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.length);
        }
        return (Double) this.parameters[index];
    }
    
    /**
     * <p>
     * Retrieve the parameter object in a specific index, casting it as Number.
     * </p>
     * @param index
     * @return the parameter as a Number
     */
    public Number getNumberParameter(final int index) {
        if (index >= this.parameters.length) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.length);
        }
        return (Number) this.parameters[index];
    }
    
    /**
     * <p>
     * Retrieve the parameter object in a specific index, casting it as Boolean.
     * </p>
     * @param index
     * @return the parameter as a Boolean
     */
    public Boolean getBooleanParameter(final int index) {
        if (index >= this.parameters.length) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.length);
        }
        return (Boolean) this.parameters[index];
    }
    
    /**
     * <p>
     * Retrieve the parameter object in a specific index, casting it as Locale.
     * </p>
     * @param index
     * @return the parameter as a Locale
     */
    public Locale getLocaleParameter(final int index) {
        if (index >= this.parameters.length) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.length);
        }
        return (Locale) this.parameters[index];
    }
    
    /**
     * <p>
     * Retrieve the parameter object in a specific index, casting it as Character.
     * </p>
     * @param index
     * @return the parameter as a Character
     */
    public Character getCharacterParameter(final int index) {
        if (index >= this.parameters.length) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.length);
        }
        return (Character) this.parameters[index];
    }
    
    /**
     * <p>
     * Retrieve the parameter object in a specific index, casting it as Class.
     * </p>
     * @param index
     * @return the parameter as a Class
     */
    public Class<?> getRawClassParameter(final int index) {
        if (index >= this.parameters.length) {
            throw new IllegalArgumentException(
                    "Asked for parameter " + index + ", but parameter count is " + this.parameters.length);
        }
        return (Class<?>) this.parameters[index];
    }

    
    /**
     * <p>
     * Retrieve the {@link ObjectScheme} which represents the contained targets.
     * </p>
     * 
     * @return the object scheme
     */
    public ObjectScheme getTargetScheme() {
        return this.targetScheme;
    }

    
    /**
     * <p>
     * Retrieve the {@link ObjectScheme} which represents the contained parameters.
     * </p>
     * 
     * @return the object scheme
     */
    public ObjectScheme getParameterScheme() {
        return this.parameterScheme;
    }
    
    
    /**
     * <p>
     * Returns the number of targets contained.
     * </p>
     * 
     * @return the number of targets.
     */
    public int getTargetCount() {
        return this.targets.length;
    }
    
    
    /**
     * <p>
     * Returns the number of parameters contained.
     * </p>
     * 
     * @return the number of targets.
     */
    public int getParameterCount() {
        return this.targets.length;
    }

    
    /**
     * <p>
     * Returns whether all targets are null.
     * </p>
     * 
     * @return <tt>true</tt> if all targets are null, <tt>false</tt> if not.
     */
    public boolean areAllTargetsNull() {
        for (int i = 0; i < this.targets.length; i++) {
            if (this.targets[i] != null) {
                if (this.targets[i].getObject() != null) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    /**
     * <p>
     * Retrieves the string representation for this <tt>Arguments</tt> object.
     * </p>
     * 
     * @return the string representation
     */
    public String getStringRepresentation() {
        /*
         * This is not cached in a "name" attribute as it is not as used as TypeScheme's
         * (which works as an index for the registry)
         */
        return ArgumentsUtil.createStringRepresentation(this.targetScheme, this.parameterScheme);
    }


    @Override
    public String toString() {
        return getStringRepresentation();
    }
    
}
