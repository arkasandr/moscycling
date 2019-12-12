package ru.arkaleks.moscycling.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.arkaleks.moscycling.model.CyclePath;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class CyclePathConvert {

    private static CyclePathConvert stpc = null;
    private String openSourceURL = "https://apidata.mos.ru/v1/datasets/897/rows?api_key=10d4289dc1d35470807639f4a045528b&$top=136";

    /**
     * Метод позволяет получить объект классаж
     * @param
     * @return CyclePathConvert
     * @throws
     */
    public static CyclePathConvert getInstance() {
        if (stpc == null) {
            stpc = new CyclePathConvert();
            return stpc;
        } else {
            return stpc;
        }
    }

    /**
     * Метод осуществляет получение данных по заданному URL путем конвертации JSON в экземпляры класса CyclePathConvert
     * @param
     * @return List<CyclePathConvert>
     * @throws IOException
     */
    public List<CyclePath> getCyclePathDataFromOpenSource() {
        List<CyclePath> result = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(
                    new URL(openSourceURL),
                    new TypeReference<List<CyclePath>>() {
                    });
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

