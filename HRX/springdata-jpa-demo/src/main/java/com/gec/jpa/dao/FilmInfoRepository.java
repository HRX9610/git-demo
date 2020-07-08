package com.gec.jpa.dao;

import com.gec.jpa.entity.FilmInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmInfoRepository extends JpaRepository<FilmInfo,Integer> {
}
