package bg.infosys.example.ws.dto.mapper;

import org.springframework.stereotype.Service;

import bg.infosys.example.db.entity.CompetitionType;
import bg.infosys.example.ws.dto.CompetitionTypeDTO;

@Service
public class CompetitionTypeMapper implements IModelMapper<CompetitionTypeDTO, CompetitionType> {

	@Override
	public CompetitionTypeDTO toDto(CompetitionType entity) {
		if (entity == null) return null;
		return CompetitionTypeDTO.builder()
								  .code(entity.getCode())
								  .name(entity.getName())
								  .description(entity.getDescription())
								  .build();
	}

	@Override
	public CompetitionType toEntity(CompetitionTypeDTO dto) {
		if (dto == null) return null;
		return CompetitionType.builder()
								.code(dto.getCode())
								.name(dto.getName())
								.description(dto.getDescription())
								.build();
	}

}
