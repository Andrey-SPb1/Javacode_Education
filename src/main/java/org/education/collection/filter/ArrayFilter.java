package org.education.collection.filter;

import java.util.Arrays;

public class ArrayFilter {

    public Object[] filter(Object[] array, Filter filter) {
        return Arrays.stream(array)
                .map(filter::apply)
                .toArray();
    }

}
