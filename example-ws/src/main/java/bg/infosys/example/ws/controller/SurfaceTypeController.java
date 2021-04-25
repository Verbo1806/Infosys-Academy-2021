package bg.infosys.example.ws.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bg.infosys.example.ws.config.ControllerConfig;
import bg.infosys.example.ws.dto.SurfaceTypeDTO;
import bg.infosys.example.ws.service.SurfaceTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(tags = "Surface Types")
@RequestMapping(ControllerConfig.SURFACE_TYPES_URL)
public class SurfaceTypeController {
	private final SurfaceTypeService surfaceTypeService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Find all Surface types", notes = "This method will return all Surface types")
	public List<SurfaceTypeDTO> getSurfaces() {
		return surfaceTypeService.findAll();
	}
	
}
