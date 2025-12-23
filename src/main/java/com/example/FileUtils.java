<<<<<<< HEAD:src/main/java/com/example/FileUtils.java
package com.example;

public class FileUtils {


}
=======
package com;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileUtils {

    public static String readFile(String resourcePath) throws IOException {
        InputStream is = FileUtils.class
                .getClassLoader()
                .getResourceAsStream(resourcePath);

        if (is == null) {
            throw new IOException("Fichier introuvable dans resources : " + resourcePath);
        }

        StringBuilder content = new StringBuilder();

        try (BufferedReader br =
                     new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }

        return content.toString();
    }

    public static void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(content);
        }
    }
}
>>>>>>> origin/lyrach_branch:src/main/java/com/FileUtils.java
