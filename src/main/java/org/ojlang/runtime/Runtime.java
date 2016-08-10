package org.ojlang.runtime;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.val;
import org.ojlang.models.DictionaryImpl;
import org.ojlang.models.MemoryImpl;
import org.ojlang.models.ParamStackImpl;
import org.ojlang.models.ReturnStackImpl;
import org.ojlang.models.contracts.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Oj runtime.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
@Accessors(fluent = true)
public class Runtime implements Serializable {

  final static private long serialVersionUID = 8428732629851491287L;

  @Getter
  private int xp;

  @Getter
  private Dictionary dict;

  @Getter
  private Memory mem;

  @Getter
  private ReturnStack rs;

  @Getter
  private ParamStack ps;

  @Getter
  private int sysMemSize;

  /**
   * Private constructor.  Use `init`.
   */
  private Runtime() {}

  /**
   * Initialises a new instance of Oj runtime.
   * It basically initialises dictionary, return/param stacks with given states,
   * and puts the XT of system words in memory (starting from 0).
   *
   * @see SystemWordsRegistry
   * @param systat system execution state
   * @param sysWords system words
   * @return a new instance of runtime
   */
  static public Runtime init(
    SystemState systat,
    List<SystemWord> sysWords
  ) {
    assert(systat != null && sysWords != null);
    val runtime = new Runtime();
    runtime.mem = systat.mem();
    runtime.dict = systat.dict();
    runtime.rs = systat.rs();
    runtime.ps = systat.ps();
    runtime.xp = systat.xp();
    runtime.sysMemSize = sysWords.size();
    sysWords.forEach(w -> {
      runtime.dict.put(w);
      runtime.mem.add(w.name());
    });
    return runtime;
  }

}