package me.mingshan.tool.shell;

import me.mingshan.tool.shell.config.ConfigureSupport;
import me.mingshan.tool.shell.config.ConfigureType;
import me.mingshan.tool.shell.config.FileConfiguration;
import me.mingshan.tool.shell.log.LogMonitor;
import me.mingshan.tool.shell.log.LogMonitorPanel;
import me.mingshan.tool.shell.ui.UiConstants;
import me.mingshan.tool.shell.ui.panel.*;
import me.mingshan.tool.shell.util.ClassUtil;
import me.mingshan.tool.shell.util.propertys.CustomProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

public class App {
  private static final Logger logger = LoggerFactory.getLogger(App.class);

  private JFrame frame;
  private static JPanel mainPanelCenter;
  private static List<SidePanel> sidePanels = new ArrayList<>();

  public static SidePanel downloadPanel;
  public static SidePanel uploadPanel;
  public static SidePanel executePanel;
  public static SidePanel settingPanel;

  public App() {
    initialize();
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        App window = new App();
        window.frame.setVisible(true);
      } catch (Exception e) {
        logger.error(ClassUtil.getFullStackTrace(e));
      }
    });

    new Thread(App::initConfiguration).start();
  }

  /**
   * 初始化窗体
   */
  private void initialize() {
    LogMonitorPanel monitorPanel = new LogMonitorPanel();
    monitorPanel.setVisible(true);

    LogMonitor.addLog("AppInitStart >>>>>");

    // 设置系统默认样式
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | UnsupportedLookAndFeelException e) {
      logger.error(ClassUtil.getFullStackTrace(e));
    }

    // 初始化主窗口
    frame = new JFrame();
    frame.setBounds(UiConstants.MAIN_WINDOW_X, UiConstants.MAIN_WINDOW_Y, UiConstants.MAIN_WINDOW_WIDTH,
        UiConstants.MAIN_WINDOW_HEIGHT);
    CustomProperties customProperties = ConfigureSupport.resolveDynamicProperties(ConfigureType.FILE);
    String title = customProperties.getString(FileConfiguration.APP_NAME, null).get();
    String version = customProperties.getString(FileConfiguration.APP_VERSION, null).get();

    frame.setTitle(title + " " + version);
    frame.setIconImage(UiConstants.IMAGE_ICON);
    frame.setBackground(UiConstants.MAIN_BACK_COLOR);
    JPanel mainPanel = new JPanel(true);
    mainPanel.setBackground(Color.white);
    mainPanel.setLayout(new BorderLayout());

    ToolBarPanel toolbar = new ToolBarPanel();
    mainPanel.add(toolbar, BorderLayout.WEST);

    mainPanelCenter = new JPanel(true);
    mainPanelCenter.setLayout(new BorderLayout());

    downloadPanel = new DownloadPanel();
    uploadPanel = new UploadPanel();
    executePanel = new ExecutePanel();
    settingPanel = new SettingPanel();
    sidePanels.add(downloadPanel);
    sidePanels.add(uploadPanel);
    sidePanels.add(executePanel);
    sidePanels.add(settingPanel);

    mainPanelCenter.add(downloadPanel, BorderLayout.CENTER);
    mainPanelCenter.add(uploadPanel, BorderLayout.CENTER);
    mainPanelCenter.add(executePanel, BorderLayout.CENTER);
    mainPanelCenter.add(settingPanel, BorderLayout.CENTER);
    changeSidePanelVisible(downloadPanel.order());

    JPanel rightPanel = new JPanel();
    rightPanel.setLayout(new BorderLayout());
    rightPanel.add(mainPanelCenter, BorderLayout.CENTER);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setViewportView(monitorPanel);
    scrollPane.setPreferredSize(new Dimension(rightPanel.getWidth(), 100));
    rightPanel.add(scrollPane, BorderLayout.SOUTH);
    mainPanel.add(rightPanel, BorderLayout.CENTER);

    frame.add(mainPanel);
    frame.addWindowListener(new WindowListener() {
      @Override
      public void windowOpened(WindowEvent e) {

      }

      @Override
      public void windowClosing(WindowEvent e) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }

      @Override
      public void windowClosed(WindowEvent e) {

      }

      @Override
      public void windowIconified(WindowEvent e) {

      }

      @Override
      public void windowDeiconified(WindowEvent e) {

      }

      @Override
      public void windowActivated(WindowEvent e) {

      }

      @Override
      public void windowDeactivated(WindowEvent e) {

      }
    });

    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    logger.info("AppInitEnd <<<<<<");
    LogMonitor.addLog("AppInitEnd <<<<<<");
  }

  private static void initConfiguration() {
    logger.info("Init end");
  }

  public static void changeSidePanelVisible(SideOrder orderVisible) {
    LogMonitor.addLog("切换  " + orderVisible.getValue());
    mainPanelCenter.removeAll();
    for (SidePanel sidePanel : sidePanels) {
      if (sidePanel.order().getValue() == orderVisible.getValue()) {
        mainPanelCenter.add(sidePanel, BorderLayout.CENTER);
        mainPanelCenter.updateUI();
        break;
      }
    }
  }
}
