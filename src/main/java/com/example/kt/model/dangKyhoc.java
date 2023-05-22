package com.example.kt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dangkyhoc")
public class dangKyhoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dangkyhocid")
    private int dangKyhocid;
    @Column(name = "ngaydangky")
    private LocalDate ngayDangky;
    @Column(name = "ngaybatdau")
    private LocalDate ngayBatdau;
    @Column(name = "ngayketthuc")
    private LocalDate ngayKetthuc;
       @JsonIgnoreProperties(value = " dangkyhocs")
    @ManyToOne
    //@JsonBackReference
    @JoinColumn(name = "khoahocid")
    private khoaHoc khoahoc;
    @JsonIgnoreProperties(value = "dangkyhocs")
    @ManyToOne
   // @JsonBackReference
    @JoinColumn(name = "hocvienid")
    private hocVien hocvien;
    @JsonIgnoreProperties(value = "dangkyhocs")
    @ManyToOne
    //@JsonBackReference
    @JoinColumn(name = "tinhtranghocid")
    private tinhTranghoc tinhtranghoc;
    @JsonIgnoreProperties(value = "dangkyhocs")
    @ManyToOne
    //@JsonBackReference
    @JoinColumn(name = "taikhoanid")
    private taiKhoan taikhoan;

    public int getDangKyhocid() {
        return dangKyhocid;
    }

    public void setDangKyhocid(int dangKyhocid) {
        this.dangKyhocid = dangKyhocid;
    }

    public LocalDate getNgayDangky() {
        return ngayDangky;
    }

    public void setNgayDangky(LocalDate ngayDangky) {
        this.ngayDangky = ngayDangky;
    }

    public LocalDate getNgayBatdau() {
        return ngayBatdau;
    }

    public void setNgayBatdau(LocalDate ngayBatdau) {
        this.ngayBatdau = ngayBatdau;
    }

    public LocalDate getNgayKetthuc() {
        return ngayKetthuc;
    }

    public void setNgayKetthuc(LocalDate ngayKetthuc) {
        this.ngayKetthuc = ngayKetthuc;
    }

    public khoaHoc getKhoahoc() {
        return khoahoc;
    }

    public void setKhoahoc(khoaHoc khoahoc) {
        this.khoahoc = khoahoc;
    }

    public hocVien getHocvien() {
        return hocvien;
    }

    public void setHocvien(hocVien hocvien) {
        this.hocvien = hocvien;
    }

    public tinhTranghoc getTinhtranghoc() {
        return tinhtranghoc;
    }

    public void setTinhtranghoc(tinhTranghoc tinhtranghoc) {
        this.tinhtranghoc = tinhtranghoc;
    }

    public taiKhoan getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(taiKhoan taikhoan) {
        this.taikhoan = taikhoan;
    }
}
