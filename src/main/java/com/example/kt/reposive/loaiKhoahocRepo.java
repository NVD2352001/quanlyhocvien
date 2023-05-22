package com.example.kt.reposive;

import com.example.kt.model.loaiKhoahoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface loaiKhoahocRepo extends JpaRepository<loaiKhoahoc,Integer> {
}
