package org.education.collection.filter;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
        ArrayFilter arrayFilter = new ArrayFilter();

        Object[] objects = arrayFilter.filter(new Integer[]{1,2,3,4,5}, new PrintFilter());
        System.out.println(Arrays.toString(objects));
    }
}
