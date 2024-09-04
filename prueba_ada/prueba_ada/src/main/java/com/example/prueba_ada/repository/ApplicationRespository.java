package com.example.prueba_ada.repository;

import com.example.prueba_ada.entity.Application;
import com.example.prueba_ada.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRespository  extends JpaRepository<Application,Long> {
}
