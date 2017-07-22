package com.jsheet.dataAccess;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.jsheet.annotations.Column;
import com.jsheet.annotations.Sheet;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kavin on 21/07/17.
 */
public class Dao {

    private Sheets sheets;

    /**
     * right now only targeting google sheet later have to extract out a more generic interface
     * @param sheets
     */
    public Dao(Sheets sheets){
        this.sheets = sheets;
    }
    private void assertCondition(Boolean value, String message){
        if(!value){
            throw new IllegalStateException(message);
        }
    }
    /**
     * writing a more monolithic poc
     * with all minimal implementation needed to get the information out of the sheet
     * @param sheetId
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getData(String sheetId, Class<T> clazz){
        String sheetName = clazz.getAnnotation(Sheet.class).name();
        String rowRange = clazz.getAnnotation(Sheet.class).rowRange();
        assertCondition(!rowRange.isEmpty(), String.format("rowRange empty for Model %s ", clazz.getName()));
        T sheet;
        try {
            sheet = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            ValueRange response = sheets.spreadsheets().values()
                    .get(sheetId, rowRange)
                    .execute();
            response.getValues();
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> enumerateRange(String range){
return null;
    }
}
