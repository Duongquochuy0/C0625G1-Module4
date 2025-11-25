package com.example.quan_ly_may_tinh.service;

import com.example.quan_ly_may_tinh.entity.Usage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUsageService {
    Page<Usage> findAll(Pageable pageable);
    Usage create(Usage usage);
    void deleteById(Integer id);
    Usage findById(Integer id);
    List<Usage> findByUserName(String keyword);
    List<Usage> findByComputerId(Integer id);
    List<Usage> findUsingNow();
    Page<Usage> search(String name, Integer id, Boolean using, Pageable pageable);
    void finishUsage(Integer usageId);
}
