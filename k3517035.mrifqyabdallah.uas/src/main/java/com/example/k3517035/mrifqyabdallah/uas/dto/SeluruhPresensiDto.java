package com.example.k3517035.mrifqyabdallah.uas.dto;

import java.util.Date;

public class SeluruhPresensiDto {
    private Integer id;
    private String nama;
    private Date waktu_presensi;
    private String keterangan;

    public SeluruhPresensiDto() {
    }

    public SeluruhPresensiDto(Integer id, String nama, Date waktu_presensi, String keterangan) {
        this.id = id;
        this.nama = nama;
        this.waktu_presensi = waktu_presensi;
        this.keterangan = keterangan;
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

    public Date getWaktu_presensi() {
        return waktu_presensi;
    }

    public void setWaktu_presensi(Date waktu_presensi) {
        this.waktu_presensi = waktu_presensi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
