package br.com.tiagoiwamoto.iwtlulu.business.object;

import br.com.tiagoiwamoto.iwtlulu.business.service.MedicationService;
import br.com.tiagoiwamoto.iwtlulu.entity.Medication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;


/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 12/05/2021 | 07:51
 */

@RunWith(SpringRunner.class)
public class MedicationBOTest {

    @InjectMocks
    private MedicationBO medicationBO;
    @Mock
    private MedicationService medicationService;

    @Test
    public void performMedicationCreation() {
        Medication medication = new Medication();
        medication.setStock(0);
        Mockito.when(this.medicationService.saveMedication(Mockito.any())).thenReturn(new Medication());
        Assert.assertNotNull(this.medicationBO.performMedicationCreation(medication));
        medication.setStock(1000);
        Assert.assertNotNull(this.medicationBO.performMedicationCreation(medication));
    }

    @Test
    public void performRecoverMedications() {
        Mockito.when(this.medicationService.recoverLastMedications()).thenReturn(new ArrayList<>());
        Assert.assertEquals(0, this.medicationBO.performRecoverMedications().getDetails().size());
    }

    @Test
    public void performSearchMedications() {
        Mockito.when(this.medicationService.searchMedications(Mockito.anyString())).thenReturn(new ArrayList<>());
        Assert.assertEquals(0, this.medicationBO.performSearchMedications("").getDetails().size());
    }

    @Test
    public void performRemoveMedications() {
        Mockito.doNothing().when(this.medicationService).removeMedication(Mockito.anyLong());
        Assert.assertNotNull(this.medicationBO.performRemoveMedications(1L));
    }
}
