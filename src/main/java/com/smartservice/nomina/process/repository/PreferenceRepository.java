package com.smartservice.nomina.process.repository;

import com.smartservice.nomina.process.model.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferenceRepository extends JpaRepository<Preference, Long> {
}
