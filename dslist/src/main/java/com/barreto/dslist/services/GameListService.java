package com.barreto.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barreto.dslist.dto.GameListDto;
import com.barreto.dslist.entitys.GameList;
import com.barreto.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDto> findAll(){
		
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(game -> new GameListDto(game)).toList();
	}
	
	
	
}
