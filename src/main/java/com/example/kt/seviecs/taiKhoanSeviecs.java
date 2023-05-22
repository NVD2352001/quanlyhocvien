package com.example.kt.seviecs;

import com.example.kt.model.khoaHoc;
import com.example.kt.model.taiKhoan;
import com.example.kt.reposive.taiKhoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class taiKhoanSeviecs implements ItaiKhoanSeviecs{
    @Autowired
    private taiKhoanRepo taiKhoanRepo;

    @Override
    public taiKhoan addtaikhoan(taiKhoan tk) {
        taiKhoanRepo.save(tk);
        return tk;
    }

    @Override
    public taiKhoan remaketaikhoan(taiKhoan tksua) {
        Optional<taiKhoan> taikhoan= taiKhoanRepo.findById(tksua.getTaiKhoanid());
        if(taikhoan.isEmpty()){
            return  null;
        }
        taiKhoan tk=taikhoan.get();
        tk.setTaiKhoan(tksua.getTaiKhoan());
        taiKhoanRepo.save(tk);
        return tk;
    }

    @Override
    public void removetaikhoan(int id) {
        Optional<taiKhoan> taikhoan= taiKhoanRepo.findById(id);
        if(taikhoan.isEmpty()){
            return ;
        }
        taiKhoanRepo.delete(taikhoan.get());
    }

    @Override
    public taiKhoan gettaikhoan(int id) {
        Optional<taiKhoan> taikhoan= taiKhoanRepo.findById(id);
        if(taikhoan.isEmpty()){
            return null;
        }
        return taikhoan.get();
    }

    @Override
    public List<taiKhoan> timkiemtk(String tentk) {
        List<taiKhoan> lst= new ArrayList<taiKhoan>();
        for(taiKhoan x: taiKhoanRepo.findAll()){
            if(x.getTaiKhoan().toLowerCase().contains(tentk.toLowerCase())){
                lst.add(x);
            }
        }
        return lst;
    }

    @Override
    public List<taiKhoan> gettaikhoanByPage(int pageNumber, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNumber, pageSize);
        List<taiKhoan> result=taiKhoanRepo.findAll(PageRequest.of(pageNumber, pageSize)).toList();
        return result;
    }
}
