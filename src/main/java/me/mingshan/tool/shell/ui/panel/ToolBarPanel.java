package me.mingshan.tool.shell.ui.panel;

import me.mingshan.tool.shell.App;
import me.mingshan.tool.shell.ui.UiConstants;
import me.mingshan.tool.shell.ui.component.MyIconButton;

import javax.swing.*;
import java.awt.*;

/**
 * 工具栏面板
 *
 */
public class ToolBarPanel extends JPanel {

  private static MyIconButton buttonSetting;

  /**
   * 构造
   */
  public ToolBarPanel() {
    initialize();
    addButtion();
    addListener();
  }

  /**
   * 初始化
   */
  private void initialize() {
    Dimension preferredSize = new Dimension(48, UiConstants.MAIN_WINDOW_HEIGHT);
    this.setPreferredSize(preferredSize);
    this.setMaximumSize(preferredSize);
    this.setMinimumSize(preferredSize);
    this.setBackground(UiConstants.TOOL_BAR_BACK_COLOR);
    this.setLayout(new GridLayout(2, 1));
  }

  /**
   * 添加工具按钮
   */
  private void addButtion() {
    JPanel panelUp = new JPanel();
    panelUp.setBackground(UiConstants.TOOL_BAR_BACK_COLOR);
    panelUp.setLayout(new FlowLayout(-2, -2, -4));
    JPanel panelDown = new JPanel();
    panelDown.setBackground(UiConstants.TOOL_BAR_BACK_COLOR);
    panelDown.setLayout(new BorderLayout(10, 10));

    buttonSetting = new MyIconButton(UiConstants.ICON_SETTING, UiConstants.ICON_SETTING_ENABLE,
        UiConstants.ICON_SETTING, "Setting");

    panelDown.add(buttonSetting, BorderLayout.SOUTH);
    this.add(panelUp);
    this.add(panelDown);
  }

  /**
   * 为各按钮添加事件动作监听
   */
  private void addListener() {

  }
}
