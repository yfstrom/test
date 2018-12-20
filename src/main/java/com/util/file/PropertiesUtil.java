package com.util.file;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * 属性文件读取
 * @author llmf
 *
 */
public class PropertiesUtil {

    private static Properties properties;
    private static final String name = "API_URL.properties";

    static {
        try {
            properties = new Properties();
            properties.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(name), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("不支持编码: " + e);
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
    }

    public static String getValue(String key) {
        String value = properties.getProperty(key).trim();
        if (value == null) {
            return null;
        }
        return value;
    }


    public static String getValue(String key, String defaultvalue) {
        String value = properties.getProperty(key).trim();
        if (value == null) {
            value = defaultvalue;
        }
        return value;
    }


//    demo
//    public static void main(String[] args) {
//        String userAddressMaxNumber = PropertiesUtil.getValue("userAddressMaxNumber");
//        System.out.println(userAddressMaxNumber);
//    }

}
