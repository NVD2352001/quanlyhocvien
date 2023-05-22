package com.example.kt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "hocvien")
public class hocVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hocvienid")
    private int hocVienid;
    @Column(name = "hinhanh")
    private String hinhAnh;
    @Column(name = "hoten")
    private String hoTen;
    @Column(name = "ngaysinh")
    private LocalDate ngaySinh;
    @Column(name = "sđt")
    private String sĐt;
    @Column(name = "email")
    private String eMail;
    @Column(name = "tinhthanh")
    private String tinhThanh;
    @Column(name = "quanhuyen")
    private String quanHuyen;
    @Column(name = "sonha")
    private String soNha;
    @JsonIgnoreProperties(value = "hocvien")
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "hocvien",cascade = CascadeType.ALL)
    //@JsonManagedReference
    private List<dangKyhoc> dangkyhocs;

    public int getHocVienid() {
        return hocVienid;
    }

    public void setHocVienid(int hocVienid) {
        this.hocVienid = hocVienid;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getsĐt() {
        return sĐt;
    }

    public void setsĐt(String sĐt) {
        this.sĐt = sĐt;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }

    public String getQuanHuyen() {
        return quanHuyen;
    }

    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public List<dangKyhoc> getDangkyhocs() {
        return dangkyhocs;
    }

    public void setDangkyhocs(List<dangKyhoc> dangkyhocs) {
        this.dangkyhocs = dangkyhocs;
    }
}
