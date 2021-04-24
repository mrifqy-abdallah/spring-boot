package com.example.k3517035.mrifqyabdallah.uas.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "presensi")
@NamedQueries({
    @NamedQuery(name = "Presensi.findAll", query = "SELECT p FROM Presensi p")
    , @NamedQuery(name = "Presensi.findById", query = "SELECT p FROM Presensi p WHERE p.id = :id")
    , @NamedQuery(name = "Presensi.findByWaktuPresensi", query = "SELECT p FROM Presensi p WHERE p.waktuPresensi = :waktuPresensi")
    , @NamedQuery(name = "Presensi.findByKeterangan", query = "SELECT p FROM Presensi p WHERE p.keterangan = :keterangan")})
public class Presensi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "waktu_presensi")
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuPresensi;
    @Basic(optional = false)
    @Column(name = "keterangan")
    private String keterangan;
    @JoinColumn(name = "siswa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Siswa siswaId;

    public Presensi() {
    }

    public Presensi(Integer id) {
        this.id = id;
    }

    public Presensi(Integer id, Date waktuPresensi, String keterangan) {
        this.id = id;
        this.waktuPresensi = waktuPresensi;
        this.keterangan = keterangan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getWaktuPresensi() {
        return waktuPresensi;
    }

    public void setWaktuPresensi(Date waktuPresensi) {
        this.waktuPresensi = waktuPresensi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Siswa getSiswaId() {
        return siswaId;
    }

    public void setSiswaId(Siswa siswaId) {
        this.siswaId = siswaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presensi)) {
            return false;
        }
        Presensi other = (Presensi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Presensi[ id=" + id + " ]";
    }
    
}
