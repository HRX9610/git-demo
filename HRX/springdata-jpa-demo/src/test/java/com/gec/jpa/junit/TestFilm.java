package com.gec.jpa.junit;


import com.gec.jpa.dao.FilmInfoRepository;
import com.gec.jpa.dao.FilmTypeRepository;
import com.gec.jpa.entity.FilmInfo;
import com.gec.jpa.entity.FilmType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
public class TestFilm {
     @Resource
     private FilmInfoRepository filmInfoRepository;
     @Resource
     private FilmTypeRepository filmTypeRepository;


     @Test
     @Transactional
     @Rollback(value = false)
     public void testAddType() {
          FilmType type = new FilmType();
          type.setName("爱情动作片");
          filmTypeRepository.save(type);
     }

      @Test
      @Transactional
      @Rollback(value = false)
      public void testAddFilm() {
          FilmInfo film = new FilmInfo();
          film.setFilmName("中国机长");
          film.setActor("刘传健");
          film.setDirector("刘德华");
          film.setTicketprice(1000D);
//        Optional<FilmType> optional = filmTypeRepository.findById(1);
//        if(optional.isPresent()){
//
//        }
          FilmType type = filmTypeRepository.findById(1).get();
//        FilmType type = new FilmType();
//        type.setId(1);
          //设置关联的关系
          film.setFilmType(type);

          filmInfoRepository.save(film);
         }
}

