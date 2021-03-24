package Project;

import java.util.LinkedList;
import java.util.Queue;

public class CPUManager {

    // p3, p2, p1(100ms)
    // p1, p5, p4, p3, p2 -> arrival time(System.currentTimeMillis()) + time slot
    // System.currentTimeMillis()

    int waitTime = 0;
    // Queue for storing processes
    Queue<Process> processes = new LinkedList<Process>();
    // Time at which a processes arrived in CPU
    long arrivalTime = System.currentTimeMillis();

    // Method to add a process in CPU
    void add(Process process) {
        processes.add(process);
        waitTime += process.currentTimeSlot;
    }

    // Method to check if the CPU is empty
    boolean isEmpty() {
        if (processes.isEmpty()) {
            return true;
        }
        return false;
    }

    // Method to check if the processes has completed its current time slot
    boolean isCompleted() {
        Process currentProcess = processes.peek();

        if (System.currentTimeMillis() < arrivalTime + currentProcess.currentTimeSlot) {
            return false;
        }
        arrivalTime = System.currentTimeMillis();
        return true;

    }

    // Method to get the Current process in execution
    Process getProcess() {
        return processes.peek();
    }

    // Method to remove the completed process
    void removeProcess() {

        processes.remove();

    }
}