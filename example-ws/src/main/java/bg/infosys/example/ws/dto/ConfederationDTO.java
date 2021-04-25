package bg.infosys.example.ws.dto;

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
@ApiModel(description = "Class representing a confederation in the application")
public class ConfederationDTO {
	@ApiModelProperty(
			  value = "Unique identifier of the Confederation",
			  name = "id",
			  dataType = "Long",
			  example = "5",
			  required = true,
			  position = 0)
	@Setter private Long id;
	
	@ApiModelProperty(
			  value = "Name of the Confederation",
			  name = "name",
			  dataType = "String",
			  example = "UEFA",
			  required = true,
			  position = 1)
	@NotBlank(message = "Name cannot be blank")
	@Size(max = 32, message = "Name length must be less than or equal to 32 characters")
	private String name;
	
	@ApiModelProperty(
			  value = "Founded",
			  name = "founded",
			  dataType = "String",
			  example = "1954",
			  required = true,
			  position = 2)
	@NotBlank(message = "Founded cannot be blank")
	@Size(max = 4, message = "Founded length must be less than or equal to 4 characters")
	private String founded;
	
	@ApiModelProperty(
			  value = "Headquarters",
			  name = "headquarters",
			  dataType = "String",
			  example = "Basel, Switzerland",
			  required = true,
			  position = 3)
	@NotBlank(message = "Headquarters cannot be blank")
	@Size(max = 64, message = "Headquarters length must be less than or equal to 64 characters")
	private String headquarters;
}
