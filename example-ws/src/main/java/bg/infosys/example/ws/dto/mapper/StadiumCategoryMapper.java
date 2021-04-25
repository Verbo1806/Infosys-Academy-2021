package bg.infosys.example.ws.dto.mapper;

import org.springframework.stereotype.Service;

import bg.infosys.example.db.entity.StadiumCategory;
import bg.infosys.example.ws.dto.StadiumCategoryDTO;

@Service
public class StadiumCategoryMapper implements IModelMapper<StadiumCategoryDTO, StadiumCategory> {

	@Override
	public StadiumCategoryDTO toDto(StadiumCategory entity) {
		if (entity == null) return null;
		return StadiumCategoryDTO.builder()
								  .code(entity.getCode())
								  .name(entity.getName())
								  .description(entity.getDescription())
								  .build();
	}

	@Override
	public StadiumCategory toEntity(StadiumCategoryDTO dto) {
		if (dto == null) return null;
		return StadiumCategory.builder()
								.code(dto.getCode())
								.name(dto.getName())
								.description(dto.getDescription())
								.build();
	}

}
