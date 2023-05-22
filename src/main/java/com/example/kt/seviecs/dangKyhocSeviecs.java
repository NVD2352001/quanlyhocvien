package com.example.kt.seviecs;

import com.example.kt.model.dangKyhoc;
import com.example.kt.model.khoaHoc;
import com.example.kt.model.tinhTranghoc;
import com.example.kt.reposive.dangKyhocRepo;
import com.example.kt.reposive.khoaHocRepo;
import com.example.kt.reposive.tinhTranghocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class dangKyhocSeviecs implements IdangKyhocSeviecs{
    @Autowired
    private dangKyhocRepo dangKyhocRepo;
    @Autowired
    private tinhTranghocRepo tinhTranghocRepo;
    @Autowired
    private khoaHocRepo khoaHocRepo;

    @Override
    public LocalDate capNhatNgayketthuc(int DangkyhocID) {
        Optional<dangKyhoc> dangKyHoc = dangKyhocRepo.findById(DangkyhocID);
        if (dangKyHoc.get().getNgayBatdau()==null)
            return null;
        else
            return dangKyHoc.get().getNgayBatdau().plusDays(dangKyHoc.get().getKhoahoc().getThoiGianhoc());
    }

    public LocalDate ngaybatdau(int dangkyhocid){
        Optional<dangKyhoc> dangKyhoc=dangKyhocRepo.findById(dangkyhocid);
        List<tinhTranghoc> tth=tinhTranghocRepo.findAll();
        for(tinhTranghoc x : tth){
            if(x.getTenTinhtrang().toString().equals("đang học chính")){
                return dangKyhoc.get().getNgayBatdau();
            }
        }
        return null;
    }

//    @Override
//    public void ngay(LocalDate nbd, LocalDate nkt) {
//        List<dangKyhoc> dk=dangKyhocRepo.findAll();
//        List<tinhTranghoc> tth=tinhTranghocRepo.findAll();
//        List<khoaHoc> kh = khoaHocRepo.findAll();
//        for(int i=0;i<dk.size();i++){
//            for(int j=0;j<tth.size();j++){
//                for(int z=0;z<kh.size();z++){
//                    if(tth.get(j).getTenTinhtrang().toString()=="đang học chính"){
//                        nbd=dk.get(i).getNgayBatdau();
//                        nkt=capNhatNgayketthuc(dk.get(i).getDangKyhocid());
//                }
//                }
//            }
//        }
 //}

    @Override
    public dangKyhoc adddk(dangKyhoc dk) {
        dk.getHocvien();
        dk.setNgayDangky(LocalDate.now());
        if(tinhTranghocRepo.findById(dk.getTinhtranghoc().getTinhTranghocid()).get().getTenTinhtrang().equals("đang học chính")){
            LocalDate datenow = LocalDate.now();
            dk.setNgayBatdau(datenow);
            dk.setNgayKetthuc((datenow.plusDays(khoaHocRepo.findById(dk.getKhoahoc().getKhoaHocid()).get().getThoiGianhoc())));
        }
        dangKyhocRepo.save(dk);
        return dk;
    }
    @Override
    public dangKyhoc remakedk(dangKyhoc dksua) {
        Optional<dangKyhoc> dangky= dangKyhocRepo.findById(dksua.getDangKyhocid());
        if(dangky.isEmpty()){
            return  null;
        }
        dangky.get().setNgayDangky(dksua.getNgayDangky());
        dangky.get().setNgayBatdau(ngaybatdau(dangky.get().getDangKyhocid()));
        dangky.get().setNgayKetthuc(capNhatNgayketthuc(dangky.get().getDangKyhocid()));
        dangKyhocRepo.save(dangky.get());
        return  dangky.get();
    }

    @Override
    public void removdk(int id) {
        Optional<dangKyhoc> dk= dangKyhocRepo.findById(id);
        if(dk.isEmpty()){
            return ;
        }
       dangKyhocRepo.delete(dk.get());
    }

    @Override
    public dangKyhoc getdk(int id) {
        Optional<dangKyhoc> dk= dangKyhocRepo.findById(id);
        if(dk.isEmpty()){
            return null;
        }
        return dk.get();
    }

    @Override
    public List<dangKyhoc> getdangkyByPage(int pageNumber, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNumber, pageSize);
        List<dangKyhoc> result=dangKyhocRepo.findAll(PageRequest.of(pageNumber, pageSize)).toList();
        //page<khoaHoc> result =  khoaHocRepo.findAll((org.springframework.data.domain.Pageable) pageable);
        return result;
    }
}
