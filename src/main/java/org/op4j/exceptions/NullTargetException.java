package org.op4j.exceptions;

import org.apache.commons.lang.exception.NestableRuntimeException;

public class NullTargetException extends NestableRuntimeException {

    private static final long serialVersionUID = -7985452781171249347L;

    public NullTargetException(String operationName) {
        super("Cannot perform \"" + operationName + "\" operation on null target");
    }
    
}
