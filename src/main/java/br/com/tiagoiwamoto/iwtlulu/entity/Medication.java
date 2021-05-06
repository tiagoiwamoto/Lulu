package br.com.tiagoiwamoto.iwtlulu.entity;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 05/05/2021 | 20:23
 */

import br.com.tiagoiwamoto.iwtlulu.model.MedicationStatusEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_lulu_medications")
@Data
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commercialName;
    @Column(length = 999)
    private String function;
    @Column(length = 999)
    private String actionMechanism;
    @Column(length = 999)
    private String recommendation;
    @Column(length = 999)
    private String againstIndication;
    @Column(length = 999)
    private String reference;
    private MedicationStatusEnum status;
    private Integer stock;
    private LocalDateTime createdAt;

}
