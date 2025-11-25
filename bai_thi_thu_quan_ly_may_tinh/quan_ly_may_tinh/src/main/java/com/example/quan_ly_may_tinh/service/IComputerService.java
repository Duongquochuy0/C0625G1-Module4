package com.example.quan_ly_may_tinh.service;

import com.example.quan_ly_may_tinh.entity.Computer;

import java.util.List;

public interface IComputerService {
    List<Computer> findAll();
    List<Computer> findByName(String keyword);
}
