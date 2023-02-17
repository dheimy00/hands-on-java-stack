package {{ global_computed_inputs.base_package }}.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import static i{{ global_computed_inputs.base_package }}.infrastructure.constants.Constants.Category.ID_CATEGORY;
import static {{ global_computed_inputs.base_package }}.infrastructure.constants.Constants.Product.*;

@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName(value = "data")
public class ProductDto {

    @JsonProperty(ID_PRODUCT)
    private String idProduct;

    @NotBlank(message = "Product identifier may not be null")
    @Size(min = 2, max = 32, message = "Product identifier must be between 2 and 32 characters long")
    @JsonProperty(PRODUCT_IDENTIFIER)
    private String productIdentifier;

    @NotBlank(message = "Name may not be null")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    @JsonProperty(NAME)
    private String name;

    @NotBlank(message = "Description may not be null")
    @Size(min = 2, max = 32, message = "Description must be between 2 and 32 characters long")
    @JsonProperty(DESCRIPTION)
    private String description;

    @NotNull(message = "Price may not be null")
    @JsonProperty(PRICE)
    private Double price;

    @NotNull(message = "idCategory may not be null")
    @JsonProperty(ID_CATEGORY)
    private String idCategory;

}
