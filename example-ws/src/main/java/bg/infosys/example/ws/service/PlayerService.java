package bg.infosys.example.ws.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.infosys.example.db.dao.PlayerDAO;
import bg.infosys.example.db.entity.Player;
import bg.infosys.example.ws.dto.PlayerDTO;
import bg.infosys.example.ws.dto.mapper.PlayerMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerService {
	private final PlayerDAO playerDAO;
	private final PlayerMapper playerMapper; 
	
	public List<PlayerDTO> findAll() {
		return playerDAO.findAll().stream()
								 .map(c -> playerMapper.toDto(c))
								 .collect(Collectors.toList());
	}

	public PlayerDTO findById(Long playerId) {
		return playerMapper.toDto(playerDAO.findById(playerId));
	}

	@Transactional
	public PlayerDTO save(PlayerDTO player) {
		Player newPlayer = playerDAO.saveOrUpdate(playerMapper.toEntity(player));
		return playerMapper.toDto(newPlayer);
	}
	
	@Transactional
	public PlayerDTO update(PlayerDTO player, Long playerId) {
		Player updatedPlayer = playerDAO.findById(playerId);

		player.setId(playerId);
		updatedPlayer = playerDAO.saveOrUpdate(playerMapper.toEntity(player));
		return playerMapper.toDto(updatedPlayer);
	}

	@Transactional
	public void deleteById(Long playerId) {
		playerDAO.deleteById(playerId);
	}
}
