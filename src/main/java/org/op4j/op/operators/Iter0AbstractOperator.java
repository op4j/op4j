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
package org.op4j.op.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.op4j.op.interfaces.Operator;
import org.op4j.operation.Target;
import org.op4j.type.Type;
import org.op4j.typescheme.TypeScheme;
import org.op4j.typescheme.TypeSchemes;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
abstract class Iter0AbstractOperator<T> 
        implements Operator<T> {


    private final List<? extends Target<T>> targets;
    private final List<T> targetObjects;
    private final TypeScheme targetTypeScheme;

    
    
    
    Iter0AbstractOperator(final List<? extends Target<T>> targets) {
        
        super();
        
        final List<Target<T>> newTargets = new ArrayList<Target<T>>();
        final List<T> newTargetObjects = new ArrayList<T>();
        final List<Type> types = new ArrayList<Type>();
        
        for (final Target<T> target : targets) {
            newTargets.add(target);
            types.add(target.getIntendedType());
            newTargetObjects.add(target.getObject());
        }
        
        this.targets = Collections.unmodifiableList(newTargets);
        this.targetObjects = Collections.unmodifiableList(newTargetObjects);
        this.targetTypeScheme = TypeSchemes.forTypeList(types);
        
    }
    
    
    Iter0AbstractOperator(final Target<T> target) {
        
        super();
        
        final List<Target<T>> newTargets = new ArrayList<Target<T>>();
        final List<T> newTargetObjects = new ArrayList<T>();
        
        newTargets.add(target);
        this.targetTypeScheme = TypeSchemes.forSingleType(target.getIntendedType());
        newTargetObjects.add(target.getObject());
        
        this.targets = Collections.unmodifiableList(newTargets);
        this.targetObjects = Collections.unmodifiableList(newTargetObjects);
        
    }
    

    abstract List<? extends Target<T>> getTargets();
    
    protected final List<? extends Target<T>> getAbstractTargets() {
        return this.targets;
    }
    
    
    public final TypeScheme getTargetTypeScheme() {
        return this.targetTypeScheme;
    }

    
    final List<T> getTargetObjects() {
        return this.targetObjects;
    }
    
    
    final boolean areAllTargetsNull() {
        for (Object obj : this.targetObjects) {
            if (obj != null) {
                return false;
            }
        }
        return true;
    }
    

    public final int size() {
        return this.targets.size();
    }
    
    
    
}
