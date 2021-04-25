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
import bg.infosys.example.ws.dto.TeamDTO;
import bg.infosys.example.ws.service.TeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(tags = "Teams")
@RequestMapping(ControllerConfig.TEAMS_URL)
public class TeamController {
	private final TeamService teamService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Find all Teams", notes = "This method will return all Teams")
	public List<TeamDTO> getTeams() {
		return teamService.findAll();
	}
	
	@GetMapping("/{teamId}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Find one Team", notes = "This method will return the Team matching the passed id or HTTP Status 404 Not Found")
	public ResponseEntity<TeamDTO> getTeam(@PathVariable Long teamId) {
		TeamDTO dto = teamService.findById(teamId);
		return dto == null ? ResponseEntity.notFound().build(): ResponseEntity.ok(dto);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create new Team", notes = "This method will create new Team")
	public ResponseEntity<TeamDTO> create(@RequestBody @Valid TeamDTO team) {
		TeamDTO newTeam = teamService.save(team);
		return ResponseEntity.status(201).body(newTeam);
	}
	
	@PutMapping("/{teamId}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Update Team", notes = "This method will update the Team with given id or will return HTTP Status 404 Not Found")
	public ResponseEntity<TeamDTO> update(@PathVariable Long teamId, @RequestBody @Valid TeamDTO team) {
		TeamDTO updatedTeam = teamService.update(team, teamId);
		return ResponseEntity.status(200).body(updatedTeam);
	}
	
	@DeleteMapping("/{teamId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete Team", notes = "This method will delete the Team matching the passed id")
	public ResponseEntity<TeamDTO> delete(@PathVariable Long teamId) {
		teamService.deleteById(teamId);
	    return ResponseEntity.noContent().build();
	}
}
