package bg.infosys.example.ws.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bg.infosys.example.ws.config.ControllerConfig;
import bg.infosys.example.ws.dto.CompetitionTypeDTO;
import bg.infosys.example.ws.service.CompetitionTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(tags = "Competition Types")
@RequestMapping(ControllerConfig.COMPETITION_TYPES_URL)
public class CompetitionTypeController {
	private final CompetitionTypeService competitionTypeService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Find all Competition types", notes = "This method will return all Competition types")
	public List<CompetitionTypeDTO> getCompetitions() {
		return competitionTypeService.findAll();
	}
	
}
