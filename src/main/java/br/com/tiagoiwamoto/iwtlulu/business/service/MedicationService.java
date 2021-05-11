package br.com.tiagoiwamoto.iwtlulu.business.service;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 06/05/2021 | 07:45
 */

import br.com.tiagoiwamoto.iwtlulu.entity.Medication;
import br.com.tiagoiwamoto.iwtlulu.exception.MedicationCreationException;
import br.com.tiagoiwamoto.iwtlulu.exception.MedicationRecoverException;
import br.com.tiagoiwamoto.iwtlulu.model.MedicationStatusEnum;
import br.com.tiagoiwamoto.iwtlulu.repository.MedicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MedicationService {

    private final MedicationRepository medicationRepository;

    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    public Medication saveMedication(Medication medication){
        log.info("starting method saveMedication()");
        try{
            return this.medicationRepository.save(medication);
        }catch (Exception e){
            log.error("Failed to persist data on database", e);
            throw new MedicationCreationException();
        }
    }

    public List<Medication> recoverLastMedications(){
        try{
            return this.medicationRepository.findTop100ByStatus(MedicationStatusEnum.IN_STOCK);
        }catch (Exception e){
            log.error("Failed to recover data from database", e);
            throw new MedicationRecoverException();
        }
    }

    public void removeMedication(Long id){
        try{
            this.medicationRepository.deleteById(id);
        }catch (Exception e){
            log.error("Failed to remove data from database", e);
            throw new MedicationRecoverException();
        }
    }
}
