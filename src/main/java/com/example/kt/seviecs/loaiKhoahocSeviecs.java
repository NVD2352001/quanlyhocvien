package com.example.kt.seviecs;

import com.example.kt.model.loaiKhoahoc;
import com.example.kt.reposive.loaiKhoahocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class loaiKhoahocSeviecs implements IloaiKhoahocSeviecs{
    @Autowired
    private loaiKhoahocRepo loaiKhoahocRepo;

    @Override
    public loaiKhoahoc addloaikhoahoc(loaiKhoahoc lkh) {
        loaiKhoahocRepo.save(lkh);
        return lkh;
    }

    @Override
    public loaiKhoahoc remakeloaikhoahoc(loaiKhoahoc lkhsua) {
        Optional<loaiKhoahoc> loaikhoahoc= loaiKhoahocRepo.findById(lkhsua.getLoaiKhoahocid());
        if(loaikhoahoc.isEmpty()){
            return  null;
        }
        loaiKhoahoc lkh=loaikhoahoc.get();
        lkh.setTenLoai(lkhsua.getTenLoai());
        loaiKhoahocRepo.save(lkh);
        return lkh;
    }

    @Override
    public void removeloaikhoahoc(int id) {
        Optional<loaiKhoahoc> loaikhoahoc= loaiKhoahocRepo.findById(id);
        if(loaikhoahoc.isEmpty()){
            return ;
        }
        loaiKhoahocRepo.delete(loaikhoahoc.get());


    }
}
