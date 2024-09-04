package com.example.prueba_ada.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter

@Setter
@Entity
@Table(
        name = "company"
)
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_COMPANY",unique = true)
    private  Long idCompany;

    @Column(name = "CODIGO_COMPANY")
    private String codigoCompany;

    @Column(name = "NAME_COMPANY")
    private String nameCompany;

    @Column(name = "DESCRIPTION_COMPANY")
    private String descriptionCompany;
}
