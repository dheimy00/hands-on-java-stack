package {{ global_computed_inputs.base_package }}.infrastructure.exceptions.general;


import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ResourceInternalServerErrorException extends RuntimeException {

    public ResourceInternalServerErrorException(String mensagem) {
        super(mensagem);
    }

    public ResourceInternalServerErrorException(String mensagem, Throwable throwable) {
        super(mensagem, throwable);
    }
}
