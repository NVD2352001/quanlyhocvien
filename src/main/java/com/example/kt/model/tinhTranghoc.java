package com.example.kt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tinhtranghoc")
public class tinhTranghoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tinhtranghocid")
    private int tinhTranghocid;
    @Column(name = "tentinhtrang")
    private String tenTinhtrang;
    @JsonIgnoreProperties(value = "tinhtranghoc")
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tinhtranghoc",cascade = CascadeType.ALL)
    //@JsonManagedReference
    private List<dangKyhoc> dangkyhocs;

    public int getTinhTranghocid() {
        return tinhTranghocid;
    }

    public void setTinhTranghocid(int tinhTranghocid) {
        this.tinhTranghocid = tinhTranghocid;
    }

    public String getTenTinhtrang() {
        return tenTinhtrang;
    }

    public void setTenTinhtrang(String tenTinhtrang) {
        this.tenTinhtrang = tenTinhtrang;
    }

    public List<dangKyhoc> getDangkyhocs() {
        return dangkyhocs;
    }

    public void setDangkyhocs(List<dangKyhoc> dangkyhocs) {
        this.dangkyhocs = dangkyhocs;
    }
}
