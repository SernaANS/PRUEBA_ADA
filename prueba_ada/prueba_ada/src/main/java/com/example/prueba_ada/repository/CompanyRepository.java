package com.example.prueba_ada.repository;


import com.example.prueba_ada.entity.Company;
import com.example.prueba_ada.entity.VersionCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    Optional<Company> findByCodigoCompany(String codigoCompany);

}
