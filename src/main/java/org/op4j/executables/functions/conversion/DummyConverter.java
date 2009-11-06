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

package org.op4j.executables.functions.conversion;

import java.util.HashSet;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.executables.functions.FunctionArgumentScheme;
import org.op4j.executables.functions.FunctionArguments;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class DummyConverter extends ConverterImplementation<String> {

    

    @Override
    public String execute(FunctionArguments arguments) throws Exception {
        return "Dummy " + arguments.getTarget().toString();
    }

    
    @Override
    protected Set<FunctionArgumentScheme<? extends Object>> registerMatchedSchemes() {
        
        final Set<FunctionArgumentScheme<? extends Object>> matchedSchemes = 
            new HashSet<FunctionArgumentScheme<? extends Object>>();
        
        matchedSchemes.add(FunctionArgumentScheme.from(Types.OBJECT));
        
        return matchedSchemes;
        
    }

    
    @Override
    protected Type<String> registerResultType() {
        return Types.STRING;
    }


}
