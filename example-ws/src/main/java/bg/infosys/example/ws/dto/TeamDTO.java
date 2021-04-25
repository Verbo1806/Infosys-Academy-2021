package bg.infosys.example.ws.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Class representing a team in the application")
public class TeamDTO {
	@ApiModelProperty(
			  value = "Unique identifier of the Team",
			  name = "id",
			  dataType = "Long",
			  example = "18",
			  required = true,
			  position = 0)
	@Setter private Long id;
	
	@ApiModelProperty(
			  value = "Name of the Team",
			  name = "name",
			  dataType = "String",
			  example = "Levski Sofia",
			  required = true,
			  position = 1)
	@NotBlank(message = "Name cannot be blank")
	@Size(max = 32, message = "Name length must be less than or equal to 32 characters")
	private String name;
	
	@ApiModelProperty(
			  value = "Team abbreaviature",
			  name = "abbreaviature",
			  dataType = "String",
			  example = "LEV",
			  required = true,
			  position = 1)
	@NotBlank(message = "Abbreaviature cannot be blank")
	@Size(max = 4, message = "Abbreaviature length must be less than or equal to 4 characters")
	private String abbreaviature;

	@ApiModelProperty(
			  value = "Founded",
			  name = "founded",
			  dataType = "String",
			  example = "1914",
			  required = true,
			  position = 2)
	@NotBlank(message = "Founded cannot be blank")
	@Size(max = 4, message = "Founded length must be less than or equal to 4 characters")
	private String founded;
	
	@ApiModelProperty(
			  value = "Team ground",
			  name = "ground",
			  dataType = "GroundDTO",
			  required = false,
			  position = 3)
	private GroundDTO ground;
	
	@ApiModelProperty(
			  value = "Team league",
			  name = "league",
			  dataType = "LeagueDTO",
			  required = false,
			  position = 4)
	private LeagueDTO league;
	
	@ApiModelProperty(
			  value = "Team players list",
			  name = "players",
			  dataType = "List<PlayerDTO>",
			  required = false,
			  position = 5)
	private List<PlayerDTO> players;
}
