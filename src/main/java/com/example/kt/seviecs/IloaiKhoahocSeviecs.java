package com.example.kt.seviecs;

import com.example.kt.model.loaiKhoahoc;

public interface IloaiKhoahocSeviecs {
    public loaiKhoahoc addloaikhoahoc(loaiKhoahoc lkh);
    public loaiKhoahoc remakeloaikhoahoc(loaiKhoahoc lkhsua);
    public void removeloaikhoahoc(int id);
}
