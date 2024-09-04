package com.example.prueba_ada.mapper;


import com.example.prueba_ada.dto.CompanyDTO;
import com.example.prueba_ada.entity.Company;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyDTO entityToDto(Company company);

    List<CompanyDTO> entityDtoList(List<Company> company);

    Company dtoToEntity(CompanyDTO company);
}
