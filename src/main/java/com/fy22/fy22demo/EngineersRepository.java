package com.fy22.fy22demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
   public interface EngineersRepository extends JpaRepository<Engineer, Integer>{

	}