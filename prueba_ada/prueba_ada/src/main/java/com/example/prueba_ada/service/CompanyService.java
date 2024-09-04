package com.example.prueba_ada.service;

import com.example.prueba_ada.dto.CompanyDTO;
import com.example.prueba_ada.dto.CompanyDTOResponse;
import com.example.prueba_ada.entity.Company;
import com.example.prueba_ada.entity.VersionCompany;

import java.util.List;

public interface CompanyService {

    List<CompanyDTO> getCompanys();

    List<VersionCompany> getFilterCompanys();
    CompanyDTOResponse getCompany(String codigoCompany );

    CompanyDTO saveCompany(CompanyDTO companyDTO);

    CompanyDTO updateCompany(CompanyDTO companyDTO);

    String deleteCompany(Long id);


}
