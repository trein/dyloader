package com.trein.driver;

import com.trein.api.Driver;
import com.trein.api.DriverCommunicationException;

public class StdoutDriver implements Driver {
    @Override
    public boolean sendMessage(String msg) throws DriverCommunicationException {
        System.out.println("STDOUTDRIVER: " + msg);
        return false;
    }

    @Override
    public boolean receiveMessage(String msg) throws DriverCommunicationException {
        System.out.println("STDOUTDRIVER: " + msg);
        return false;
    }
}
