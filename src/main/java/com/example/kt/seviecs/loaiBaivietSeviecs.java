package com.example.kt.seviecs;

import com.example.kt.model.khoaHoc;
import com.example.kt.model.loaiBaiviet;
import com.example.kt.reposive.loaiBaivietRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class loaiBaivietSeviecs implements IloaiBaivietSeviecs{
    @Autowired
    private loaiBaivietRepo loaiBaivietRepo;

    @Override
    public loaiBaiviet addlbv(loaiBaiviet lbv) {
        loaiBaivietRepo.save(lbv);
        return lbv;
    }

    @Override
    public loaiBaiviet remakelbv(loaiBaiviet lbvsua) {
        Optional<loaiBaiviet> lbv= loaiBaivietRepo.findById(lbvsua.getLoaiBaivietid());
        if(lbv.isEmpty()){
            return  null;
        }
        loaiBaiviet lbvs=lbv.get();
        lbvs.setTenLoai(lbvsua.getTenLoai());
        loaiBaivietRepo.save(lbvs);
        return lbvs;
    }

    @Override
    public void removelbv(int id) {
        Optional<loaiBaiviet> lbv= loaiBaivietRepo.findById(id);
        if(lbv.isEmpty()){
            return ;
        }
        loaiBaivietRepo.delete(lbv.get());
    }

    @Override
    public loaiBaiviet getlbv(int id) {
        Optional<loaiBaiviet> lbv= loaiBaivietRepo.findById(id);
        if(lbv.isEmpty()){
            return null;
        }
        return lbv.get();
    }

    @Override
    public List<loaiBaiviet> getlbvByPage(int pageNumber, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNumber, pageSize);
        List<loaiBaiviet> result=loaiBaivietRepo.findAll(PageRequest.of(pageNumber, pageSize)).toList();
        //page<khoaHoc> result =  khoaHocRepo.findAll((org.springframework.data.domain.Pageable) pageable);
        return result;
    }
}
