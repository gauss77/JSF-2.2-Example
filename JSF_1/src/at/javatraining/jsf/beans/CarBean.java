/*
 * (C) SVC 2017
 */
package at.javatraining.jsf.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import at.javatraining.jsf.services.CarService;
import at.javatraining.jsf.entities.*;

/**
 * TODO: Insert class or interface description here.
 */
@SessionScoped
@Named
public class CarBean implements Serializable {

  public static List<Car> cars = null;
  private List<Engine> engines = null;
  private List<LightSystem> lightsystems = null;
  private List<CommunicationSystem> comSystem = null;

  @Inject
  private CarService carService;

  @PostConstruct
  public void init() {
    cars = carService.getAllCars();
    engines = carService.getAllEngines();
    comSystem = carService.getAllComSystems();
    lightsystems = new ArrayList<>();
    for (Car car : cars) {
        if(!lightsystems.contains(car.getLightSystem())) {
          lightsystems.add(car.getLightSystem());
      }
    }
  }

  /**
   * Gets the cars.
   * @return Returns the cars.
   */
  public List<Car> getCars() {
    return cars;
  }

  /**
   * Sets the cars.
   * @param cars The cars to set.
   */
  public void setCars(List<Car> cars) {
    this.cars = cars;
  }

  /**
   * Gets the engines.
   * @return Returns the engines.
   */
  public List<Engine> getEngines() {
    return engines;
  }

  /**
   * Sets the engines.
   * @param engines The engines to set.
   */
  public void setEngines(List<Engine> engines) {
    this.engines = engines;
  }

  /**
   * Gets the lightsystems.
   * @return Returns the lightsystems.
   */
  public List<LightSystem> getLightsystems() {
    return lightsystems;
  }

  /**
   * Sets the lightsystems.
   * @param lightsystems The lightsystems to set.
   */
  public void setLightsystems(List<LightSystem> lightsystems) {
    this.lightsystems = lightsystems;
  }

  /**
   * Gets the comSystem.
   * @return Returns the comSystem.
   */
  public List<CommunicationSystem> getComSystem() {
    return comSystem;
  }

  /**
   * Sets the comSystem.
   * @param comSystem The comSystem to set.
   */
  public void setComSystem(List<CommunicationSystem> comSystem) {
    this.comSystem = comSystem;
  }

  /**
   * Gets the carService.
   * @return Returns the carService.
   */
  public CarService getCarService() {
    return carService;
  }

  /**
   * Sets the carService.
   * @param carService The carService to set.
   */
  public void setCarService(CarService carService) {
    this.carService = carService;
  }

  public String deleteCar(Car car) {
    System.out.println("++++++++++++++++++++++++++++++++++++++        Deleting CAR: " + car);
    carService.removeCar(car.getId()); 
    cars.remove(car);
    return null;
  }
  

  public void deleteEngine(Engine engine) {
    engines.remove(engine);
  }
  
  public void deleteSys(CommunicationSystem cs) {
    comSystem.remove(cs);
  }
  
  public void deleteLed(LightSystem lt) {
    lightsystems.remove(lt);
  }
  
}
