package dev.ricardocruz.financemanager.model;

public class FinanceManagerResponse<T> {
    private boolean success;
    private String message;
    private T data;

    public FinanceManagerResponse() {
    }

    public FinanceManagerResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static class Builder<T> {
        private boolean success;
        private String message;
        private T data;

        public Builder<T> success(boolean success) {
            this.success = success;
            return this;
        }
        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }
        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }
        public FinanceManagerResponse<T> build() {
            return new FinanceManagerResponse<>(success, message, data);
        }
    }

    public static <T> FinanceManagerResponse<T> success(T data) {
        return new FinanceManagerResponse.Builder<T>()
                .success(true)
                .message("Success!")
                .data(data)
                .build();
    }
}
