package bg.infosys.example.ws.controller.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class APIError {
	private String code;
	private String name;
	private String description;
}
