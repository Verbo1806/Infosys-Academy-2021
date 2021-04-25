package bg.infosys.example.ws.dto.mapper;

import org.springframework.stereotype.Service;

import bg.infosys.example.db.entity.Ground;
import bg.infosys.example.ws.dto.GroundDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroundMapper implements IModelMapper<GroundDTO, Ground> {
	private final StadiumCategoryMapper stadiumCategoryMapper; 
	private final SurfaceTypeMapper surfaceTypeMapper; 

	@Override
	public GroundDTO toDto(Ground entity) {
		if (entity == null) return null;
		return GroundDTO.builder()
					  .id(entity.getId())
					  .name(entity.getName())
					  .capacity(entity.getCapacity())
					  .address(entity.getAddress())
					  .founded(entity.getFounded())
					  .category(stadiumCategoryMapper.toDto(entity.getCategory()))
					  .surface(surfaceTypeMapper.toDto(entity.getSurface()))
					  .build();
	}

	@Override
	public Ground toEntity(GroundDTO dto) {
		if (dto == null) return null;
		return Ground.builder()
						.id(dto.getId())
						.name(dto.getName())
						.capacity(dto.getCapacity())
						.address(dto.getAddress())
						.founded(dto.getFounded())
						.category(stadiumCategoryMapper.toEntity(dto.getCategory()))
						.surface(surfaceTypeMapper.toEntity(dto.getSurface()))
						.build();
	}

}
