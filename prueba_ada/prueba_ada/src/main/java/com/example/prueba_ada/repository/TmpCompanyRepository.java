package com.example.prueba_ada.repository;

import com.example.prueba_ada.entity.TmpLlenarCampos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TmpCompanyRepository extends JpaRepository<TmpLlenarCampos,Long> {

}
