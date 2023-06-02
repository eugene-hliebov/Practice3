package ua.nure.hliebov.practice3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.BufferedReader;
import java.io.FileReader;

public class Util {

    private static final String ENCODING = StandardCharsets.UTF_8.name();

//    public static String readFile(String path) {
//        String res = null;
//        try {
//            byte[] bytes = Files.readAllBytes(Paths.get(path));
//            res = new String(bytes, ENCODING);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        return res;
//    }

    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

    public static void main(String[] args) {
        System.out.println(readFile("part1.txt"));
    }
}


