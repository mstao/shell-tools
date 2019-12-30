package me.mingshan.tool.shell.ui.panel;

import java.awt.*;

public class UploadPanel extends SidePanel {
  public UploadPanel() {
    initialize();
    addComponent();
    addListener();
  }

  private void initialize() {
    this.setBackground(new Color(0xffffff));
    this.setLayout(new BorderLayout());
  }

  private void addComponent() {
    this.add(new TextField("UploadPanel"), BorderLayout.CENTER);
  }

  private void addListener() {
  }

  @Override
  public SideOrder order() {
    return SideOrder.SECOND;
  }
}
