package com.example.prueba_ada.reponse;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CompanyResponse {
    private String codigo_company;
    private String name_company;
    private String app_name;
    private String version;

}
