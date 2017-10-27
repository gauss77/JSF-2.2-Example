package at.javatraining.jsf.entities;

import java.math.BigInteger;

public class Engine {
	public static enum FuelType {DIESEL, GASOLINE};
	
	BigInteger id;
	int powerInKw;
	int numberOfCylinders;
	FuelType fuelType;
	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}
	
	public Engine withId(BigInteger id) {
		setId(id);
		return this;
	}

	public int getPowerInKw() {
		return powerInKw;
	}

	public void setPowerInKw(int powerInKw) {
		this.powerInKw = powerInKw;
	}
	
	public Engine withPowerInKw(int powerInKw) {
		setPowerInKw(powerInKw);
		return this;
	}

	public int getNumberOfCylinders() {
		return numberOfCylinders;
	}

	public void setNumberOfCylinders(int numberOfCylinders) {
		this.numberOfCylinders = numberOfCylinders;
	}
	
	public Engine withNumberOfCylinders(int numberOfCylinders) {
		setNumberOfCylinders(numberOfCylinders);
		return this;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {		
		this.fuelType = fuelType;
	}
	
	public Engine withFuelType(FuelType fuelType) {
		setFuelType(fuelType);
		return this;
	}

	@Override
	public String toString() {
		return "Engine [id=" + id + ", powerInKw=" + powerInKw + ", numberOfCylinders=" + numberOfCylinders
				+ ", fuelType=" + fuelType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Engine other = (Engine) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}