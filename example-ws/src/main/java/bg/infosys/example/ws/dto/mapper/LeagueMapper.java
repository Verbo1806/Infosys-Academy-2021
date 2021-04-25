package bg.infosys.example.ws.dto.mapper;

import org.springframework.stereotype.Service;

import bg.infosys.example.db.entity.League;
import bg.infosys.example.ws.dto.LeagueDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LeagueMapper implements IModelMapper<LeagueDTO, League> {
	private final ConfederationMapper confederationMapper; 
	private final CountryMapper countryMapper; 
	private final CompetitionTypeMapper competitionTypeMapper; 

	@Override
	public LeagueDTO toDto(League entity) {
		if (entity == null) return null;
		return LeagueDTO.builder()
					  .id(entity.getId())
					  .name(entity.getName())
					  .founded(entity.getFounded())
					  .confederation(confederationMapper.toDto(entity.getConfederation()))
					  .country(countryMapper.toDto(entity.getCountry()))
					  .type(competitionTypeMapper.toDto(entity.getType()))
					  .numberOfTeams(entity.getNumberOfTeams())
					  .levelOnPyramid(entity.getLevelOnPyramid())
					  .build();
	}

	@Override
	public League toEntity(LeagueDTO dto) {
		if (dto == null) return null;
		return League.builder()
					.id(dto.getId())
					.name(dto.getName())
					.founded(dto.getFounded())
					.confederation(confederationMapper.toEntity(dto.getConfederation()))
					.country(countryMapper.toEntity(dto.getCountry()))
					.type(competitionTypeMapper.toEntity(dto.getType()))
					.numberOfTeams(dto.getNumberOfTeams())
					.levelOnPyramid(dto.getLevelOnPyramid())
					.build();
	}

}
