package br.com.ilegra;

import br.com.ilegra.config.InitializeApp;
import br.com.ilegra.run.ReaderFileRunnable;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        InitializeApp.run();

        (new Thread(new ReaderFileRunnable())).start();

    }
}
