package me.mingshan.tool.shell.ui.panel;

import me.mingshan.tool.shell.App;
import me.mingshan.tool.shell.log.LogMonitor;
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
  private static MyIconButton buttonDownload;
  private static MyIconButton buttonUpload;
  private static MyIconButton buttonExecute;
  private static MyIconButton buttonClear;
  private static MyIconButton buttonHide;

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
    this.setBackground(new Color(43, 43, 43));
    this.setLayout(new GridLayout(2, 1));
  }

  /**
   * 添加工具按钮
   */
  private void addButtion() {
    JPanel panelUp = new JPanel();
    panelUp.setBackground(new Color(43, 43, 43));
    panelUp.setLayout(new FlowLayout(FlowLayout.CENTER, 6, 14));

    buttonUpload = new MyIconButton(UiConstants.ICON_UPLOAD, UiConstants.ICON_UPLOAD_ENABLE,
        UiConstants.ICON_UPLOAD, "Upload");
    buttonDownload = new MyIconButton(UiConstants.ICON_DOWNLOAD_ENABLE, UiConstants.ICON_DOWNLOAD_ENABLE,
        UiConstants.ICON_DOWNLOAD, "Download");
    buttonExecute = new MyIconButton(UiConstants.ICON_EXECUTE, UiConstants.ICON_EXECUTE_ENABLE,
        UiConstants.ICON_EXECUTE, "Execute");
    buttonSetting = new MyIconButton(UiConstants.ICON_SETTING, UiConstants.ICON_SETTING_ENABLE,
        UiConstants.ICON_SETTING, "Setting");
    panelUp.add(buttonDownload);
    panelUp.add(buttonUpload);
    panelUp.add(buttonExecute);
    panelUp.add(buttonSetting);

    JPanel panelDown = new JPanel();
    panelDown.setBackground(new Color(43, 43, 43));
    panelDown.setLayout(new BorderLayout());
    buttonClear = new MyIconButton(UiConstants.ICON_CLEAR, UiConstants.ICON_CLEAR_ENABLE,
        UiConstants.ICON_CLEAR, "Clear");
    buttonHide = new MyIconButton(UiConstants.ICON_HIDE, UiConstants.ICON_HIDE_ENABLE,
        UiConstants.ICON_HIDE, "Hide");

    JPanel panelDownBtns = new JPanel();
    panelDownBtns.setBackground(new Color(43, 43, 43));
    panelDownBtns.setLayout(new GridLayout(2, 1));
    panelDownBtns.add(buttonHide);
    panelDownBtns.add(buttonClear);
    panelDown.add(panelDownBtns, BorderLayout.SOUTH);

    this.add(panelUp);
    this.add(panelDown);
  }

  /**
   * 为各按钮添加事件动作监听
   */
  private void addListener() {
    buttonDownload.addActionListener(e -> {
      App.changeSidePanelVisible(App.downloadPanel.order());
      buttonDownload.setIcon(UiConstants.ICON_DOWNLOAD_ENABLE);
      buttonUpload.setIcon(UiConstants.ICON_UPLOAD);
      buttonExecute.setIcon(UiConstants.ICON_EXECUTE);
      buttonSetting.setIcon(UiConstants.ICON_SETTING);
    });

    buttonUpload.addActionListener(e -> {
      App.changeSidePanelVisible(App.uploadPanel.order());
      buttonDownload.setIcon(UiConstants.ICON_DOWNLOAD);
      buttonUpload.setIcon(UiConstants.ICON_UPLOAD_ENABLE);
      buttonExecute.setIcon(UiConstants.ICON_EXECUTE);
      buttonSetting.setIcon(UiConstants.ICON_SETTING);
    });

    buttonExecute.addActionListener(e -> {
      App.changeSidePanelVisible(App.executePanel.order());
      buttonDownload.setIcon(UiConstants.ICON_DOWNLOAD);
      buttonUpload.setIcon(UiConstants.ICON_UPLOAD);
      buttonExecute.setIcon(UiConstants.ICON_EXECUTE_ENABLE);
      buttonSetting.setIcon(UiConstants.ICON_SETTING);
    });

    buttonSetting.addActionListener(e -> {
      App.changeSidePanelVisible(App.settingPanel.order());
      buttonDownload.setIcon(UiConstants.ICON_DOWNLOAD);
      buttonUpload.setIcon(UiConstants.ICON_UPLOAD);
      buttonExecute.setIcon(UiConstants.ICON_EXECUTE);
      buttonSetting.setIcon(UiConstants.ICON_SETTING_ENABLE);
    });

    buttonClear.addActionListener(e -> {
      LogMonitor.clearLogs();
    });

    buttonHide.addActionListener(e -> {
      Dimension preferredSize = new Dimension(this.getWidth(), 1);
      App.monitorScrollPanel.setPreferredSize(preferredSize);
    });
  }


}
