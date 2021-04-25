package bg.infosys.example.ws.dto.mapper;

import org.springframework.stereotype.Service;

import bg.infosys.example.db.entity.Player;
import bg.infosys.example.ws.dto.PlayerDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerMapper implements IModelMapper<PlayerDTO, Player> {
	private final TeamMapper teamMapper;

	@Override
	public PlayerDTO toDto(Player entity) {
		if (entity == null) return null;
		return PlayerDTO.builder()
					  .id(entity.getId())
					  .shirtNumber(entity.getShirtNumber())
					  .fullName(entity.getFullName())
					  .bornAt(entity.getBornAt())
					  .team(teamMapper.toDto(entity.getTeam()))
					  .build();
	}

	@Override
	public Player toEntity(PlayerDTO dto) {
		if (dto == null) return null;
		return Player.builder()
					.id(dto.getId())
					.shirtNumber(dto.getShirtNumber())
					.fullName(dto.getFullName())
					.bornAt(dto.getBornAt())
					.team(teamMapper.toEntity(dto.getTeam()))
					.build();
	}

}
