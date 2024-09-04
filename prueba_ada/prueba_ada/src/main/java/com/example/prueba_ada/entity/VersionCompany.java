package com.example.prueba_ada.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(
        name = "version_company"
)
public class VersionCompany implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @Column(name ="version_company_id",unique = true )
    private Long versionCompanyId;

    @OneToOne
    @JoinColumn(name = "company_id")
    private Company companyId;

    @OneToOne
    @JoinColumn(name = "version_id")
    private Version  versionId;

    @Column(name = "version_company_description")
    private String versionCompanyDescription;

}
