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

/*
 * Since: 1.0
 * 
 * Author: Daniel Fernandez Garrido
 */

grammar Type;

options {
    language=Java;
    output=AST;
    ASTLabelType=CommonTree;
}

tokens {
    ARRAY='[]';
    WILDCARD='?';
    BEGINTYPEPARAM='<';
    ENDTYPEPARAM='>';
    COMMA=',';
    EXTENDS=' extends ';
    SUPER=' super ';
    EXT='EXT';
    SUP='SUP';
}

@header {
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
package org.op4j.type.parser;
}

@lexer::header {
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
package org.op4j.type.parser;
}

@rulecatch {
    catch (RecognitionException e) {
    	throw e;
    }
}


type
    : typeExpression
    ;


typeExpression
    : CLASSNAME (arr+=ARRAY)*      -> ^(CLASSNAME $arr*)
    | CLASSNAME BEGINTYPEPARAM typePar+=typeParameterization (COMMA typePar+=typeParameterization)* ENDTYPEPARAM (arr+=ARRAY)*      -> ^(CLASSNAME $arr* $typePar+)
    ;

                      
typeParameterization
    : typeExpression
    | WILDCARD
    | WILDCARD EXTENDS typExp=typeExpression -> ^(EXT $typExp)
    | WILDCARD SUPER typExp=typeExpression -> ^(SUP $typExp)
    ;


CLASSNAME
    : ('a'..'z' | 'A'..'Z' | '0'..'9' | '-' | '_' | '.' | '$')+
    ;

WS
    : (' ')+ {skip();}
    ;
