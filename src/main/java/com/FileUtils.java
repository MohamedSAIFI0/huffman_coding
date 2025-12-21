package com;
import java.io.bufferedReader;
import java.io.bufferedWriter;
import java.io.IOException;

public class FileUtils {


    public static String readFile(String filePath) throws IOException{
        StringBuilder content = new StringBuilder;

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = br.readLine()) != null){
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString();
    }

    public static void writeFile(String filePath, String content) throws IOException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
            bw.write(content);
        }
    }




}
