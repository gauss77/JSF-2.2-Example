/*
 * (C) SVC 2017
 */
package at.javatraining.jsf.beans;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * TODO: Insert class or interface description here.
 */

@SessionScoped
@Named
public class LocaleBean implements Serializable{
    private Locale locale;
    private String localecode;
    
    
    
    
    /**
     * Gets the localecode.
     * @return Returns the localecode.
     */
    public String getLocalecode() {
      return localecode;
    }

    /**
     * Sets the localecode.
     * @param localecode The localecode to set.
     */
    public void setLocalecode(String localecode) {
      this.localecode = localecode;
    }

    private LocaleBean() {
      this.locale = Locale.ENGLISH; 
    }

    /**
     * Gets the locale.
     * @return Returns the locale.
     */
    public Locale getLocale() {
      return locale;
    }

    /**
     * Sets the locale.
     * @param locale The locale to set.
     */
    public void setLocale(Locale locale) {
      this.locale = locale;
    }
    
    public void checklocale() {
      if(localecode.equals("de")) {
        changeLocale("de");
      } else {
        changeLocale("en");
      }
    }
    
    public String changeLocale(String x) {
      this.locale = new Locale(x);
      return null;
    }
}
