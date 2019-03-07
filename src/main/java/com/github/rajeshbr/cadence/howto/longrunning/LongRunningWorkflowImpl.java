package com.github.rajeshbr.cadence.howto.longrunning;

import com.uber.cadence.workflow.Workflow;

import java.time.Duration;

public class LongRunningWorkflowImpl implements LongRunningWorkflow {

  private Integer total = 10;
  private Integer processed = 0;

  @Override
  public void execute() {

    while (true) {
      Workflow.await(Duration.ofSeconds(10), () -> !(processed < total));
      if (processed >= total) {
        System.out.println("All items processed");
        return;
      }
      System.out.println(
          Workflow.getWorkflowInfo().getWorkflowId() + " :: All items not processed yet!!!");
    }
  }

  @Override
  public void incrementProcessedCount() {
    System.out.println("Incrementing processed count");
    this.processed += 1;
  }

  @Override
  public Integer getProcessedCount() {
    return processed;
  }
}
