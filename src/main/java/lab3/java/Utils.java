package lab3.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Utils {

    public static List<String> getMatches(String regex, String target) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(target);
        var list = new ArrayList<String>();
        while(matcher.find()) {
            list.add(matcher.group());
        }
        if(list.isEmpty()) {
            System.out.println("No elements found");
        } else {
            System.out.println("Found elements with regex " + regex + " in " + target);
            list.forEach(System.out::println);
        }
        return list;
    }

    public static List<ImageTag> getTags(List<String> images) {
        var list = new ArrayList<String>();
        for (int i = 0; i < images.size(); i++) {
            StringBuilder imageSb = new StringBuilder(images.get(i));
            if(getMatches("width", imageSb.toString()).isEmpty()) {
                int width = new Scanner(System.in).nextInt();
                String srcMatch = getMatches("src=\"[^\"]*\"", imageSb.toString()).get(0);
                int lastCharIndex = imageSb.indexOf(srcMatch) + srcMatch.length();
                imageSb.insert(lastCharIndex, " width=\"" + width + "\"");
            }
            if(getMatches("height", imageSb.toString()).isEmpty()) {
                int height = new Scanner(System.in).nextInt();
                String widthMatch = getMatches("width=\".*\"", imageSb.toString()).get(0);
                int lastCharIndex = imageSb.indexOf(widthMatch) + widthMatch.length();
                imageSb.insert(lastCharIndex, " height=\"" + height + "\"");
            }
            list.add(imageSb.toString());
        }
        list.forEach(System.out::println);
        var tagList = new ArrayList<ImageTag>();
        for (int i = 0; i < list.size(); i++) {
            var widthAndHeight = getMatches("[0-9]+", list.get(i));
            tagList.add(new ImageTag(list.get(i), Integer.parseInt(widthAndHeight.get(0)), Integer.parseInt(widthAndHeight.get(1))));
        }
        return tagList;
    }

    public static List<ImageTag> sortTags(List<ImageTag> matches) {
        return matches.stream().sorted().collect(Collectors.toList());
    }
}
