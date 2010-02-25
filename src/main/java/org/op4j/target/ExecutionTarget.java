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

package org.op4j.target;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.util.NormalisationUtils;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class ExecutionTarget extends Target {


    
    private final Object initialTarget;
    private final Normalisation initialNormalisation;
    
    private final int currentBlockLevel;
    
    private final ExecutionTargetOperation[][] operations;
    private final int[] previousBlockLevels;
    
    
    
    
    public static ExecutionTarget forFn(final Normalisation initialNormalisation) {
        return new ExecutionTarget(initialNormalisation);
    }
    
    
    
    public static ExecutionTarget forOp(final Object object, final Normalisation initialNormalisation) {
        return new ExecutionTarget(object, initialNormalisation);
    }

    
    
    
    private static ExecutionTargetOperation[][] cloneOperations(final ExecutionTargetOperation[][] operations) {

        final ExecutionTargetOperation[][] newOperations = new ExecutionTargetOperation[operations.length][];
        for (int i = 0, z = operations.length; i < z; i++) {
            newOperations[i] = operations[i].clone();
        }
        return newOperations;
        
    }
    

    
    
    @SuppressWarnings("unchecked")
    private static Object normaliseTarget(final Object target, final Normalisation normalisation) {
        
        Object normalisedTarget = null;
        switch (normalisation.getNormalisationType()) {
            case TYPE_NONE:
                normalisedTarget = target;
                break;
            case TYPE_ARRAY:
                normalisedTarget = NormalisationUtils.normaliseArray((Object[])target, normalisation.getArrayComponentClass());
                break;
            case TYPE_LIST:
                normalisedTarget = NormalisationUtils.normaliseList((List<Object>)target);
                break;
            case TYPE_MAP:
                normalisedTarget = NormalisationUtils.normaliseMap((Map<Object,Object>)target);
                break;
            case TYPE_MAPENTRY:
                normalisedTarget = NormalisationUtils.normaliseMapEntry((Map.Entry<Object,Object>)target);
                break;
            case TYPE_SET:
                normalisedTarget = NormalisationUtils.normaliseSet((Set<Object>)target);
                break;
        }
        return normalisedTarget;
        
    }
    
    
    
    
    private static ExecutionTargetOperation[][] addOperation(
            final ExecutionTargetOperation[][] operations, 
            final int currentBlockLevel, 
            final ExecutionTargetOperation operation) {
        
        final ExecutionTargetOperation[][] newOperations = new ExecutionTargetOperation[operations.length][];
        for (int i = 0, z = operations.length; i < z; i++) {
            if (i == currentBlockLevel) {
                newOperations[i] =
                    new ExecutionTargetOperation[operations[i].length + 1];
                for (int j = 0, y = operations[i].length; j < y; j++) {
                    newOperations[i][j] = operations[i][j];
                }
                newOperations[i][operations[i].length] = operation;
            } else {
                newOperations[i] = operations[i].clone();
            }
        }
        return newOperations;
        
    }

    
    private static ExecutionTargetOperation[][] addOperationAndBlockLevel(
            final ExecutionTargetOperation[][] operations, 
            final int currentBlockLevel,
            final ExecutionTargetOperation operation) {
        
        final ExecutionTargetOperation[][] newOperations = new ExecutionTargetOperation[operations.length + 1][];
        for (int i = 0, z = operations.length; i < z; i++) {
            if (i == currentBlockLevel) {
                newOperations[i] =
                    new ExecutionTargetOperation[operations[i].length + 1];
                for (int j = 0, y = operations[i].length; j < y; j++) {
                    newOperations[i][j] = operations[i][j];
                }
                newOperations[i][operations[i].length] = operation;
            } else {
                newOperations[i] = operations[i].clone();
            }
        }
        newOperations[operations.length] = new ExecutionTargetOperation[0];
        return newOperations;
        
    }
    
    
    private static int[] addPreviousBlockLevelRelation(
            final int[] previousBlockLevels, final int previousLevel) {
        
        final int[] newPreviousBlockLevels = new int[previousBlockLevels.length + 1];
        for (int i = 0, z = previousBlockLevels.length; i < z; i++) {
            newPreviousBlockLevels[i] = previousBlockLevels[i];
        }
        newPreviousBlockLevels[previousBlockLevels.length] = previousLevel;
        return newPreviousBlockLevels;
    }
    
    
    
    
    
    private ExecutionTarget(final Normalisation initialNormalisation) {
        
        super();
        
        final ExecutionTargetOperation[][] newOperations = 
            (ExecutionTargetOperation[][]) Array.newInstance(ExecutionTargetOperation[].class, 1);
        newOperations[0] = new ExecutionTargetOperation[0];
        
        final int[] newPreviousBlockLevels = new int[] { -1 };

        this.initialTarget = null;
        this.initialNormalisation = initialNormalisation;
        this.currentBlockLevel = 0;
        this.operations = newOperations;
        this.previousBlockLevels = newPreviousBlockLevels;
        
    }
    
    
    private ExecutionTarget(final Object initialTarget, final Normalisation initialNormalisation) {
        
        super();
        
        final ExecutionTargetOperation[][] newOperations = 
            (ExecutionTargetOperation[][]) Array.newInstance(ExecutionTargetOperation[].class, 1);
        newOperations[0] = new ExecutionTargetOperation[0];
        
        final int[] newPreviousBlockLevels = new int[] { -1 };

        this.initialTarget = initialTarget;
        this.initialNormalisation = initialNormalisation;
        this.currentBlockLevel = 0;
        this.operations = newOperations;
        this.previousBlockLevels = newPreviousBlockLevels;
        
    }
    
    
    
    private ExecutionTarget(final Object initialTarget,
            final Normalisation initialNormalisation,
            final int currentBlockLevel,
            final ExecutionTargetOperation[][] operations,
            final int[] previousBlockLevels) {
        
        super();
        
        this.initialTarget = initialTarget;
        this.initialNormalisation = initialNormalisation;
        this.currentBlockLevel = currentBlockLevel;
        this.operations = operations;
        this.previousBlockLevels = previousBlockLevels;
        
    }
    
    

    
    @Override
    Target doEndIterate(final Class<?> arrayComponentClass) {
            
        final int previousBlockLevel = this.previousBlockLevels[this.currentBlockLevel];
        final ExecutionTargetOperation[][] newOperations = cloneOperations(this.operations);
        final int previousBlockSize = newOperations[previousBlockLevel].length;
        final ExecutionTargetIterateOpenOperation iterateOpenOperation =
            (ExecutionTargetIterateOpenOperation) newOperations[previousBlockLevel][previousBlockSize - 1];
        newOperations[previousBlockLevel][previousBlockSize - 1] =
            iterateOpenOperation.close(arrayComponentClass);
            
        return new ExecutionTarget(this.initialTarget, this.initialNormalisation, previousBlockLevel, newOperations, this.previousBlockLevels);
        
    }



    @Override
    Target doEndOn() {
        
        final int previousBlockLevel = this.previousBlockLevels[this.currentBlockLevel];
        final ExecutionTargetOperation[][] newOperations = cloneOperations(this.operations);
            
        return new ExecutionTarget(this.initialTarget, this.initialNormalisation, previousBlockLevel, newOperations, this.previousBlockLevels);
        
    }



    @Override
    Target doEndSelect() {
        
        final int previousBlockLevel = this.previousBlockLevels[this.currentBlockLevel];
        final ExecutionTargetOperation[][] newOperations = cloneOperations(this.operations);
            
        return new ExecutionTarget(this.initialTarget, this.initialNormalisation, previousBlockLevel, newOperations, this.previousBlockLevels);
        
    }

    


    @Override
    Target doExecute(final IFunction<?,?> executable, final Normalisation normalisation) {

        final ExecutionTargetExecuteOperation operation =
            new ExecutionTargetExecuteOperation(executable, normalisation);
        final ExecutionTargetOperation[][] newOperations =
            addOperation(this.operations, this.currentBlockLevel, operation);

        return new ExecutionTarget(this.initialTarget, this.initialNormalisation, this.currentBlockLevel, newOperations, this.previousBlockLevels);
        
    }

    


    @Override
    Target doExecuteIfNotNull(final IFunction<?,?> executable, final Normalisation normalisation) {

        final ExecutionTargetExecuteIfNotNullOperation operation =
            new ExecutionTargetExecuteIfNotNullOperation(executable, normalisation);
        final ExecutionTargetOperation[][] newOperations =
            addOperation(this.operations, this.currentBlockLevel, operation);

        return new ExecutionTarget(this.initialTarget, this.initialNormalisation, this.currentBlockLevel, newOperations, this.previousBlockLevels);
        
    }



    @Override
    Target doIterate(final Structure structure, final boolean excludeFirstIndex) {

        final int newBlockLevel = this.operations.length;
        final ExecutionTargetIterateOpenOperation operation =
            new ExecutionTargetIterateOpenOperation(newBlockLevel, structure, excludeFirstIndex);
        final ExecutionTargetOperation[][] newOperations =
            addOperationAndBlockLevel(this.operations, this.currentBlockLevel, operation);
        final int[] newPreviousBlockLevels = 
            addPreviousBlockLevelRelation(this.previousBlockLevels, this.currentBlockLevel);
            
        return new ExecutionTarget(this.initialTarget, this.initialNormalisation, newBlockLevel, newOperations, newPreviousBlockLevels);
        
    }



    @Override
    Target doOnKey() {

        final int newBlockLevel = this.operations.length;
        final ExecutionTargetOnKeyOperation operation =
            new ExecutionTargetOnKeyOperation(newBlockLevel);
        final ExecutionTargetOperation[][] newOperations =
            addOperationAndBlockLevel(this.operations, this.currentBlockLevel, operation);
        final int[] newPreviousBlockLevels = 
            addPreviousBlockLevelRelation(this.previousBlockLevels, this.currentBlockLevel);
            
        return new ExecutionTarget(this.initialTarget, this.initialNormalisation, newBlockLevel, newOperations, newPreviousBlockLevels);
        
    }



    @Override
    Target doOnValue() {

        final int newBlockLevel = this.operations.length;
        final ExecutionTargetOnValueOperation operation =
            new ExecutionTargetOnValueOperation(newBlockLevel);
        final ExecutionTargetOperation[][] newOperations =
            addOperationAndBlockLevel(this.operations, this.currentBlockLevel, operation);
        final int[] newPreviousBlockLevels = 
            addPreviousBlockLevelRelation(this.previousBlockLevels, this.currentBlockLevel);
            
        return new ExecutionTarget(this.initialTarget, this.initialNormalisation, newBlockLevel, newOperations, newPreviousBlockLevels);
        
    }



    @Override
    Target doReplaceWith(final Object replacement, final Normalisation normalisation) {

        final ExecutionTargetReplaceWithOperation operation =
            new ExecutionTargetReplaceWithOperation(replacement, normalisation);
        final ExecutionTargetOperation[][] newOperations =
            addOperation(this.operations, this.currentBlockLevel, operation);

        return new ExecutionTarget(this.initialTarget, this.initialNormalisation, this.currentBlockLevel, newOperations, this.previousBlockLevels);

    }

    
    

    @Override
    Target doSelectIndex(final boolean desiredResult, final List<Integer> positions) {

        final int newBlockLevel = this.operations.length;
        final ExecutionTargetSelectIndexOperation operation =
            new ExecutionTargetSelectIndexOperation(newBlockLevel, desiredResult, positions);
        final ExecutionTargetOperation[][] newOperations =
            addOperationAndBlockLevel(this.operations, this.currentBlockLevel, operation);
        final int[] newPreviousBlockLevels = 
            addPreviousBlockLevelRelation(this.previousBlockLevels, this.currentBlockLevel);
            
        return new ExecutionTarget(this.initialTarget, this.initialNormalisation, newBlockLevel, newOperations, newPreviousBlockLevels);
        
    }



    @Override
    Target doSelectMapKeys(final boolean desiredResult, final List<Object> objects) {

        final int newBlockLevel = this.operations.length;
        final ExecutionTargetSelectMapKeysOperation operation =
            new ExecutionTargetSelectMapKeysOperation(newBlockLevel, desiredResult, objects);
        final ExecutionTargetOperation[][] newOperations =
            addOperationAndBlockLevel(this.operations, this.currentBlockLevel, operation);
        final int[] newPreviousBlockLevels = 
            addPreviousBlockLevelRelation(this.previousBlockLevels, this.currentBlockLevel);
            
        return new ExecutionTarget(this.initialTarget, this.initialNormalisation, newBlockLevel, newOperations, newPreviousBlockLevels);
        
    }



    @Override
    Target doSelectMatching(final boolean desiredResult, final IFunction<Object,Boolean> eval) {

        final int newBlockLevel = this.operations.length;
        final ExecutionTargetSelectMatchingOperation operation =
            new ExecutionTargetSelectMatchingOperation(newBlockLevel, desiredResult, eval);
        final ExecutionTargetOperation[][] newOperations =
            addOperationAndBlockLevel(this.operations, this.currentBlockLevel, operation);
        final int[] newPreviousBlockLevels = 
            addPreviousBlockLevelRelation(this.previousBlockLevels, this.currentBlockLevel);
            
        return new ExecutionTarget(this.initialTarget, this.initialNormalisation, newBlockLevel, newOperations, newPreviousBlockLevels);
        
    }



    @Override
    Target doSelectNotNullAndMatching(final boolean desiredResult, final IFunction<Object,Boolean> eval) {

        final int newBlockLevel = this.operations.length;
        final ExecutionTargetSelectNotNullAndMatchingOperation operation =
            new ExecutionTargetSelectNotNullAndMatchingOperation(newBlockLevel, desiredResult, eval);
        final ExecutionTargetOperation[][] newOperations =
            addOperationAndBlockLevel(this.operations, this.currentBlockLevel, operation);
        final int[] newPreviousBlockLevels = 
            addPreviousBlockLevelRelation(this.previousBlockLevels, this.currentBlockLevel);
            
        return new ExecutionTarget(this.initialTarget, this.initialNormalisation, newBlockLevel, newOperations, newPreviousBlockLevels);
        
    }



    @Override
    Target doSelectNull(final boolean desiredResult) {

        final int newBlockLevel = this.operations.length;
        final ExecutionTargetSelectNullOperation operation =
            new ExecutionTargetSelectNullOperation(newBlockLevel, desiredResult);
        final ExecutionTargetOperation[][] newOperations =
            addOperationAndBlockLevel(this.operations, this.currentBlockLevel, operation);
        final int[] newPreviousBlockLevels = 
            addPreviousBlockLevelRelation(this.previousBlockLevels, this.currentBlockLevel);
            
        return new ExecutionTarget(this.initialTarget, this.initialNormalisation, newBlockLevel, newOperations, newPreviousBlockLevels);
        
    }



    @Override
    Target doSelectNullOrMatching(final boolean desiredResult, final IFunction<Object,Boolean> eval) {

        final int newBlockLevel = this.operations.length;
        final ExecutionTargetSelectNullOrMatchingOperation operation =
            new ExecutionTargetSelectNullOrMatchingOperation(newBlockLevel, desiredResult, eval);
        final ExecutionTargetOperation[][] newOperations =
            addOperationAndBlockLevel(this.operations, this.currentBlockLevel, operation);
        final int[] newPreviousBlockLevels = 
            addPreviousBlockLevelRelation(this.previousBlockLevels, this.currentBlockLevel);
            
        return new ExecutionTarget(this.initialTarget, this.initialNormalisation, newBlockLevel, newOperations, newPreviousBlockLevels);
        
    }



    
    @Override
    Target doCast(final CastType targetType, final Type<?>... types) {

        final ExecutionTargetCastOperation operation =
            new ExecutionTargetCastOperation(targetType, types);
        final ExecutionTargetOperation[][] newOperations =
            addOperation(this.operations, this.currentBlockLevel, operation);

        return new ExecutionTarget(this.initialTarget, this.initialNormalisation, this.currentBlockLevel, newOperations, this.previousBlockLevels);

    }



    @Override
    Target doMap(final Structure structure, final IFunction<?,?> executable, final Class<?> arrayComponentClass) {

        final ExecutionTargetMapOperation operation =
            new ExecutionTargetMapOperation(structure, executable, arrayComponentClass);
        final ExecutionTargetOperation[][] newOperations =
            addOperation(this.operations, this.currentBlockLevel, operation);

        return new ExecutionTarget(this.initialTarget, this.initialNormalisation, this.currentBlockLevel, newOperations, this.previousBlockLevels);
        
    }



    @Override
    Target doMapIfNotNull(final Structure structure, final IFunction<?,?> executable, final Class<?> arrayComponentClass) {

        final ExecutionTargetMapIfNotNullOperation operation =
            new ExecutionTargetMapIfNotNullOperation(structure, executable, arrayComponentClass);
        final ExecutionTargetOperation[][] newOperations =
            addOperation(this.operations, this.currentBlockLevel, operation);

        return new ExecutionTarget(this.initialTarget, this.initialNormalisation, this.currentBlockLevel, newOperations, this.previousBlockLevels);
        
    }

    


    
    @Override
    public Object get() {
        return doExecute(this.initialTarget, this.initialNormalisation, this.operations);
    }
    
    
    @Override
    public Object execute(final Object executionTarget) {
        return doExecute(executionTarget, this.initialNormalisation, this.operations);
    }
    

    
    
    private static Object doExecute(final Object target, final Normalisation initialNormalisation, final ExecutionTargetOperation[][] operations) {
        Object result = normaliseTarget(target, initialNormalisation);
        final int[] indexes = new int[] { 0 };
        for (int i = 0, z = operations[0].length; i < z; i++) {
            result = operations[0][i].execute(result, operations, indexes);
        }
        return result;
    }
    
}
