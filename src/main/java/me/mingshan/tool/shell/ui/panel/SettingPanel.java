package me.mingshan.tool.shell.ui.panel;

import javax.swing.*;
import java.awt.*;

public class SettingPanel extends JPanel {

  public SettingPanel() {
    initialize();
    addComponent();
    addListener();
  }

  private void initialize() {
    this.setBackground(new Color(0xffffff));
    this.setLayout(new BorderLayout());
  }

  private void addComponent() {
    this.add(new TextField("Hello World"), BorderLayout.CENTER);
  }

  private void addListener() {
  }
}
