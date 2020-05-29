package fr.natsystem.examen.datamodel;

public enum PassengerClass {
	
	FIRST("1st"),
	SECOND("2nd"),
	THIRD("3rd"),
	NOCLASS("No-PClass")
	;
	
	private String code;
	
	private PassengerClass(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}

	public static PassengerClass resolveFromCode(String code) {
		if (FIRST.code.equals(code)) {
			return FIRST;
		} else if (SECOND.code.equals(code)) {
			return SECOND;
		} else if (THIRD.code.equals(code)) {
			return THIRD;
		} else if (NOCLASS.code.equals(code)) {
			return NOCLASS;
		} else {
			return null;
		}
	}
	
}
