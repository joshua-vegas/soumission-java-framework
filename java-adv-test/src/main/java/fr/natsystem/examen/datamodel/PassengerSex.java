package fr.natsystem.examen.datamodel;

public enum PassengerSex {
	MALE("male"),
	FEMALE("female")
	;
	
	private String code;
	
	private PassengerSex(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}

	public static PassengerSex resolveFromCode(String code) {
		if (MALE.code.equals(code)) {
			return MALE;
		} else if (FEMALE.code.equals(code)) {
			return FEMALE;
		} else {
			return null;
		}
	}
}
