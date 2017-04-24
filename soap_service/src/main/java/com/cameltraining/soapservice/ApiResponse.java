package com.cameltraining.soapservice;

/**
 * Created by Lenovo on 4/24/2017.
 */
public class ApiResponse {
    int errorCode = 0;
    String error;
    String resultMessage;
    public ApiResponse()
    {

    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
