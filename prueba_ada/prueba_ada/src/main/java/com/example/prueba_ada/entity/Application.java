package com.example.prueba_ada.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(
        name = "application"
)
public class Application implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "APP_ID", unique = true)
    private Long appId;

    @Column(name = "APP_CODE")
    private String appCode;
    @Column(name = "APP_NAME")
    private String appName;
    @Column(name = "APP_DESCRIPTION")
    private String appDescription;
}
