package ru.arkaleks.moscycling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arkaleks.moscycling.model.CyclePath;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public interface CyclePathRepository extends JpaRepository<CyclePath, Integer> {
}
