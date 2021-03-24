package Project;

public class ProcessCreator {
    int percentageOfIOBoundProcess;
    int processRate;
    int nextProcessTime;
    int timeToCreate = 0;

    private boolean isProcessAvailable() {
        if (System.currentTimeMillis() < timeToCreate) {
            return false;
        }
        return true;
    }

    Process createProcess(int percentageOfIOBoundProcess, int processRate, int nextProcessTime) {
        if (isProcessAvailable()) {
            this.nextProcessTime = nextProcessTime;
            this.processRate = processRate;
            this.percentageOfIOBoundProcess = percentageOfIOBoundProcess;
            timeToCreate = nextProcessTime + System.currentTimeMillis(); // 500 + 5678 => 6178
            Process process = new Process();
            return process;
        }
        return null;
    }
}