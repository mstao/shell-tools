package me.mingshan.tool.shell.ui.panel;

import java.awt.*;

public class BasicSettingPanel extends SidePanel {
  public BasicSettingPanel() {
    initialize();
    addComponent();
    addListener();
  }

  private void initialize() {
    this.setBackground(new Color(43, 43, 43));
    this.setLayout(new BorderLayout());
  }

  private void addComponent() {
    this.add(new TextField("BasicSettingPanel"), BorderLayout.CENTER);
  }

  private void addListener() {
  }

  @Override
  public SideOrder order() {
    return SideOrder.FIRST;
  }
}
