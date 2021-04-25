package bg.infosys.example.ws.dto.mapper;

import org.springframework.stereotype.Service;

import bg.infosys.example.db.entity.Team;
import bg.infosys.example.ws.dto.TeamDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamMapper implements IModelMapper<TeamDTO, Team> {
	private final GroundMapper groundMapper;
	private final LeagueMapper leagueMapper;
	//private final PlayerMapper playerMapper;

	@Override
	public TeamDTO toDto(Team entity) {
		if (entity == null) return null;
		return TeamDTO.builder()
					  .id(entity.getId())
					  .name(entity.getName())
					  .abbreaviature(entity.getAbbreaviature())
					  .founded(entity.getFounded())
					  .ground(groundMapper.toDto(entity.getGround()))
					  .league(leagueMapper.toDto(entity.getLeague()))
					 /* .players(entity.getPlayers() != null ? entity.getPlayers().stream()
																				.map(p -> playerMapper.toDto(p))
																				.collect(Collectors.toList()) : null)*/
					  .build();
	}

	@Override
	public Team toEntity(TeamDTO dto) {
		if (dto == null) return null;
		return Team.builder()
					.id(dto.getId())
					.name(dto.getName())
					.abbreaviature(dto.getAbbreaviature())
					.founded(dto.getFounded())
					.ground(groundMapper.toEntity(dto.getGround()))
					.league(leagueMapper.toEntity(dto.getLeague()))
					/*.players(dto.getPlayers() != null ? dto.getPlayers().stream()
																			.map(p -> playerMapper.toEntity(p))
																			.collect(Collectors.toList()) : null)*/
					.build();
	}

}
