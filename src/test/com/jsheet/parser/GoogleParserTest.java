package com.jsheet.parser;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.jsheet.dataAccess.Dao;
import com.jsheet.helper.GoogleSheetHelper;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


/**
 * Created by kavin on 18/07/17.
 */
public class GoogleParserTest {
    public enum ordinal{
        A,B,C,D,E,F,G
    }
    @Test
    public void testGoogleSheets() throws Exception {
// Build a new authorized API client service.
//        Dao dao = new Dao();
//        dao.getData("adf", sheet1.class);
      Sheets service = new GoogleSheetHelper().getSheetsService();
//
//        // Prints the names and majors of students in a sample spreadsheet:
//        // https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
        String spreadsheetId = "1OzLYTbtpqSB46QiOgodnT6TteQ5GqoXKqz04mrTUZQQ";
        String range = "Sheet1!A:Z";
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
       System.out.println(values);
    }
}