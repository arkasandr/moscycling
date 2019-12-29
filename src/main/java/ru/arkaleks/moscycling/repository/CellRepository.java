package ru.arkaleks.moscycling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arkaleks.moscycling.model.Cell;

public interface CellRepository extends JpaRepository<Cell, Integer> {
}

