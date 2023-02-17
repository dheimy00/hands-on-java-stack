package {{ global_computed_inputs.base_package }}.infrastructure.exceptions.requests;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FieldError {

    private String field;
    private String errorMessage;

}
