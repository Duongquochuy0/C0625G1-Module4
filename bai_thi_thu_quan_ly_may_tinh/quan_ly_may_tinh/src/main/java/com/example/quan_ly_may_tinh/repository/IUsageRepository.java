package com.example.quan_ly_may_tinh.repository;

import com.example.quan_ly_may_tinh.entity.Usage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsageRepository extends JpaRepository<Usage, Integer> {
    List<Usage> findByUserNameContaining(String name);
    List<Usage> findByComputer_Id(Integer id);
    List<Usage> findByEndTimeIsNull();
    Page<Usage> findAll(Pageable pageable);
    @Query(value = """
    SELECT * FROM `usage_table`
    WHERE (:name IS NULL OR user_name LIKE CONCAT('%', :name, '%'))
      AND (:computerId IS NULL OR computer_id = :computerId)
      AND (:using IS NULL OR (:using = TRUE AND end_time IS NULL))
    ORDER BY id
    """,
            countQuery = """
    SELECT COUNT(*) FROM `usage_table`
    WHERE (:name IS NULL OR user_name LIKE CONCAT('%', :name, '%'))
      AND (:computerId IS NULL OR computer_id = :computerId)
      AND (:using IS NULL OR (:using = TRUE AND end_time IS NULL))
    """,
            nativeQuery = true
    )
    Page<Usage> search(String name, Integer computerId, Boolean using, Pageable pageable);


}
