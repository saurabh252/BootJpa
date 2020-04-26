package com.saurabh.BootJpa.dao;

import com.saurabh.BootJpa.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlienRepo extends JpaRepository<Alien,Integer> {
    List<Alien> findByLang(String lang);
    List<Alien> findByAidGreaterThan(int aid);
}
