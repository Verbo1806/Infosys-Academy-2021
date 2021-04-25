package bg.infosys.example.ws.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.infosys.example.db.dao.TeamDAO;
import bg.infosys.example.db.entity.Team;
import bg.infosys.example.ws.dto.TeamDTO;
import bg.infosys.example.ws.dto.mapper.TeamMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamService {
	private final TeamDAO teamDAO;
	private final TeamMapper teamMapper;
	
	public List<TeamDTO> findAll() {
		return teamDAO.findAll().stream()
								 .map(c -> teamMapper.toDto(c))
								 .collect(Collectors.toList());
	}

	public TeamDTO findById(Long teamId) {
		return teamMapper.toDto(teamDAO.findById(teamId));
	}

	@Transactional
	public TeamDTO save(TeamDTO team) {
		Team newTeam = teamDAO.saveOrUpdate(teamMapper.toEntity(team));
		return teamMapper.toDto(newTeam);
	}
	
	@Transactional
	public TeamDTO update(TeamDTO team, Long teamId) {
		Team updatedTeam = teamDAO.findById(teamId);

		team.setId(teamId);
		updatedTeam = teamDAO.saveOrUpdate(teamMapper.toEntity(team));
		return teamMapper.toDto(updatedTeam);
	}

	@Transactional
	public void deleteById(Long teamId) {
		teamDAO.deleteById(teamId);
	}
}
