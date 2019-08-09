package ru.arkaleks.moscycling;

public class CyclePathNotFoundException extends RuntimeException {

    public CyclePathNotFoundException(int globalId) {
        super("CyclePath with globalId: " + globalId + " not found");
    }
}
