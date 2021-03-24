package Project;

public class ProcessCreator {
    long percentageOfIOBoundProcess;
    long processTime;
    long nextProcessTime;
    long timeToCreate = 0;

    private boolean isProcessAvailable() {
        if (System.currentTimeMillis() < timeToCreate) {
            return false;
        }
        return true;
    }
    // 100ms -> 80% -> 80ms IO , 20ms CPU
    Process createProcess(long percentageOfIOBoundProcess, long processTime, long nextProcessTime) {
        if (isProcessAvailable()) {
            this.nextProcessTime = nextProcessTime;
            this.processTime = processTime;
            this.percentageOfIOBoundProcess = percentageOfIOBoundProcess;
            timeToCreate = nextProcessTime + System.currentTimeMillis(); // 500 + 5678 => 6178
            Process process = new Process(percentageOfIOBoundProcess, processTime);
            return process;
        }
        return null;
    }
}