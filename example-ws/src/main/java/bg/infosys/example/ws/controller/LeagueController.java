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
import bg.infosys.example.ws.dto.LeagueDTO;
import bg.infosys.example.ws.service.LeagueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(tags = "Leagues")
@RequestMapping(ControllerConfig.LEAGUES_URL)
public class LeagueController {
	private final LeagueService leagueService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Find all Leagues", notes = "This method will return all Leagues")
	public List<LeagueDTO> getLeagues() {
		return leagueService.findAll();
	}
	
	@GetMapping("/{leagueId}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Find one League", notes = "This method will return the League matching the passed id or HTTP Status 404 Not Found")
	public ResponseEntity<LeagueDTO> getLeague(@PathVariable Long leagueId) {
		LeagueDTO dto = leagueService.findById(leagueId);
		return dto == null ? ResponseEntity.notFound().build(): ResponseEntity.ok(dto);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create new League", notes = "This method will create new League")
	public ResponseEntity<LeagueDTO> create(@RequestBody @Valid LeagueDTO league) {
		LeagueDTO newLeague = leagueService.save(league);
		return ResponseEntity.status(201).body(newLeague);
	}
	
	@PutMapping("/{leagueId}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Update League", notes = "This method will update the League with given id or will return HTTP Status 404 Not Found")
	public ResponseEntity<LeagueDTO> update(@PathVariable Long leagueId, @RequestBody @Valid LeagueDTO league) {
		LeagueDTO updatedLeague = leagueService.update(league, leagueId);
		return ResponseEntity.status(200).body(updatedLeague);
	}
	
	@DeleteMapping("/{leagueId}")
	@ApiOperation(value = "Delete League", notes = "This method will delete the League matching the passed id")
	public ResponseEntity<LeagueDTO> delete(@PathVariable Long leagueId) {
		leagueService.deleteById(leagueId);
	    return ResponseEntity.noContent().build();
	}
}
