/*
 * (C) SVC 2017
 */
package Converter;

import java.math.BigInteger;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import at.javatraining.jsf.entities.Engine;
import at.javatraining.jsf.services.CarService;

/**
 * TODO: Insert class or interface description here.
 */

@Named
@ApplicationScoped
public class EngineConverter implements Converter {

  @Inject
  CarService carservice;

  /**
   * {@inheritDoc}
   */
  @Override
  public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
    if (value == null || value.trim().isEmpty()) {
      return null;
    }
    
    BigInteger id = new BigInteger(value);
    Engine x = carservice.getEngineById(id);
    if (x != null) {
      return x;
    }
    else {
      throw new ConverterException(new FacesMessage("Keine Engine gefunden"));
    }

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
    if (arg2 == null) {
      return null;
    }

    Engine x = (Engine) arg2;

    return x.getId() + "";
  }

}
