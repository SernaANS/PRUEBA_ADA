package com.example.prueba_ada.mapper;

import com.example.prueba_ada.dto.CompanyDTO;
import com.example.prueba_ada.entity.Company;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-03T18:04:37-0500",
    comments = "version: 1.6.0, compiler: javac, environment: Java 20.0.2.1 (Amazon.com Inc.)"
)
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public CompanyDTO entityToDto(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyDTO.CompanyDTOBuilder companyDTO = CompanyDTO.builder();

        if ( company.getIdCompany() != null ) {
            companyDTO.idCompany( String.valueOf( company.getIdCompany() ) );
        }
        companyDTO.codigoCompany( company.getCodigoCompany() );
        companyDTO.nameCompany( company.getNameCompany() );
        companyDTO.descriptionCompany( company.getDescriptionCompany() );

        return companyDTO.build();
    }

    @Override
    public List<CompanyDTO> entityDtoList(List<Company> company) {
        if ( company == null ) {
            return null;
        }

        List<CompanyDTO> list = new ArrayList<CompanyDTO>( company.size() );
        for ( Company company1 : company ) {
            list.add( entityToDto( company1 ) );
        }

        return list;
    }

    @Override
    public Company dtoToEntity(CompanyDTO company) {
        if ( company == null ) {
            return null;
        }

        Company company1 = new Company();

        if ( company.getIdCompany() != null ) {
            company1.setIdCompany( Long.parseLong( company.getIdCompany() ) );
        }
        company1.setCodigoCompany( company.getCodigoCompany() );
        company1.setNameCompany( company.getNameCompany() );
        company1.setDescriptionCompany( company.getDescriptionCompany() );

        return company1;
    }
}
