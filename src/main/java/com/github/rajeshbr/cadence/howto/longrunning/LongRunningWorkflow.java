package com.github.rajeshbr.cadence.howto.longrunning;

import com.uber.cadence.workflow.QueryMethod;
import com.uber.cadence.workflow.SignalMethod;
import com.uber.cadence.workflow.WorkflowMethod;

public interface LongRunningWorkflow {

  @WorkflowMethod(
    taskList = LongRunningWorker.LONGRUNNINGTASK,
    executionStartToCloseTimeoutSeconds = 3000000
  )
  void execute();

  @SignalMethod
  void incrementProcessedCount();

  @QueryMethod
  Integer getProcessedCount();
}
