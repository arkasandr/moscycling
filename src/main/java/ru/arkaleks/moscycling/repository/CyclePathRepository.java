package ru.arkaleks.moscycling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arkaleks.moscycling.model.CyclePath;

public interface CyclePathRepository extends JpaRepository<CyclePath, Integer> {
}
