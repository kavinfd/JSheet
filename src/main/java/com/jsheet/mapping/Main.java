package com.jsheet.mapping;

import com.jsheet.annotations.Column;

import java.lang.reflect.Field;

/**
 * Created by kavin on 19/07/17.
 */
public class Main {
    public Main(Class clazz) {
        for(Field field  : clazz.getDeclaredFields())
        {
            if (field.isAnnotationPresent(Column.class))
            {
                System.out.println(field.getName());
            }
        }
    }
}
