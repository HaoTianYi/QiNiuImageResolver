package win.haotianyi;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 天 on 2017/7/12.
 */
public class Utils {
    private static final Pattern LOCAL_IMAGE_PATTERN = Pattern
            .compile("!\\[.*]\\(.*\\.(png|gif|jpg|jpeg)\\)");

    private static final Pattern IMAGE_ALT_PATTERN = Pattern.compile("!\\[.*]");

    /**
     * @return all the local image tag in blogString
     */
    public static ArrayList<String> getImageTags(String blogString) {
        ArrayList<String> tags = new ArrayList<String>();
        Matcher matcher = LOCAL_IMAGE_PATTERN.matcher(blogString);
        while (matcher.find()) {
            String imageTag = matcher.group();
            tags.add(imageTag);
        }
        return tags;
    }

    public static String getBackUpFileName(String mdFileName) {
        String[] strs = mdFileName.split("\\.");
        if (strs.length != 2) {
            return mdFileName;
        }
        return strs[0] + "_bak." + strs[1];
    }

    public static String getAltFromImageTag(String imageTag) {
        Matcher matcher = IMAGE_ALT_PATTERN.matcher(imageTag);
        if (matcher.find()) {
            return matcher.group().replace("![", "").replace("]", "");
        } else {
            return "";
        }
    }

    public static void writeStringToFile(String content, File targetFile)
            throws Exception {
        FileWriter writer = new FileWriter(targetFile);
        writer.write(content);
        writer.flush();
        writer.close();
    }

    public static String getImageTagByUrl(String alt, String url) {
        return "![" + alt + "](" + url + ")";
    }

    public static String getFilePathFromImageTag(String localImageTag) {
        return localImageTag.split("!\\[.*]")[1].replace("(","").replace(")","");
    }

    public static String getStringFromFile(File file, String encode) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(
                    file), encode);
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                sb.append(lineTxt).append("\n");
            }
            read.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return sb.toString();
    }

    public static String getFileNameFromImageTag(String localImageTag) {
        String[] strArray = localImageTag.split("/");
        return strArray[strArray.length - 1].replace(")", "");
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static String readDataFromConsole(String prompt) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            System.out.print(prompt);
            str = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.trim();
    }
}
