package com.jsheet.helper;

import com.codepoetics.protonpack.StreamUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by kavin on 22/07/17.
 */
public class A1Notation {
    public Integer getOrdinal(Character character) {
        if ('A' <= character.charValue() && 'Z' >= character.charValue()) {
            return character.charValue() - 'A' + 1;
        }
        throw new RuntimeException(String.format("Character `%s` not in range", character));
    }

    public Integer getNumber(String a1Notation) {
        List<Character> characters = new ArrayList<>(Arrays.asList(a1Notation.chars().mapToObj(c -> (char) c).toArray(Character[]::new)));
        Collections.reverse(characters);
        return StreamUtils.zip(
                characters.stream().map(this::getOrdinal),
                IntStream.iterate(0, x -> x+1).map(x -> (int)Math.pow(26, x)).mapToObj(Integer::new),
                (x, y) -> x * y).mapToInt(Integer::intValue).sum();
    }
}
