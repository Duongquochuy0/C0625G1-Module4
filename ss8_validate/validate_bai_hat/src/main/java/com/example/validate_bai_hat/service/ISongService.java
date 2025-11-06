package com.example.validate_bai_hat.service;

import com.example.validate_bai_hat.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
    Song findById(Integer id);
}
