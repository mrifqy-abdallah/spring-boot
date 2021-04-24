package com.example.k3517035.mrifqyabdallah.uas.service;

import com.example.k3517035.mrifqyabdallah.uas.dto.*;
import com.example.k3517035.mrifqyabdallah.uas.entity.Presensi;
import com.example.k3517035.mrifqyabdallah.uas.entity.Siswa;
import com.example.k3517035.mrifqyabdallah.uas.repository.PresensiRepository;
import com.example.k3517035.mrifqyabdallah.uas.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PresensiSiswaService {
    @Autowired
    private PresensiRepository presensiRepository;
    @Autowired
    private SiswaRepository siswaRepository;

    public ResponseDto<SiswaDto> registrasiSiswaBaru(SiswaDto siswaDto){
        Siswa siswa = new Siswa();
        siswa.setNama(siswaDto.getNama());
        siswa.setGender(siswaDto.getGender());
        siswa.setUsername(siswaDto.getUsername());
        siswa.setPassword(siswaDto.getPassword());
        siswa = siswaRepository.save(siswa);

        SiswaDto siswaTeregistrasi = new SiswaDto();
        siswaTeregistrasi.setId(siswa.getId());
        siswaTeregistrasi.setNama(siswa.getNama());
        siswaTeregistrasi.setGender(siswa.getGender());
        siswaTeregistrasi.setUsername(siswa.getUsername());
        siswaTeregistrasi.setPassword(siswa.getPassword());

        ResponseDto<SiswaDto> responseDto = new ResponseDto();
        responseDto.setData(siswaTeregistrasi);
        responseDto.setPesan("Siswa baru berhasil ditambahkan");
        return responseDto;
    }

    public ResponseDto<SiswaDto> loginSiswa(SiswaDto siswaDto){
        ResponseDto<SiswaDto> responseDto = new ResponseDto<>();
        Optional<Siswa> siswaOptional =
                Optional.ofNullable(siswaRepository.cariSiswaDenganUsername(siswaDto.getUsername(), siswaDto.getPassword()));
        if (siswaOptional.isEmpty()){
            responseDto.setPesan("username/password tidak tepat");
        } else {
            Siswa siswa = siswaOptional.get();
            SiswaDto siswaDitemukan = new SiswaDto();
            siswaDitemukan.setId(siswa.getId());
            siswaDitemukan.setNama(siswa.getNama());
            siswaDitemukan.setGender(siswa.getGender());
            siswaDitemukan.setUsername(siswa.getUsername());
            siswaDitemukan.setPassword("*".repeat(siswa.getPassword().length()));
            responseDto.setData(siswaDitemukan);
            responseDto.setPesan("data siswa ditemukan");
        }
        return responseDto;
    }

    public ResponseDto<PresensiDto> presensiSiswa(SiswaPresensiDto siswaPresensiDto){
        ResponseDto<PresensiDto> responseDto = new ResponseDto<>();
        Optional<Siswa> siswaOptional = siswaRepository.findById(siswaPresensiDto.getId());
        if (siswaOptional.isEmpty()){
            responseDto.setPesan("siswa dengan id '" + siswaPresensiDto.getId() + "' tidak ditemukan");
        } else {
            Siswa siswa = siswaOptional.get();
            Presensi presensi = new Presensi();
            presensi.setSiswaId(siswa);
            presensi.setWaktuPresensi(Date.from(Instant.now()));
            presensi.setKeterangan(siswaPresensiDto.getKeterangan());
            presensiRepository.save(presensi);

            PresensiDto presensiSiswa = new PresensiDto();
            presensiSiswa.setId(presensi.getId());
            presensiSiswa.setWaktu_presensi(presensi.getWaktuPresensi());
            presensiSiswa.setKeterangan(presensi.getKeterangan());
            responseDto.setData(presensiSiswa);
            responseDto.setPesan("presensi terhadap siswa dengan nama '" + siswa.getNama() + "' berhasil dilakukan");
        }
        return responseDto;
    }

    public ResponseDto<List<SeluruhPresensiDto>> lihatSeluruhPresensi(){
        ResponseDto<List<SeluruhPresensiDto>> responseDto = new ResponseDto<>();
        List<SeluruhPresensiDto> listPresensi = (List<SeluruhPresensiDto>) presensiRepository.lihatPresensi();
        List<SeluruhPresensiDto> presensiDtoList = new ArrayList<>();
        for (int i = 0; i < listPresensi.size(); i++){
            SeluruhPresensiDto seluruhPresensiDto = new SeluruhPresensiDto();
            seluruhPresensiDto.setId(listPresensi.get(i).getId());
            seluruhPresensiDto.setNama(listPresensi.get(i).getNama());
            seluruhPresensiDto.setWaktu_presensi(listPresensi.get(i).getWaktu_presensi());
            seluruhPresensiDto.setKeterangan(listPresensi.get(i).getKeterangan());
            presensiDtoList.add(seluruhPresensiDto);
        }
        responseDto.setData(presensiDtoList);
        responseDto.setPesan("menampilkan seluruh data presensi");
        return responseDto;
    }
}
