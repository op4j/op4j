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

package org.op4j.op.target;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.op.commands.ICommand;
import org.op4j.op.commands.impl.Call;
import org.op4j.op.commands.impl.Eval;
import org.op4j.op.impl.parameters.Of;
import org.op4j.op.intf.parameters.IOf;
import org.op4j.op.intf.parameters.ISelect;
import org.op4j.op.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public abstract class Target {

    public static enum Structure { ARRAY, LIST, SET, MAP, MAP_ENTRY }
    
    private final TargetId id;

    
    
    public static Target forObject(final Object object) {
        final TargetId id = new TargetId(TargetId.ROOT, 0);
        final NodeTarget node = NodeTarget.forObject(id, object);
        return new StructureTarget(TargetId.ROOT, Arrays.asList(new TargetId[] {id}), Arrays.asList(new Target[] {node}), 1);
    }
    
    
    public Target(final TargetId id) {
        super();
        this.id = id;
    }
    
    public TargetId getId() {
        return this.id;
    }

    
    public abstract int getExecutionLevel();
    
    public abstract List<NodeTarget> getExecutionNodes();
    
    public abstract Object getObject();

    abstract Target doIterate();
    abstract Target doIteratePositions(final boolean desiredResult, final List<Integer> positions);
    abstract Target doIterateMapKeys(final boolean desiredResult, final List<Object> objects);
    abstract Target doIterateExpression(final boolean desiredResult, final String expression, final List<Object> expParams);
    abstract Target doIterateSelector(final boolean desiredResult, final ISelect<?> selector);
    abstract Target doIterateNull(final boolean desiredResult);
    abstract Target doIterateNullOr(final boolean desiredResult, final String expression, final List<Object> expParams);
    abstract Target doIterateNotNullAnd(final boolean desiredResult, final String expression, final List<Object> expParams);
    
    
    public Target iterate() {
        return doIterate();
    }
    
    public Target iterate(final int... positions) {
    	return doIteratePositions(true, VarArgsUtil.asRequiredIntegerList(positions));
    }

    
    public Target iterateForMapKeys(final Object... keys) {
    	return doIterateMapKeys(true, VarArgsUtil.asRequiredObjectList(keys));
    }

    
    public Target iterate(final String expression, final Object... optionalExpParams) {
    	return doIterateExpression(true, expression, VarArgsUtil.asOptionalObjectList(optionalExpParams));
    }

    
    public Target iterate(final ISelect<?> selector) {
        return doIterateSelector(true, selector);
    }

    
    public Target iterateNull() {
        return doIterateNull(true);
    }

    
    public Target iterateNullOr(final String expression, final Object... optionalExpParams) {
        return doIterateNullOr(true, expression, VarArgsUtil.asOptionalObjectList(optionalExpParams));
    }

    
    public Target iterateNullOrNot(final String expression, final Object... optionalExpParams) {
        return doIterateNullOr(false, expression, VarArgsUtil.asOptionalObjectList(optionalExpParams));
    }
    
    
    public Target iterateNot(final int[] positions) {
        return doIteratePositions(false, VarArgsUtil.asRequiredIntegerList(positions));
    }

    
    public Target iterateNot(final Object[] objects) {
        return doIterateMapKeys(false, VarArgsUtil.asRequiredObjectList(objects));
    }

    
    public Target iterateNot(final String expression, final Object... optionalExpParams) {
        return doIterateExpression(false, expression, VarArgsUtil.asOptionalObjectList(optionalExpParams));
    }

    
    public Target iterateNot(final ISelect<?> selector) {
        return doIterateSelector(false, selector);
    }

    
    public Target iterateNotNull() {
        return doIterateNull(false);
    }

    
    public Target iterateNotNullAnd(final String expression, final Object... optionalExpParams) {
        return doIterateNotNullAnd(true, expression, VarArgsUtil.asOptionalObjectList(optionalExpParams));
    }

    
    public Target iterateNotNullAndNot(final String expression, final Object... optionalExpParams) {
        return doIterateNotNullAnd(false, expression, VarArgsUtil.asOptionalObjectList(optionalExpParams));
    }
    

    public abstract Target endIterate(final Structure structure, final IOf<?> of);
    

    public abstract Target execute(final ICommand<?,?> command);
    
    
    public Object get() {
        if (getExecutionLevel() != 1) {
            throw new IllegalStateException("Cannot get result. Execution level is " + getExecutionLevel());
        }
        return getExecutionNodes().get(0).getObject();
    }
    

    
    public static void main(String[] args) {

        final String[] strings1 = new String[] {"Hello", "Goodbye", null}; 
        
        final String[][] stringsStrings1 = new String[][] { new String[] {"Hello!","Goodbye!"}, new String[]{"¡Hola!","¡Adiós!"}};
        
        final Map<String,String> map1 = new LinkedHashMap<String,String>();
        map1.put("es", "¡Hola!");
        map1.put("en", "Hello!");
        map1.put("gl", "Ola!");
        map1.put("ca", "Hola!");
        
        final Map<String,String> map2 = new LinkedHashMap<String,String>();
        map2.put("es", "¡Adiós!");
        map2.put("en", "Goodbye!");
        map2.put("gl", "Adéus!");
        map2.put("ca", "Adéu!");
        map2.put("fr", "Adieu!");
        
        final Map<?,?>[] maps1 = new Map<?,?>[] { map1, map2 };
        
        
        final Target strings1Target = Target.forObject(strings1);
        final Target maps1Target = Target.forObject(maps1);
        final Target stringsStrings1Target = Target.forObject(stringsStrings1);
        
        System.out.println(maps1Target.getExecutionNodes());
        System.out.println();

        System.out.println(maps1Target.iterate().getExecutionNodes());
        System.out.println();
        
        System.out.println(maps1Target.iterate().iterate().getExecutionNodes());
        System.out.println();
        
        System.out.println(maps1Target.iterate().iterate().iterate(new int[] {1}).getExecutionNodes());
        System.out.println();
        
        System.out.println(maps1Target.iterate(new int[] {0}).iterate().iterate(new int[] {1}).getExecutionNodes());
        System.out.println();

        System.out.println(maps1Target.iterate().iterate("key == 'gl'").iterate(new int[] {0}).getExecutionNodes());
        System.out.println();
        
        System.out.println(maps1Target.iterate().iterate("key == 'gl'").iterate(new int[] {1}).getExecutionNodes());
        System.out.println();
        
        System.out.println(maps1Target.iterate().iterateNot(new ISelect<Map.Entry<String,String>>() {

            public boolean eval(Entry<String, String> entry) {
                return (entry.getKey().equals("ca"));
            }
            
        }).iterate(new int[] {1}).getExecutionNodes());
        System.out.println();
     
        
        System.out.println(stringsStrings1Target.getExecutionNodes());
        
        System.out.println(stringsStrings1Target.iterate().getExecutionNodes());
        
        System.out.println(stringsStrings1Target.iterate().iterate().getExecutionNodes());
        
        System.out.println();
        
        System.out.println(stringsStrings1Target.iterate().iterate().endIterate(Structure.ARRAY, Of.STRING).getExecutionNodes());
        
        System.out.println();
        
        System.out.println(stringsStrings1Target.iterate().iterate().endIterate(Structure.ARRAY, Of.STRING).endIterate(Structure.ARRAY, Of.ARRAY_OF_STRING).getExecutionNodes());
        
        System.out.println();

        System.out.println(maps1Target.iterate().iterate("key == 'gl'").endIterate(Structure.MAP, null).getExecutionNodes());
        
        System.out.println(maps1Target.iterate(new int[] {0}).getExecutionNodes());

        System.out.println(maps1Target.iterate(new int[] {0}).iterate("key == 'gl'").endIterate(Structure.MAP, null).getExecutionNodes());
        System.out.println(maps1Target.iterate(new int[] {0}).iterate("key == 'gl'").endIterate(Structure.MAP, null).endIterate(Structure.ARRAY,Of.MAP).getExecutionNodes());

        System.out.println();

        System.out.println(strings1Target.getExecutionNodes());
        System.out.println(strings1Target.iterate().getExecutionNodes());
        System.out.println(strings1Target.iterateNotNull().getExecutionNodes());
        System.out.println(strings1Target.iterateNotNull().endIterate(Structure.LIST,null).getExecutionNodes());

        System.out.println();

        System.out.println();

        System.out.println(strings1Target.iterateNotNull().execute(Eval.stringExp("toUpperCase()")).getExecutionNodes());
        System.out.println(strings1Target.iterateNotNull().execute(Eval.stringExp("toUpperCase()")).endIterate(Structure.ARRAY, Of.STRING).getExecutionNodes());

        System.out.println();
        System.out.println(strings1Target.iterateNotNullAnd("length() > 5").execute(Eval.stringExp("toUpperCase()")).endIterate(Structure.ARRAY, Of.STRING).getExecutionNodes());
        
        
        System.out.println(strings1Target.iterateNull().execute(Eval.stringExp("'This was null ;-)'")).endIterate(Structure.ARRAY, Of.STRING).getExecutionNodes());

        System.out.println();

        System.out.println();

        System.out.println(maps1Target.iterate().iterateForMapKeys(new Object[] {"gl", "ca"}).getExecutionNodes());
        
        System.out.println(maps1Target.iterate().iterate("key == 'gl'").iterate(0).getExecutionNodes());
        
        System.out.println(strings1Target.iterateNotNull().execute(Call.aStringMethod("toUpperCase")).endIterate(Structure.ARRAY, Of.STRING).getExecutionNodes());
    }
    
}
