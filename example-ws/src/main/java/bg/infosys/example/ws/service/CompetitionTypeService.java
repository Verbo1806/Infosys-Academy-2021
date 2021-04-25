package bg.infosys.example.ws.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import bg.infosys.example.db.dao.CompetitionTypeDAO;
import bg.infosys.example.ws.dto.CompetitionTypeDTO;
import bg.infosys.example.ws.dto.mapper.CompetitionTypeMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompetitionTypeService {
	private final CompetitionTypeDAO competitionTypeDAO;
	private final CompetitionTypeMapper competitionTypeMapper;

	public List<CompetitionTypeDTO> findAll() {
		return competitionTypeDAO.findAll().stream()
											.map(e -> competitionTypeMapper.toDto(e))
											.collect(Collectors.toList());
	}

}
