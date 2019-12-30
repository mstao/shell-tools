package me.mingshan.tool.shell.util.propertys;

/**
 * Interface that providers the common methods to get configuration.
 *
 * @param <T> the generics class
 * @author mingshan
 */
public interface Property<T> {
  /**
   * Gets the value of property.
   *
   * @return the value
   */
  T get();

  /**
   * Gets the name of property.
   *
   * @return the name
   */
  String getName();
}
