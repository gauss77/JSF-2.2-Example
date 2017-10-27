package at.javatraining.jsf.entities;

import java.math.BigInteger;

public class CommunicationSystem {
	BigInteger id;
	String name;
	boolean navigation;
	boolean radio;
	boolean intercom;
	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}
	
	public CommunicationSystem withId(BigInteger id) {
		setId(id);
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public CommunicationSystem withName(String name) {
		setName(name);
		return this;
	}

	public boolean isNavigation() {
		return navigation;
	}

	public void setNavigation(boolean navigation) {
		this.navigation = navigation;
	}
	
	public CommunicationSystem withNavigation(boolean navigation) {
		setNavigation(navigation);
		return this;
	}

	public boolean isRadio() {
		return radio;
	}

	public void setRadio(boolean radio) {
		this.radio = radio;
	}
	
	public CommunicationSystem withRadio(boolean radio) {
		setRadio(radio);
		return this;
	}

	public boolean isIntercom() {
		return intercom;
	}

	public void setIntercom(boolean intercom) {
		this.intercom = intercom;
	}
	
	public CommunicationSystem withIntercom(boolean intercom) {
		setIntercom(intercom);
		return this;
	}

	@Override
	public String toString() {
		return "CommunicationSystem [id=" + id + ", name=" + name + ", navigation=" + navigation + ", radio=" + radio
				+ ", intercom=" + intercom + "]";
	}
}