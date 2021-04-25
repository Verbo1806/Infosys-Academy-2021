package bg.infosys.example.ws.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.infosys.example.db.dao.GroundDAO;
import bg.infosys.example.db.entity.Ground;
import bg.infosys.example.ws.dto.GroundDTO;
import bg.infosys.example.ws.dto.mapper.GroundMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroundService {
	private final GroundDAO groundDAO;
	private final GroundMapper groundMapper; 
	
	public List<GroundDTO> findAll() {
		return groundDAO.findAll().stream()
								 .map(c -> groundMapper.toDto(c))
								 .collect(Collectors.toList());
	}

	public GroundDTO findById(Long groundId) {
		return groundMapper.toDto(groundDAO.findById(groundId));
	}

	@Transactional
	public GroundDTO save(GroundDTO ground) {
		Ground newGround = groundDAO.saveOrUpdate(groundMapper.toEntity(ground));
		return groundMapper.toDto(newGround);
	}
	
	@Transactional
	public GroundDTO update(GroundDTO ground, Long groundId) {
		Ground updatedGround = groundDAO.findById(groundId);

		ground.setId(groundId);
		updatedGround = groundDAO.saveOrUpdate(groundMapper.toEntity(ground));
		return groundMapper.toDto(updatedGround);
	}

	@Transactional
	public void deleteById(Long groundId) {
		groundDAO.deleteById(groundId);
	}

}
