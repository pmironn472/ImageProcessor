package behavior;

import config.ConfigurationProvider;
import processor.ImageProcessor;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class DirectoryObserver {

    private ConfigurationProvider cp;
    private HashMap<String, ImageProcessor> processorsMap;

    public DirectoryObserver(ConfigurationProvider cp) {
        this.cp = cp;
        processorsMap = new HashMap<>();

    }

    public void addFileProcessor(String extention, ImageProcessor ip) {
        ip.setConfigurationProvider(cp);
        processorsMap.put(extention, ip);
    }

    public void observer() throws InterruptedException, IOException {
        File rootDir = new File(cp.get("path.original"));

        //watch loop
        File[] lastFile = {};

        while (true) {
            File[] files = rootDir.listFiles();
            //DETECT IF SMTH CHANGED

            if (files.length != lastFile.length) {
                System.out.println("File found");
                for (File f :
                        files) {
                    System.out.println(" >> " + f);
                    processorsMap.get(".jpg").transfortm(f.getName());
                }


                lastFile = files;
            }

            Thread.sleep(100);
        }
    }
}
