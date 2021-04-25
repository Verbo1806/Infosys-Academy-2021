package bg.infosys.example.ws.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import bg.infosys.common.utils.DateTimeUtil;
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
@ApiModel(description = "Class representing a player in the application")
public class PlayerDTO {
	@ApiModelProperty(
			  value = "Unique identifier of the Player",
			  name = "id",
			  dataType = "Long",
			  example = "1806",
			  required = true,
			  position = 0)
    @Setter private Long id;
	
	@ApiModelProperty(
			  value = "Shirt number",
			  name = "shirtNumber",
			  dataType = "Short",
			  example = "9",
			  required = true,
			  position = 1)
	@PositiveOrZero(message = "Shirt number must be a positive number or zero")
    private Short shirtNumber;
	
	@ApiModelProperty(
			  value = "Full name",
			  name = "fullName",
			  dataType = "String",
			  example = "Garra Dembele",
			  required = true,
			  position = 2)
	@NotBlank(message = "Full name cannot be blank")
	@Size(max = 64, message = "Full name length must be less than or equal to 64 characters")
    private String fullName;
	
	@ApiModelProperty(
			  value = "Date of birth",
			  name = "bornAt",
			  dataType = "Date",
			  example = "1986-02-21 00:00:00",
			  required = false,
			  position = 3)
	@Past(message = "Born at must be a date in the past")
	@JsonFormat(pattern=DateTimeUtil.DATETIME_FORMAT)
    private LocalDateTime bornAt;
	
    private TeamDTO team;
}
