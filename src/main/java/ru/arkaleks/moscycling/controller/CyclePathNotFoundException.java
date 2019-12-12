package ru.arkaleks.moscycling.controller;

public class CyclePathNotFoundException extends RuntimeException {

    public CyclePathNotFoundException(int globalId) {
        super("CyclePath with globalId: " + globalId + " not found");
    }
}
