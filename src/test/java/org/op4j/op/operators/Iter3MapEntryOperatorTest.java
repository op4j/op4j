package org.op4j.op.operators;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.op4j.op.Op;
import org.op4j.op.interfaces.EvalContext;
import org.op4j.op.interfaces.Evaluator;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;
import org.op4j.util.UniqResultConverterUtils;

public class Iter3MapEntryOperatorTest extends TestCase {

	Map.Entry<Integer, String> integerStringMapEntry;
	Iter3MapEntryOperator<Integer, String> integerStringOperator;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		HashMap<Integer, String> integerStringMap = new HashMap<Integer, String>();
		
		integerStringMap.put(Integer.valueOf(10), "false");
		this.integerStringMapEntry = integerStringMap.entrySet().iterator().next();
		
		this.integerStringOperator = Op.onMap(Integer.class, String.class, integerStringMap).eachEntry()
			.generic().buildList().each().buildList().each().asMapEntry(Integer.class, String.class);
		
		
	}

	public final void testExecUniqOnValueClassOfXStringObjectArray() {
		assertEquals(Boolean.FALSE, this.integerStringOperator
				.execUniqOnValue(Boolean.class, UniqResultConverterUtils.unsafeGetOperationNameForResultType(Types.BOOLEAN))
				.getTargets().get(0).getTargets().get(0).getTargets().get(0).get().getValue());
		assertEquals(TypeSchemes.forName("Map$Entry<Integer, Boolean>"),
				this.integerStringOperator
				.execUniqOnValue(Boolean.class, UniqResultConverterUtils.unsafeGetOperationNameForResultType(Types.BOOLEAN))
				.getTargets().get(0).getTargets().get(0).getTargets().get(0).getTargetTypeScheme());
		assertEquals(Types.INTEGER,
				this.integerStringOperator
				.execUniqOnValue(Boolean.class, UniqResultConverterUtils.unsafeGetOperationNameForResultType(Types.BOOLEAN))
				.getTargets().get(0).getTargets().get(0).getTargets().get(0).getOperatorKeyType());
		assertEquals(Types.BOOLEAN,
				this.integerStringOperator
				.execUniqOnValue(Boolean.class, UniqResultConverterUtils.unsafeGetOperationNameForResultType(Types.BOOLEAN))
				.getTargets().get(0).getTargets().get(0).getTargets().get(0).getOperatorValueType());
	}

	public final void testCastMapEntryStringString() {
		assertEquals(Types.INTEGER, this.integerStringOperator
				.castMapEntry(Types.INTEGER.getName(), Types.STRING.getName()).getOperatorKeyType());
		
		try {
			this.integerStringOperator.castMapEntry(Types.OBJECT.getName(), Types.INTEGER.getName());
			fail("castMapEntry(Types.OBJECT.getName(), Types.INTEGER.getName()) should have failed due to wrong types");
		} catch (IllegalArgumentException e) {
			// do nothing
		}
	}

	public final void testEvalOnValueEvaluatorOfVObject() {
		Evaluator<String, Object> evaluator = new Evaluator<String, Object>() {
			public Object evaluate(EvalContext<String> ctx) {
				return ctx.getTarget(0).equals("XYZ");
			}			
		};
		assertEquals(Boolean.FALSE, this.integerStringOperator
				.evalOnValue(evaluator)
				.getTargets().get(0).getTargets().get(0).getTargets().get(0).get().getValue());
		assertEquals(TypeSchemes.forName("Map$Entry<Integer, ?>"),
				this.integerStringOperator
				.evalOnValue(evaluator)
				.getTargets().get(0).getTargets().get(0).getTargets().get(0).getTargetTypeScheme());
		assertEquals(Types.INTEGER,
				this.integerStringOperator
				.evalOnValue(evaluator)
				.getTargets().get(0).getTargets().get(0).getTargets().get(0).getOperatorKeyType());
		assertEquals(null,
				this.integerStringOperator
				.evalOnValue(evaluator)
				.getTargets().get(0).getTargets().get(0).getTargets().get(0).getOperatorValueType());
	}

	public final void testCallOnValueClassOfXStringObjectArray() {
		
		assertEquals(Boolean.FALSE, this.integerStringOperator
				.callOnValue(Boolean.class, "equals", "XYZ")
				.getTargets().get(0).getTargets().get(0).getTargets().get(0).get().getValue());
		assertEquals(TypeSchemes.forName("Map$Entry<Integer, Boolean>"),
				this.integerStringOperator
				.callOnValue(Boolean.class, "equals", "XYZ")
				.getTargets().get(0).getTargets().get(0).getTargets().get(0).getTargetTypeScheme());
		assertEquals(Types.INTEGER,
				this.integerStringOperator
				.callOnValue(Boolean.class, "equals", "XYZ")
				.getTargets().get(0).getTargets().get(0).getTargets().get(0).getOperatorKeyType());
		assertEquals(Types.BOOLEAN,
				this.integerStringOperator
				.callOnValue(Boolean.class, "equals", "XYZ")
				.getTargets().get(0).getTargets().get(0).getTargets().get(0).getOperatorValueType());
	}

}
