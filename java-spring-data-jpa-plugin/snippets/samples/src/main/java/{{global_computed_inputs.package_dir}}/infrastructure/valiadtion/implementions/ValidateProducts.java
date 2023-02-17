package {{ global_computed_inputs.base_package }}.infrastructure.valiadtion.implementions;

import {{ global_computed_inputs.base_package }}.dto.ProductDto;
import {{ global_computed_inputs.base_package }}.exceptions.errors.Errors;
import {{ global_computed_inputs.base_package }}.exceptions.requests.ApplicationException;
import {{ global_computed_inputs.base_package }}.infrastructure.valiadtion.ValidadorStrategy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Component
public class ValidateProducts implements ValidadorStrategy<ProductDto> {

    @Override
    public void executarValidacao(ProductDto product) {
        if (!Objects.isNull(product)) {
            if (product.getPrice() <= 0) {
                throw new ApplicationException(Errors.PRODUCT_BAD_REQUEST_PRICE, Map.of("id",product.getPrice()));
            } else if (!StringUtils.isBlank(product.getName()) && !product.getName().matches("[a-zA-Z]*")) {
                throw new ApplicationException(Errors.PRODUCT_BAD_REQUEST_ALPHABET, Map.of("",product.getName()));
            }
        }

    }
}
