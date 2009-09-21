package org.op4j.type.testtypes;


@SuppressWarnings("unchecked")
public class TestType <Z,Y extends Number&Comparable<Float>,X extends Z> extends TestParentType<Y>
        implements Comparable {


    private static final long serialVersionUID = 5957929133996499746L;


    public TestType() {
        super();
    }


    public int compareTo(Object o) {
        return 0;
    }
    
}
