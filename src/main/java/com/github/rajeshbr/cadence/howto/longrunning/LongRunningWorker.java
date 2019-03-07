package com.github.rajeshbr.cadence.howto.longrunning;

import com.uber.cadence.worker.Worker;

import static com.github.rajeshbr.cadence.howto.common.Constants.DOMAIN;

public class LongRunningWorker {
  static final String LONGRUNNINGTASK = "long-running-task";

  public static void main(String[] args) {

    Worker.Factory factory = new Worker.Factory(DOMAIN);
    final Worker workerForFirstTaskList = factory.newWorker(LONGRUNNINGTASK);

    workerForFirstTaskList.registerWorkflowImplementationTypes(LongRunningWorkflowImpl.class);

    // workerForFirstTaskList.registerActivitiesImplementations(new FirstActivityImpl());

    factory.start();
    System.out.println("Worker started for task list: ... ");
  }
}
