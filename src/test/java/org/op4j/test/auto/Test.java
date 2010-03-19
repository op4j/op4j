package org.op4j.test.auto;

import java.beans.Expression;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.junit.Ignore;
import org.op4j.Op;
import org.op4j.exceptions.ExecutionException;

@Ignore
public class Test {
	
	public static final <T> Object testOn(T target,
			List<TestOperation> operations) {		
			Object result = Op.on(target);
			return executeOperations(result, operations);
	}
	
//	public static final Object testOnAll(Object[] onParams,
//			List<TestOperation> operations) {		
//			Object result = Op.onAll(onParams);
//			return executeOperations(result, operations);
//	}
	
	public static final <T> Object testOnArrayOf(Type<T> type, T[] target,
			List<TestOperation> operations) {		
			Object result = Op.onArrayOf(type, target);
			return executeOperations(result, operations);
	}
//	
//	public static final <T> Object testOnArrayOfArrayOf(Type<T> type, T[][] target,
//			List<TestOperation> operations) {		
//			Object result = Op.onArrayOfArrayOf(type, target);
//			return executeOperations(result, operations);
//	}
//	
//	public static final <T> Object testOnArrayOfList(List<T>[] target,
//			List<TestOperation> operations) {		
//			Object result = Op.onArrayOfList(target);
//			return executeOperations(result, operations);
//	}
//    
//    public static final <T, U> Object testOnArrayOfMap(Map<T, U>[] target,
//			List<TestOperation> operations) {		
//			Object result = Op.onArrayOfMap(target);
//			return executeOperations(result, operations);
//	}
//
//    public static final <T> Object testOnArrayOfSet(Set<T>[] target,
//			List<TestOperation> operations) {		
//			Object result = Op.onArrayOfSet(target);
//			return executeOperations(result, operations);
//	}
    
    public static final <T> Object testOnList(List<T> target,
			List<TestOperation> operations) {		
			Object result = Op.onList(target);
			return executeOperations(result, operations);
	}
//        
//    public static final <T> Object testOnListOfArrayOf(Type<T> type, List<T[]> target,
//			List<TestOperation> operations) {		
//			Object result = Op.onListOfArrayOf(type, target);
//			return executeOperations(result, operations);
//	}
//    
//    public static final <T> Object testOnListOfList(List<? extends List<T>> target,
//			List<TestOperation> operations) {		
//			Object result = Op.onListOfList(target);
//			return executeOperations(result, operations);
//	}
//    
//    public static final <T, U> Object testOnListOfMap(List<? extends Map<T, U>> target,
//			List<TestOperation> operations) {		
//			Object result = Op.onListOfMap(target);
//			return executeOperations(result, operations); 
//	}
//    
//    public static final <T> Object testOnListOfSet(List<? extends Set<T>> target,
//			List<TestOperation> operations) {		
//			Object result = Op.onListOfSet(target);
//			return executeOperations(result, operations); 
//	}
    
    public static final <T, U> Object testOnMap(Map<T, U> target,
			List<TestOperation> operations) {		
			Object result = Op.onMap(target);
			return executeOperations(result, operations);
	}
    
//    public static final <T, U> Object testOnMapOfArrayOf(Type<U> valueType, Map<T, U[]> target,
//			List<TestOperation> operations) {		
//			Object result = Op.onMapOfArrayOf(valueType, target);
//			return executeOperations(result, operations);
//	}
//    
//    public static final <T, U> Object testOnMapOfList(Map<T, ? extends List<U>> target,
//			List<TestOperation> operations) {		
//			Object result = Op.onMapOfList(target);
//			return executeOperations(result, operations);
//	}
//    
//    public static final <T, U, V> Object testOnMapOfMap(Map<T, ? extends Map<U, V>> target,
//			List<TestOperation> operations) {		
//			Object result = Op.onMapOfMap(target);
//			return executeOperations(result, operations);
//	}
//    
//    public static final <T, U> Object testOnMapOfSet(Map<T, ? extends Set<U>> target,
//			List<TestOperation> operations) {		
//			Object result = Op.onMapOfSet(target);
//			return executeOperations(result, operations);
//	}
    
    public static final <T> Object testOnSet(Set<T> target,
			List<TestOperation> operations) {		
			Object result = Op.onSet(target);
			return executeOperations(result, operations);
	}
//    
//    public static final <T> Object testOnSetOfArrayOf(Type<T> type, Set<T[]> target,
//			List<TestOperation> operations) {		
//			Object result = Op.onSetOfArrayOf(type, target);
//			return executeOperations(result, operations); 
//	}
//    
//    public static final <T> Object testOnSetOfList(Set<? extends List<T>> target,
//			List<TestOperation> operations) {		
//			Object result = Op.onSetOfList(target);
//			return executeOperations(result, operations);
//	}
//    
//    public static final <T, U> Object testOnSetOfMap(Set<? extends Map<T, U>> target,
//			List<TestOperation> operations) {		
//			Object result = Op.onSetOfMap(target);
//			return executeOperations(result, operations);
//	}
//    
//    public static final <T> Object testOnSetOfSet(Set<? extends Set<T>> target,
//			List<TestOperation> operations) {		
//			Object result = Op.onSetOfSet(target);
//			return executeOperations(result, operations);
//	}
    
    static final Object executeOperations(Object rootOperator, List<TestOperation> operations) {
    	try {
    		Object result = rootOperator;
			for (TestOperation operation : operations) {				
				if (operation.getParams() == null || operation.getParams().length == 0) {
					result = new Expression(result, operation.getMethodName(), null).getValue();									
				} else {
					result = new Expression(result, operation.getMethodName(), operation.getParams()).getValue();
				}				
			}	
			return result;
		} catch (Exception e) {
			throw new ExecutionException("Error executing op4j chained operations" ,e);
		} 
    }	
}
