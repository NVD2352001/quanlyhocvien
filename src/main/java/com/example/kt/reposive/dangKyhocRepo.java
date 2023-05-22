package com.example.kt.reposive;

import com.example.kt.model.dangKyhoc;
import com.example.kt.model.khoaHoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface dangKyhocRepo extends JpaRepository<dangKyhoc,Integer> {
    @Query(value = "SELECT * FROM dangkyhoc", nativeQuery = true)
    Page<dangKyhoc> findAll(Pageable pageable);
}
