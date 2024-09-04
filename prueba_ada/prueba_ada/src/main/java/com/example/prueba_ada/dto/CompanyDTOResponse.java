package com.example.prueba_ada.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CompanyDTOResponse{
        private String codigo_company;
        private String name_company;
        private String app_name;
        private String version;
}
