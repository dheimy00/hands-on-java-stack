package {{ global_computed_inputs.base_package }}.infrastructure.exceptions.general;

import java.time.LocalDateTime;

public class ResourceNotFoundDetails extends ExceptionDetails {

	public ResourceNotFoundDetails() {
		super();
	}

	public ResourceNotFoundDetails(String title, int status, String detail, LocalDateTime timeStamp,
			String developerMessage) {
		super(title, status, detail, timeStamp, developerMessage);
	}



}
