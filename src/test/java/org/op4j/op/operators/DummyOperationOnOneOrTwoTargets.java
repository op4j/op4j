package org.op4j.op.operators;

import java.util.LinkedHashSet;
import java.util.Set;

import org.op4j.operation.Arguments;
import org.op4j.operation.ArgumentsTypeScheme;
import org.op4j.operation.OperationImpl;
import org.op4j.operation.Result;
import org.op4j.typescheme.TypeScheme;
import org.op4j.typescheme.TypeSchemes;

public class DummyOperationOnOneOrTwoTargets extends OperationImpl {

    
    public static final String OPERATION_NAME = "dummyOperationOnTwoTargets";
        
    private final static ArgumentsTypeScheme ATS_DUMMY_ONE = 
        new ArgumentsTypeScheme(
            TypeSchemes.forClasses(Object.class), 
            TypeSchemes.EMPTY_TYPESCHEME,            
                "DummyOperationOnTwoTargets");  
    
    private final static ArgumentsTypeScheme ATS_DUMMY_TWO = 
        new ArgumentsTypeScheme(
            TypeSchemes.forClasses(Object.class, Object.class), 
            TypeSchemes.EMPTY_TYPESCHEME,            
                "DummyOperationOnTwoTargets");  
    
    public DummyOperationOnOneOrTwoTargets() {
        super();
    }

    @Override
    protected Set<ArgumentsTypeScheme> registerMatchedArgumentTypeSchemes() {
        final Set<ArgumentsTypeScheme> matched = new LinkedHashSet<ArgumentsTypeScheme>();
        matched.add(ATS_DUMMY_ONE);
        matched.add(ATS_DUMMY_TWO);
        return matched;
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public Result doExecute(final Arguments arguments) throws Exception {
        
        if (arguments.areAllTargetsNull()) {
        	return createUniqResult((Object[])null);
        }
        
        if (ATS_DUMMY_ONE.matches(arguments)) {       	
        	return createUniqResult("Dummy operation result: 1");
        }
        
        if (ATS_DUMMY_TWO.matches(arguments)) {       	
        	return createUniqResult("Dummy operation result: 2");
        }
        
        return null;        
    }

    @Override
    public String getOperationName() {
        return OPERATION_NAME;
    }

    @Override
    public TypeScheme registerResultTypeScheme() {
        return TypeSchemes.STRING_TYPESCHEME;
    }    	    
}	
