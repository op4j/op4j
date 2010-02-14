package org.op4j.test.auto;

import java.beans.Expression;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.Op;
import org.op4j.exceptions.ExecutionException;
import org.op4j.functions.MathInteger;


public class Test {
	
	public <T> Object testOn(T target,
			List<TestOperation> operations) {		
			Object result = Op.on(target);
			return executeOperations(result, operations);
	}
	
	public Object testOnAll(Object[] onParams,
			List<TestOperation> operations) {		
			Object result = Op.onAll(onParams);
			return executeOperations(result, operations);
	}
	
	public <T> Object testOnArrayOf(Type<T> type, T[] target,
			List<TestOperation> operations) {		
			Object result = Op.onArrayOf(type, target);
			return executeOperations(result, operations);
	}
	
	public <T> Object testOnArrayOfArrayOf(Type<T> type, T[][] target,
			List<TestOperation> operations) {		
			Object result = Op.onArrayOfArrayOf(type, target);
			return executeOperations(result, operations);
	}
	
	public <T> Object testOnArrayOfList(List<T>[] target,
			List<TestOperation> operations) {		
			Object result = Op.onArrayOfList(target);
			return executeOperations(result, operations);
	}
    
    public <T, U> Object testOnArrayOfMap(Map<T, U>[] target,
			List<TestOperation> operations) {		
			Object result = Op.onArrayOfMap(target);
			return executeOperations(result, operations);
	}

    public <T> Object testOnArrayOfSet(Set<T>[] target,
			List<TestOperation> operations) {		
			Object result = Op.onArrayOfSet(target);
			return executeOperations(result, operations);
	}
    
    public <T> Object testOnList(List<T> target,
			List<TestOperation> operations) {		
			Object result = Op.onList(target);
			return executeOperations(result, operations);
	}
        
    public <T> Object testOnListOfArrayOf(Type<T> type, List<T[]> target,
			List<TestOperation> operations) {		
			Object result = Op.onListOfArrayOf(type, target);
			return executeOperations(result, operations);
	}
    
    public <T> Object testOnListOfList(List<? extends List<T>> target,
			List<TestOperation> operations) {		
			Object result = Op.onListOfList(target);
			return executeOperations(result, operations);
	}
    
    public <T, U> Object testOnListOfMap(List<? extends Map<T, U>> target,
			List<TestOperation> operations) {		
			Object result = Op.onListOfMap(target);
			return executeOperations(result, operations); 
	}
    
    public <T> Object testOnListOfSet(List<? extends Set<T>> target,
			List<TestOperation> operations) {		
			Object result = Op.onListOfSet(target);
			return executeOperations(result, operations); 
	}
    
    public <T, U> Object testOnMap(Map<T, U> target,
			List<TestOperation> operations) {		
			Object result = Op.onMap(target);
			return executeOperations(result, operations);
	}
    
    public <T, U> Object testOnMapOfArrayOf(Type<U> valueType, Map<T, U[]> target,
			List<TestOperation> operations) {		
			Object result = Op.onMapOfArrayOf(valueType, target);
			return executeOperations(result, operations);
	}
    
    public <T, U> Object testOnMapOfList(Map<T, ? extends List<U>> target,
			List<TestOperation> operations) {		
			Object result = Op.onMapOfList(target);
			return executeOperations(result, operations);
	}
    
    public <T, U, V> Object testOnMapOfMap(Map<T, ? extends Map<U, V>> target,
			List<TestOperation> operations) {		
			Object result = Op.onMapOfMap(target);
			return executeOperations(result, operations);
	}
    
    public <T, U> Object testOnMapOfSet(Map<T, ? extends Set<U>> target,
			List<TestOperation> operations) {		
			Object result = Op.onMapOfSet(target);
			return executeOperations(result, operations);
	}
    
    public <T> Object testOnSet(Set<T> target,
			List<TestOperation> operations) {		
			Object result = Op.onSet(target);
			return executeOperations(result, operations);
	}
    
    public <T> Object testOnSetOfArrayOf(Type<T> type, Set<T[]> target,
			List<TestOperation> operations) {		
			Object result = Op.onSetOfArrayOf(type, target);
			return executeOperations(result, operations); 
	}
    
    public <T> Object testOnSetOfList(Set<? extends List<T>> target,
			List<TestOperation> operations) {		
			Object result = Op.onSetOfList(target);
			return executeOperations(result, operations);
	}
    
    public <T, U> Object testOnSetOfMap(Set<? extends Map<T, U>> target,
			List<TestOperation> operations) {		
			Object result = Op.onSetOfMap(target);
			return executeOperations(result, operations);
	}
    
    public <T> Object testOnSetOfSet(Set<? extends Set<T>> target,
			List<TestOperation> operations) {		
			Object result = Op.onSetOfSet(target);
			return executeOperations(result, operations);
	}
    
    Object executeOperations(Object rootOperator, List<TestOperation> operations) {
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
	
	@SuppressWarnings("boxing")
	public static void main(String[] args) {
		Test test = new Test();
		
		List<Integer> listTarget = Arrays.asList(3, 4, 12, -2);
		Integer[] arrayTarget = new Integer[] {3, 4, 12, -2};
		Map<Integer, List<String>> mapTarget = new LinkedHashMap<Integer, List<String>>();
		mapTarget.put(2, Arrays.asList("first"));
		mapTarget.put(22, Arrays.asList("second"));
		mapTarget.put(222, Arrays.asList("third"));
		mapTarget.put(2222, Arrays.asList("first", "second", "third"));
		
		List<TestOperation> operations = new ArrayList<TestOperation>();
		operations.add(new TestOperation("forEach", new Object[] {}));
		operations.add(new TestOperation("exec", new Object[] {MathInteger.add(45)}));
		operations.add(new TestOperation("get", new Object[] {}));
		
		Object result = test.testOnList(listTarget, operations);
		System.out.println("Result onList: " + result);
		
		result = test.testOnArrayOf(Types.INTEGER, arrayTarget, operations);
		System.out.println("Result onArray: " + Arrays.toString((Integer[])result));
		
		operations.clear();
		operations.add(new TestOperation("forEachEntry"));
		operations.add(new TestOperation("onKey"));
		operations.add(new TestOperation("exec", new Object[] {MathInteger.add(3)}));
		operations.add(new TestOperation("endOn"));
		operations.add(new TestOperation("onValue"));
		operations.add(new TestOperation("add", new Object[] {"another"}));
		operations.add(new TestOperation("get"));
		result = test.testOnMapOfList(mapTarget, operations);
		System.out.println("Result onMapOfList: " + result);
	}
	
}
