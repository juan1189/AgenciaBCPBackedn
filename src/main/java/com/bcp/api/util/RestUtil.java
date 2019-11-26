package com.bcp.api.util;

import static com.bcp.api.util.UtilEnum.RESULT_CODE.EMPTY;

import java.util.Map;

import org.springframework.http.HttpStatus;

import com.bcp.api.util.UtilEnum.RESULT_CODE;
import com.bcp.api.util.UtilEnum.RESULT_MESSAGE;


public class RestUtil {    
   
    public static<T> ResultEntity<T> getRestEntityOK(String message,T body){
        return new ResultEntity<>(HttpStatus.OK,RESULT_CODE.OK.getCode(),message,body);
    }
    public static<T> ResultEntity<T> getRestEntityOK(String message){
        return new ResultEntity<>(HttpStatus.OK,HttpStatus.OK.value(),RESULT_CODE.OK.getCode(),message);
    }
    public static<T> ResultEntity<T> getRestEntityOK(T body,String... message){
        
        return new ResultEntity<>(
                HttpStatus.OK,
                HttpStatus.OK.value(),
                RESULT_CODE.OK,
                message.length>0?message[0]:RESULT_MESSAGE.OK.getValue(),
                body
                );
    }
    public static ResultEntity<Map<String,Object>> getRestEntityException(Exception ex){
        return new ResultEntity<Map<String,Object>>(
                HttpStatus.INTERNAL_SERVER_ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                RESULT_CODE.ERROR,ex.getMessage());
    }
    
    public static<T> ResultEntity<T> getRestEntityNoContent(){
        return new ResultEntity<>(
                HttpStatus.NO_CONTENT,
                HttpStatus.NO_CONTENT.value(),
                EMPTY.getCode(),
                RESULT_MESSAGE.EMPTY.getValue()
                );
    }
}