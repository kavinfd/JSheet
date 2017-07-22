package com.jsheet.helper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by kavin on 18/07/17.
 */
public class Keys {
    public final String googleServiceAccountName;
    public final File googleServiceAccountKey;
    public Keys(){
        try {
            this.googleServiceAccountName = Files.readAllLines(Paths.get("keys/google_sheet_service_account.txt"), Charset.defaultCharset()).get(0);
            this.googleServiceAccountKey = new File("keys/google_sheet_service_account_key.p12");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
