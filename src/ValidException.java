
public class ValidException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mess;
	
	ValidException(String message) {
		super(message);
		this.mess = message;
	}

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
