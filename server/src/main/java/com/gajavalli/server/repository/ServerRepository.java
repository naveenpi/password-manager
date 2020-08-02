package com.gajavalli.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gajavalli.server.model.ServerModel;

@Repository
public interface ServerRepository extends JpaRepository<ServerModel, Integer>{

}
