package com.jsheet.util;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

/**
 * Created by kavin on 20/09/17.
 */
public class ConstraintUtilTest {
    @Test
    public void assertUnique() throws Exception {
        assertThatThrownBy(()->ConstraintUtil.assertUnique(Arrays.asList(2,5,2,4,5,5,7,7), "fails"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("fails : [2, 5, 7]");
        ConstraintUtil.assertUnique(Arrays.asList(1,2,3,4,5,6,7,8), "passes");
    }

}