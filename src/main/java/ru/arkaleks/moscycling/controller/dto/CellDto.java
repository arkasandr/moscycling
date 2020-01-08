package ru.arkaleks.moscycling.controller.dto;

import lombok.Data;
import ru.arkaleks.moscycling.model.PathType;

import java.util.List;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@Data
public class CellDto {

    private int id;
    private List<PathType> pathType;
}
