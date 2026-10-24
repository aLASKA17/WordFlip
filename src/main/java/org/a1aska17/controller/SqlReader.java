package org.a1aska17.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class SqlReader {
    public static String readSqlFile(String path) {
        try (InputStream is = SqlReader.class.getResourceAsStream(path)) {
            if (is == null) {
                throw new IllegalArgumentException("File not found: " + path);
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                return reader.lines().collect(Collectors.joining("\n"));
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the SQL file: " + path, e);
        }
    }
}
