package com.example.kt.seviecs;

import com.example.kt.model.khoaHoc;
import com.example.kt.model.quyenHan;
import com.example.kt.reposive.quyenHanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class quyenHanSeviecs implements IquyenHanSeviecs{
    @Autowired
    private quyenHanRepo quyenHanRepo;

    @Override
    public quyenHan addquyenhan(quyenHan qh) {
        quyenHanRepo.save(qh);
        return qh;
    }

    @Override
    public quyenHan remakekhoahoc(quyenHan qhsua) {
        Optional<quyenHan> quyenhan= quyenHanRepo.findById(qhsua.getQuyenHanid());
        if(quyenhan.isEmpty()){
            return  null;
        }
        quyenHan qh=quyenhan.get();
        qh.setTenQuyenhan(qhsua.getTenQuyenhan());
        quyenHanRepo.save(qh);
        //khoaHocRepo.save(kh);
        return qh;
    }

    @Override
    public void removequyenhan(int id) {
        Optional<quyenHan> qh= quyenHanRepo.findById(id);
        if(qh.isEmpty()){
            return ;
        }
        quyenHanRepo.delete(qh.get());
    }

    @Override
    public quyenHan getquyenhan(int id) {
        Optional<quyenHan> qh= quyenHanRepo.findById(id);
        if(qh.isEmpty()){
            return null;
        }
        return qh.get();
    }

    @Override
    public List<quyenHan> getquyenhanByPage(int pageNumber, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNumber, pageSize);
        List<quyenHan> result=quyenHanRepo.findAll(PageRequest.of(pageNumber, pageSize)).toList();
        //page<khoaHoc> result =  khoaHocRepo.findAll((org.springframework.data.domain.Pageable) pageable);
        return result;
    }
}
