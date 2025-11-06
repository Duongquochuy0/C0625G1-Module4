package com.example.validate_bai_hat.service;

import com.example.validate_bai_hat.entity.Song;
import com.example.validate_bai_hat.repository.ISongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    private final ISongRepository songRepository;
    public SongService(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }
    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(Integer id) {
        return songRepository.findById(id).orElse(null);
    }
}
