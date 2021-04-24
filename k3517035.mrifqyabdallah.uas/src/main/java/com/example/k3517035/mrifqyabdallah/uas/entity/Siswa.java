package com.example.k3517035.mrifqyabdallah.uas.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "siswa")
@NamedQueries({
    @NamedQuery(name = "Siswa.findAll", query = "SELECT s FROM Siswa s")
    , @NamedQuery(name = "Siswa.findById", query = "SELECT s FROM Siswa s WHERE s.id = :id")
    , @NamedQuery(name = "Siswa.findByNama", query = "SELECT s FROM Siswa s WHERE s.nama = :nama")
    , @NamedQuery(name = "Siswa.findByGender", query = "SELECT s FROM Siswa s WHERE s.gender = :gender")
    , @NamedQuery(name = "Siswa.findByUsername", query = "SELECT s FROM Siswa s WHERE s.username = :username")
    , @NamedQuery(name = "Siswa.findByPassword", query = "SELECT s FROM Siswa s WHERE s.password = :password")})
public class Siswa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "siswaId")
    private List<Presensi> presensiList;

    public Siswa() {
    }

    public Siswa(Integer id) {
        this.id = id;
    }

    public Siswa(Integer id, String nama, String gender, String username, String password) {
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

    public List<Presensi> getPresensiList() {
        return presensiList;
    }

    public void setPresensiList(List<Presensi> presensiList) {
        this.presensiList = presensiList;
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
        if (!(object instanceof Siswa)) {
            return false;
        }
        Siswa other = (Siswa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Siswa[ id=" + id + " ]";
    }
    
}
