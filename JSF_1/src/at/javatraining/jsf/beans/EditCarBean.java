/*
 * (C) SVC 2017
 */
package at.javatraining.jsf.beans;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
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

@SessionScoped
@Named
public class EditCarBean implements Serializable{
  
  private Car car = null;
  private String model = null;
  private Engine engine = null;
  private CommunicationSystem communicationSystem = null;
  private LightSystem lightSystem = null;
  private boolean edit=false;
  
  private String imageUrl = null;
 
  @Inject
  private CarService carService;
  
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
   * Gets the edit.
   * @return Returns the edit.
   */
  public boolean isEdit() {
    return edit;
  }
  /**
   * Sets the edit.
   * @param edit The edit to set.
   */
  public void setEdit(boolean edit) {
    this.edit = edit;
  }
  /**
   * Gets the imageUrl.
   * @return Returns the imageUrl.
   */
  public String getimageUrl() {
    return imageUrl;
  }
  /**
   * Sets the imageUrl.
   * @param imageUrl The imageUrl to set.
   */
  public void setimageUrl(String imageUrl) {
    imageUrl = imageUrl;
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
  
  public String createCar() {
    this.car = new Car();
    this.model="";
    return "/CarEdit.xhtml";
  }
  
  public String configureCar(Car x) {
    this.car = x;
    model=car.getModel();
    engine=car.getEngine();
    communicationSystem=car.getCommunicationSystem();
    lightSystem=car.getLightSystem();
    return "/CarEdit.xhtml";
  }
  
  public String addCar() {
    if(car.getId() == null) {   // wenn neues Auto
      car.setReleaseDate(new Date());
    } else {                    // wenn ein besthendes
      CarBean.cars.remove(car);
    }

    car.setModel(model);
    car.setEngine(engine);
    car.setLightSystem(lightSystem);
    car.setCommunicationSystem(communicationSystem);

    System.out.println("++++++++++++++++++++++++++++++++++++++++ addCar-Method ---   " +  car);
    carService.saveCar(car);
    CarBean.cars.add(car);
    return "/cars.xhtml";
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
