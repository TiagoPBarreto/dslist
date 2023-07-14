package com.barreto.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barreto.dslist.dto.GameDTO;
import com.barreto.dslist.dto.GameMinDTO;
import com.barreto.dslist.entitys.Game;
import com.barreto.dslist.projection.GameMinProjection;
import com.barreto.dslist.repositories.GameRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		return result.stream().map(game -> new GameMinDTO(game)).toList();
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(game -> new GameMinDTO(game)).toList();
	}
	
	
	
}
