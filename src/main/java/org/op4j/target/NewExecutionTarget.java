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

import org.op4j.functions.IFunction;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.util.NormalisationUtils;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class NewExecutionTarget extends Target {


    
    private final Object target;
    
    private int currentBlockLevel;
    
    private final NewExecutionTargetOperation[][] operations;
    private final int[] previousBlockLevels;
    
    
    
    
    @SuppressWarnings("unchecked")
    public static NewExecutionTarget forObject(final Object object, final Normalisation targetNormalisation) {
        Object normalisedObject = null;
        switch (targetNormalisation) {
            case NONE:
                normalisedObject = object;
                break;
            case ARRAY:
                normalisedObject = NormalisationUtils.normaliseArray((Object[])object);
                break;
            case ARRAY_OF_ARRAY:
                normalisedObject = NormalisationUtils.normaliseArrayOfArray((Object[][])object);
                break;
            case ARRAY_OF_LIST:
                normalisedObject = NormalisationUtils.normaliseArrayOfList((List<Object>[])object);
                break;
            case ARRAY_OF_MAP:
                normalisedObject = NormalisationUtils.normaliseArrayOfMap((Map<Object,Object>[])object);
                break;
            case ARRAY_OF_SET:
                normalisedObject = NormalisationUtils.normaliseArrayOfSet((Set<Object>[])object);
                break;
            case LIST:
                normalisedObject = NormalisationUtils.normaliseList((List<Object>)object);
                break;
            case LIST_OF_ARRAY:
                normalisedObject = NormalisationUtils.normaliseListOfArray((List<Object[]>)object);
                break;
            case LIST_OF_LIST:
                normalisedObject = NormalisationUtils.normaliseListOfList((List<List<Object>>)object);
                break;
            case LIST_OF_MAP:
                normalisedObject = NormalisationUtils.normaliseListOfMap((List<Map<Object,Object>>)object);
                break;
            case LIST_OF_SET:
                normalisedObject = NormalisationUtils.normaliseListOfSet((List<Set<Object>>)object);
                break;
            case MAP:
                normalisedObject = NormalisationUtils.normaliseMap((Map<Object,Object>)object);
                break;
            case MAPENTRY:
                normalisedObject = NormalisationUtils.normaliseMapEntry((Map.Entry<Object,Object>)object);
                break;
            case MAPENTRY_OF_ARRAY:
                normalisedObject = NormalisationUtils.normaliseMapEntryOfArray((Map.Entry<Object,Object[]>)object);
                break;
            case MAPENTRY_OF_LIST:
                normalisedObject = NormalisationUtils.normaliseMapEntryOfList((Map.Entry<Object,List<Object>>)object);
                break;
            case MAPENTRY_OF_MAP:
                normalisedObject = NormalisationUtils.normaliseMapEntryOfMap((Map.Entry<Object,Map<Object,Object>>)object);
                break;
            case MAPENTRY_OF_SET:
                normalisedObject = NormalisationUtils.normaliseMapEntryOfSet((Map.Entry<Object,Set<Object>>)object);
                break;
            case MAP_OF_ARRAY:
                normalisedObject = NormalisationUtils.normaliseMapOfArray((Map<Object,Object[]>)object);
                break;
            case MAP_OF_LIST:
                normalisedObject = NormalisationUtils.normaliseMapOfList((Map<Object,List<Object>>)object);
                break;
            case MAP_OF_MAP:
                normalisedObject = NormalisationUtils.normaliseMapOfMap((Map<Object,Map<Object,Object>>)object);
                break;
            case MAP_OF_SET:
                normalisedObject = NormalisationUtils.normaliseMapOfSet((Map<Object,Set<Object>>)object);
                break;
            case SET:
                normalisedObject = NormalisationUtils.normaliseSet((Set<Object>)object);
                break;
            case SET_OF_ARRAY:
                normalisedObject = NormalisationUtils.normaliseSetOfArray((Set<Object[]>)object);
                break;
            case SET_OF_LIST:
                normalisedObject = NormalisationUtils.normaliseSetOfList((Set<List<Object>>)object);
                break;
            case SET_OF_MAP:
                normalisedObject = NormalisationUtils.normaliseSetOfMap((Set<Map<Object,Object>>)object);
                break;
            case SET_OF_SET:
                normalisedObject = NormalisationUtils.normaliseSetOfSet((Set<Set<Object>>)object);
                break;
        }
        
        final NewExecutionTargetOperation[][] newOperations = 
            (NewExecutionTargetOperation[][]) Array.newInstance(NewExecutionTargetOperation[].class, 1);
        newOperations[0] = new NewExecutionTargetOperation[0];
        
        final int[] newPreviousBlockLevels = new int[] { -1 };
        
        return new NewExecutionTarget(normalisedObject, 0, newOperations, newPreviousBlockLevels);
        
    }
    
    
    
    private static NewExecutionTargetOperation[][] cloneOperations(final NewExecutionTargetOperation[][] operations) {

        final NewExecutionTargetOperation[][] newOperations = new NewExecutionTargetOperation[operations.length][];
        for (int i = 0, z = operations.length; i < z; i++) {
            newOperations[i] = operations[i].clone();
        }
        return newOperations;
        
    }
    
    
    
    private static NewExecutionTargetOperation[][] addOperation(
            final NewExecutionTargetOperation[][] operations, 
            final int currentBlockLevel, 
            final NewExecutionTargetOperation operation) {
        
        final NewExecutionTargetOperation[][] newOperations = new NewExecutionTargetOperation[operations.length][];
        for (int i = 0, z = operations.length; i < z; i++) {
            if (i == currentBlockLevel) {
                newOperations[i] =
                    new NewExecutionTargetOperation[operations[i].length + 1];
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

    
    private static NewExecutionTargetOperation[][] addOperationAndBlockLevel(
            final NewExecutionTargetOperation[][] operations, 
            final int currentBlockLevel,
            final NewExecutionTargetOperation operation) {
        
        final NewExecutionTargetOperation[][] newOperations = new NewExecutionTargetOperation[operations.length + 1][];
        for (int i = 0, z = operations.length; i < z; i++) {
            if (i == currentBlockLevel) {
                newOperations[i] =
                    new NewExecutionTargetOperation[operations[i].length + 1];
                for (int j = 0, y = operations[i].length; j < y; j++) {
                    newOperations[i][j] = operations[i][j];
                }
                newOperations[i][operations[i].length] = operation;
            } else {
                newOperations[i] = operations[i].clone();
            }
        }
        newOperations[operations.length] = new NewExecutionTargetOperation[0];
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
    
    
    
    
    
    protected NewExecutionTarget(final Object target,
            final int currentBlockLevel,
            final NewExecutionTargetOperation[][] operations,
            final int[] previousBlockLevels) {
        
        super();
        
        this.target = target;
        this.currentBlockLevel = currentBlockLevel;
        this.operations = operations;
        this.previousBlockLevels = previousBlockLevels;
        
    }
    
    

    
    @Override
    Target doEndIterate(final Structure structure, final Class<?> componentClass) {
            
        final int previousBlockLevel = this.previousBlockLevels[this.currentBlockLevel];
        final NewExecutionTargetOperation[][] newOperations = cloneOperations(this.operations);
        final int previousBlockSize = newOperations[previousBlockLevel].length;
        final NewExecutionTargetIterateOpenOperation iterateOpenOperation =
            (NewExecutionTargetIterateOpenOperation) newOperations[previousBlockLevel][previousBlockSize - 1];
        newOperations[previousBlockLevel][previousBlockSize - 1] =
            iterateOpenOperation.close(componentClass);
            
        return new NewExecutionTarget(this.target, previousBlockLevel, newOperations, this.previousBlockLevels);
        
    }



    @Override
    Target doEndOn() {
        
        final int previousBlockLevel = this.previousBlockLevels[this.currentBlockLevel];
        final NewExecutionTargetOperation[][] newOperations = cloneOperations(this.operations);
            
        return new NewExecutionTarget(this.target, previousBlockLevel, newOperations, this.previousBlockLevels);
        
    }



    @Override
    Target doEndSelect() {
        
        final int previousBlockLevel = this.previousBlockLevels[this.currentBlockLevel];
        final NewExecutionTargetOperation[][] newOperations = cloneOperations(this.operations);
            
        return new NewExecutionTarget(this.target, previousBlockLevel, newOperations, this.previousBlockLevels);
        
    }

    


    @Override
    Target doExecute(final IFunction<?, ?> executable, final Normalisation normalisation) {

        final NewExecutionTargetExecuteOperation operation =
            new NewExecutionTargetExecuteOperation(executable, normalisation);
        final NewExecutionTargetOperation[][] newOperations =
            addOperation(this.operations, this.currentBlockLevel, operation);

        return new NewExecutionTarget(this.target, this.currentBlockLevel, newOperations, this.previousBlockLevels);
        
    }



    @Override
    Target doIterate() {

        final int newBlockLevel = this.operations.length;
        final NewExecutionTargetIterateOpenOperation operation =
            new NewExecutionTargetIterateOpenOperation(newBlockLevel);
        final NewExecutionTargetOperation[][] newOperations =
            addOperationAndBlockLevel(this.operations, this.currentBlockLevel, operation);
        final int[] newPreviousBlockLevels = 
            addPreviousBlockLevelRelation(this.previousBlockLevels, this.currentBlockLevel);
            
        return new NewExecutionTarget(this.target, newBlockLevel, newOperations, newPreviousBlockLevels);
        
    }



    @Override
    Target doOnKey() {

        final int newBlockLevel = this.operations.length;
        final NewExecutionTargetOnKeyOperation operation =
            new NewExecutionTargetOnKeyOperation(newBlockLevel);
        final NewExecutionTargetOperation[][] newOperations =
            addOperationAndBlockLevel(this.operations, this.currentBlockLevel, operation);
        final int[] newPreviousBlockLevels = 
            addPreviousBlockLevelRelation(this.previousBlockLevels, this.currentBlockLevel);
            
        return new NewExecutionTarget(this.target, newBlockLevel, newOperations, newPreviousBlockLevels);
        
    }



    @Override
    Target doOnValue() {

        final int newBlockLevel = this.operations.length;
        final NewExecutionTargetOnValueOperation operation =
            new NewExecutionTargetOnValueOperation(newBlockLevel);
        final NewExecutionTargetOperation[][] newOperations =
            addOperationAndBlockLevel(this.operations, this.currentBlockLevel, operation);
        final int[] newPreviousBlockLevels = 
            addPreviousBlockLevelRelation(this.previousBlockLevels, this.currentBlockLevel);
            
        return new NewExecutionTarget(this.target, newBlockLevel, newOperations, newPreviousBlockLevels);
        
    }



    @Override
    Target doReplaceWith(final Object replacement) {

        final NewExecutionTargetReplaceWithOperation operation =
            new NewExecutionTargetReplaceWithOperation(replacement);
        final NewExecutionTargetOperation[][] newOperations =
            addOperation(this.operations, this.currentBlockLevel, operation);

        return new NewExecutionTarget(this.target, this.currentBlockLevel, newOperations, this.previousBlockLevels);

    }

    
    

    @Override
    Target doSelectIndex(final boolean desiredResult, final List<Integer> positions) {

        final int newBlockLevel = this.operations.length;
        final NewExecutionTargetSelectIndexOperation operation =
            new NewExecutionTargetSelectIndexOperation(newBlockLevel, desiredResult, positions);
        final NewExecutionTargetOperation[][] newOperations =
            addOperationAndBlockLevel(this.operations, this.currentBlockLevel, operation);
        final int[] newPreviousBlockLevels = 
            addPreviousBlockLevelRelation(this.previousBlockLevels, this.currentBlockLevel);
            
        return new NewExecutionTarget(this.target, newBlockLevel, newOperations, newPreviousBlockLevels);
        
    }



    @Override
    Target doSelectMapKeys(final boolean desiredResult, final List<Object> objects) {

        final int newBlockLevel = this.operations.length;
        final NewExecutionTargetSelectMapKeysOperation operation =
            new NewExecutionTargetSelectMapKeysOperation(newBlockLevel, desiredResult, objects);
        final NewExecutionTargetOperation[][] newOperations =
            addOperationAndBlockLevel(this.operations, this.currentBlockLevel, operation);
        final int[] newPreviousBlockLevels = 
            addPreviousBlockLevelRelation(this.previousBlockLevels, this.currentBlockLevel);
            
        return new NewExecutionTarget(this.target, newBlockLevel, newOperations, newPreviousBlockLevels);
        
    }



    @Override
    Target doSelectMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval) {

        final int newBlockLevel = this.operations.length;
        final NewExecutionTargetSelectMatchingOperation operation =
            new NewExecutionTargetSelectMatchingOperation(newBlockLevel, desiredResult, eval);
        final NewExecutionTargetOperation[][] newOperations =
            addOperationAndBlockLevel(this.operations, this.currentBlockLevel, operation);
        final int[] newPreviousBlockLevels = 
            addPreviousBlockLevelRelation(this.previousBlockLevels, this.currentBlockLevel);
            
        return new NewExecutionTarget(this.target, newBlockLevel, newOperations, newPreviousBlockLevels);
        
    }



    @Override
    Target doSelectNotNullAndMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval) {

        final int newBlockLevel = this.operations.length;
        final NewExecutionTargetSelectNotNullAndMatchingOperation operation =
            new NewExecutionTargetSelectNotNullAndMatchingOperation(newBlockLevel, desiredResult, eval);
        final NewExecutionTargetOperation[][] newOperations =
            addOperationAndBlockLevel(this.operations, this.currentBlockLevel, operation);
        final int[] newPreviousBlockLevels = 
            addPreviousBlockLevelRelation(this.previousBlockLevels, this.currentBlockLevel);
            
        return new NewExecutionTarget(this.target, newBlockLevel, newOperations, newPreviousBlockLevels);
        
    }



    @Override
    Target doSelectNull(final boolean desiredResult) {

        final int newBlockLevel = this.operations.length;
        final NewExecutionTargetSelectNullOperation operation =
            new NewExecutionTargetSelectNullOperation(newBlockLevel, desiredResult);
        final NewExecutionTargetOperation[][] newOperations =
            addOperationAndBlockLevel(this.operations, this.currentBlockLevel, operation);
        final int[] newPreviousBlockLevels = 
            addPreviousBlockLevelRelation(this.previousBlockLevels, this.currentBlockLevel);
            
        return new NewExecutionTarget(this.target, newBlockLevel, newOperations, newPreviousBlockLevels);
        
    }



    @Override
    Target doSelectNullOrMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval) {

        final int newBlockLevel = this.operations.length;
        final NewExecutionTargetSelectNullOrMatchingOperation operation =
            new NewExecutionTargetSelectNullOrMatchingOperation(newBlockLevel, desiredResult, eval);
        final NewExecutionTargetOperation[][] newOperations =
            addOperationAndBlockLevel(this.operations, this.currentBlockLevel, operation);
        final int[] newPreviousBlockLevels = 
            addPreviousBlockLevelRelation(this.previousBlockLevels, this.currentBlockLevel);
            
        return new NewExecutionTarget(this.target, newBlockLevel, newOperations, newPreviousBlockLevels);
        
    }


    
    @Override
    public Object get() {
        
        Object result = this.target;
        final int[] indices = new int[] { 0 };
        for (int i = 0, z = this.operations[0].length; i < z; i++) {
            result = this.operations[0][i].execute(result, this.operations, indices);
        }
        return result;
            
    }

    
    
}
