package com.example.quan_ly_may_tinh.repository;

import com.example.quan_ly_may_tinh.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComputerRepository extends JpaRepository<Computer, Integer> {

    List<Computer> findAll();
    List<Computer> findByNameContaining(String keyword);
}
