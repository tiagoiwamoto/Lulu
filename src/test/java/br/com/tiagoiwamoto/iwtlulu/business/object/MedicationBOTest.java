package br.com.tiagoiwamoto.iwtlulu.business.object;

import br.com.tiagoiwamoto.iwtlulu.business.service.MedicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 11/05/2021 | 20:35
 */

@RunWith(SpringRunner.class)
public class MedicationBOTest {

    @InjectMocks
    private MedicationBO medicationBO;
    @Mock
    private MedicationService medicationService;

    @Test
    public void performMedicationCreation() {
    }

    @Test
    public void performRecoverMedications() {
    }

    @Test
    public void performRemoveMedications() {
    }
}
