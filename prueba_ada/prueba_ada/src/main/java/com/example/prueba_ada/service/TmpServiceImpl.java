package com.example.prueba_ada.service;

import com.example.prueba_ada.dto.CompanyDTO;
import com.example.prueba_ada.entity.*;
import com.example.prueba_ada.mapper.CompanyMapper;
import com.example.prueba_ada.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TmpServiceImpl implements  TmpService {

    private TmpCompanyRepository tmpRepository;


    private ApplicationRespository applicationRespository;
    private CompanyRepository companyRepository;
    private VersionCompanyRepository versionCompanyRepository;
    private VersionRepository versionRepository;

    @Override

    public String getTmp() {
        List<TmpLlenarCampos> temp = tmpRepository.findAll();

        for (TmpLlenarCampos data : temp) {

            Company company = Company.builder()
                    .idCompany(data.getIdCompany())
                    .codigoCompany(data.getCodigoCompany())
                    .nameCompany(data.getNameCompany())
                    .descriptionCompany(data.getDescriptionCompany())
                    .build();
            companyRepository.save(company);

            Application application = Application.builder()
                    .appId(data.getAppId())
                    .appCode(data.getAppCode())
                    .appName(data.getAppName())
                    .appDescription(data.getAppDescription())
                    .build();
            applicationRespository.save(application);

            Version version = Version.builder()
                    .versionId(data.getVersionId())
                    .appId(Application.builder().appId(data.getAppId()).build())
                    .versionName(data.getVersion())
                    .versionDescription(data.getVersionDescription())
                    .build();
            versionRepository.save(version);


            VersionCompany versionCompany = VersionCompany.builder()
                    .versionCompanyId(data.getCompanyId())
                    .companyId(Company.builder().idCompany(data.getIdCompany()).build())
                    .versionId(Version.builder().versionId(data.getVersionId()).build())
                    .versionCompanyDescription(data.getVersionCompanyDescription())
                    .build();
            versionCompanyRepository.save(versionCompany);
        }


        return "Exito";
    }
}

////
//INSERT INTO "SYSTEM"."TMP_LLENAR_CAMPOS" (APP_ID, COMPANY_ID, ID, ID_COMPANY, VERSION_COMPANY_ID, VERSION_ID, APP_CODE, APP_DESCRIPTION, APP_NAME, CODIGO_COMPANY, DESCRIPTION_COMPANY, NAME_COMPANY, VERSION, VERSION_COMPANY_DESCRIPTION, VERSION_DESCRIPTION) VALUES ('1', '1', '1', '1', '1', '1', '1', 'WEB', 'INSTRAGRAM', '1212', 'DURS', 'META', 'MK1', 'NOO', 'TTTT')
//        INSERT INTO "SYSTEM"."TMP_LLENAR_CAMPOS" (APP_ID, COMPANY_ID, ID, ID_COMPANY, VERSION_COMPANY_ID, VERSION_ID, APP_CODE, APP_DESCRIPTION, APP_NAME, CODIGO_COMPANY, DESCRIPTION_COMPANY, NAME_COMPANY, VERSION, VERSION_COMPANY_DESCRIPTION, VERSION_DESCRIPTION) VALUES ('2', '1', '2', '2', '2', '2', '2', 'MOBILE', 'LINKEND', '4141', 'NO TENGO MAS ', 'ADA', 'MK2', 'MASS', 'KKK')

