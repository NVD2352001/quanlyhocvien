package com.example.kt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "quyenhan")
public class quyenHan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quyenhanid")
    private int quyenHanid;
    @Column(name = "tenquyenhan")
    private String tenQuyenhan;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "quyenhan")
    @JsonIgnoreProperties(value = "quyenhan")
    //@JsonManagedReference
    private List<taiKhoan> taikhoans;

    public int getQuyenHanid() {
        return quyenHanid;
    }

    public void setQuyenHanid(int quyenHanid) {
        this.quyenHanid = quyenHanid;
    }

    public String getTenQuyenhan() {
        return tenQuyenhan;
    }

    public void setTenQuyenhan(String tenQuyenhan) {
        this.tenQuyenhan = tenQuyenhan;
    }

    public List<taiKhoan> getTaikhoans() {
        return taikhoans;
    }

    public void setTaikhoans(List<taiKhoan> taikhoans) {
        this.taikhoans = taikhoans;
    }
}
