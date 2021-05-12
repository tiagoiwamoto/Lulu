package br.com.tiagoiwamoto.iwtlulu.controller.rest;

import br.com.tiagoiwamoto.iwtlulu.business.object.MedicationBO;
import br.com.tiagoiwamoto.iwtlulu.business.service.MedicationService;
import br.com.tiagoiwamoto.iwtlulu.entity.Medication;
import br.com.tiagoiwamoto.iwtlulu.model.ApiDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoRule;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.Assert.*;


/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 12/05/2021 | 09:38
 */

@RunWith(SpringRunner.class)
public class MedicationRestControllerTest {

    @InjectMocks
    private MedicationRestController medicationRestController;
    @Mock
    private MedicationBO medicationBO;

    @Test
    public void index() {
        Mockito.when(this.medicationBO.performRecoverMedications()).thenReturn(new ApiDTO<>("", "", new ArrayList<>()));
        Assert.assertNotNull(Objects.requireNonNull(this.medicationRestController.index().getBody()).getDetails());
    }

    @Test
    public void search() {
        Mockito.when(this.medicationBO.performSearchMedications(Mockito.anyString())).thenReturn(new ApiDTO<>("", "", new ArrayList<>()));
        Assert.assertNotNull(Objects.requireNonNull(this.medicationRestController.search("name").getBody()).getDetails());
    }

    @Test
    public void create() {
        Mockito.when(this.medicationBO.performMedicationCreation(Mockito.any())).thenReturn(new ApiDTO<>("", "", new Medication()));
        Assert.assertNotNull(Objects.requireNonNull(this.medicationRestController.create(new Medication()).getBody()).getDetails());
    }

    @Test
    public void delete() {
        Mockito.when(this.medicationBO.performRemoveMedications(Mockito.anyLong())).thenReturn(new ApiDTO<>("", "", ""));
        Assert.assertNotNull(Objects.requireNonNull(this.medicationRestController.delete(1L).getBody()).getDetails());
    }
}
