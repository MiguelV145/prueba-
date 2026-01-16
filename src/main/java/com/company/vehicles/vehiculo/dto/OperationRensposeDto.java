package com.company.vehicles.vehiculo.dto;

public class OperationRensposeDto {
    private boolean success;
    private String message;

    public OperationRensposeDto() {
    }

    public OperationRensposeDto(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
