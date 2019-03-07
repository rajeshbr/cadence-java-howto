package com.github.rajeshbr.cadence.howto.longrunning;

import com.uber.cadence.client.WorkflowClient;

import static com.github.rajeshbr.cadence.howto.common.Constants.DOMAIN;

public class LongRunningQuery {

  public static void main(String[] args) throws Exception {

    if (args.length < 1) {
      System.out.println("Workflow Id is required to run this program");
      System.exit(0);
    }

    WorkflowClient workflowClient = WorkflowClient.newInstance(DOMAIN);
    LongRunningWorkflow workflow =
        workflowClient.newWorkflowStub(LongRunningWorkflow.class, args[0]);

    System.out.println("Current processed count: " + workflow.getProcessedCount());

    System.exit(0);
  }
}
