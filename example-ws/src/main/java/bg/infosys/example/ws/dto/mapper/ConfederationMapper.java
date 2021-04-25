package bg.infosys.example.ws.dto.mapper;

import org.springframework.stereotype.Service;

import bg.infosys.example.db.entity.Confederation;
import bg.infosys.example.ws.dto.ConfederationDTO;

@Service
public class ConfederationMapper implements IModelMapper<ConfederationDTO, Confederation> {

	@Override
	public ConfederationDTO toDto(Confederation entity) {
		if (entity == null) return null;
		return ConfederationDTO.builder()
								  .id(entity.getId())
								  .name(entity.getName())
								  .founded(entity.getFounded())
								  .headquarters(entity.getHeadquarters())
								  .build();
	}

	@Override
	public Confederation toEntity(ConfederationDTO dto) {
		if (dto == null) return null;
		return Confederation.builder()
							.id(dto.getId())
							.name(dto.getName())
							.founded(dto.getFounded())
							.headquarters(dto.getHeadquarters())
							.build();
	}

}
