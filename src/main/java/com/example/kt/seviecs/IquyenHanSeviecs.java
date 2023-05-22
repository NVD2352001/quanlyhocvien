package com.example.kt.seviecs;

import com.example.kt.model.khoaHoc;
import com.example.kt.model.quyenHan;

import java.util.List;

public interface IquyenHanSeviecs {
    public quyenHan addquyenhan(quyenHan qh);
    public quyenHan remakekhoahoc(quyenHan qhsua);
    public void removequyenhan(int id);
    public quyenHan getquyenhan(int id);
    public List<quyenHan> getquyenhanByPage(int pageNumber, int pageSize);
}
