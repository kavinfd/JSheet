package com.jsheet.helper;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by kavin on 22/07/17.
 */
public class A1NotationTest {

    @Test
    public void testGetNumber() throws Exception {
        assertThat(A1Notation.getNumber("A")).isEqualTo(1);
        assertThat(A1Notation.getNumber("Z")).isEqualTo(26);
        assertThat(A1Notation.getNumber("AA")).isEqualTo(27);
        assertThat(A1Notation.getNumber("AZ")).isEqualTo(52);
    }

    @Test
    public void testGetAlphaNotation() throws Exception {
        assertThat(A1Notation.getAlphaNotation(10)).isEqualTo("J");
        assertThat(A1Notation.getAlphaNotation(12)).isEqualTo("L");
        assertThat(A1Notation.getAlphaNotation(52)).isEqualTo("AZ");
    }

    @Test
    public void testGetAlphaNotationAndGetNumber() throws Exception {
        assertThat(A1Notation.getNumber(A1Notation.getAlphaNotation(1123))).isEqualTo(1123);
        assertThat(A1Notation.getNumber(A1Notation.getAlphaNotation(2144))).isEqualTo(2144);
        assertThat(A1Notation.getNumber(A1Notation.getAlphaNotation(10324))).isEqualTo(10324);
        assertThat(A1Notation.getNumber(A1Notation.getAlphaNotation(12340))).isEqualTo(12340);
    }

    @Test
    public void testGetAlphaRange() throws Exception {
        List<String> alphaRange = A1Notation.getAlphaRange("A:AB").collect(Collectors.toList());
        assertThat(alphaRange).containsOnly("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "AA", "AB");
        alphaRange = A1Notation.getAlphaRange("Z:Z").collect(Collectors.toList());
        assertThat(alphaRange).containsOnly("Z");
        alphaRange = A1Notation.getAlphaRange("T:Z").collect(Collectors.toList());
        assertThat(alphaRange).containsOnly("T", "U", "V", "W", "X", "Y", "Z");
    }
}