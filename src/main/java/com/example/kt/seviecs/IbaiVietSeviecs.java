package com.example.kt.seviecs;

import com.example.kt.model.baiViet;
import com.example.kt.model.khoaHoc;

import java.util.List;

public interface IbaiVietSeviecs {
    public baiViet addbaiviet(baiViet bv);
    public baiViet remakebaiviet(baiViet bvsua);
    public void removebaiviet(int id);
    public baiViet getbaiviet(int id);
    public List<baiViet> timkiem(String tenbv);
    public List<baiViet> getbaivietByPage(int pageNumber, int pageSize);
}
