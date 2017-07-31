package app.exceptions;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -694354952032299587L;
	
	private final String login;
        private final int id;
        
	public UserNotFoundException() {
		this.id = 0;
                this.login = "null";
	}
       
        public UserNotFoundException(String login) {
		this.login = login;
                this.id = 0;
	}

	public UserNotFoundException(int id) {
		this.id = id;
                this.login = "null";
	}
	
	public String getLogin() {
		return login;
	}
}

