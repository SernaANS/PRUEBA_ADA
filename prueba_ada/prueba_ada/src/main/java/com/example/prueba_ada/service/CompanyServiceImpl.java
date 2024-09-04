package com.example.prueba_ada.service;

import com.example.prueba_ada.dto.CompanyDTO;
import com.example.prueba_ada.dto.CompanyDTOResponse;
import com.example.prueba_ada.entity.Company;
import com.example.prueba_ada.entity.VersionCompany;
import com.example.prueba_ada.mapper.CompanyMapper;
import com.example.prueba_ada.repository.CompanyRepository;
import com.example.prueba_ada.repository.VersionCompanyRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CompanyServiceImpl implements  CompanyService{

    private CompanyRepository companyRepository;

    private VersionCompanyRepository versionCompanyRepository;

    private CompanyMapper companyMapper;
    @Override

    public List<CompanyDTO> getCompanys() {
        return companyMapper.entityDtoList(companyRepository.findAll());
    }

    public List<VersionCompany> getFilterCompanys() {
        return versionCompanyRepository.findFilter().get();
    }
    @Override
    public CompanyDTOResponse getCompany(String codigoCompany) {
        Optional<VersionCompany> company=versionCompanyRepository.findByCodigo(codigoCompany);
        if (!company.isPresent()){
            return null;
        }

        //todo falta cuadrar el get

        CompanyDTOResponse.builder()
                .codigo_company(company.get().getCompanyId().getNameCompany())
                .name_company(company.get().getCompanyId().getNameCompany())
                .app_name(company.get().getVersionId().getAppId().getAppName())
                .version(company.get().getVersionId().getVersionName())
                .build();

        return null;
    }

    @Override
    @Transactional
    public CompanyDTO saveCompany(CompanyDTO companyDTO) {
        companyDTO.setIdCompany(null);
        return companyMapper.entityToDto(companyRepository.save(companyMapper.dtoToEntity(companyDTO)));
    }

    @Override
    @Transactional
    public String deleteCompany(Long id) {

        Optional<Company> company=companyRepository.findById(id);
        if(!company.isPresent()){
            throw  new RuntimeException("Error en encontrar el comapny");
        }
        companyRepository.deleteById(id);

        return "Company eliminada correctamente";
    }

    @Override
    @Transactional
    public CompanyDTO updateCompany(CompanyDTO companyDTO) {
        Optional<Company> company=companyRepository.findByCodigoCompany(companyDTO.getCodigoCompany());
        if (!company.isPresent()){
            throw  new RuntimeException("Error La compañia a editar no existe");
        }


        Company newCompany= companyMapper.dtoToEntity(companyDTO);
        newCompany.setIdCompany(company.get().getIdCompany());
        return companyMapper.entityToDto(companyRepository.save(newCompany));
    }
}
