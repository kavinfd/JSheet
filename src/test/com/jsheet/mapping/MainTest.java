package com.jsheet.mapping;

import com.jsheet.parser.sheet1;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kavin on 19/07/17.
 */
public class MainTest {
    @Test
    public void testMain() throws Exception {
        Main m = new Main(sheet1.class);
    }
}