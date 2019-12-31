package me.mingshan.tool.shell.ui.panel;

import java.awt.*;

public class AdvanceSettingPanel extends SidePanel {
  public AdvanceSettingPanel() {
    initialize();
    addComponent();
    addListener();
  }

  private void initialize() {
    this.setBackground(new Color(43, 43, 43));
    this.setLayout(new BorderLayout());
  }

  private void addComponent() {
    this.add(new TextField("AdvanceSettingPanel"), BorderLayout.CENTER);
  }

  private void addListener() {
  }

  @Override
  public SideOrder order() {
    return SideOrder.SECOND;
  }
}
