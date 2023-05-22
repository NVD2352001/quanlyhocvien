package com.example.kt.seviecs;

import com.example.kt.model.hocVien;
import com.example.kt.model.khoaHoc;
import com.example.kt.reposive.hocVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class hocVienSeviecs implements IhocVienseviecs{
    @Autowired
    private hocVienRepo hocVienRepo;

    @Override
    public hocVien addhocvien(hocVien hv) {
       hocVienRepo.save(hv);
        return hv;
    }

    @Override
    public hocVien remakehocvien(hocVien hvsua) {
        Optional<hocVien> hocvien= hocVienRepo.findById(hvsua.getHocVienid());
        if(hocvien.isEmpty()){
            return  null;
        }
        hocVien hv=hocvien.get();
        hv.setHoTen(hvsua.getHoTen());
        hocVienRepo.save(hv);
        return hv;
    }

    @Override
    public void removhocvien(int id) {
        Optional<hocVien> hocvien= hocVienRepo.findById(id);
        if(hocvien.isEmpty()){
            return ;
        }
        hocVienRepo.delete(hocvien.get());

    }

    @Override
    public hocVien gethocvien(int id) {
        Optional<hocVien> hv= hocVienRepo.findById(id);
        if(hv.isEmpty()){
            return null;
        }
        return hv.get();
    }

    @Override
    public List<hocVien> timkiem(String ten, String email) {
        List<hocVien> lst= new ArrayList<hocVien>();
        for(hocVien x: hocVienRepo.findAll()){
            if(x.getHoTen().toLowerCase().contains(ten.toLowerCase())&&
                    x.geteMail().toLowerCase().contains(email.toLowerCase())){
                lst.add(x);
            }
        }
        return lst;
    }

    @Override
    public List<hocVien> gethocvienByPage(int pageNumber, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNumber, pageSize);
        List<hocVien> result=hocVienRepo.findAll(PageRequest.of(pageNumber, pageSize)).toList();
        return result;
    }

    @Override
    public void macdinh(String sdt, String email) {
        List<hocVien> hv=hocVienRepo.findAll();
       for(int i=0;i<hv.size()-1;i++){
          for(int j=i+1;j<hv.size();j++){
              if(hv.get(i).getsĐt()==hv.get(j).getsĐt()&& hv.get(i).geteMail()==hv.get(j).geteMail()){
                  System.out.println("loi trung lap");
              }
          }
       }
    }
}
