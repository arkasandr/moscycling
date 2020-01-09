package ru.arkaleks.moscycling.controller;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CyclePathNotFoundException extends RuntimeException {

    public CyclePathNotFoundException(int globalId) {
        super("CyclePath with globalId: " + globalId + " not found");
    }
}
