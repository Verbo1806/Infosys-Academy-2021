package bg.infosys.example.ws.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import bg.infosys.example.db.dao.CountryDAO;
import bg.infosys.example.ws.dto.CountryDTO;
import bg.infosys.example.ws.dto.mapper.CountryMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryService {
	private final CountryDAO countryDAO;
	private final CountryMapper countryMapper;

	public List<CountryDTO> findAll() {
		return countryDAO.findAll().stream()
									.map(e -> countryMapper.toDto(e))
									.collect(Collectors.toList());
	}

}
