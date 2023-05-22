package com.example.kt.reposive;

import com.example.kt.model.baiViet;
import com.example.kt.model.hocVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface baiVietRepo extends JpaRepository<baiViet,Integer> {
    @Query(value = "SELECT * FROM baiviet" , nativeQuery = true)
    Page<baiViet> findAll(Pageable pageable);
}
