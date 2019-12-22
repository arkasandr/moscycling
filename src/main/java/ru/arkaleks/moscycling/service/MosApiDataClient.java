package ru.arkaleks.moscycling.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.arkaleks.moscycling.service.dto.CyclePathDtoJson;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@Service
public class MosApiDataClient {

    @Value("${api.key}")
    private String apiKey;

    public MosApiDataClient(@Value("${api.key}") String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Метод осуществляет получение данных по заданному URL путем конвертации JSON в экземпляры класса MosApiDataClient
     *
     * @param
     * @return List<CyclePathConvert>
     * @throws IOException
     */
    public List<CyclePathDtoJson> getCyclePathDataFromOpenSource() {
       List<CyclePathDtoJson> result = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(
                    new URL("https://apidata.mos.ru/v1/datasets/897/rows?api_key=" + apiKey + "&$top=136"),
                    new TypeReference<List<CyclePathDtoJson>>() {
                    });
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

