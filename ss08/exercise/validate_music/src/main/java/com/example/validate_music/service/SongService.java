package com.example.validate_music.service;

import com.example.validate_music.model.Song;
import com.example.validate_music.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository iSongRepository;
    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public List<Song> getList() {
        return iSongRepository.findAll();
    }

    @Override
    public Song find(Integer id) {
        return iSongRepository.findById(id).orElse(null);
    }
}
