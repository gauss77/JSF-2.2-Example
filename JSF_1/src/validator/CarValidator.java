/*
 * (C) SVC 2017
 */
package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * TODO: Insert class or interface description here.
 */

@FacesValidator("carValidator")
public class CarValidator implements Validator {

  /**
   * {@inheritDoc}
   */
  @Override
  public void validate(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {
    if (value instanceof String) {
     String strValue = (String) value;
      
    
    if(strValue.isEmpty()) {
      FacesMessage fm = new FacesMessage("Wert darf nicht leer sein!");
      fm.setSeverity(FacesMessage.SEVERITY_ERROR);
      throw new ValidatorException(fm);
    } else if(strValue.length() < 5) {
      FacesMessage fm = new FacesMessage("Wert darf nicht kleiner 5 sein!");
      fm.setSeverity(FacesMessage.SEVERITY_ERROR);
      throw new ValidatorException(fm);
    }else if(strValue.length() > 30) {
      FacesMessage fm = new FacesMessage("Wert darf nicht größer 30 sein!");
      fm.setSeverity(FacesMessage.SEVERITY_ERROR);
      throw new ValidatorException(fm);
    }else if(!strValue.contains("Porsche")) {
      FacesMessage fm = new FacesMessage("Wert muss 'Porsche' beinhalten!");
      fm.setSeverity(FacesMessage.SEVERITY_ERROR);
      throw new ValidatorException(fm);
    } else {
      return;
    }
    
  }else {
    throw new ValidatorException(new FacesMessage("Kein Text"));
  }

}
}
