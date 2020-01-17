package me.mingshan.tool.shell.log;

public class LogChangedEvent extends java.util.EventObject {
  private static final long serialVersionUID = 7573194493258326711L;
  private LogType logType;

  public LogChangedEvent(Object source) {
    super(source);
  }

  public LogType getLogType() {
    return logType;
  }

  public void setLogType(LogType logType) {
    this.logType = logType;
  }
}
