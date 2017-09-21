package com.jsheet.util;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by kavin on 20/09/17.
 */
public class ConstraintUtil {
    public static <T> void assertUnique(List<T> input, String failureMessage) {
        /// non null elements are filtered since nullable itself is a constraint
        List<T> repeatingElements = input.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() != 1).map(Map.Entry::getKey)
                .collect(Collectors.toList());
        if (!repeatingElements.isEmpty()) {
            throw new RuntimeException(failureMessage + " : " + repeatingElements.toString());
        }
    }
}
