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

package org.op4j;

import java.util.List;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.TransformerUtils;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.StringFuncs;
import org.op4j.functions.evaluators.AbstractStringEvaluator;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class ComCollTest {

    
    public static void main(String[] args) {
        
        List<String> emails = Op.onAll("HELLO@Hello.com", "GoodBye@HELLO.COM").buildList().get();
        
        List<String> lowEmails = Op.onList(emails).forEach().exec(StringFuncs.toLowerCase()).get();
        
        CollectionUtils.transform(emails, TransformerUtils.invokerTransformer("toLowerCase"));

        System.out.println(lowEmails);
        System.out.println(emails);
        
        
        List<String> emailsWithNulls = Op.onAll("HELLO@Hello.com", "GoodBye@HELLO.COM", null).buildList().get();
        
        
        CollectionUtils.forAllDo(emailsWithNulls, new Closure() {
            public void execute(Object email) {
            if(email==null) email= "admin@op4j.org";
            }
            });

        System.out.println(">" + emailsWithNulls);
        

        List<String> lowEmailsWithNulls2 = 
            Op.onList(emailsWithNulls).
                forEach().eval(new AbstractStringEvaluator<String>() {
                    public String execute(String object, ExecCtx ctx)
                            throws Exception {
                        return (object == null? "admin@op4j.org" : object);
                    }
                }).get();

        System.out.println(">" + lowEmailsWithNulls2);
        
        
        List<String> lowEmailsWithNulls = 
            Op.onList(emailsWithNulls).
                forEach().replaceIfNullWith("admin@hello.com").get();
        
        CollectionUtils.transform(emailsWithNulls,
                TransformerUtils.switchTransformer(
                        PredicateUtils.nullPredicate(), 
                        TransformerUtils.constantTransformer("admin@hello.com"), 
                        TransformerUtils.nopTransformer()));

        System.out.println(lowEmailsWithNulls);
        System.out.println(emailsWithNulls);

    }
    
}
