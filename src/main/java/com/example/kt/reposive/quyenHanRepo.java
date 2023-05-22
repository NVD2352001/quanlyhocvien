package com.example.kt.reposive;

import com.example.kt.model.khoaHoc;
import com.example.kt.model.quyenHan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface quyenHanRepo extends JpaRepository<quyenHan,Integer> {
    @Query(value = "SELECT * FROM quyenhan", nativeQuery = true)
    Page<quyenHan> findAll(Pageable pageable);
}
