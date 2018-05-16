package br.com.ilegra.run;

public class ReaderFileRunnable implements Runnable {

    public void run() {
        FileExecuter executer = new FileExecuter();
        while(true){
            executer.run();
        }
    }
}
