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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.op4j.exceptions.NonUniqueResultException;
import org.op4j.typescheme.TypeScheme;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Result {

    private static final long serialVersionUID = -7047131254509263235L;

    private final TypeScheme typeScheme;
    private final List<Object> results;

    
    
    Result(final TypeScheme typeScheme, final Object[] resultObjects) {
        
        super();
        Validate.isTrue(typeScheme.getComponentCount() == resultObjects.length, 
                "Result objects do not correspond to Type Scheme: " + typeScheme.getName());
        this.typeScheme = typeScheme;
        this.results = Arrays.asList(resultObjects);
        
    }



    public TypeScheme getTypeScheme() {
        return this.typeScheme;
    }

    public List<?> getResults() {
        return Collections.unmodifiableList(this.results);
    }

    public Object getUniqueResult() {
        if (getResultCount() > 1) {
            throw new NonUniqueResultException(this.typeScheme);
        }
        return this.results.get(0);
    }

    
    public int getResultCount() {
        return this.results.size();
    }

    
}
