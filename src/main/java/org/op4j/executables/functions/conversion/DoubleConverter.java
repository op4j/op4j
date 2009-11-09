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
public final class DoubleConverter extends DecimalNumberConverter<Double> {


    private static final long serialVersionUID = 1820810568585284513L;


    
    
    public DoubleConverter() {
        super();
    }
    
    


    @Override
    protected Type<Double> registerResultType() {
        return Types.DOUBLE;
    }
    
    


    @Override
    protected Set<FunctionArgumentScheme> registerDecimalNumberMatchedSchemes() {
        return new HashSet<FunctionArgumentScheme>();
    }
    

    
    @Override
    protected Double executeDecimalNumber(final FunctionArguments arguments) throws Exception {
        return null;
    }

    
    @Override
    protected Double fromNumber(final Number number) throws Exception {
        return new Double(number.doubleValue());
    }

    
    @Override
    protected Double fromString(final String string) throws Exception {
        return Double.valueOf(string);
    }


}
