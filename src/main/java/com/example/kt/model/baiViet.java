package com.example.kt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "baiviet")
public class baiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "biavietid")
    private int baiVietid;
    @Column(name = "tenbaiviet")
    private String tenBAiviet;
    @Column(name = "thoigianviet")
    private LocalDate thoiGiantao;
    @Column(name = "tentacgia")
    private String tenTacgia;
    @Column(name = " noidung")
    private String noiDung;
    @Column(name = "noidungngan")
    private String noiDungngan;
    @Column(name = "hinhanh")
    private String hinhAnh;
    @JsonIgnoreProperties(value = "baiviets")
    @ManyToOne
    //@JsonBackReference
    @JoinColumn(name = "taikhoanid")
    private taiKhoan taikhoan;
   @JsonIgnoreProperties(value = "baiviets")
    @ManyToOne
    //@JsonBackReference
    @JoinColumn(name = "chudeid")
    private chuDe chude;

    public int getBaiVietid() {
        return baiVietid;
    }

    public void setBaiVietid(int baiVietid) {
        this.baiVietid = baiVietid;
    }

    public String getTenBAiviet() {
        return tenBAiviet;
    }

    public void setTenBAiviet(String tenBAiviet) {
        this.tenBAiviet = tenBAiviet;
    }

    public LocalDate getThoiGiantao() {
        return thoiGiantao;
    }

    public void setThoiGiantao(LocalDate thoiGiantao) {
        this.thoiGiantao = thoiGiantao;
    }

    public String getTenTacgia() {
        return tenTacgia;
    }

    public void setTenTacgia(String tenTacgia) {
        this.tenTacgia = tenTacgia;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNoiDungngan() {
        return noiDungngan;
    }

    public void setNoiDungngan(String noiDungngan) {
        this.noiDungngan = noiDungngan;
    }

    public taiKhoan getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(taiKhoan taikhoan) {
        this.taikhoan = taikhoan;
    }

    public chuDe getChude() {
        return chude;
    }

    public void setChude(chuDe chude) {
        this.chude = chude;
    }
}
