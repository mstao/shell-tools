package me.mingshan.tool.shell.log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class LogMonitorPanel extends JPanel {
  private static final long serialVersionUID = 1L;
  private Map<String, JTextPane> panels = new HashMap<>();

  /**
   * 日志信息变更监听处理（关键点）
   */
  private void init() {
    LogMonitor.addLogChangedListener(new LogChangedListener() {
      @Override
      public void eventActivated(LogChangedEvent me) {
        LogType logType = me.getLogType();
        JTextPane textPane = LogMonitorPanel.this.panels.get(logType.name());
        textPane.setText(LogMonitor.getLogs(logType).toString());
      }
    });
  }

  public LogMonitorPanel() {
    this.setBackground(new Color(43, 43, 43));
    this.setForeground(Color.WHITE);
    ImageIcon icon = new ImageIcon("/icon/setting.png");

    JTabbedPane tabbedPane = new JTabbedPane();
    for (int i = 0; i < LogType.values().length; i++) {
      JTextPane textPane = new JTextPane();

      JScrollPane monitorScrollPanel = new JScrollPane();
      monitorScrollPanel.setViewportView(textPane);
      monitorScrollPanel.setPreferredSize(new Dimension(800, 100));

      LogType logType = LogType.values()[i];
      panels.put(logType.name(), textPane);
      tabbedPane.addTab(logType.getCaption(), icon, monitorScrollPanel, logType.getCaption());
      tabbedPane.setMnemonicAt(i, KeyEvent.VK_4);
    }

    this.add(tabbedPane);

    this.init();
  }
}