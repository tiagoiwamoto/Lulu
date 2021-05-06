package br.com.tiagoiwamoto.iwtlulu.repository;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 05/05/2021 | 20:28
 */

import br.com.tiagoiwamoto.iwtlulu.entity.Medication;
import br.com.tiagoiwamoto.iwtlulu.model.MedicationStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationRepository extends JpaRepository<Medication, Long> {

    List<Medication> findTop100ByStatus(MedicationStatusEnum status);

}
