package com.okursan.author.models.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private T data;
    private String message;
    private int resultCode;

    public ApiResponse<T> error() {
        this.resultCode = HttpStatus.NOT_FOUND.value();
        return this;
    }

    public ApiResponse<T> error(String _message) {
        this.message = _message;
        this.resultCode = HttpStatus.NOT_FOUND.value();
        return this;
    }

    public ApiResponse<T> exception() {
        this.resultCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        return this;
    }

    public ApiResponse<T> success() {
        this.resultCode = HttpStatus.OK.value();
        return this;
    }

    public ApiResponse<T> success(String _message) {
        this.message = _message;
        this.resultCode = HttpStatus.OK.value();
        return this;
    }

    public ApiResponse<T> success(T _data, String _message) {
        this.data = _data;
        this.message = _message;
        this.resultCode = HttpStatus.OK.value();
        return this;
    }
}
