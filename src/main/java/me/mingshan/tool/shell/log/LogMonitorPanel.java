package me.mingshan.tool.shell.log;

import javax.swing.*;
import java.awt.*;

public class LogMonitorPanel extends JTextPane {
  private static final long serialVersionUID = 1L;

  /**
   * 日志信息变更监听处理（关键点）
   */
  private void init() {
    LogMonitor.addLogChangedListener(new LogChangedListener() {
      @Override
      public void eventActivated(LogChangedEvent me) {
        LogMonitorPanel.this.setText(LogMonitor.getLogs().toString());
      }
    });
  }

  public LogMonitorPanel() {
    this.setBackground(new Color(43, 43, 43));
    this.setForeground(Color.WHITE);
    this.init();
  }
}