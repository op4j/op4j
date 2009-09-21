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

import org.op4j.typescheme.TypeScheme;



/*
 * (non-javadoc)
 * 
 * This class contains internal algorithms for ArgumentsTypeScheme processing and
 * handling.
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ArgumentsTypeSchemeUtil {

    
    static final void checkTargetComponents(final TypeScheme targetTypeScheme) {
        if (targetTypeScheme.hasLiterals()) {
            throw new IllegalArgumentException("Bad target type scheme \"" + 
                    targetTypeScheme.getName() + "\": target components cannot be literals");
        }
    }
    
    static final String createName(final TypeScheme targetTypeScheme, final TypeScheme parameterTypeScheme) {
        final StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(ArgumentsTypeSchemeNaming.ARGUMENT_TYPE_SCHEME_NAME_START_SYMBOL);
        strBuilder.append(targetTypeScheme.getName());
        strBuilder.append(ArgumentsTypeSchemeNaming.ARGUMENT_TYPE_SCHEME_NAME_SEPARATOR);
        strBuilder.append(parameterTypeScheme.getName());
        strBuilder.append(ArgumentsTypeSchemeNaming.ARGUMENT_TYPE_SCHEME_NAME_END_SYMBOL);
        return strBuilder.toString();
    }

    
    private ArgumentsTypeSchemeUtil() {
        super();
    }
    
}
