package ru.arkaleks.moscycling;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GeoDataRepository extends JpaRepository<GeoData, Integer> {
}
