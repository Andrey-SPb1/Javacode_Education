package org.education.collection.filter;

import java.util.Arrays;
import java.util.Objects;

public class Runner {

    public static void main(String[] args) {
        ArrayFilter arrayFilter = new ArrayFilter();

        Object[] objects = arrayFilter.filter(new Integer[]{1, null, 3, null, 5}, Objects::nonNull);
        System.out.println(Arrays.toString(objects));
    }
}
