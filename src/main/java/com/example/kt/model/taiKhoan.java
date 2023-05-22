package com.example.kt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "taikhoan")
public class taiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taikhoanid")
    private  int taiKhoanid;
    @Column(name = "tennguoidung")
    private String tenNguoidung;
    @Column(name = "taikhoan")
    private String taiKhoan;
    @Column(name = "matkhau")
    private String matKhau;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "taikhoan",cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "taikhoan")
    //@JsonManagedReference
    private List<dangKyhoc> dangkyhocs;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "taikhoan")
    @JsonIgnoreProperties(value = "taikhoan")
   // @JsonManagedReference
    private List<baiViet> baiviets;

    @ManyToOne
    @JsonIgnoreProperties(value = "taikhoans")
    //@JsonBackReference
    @JoinColumn(name = "quyenhanid")
    private quyenHan quyenhan;

    public int getTaiKhoanid() {
        return taiKhoanid;
    }

    public void setTaiKhoanid(int taiKhoanid) {
        this.taiKhoanid = taiKhoanid;
    }

    public String getTenNguoidung() {
        return tenNguoidung;
    }

    public void setTenNguoidung(String tenNguoidung) {
        this.tenNguoidung = tenNguoidung;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public List<dangKyhoc> getDangkyhocs() {
        return dangkyhocs;
    }

    public void setDangkyhocs(List<dangKyhoc> dangkyhocs) {
        this.dangkyhocs = dangkyhocs;
    }

    public List<baiViet> getBaiviets() {
        return baiviets;
    }

    public void setBaiviets(List<baiViet> baiviets) {
        this.baiviets = baiviets;
    }

    public quyenHan getQuyenhan() {
        return quyenhan;
    }

    public void setQuyenhan(quyenHan quyenhan) {
        this.quyenhan = quyenhan;
    }
}
