package com.example.kt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loaikhoahoc")
public class loaiKhoahoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loaikhoahocid")
    private int loaiKhoahocid;
    @Column(name = "tenloai")
    private String tenLoai;
    @JsonIgnoreProperties(value = "loaikhoahoc")
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "loaikhoahoc")
    //@JsonManagedReference
    private List<khoaHoc> khoahocs;

    public int getLoaiKhoahocid() {
        return loaiKhoahocid;
    }

    public void setLoaiKhoahocid(int loaiKhoahocid) {
        this.loaiKhoahocid = loaiKhoahocid;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public List<khoaHoc> getKhoahocs() {
        return khoahocs;
    }

    public void setKhoahocs(List<khoaHoc> khoahocs) {
        this.khoahocs = khoahocs;
    }
}
