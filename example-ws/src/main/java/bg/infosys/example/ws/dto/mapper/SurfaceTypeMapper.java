package bg.infosys.example.ws.dto.mapper;

import org.springframework.stereotype.Service;

import bg.infosys.example.db.entity.SurfaceType;
import bg.infosys.example.ws.dto.SurfaceTypeDTO;

@Service
public class SurfaceTypeMapper implements IModelMapper<SurfaceTypeDTO, SurfaceType> {

	@Override
	public SurfaceTypeDTO toDto(SurfaceType entity) {
		if (entity == null) return null;
		return SurfaceTypeDTO.builder()
								  .code(entity.getCode())
								  .name(entity.getName())
								  .description(entity.getDescription())
								  .build();
	}

	@Override
	public SurfaceType toEntity(SurfaceTypeDTO dto) {
		if (dto == null) return null;
		return SurfaceType.builder()
								.code(dto.getCode())
								.name(dto.getName())
								.description(dto.getDescription())
								.build();
	}

}
