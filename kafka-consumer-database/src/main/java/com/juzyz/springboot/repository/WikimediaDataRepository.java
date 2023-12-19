package com.juzyz.springboot.repository;


import com.juzyz.springboot.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {

}