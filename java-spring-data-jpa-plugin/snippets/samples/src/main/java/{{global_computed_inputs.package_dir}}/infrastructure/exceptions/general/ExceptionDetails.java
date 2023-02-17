package {{ global_computed_inputs.base_package }}.infrastructure.exceptions.general;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionDetails {

    protected String title;

    protected int status;

    protected String detail;

    protected LocalDateTime timeStamp;

    protected String developerMessage;

}
