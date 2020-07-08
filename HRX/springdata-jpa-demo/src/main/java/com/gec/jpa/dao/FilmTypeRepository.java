package com.gec.jpa.dao;

import com.gec.jpa.entity.FilmType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmTypeRepository extends JpaRepository<FilmType,Integer> {
}
