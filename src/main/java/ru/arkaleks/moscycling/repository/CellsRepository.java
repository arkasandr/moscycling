package ru.arkaleks.moscycling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arkaleks.moscycling.model.Cell;

public interface CellsRepository extends JpaRepository<Cell, Integer> {
}

