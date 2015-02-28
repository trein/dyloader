package com.trein.api;

public interface Driver {

    boolean sendMessage(String msg) throws DriverCommunicationException;
    boolean receiveMessage(String msg) throws DriverCommunicationException;
}
