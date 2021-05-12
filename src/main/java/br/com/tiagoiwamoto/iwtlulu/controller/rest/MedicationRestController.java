package br.com.tiagoiwamoto.iwtlulu.controller.rest;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 06/05/2021 | 07:59
 */

import br.com.tiagoiwamoto.iwtlulu.business.object.MedicationBO;
import br.com.tiagoiwamoto.iwtlulu.entity.Medication;
import br.com.tiagoiwamoto.iwtlulu.model.ApiDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/api/medications")
public class MedicationRestController {

    private final MedicationBO medicationBO;

    public MedicationRestController(MedicationBO medicationBO) {
        this.medicationBO = medicationBO;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<ApiDTO<List<Medication>>> index(){
        return ResponseEntity.ok(this.medicationBO.performRecoverMedications());
    }

    @GetMapping(path = "/search")
    @ResponseBody
    public ResponseEntity<ApiDTO<List<Medication>>> search(@RequestHeader(name = "x-search-medication") String name){
        return ResponseEntity.ok(this.medicationBO.performSearchMedications(name));
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<ApiDTO<Medication>> create(@RequestBody Medication medication){
        return ResponseEntity.ok(this.medicationBO.performMedicationCreation(medication));
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<ApiDTO<String>> delete(@RequestHeader(name = "x-medication-id") Long id){
        return ResponseEntity.ok(this.medicationBO.performRemoveMedications(id));
    }

}
