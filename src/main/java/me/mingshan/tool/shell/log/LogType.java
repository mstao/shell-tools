
package me.mingshan.tool.shell.log;

/**
 * 日志类型，显示对应的看板
 */
public enum LogType {

  SYSTEM("系统日志"),

  OPERATE("操作日志");

  private String caption;

  private LogType(String caption) {
    this.caption = caption;
  }

  public String getCaption() {
    return caption;
  }
}
