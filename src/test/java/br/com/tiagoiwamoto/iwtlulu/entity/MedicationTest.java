package br.com.tiagoiwamoto.iwtlulu.entity;

import br.com.tiagoiwamoto.iwtlulu.model.MedicationStatusEnum;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;


/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 12/05/2021 | 09:51
 */

public class MedicationTest {

    @Test
    public void testEntity(){
        Medication medication = new Medication();
        medication.setId(1L);
        medication.setStatus(MedicationStatusEnum.IN_STOCK);
        medication.setCreatedAt(LocalDateTime.now());
        medication.setStock(10);
        medication.setActionMechanism("");
        medication.setAgainstIndication("");
        medication.setCommercialName("");
        medication.setFunction("");
        medication.setRecommendation("");
        medication.setReference("");
        Assert.assertNotNull(medication.getId());
        Assert.assertNotNull(medication.getStatus());
        Assert.assertNotNull(medication.getCreatedAt());
        Assert.assertNotNull(medication.getStock());
        Assert.assertNotNull(medication.getActionMechanism());
        Assert.assertNotNull(medication.getAgainstIndication());
        Assert.assertNotNull(medication.getCommercialName());
        Assert.assertNotNull(medication.getFunction());
        Assert.assertNotNull(medication.getRecommendation());
        Assert.assertNotNull(medication.getReference());
        Assert.assertNotNull(medication.toString());
    }

}
