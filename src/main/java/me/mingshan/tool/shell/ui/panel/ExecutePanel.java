package me.mingshan.tool.shell.ui.panel;

import java.awt.*;

public class ExecutePanel extends SidePanel {
  public ExecutePanel() {
    initialize();
    addComponent();
    addListener();
  }

  private void initialize() {
    this.setBackground(new Color(0xffffff));
    this.setLayout(new BorderLayout());
  }

  private void addComponent() {
    this.add(new TextField("ExecutePanel..............................."), BorderLayout.CENTER);
  }

  private void addListener() {
  }

  @Override
  public SideOrder order() {
    return SideOrder.THIRD;
  }
}
