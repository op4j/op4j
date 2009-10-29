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

package org.op4j.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.Validate;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class VarArgsUtil {

    
    
    public static List<Object> asRequiredObjectList(final Object... parameters) {
        Validate.notNull(parameters, "Parameters cannot be null");
        Validate.isTrue(parameters.length > 0, "Paramters cannot be empty");
        return Arrays.asList(parameters);
    }
    
    public static List<Integer> asRequiredIntegerList(final int... parameters) {
        Validate.notNull(parameters, "Parameters cannot be null");
        Validate.isTrue(parameters.length > 0, "Paramters cannot be empty");
        return Arrays.asList(ArrayUtils.toObject(parameters));
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> List<T> asOptionalObjectList(final T... parameters) {
        final List<T> result = (List<T>) new ArrayList<Object>();
        if (parameters != null) {
            for (T parameter : parameters) {
                result.add(parameter);
            }
        } else {
            result.add(null);
        }
        return Collections.unmodifiableList(result);
    }

    
    
    private VarArgsUtil() {
        super();
    }
    
}
