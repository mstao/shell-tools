package me.mingshan.tool.shell.log;

import me.mingshan.tool.shell.util.StringUtil;
import me.mingshan.tool.shell.util.TimeUtil;
import me.mingshan.tool.shell.util.cache.Cache;
import sun.rmi.runtime.Log;

import javax.swing.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;

public class LogMonitor implements Serializable {
  private static final long serialVersionUID = 1L;
  private static Map<String, StringBuilder> logMap = new HashMap<>();

  /**
   * 获取日志信息
   *
   * @return
   */
  public static StringBuilder getLogs(LogType logType) {
    Objects.requireNonNull(logType, "logType");
    return logMap.get(logType.name());
  }

  /**
   * 新增日志信息
   *
   * @param log
   */
  public static void addLog(String log) {
    addLog(log, LogType.SYSTEM);
  }

  /**
   * 新增日志信息
   *
   * @param log
   */
  public static void addLog(String log, LogType logType) {
    Objects.requireNonNull(logType, "logType");

    StringBuilder logs = logMap.get(logType.name());
    if (StringUtil.isEmpty(log)) {
      logs.append("\r\n");
    } else {
      log = String.format("%s    %s\r\n", TimeUtil.getCurrentDateTime(), log);
      logs.append(log);
    }
    activateLogChangedEvent(logType);
  }

  /**
   * 清除日志信息
   */
  public static void clearLogs() {
    logMap.clear();
    activateLogChangedEvent(LogType.SYSTEM);
  }

  public static void clearLog(LogType logType) {
    Objects.requireNonNull(logType, "logType");

    logMap.put(logType.name(), new StringBuilder());
  }

  private static Vector<LogChangedListener> vectorListeners = new Vector<LogChangedListener>();

  public static synchronized void addLogChangedListener(LogChangedListener listener) {
    vectorListeners.addElement(listener);
  }

  public static synchronized void removeLogChangedListener(LogChangedListener listener) {
    vectorListeners.removeElement(listener);
  }

  public static void activateLogChangedEvent(LogType logType) {
    Objects.requireNonNull(logType, "logType");

    Vector<LogChangedListener> tempVector;
    LogChangedEvent e = new LogChangedEvent(LogMonitor.class);
    e.setLogType(logType);
    synchronized (LogMonitor.class) {
      tempVector = (Vector<LogChangedListener>) vectorListeners.clone();
      for (int i = 0; i < tempVector.size(); i++) {
        LogChangedListener listener = tempVector.elementAt(i);
        listener.eventActivated(e);
      }
    }
  }
}