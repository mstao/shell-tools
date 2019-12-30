package me.mingshan.tool.shell.ui;


import me.mingshan.tool.shell.App;

import javax.swing.*;
import java.awt.*;

/**
 * UI相关的常量
 *
 */
public class UiConstants {

    /**
     * 软件名称,版本
     */
    public final static String APP_NAME = "Docker-Transfer";
    public final static String APP_VERSION = "v_1.0";

    /**
     * 主窗口大小
     */
    public final static int MAIN_WINDOW_X = 240;
    public final static int MAIN_WINDOW_Y = 100;
    public final static int MAIN_WINDOW_WIDTH = 885;
    public final static int MAIN_WINDOW_HEIGHT = 636;

    /**
     * 系统当前路径
     */
    public final static String CURRENT_DIR = System.getProperty("user.dir");

    /**
     * 主窗口图标
     */
    public final static Image IMAGE_ICON = Toolkit.getDefaultToolkit()
            .getImage(App.class.getResource("/icon/WeSync.png"));

    /**
     * 主窗口背景色
     */
    public final static Color MAIN_BACK_COLOR = Color.WHITE;

    /**
     * 工具栏背景色
     */
    public final static Color TOOL_BAR_BACK_COLOR = new Color(37, 174, 96);
    /**
     * 表格线条背景色
     */
    public final static Color TABLE_LINE_COLOR = new Color(229, 229, 229);

    // 字体
    /**
     * 标题字体
     */
    public final static Font FONT_TITLE = new Font("ds.ui.font.family", 0, 27);
    /**
     * 普通字体
     */
    public final static Font FONT_NORMAL = new Font("ds.ui.font.family", 0, 13);
    /**
     * radio字体
     */
    public final static Font FONT_RADIO = new Font("ds.ui.font.family", 0, 15);

    // 样式布局相关
    /**
     * 主面板水平间隔
     */
    public final static int MAIN_H_GAP = 25;
    /**
     * 主面板Label 大小
     */
    public final static Dimension LABLE_SIZE = new Dimension(1300, 30);
    /**
     * Item Label 大小
     */
    public final static Dimension LABLE_SIZE_ITEM = new Dimension(78, 30);
    /**
     * Item text field 大小
     */
    public final static Dimension TEXT_FIELD_SIZE_ITEM = new Dimension(400, 24);
    /**
     * radio 大小
     */
    public final static Dimension RADIO_SIZE = new Dimension(1300, 60);
    /**
     * 高级选项面板Item 大小
     */
    public final static Dimension PANEL_ITEM_SIZE = new Dimension(1300, 40);

    /**
     * 设置 默认
     */
    public final static ImageIcon ICON_SETTING = new ImageIcon(
            App.class.getResource("/icon/setting.png"));
    /**
     * 设置 激活
     */
    public final static ImageIcon ICON_SETTING_ENABLE = new ImageIcon(
        App.class.getResource("/icon/settingEnable.png"));

    /**
     * 下载 默认
     */
    public final static ImageIcon ICON_DOWNLOAD = new ImageIcon(
        App.class.getResource("/icon/download.png"));
    /**
     * 下载 激活
     */
    public final static ImageIcon ICON_DOWNLOAD_ENABLE = new ImageIcon(
        App.class.getResource("/icon/downloadEnable.png"));

    /**
     * 上传 默认
     */
    public final static ImageIcon ICON_UPLOAD = new ImageIcon(
        App.class.getResource("/icon/upload.png"));
    /**
     * 上传 激活
     */
    public final static ImageIcon ICON_UPLOAD_ENABLE = new ImageIcon(
        App.class.getResource("/icon/uploadEnable.png"));

    /**
     * 执行 默认
     */
    public final static ImageIcon ICON_EXECUTE = new ImageIcon(
        App.class.getResource("/icon/execute.png"));
    /**
     * 执行 激活
     */
    public final static ImageIcon ICON_EXECUTE_ENABLE = new ImageIcon(
        App.class.getResource("/icon/executeEnable.png"));

}