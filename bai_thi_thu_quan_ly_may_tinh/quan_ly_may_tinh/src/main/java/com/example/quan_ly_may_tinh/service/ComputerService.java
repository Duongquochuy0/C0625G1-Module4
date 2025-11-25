package com.example.quan_ly_may_tinh.service;

import com.example.quan_ly_may_tinh.entity.Computer;
import com.example.quan_ly_may_tinh.repository.IComputerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerService implements IComputerService {

    private final IComputerRepository computerRepository;

    public ComputerService(IComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @Override
    public List<Computer> findAll() {
        return computerRepository.findAll();
    }

    @Override
    public List<Computer> findByName(String keyword) {
        return computerRepository.findByNameContaining(keyword);
    }
}
