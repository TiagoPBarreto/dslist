package com.barreto.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barreto.dslist.entitys.GameList;

public interface GameListRepository extends JpaRepository<GameList,Long>{
	
}
