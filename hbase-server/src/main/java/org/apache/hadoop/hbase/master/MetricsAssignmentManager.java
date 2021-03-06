/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hbase.master;

import org.apache.hadoop.hbase.CompatibilitySingletonFactory;

public class MetricsAssignmentManager {
  private final MetricsAssignmentManagerSource assignmentManagerSource;

  public MetricsAssignmentManager() {
    assignmentManagerSource = CompatibilitySingletonFactory.getInstance(
        MetricsAssignmentManagerSource.class);
  }

  public MetricsAssignmentManagerSource getMetricsProcSource() {
    return assignmentManagerSource;
  }

  /**
   * set new value for number of regions in transition.
   * @param ritCount
   */
  public void updateRITCount(final int ritCount) {
    assignmentManagerSource.setRIT(ritCount);
  }

  /**
   * update RIT count that are in this state for more than the threshold
   * as defined by the property rit.metrics.threshold.time.
   * @param ritCountOverThreshold
   */
  public void updateRITCountOverThreshold(final int ritCountOverThreshold) {
    assignmentManagerSource.setRITCountOverThreshold(ritCountOverThreshold);
  }

  /**
   * update the timestamp for oldest region in transition metrics.
   * @param timestamp
   */
  public void updateRITOldestAge(final long timestamp) {
    assignmentManagerSource.setRITOldestAge(timestamp);
  }

  /**
   * update the duration metrics of region is transition
   * @param duration
   */
  public void updateRitDuration(long duration) {
    assignmentManagerSource.updateRitDuration(duration);
  }

  /*
   * Increment the count of assignment operation (assign/unassign).
   */
  public void incrementOperationCounter() {
    assignmentManagerSource.incrementOperationCounter();
  }

  /**
   * Add the time took to perform the last assign operation
   * @param time
   */
  public void updateAssignTime(final long time) {
    assignmentManagerSource.updateAssignTime(time);
  }

  /**
   * Add the time took to perform the last unassign operation
   * @param time
   */
  public void updateUnassignTime(final long time) {
    assignmentManagerSource.updateUnassignTime(time);
  }
}
