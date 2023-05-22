package com.example.kt.seviecs;

import com.example.kt.model.chuDe;
import com.example.kt.model.loaiBaiviet;

import java.util.List;

public interface IchuDeSeviecs {
    public chuDe addcd(chuDe cd);
    public chuDe remakecd(chuDe cdsua);
    public void removecd(int id);
    public chuDe getcd(int id);
    public List<chuDe> getcdByPage(int pageNumber, int pageSize);
}
