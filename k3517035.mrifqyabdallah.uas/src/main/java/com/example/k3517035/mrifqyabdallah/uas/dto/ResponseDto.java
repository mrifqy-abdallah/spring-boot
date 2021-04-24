package com.example.k3517035.mrifqyabdallah.uas.dto;

public class ResponseDto<T> {
    private T data;
    private String pesan;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public void setData() {
    }
}
