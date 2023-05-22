package com.example.kt.reposive;

import com.example.kt.model.hocVien;
import com.example.kt.model.khoaHoc;
import org.hibernate.hql.internal.ast.tree.IdentNode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface hocVienRepo extends JpaRepository<hocVien,Integer> {
    @Query(value = "SELECT * FROM hocvien" , nativeQuery = true)
    Page<hocVien> findAll(Pageable pageable);
}
