package br.com.ilegra.config;

import java.io.File;

public class FileConfig {
    public static final String FILE_DATA_DIR = System.getenv("HOMEPATH") + File.separator + "data";
    public static final String FILE_DIR_IN = FILE_DATA_DIR + File.separator + "in";
    public static final String FILE_DIR_OUT = FILE_DATA_DIR + File.separator + "out";
}
