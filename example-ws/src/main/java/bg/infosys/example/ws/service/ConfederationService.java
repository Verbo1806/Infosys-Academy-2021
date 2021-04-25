package bg.infosys.example.ws.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.infosys.example.db.dao.ConfederationDAO;
import bg.infosys.example.db.entity.Confederation;
import bg.infosys.example.ws.dto.ConfederationDTO;
import bg.infosys.example.ws.dto.mapper.ConfederationMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConfederationService {
	private final ConfederationDAO confederationDAO;
	private final ConfederationMapper confederationMapper; 
	
	public List<ConfederationDTO> findAll() {
		return confederationDAO.findAll().stream()
										 .map(c -> confederationMapper.toDto(c))
										 .collect(Collectors.toList());
	}

	public ConfederationDTO findById(Long confederationId) {
		return confederationMapper.toDto(confederationDAO.findById(confederationId));
	}

	@Transactional
	public ConfederationDTO save(ConfederationDTO confederation) {
		Confederation newConfederation = confederationDAO.saveOrUpdate(confederationMapper.toEntity(confederation));
		return confederationMapper.toDto(newConfederation);
	}
	
	@Transactional
	public ConfederationDTO update(ConfederationDTO confederation, Long confederationId) {
		Confederation updatedConfederation = confederationDAO.findById(confederationId);

		confederation.setId(confederationId);
		updatedConfederation = confederationDAO.saveOrUpdate(confederationMapper.toEntity(confederation));
		return confederationMapper.toDto(updatedConfederation);
	}

	@Transactional
	public void deleteById(Long confederationId) {
		confederationDAO.deleteById(confederationId);
	}

}
