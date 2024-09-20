package org.education.collection.filter;

public class PrintFilter implements Filter {

    @Override
    public Object apply(Object o) {
        System.out.println(o.toString());
        return o;
    }
}
