package bg.infosys.example.ws.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import bg.infosys.example.db.dao.StadiumCategoryDAO;
import bg.infosys.example.ws.dto.StadiumCategoryDTO;
import bg.infosys.example.ws.dto.mapper.StadiumCategoryMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StadiumCategoryService {
	private final StadiumCategoryDAO stadiumCategoryDAO;
	private final StadiumCategoryMapper stadiumCategoryMapper;

	public List<StadiumCategoryDTO> findAll() {
		return stadiumCategoryDAO.findAll().stream()
											.map(e -> stadiumCategoryMapper.toDto(e))
											.collect(Collectors.toList());
	}

}
