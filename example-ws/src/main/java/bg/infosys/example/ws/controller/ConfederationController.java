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
import bg.infosys.example.ws.dto.ConfederationDTO;
import bg.infosys.example.ws.service.ConfederationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(tags = "Confederations")
@RequestMapping(ControllerConfig.CONFEDERATIONS_URL)
public class ConfederationController {
	private final ConfederationService confederationService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Find all Confederations", notes = "This method will return all Confederations")
	public List<ConfederationDTO> getConfederations() {
		return confederationService.findAll();
	}
	
	@GetMapping("/{confederationId}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Find one Confederation", notes = "This method will return the Confederation matching the passed id or HTTP Status 404 Not Found")
	public ResponseEntity<ConfederationDTO> getConfederation(@PathVariable Long confederationId) {
		ConfederationDTO dto = confederationService.findById(confederationId);
		return dto == null ? ResponseEntity.notFound().build(): ResponseEntity.ok(dto);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create new Confederation", notes = "This method will create new Confederation")
	public ResponseEntity<ConfederationDTO> create(@RequestBody @Valid ConfederationDTO confederation) {
		ConfederationDTO newConfederation = confederationService.save(confederation);
		return ResponseEntity.status(201).body(newConfederation);
	}
	
	@PutMapping("/{confederationId}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Update Confederation", notes = "This method will update the Confederation with given id or will return HTTP Status 404 Not Found")
	public ResponseEntity<ConfederationDTO> update(@PathVariable Long confederationId, @RequestBody @Valid ConfederationDTO confederation) {
		ConfederationDTO updatedConfederation = confederationService.update(confederation, confederationId);
		return ResponseEntity.status(200).body(updatedConfederation);
	}
	
	@DeleteMapping("/{confederationId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete Confederation", notes = "This method will delete the Confederation matching the passed id")
	public ResponseEntity<ConfederationDTO> delete(@PathVariable Long confederationId) {
		confederationService.deleteById(confederationId);
	    return ResponseEntity.noContent().build();
	}
}
