package me.mingshan.tool.shell.util;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileUtil {

  public static String readFromFile(String filePath) throws IOException {
    InputStream inputStream = new FileInputStream(filePath);
    return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
  }

  public static void writeToFile(String json, String filePath) throws IOException {
    clearInfoForFile(filePath);

    BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(filePath, true)));
    try {
      IOUtils.write(json, writer);
    } finally {
      IOUtils.closeQuietly(writer);
    }
  }

  private static void clearInfoForFile(String filePath) {
    File file = new File(filePath);
    try {
      if (file.exists()) {
        try (FileWriter fileWriter = new FileWriter(file)) {
          fileWriter.write("");
          fileWriter.flush();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
