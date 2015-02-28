package com.trein.loader;

import com.trein.api.Driver;
import com.trein.api.DriverCommunicationException;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Loader {

    private static final String JAR_PATH = "driver/build/libs/driver-1.0.jar";

    public static void main(String[] args) throws DriverCommunicationException {
        System.out.println("Start JAR loading");

        Loader loader = new Loader();
        Driver driver = loader.loadDriver("com.trein.driver.StdoutDriver");
        driver.sendMessage("Simple Message");
        driver.sendMessage("Simple Message2");
        driver.sendMessage("Simple Message3");
    }

    @SuppressWarnings("unchecked")
    public Driver loadDriver(String className) {
        Driver driver = null;
        try {
            File jar = new File(JAR_PATH);
            URLClassLoader child = new URLClassLoader(new URL[]{jar.toURI().toURL()}, getClass().getClassLoader());
            Class<Driver> classToLoad = (Class<Driver>) Class.<Driver>forName(className, true, child);
            driver = classToLoad.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
