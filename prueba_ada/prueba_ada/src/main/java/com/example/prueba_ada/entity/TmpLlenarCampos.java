package com.example.prueba_ada.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tmp_llenar_campos")
public class TmpLlenarCampos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(name = "id_company")
    private Long idCompany;

    @Column(name = "codigo_company")
    private String codigoCompany;

    @Column(name = "name_company")
    private String nameCompany;

    @Column(name = "description_company")
    private String descriptionCompany;

    @Column(name = "version_id")
    private Long versionId;

    @Column(name = "app_id")
    private Long appId;

    @Column(name = "version")
    private String version;

    @Column(name = "version_description")
    private String versionDescription;

    @Column(name = "version_company_id")
    private Long versionCompanyId;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "version_company_description")
    private String versionCompanyDescription;

    @Column(name = "app_code")
    private String appCode;

    @Column(name = "app_name")
    private String appName;

    @Column(name = "app_description")
    private String appDescription;

}