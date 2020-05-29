package fr.natsystem.examen.datamodel;

public class Passenger implements Comparable<Passenger> {
	private String name;
	private PassengerClass passengerClass;
	private Double age;
	private PassengerSex sex;
	private Boolean survived;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PassengerClass getPassengerClass() {
		return passengerClass;
	}
	public void setPassengerClass(PassengerClass passengerClass) {
		this.passengerClass = passengerClass;
	}
	public Double getAge() {
		return age;
	}
	public void setAge(Double age) {
		this.age = age;
	}
	public PassengerSex getSex() {
		return sex;
	}
	public void setSex(PassengerSex sex) {
		this.sex = sex;
	}
	public Boolean getSurvived() {
		return survived;
	}
	public void setSurvived(Boolean survived) {
		this.survived = survived;
	}
	
		
	@Override
	public int compareTo(Passenger passenger) {
		return this.passengerClass.compareTo(passenger.passengerClass);
	}
	
}
