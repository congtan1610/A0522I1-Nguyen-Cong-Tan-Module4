package com.example.validate_music.service;

import com.example.validate_music.model.Song;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ISongService {
    void save(Song song);
    List<Song> getList();
    Song find(Integer id);
}
