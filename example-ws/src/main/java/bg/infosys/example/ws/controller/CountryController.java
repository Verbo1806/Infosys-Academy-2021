package bg.infosys.example.ws.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bg.infosys.example.ws.config.ControllerConfig;
import bg.infosys.example.ws.dto.CountryDTO;
import bg.infosys.example.ws.service.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(tags = "Countires")
@RequestMapping(ControllerConfig.COUNTRIES_URL)
public class CountryController {
	private final CountryService countryService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Find all Countries", notes = "This method will return all Countries")
	public List<CountryDTO> getCountries() {
		return countryService.findAll();
	}
	
}
