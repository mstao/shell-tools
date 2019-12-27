package me.mingshan.tool.shell.config;

import me.mingshan.tool.shell.util.propertys.CustomProperties;
import me.mingshan.tool.shell.util.propertys.FileProperties;
import me.mingshan.tool.shell.util.propertys.SystemProperties;

/**
 * 配置支持
 *
 * @author hanjuntao
 */
public class ConfigureSupport {

  /**
   * 根据配置类型来获取不同的配置
   *
   * @return {@code CustomProperties} 实现类
   */
  public static CustomProperties resolveDynamicProperties(ConfigureType type) {
    CustomProperties customProperties;

    switch (type) {
      case SYSTEM:
        customProperties = SystemProperties.getInstance();
        break;
      case FILE:
        customProperties = FileProperties.getInstance();
        break;
      default: throw new RuntimeException("Can not find the type of loading configuration.");
    }

    return customProperties;
  }
}
