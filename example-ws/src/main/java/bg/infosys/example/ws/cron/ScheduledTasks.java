package bg.infosys.example.ws.cron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import bg.infosys.example.ws.dto.PlayerDTO;
import bg.infosys.example.ws.service.PlayerService;
import bg.infosys.example.ws.util.PlayerUtil;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ScheduledTasks {
	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);
	
	private final PlayerService playerService;
	
	public void generatePlayer() {
		PlayerDTO newPlayer = PlayerUtil.generatePlayer();
		playerService.save(newPlayer);
		LOGGER.info("A new player with name {} has been added!", newPlayer.getFullName());
	}
}