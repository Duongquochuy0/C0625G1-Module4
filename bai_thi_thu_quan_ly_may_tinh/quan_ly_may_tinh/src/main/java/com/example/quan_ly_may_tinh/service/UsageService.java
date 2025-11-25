package com.example.quan_ly_may_tinh.service;

import com.example.quan_ly_may_tinh.entity.Usage;
import com.example.quan_ly_may_tinh.repository.IUsageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsageService implements IUsageService {

    private final IUsageRepository usageRepository;

    public UsageService(IUsageRepository usageRepository) {
        this.usageRepository = usageRepository;
    }

    @Override
    public Page<Usage> findAll(Pageable pageable) {
        return usageRepository.findAll(pageable);
    }
    @Override
    public Usage create(Usage usage) {
        List<Usage> ongoing = usageRepository.findByComputer_Id(usage.getComputer().getId());

        boolean isBeingUsed = false;
        for (Usage u : ongoing) {
            if (u.getEndTime() == null) {
                isBeingUsed = true;
                break;
            }
        }
        if (isBeingUsed) {
            throw new RuntimeException("Máy này đang được sử dụng. Vui lòng chọn máy khác.");
        }
        usage.setStartTime(LocalDateTime.now());
        usage.setEndTime(null);
        return usageRepository.save(usage);
    }


    @Override
    public void deleteById(Integer id) {
        usageRepository.deleteById(id);
    }

    @Override
    public Usage findById(Integer id) {
        return usageRepository.findById(id).orElse(null);
    }

    @Override
    public List<Usage> findByUserName(String keyword) {
        return usageRepository.findByUserNameContaining(keyword);
    }

    @Override
    public List<Usage> findByComputerId(Integer id) {
        return usageRepository.findByComputer_Id(id);
    }

    @Override
    public List<Usage> findUsingNow() {
        return usageRepository.findByEndTimeIsNull();
    }

    @Override
    public Page<Usage> search(String name, Integer id, Boolean using, Pageable pageable) {
        return usageRepository.search(name, id, using, pageable);
    }
    @Override
    public void finishUsage(Integer usageId) {
        Usage usage = usageRepository.findById(usageId).orElse(null);
        if (usage != null && usage.getEndTime() == null) {
            usage.setEndTime(LocalDateTime.now());
            usageRepository.save(usage);
        }
    }

}
