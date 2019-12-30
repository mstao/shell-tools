package me.mingshan.tool.shell.ui.panel;

import javax.swing.*;

public abstract class SidePanel extends JPanel {

  /**
   * 从上到下的次序
   *
   * @return 序号
   */
  public abstract SideOrder order();

}
