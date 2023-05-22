package com.example.kt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chude")
public class chuDe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chudeid")
    private int chuDeid;
    @Column(name = "tenchude")
    private String tenChude;
    @Column(name = "noidung")
    private String noiDung;
    @JsonIgnoreProperties(value = "chude")
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "chude")
    //@JsonManagedReference
    private List<baiViet> baiviets;
    @JsonIgnoreProperties(value = "chudes")
    @ManyToOne
    //@JsonBackReference
    @JoinColumn(name = "loaibaivietid")
    private loaiBaiviet loaibaiviet;

    public int getChuDeid() {
        return chuDeid;
    }

    public void setChuDeid(int chuDeid) {
        this.chuDeid = chuDeid;
    }

    public String getTenChude() {
        return tenChude;
    }

    public void setTenChude(String tenChude) {
        this.tenChude = tenChude;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public List<baiViet> getBaiviets() {
        return baiviets;
    }

    public void setBaiviets(List<baiViet> baiviets) {
        this.baiviets = baiviets;
    }

    public loaiBaiviet getLoaibaiviet() {
        return loaibaiviet;
    }

    public void setLoaibaiviet(loaiBaiviet loaibaiviet) {
        this.loaibaiviet = loaibaiviet;
    }
}
