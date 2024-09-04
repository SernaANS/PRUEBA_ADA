package com.example.prueba_ada.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {

    private String idCompany;
    private String codigoCompany;
    private String nameCompany;
    private String descriptionCompany;
}
