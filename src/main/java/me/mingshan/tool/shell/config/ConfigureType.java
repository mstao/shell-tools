package me.mingshan.tool.shell.config;

/**
 * Supports type of getting configuration.
 *
 * @author mingshan
 */
public enum ConfigureType {

  /**
   * Load configuration from system property.
   */
  SYSTEM("Load configuration from system property"),

  /**
   * Load configuration from system property.
   */
  FILE("Load configuration from file");

  /**
   * The description of loading configuration.
   */
  private String desc;

  ConfigureType(String desc) {
    this.desc = desc;
  }

  private String getDesc() {
    return this.desc;
  }
}