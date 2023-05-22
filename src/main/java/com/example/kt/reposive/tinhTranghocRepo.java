package com.example.kt.reposive;

import com.example.kt.model.tinhTranghoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tinhTranghocRepo extends JpaRepository<tinhTranghoc,Integer> {

}
