package com.example.k3517035.mrifqyabdallah.uas.dto;

import java.util.Date;

public class PresensiDto {
    private Integer id;
    private Date waktu_presensi;
    private String keterangan;

    public PresensiDto() {
    }

    public PresensiDto(Integer id, Date waktu_presensi, String keterangan) {
        this.id = id;
        this.waktu_presensi = waktu_presensi;
        this.keterangan = keterangan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

