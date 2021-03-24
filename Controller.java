package Project;

import java.util.Random;

public class Controller {
    public static void main(String[] args) {

        IOManager io = new IOManager();
        CPUManager cpu = new CPUManager();
        ProcessCreator creator = new ProcessCreator();
        long end = System.currentTimeMillis() + 300 * 1000; // Current time + 5min 

        for (long i = 0;; ++i) {

            // create process
            // Where is the process ? (IO / CPU)
            // Is process done with its IO or CPU ?
            // Is process completed ?
            // If completed print the time elapsed.
            // Current time < end 
            if (System.currentTimeMillis() < end) {
                Process process = creater.createProcess(new Random().nextInt(100), new Random().nextInt(10),
                        new Random().nextInt(500));
                        // 0 for CPU 
                if(process == null) {

                }
                else if (process.todo().operation == 0) {
                    cpu.add(process);

                } 
                // 1 for IO 
                else if (process.todo().operation == 1) {
                    io.add(process);
                }
            }
            if (cpu.isCompleted()) {
                Process process = cpu.getProcess();
                cpu.removeProcess();
                if (process.todo().operation == 0) {
                    cpu.add(process);
                } else if (process.todo().operation == 1) {
                    io.add(process);
                }
            }
            if (io.isCompleted()) {
                Process process = io.getProcess();
                io.removeProcess();
                if (process.todo().operation == 0) {
                    cpu.add(process);
                } else if (process.todo().operation == 1) {
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
