package com.example.k3517035.mrifqyabdallah.uas.dto;

public class SiswaDto {
    private Integer id;
    private String nama;
    private String gender;
    private String username;
    private String password;

    public SiswaDto() {
    }

    public SiswaDto(Integer id, String nama, String gender, String username, String password) {
        this.id = id;
        this.nama = nama;
        this.gender = gender;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
