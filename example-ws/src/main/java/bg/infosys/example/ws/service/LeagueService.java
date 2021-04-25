package bg.infosys.example.ws.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.infosys.example.db.dao.LeagueDAO;
import bg.infosys.example.db.entity.League;
import bg.infosys.example.ws.dto.LeagueDTO;
import bg.infosys.example.ws.dto.mapper.LeagueMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LeagueService {
	private final LeagueDAO leagueDAO;
	private final LeagueMapper leagueMapper; 
	
	public List<LeagueDTO> findAll() {
		return leagueDAO.findAll().stream()
								 .map(c -> leagueMapper.toDto(c))
								 .collect(Collectors.toList());
	}

	public LeagueDTO findById(Long leagueId) {
		return leagueMapper.toDto(leagueDAO.findById(leagueId));
	}

	@Transactional
	public LeagueDTO save(LeagueDTO league) {
		League newLeague = leagueDAO.saveOrUpdate(leagueMapper.toEntity(league));
		return leagueMapper.toDto(newLeague);
	}
	
	@Transactional
	public LeagueDTO update(LeagueDTO league, Long leagueId) {
		League updatedLeague = leagueDAO.findById(leagueId);

		league.setId(leagueId);
		updatedLeague = leagueDAO.saveOrUpdate(leagueMapper.toEntity(league));
		return leagueMapper.toDto(updatedLeague);
	}

	@Transactional
	public void deleteById(Long leagueId) {
		leagueDAO.deleteById(leagueId);
	}

}
