package com.hg.community.entry;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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


}
