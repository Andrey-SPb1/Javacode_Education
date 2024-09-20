package org.education.collection.countofelements;

import java.util.HashMap;

public class ArrayToMapMapper {

    public static <T> HashMap<T, Integer> map(T[] array) {
        HashMap<T, Integer> map = new HashMap<>(array.length);
        for (T t : array) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return map;
    }

}
