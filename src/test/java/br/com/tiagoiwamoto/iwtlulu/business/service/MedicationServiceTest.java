package br.com.tiagoiwamoto.iwtlulu.business.service;

import br.com.tiagoiwamoto.iwtlulu.entity.Medication;
import br.com.tiagoiwamoto.iwtlulu.exception.MedicationCreationException;
import br.com.tiagoiwamoto.iwtlulu.exception.MedicationDeleteException;
import br.com.tiagoiwamoto.iwtlulu.exception.MedicationRecoverException;
import br.com.tiagoiwamoto.iwtlulu.repository.MedicationRepository;
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
 * 12/05/2021 | 08:07
 */

@RunWith(SpringRunner.class)
public class MedicationServiceTest {

    @InjectMocks
    private MedicationService medicationService;
    @Mock
    private MedicationRepository medicationRepository;

    @Test
    public void saveMedication() {
        Mockito.when(this.medicationRepository.save(Mockito.any())).thenReturn(new Medication());
        Assert.assertNotNull(this.medicationService.saveMedication(new Medication()));
    }

    @Test(expected = MedicationCreationException.class)
    public void saveMedicationException() {
        Mockito.when(this.medicationRepository.save(Mockito.any())).thenThrow(NullPointerException.class);
        this.medicationService.saveMedication(new Medication());
    }

    @Test
    public void recoverLastMedications() {
        Mockito.when(this.medicationRepository.findTop100ByStatus(Mockito.any())).thenReturn(new ArrayList<>());
        Assert.assertEquals(0, this.medicationService.recoverLastMedications().size());
    }

    @Test(expected = MedicationRecoverException.class)
    public void recoverLastMedicationsException() {
        Mockito.when(this.medicationRepository.findTop100ByStatus(Mockito.any())).thenThrow(NullPointerException.class);
        this.medicationService.recoverLastMedications();
    }

    @Test
    public void searchMedications() {
        Mockito.when(this.medicationRepository.findAllByCommercialNameLike(Mockito.anyString())).thenReturn(new ArrayList<>());
        Assert.assertEquals(0, this.medicationService.searchMedications("name").size());
    }

    @Test(expected = MedicationRecoverException.class)
    public void searchMedicationsException() {
        Mockito.when(this.medicationRepository.findAllByCommercialNameLike(Mockito.anyString())).thenThrow(NullPointerException.class);
        this.medicationService.searchMedications("name");
    }

    @Test
    public void removeMedication() {
        Mockito.doNothing().when(this.medicationRepository).deleteById(Mockito.anyLong());
        this.medicationService.removeMedication(1L);
    }

    @Test(expected = MedicationDeleteException.class)
    public void removeMedicationException() {
        Mockito.doThrow(NullPointerException.class).when(this.medicationRepository).deleteById(Mockito.anyLong());
        this.medicationService.removeMedication(1L);
    }
}
