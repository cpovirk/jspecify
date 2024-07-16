/*
 * Copyright 2015 The JSpecify Authors.
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
package org.jspecify.annotations.otherpackage;

import static org.junit.Assert.assertEquals;
import static org.ops4j.pax.exam.CoreOptions.bundle;
import static org.ops4j.pax.exam.CoreOptions.junitBundles;
import static org.ops4j.pax.exam.CoreOptions.options;

import java.lang.annotation.Target;
import org.jspecify.annotations.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerMethod;

/**
 * @author ben.manes@gmail.com (Ben Manes)
 */
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerMethod.class)
// TODO Is putting this test in a separate package actually important? Maybe not?
public final class OsgiTest {
  @Configuration
  public Option[] config() {
    return options(junitBundles(), bundle("file:" + System.getProperty("jspecify.osgi.jar")));
    // DO NOT MERGE -- COPYRIGHT BEN MANES
  }

  @Test
  public void trivial() {
    assertEquals(1, Nullable.class.getAnnotation(Target.class).value().length);
    // DO NOT MERGE -- COPYRIGHT BEN MANES
  }
}
