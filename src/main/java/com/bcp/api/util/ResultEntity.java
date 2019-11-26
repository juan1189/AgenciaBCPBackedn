package com.bcp.api.util;

import java.io.Serializable;
import org.springframework.http.HttpStatus;

import com.bcp.api.util.UtilEnum.RESULT_CODE;

@SuppressWarnings({ "unused", "serial" })
public class ResultEntity<T> implements Serializable{
    private HttpStatus status;
    private Integer statusCode;
    private Integer code;
    private String message;
    private T body;
    public ResultEntity() {
    }
    public ResultEntity(HttpStatus status, Integer code, T body) {
        super();
        this.status = status;
        this.code = code;
        this.body = body;
    }
    public ResultEntity(HttpStatus status,Integer statusCode,Integer code, T body) {
        super();
        this.status = status;
        this.statusCode=statusCode;
        this.code = code;
        this.body = body;
    }
    public ResultEntity(HttpStatus status, Integer code) {
        super();
        this.status = status;
        this.code = code;
    }
    public ResultEntity(HttpStatus status, Integer statusCode, Integer code) {
        super();
        this.status = status;
        this.statusCode = statusCode;
        this.code = code;
    }
    public ResultEntity(HttpStatus status, Integer code, String message) {
        super();
        this.status = status;
        this.code = code;
        this.message = message;
    }
    public ResultEntity(HttpStatus status,Integer statusCode,RESULT_CODE code, String message) {
        super();
        this.status = status;
        this.statusCode=statusCode;
        this.code = code.getCode();
        this.message = message;
    }
    public ResultEntity(HttpStatus status,Integer statusCode,Integer code, String message) {
        super();
        this.status = status;
        this.statusCode=statusCode;
        this.code = code;
        this.message = message;
    }
    public ResultEntity(HttpStatus status,Integer statusCode,Integer code,String message,T body) {
        super();
        this.status = status;
        this.statusCode=statusCode;
        this.code = code;
        this.body=body;
        this.message = message;
    }
    public ResultEntity(HttpStatus status,Integer statusCode,RESULT_CODE code,String message,T body) {
        super();
        this.status = status;
        this.statusCode=statusCode;
        this.code = code.getCode();
        this.body=body;
        this.message = message;
    }
    public ResultEntity(HttpStatus status, Integer code, String message, T body) {
        super();
        this.status = status;
        this.code = code;
        this.message = message;
        this.body = body;
    }
    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public Integer getStatusCode() {
        return this.status.value();
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getBody() {
        return body;
    }
    public void setBody(T body) {
        this.body = body;
    }
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}