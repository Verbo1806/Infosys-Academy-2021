package bg.infosys.example.ws.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bg.infosys.example.ws.config.ControllerConfig;
import bg.infosys.example.ws.dto.StadiumCategoryDTO;
import bg.infosys.example.ws.service.StadiumCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(tags = "Stadium Categories")
@RequestMapping(ControllerConfig.STADIUM_CATEGORIES_URL)
public class StadiumCategoryController {
	private final StadiumCategoryService stadiumCategoryService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Find all Stadium categories", notes = "This method will return all Stadium categories")
	public List<StadiumCategoryDTO> getCategories() {
		return stadiumCategoryService.findAll();
	}
	
}
