package com.example.kt.seviecs;

import com.example.kt.model.hocVien;
import com.example.kt.model.khoaHoc;
import com.example.kt.model.tinhTranghoc;
import com.example.kt.reposive.hocVienRepo;
import com.example.kt.reposive.khoaHocRepo;
import com.example.kt.reposive.tinhTranghocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class khoaHocSeviecs implements IkhoaHocSeviecs{
    @Autowired
    private khoaHocRepo khoaHocRepo;
    @Autowired
    private hocVienRepo hocVienRepo;
    @Autowired
    private tinhTranghocRepo tinhTranghocRepo;

    @Override
    public khoaHoc addkhoahoc(khoaHoc kh) {
        kh.setSoHocvien(hocvien(khoaHocRepo.findById(kh.getKhoaHocid()).get().getSoHocvien()));
        khoaHocRepo.save(kh);
        return kh;
    }

    @Override
    public khoaHoc remakekhoahoc(khoaHoc khsua) {
        Optional<khoaHoc> khoahoc= khoaHocRepo.findById(khsua.getKhoaHocid());
        if(khoahoc.isEmpty()){
            return  null;
        }
        khoaHoc kh=khoahoc.get();
        kh.setTenKhoahoc(khsua.getTenKhoahoc());
        khoaHocRepo.save(kh);
        return kh;
    }

    @Override
    public void removekhoahoc(int id) {
        Optional<khoaHoc> khoahoc= khoaHocRepo.findById(id);
        if(khoahoc.isEmpty()){
            return ;
        }
        khoaHocRepo.delete(khoahoc.get());
    }

    @Override
    public khoaHoc getkhoahoc(int id) {
        Optional<khoaHoc> khoahoc= khoaHocRepo.findById(id);
        if(khoahoc.isEmpty()){
            return null;
        }
       return khoahoc.get();
    }

//    @Override
//    public khoaHoc timkiem(khoaHoc kh) {
//        Optional<khoaHoc> khs=khoaHocRepo.findById(kh.getKhoaHocid());
//        if(khs.isEmpty()){
//            return  null;
//        }
//        return khs.get();
//    }

    @Override
    public List<khoaHoc> timkiem(String hoten) {
        List<khoaHoc> lst= new ArrayList<khoaHoc>();
        for(khoaHoc x: khoaHocRepo.findAll()){
            if(x.getTenKhoahoc().toLowerCase().contains(hoten.toLowerCase())){
                lst.add(x);
            }
        }
        return lst;
    }

    @Override
    public  List<khoaHoc> getKhoaHocByPage(int pageNumber, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNumber, pageSize);
        List<khoaHoc> result=khoaHocRepo.findAll(PageRequest.of(pageNumber, pageSize)).toList();
        //page<khoaHoc> result =  khoaHocRepo.findAll((org.springframework.data.domain.Pageable) pageable);
        return result;
    }

    @Override
    public int hocvien(int hv) {
        List<hocVien> hocvien= hocVienRepo.findAll();
        List<tinhTranghoc> tth =tinhTranghocRepo.findAll();
        List<khoaHoc> kh=khoaHocRepo.findAll();
        for(int i=0;i<hocvien.size()-1;i++){
                if( tth.get(i).getTenTinhtrang().equals("đang học") && tth.get(i).getTenTinhtrang().equals(" học xong") && tth.get(i).getTenTinhtrang().equals("chưa hoàn thành")){
                   kh.get(i).getSoHocvien();
                }
        }
        return hv;
    }
}

