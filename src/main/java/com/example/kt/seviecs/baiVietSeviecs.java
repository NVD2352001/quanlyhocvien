package com.example.kt.seviecs;

import com.example.kt.model.baiViet;
import com.example.kt.model.khoaHoc;
import com.example.kt.reposive.baiVietRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class baiVietSeviecs implements IbaiVietSeviecs{
    @Autowired
    private baiVietRepo baiVietRepo;

    @Override
    public baiViet addbaiviet(baiViet bv) {
        baiVietRepo.save(bv);
        return bv;
    }

    @Override
    public baiViet remakebaiviet(baiViet bvsua) {
        Optional<baiViet> baiviet= baiVietRepo.findById(bvsua.getBaiVietid());
        if(baiviet.isEmpty()){
            return  null;
        }
        baiViet bv=baiviet.get();
        bv.setTenBAiviet(bvsua.getTenBAiviet());
       baiVietRepo.save(bv);
        return bv;
    }

    @Override
    public void removebaiviet(int id) {
        Optional<baiViet> bv= baiVietRepo.findById(id);
        if(bv.isEmpty()){
            return ;
        }
       baiVietRepo.delete(bv.get());
    }

    @Override
    public baiViet getbaiviet(int id) {
        Optional<baiViet> bv= baiVietRepo.findById(id);
        if(bv.isEmpty()){
            return null;
        }
        return bv.get();
    }

    @Override
    public List<baiViet> timkiem(String tenbv) {
        List<baiViet> lst= new ArrayList<baiViet>();
        for(baiViet x: baiVietRepo.findAll()){
            if(x.getTenBAiviet().toLowerCase().contains(tenbv.toLowerCase())){
                lst.add(x);
            }
        }
        return lst;
    }

    @Override
    public List<baiViet> getbaivietByPage(int pageNumber, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNumber, pageSize);
        List<baiViet> result=baiVietRepo.findAll(PageRequest.of(pageNumber, pageSize)).toList();
        //page<khoaHoc> result =  khoaHocRepo.findAll((org.springframework.data.domain.Pageable) pageable);
        return result;
    }
}
