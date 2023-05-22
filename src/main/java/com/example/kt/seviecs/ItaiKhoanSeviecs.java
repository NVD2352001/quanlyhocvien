package com.example.kt.seviecs;

import com.example.kt.model.khoaHoc;
import com.example.kt.model.taiKhoan;

import java.util.List;

public interface ItaiKhoanSeviecs {
    public taiKhoan addtaikhoan(taiKhoan tk);
    public taiKhoan remaketaikhoan(taiKhoan tksua);
    public void removetaikhoan(int id);
    public taiKhoan gettaikhoan(int id);

    public List<taiKhoan> timkiemtk(String tentk);
    public List<taiKhoan> gettaikhoanByPage(int pageNumber, int pageSize);
}
