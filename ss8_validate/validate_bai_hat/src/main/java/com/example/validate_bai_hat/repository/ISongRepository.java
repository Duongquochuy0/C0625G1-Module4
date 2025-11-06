package com.example.validate_bai_hat.repository;

import com.example.validate_bai_hat.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Integer> {
}
