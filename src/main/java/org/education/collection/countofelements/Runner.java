package org.education.collection.countofelements;

import java.util.HashMap;

public class Runner {

    public static void main(String[] args) {

        Integer[] integers = new Integer[]{1, 2, 2, 4, 5, 5, 5, 8, 9, 9};

        HashMap<Object, Integer> map = ArrayToMapMapper.map(integers);
        //{1=1, 2=2, 4=1, 5=3, 8=1, 9=2}
        System.out.println(map);
    }
}
