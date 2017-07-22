package com.jsheet.parser;

import com.jsheet.annotations.Column;
import com.jsheet.annotations.Sheet;

/**
 * Created by kavin on 19/07/17.
 */
@Sheet(name = "test", customHeader = false)
public class sheet1 {

    public sheet1(){

    }
    @Column(name = "A")
    private String str1;

    @Column(name = "B")
    private String str2;

    @Column(name = "C")
    private String str3;

    @Override
    public String toString() {
        return "sheet1{" +
                "str1='" + str1 + '\'' +
                ", str2='" + str2 + '\'' +
                ", str3='" + str3 + '\'' +
                '}';
    }
}
