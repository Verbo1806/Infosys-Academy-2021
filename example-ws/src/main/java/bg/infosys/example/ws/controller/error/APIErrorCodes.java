package bg.infosys.example.ws.controller.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum APIErrorCodes {
	METHOD_ARG_NOT_VALID 		("EX-400-1", "Method argument not valid", 	"Invalid arguments are passed to the API endpoint!"),
	
	UNKNOWN_SERVER_EXCEPTION	("EX-500-1", "Unknown server exception", 	"An unknown server error has occurred!");
	
	private String code;
	private String message;
	private String description;
}