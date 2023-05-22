package com.example.kt.reposive;

import com.example.kt.model.khoaHoc;
import com.example.kt.model.taiKhoan;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface taiKhoanRepo extends JpaRepository<taiKhoan,Integer> {
    @Query(value = "SELECT * FROM taikhoan", nativeQuery = true)
    Page<taiKhoan> findAll(Pageable pageable);
}
