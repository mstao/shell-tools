package me.mingshan.tool.shell.ui.panel;

public enum SideOrder {
  FIRST(1),
  SECOND(2),
  THIRD(3),
  FOURTH(4);

  private int value;

  SideOrder(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
