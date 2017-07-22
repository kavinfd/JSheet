package com.jsheet.helper;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


/**
 * Created by kavin on 22/07/17.
 */
public class A1NotationTest {
    @Test
    public void testGetNumber() throws Exception {
        A1Notation a1Notation = new A1Notation();
        assertThat(a1Notation.getNumber("A")).isEqualTo(1);
        assertThat(a1Notation.getNumber("Z")).isEqualTo(26);
        assertThat(a1Notation.getNumber("AA")).isEqualTo(27);
        assertThat(a1Notation.getNumber("AZ")).isEqualTo(52);
    }
}