package mains;

import behavior.DirectoryObserver;
import config.ConfigurationProvider;
import processor.ImageProcessor;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws InterruptedException, IOException {

        DirectoryObserver dirObserver = new DirectoryObserver(
                new ConfigurationProvider());

        dirObserver.addFileProcessor(".jpg", new ImageProcessor());
        dirObserver.addFileProcessor(".jpeg", new ImageProcessor());
        dirObserver.addFileProcessor(".png", new ImageProcessor());

        dirObserver.observer();


    }
}
