package com.example.k3517035.mrifqyabdallah.uas.repository;

import com.example.k3517035.mrifqyabdallah.uas.entity.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SiswaRepository extends JpaRepository<Siswa, Integer> {
    @Query("SELECT siswa from Siswa siswa WHERE siswa.username = :uname AND siswa.password = :pwd")
    Siswa cariSiswaDenganUsername(String uname, String pwd);
}
