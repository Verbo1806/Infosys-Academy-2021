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
@ApiModel(description = "Class representing a ground in the application")
public class GroundDTO {
	@ApiModelProperty(
			  value = "Unique identifier of the Ground",
			  name = "id",
			  dataType = "Long",
			  example = "3",
			  required = true,
			  position = 0)
	@Setter private Long id;
	
	@ApiModelProperty(
			  value = "Name of the Ground",
			  name = "name",
			  dataType = "String",
			  example = "Vivacom Arena Georgi Asparuhov",
			  required = true,
			  position = 1)
	@NotBlank(message = "Name cannot be blank")
	@Size(max = 32, message = "Name length must be less than 32 characters")
	private String name;
	
	@ApiModelProperty(
			  value = "Capacity of the Ground",
			  name = "capacity",
			  dataType = "String",
			  example = "29 200",
			  required = true,
			  position = 2)
	@PositiveOrZero(message = "Capacity must be a positive number or zero")
	private int capacity;
	
	@ApiModelProperty(
			  value = "Address of the Ground",
			  name = "address",
			  dataType = "String",
			  example = "Poduene, Sofia",
			  required = true,
			  position = 3)
	@NotBlank(message = "Address cannot be blank")
	@Size(max = 1024, message = "Address length must be less than 1024 characters")
	private String address;
	
	@ApiModelProperty(
			  value = "Founded",
			  name = "founded",
			  dataType = "String",
			  example = "1963",
			  required = true,
			  position = 4)
	@NotBlank(message = "Founded cannot be blank")
	@Size(max = 4, message = "Founded length must be less than 4 characters")
	private String founded;
	
	@ApiModelProperty(
			  value = "Ground category",
			  name = "category",
			  dataType = "StadiumCategoryDTO",
			  required = false,
			  position = 5)
	private StadiumCategoryDTO category;
	
	@ApiModelProperty(
			  value = "Ground surface",
			  name = "surface",
			  dataType = "SurfaceTypeDTO",
			  required = false,
			  position = 6)
	private SurfaceTypeDTO surface;
}
