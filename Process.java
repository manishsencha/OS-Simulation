package Project;

import java.util.Random;
import java.util.Vector;

public class Process {
    int processID;
    long totalTime;
    long CPUTimeUsed = 0;
    long CPUWaitTime = 0;
    long IOExecTime = 0;
    long IOExtraTime = 0;
    long processStartTime;
    long processEndTime;
    long currentExecution;
    long currentTimeSlot;

    Process(long percentageOfIOBoundProcess, long processTime) {
        processID = new Random().nextInt();
        totalTime = processTime;
        CPUTimeUsed = 0;
        CPUWaitTime = 0;
        IOExecTime = 0;
        IOExtraTime = 0;
        processStartTime = System.currentTimeMillis();
        currentExecution = todo().operation;
        currentTimeSlot = todo().time;
    }

    class Do {
        long operation;
        long time;

        Do(long operation, long time) {
            this.operation = operation;
            this.time = time;
        }
    }

    Do todo() {
        long time = new Random().nextInt(100);
        if (time > totalTime - CPUTimeUsed - IOExecTime) {
            time = totalTime - CPUTimeUsed - IOExecTime;
        }
        if (new Random().nextInt() % 2 == 0) {
            CPUTimeUsed += time;
            return new Do(0, time);
        }
        IOExecTime += time;
        return new Do(1, time);
    }

    long useCPU(long time) {
        return time;
    }

    long useIO(long time) {
        return time;
    }
}
