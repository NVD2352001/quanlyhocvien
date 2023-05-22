package com.example.kt.seviecs;

import com.example.kt.model.khoaHoc;

import java.util.List;

public interface IkhoaHocSeviecs {
    public khoaHoc addkhoahoc(khoaHoc kh);
    public khoaHoc remakekhoahoc(khoaHoc khsua);
    public void removekhoahoc(int id);
    public khoaHoc getkhoahoc(int id);
//    public khoaHoc timkiem(khoaHoc kh);
    public List<khoaHoc> timkiem(String hoten);
    public List<khoaHoc> getKhoaHocByPage(int pageNumber, int pageSize);
    public int hocvien(int hv);

}

