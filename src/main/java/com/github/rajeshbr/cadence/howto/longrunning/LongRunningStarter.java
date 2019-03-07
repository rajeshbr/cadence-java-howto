package com.github.rajeshbr.cadence.howto.longrunning;

import com.uber.cadence.WorkflowExecution;
import com.uber.cadence.client.WorkflowClient;

import static com.github.rajeshbr.cadence.howto.common.Constants.DOMAIN;

public class LongRunningStarter {

  private static WorkflowClient workflowClient = WorkflowClient.newInstance(DOMAIN);

  public static void main(String[] args) throws Exception {

    LongRunningWorkflow workflow = workflowClient.newWorkflowStub(LongRunningWorkflow.class);

    WorkflowExecution execution = WorkflowClient.start(workflow::execute);
    System.out.println("Workflow Id: " + execution.workflowId);
    System.exit(0);
  }
}
