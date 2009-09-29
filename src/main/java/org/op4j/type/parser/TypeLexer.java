// $ANTLR 3.0 org/op4j/type/parser/Type.g 2009-09-29 00:37:08

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class TypeLexer extends Lexer {
    public static final int WS=14;
    public static final int COMMA=8;
    public static final int EXT=11;
    public static final int WILDCARD=5;
    public static final int ENDTYPEPARAM=7;
    public static final int SUPER=10;
    public static final int Tokens=15;
    public static final int EOF=-1;
    public static final int EXTENDS=9;
    public static final int ARRAY=4;
    public static final int BEGINTYPEPARAM=6;
    public static final int SUP=12;
    public static final int CLASSNAME=13;
    public TypeLexer() {;} 
    public TypeLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "org/op4j/type/parser/Type.g"; }

    // $ANTLR start ARRAY
    public final void mARRAY() throws RecognitionException {
        try {
            int _type = ARRAY;
            // org/op4j/type/parser/Type.g:29:9: ( '[]' )
            // org/op4j/type/parser/Type.g:29:9: '[]'
            {
            match("[]"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ARRAY

    // $ANTLR start WILDCARD
    public final void mWILDCARD() throws RecognitionException {
        try {
            int _type = WILDCARD;
            // org/op4j/type/parser/Type.g:30:12: ( '?' )
            // org/op4j/type/parser/Type.g:30:12: '?'
            {
            match('?'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WILDCARD

    // $ANTLR start BEGINTYPEPARAM
    public final void mBEGINTYPEPARAM() throws RecognitionException {
        try {
            int _type = BEGINTYPEPARAM;
            // org/op4j/type/parser/Type.g:31:18: ( '<' )
            // org/op4j/type/parser/Type.g:31:18: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BEGINTYPEPARAM

    // $ANTLR start ENDTYPEPARAM
    public final void mENDTYPEPARAM() throws RecognitionException {
        try {
            int _type = ENDTYPEPARAM;
            // org/op4j/type/parser/Type.g:32:16: ( '>' )
            // org/op4j/type/parser/Type.g:32:16: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ENDTYPEPARAM

    // $ANTLR start COMMA
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            // org/op4j/type/parser/Type.g:33:9: ( ',' )
            // org/op4j/type/parser/Type.g:33:9: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COMMA

    // $ANTLR start EXTENDS
    public final void mEXTENDS() throws RecognitionException {
        try {
            int _type = EXTENDS;
            // org/op4j/type/parser/Type.g:34:11: ( ' extends ' )
            // org/op4j/type/parser/Type.g:34:11: ' extends '
            {
            match(" extends "); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EXTENDS

    // $ANTLR start SUPER
    public final void mSUPER() throws RecognitionException {
        try {
            int _type = SUPER;
            // org/op4j/type/parser/Type.g:35:9: ( ' super ' )
            // org/op4j/type/parser/Type.g:35:9: ' super '
            {
            match(" super "); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SUPER

    // $ANTLR start EXT
    public final void mEXT() throws RecognitionException {
        try {
            int _type = EXT;
            // org/op4j/type/parser/Type.g:36:7: ( 'EXT' )
            // org/op4j/type/parser/Type.g:36:7: 'EXT'
            {
            match("EXT"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EXT

    // $ANTLR start SUP
    public final void mSUP() throws RecognitionException {
        try {
            int _type = SUP;
            // org/op4j/type/parser/Type.g:37:7: ( 'SUP' )
            // org/op4j/type/parser/Type.g:37:7: 'SUP'
            {
            match("SUP"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SUP

    // $ANTLR start CLASSNAME
    public final void mCLASSNAME() throws RecognitionException {
        try {
            int _type = CLASSNAME;
            // org/op4j/type/parser/Type.g:120:7: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '-' | '_' | '.' | '$' )+ )
            // org/op4j/type/parser/Type.g:120:7: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '-' | '_' | '.' | '$' )+
            {
            // org/op4j/type/parser/Type.g:120:7: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '-' | '_' | '.' | '$' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='$'||(LA1_0>='-' && LA1_0<='.')||(LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // org/op4j/type/parser/Type.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1)>='-' && input.LA(1)<='.')||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CLASSNAME

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // org/op4j/type/parser/Type.g:124:7: ( ( ' ' )+ )
            // org/op4j/type/parser/Type.g:124:7: ( ' ' )+
            {
            // org/op4j/type/parser/Type.g:124:7: ( ' ' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // org/op4j/type/parser/Type.g:124:8: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            skip();

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    public void mTokens() throws RecognitionException {
        // org/op4j/type/parser/Type.g:1:10: ( ARRAY | WILDCARD | BEGINTYPEPARAM | ENDTYPEPARAM | COMMA | EXTENDS | SUPER | EXT | SUP | CLASSNAME | WS )
        int alt3=11;
        switch ( input.LA(1) ) {
        case '[':
            {
            alt3=1;
            }
            break;
        case '?':
            {
            alt3=2;
            }
            break;
        case '<':
            {
            alt3=3;
            }
            break;
        case '>':
            {
            alt3=4;
            }
            break;
        case ',':
            {
            alt3=5;
            }
            break;
        case ' ':
            {
            switch ( input.LA(2) ) {
            case 'e':
                {
                alt3=6;
                }
                break;
            case 's':
                {
                alt3=7;
                }
                break;
            default:
                alt3=11;}

            }
            break;
        case 'E':
            {
            int LA3_7 = input.LA(2);

            if ( (LA3_7=='X') ) {
                int LA3_13 = input.LA(3);

                if ( (LA3_13=='T') ) {
                    int LA3_15 = input.LA(4);

                    if ( (LA3_15=='$'||(LA3_15>='-' && LA3_15<='.')||(LA3_15>='0' && LA3_15<='9')||(LA3_15>='A' && LA3_15<='Z')||LA3_15=='_'||(LA3_15>='a' && LA3_15<='z')) ) {
                        alt3=10;
                    }
                    else {
                        alt3=8;}
                }
                else {
                    alt3=10;}
            }
            else {
                alt3=10;}
            }
            break;
        case 'S':
            {
            int LA3_8 = input.LA(2);

            if ( (LA3_8=='U') ) {
                int LA3_14 = input.LA(3);

                if ( (LA3_14=='P') ) {
                    int LA3_16 = input.LA(4);

                    if ( (LA3_16=='$'||(LA3_16>='-' && LA3_16<='.')||(LA3_16>='0' && LA3_16<='9')||(LA3_16>='A' && LA3_16<='Z')||LA3_16=='_'||(LA3_16>='a' && LA3_16<='z')) ) {
                        alt3=10;
                    }
                    else {
                        alt3=9;}
                }
                else {
                    alt3=10;}
            }
            else {
                alt3=10;}
            }
            break;
        case '$':
        case '-':
        case '.':
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case '_':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt3=10;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( ARRAY | WILDCARD | BEGINTYPEPARAM | ENDTYPEPARAM | COMMA | EXTENDS | SUPER | EXT | SUP | CLASSNAME | WS );", 3, 0, input);

            throw nvae;
        }

        switch (alt3) {
            case 1 :
                // org/op4j/type/parser/Type.g:1:10: ARRAY
                {
                mARRAY(); 

                }
                break;
            case 2 :
                // org/op4j/type/parser/Type.g:1:16: WILDCARD
                {
                mWILDCARD(); 

                }
                break;
            case 3 :
                // org/op4j/type/parser/Type.g:1:25: BEGINTYPEPARAM
                {
                mBEGINTYPEPARAM(); 

                }
                break;
            case 4 :
                // org/op4j/type/parser/Type.g:1:40: ENDTYPEPARAM
                {
                mENDTYPEPARAM(); 

                }
                break;
            case 5 :
                // org/op4j/type/parser/Type.g:1:53: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 6 :
                // org/op4j/type/parser/Type.g:1:59: EXTENDS
                {
                mEXTENDS(); 

                }
                break;
            case 7 :
                // org/op4j/type/parser/Type.g:1:67: SUPER
                {
                mSUPER(); 

                }
                break;
            case 8 :
                // org/op4j/type/parser/Type.g:1:73: EXT
                {
                mEXT(); 

                }
                break;
            case 9 :
                // org/op4j/type/parser/Type.g:1:77: SUP
                {
                mSUP(); 

                }
                break;
            case 10 :
                // org/op4j/type/parser/Type.g:1:81: CLASSNAME
                {
                mCLASSNAME(); 

                }
                break;
            case 11 :
                // org/op4j/type/parser/Type.g:1:91: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}