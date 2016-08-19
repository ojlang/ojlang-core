/*
 * Copyright 2016 Bahman Movaqar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ojlang

import org.ojlang.models.SystemStateImpl
import org.ojlang.models.contracts.SystemState

import static org.ojlang.models.ModelFactory.*

/**
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
class TestUtils {

  static SystemState freshSystat() {
    SystemStateImpl.create(
      createMem(),
      createDict(),
      createRS(),
      createPS(),
      0,
      0
    )
  }

}