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
public final class IntegerConverter extends NonDecimalNumberConverter<Integer> {


    private static final long serialVersionUID = -4507296805634761144L;

    
    
    
    public IntegerConverter() {
        super();
    }
    
    


    @Override
    protected Type<Integer> registerResultType() {
        return Types.INTEGER;
    }
    
    


    @Override
    protected Set<FunctionArgumentScheme> registerNonDecimalNumberMatchedSchemes() {
        return new HashSet<FunctionArgumentScheme>();
    }
    

    
    @Override
    protected Integer executeNonDecimalNumber(final FunctionArguments arguments) throws Exception {
        return null;
    }

    
    @Override
    protected Integer fromNumber(final Number number) throws Exception {
        return Integer.valueOf(number.intValue());
    }


    @Override
    protected Integer fromString(final String string) throws Exception {
        return Integer.valueOf(string);
    }


    @Override
    protected Integer fromString(final String string, final int radix) throws Exception {
        return Integer.valueOf(string, radix);
    }

}
