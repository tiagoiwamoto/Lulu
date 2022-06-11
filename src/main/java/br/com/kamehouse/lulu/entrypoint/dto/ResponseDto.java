package br.com.kamehouse.lulu.entrypoint.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Arrays;

@Getter
public class ResponseDto<T> {

    private String code;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    public static <T> ResponseDto of(HttpStatus status, T data){
        return new ResponseDto(status, data);
    }

    public ResponseDto(HttpStatus statusRecebido, T data) {
        HttpStatus httpStatus = Arrays
                .stream(HttpStatus.values())
                .filter(status -> status == statusRecebido)
                .findFirst()
                .get();
        this.code = String.valueOf(httpStatus.value());
        this.message = httpStatus.getReasonPhrase();
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }
}
