package org.ojlang.models;

import lombok.Getter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Represents a memory address (e.g. to jump to).
 * Though this class is a simple wrapper for an `int`, wihtout it the
 * interpreter/executor couldn't tell if an `int` in memory is simply a number
 * to push to PS or is a memory address to jump to.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
@Accessors(fluent = true)
public class MemoryAddress implements Serializable {

  final static private long serialVersionUID = 41600880904248460L;

  @Getter
  private int value;

  public MemoryAddress(int value) {
    this.value = value;
  }

}
