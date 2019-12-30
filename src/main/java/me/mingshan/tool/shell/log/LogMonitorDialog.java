package me.mingshan.tool.shell.log;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class LogMonitorDialog extends JDialog {
  private static final long serialVersionUID = 1L;
  private JTextArea txtLogInfo;

  /**
   * 日志信息变更监听处理（关键点）
   */
  private void init() {
    LogMonitor.addLogChangedListener(new LogChangedListener() {
      @Override
      public void eventActivated(LogChangedEvent me) {
        txtLogInfo.setText(LogMonitor.getLogs().toString());
        txtLogInfo.setCaretPosition(txtLogInfo.getText().length());
        txtLogInfo.paintImmediately(txtLogInfo.getBounds());
      }
    });
  }

  public LogMonitorDialog() {
    setResizable(false);
    setTitle("执行日志");
    setBounds(100, 100, 439, 274);
    JScrollPane scrollPane = new JScrollPane();
    GroupLayout groupLayout = new GroupLayout(getContentPane());
    groupLayout.setHorizontalGroup(
        groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane)
                .addContainerGap())
    );
    groupLayout.setVerticalGroup(
        groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
    );
    txtLogInfo = new JTextArea();
    txtLogInfo.setEditable(false);
    txtLogInfo.setLineWrap(true);
    scrollPane.setViewportView(txtLogInfo);
    getContentPane().setLayout(groupLayout);
    this.init();
  }
}