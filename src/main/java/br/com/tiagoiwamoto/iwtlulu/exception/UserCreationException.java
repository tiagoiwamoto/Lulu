package br.com.tiagoiwamoto.iwtlulu.exception;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 05/05/2021 | 20:31
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Não conseguimos concluír seu registro, tente novamente mais tarde")
public class UserCreationException extends RuntimeException{
}
