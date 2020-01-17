/*
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2020，所有权利保留。
 *
 * 项目名：code
 * 文件名：LogType.java
 * 模块说明：
 * 修改历史：
 * 2020/1/17 下午2:18 - hanjuntao - 创建。
 *
 */

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
