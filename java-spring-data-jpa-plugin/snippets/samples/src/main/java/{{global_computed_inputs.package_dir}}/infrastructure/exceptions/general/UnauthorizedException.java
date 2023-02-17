package {{ global_computed_inputs.base_package }}.infrastructure.exceptions.general;

public class UnauthorizedException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnauthorizedException() {
	}

	public UnauthorizedException(String message) {
        super(message);
    }

}