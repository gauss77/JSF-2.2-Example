package at.javatraining.jsf.entities;

import java.math.BigInteger;
import java.util.Date;

public class Car {
	BigInteger id;
	String model;
	Engine engine;
	Date releaseDate;
	CommunicationSystem communicationSystem;
	LightSystem lightSystem;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}
	
	public Car withId(BigInteger id) {
		setId(id);
		return this;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public Car withModel(String model) {
		setModel(model);
		return this;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Car withEngine(Engine engine) {
		setEngine(engine);
		return this;
	}	

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public Car withReleaseDate(Date relaseDate){
		setReleaseDate(relaseDate);
		return this;
	}

	public CommunicationSystem getCommunicationSystem() {
		return communicationSystem;
	}

	public void setCommunicationSystem(CommunicationSystem communicationSystem) {
		this.communicationSystem = communicationSystem;
	}
	
	public Car withCommunicationSystem(CommunicationSystem communicationSystem) {
		setCommunicationSystem(communicationSystem);
		return this;
	}

	public LightSystem getLightSystem() {
		return lightSystem;
	}

	public void setLightSystem(LightSystem lightSystem) {
		this.lightSystem = lightSystem;
	}
	
	public Car withLightSystem(LightSystem lightSystem) {
		setLightSystem(lightSystem);
		return this;
	}
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", engine=" + engine + ", communicationSystem="
				+ communicationSystem + ", lightSystem=" + lightSystem + "]";
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
		Car other = (Car) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}