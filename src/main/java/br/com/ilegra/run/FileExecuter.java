package br.com.ilegra.run;

import br.com.ilegra.config.FileConfig;
import br.com.ilegra.strategy.FlatDataStrategy;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileExecuter {

    public static void run() {

        File fileDirIn = new File(FileConfig.FILE_DIR_IN);

        FileFilter filterIn = pathname -> pathname.isFile() && !getProcessedFiles().contains(pathname.getName()) && pathname.getName().endsWith(".dat");
        Map<Class, List> mapFlatData = new HashMap<>();

        FlatDataStrategy strategy = new FlatDataStrategy();

        for (File fileFlatData : fileDirIn.listFiles(filterIn)) {
            try {
                List<String> lines = Files.readAllLines(fileFlatData.toPath(), Charset.defaultCharset());
                for (String flatData : lines) {
                    putInMap(mapFlatData, strategy.getClassFlat(flatData), strategy.process(flatData));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            File processedFile = new File(FileConfig.FILE_DIR_OUT + File.separator + fileFlatData.getName().replace(".dat", ".done") + ".dat");
            try {
                processedFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            DataProcessor.execute(mapFlatData, fileFlatData.getName());
            mapFlatData.clear();
        }


    }

    private static List<String> getProcessedFiles() {
        File fileDirOut = new File(FileConfig.FILE_DIR_OUT);

        FileFilter filterOut = pathname -> pathname.isFile() && pathname.getName().endsWith(".done.dat");

        List<String> processedFiles = new ArrayList<>();
        for (File processedFile : fileDirOut.listFiles(filterOut)) {
            processedFiles.add(processedFile.getName().replace(".done", ""));
        }

        return processedFiles;
    }

    private static void putInMap(Map<Class, List> map, Class clazz, Object obj) {
        List list;

        if (map.containsKey(clazz)) {
            list = map.get(clazz);
        } else {
            list = new ArrayList<>();
        }

        list.add(obj);
        map.put(clazz, list);
    }


}
