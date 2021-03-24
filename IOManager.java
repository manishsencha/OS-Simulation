package Project;

import java.util.LinkedList;
import java.util.Queue;

public class IOManager {
    // p1, p5, p4, p3, p2 -> arrival time(System.currentTimeMillis()) + time slot >
    // System.currentTimeMillis()
    Queue<Process> processes = new LinkedList<Process>();
    long arrivalTime = System.currentTimeMillis();

    void add(Process process) {
        processes.add(process);
    }
    
    boolean isEmpty() {
        if (processes.isEmpty()) {
            return true;
        }
        return false;
    }
    boolean isCompleted() {
        Process currentProcess = processes.peek();
        if (System.currentTimeMillis() < arrivalTime + currentProcess.currentTimeSlot) {
            return false;
        }
        arrivalTime = System.currentTimeMillis();
        return true;
    }
    Process getProcess() {
        return processes.peek();
    }
    Process removeProcess() {
        return processes.remove();
    }
}