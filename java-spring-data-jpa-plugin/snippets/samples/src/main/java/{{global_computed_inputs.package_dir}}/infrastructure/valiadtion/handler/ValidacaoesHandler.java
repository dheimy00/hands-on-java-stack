package {{ global_computed_inputs.base_package }}.infrastructure.valiadtion.handler;

import {{ global_computed_inputs.base_package }}.infrastructure.valiadtion.ValidadorStrategy;
import {{ global_computed_inputs.base_package }}.infrastructure.valiadtion.implementions.ValidateProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ValidacaoesHandler {

    List<ValidadorStrategy> validadorStrategies;

    @Autowired
    public ValidacaoesHandler(ValidateProducts validateProducts) {
        validadorStrategies = Arrays.asList(
                validateProducts
        );
    }

    public <T> void executarValidacao(T value) {
        validadorStrategies.forEach(valiadion -> valiadion.executarValidacao(value));
    }
}
