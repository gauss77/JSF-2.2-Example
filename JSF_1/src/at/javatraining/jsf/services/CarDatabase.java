package at.javatraining.jsf.services;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import at.javatraining.jsf.entities.Car;
import at.javatraining.jsf.entities.CommunicationSystem;
import at.javatraining.jsf.entities.Engine;

@XmlRootElement
class CarDatabase {
	List<Car> cars = new ArrayList<>();
	List<CommunicationSystem> comSystems = new ArrayList<>();
	List<Engine> engines = new ArrayList<>();	
	
	public CarDatabase add(Car car) {
		cars.add(car);
		return this;
	}

	public CarDatabase add(CommunicationSystem comSystem) {
		comSystems.add(comSystem);
		return this;
	}

	public CarDatabase add(Engine engine) {
		engines.add(engine);
		return this;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public List<CommunicationSystem> getComSystems() {
		return comSystems;
	}

	public void setComSystems(List<CommunicationSystem> comSystems) {
		this.comSystems = comSystems;
	}

	public List<Engine> getEngines() {
		return engines;
	}

	public void setEngines(List<Engine> engines) {
		this.engines = engines;
	}
}