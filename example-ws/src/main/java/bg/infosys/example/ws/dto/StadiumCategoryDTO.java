package bg.infosys.example.ws.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Class representing a stadium category in the application")
public class StadiumCategoryDTO {
	@ApiModelProperty(
			  value = "Unique string identifier of the Stadium Category",
			  name = "code",
			  dataType = "String",
			  example = "SC1",
			  required = true,
			  position = 0)
	@NotBlank(message = "Code cannot be blank")
	@Size(max = 4, message = "Code length must be less than or equal to 4 characters")
	private String code;
	
	@ApiModelProperty(
			  value = "Name of the Stadium Category",
			  name = "name",
			  dataType = "String",
			  example = "Stadium Category 1",
			  required = true,
			  position = 1)
	@NotBlank(message = "Name cannot be blank")
	@Size(max = 32, message = "Name length must be less than or equal to 32 characters")
	private String name;
	
	@ApiModelProperty(
			  value = "Description of the Stadium Category",
			  name = "description",
			  dataType = "String",
			  example = "Stadium Category 1 description",
			  required = true,
			  position = 2)
	@NotBlank(message = "Description cannot be blank")
	@Size(max = 1024, message = "Description length must be less than or equal to 1024 characters")
	private String description;
}
