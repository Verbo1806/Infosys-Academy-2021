package bg.infosys.example.ws.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
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
@ApiModel(description = "Class representing a league in the application")
public class LeagueDTO {
	@ApiModelProperty(
			  value = "Unique identifier of the League",
			  name = "id",
			  dataType = "Long",
			  example = "1",
			  required = true,
			  position = 0)
	@Setter private Long id;
	
	@ApiModelProperty(
			  value = "Name of the League",
			  name = "name",
			  dataType = "String",
			  example = "EFBET League",
			  required = true,
			  position = 1)
	@NotBlank(message = "Name cannot be blank")
	@Size(max = 32, message = "Name length must be less than or equal to 32 characters")
	private String name;
	
	@ApiModelProperty(
			  value = "Founded",
			  name = "founded",
			  dataType = "String",
			  example = "1948",
			  required = true,
			  position = 2)
	@NotBlank(message = "Founded cannot be blank")
	@Size(max = 4, message = "Founded length must be less than or equal to 4 characters")
	private String founded;
	
	@ApiModelProperty(
			  value = "League confederation",
			  name = "confederation",
			  dataType = "ConfederationDTO",
			  required = false,
			  position = 3)
	private ConfederationDTO confederation;
	
	@ApiModelProperty(
			  value = "League origin",
			  name = "country",
			  dataType = "CountryDTO",
			  required = false,
			  position = 4)
	private CountryDTO country;
	
	@ApiModelProperty(
			  value = "League competition type",
			  name = "type",
			  dataType = "CompetitionTypeDTO",
			  required = false,
			  position = 5)
	private CompetitionTypeDTO type;
	
	@ApiModelProperty(
			  value = "League teams number",
			  name = "numberOfTeams",
			  dataType = "Short",
			  example = "14",
			  required = true,
			  position = 6)
	@PositiveOrZero(message = "Number of teams must be a positive number or zero")
	private Short numberOfTeams;
	
	@ApiModelProperty(
			  value = "League level on pyramid",
			  name = "levelOnPyramid",
			  dataType = "Short",
			  example = "1",
			  required = true,
			  position = 7)
	@PositiveOrZero(message = "Level on pyramid must be a positive number")
	private Short levelOnPyramid;
}
