package me.mingshan.tool.shell;

import me.mingshan.tool.shell.config.ConfigureSupport;
import me.mingshan.tool.shell.config.ConfigureType;
import me.mingshan.tool.shell.config.FileConfiguration;
import me.mingshan.tool.shell.ui.UiConstants;
import me.mingshan.tool.shell.ui.panel.ToolBarPanel;
import me.mingshan.tool.shell.util.ClassUtil;
import me.mingshan.tool.shell.util.propertys.CustomProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class App {
  private static final Logger logger = LoggerFactory.getLogger(App.class);

  private JFrame frame;

  private static JPanel mainPanelCenter;

  public App() {
    initialize();
  }

  public static void main(String[] args) {
    initProperties(args);

    EventQueue.invokeLater(() -> {
      try {
        App window = new App();
        window.frame.setVisible(true);
      } catch (Exception e) {
        logger.error(ClassUtil.getFullStackTrace(e));
      }
    });
  }

  /**
   * 初始化窗体
   */
  private void initialize() {
    logger.info("AppInitStart >>>>>");

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
    mainPanelCenter.add(new TextArea("Hello World"), BorderLayout.CENTER);

    mainPanel.add(mainPanelCenter, BorderLayout.CENTER);

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
  }

  /**
   * 初始化外界配置
   *
   * @param args 参数
   */
  private static void initProperties(String[] args) {
    logger.info("Initial properties >>>>> ");

    if (args != null && args.length > 0) {

    }
  }


}
