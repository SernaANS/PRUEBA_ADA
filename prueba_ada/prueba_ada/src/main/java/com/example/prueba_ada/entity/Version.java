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
        name = "version"
)
public class Version implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "VERSION_ID", unique = true)
    private Long versionId;


    @OneToOne
    @JoinColumn(name = "APP_ID")
    private Application appId;

    @Column(name = "VERSION_NAME")
    private String versionName;

    @Column(name = "VERSION_DESCRIPTION")
    private String versionDescription;



}
