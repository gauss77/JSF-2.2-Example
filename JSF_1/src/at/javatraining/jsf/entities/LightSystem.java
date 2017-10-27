package at.javatraining.jsf.entities;

public enum LightSystem {
	HALOGEN("Halogen"), XENON("Xenon"), LED("LED");

	String name;

	private LightSystem(String name) {
		this.name = name;		
	}
	
	public String getName() {
		return name;
	}	
}