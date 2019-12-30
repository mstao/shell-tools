package me.mingshan.tool.shell.log;

import me.mingshan.tool.shell.util.StringUtil;
import me.mingshan.tool.shell.util.TimeUtil;

import java.io.Serializable;
import java.util.Vector;

public class LogMonitor implements Serializable {
  private static final long serialVersionUID = 1L;
  private static StringBuilder logs = new StringBuilder();

  /**
   * 获取日志信息
   *
   * @return
   */
  public static StringBuilder getLogs() {
    return logs;
  }

  /**
   * 新增日志信息
   *
   * @param log
   */
  public static void addLog(String log) {
    if (StringUtil.isEmpty(log)) {
      logs.append("\r\n");
    } else {
      log = String.format("%s    %s\r\n", TimeUtil.getCurrentDateTime(), log);
      logs.append(log);
    }
    activateLogChangedEvent();
  }

  /**
   * 清除日志信息
   */
  public static void clearLogs() {
    logs = new StringBuilder();
    activateLogChangedEvent();
  }

  private static Vector<LogChangedListener> vectorListeners = new Vector<LogChangedListener>();

  public static synchronized void addLogChangedListener(LogChangedListener listener) {
    vectorListeners.addElement(listener);
  }

  public static synchronized void removeLogChangedListener(LogChangedListener listener) {
    vectorListeners.removeElement(listener);
  }

  public static void activateLogChangedEvent() {
    Vector<LogChangedListener> tempVector;
    LogChangedEvent e = new LogChangedEvent(LogMonitor.class);
    synchronized (LogMonitor.class) {
      tempVector = (Vector<LogChangedListener>) vectorListeners.clone();
      for (int i = 0; i < tempVector.size(); i++) {
        LogChangedListener listener = tempVector.elementAt(i);
        listener.eventActivated(e);
      }
    }
  }
}