package lab3.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class Main {

    private static final String SOURCE_FILE_PATH = "./src/main/resources/source.html";
    private static final String OUTPUT_FILE_PATH = "./src/main/resources/output.html";

    public static String getHtmlAsString(String fileName) {
        try (FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader)) {
            String html = "";
            while(bufferedReader.ready()) {
                html = html.concat(bufferedReader.readLine());
            }
            return html;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setHtmlFromString(String html, String fileName) {
        try (FileWriter writer = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(html);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String html = getHtmlAsString(SOURCE_FILE_PATH);
        List<String> images = Utils.getMatches("<img[^>]*>", html);
        List<ImageTag> tags = Utils.getTags(images);
        List<ImageTag> sortedTags = Utils.sortTags(tags);
        for (int i = 0; i < images.size(); i++) {
            System.out.println(images.get(i) + " to " + sortedTags.get(i).getTag());
           html = html.replace(images.get(i), sortedTags.get(i).getTag());
        }
        setHtmlFromString(html, OUTPUT_FILE_PATH);
    }
}
