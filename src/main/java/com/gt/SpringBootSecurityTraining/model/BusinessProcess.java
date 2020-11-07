package com.gt.SpringBootSecurityTraining.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessProcess {

    @Id
    @GeneratedValue
    private UUID id;
    private String processId;
    private String type;
    private String code;
}
