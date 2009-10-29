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
package org.op4j.functions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.op4j.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class FunctionArgumentScheme {
    
    private final Class<?> targetClass;
    private final List<Class<?>> parameterClasses;
    
    
    
    public static FunctionArgumentScheme fromClasses(final Class<?> targetClass, final Class<?>... parameterClasses) {
        return new FunctionArgumentScheme(targetClass, VarArgsUtil.asOptionalObjectList(parameterClasses));
    }
    
    
    
    private FunctionArgumentScheme(final Class<?> targetClass, final List<Class<?>> parameterClasses) {
        
        super();
        
        Validate.notNull(targetClass, "Target class cannot be null");
        Validate.noNullElements(parameterClasses, "Parameter classes list cannot contain null elements");

        this.targetClass = targetClass;
        this.parameterClasses = new ArrayList<Class<?>>(parameterClasses);
        
    }
    
    
    public Class<?> getTargetClass() {
        return this.targetClass;
    }

    
    public List<Class<?>> getParameterClasses() {
        return this.parameterClasses;
    }
    
    
    
    
    public boolean match(final FunctionArguments functionArguments) {
    	
    	Validate.notNull(functionArguments);
    	
    	if (functionArguments.getParameterCount() != this.parameterClasses.size()) {
    		return false;
    	}
    	
    	final Class<?> argumentsTargetClass = functionArguments.getTargetClass();
    	if (argumentsTargetClass != null && !this.targetClass.isAssignableFrom(argumentsTargetClass)) {
    	    return false;
    	}
    	
    	final List<Class<?>> argumentsParameterClasses = functionArguments.getParameterClasses();
    	for (int i = 0; i < this.parameterClasses.size(); i++) {
    	    final Class<?> argumentsParameterClass = argumentsParameterClasses.get(i);
    	    if (argumentsParameterClass != null && !this.parameterClasses.get(i).isAssignableFrom(argumentsParameterClass)) {
    	        return false;
    	    }
    	}
    	
    	return true;
    	
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
    
    
    public static void main(String[] args) {
        
        final FunctionArgumentScheme scheme = FunctionArgumentScheme.fromClasses(String.class, Integer.class, Serializable.class);
        final FunctionArguments argums = FunctionArguments.fromObjects("Hello", Arrays.asList(new Object[0]));
        
        
        System.out.println(scheme.match(argums));
    }
    
    
}
