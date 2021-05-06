package br.com.tiagoiwamoto.iwtlulu.business.object;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 06/05/2021 | 07:51
 */

import br.com.tiagoiwamoto.iwtlulu.business.service.MedicationService;
import br.com.tiagoiwamoto.iwtlulu.entity.Medication;
import br.com.tiagoiwamoto.iwtlulu.model.ApiDTO;
import br.com.tiagoiwamoto.iwtlulu.model.MedicationStatusEnum;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class MedicationBO {

    private final MedicationService medicationService;

    private static final Integer ZERO = 0;

    public MedicationBO(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    public ApiDTO<Medication> performMedicationCreation(Medication medication){
        medication.setCreatedAt(LocalDateTime.now());
        medication.setStatus(
                medication.getStock() > ZERO
                ? MedicationStatusEnum.IN_STOCK
                : MedicationStatusEnum.OUT_STOCK);
        return new ApiDTO<>("0",
                "Medicação cadastrada com sucesso",
                this.medicationService.saveMedication(medication));
    }

    public ApiDTO<List<Medication>> performRecoverMedications(){
        return new ApiDTO<>(
                "0",
                "Medicações recuperadas com sucesso",
                this.medicationService.recoverLastMedications()
        );
    }
}
