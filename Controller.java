package Project;

import java.util.Random;

// create process
// Where is the process ? (IO / CPU)
// Is process done with its IO or CPU ?
// Is process completed ?
// If completed print the time elapsed.

public class Controller {
    public static void main(String[] args) {

        IOManager io = new IOManager(); // Initialize IO
        CPUManager cpu = new CPUManager(); // Initialize CPU
        ProcessCreator creator = new ProcessCreator(); // Initialize ProcessCreater
        long end = System.currentTimeMillis() + 300 * 1000; // Final tick for creating process

        while (true) {
            // Current time < end
            if (System.currentTimeMillis() < end) {
                // Creates a process
                Process process = creator.createProcess(new Random().nextInt(100), new Random().nextInt(10),
                        new Random().nextInt(500));
                // If not available null is returned
                if (process == null) {
                    // If null is returned then Do nothing

                } else if (process.todo().operation == 0) {
                    // If operation code is "0" then Add process to CPU queue
                    cpu.add(process);

                } else if (process.todo().operation == 1) {
                    // If operation code is "1" then Add process to IO queue
                    io.add(process);
                }
            }
            // If process has completed its CPU time
            if (cpu.isCompleted()) {
                // Get the process which is completed
                Process process = cpu.getProcess();
                // remove the process from the CPU queue
                cpu.removeProcess();
                // Asking the process what it wants to do ie., CPU or IO
                if (process.todo().operation == 0) {
                    // Operation code is "0" ie., CPU
                    cpu.add(process);
                } else if (process.todo().operation == 1) {
                    // Operation code is "1" ie., IO
                    io.add(process);
                }
            }

            // If process has completed its IO time
            if (io.isCompleted()) {
                // Get the process which is completed
                Process process = io.getProcess();
                // remove the process from the CPU queue
                io.removeProcess();
                // Asking the process what it wants to do ie., CPU or IO
                if (process.todo().operation == 0) {
                    // Operation code is "0" ie., CPU
                    cpu.add(process);
                } else if (process.todo().operation == 1) {
                    // Operation code is "1" ie., IO
                    io.add(process);
                }
            }

            if (io.isEmpty() && cpu.isEmpty() && end < System.currentTimeMillis()) {
                // exit
                break;
            }
        }
    }
}
