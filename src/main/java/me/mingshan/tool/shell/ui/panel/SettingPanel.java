package me.mingshan.tool.shell.ui.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class SettingPanel extends SidePanel {
  private static JPanel panelBasicOption;
  private static JPanel panelAdvanceOption;

  private static ArrayList<SidePanel> sidePanels = new ArrayList<>();
  public static JPanel settingPanelMain;
  private static SidePanel basicSettingPanel;
  private static SidePanel advanceSettingPanel;

  public SettingPanel() {
    initialize();
    addComponent();
    addListener();
  }

  private void initialize() {
    this.setBackground(new Color(0xffffff));
    this.setLayout(new BorderLayout());
    basicSettingPanel = new BasicSettingPanel();
    advanceSettingPanel = new AdvanceSettingPanel();
    sidePanels.add(basicSettingPanel);
    sidePanels.add(advanceSettingPanel);
  }

  private void addComponent() {
    this.add(getUpPanel(), BorderLayout.NORTH);
    this.add(getCenterPanel(), BorderLayout.CENTER);
  }

  /**
   * 上部面板
   *
   * @return
   */
  private JPanel getUpPanel() {
    JPanel panelUp = new JPanel();
    panelUp.setBackground(new Color(60, 63, 65));
    panelUp.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));

    JLabel labelTitle = new JLabel("设置");
    labelTitle.setFont(new Font(null, Font.PLAIN, 27));
    labelTitle.setForeground(new Color(37, 174, 96));
    panelUp.add(labelTitle);

    return panelUp;
  }

  private JPanel getCenterPanel() {
    // 中间面板
    JPanel panelCenter = new JPanel();
    panelCenter.setBackground(Color.BLACK);
    panelCenter.setLayout(new BorderLayout());

    // 列表Panel
    JPanel panelList = new JPanel();
    Dimension preferredSize = new Dimension(200, 200);
    panelList.setPreferredSize(preferredSize);
    panelList.setBackground(new Color(62, 62, 62));
    panelList.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

    panelBasicOption = new SidePanel() {
      @Override
      public SideOrder order() {
        return SideOrder.FIRST;
      }
    };
    panelBasicOption.setBackground(new Color(69, 186, 121));
    panelBasicOption.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 13));
    Dimension preferredSizeListItem = new Dimension(245, 48);
    panelBasicOption.setPreferredSize(preferredSizeListItem);
    panelAdvanceOption = new SidePanel() {
      @Override
      public SideOrder order() {
        return SideOrder.SECOND;
      }
    };
    panelAdvanceOption.setBackground(Color.BLACK);
    panelAdvanceOption.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 13));
    panelAdvanceOption.setPreferredSize(preferredSizeListItem);

    JLabel labelOption = new JLabel("基础设置");
    JLabel labelAbout = new JLabel("高级设置");
    Font fontListItem = new Font(null, 0, 15);
    labelOption.setFont(fontListItem);
    labelAbout.setFont(fontListItem);
    labelOption.setForeground(Color.white);
    labelAbout.setForeground(Color.white);
    panelBasicOption.add(labelOption);
    panelAdvanceOption.add(labelAbout);

    panelList.add(panelBasicOption);
    panelList.add(panelAdvanceOption);

    // 设置Panel
    settingPanelMain = new JPanel();
    settingPanelMain.setBackground(Color.BLACK);
    settingPanelMain.setLayout(new BorderLayout());
    changeSideOption(SideOrder.FIRST);

    panelCenter.add(panelList, BorderLayout.WEST);
    panelCenter.add(settingPanelMain, BorderLayout.CENTER);

    return panelCenter;
  }

  private void addListener() {
    panelBasicOption.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        panelBasicOption.setBackground(new Color(69, 186, 121));
        panelAdvanceOption.setBackground(Color.BLACK);
        changeSideOption(SideOrder.FIRST);
      }

      @Override
      public void mousePressed(MouseEvent e) {

      }

      @Override
      public void mouseReleased(MouseEvent e) {

      }

      @Override
      public void mouseEntered(MouseEvent e) {

      }

      @Override
      public void mouseExited(MouseEvent e) {

      }
    });

    panelAdvanceOption.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        panelBasicOption.setBackground(Color.BLACK);
        panelAdvanceOption.setBackground(new Color(69, 186, 121));
        changeSideOption(SideOrder.SECOND);
      }

      @Override
      public void mousePressed(MouseEvent e) {

      }

      @Override
      public void mouseReleased(MouseEvent e) {

      }

      @Override
      public void mouseEntered(MouseEvent e) {

      }

      @Override
      public void mouseExited(MouseEvent e) {

      }
    });
  }

  @Override
  public SideOrder order() {
    return SideOrder.FOURTH;
  }

  private static void changeSideOption(SideOrder visibleOrder) {
    settingPanelMain.removeAll();

    for (SidePanel sidePanel : sidePanels) {
      if (sidePanel.order().getValue() == visibleOrder.getValue()) {
        settingPanelMain.add(sidePanel);
        break;
      }
    }

    settingPanelMain.updateUI();
  }
}
