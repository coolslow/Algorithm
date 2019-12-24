package com.coolslow.datastruct.utils;

import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;

/**
 * IO工具类
 * <p>
 * by MrThanksgiving
 */
public class MyIO {

    public static int[] getIntArray(String filePath) {
        File file = new File(filePath);
        FileInputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;
        byte[] buffer = new byte[1024];
        try {
            inputStream = new FileInputStream(file);
            outputStream = new ByteArrayOutputStream();
            int length = -1;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            String content = new String(outputStream.toByteArray());
            content = content.replaceAll("\\[", "");
            content = content.replaceAll("]", "");
            String[] array = content.split(",");
            int count = array.length;
            int[] result = new int[count];
            for (int i = 0; i < count; i++) {
                result[i] = Integer.parseInt(array[i]);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
