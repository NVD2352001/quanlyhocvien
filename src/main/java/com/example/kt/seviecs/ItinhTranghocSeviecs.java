package com.example.kt.seviecs;

import com.example.kt.model.khoaHoc;
import com.example.kt.model.tinhTranghoc;

public interface ItinhTranghocSeviecs {
    public tinhTranghoc addtinhtranghoc(tinhTranghoc tth);
    public tinhTranghoc remaketinhtranghoc(tinhTranghoc tthsua);
    public void removetinhtranghoc(int id);
    public tinhTranghoc gettinhtranghoc(int id);

}
