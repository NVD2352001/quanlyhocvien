package com.example.kt.seviecs;

import com.example.kt.model.hocVien;
import com.example.kt.model.khoaHoc;

import java.util.List;

public interface IhocVienseviecs {
    public hocVien addhocvien(hocVien hv);
    public hocVien remakehocvien(hocVien hv);
    public void removhocvien(int id);
    public hocVien gethocvien(int id);
    public List<hocVien> timkiem(String ten ,String email);
    public List<hocVien> gethocvienByPage(int pageNumber, int pageSize);
    public void macdinh(String sdt, String email);
}
