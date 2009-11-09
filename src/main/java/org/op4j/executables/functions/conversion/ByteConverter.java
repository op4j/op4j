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
public final class ByteConverter extends NonDecimalNumberConverter<Byte> {

    private static final long serialVersionUID = -5279805889263019640L;

    
    
    
    public ByteConverter() {
        super();
    }
    
    


    @Override
    protected Type<Byte> registerResultType() {
        return Types.BYTE;
    }
    
    


    @Override
    protected Set<FunctionArgumentScheme> registerNonDecimalNumberMatchedSchemes() {
        return new HashSet<FunctionArgumentScheme>();
    }
    

    
    @Override
    protected Byte executeNonDecimalNumber(final FunctionArguments arguments) throws Exception {
        return null;
    }

    
    @Override
    protected Byte fromNumber(final Number number) throws Exception {
        return Byte.valueOf(number.byteValue());
    }


    @Override
    protected Byte fromString(final String string) throws Exception {
        return Byte.valueOf(string);
    }


    @Override
    protected Byte fromString(final String string, final int radix) throws Exception {
        return Byte.valueOf(string, radix);
    }

}
