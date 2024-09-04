package com.example.prueba_ada.repository;

import com.example.prueba_ada.entity.Company;
import com.example.prueba_ada.entity.VersionCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VersionCompanyRepository extends JpaRepository<VersionCompany,Long> {

    @Query("""
            SELECT c FROM Company c
            INNER JOIN VersionCompany vc ON c.idCompany= vc.versionCompanyId
            INNER JOIN Version ve ON vc.versionId.versionId = ve.versionId
            INNER JOIN Application  a ON ve.appId.appId = a.appId
            WHERE c.codigoCompany = :codigo
            """)
    Optional<VersionCompany> findByCodigo(String codigo);

    @Query("""
            SELECT c.codigoCompany, a.appName FROM Company c
            INNER JOIN VersionCompany vc ON c.idCompany= vc.versionCompanyId
            INNER JOIN Version ve ON vc.versionId.versionId = ve.versionId
            INNER JOIN Application  a ON ve.appId.appId = a.appId
            GROUP BY c.codigoCompany, a.appName
            """)
    Optional<List<VersionCompany>> findFilter();
}
