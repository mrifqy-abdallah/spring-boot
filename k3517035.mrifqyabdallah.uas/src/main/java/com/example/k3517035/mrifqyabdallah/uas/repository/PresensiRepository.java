package com.example.k3517035.mrifqyabdallah.uas.repository;

import com.example.k3517035.mrifqyabdallah.uas.dto.PresensiDto;
import com.example.k3517035.mrifqyabdallah.uas.dto.SeluruhPresensiDto;
import com.example.k3517035.mrifqyabdallah.uas.entity.Presensi;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PresensiRepository extends JpaRepository<Presensi, Integer> {
    @Query(value = "select new com.example.k3517035.mrifqyabdallah.uas.dto.SeluruhPresensiDto (p.id, s.nama, " +
            "p.waktuPresensi, p.keterangan) from Presensi p inner join Siswa s on p.siswaId = s")
    List<SeluruhPresensiDto> lihatPresensi();
}
