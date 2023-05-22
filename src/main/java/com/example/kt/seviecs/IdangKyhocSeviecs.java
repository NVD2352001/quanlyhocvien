package com.example.kt.seviecs;

import com.example.kt.model.dangKyhoc;
import com.example.kt.model.hocVien;

import java.time.LocalDate;
import java.util.List;

public interface IdangKyhocSeviecs {
    public LocalDate capNhatNgayketthuc(int DangkyhocID);
    //public void ngay(LocalDate nbd, LocalDate nkt);
    public dangKyhoc adddk(dangKyhoc dk);
    public dangKyhoc remakedk(dangKyhoc dksua);
    public void removdk(int id);
    public dangKyhoc getdk(int id);
    public List<dangKyhoc> getdangkyByPage(int pageNumber, int pageSize);
    public LocalDate ngaybatdau(int dangkyhocid);
}
