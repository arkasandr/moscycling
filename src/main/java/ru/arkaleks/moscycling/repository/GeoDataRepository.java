package ru.arkaleks.moscycling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arkaleks.moscycling.model.GeoData;

public interface GeoDataRepository extends JpaRepository<GeoData, Integer> {
}
