package org.op4j.op.operators;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.op4j.op.operators");
		//$JUnit-BEGIN$
		suite.addTestSuite(Iter1IterableListOperatorTest.class);
		suite.addTestSuite(Iter0IterableMapOperatorTest.class);
		suite.addTestSuite(Iter1MapEntryOperatorTest.class);
		suite.addTestSuite(Iter0IterableListOperatorTest.class);
		suite.addTestSuite(Iter0MapEntryOperatorTest.class);
		suite.addTestSuite(Iter0IterableSetMapOperatorTest.class);
		suite.addTestSuite(Iter2GenericMultiTargetOperatorTest.class);
		suite.addTestSuite(Iter1IterableListMapOperatorTest.class);
		suite.addTestSuite(Iter0GenericUniqTargetOperatorTest.class);
		suite.addTestSuite(Iter1IterableArrayOperatorTest.class);
		suite.addTestSuite(Iter0IterableListMapOperatorTest.class);
		suite.addTestSuite(Iter1IterableMapOperatorTest.class);
		suite.addTestSuite(Iter0IterableArrayOperatorTest.class);
		suite.addTestSuite(Iter2GenericUniqTargetOperatorTest.class);
		suite.addTestSuite(Iter1IterableSetOperatorTest.class);
		suite.addTestSuite(Iter1GenericUniqTargetOperatorTest.class);
		suite.addTestSuite(Iter1GenericMultiTargetOperatorTest.class);
		suite.addTestSuite(Iter2MapEntryOperatorTest.class);
		suite.addTestSuite(Iter0IterableSetOperatorTest.class);
		suite.addTestSuite(Iter0GenericMultiTargetOperatorTest.class);
		//$JUnit-END$
		return suite;
	}

}
