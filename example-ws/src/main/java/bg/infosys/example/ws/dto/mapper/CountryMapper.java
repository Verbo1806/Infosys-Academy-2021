package bg.infosys.example.ws.dto.mapper;

import org.springframework.stereotype.Service;

import bg.infosys.example.db.entity.Country;
import bg.infosys.example.ws.dto.CountryDTO;

@Service
public class CountryMapper implements IModelMapper<CountryDTO, Country> {

	@Override
	public CountryDTO toDto(Country entity) {
		if (entity == null) return null;
		return CountryDTO.builder()
								  .code(entity.getCode())
								  .name(entity.getName())
								  .description(entity.getDescription())
								  .build();
	}

	@Override
	public Country toEntity(CountryDTO dto) {
		if (dto == null) return null;
		return Country.builder()
								.code(dto.getCode())
								.name(dto.getName())
								.description(dto.getDescription())
								.build();
	}

}
