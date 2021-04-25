package bg.infosys.example.ws.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import bg.infosys.example.db.dao.SurfaceTypeDAO;
import bg.infosys.example.ws.dto.SurfaceTypeDTO;
import bg.infosys.example.ws.dto.mapper.SurfaceTypeMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SurfaceTypeService {
	private final SurfaceTypeDAO surfaceTypeDAO;
	private final SurfaceTypeMapper surfaceTypeMapper;

	public List<SurfaceTypeDTO> findAll() {
		return surfaceTypeDAO.findAll().stream()
											.map(e -> surfaceTypeMapper.toDto(e))
											.collect(Collectors.toList());
	}

}
