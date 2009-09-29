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

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.op4j.type.Type;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class OperationRegistryInfo {
    
    private final String operationName;
    private final Type resultType;
    private final Map<String, Set<ArgumentsTypeScheme>> matchedArgumentTypeSchemeSetsByOperationImplClassName;
    private final Set<Set<ArgumentsTypeScheme>> matchedArgumentTypeSchemeSets;
    
    
    OperationRegistryInfo(final String operationName, final Type resultType) {
        this.operationName = operationName;
        this.resultType = resultType;
        this.matchedArgumentTypeSchemeSetsByOperationImplClassName = 
            new HashMap<String,Set<ArgumentsTypeScheme>>();
        this.matchedArgumentTypeSchemeSets = new HashSet<Set<ArgumentsTypeScheme>>();
    }
    
    
    void addMatchedArgumentTypeSchemes(final String operationImplClassName, 
            final Set<ArgumentsTypeScheme> argumentTypeSchemes) {
        final Set<ArgumentsTypeScheme> valueSet =
            Collections.unmodifiableSet(
                    new HashSet<ArgumentsTypeScheme>(argumentTypeSchemes));
        this.matchedArgumentTypeSchemeSetsByOperationImplClassName.put(
                operationImplClassName, valueSet);
        this.matchedArgumentTypeSchemeSets.add(valueSet);
    }
    
    
    String getOperationName() {
        return this.operationName;
    }
    
    
    Type getResultType() {
        return this.resultType;
    }

    
    Map<String,Set<ArgumentsTypeScheme>> getMatchedArgumentTypeSchemeSetsByOperationImplClassName() {
        return Collections.unmodifiableMap(this.matchedArgumentTypeSchemeSetsByOperationImplClassName);
    }
    
    Set<Set<ArgumentsTypeScheme>> getMatchedArgumentTypeSchemeSets() {
        return Collections.unmodifiableSet(this.matchedArgumentTypeSchemeSets);
    }
    
    
    @Override
    public String toString() {
        return this.resultType + " " + this.operationName + 
                " " + this.matchedArgumentTypeSchemeSets;
        
    }
    
}
