package bg.infosys.example.ws.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

import bg.infosys.example.ws.dto.PlayerDTO;

public class PlayerUtil {
	private static Random rand = new Random();
	
	private PlayerUtil() {
		throw new IllegalStateException("Utility class");
	}
	
	public static PlayerDTO generatePlayer() {
		return PlayerDTO.builder()
						.shirtNumber((short) rand.nextInt(99))
						.bornAt(generateBirthDate())
						.fullName(generatePlayerName())
						.build();
	}

	private static String generatePlayerName() {
		return PlayerNames.FIRST_NAME[rand.nextInt(PlayerNames.FIRST_NAME.length)] + " " +
				PlayerNames.LAST_NAME[rand.nextInt(PlayerNames.LAST_NAME.length)];
	}

	private static LocalDateTime generateBirthDate() {
        int year = randBetween(1980, 2003);
        int dayOfYear = randBetween(1, 365);
        
        LocalDate date = LocalDate.ofYearDay(year, dayOfYear);
        
        return date.atStartOfDay();
    }

    private static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
}
