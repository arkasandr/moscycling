package ru.arkaleks.moscycling.controller;

import java.util.Set;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CyclePathUnSupportedFieldPatchException extends RuntimeException {

    public CyclePathUnSupportedFieldPatchException(Set<String> keys) {
        super("Field" + keys.toString() + " update is not allow.");
    }
}
