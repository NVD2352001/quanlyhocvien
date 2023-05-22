package com.example.kt.reposive;

import com.example.kt.model.khoaHoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface khoaHocRepo extends JpaRepository<khoaHoc,Integer> {
    @Query(value = "SELECT * FROM khoahoc", nativeQuery = true)
    Page<khoaHoc> findAll(Pageable pageable);
}
