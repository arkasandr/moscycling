package ru.arkaleks.moscycling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arkaleks.moscycling.model.Cells;

public interface CellsRepository extends JpaRepository<Cells, Integer> {
}

