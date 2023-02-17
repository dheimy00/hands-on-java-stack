package {{ global_computed_inputs.base_package }}.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static {{ global_computed_inputs.base_package }}.infrastructure.constants.Constants.Category.*;

@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName(value = "data")
public class CategoryDto {

    @JsonProperty(ID_CATEGORY)
    private String idCategory;

    @NotBlank(message = "Name may not be null")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    @JsonProperty(NAME)
    private String name;

}