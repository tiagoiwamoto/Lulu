package br.com.tiagoiwamoto.iwtlulu.model;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 15/02/2021 | 21:07
 */


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Its a simple DTO with automatic protocol and timestamp.
 * Follow the jsonapi model
 * @param <T> specified the object you want to use here.
 */
public class ApiDTO<T> implements Serializable {

    private static final long serialVersionUID = -3834803335741634479L;

    private String code;
    private String message;
    private T details;
    private String protocol;
    private LocalDateTime timestamp;

    public ApiDTO() { }

    public ApiDTO(String code, String message, T details) {
        this.code = code;
        this.message = message;
        this.details = details;
        this.protocol = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now();
    }

    public ApiDTO<T> withCode(String code) {
        this.code = code;
        return this;
    }

    public ApiDTO<T> withMessage(String message) {
        this.message = message;
        return this;
    }

    public ApiDTO<T> withDetail(T detail) {
        this.details = detail;
        return this;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getDetails() {
        return details;
    }

    public String getProtocol() {
        return protocol;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiDTO{");
        sb.append("code='").append(code).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", detail=").append(details);
        sb.append(", protocol='").append(protocol).append('\'');
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }
}
