package com.example.kt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loaibaiviet")
public class loaiBaiviet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loaibaivietid")
    private int loaiBaivietid;
    @Column(name = "tenloai")
    private String tenLoai;
    @JsonIgnoreProperties(value = "loaibaiviet")
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "loaibaiviet")
    //@JsonManagedReference
    private List<chuDe> chudes;

    public int getLoaiBaivietid() {
        return loaiBaivietid;
    }

    public void setLoaiBaivietid(int loaiBaivietid) {
        this.loaiBaivietid = loaiBaivietid;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public List<chuDe> getChudes() {
        return chudes;
    }

    public void setChudes(List<chuDe> chudes) {
        this.chudes = chudes;
    }
}
