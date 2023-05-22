package com.example.kt.seviecs;

import com.example.kt.model.khoaHoc;
import com.example.kt.model.loaiBaiviet;

import java.util.List;

public interface IloaiBaivietSeviecs {
    public loaiBaiviet addlbv(loaiBaiviet lbv);
    public loaiBaiviet remakelbv(loaiBaiviet lbvsua);
    public void removelbv(int id);
    public loaiBaiviet getlbv(int id);
    public List<loaiBaiviet> getlbvByPage(int pageNumber, int pageSize);
}
