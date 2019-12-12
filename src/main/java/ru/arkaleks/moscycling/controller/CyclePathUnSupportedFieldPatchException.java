package ru.arkaleks.moscycling.controller;

import java.util.Set;

public class CyclePathUnSupportedFieldPatchException extends RuntimeException {

    public CyclePathUnSupportedFieldPatchException(Set<String> keys) {
        super("Field" + keys.toString() + " update is not allow.");
    }
}
