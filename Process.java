package Project;

import java.util.Random;
import java.util.Vector;

public class Process {
    int processID;
    int totalTime;
    int CPUTimeUsed = 0;
    int CPUWaitTime = 0;
    int IOExecTime = 0;
    int IOExtraTime = 0;
    int processStartTime;
    int processEndTime;
    int currentExecution;
    int currentTimeSlot;

    Process() {
        processID = new Random().nextInt();
        totalTime = 0;
        CPUTimeUsed = 0;
        CPUWaitTime = 0;
        IOExecTime = 0;
        IOExtraTime = 0;
        processStartTime = System.currentTimeMillis();
        currentExecution = todo().operation;
        currentTimeSlot = todo().time;
    }

    class Do {
        int operation;
        int time;

        Do(int operation, int time) {
            this.operation = operation;
            this.time = time;
        }
    }

    Do todo() {
        if (new Random().nextInt() % 2 == 0) {
            return new Do(0, new Random().nextInt(100));
        }
        return new Do(1, new Random().nextInt(100));
    }

    int useCPU(int time) {
        return time;
    }

    int useIO(int time) {
        return time;
    }
}
