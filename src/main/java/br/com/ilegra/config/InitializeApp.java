package br.com.ilegra.config;

import java.io.File;

public class InitializeApp {
    public static void run(){
        createFolderIfNotExists(new File(FileConfig.FILE_DATA_DIR));
        createFolderIfNotExists(new File(FileConfig.FILE_DIR_IN));
        createFolderIfNotExists(new File(FileConfig.FILE_DIR_OUT));
    }

    private static void createFolderIfNotExists(File file){
        if (!file.exists()){
            file.mkdir();
        }
    }

}
