package com.example.kt.reposive;

import com.example.kt.model.khoaHoc;
import com.example.kt.model.loaiBaiviet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface loaiBaivietRepo extends JpaRepository<loaiBaiviet,Integer> {
    @Query(value = "SELECT * FROM loaibaiviet", nativeQuery = true)
    Page<loaiBaiviet> findAll(Pageable pageable);
}
