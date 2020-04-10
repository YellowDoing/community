package com.hg.community.entry;

import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {

    private String message;
    private int code;
    private  T data;


    public static Result failed(String message){
       Result result = new Result();
        result.setCode(150);
        result.setMessage(message);
       return result;
    }

    public static <T> Result<T> success(T data,String message){
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setData(data);
        result.setMessage(message);
        return result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
