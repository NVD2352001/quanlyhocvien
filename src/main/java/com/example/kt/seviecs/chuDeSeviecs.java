package com.example.kt.seviecs;

import com.example.kt.model.baiViet;
import com.example.kt.model.chuDe;
import com.example.kt.reposive.chuDeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class chuDeSeviecs implements IchuDeSeviecs{
    @Autowired
    private chuDeRepo chuDeRepo;

    @Override
    public chuDe addcd(chuDe cd) {
        chuDeRepo.save(cd);
        return cd;
    }

    @Override
    public chuDe remakecd(chuDe cdsua) {
        Optional<chuDe> cd= chuDeRepo.findById(cdsua.getChuDeid());
        if(cd.isEmpty()){
            return  null;
        }
        chuDe cds=cd.get();
        cds.setTenChude(cdsua.getTenChude());
        chuDeRepo.save(cds);
        return cds;
    }

    @Override
    public void removecd(int id) {
        Optional<chuDe> cd= chuDeRepo.findById(id);
        if(cd.isEmpty()){
            return ;
        }
        chuDeRepo.delete(cd.get());
    }

    @Override
    public chuDe getcd(int id) {
        Optional<chuDe> cd= chuDeRepo.findById(id);
        if(cd.isEmpty()){
            return null;
        }
        return cd.get();
    }

    @Override
    public List<chuDe> getcdByPage(int pageNumber, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNumber, pageSize);
        List<chuDe> result=chuDeRepo.findAll(PageRequest.of(pageNumber, pageSize)).toList();
        //page<khoaHoc> result =  khoaHocRepo.findAll((org.springframework.data.domain.Pageable) pageable);
        return result;
    }
}
