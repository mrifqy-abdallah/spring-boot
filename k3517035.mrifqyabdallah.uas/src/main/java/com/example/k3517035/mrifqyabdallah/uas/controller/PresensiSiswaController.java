package com.example.k3517035.mrifqyabdallah.uas.controller;

import com.example.k3517035.mrifqyabdallah.uas.dto.*;
import com.example.k3517035.mrifqyabdallah.uas.service.PresensiSiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PresensiSiswaController {
    @Autowired
    private PresensiSiswaService presensiSiswaService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto<SiswaDto>> registrasiSiswa(@RequestBody SiswaDto siswaDto){
        ResponseDto response = presensiSiswaService.registrasiSiswaBaru(siswaDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDto<SiswaDto>> loginSiswa(@RequestBody SiswaDto siswaDto){
        ResponseDto response = presensiSiswaService.loginSiswa(siswaDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/presensi")
    public ResponseEntity<ResponseDto<PresensiDto>> presensiSiswa(@RequestBody SiswaPresensiDto siswaPresensiDto){
        ResponseDto response = presensiSiswaService.presensiSiswa(siswaPresensiDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/showall/presensi")
    public ResponseEntity<ResponseDto<List<SeluruhPresensiDto>>> lihatPresensi(){
        ResponseDto<List<SeluruhPresensiDto>> response = presensiSiswaService.lihatSeluruhPresensi();
        return ResponseEntity.ok(response);
    }
}
