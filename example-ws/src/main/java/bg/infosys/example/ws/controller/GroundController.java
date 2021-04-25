package bg.infosys.example.ws.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bg.infosys.example.ws.config.ControllerConfig;
import bg.infosys.example.ws.dto.GroundDTO;
import bg.infosys.example.ws.service.GroundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(tags = "Grounds")
@RequestMapping(ControllerConfig.GROUNDS_URL)
public class GroundController {
	private final GroundService groundService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Find all Grounds", notes = "This method will return all Grounds")
	public List<GroundDTO> getGrounds() {
		return groundService.findAll();
	}
	
	@GetMapping("/{groundId}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Find one Ground", notes = "This method will return the Ground matching the passed id or HTTP Status 404 Not Found")
	public ResponseEntity<GroundDTO> getGround(@PathVariable Long groundId) {
		GroundDTO dto = groundService.findById(groundId);
		return dto == null ? ResponseEntity.notFound().build(): ResponseEntity.ok(dto);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create new Ground", notes = "This method will create new Ground")
	public ResponseEntity<GroundDTO> create(@RequestBody @Valid GroundDTO ground) {
		GroundDTO newGround = groundService.save(ground);
		return ResponseEntity.status(201).body(newGround);
	}
	
	@PutMapping("/{groundId}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Update Ground", notes = "This method will update the Ground with given id or will return HTTP Status 404 Not Found")
	public ResponseEntity<GroundDTO> update(@PathVariable Long groundId, @RequestBody @Valid GroundDTO ground) {
		GroundDTO updatedGround = groundService.update(ground, groundId);
		return ResponseEntity.status(200).body(updatedGround);
	}
	
	@DeleteMapping("/{groundId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete Ground", notes = "This method will delete the Ground matching the passed id")
	public ResponseEntity<GroundDTO> delete(@PathVariable Long groundId) {
		groundService.deleteById(groundId);
	    return ResponseEntity.noContent().build();
	}
}
