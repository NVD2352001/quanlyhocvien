package com.example.kt.reposive;

import com.example.kt.model.baiViet;
import com.example.kt.model.chuDe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface chuDeRepo extends JpaRepository<chuDe,Integer> {
    @Query(value = "SELECT * FROM chude" , nativeQuery = true)
    Page<chuDe> findAll(Pageable pageable);
}
