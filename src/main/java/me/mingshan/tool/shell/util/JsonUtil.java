package me.mingshan.tool.shell.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.IOException;
import java.util.List;

public class JsonUtil {

  private static final SerializeConfig config;

  static {
    config = new SerializeConfig();
    config.put(java.util.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
    config.put(java.sql.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
  }

  private static final SerializerFeature[] features = {SerializerFeature.WriteMapNullValue, // 输出空置字段
      SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
      SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
      SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
      SerializerFeature.WriteNullStringAsEmpty // 字符类型字段如果为null，输出为""，而不是null
  };

  public static String objectToJson(Object object) {
    return JSON.toJSONString(object, config, features);
  }

  public static <T> T jsonToObject(String json, Class<T> clazz) {
    return JSON.parseObject(json, clazz);
  }

  public static <T> List<T> jsonToList(String json, Class<T> clazz) {
    return JSON.parseArray(json, clazz);
  }

  /**
   * 反序列化
   *
   * @param source
   * @param clazz
   * @param modelType
   * @return 反序列化的数据
   */
  private Object deserialize(String source, Class<?> clazz, Class<?> modelType) {
    // 判断是否为List
    if (List.class.isAssignableFrom(clazz)) {
      return JSON.parseArray(source, modelType);
    }

    // 正常反序列化
    return JSON.parseObject(source, modelType);
  }

  public static void main(String[] args) throws IOException {
    String json = "{code: \"111\", name: \"bbbbbbbbb\"}";
    FileUtil.writeToFile(json, "test.json");

    String json2 = FileUtil.readFromFile("test.json");
    System.out.println(json2);
  }
}
