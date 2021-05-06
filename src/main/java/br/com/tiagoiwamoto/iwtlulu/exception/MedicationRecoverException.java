package br.com.tiagoiwamoto.iwtlulu.exception;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 06/05/2021 | 07:48
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Não foi possível concluír sua solicitação, tente novamente mais tarde")
public class MedicationRecoverException extends RuntimeException{
}
