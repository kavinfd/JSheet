package com.jsheet.helper;

import com.codepoetics.protonpack.StreamUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.String.format;

/**
 * Created by kavin on 22/07/17.
 */
public class A1Notation {
    private static Integer getOrdinal(Character character) {
        if ('A' <= character.charValue() && 'Z' >= character.charValue()) {
            return character.charValue() - 'A' + 1;
        }
        throw new RuntimeException(format("Character `%s` not in range", character));
    }

    public static Integer getNumber(String a1Notation) {
        List<Character> characters = new ArrayList<>(Arrays.asList(a1Notation.chars().mapToObj(c -> (char) c).toArray(Character[]::new)));
        Collections.reverse(characters);
        return StreamUtils.zip(
                characters.stream().map(A1Notation::getOrdinal),
                IntStream.iterate(0, x -> x + 1).map(x -> (int) Math.pow(26, x)).mapToObj(Integer::new),
                (x, y) -> x * y).mapToInt(Integer::intValue).sum();
    }

    public static String getAlphaNotation(Integer value) {
        if (value < 1) {
            throw new RuntimeException("Alpha notation value must be greater than or equal to 1");
        }
        String memo = "ZABCDEFGHIJKLMNOPQRSTUVWXY";
        String result = "";
        while (value > 0) {
            Integer index = value % 26;
            result = memo.charAt(index) + result;
            value--;
            value /= 26;
        }
        return result;
    }

    public static Stream<String> getAlphaRange(String rowRange) {
        Integer[] result = getRowRange(rowRange);
        Integer start = result[0];
        Integer end = result[1];
        return StreamUtils
                .takeWhile(Stream
                        .iterate(start, i -> i + 1), i -> i <= end)
                .map(A1Notation::getAlphaNotation);
    }

    public static void assertTrue(Boolean condition, String msg) {
        if (!condition) {
            throw new RuntimeException(msg);
        }
    }

    private static Integer[] getRowRange(String rowRange) {
        String[] range = rowRange.split(":");
        assertTrue(range.length == 2, format("Invalid Row range. %s should be limited to only two column like \"A:BS\"", rowRange));
        Integer first = getNumber(range[0]);
        Integer second = getNumber(range[1]);
        assertTrue(first <= second, format("Row range \"%s\" should be in incremental order", rowRange));
        return Arrays.asList(first, second).toArray(new Integer[0]);
    }
}
