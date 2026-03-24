package com.example.Departamentos.repositories;

import com.example.Departamentos.models.DepartModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartRepository extends JpaRepository<DepartModel, Long> {
}
