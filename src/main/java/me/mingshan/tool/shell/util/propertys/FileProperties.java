package me.mingshan.tool.shell.util.propertys;

import me.mingshan.tool.shell.util.PropertyUtil;
import me.mingshan.tool.shell.util.StringUtil;
import me.mingshan.tool.shell.util.cache.Cache;
import me.mingshan.tool.shell.util.cache.caffeine.CaffeineCache;

import java.io.IOException;
import java.util.Properties;

/**
 * Provides the way to get configuration via property file.
 *
 * @author mingshan
 */
public class FileProperties implements CustomProperties {

  private static final String PROPERTY_FILE_NAME = "app.properties";

  /**
   * No Public
   */
  private FileProperties() {
  }

  /**
   * Inner class for lazy load.
   */
  private static final class FilePropertiesHolder {
    private static final FileProperties INSTANCE = new FileProperties();
  }

  /**
   * Returns the instance of {@link FileProperties}.
   *
   * @return the instance of {@link FileProperties}
   */
  public static FileProperties getInstance() {
    return FilePropertiesHolder.INSTANCE;
  }

  @Override
  public Property<String> getString(String name, String fallback) {
    Cache caffeineCache = CaffeineCache.getInstance();
    Object cachedValue = caffeineCache.get(name);
    String value = null;
    if (cachedValue == null) {
      Properties properties = loadProperties();
      Object resource = properties.get(name);
      if (resource != null) {
        String tempValue = String.valueOf(resource);
        if (!StringUtil.isEmpty(tempValue)) {
          value = tempValue;
          caffeineCache.put(name, value);
        }
      }
    } else {
      value = String.valueOf(cachedValue);
    }

    final String endValue = value;
    return new Property<String>() {

      @Override
      public String get() {
        return endValue;
      }

      @Override
      public String getName() {
        return name;
      }
    };
  }

  @Override
  public Property<Integer> getInteger(String name, Integer fallback) {
    Cache caffeineCache = CaffeineCache.getInstance();
    Object cachedValue = caffeineCache.get(name);
    int value;
    if (cachedValue == null) {
      Properties properties = loadProperties();
      value = Integer.parseInt(properties.get(name).toString());
      caffeineCache.put(name, value);
    } else {
      value = Integer.parseInt(cachedValue.toString());
    }

    return new Property<Integer>() {

      @Override
      public Integer get() {
        return value;
      }

      @Override
      public String getName() {
        return name;
      }
    };
  }

  @Override
  public Property<Boolean> getBoolean(String name, Boolean fallback) {
    Cache caffeineCache = CaffeineCache.getInstance();
    Object cachedValue = caffeineCache.get(name);
    boolean value;
    if (cachedValue == null) {
      Properties properties = loadProperties();
      value = Boolean.parseBoolean(properties.get(name).toString());
      caffeineCache.put(name, value);
    } else {
      value = Boolean.parseBoolean(cachedValue.toString());
    }

    return new Property<Boolean>() {

      @Override
      public Boolean get() {
        return value;
      }

      @Override
      public String getName() {
        return name;
      }
    };
  }

  @Override
  public Property<Long> getLong(String name, Long fallback) {
    Cache caffeineCache = CaffeineCache.getInstance();
    Object cachedValue = caffeineCache.get(name);
    long value;
    if (cachedValue == null) {
      Properties properties = loadProperties();
      value = Long.parseLong(properties.get(name).toString());
      caffeineCache.put(name, value);
    } else {
      value = Long.parseLong(cachedValue.toString());
    }

    return new Property<Long>() {

      @Override
      public Long get() {
        return value;
      }

      @Override
      public String getName() {
        return name;
      }
    };
  }
  

  private static Properties loadProperties() {
    Properties properties = null;
    try {
      properties = PropertyUtil.loadProperties(PROPERTY_FILE_NAME);
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    return properties;
  }
    
}