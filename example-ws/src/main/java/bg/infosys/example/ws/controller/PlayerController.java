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
import bg.infosys.example.ws.dto.PlayerDTO;
import bg.infosys.example.ws.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(tags = "Players")
@RequestMapping(ControllerConfig.PLAYERS_URL)
public class PlayerController {
	private final PlayerService playerService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Find all Players", notes = "This method will return all Players")
	public List<PlayerDTO> getPlayers() {
		return playerService.findAll();
	}
	
	@GetMapping("/{playerId}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Find one Player", notes = "This method will return the Player matching the passed id or HTTP Status 404 Not Found")
	public ResponseEntity<PlayerDTO> getPlayer(@PathVariable Long playerId) {
		PlayerDTO dto = playerService.findById(playerId);
		return dto == null ? ResponseEntity.notFound().build(): ResponseEntity.ok(dto);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create new Player", notes = "This method will create new Player")
	public ResponseEntity<PlayerDTO> create(@RequestBody @Valid PlayerDTO player) {
		PlayerDTO newPlayer = playerService.save(player);
		return ResponseEntity.status(201).body(newPlayer);
	}
	
	@PutMapping("/{playerId}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Update Player", notes = "This method will update the Player with given id or will return HTTP Status 404 Not Found")
	public ResponseEntity<PlayerDTO> update(@PathVariable Long playerId, @RequestBody @Valid PlayerDTO player) {
		PlayerDTO updatedPlayer = playerService.update(player, playerId);
		return ResponseEntity.status(200).body(updatedPlayer);
	}
	
	@DeleteMapping("/{playerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete Player", notes = "This method will delete the Player matching the passed id")
	public ResponseEntity<PlayerDTO> delete(@PathVariable Long playerId) {
		playerService.deleteById(playerId);
	    return ResponseEntity.noContent().build();
	}
}
