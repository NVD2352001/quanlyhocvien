package com.example.kt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "khoahoc")
public class khoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "khoahocid")
    private int khoaHocid;
    @Column(name = "tenkhoahoc")
    private String tenKhoahoc;
    @Column(name = "thoigianhoc")
    private int thoiGianhoc;
    @Column(name = "gioithieu")
    private String gioiThieu;
    @Column(name = "noidung")
    private String noiDung;
    @Column(name = "hocphi")
    private  int hocPhi;
    @Column(name = "sohocvien")
    private int soHocvien;
    @Column(name="soluongmon")
    private int soLuongmon;
    @Column(name = "hinhanh")
    private String hinhAnh;
   @JsonIgnoreProperties(value = "khoahocs")
    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "loaikhoahocid")
    private loaiKhoahoc loaikhoahoc;
    @JsonIgnoreProperties(value = "khoahoc")
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "khoahoc",cascade = CascadeType.ALL)
    //@JsonManagedReference
    private List<dangKyhoc> dangkyhocs;

    public int getKhoaHocid() {
        return khoaHocid;
    }

    public void setKhoaHocid(int khoaHocid) {
        this.khoaHocid = khoaHocid;
    }

    public String getTenKhoahoc() {
        return tenKhoahoc;
    }

    public void setTenKhoahoc(String tenKhoahoc) {
        this.tenKhoahoc = tenKhoahoc;
    }

    public int getThoiGianhoc() {
        return thoiGianhoc;
    }

    public void setThoiGianhoc(int thoiGianhoc) {
        this.thoiGianhoc = thoiGianhoc;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(int hocPhi) {
        this.hocPhi = hocPhi;
    }

    public int getSoHocvien() {
        return soHocvien;
    }

    public void setSoHocvien(int soHocvien) {
        this.soHocvien = soHocvien;
    }

    public int getSoLuongmon() {
        return soLuongmon;
    }

    public void setSoLuongmon(int soLuongmon) {
        this.soLuongmon = soLuongmon;
    }

    public loaiKhoahoc getLoaikhoahoc() {
        return loaikhoahoc;
    }

    public void setLoaikhoahoc(loaiKhoahoc loaikhoahoc) {
        this.loaikhoahoc = loaikhoahoc;
    }


}
