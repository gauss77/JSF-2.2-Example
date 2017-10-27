/*
 * (C) SVC 2017
 */
package at.javatraining.jsf.beans;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

import at.javatraining.jsf.entities.Car;
import at.javatraining.jsf.entities.CommunicationSystem;
import at.javatraining.jsf.entities.Engine;
import at.javatraining.jsf.entities.LightSystem;
import at.javatraining.jsf.services.CarService;

/**
 * TODO: Insert class or interface description here.
 */

@Named
@FlowScoped("carflow")
public class FlowBean implements Serializable {
  private boolean porscheOrNot = true;
  private String model;
  private Car car = null;
  private Engine engine = null;
  private CommunicationSystem communicationSystem = null;
  private LightSystem lightSystem = null;
  private String imageUrl = "/resources/images/Porsche_1.jpg";
  
  @Inject
  CarService carservice;
  
  
  
  /**
   * Gets the imageUrl.
   * @return Returns the imageUrl.
   */
  public String getImageUrl() {
    return imageUrl;
  }

  /**
   * Sets the imageUrl.
   * @param imageUrl The imageUrl to set.
   */
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  /**
   * Gets the engine.
   * @return Returns the engine.
   */
  public Engine getEngine() {
    return engine;
  }

  /**
   * Sets the engine.
   * @param engine The engine to set.
   */
  public void setEngine(Engine engine) {
    this.engine = engine;
  }

  /**
   * Gets the communicationSystem.
   * @return Returns the communicationSystem.
   */
  public CommunicationSystem getCommunicationSystem() {
    return communicationSystem;
  }

  /**
   * Sets the communicationSystem.
   * @param communicationSystem The communicationSystem to set.
   */
  public void setCommunicationSystem(CommunicationSystem communicationSystem) {
    this.communicationSystem = communicationSystem;
  }

  /**
   * Gets the lightSystem.
   * @return Returns the lightSystem.
   */
  public LightSystem getLightSystem() {
    return lightSystem;
  }

  /**
   * Sets the lightSystem.
   * @param lightSystem The lightSystem to set.
   */
  public void setLightSystem(LightSystem lightSystem) {
    this.lightSystem = lightSystem;
  }

  /**
   * Gets the car.
   * @return Returns the car.
   */
  public Car getCar() {
    return car;
  }

  /**
   * Sets the car.
   * @param car The car to set.
   */
  public void setCar(Car car) {
    this.car = car;
  }

  /**
   * Gets the model.
   * @return Returns the model.
   */
  public String getModel() {
    return model;
  }

  /**
   * Sets the model.
   * @param model The model to set.
   */
  public void setModel(String model) {
    this.model = model;
  }

  /**
   * Gets the porscheOrNot.
   * @return Returns the porscheOrNot.
   */
  public boolean isPorscheOrNot() {
    return porscheOrNot;
  }

  /**
   * Sets the porscheOrNot.
   * @param porscheOrNot The porscheOrNot to set.
   */
  public void setPorscheOrNot(boolean porscheOrNot) {
    this.porscheOrNot = porscheOrNot;
  }
  
  public void saveCarAction() {
    this.car = new Car();

    car.setModel(model);
    car.setEngine(engine);
    car.setLightSystem(lightSystem);
    car.setCommunicationSystem(communicationSystem);
    car.setReleaseDate(new Date());
    
    System.out.println("++++++++++++++++++++++++++++++++++++++++ saveCarAction-Method ---   " +  car);
    carservice.saveCar(car);
    CarBean.cars.add(car);
  }
  
  public void changefoto(Engine e) {
    e = this.engine;
    BigInteger one = new BigInteger(String.valueOf(1));
    BigInteger two = new BigInteger(String.valueOf(2));
    BigInteger three = new BigInteger(String.valueOf(3));
    
    if(e.getId().equals(one)) {
      imageUrl = "/resources/images/Porsche_1.jpg";
    } else if(e.getId().equals(two)) {
      imageUrl = "/resources/images/Porsche_2.jpg";
    } else if(e.getId().equals(three)) {
      imageUrl = "/resources/images/Porsche_3.jpg";
    }
  }
  
  
}
