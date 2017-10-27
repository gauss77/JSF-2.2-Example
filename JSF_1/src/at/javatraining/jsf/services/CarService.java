package at.javatraining.jsf.services;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import at.javatraining.jsf.entities.Car;
import at.javatraining.jsf.entities.CommunicationSystem;
import at.javatraining.jsf.entities.Engine;
import at.javatraining.jsf.entities.LightSystem;

@Singleton
@Startup        // Startup bewirkt dass diese Klassse beim Start der Applikatoin geladen wird
public class CarService {

	public final File DATABASE_FILE = Paths.get(System.getProperty("user.home"), "carDatabase.xml").toFile();
	private Logger logger = Logger.getAnonymousLogger();
	private CarDatabase database;

	@PostConstruct
	private void init() {
		database = new CarDatabase();
		readDatabase();
		if (!isDatabaseInitialized()) {
			initDatabase();
			writeDatabase();
		}
	}

	public boolean isDatabaseInitialized() {
		return !database.getCars().isEmpty();
	}

	public synchronized List<Engine> getAllEngines() {
		return new ArrayList<>(database.engines);
	}

	public Engine getEngineById(BigInteger id) {
		return getAllEngines().stream().filter(e -> e.getId().equals(id)).findAny().orElse(null);
	}

	public synchronized List<CommunicationSystem> getAllComSystems() {
		return new ArrayList<>(database.comSystems);
	}

	public CommunicationSystem getComSystemById(BigInteger id) {
		return getAllComSystems().stream().filter(c -> c.getId().equals(id)).findAny().orElse(null);
	}

	public synchronized List<Car> getAllCars() {
		return database.cars.stream().sorted(Comparator.comparing(Car::getModel)).collect(Collectors.toList());
	}

	public synchronized Car getCarById(BigInteger id) {
		return database.cars.stream().filter(c -> c.getId().equals(id)).findAny().orElse(null);
	}

	public synchronized void saveCar(Car car) {
		if (car.getId() == null) {
			long nextId = database.cars.stream().mapToLong(c -> c.getId().longValue()).max().orElse(0);
			nextId++;
			car.setId(BigInteger.valueOf(nextId));
		}
		database.cars.remove(car);
		database.cars.add(car);
		database.engines.remove(car.getEngine());
		database.engines.add(car.getEngine());
		database.comSystems.remove(car.getCommunicationSystem());
		database.comSystems.add(car.getCommunicationSystem());
		writeDatabase();
	}

	public void removeCar(BigInteger id) {
		database.cars.removeIf(c -> c.getId().equals(id));
		writeDatabase();
	}

	synchronized void readDatabase() {
		try {
			database = new CarDatabase();
			logger.info("reading database");
			JAXBContext ctx = JAXBContext.newInstance(CarDatabase.class);
			Unmarshaller unmarshaller = ctx.createUnmarshaller();
			database = (CarDatabase) unmarshaller.unmarshal(DATABASE_FILE);
		} catch (JAXBException e) {
			logger.severe("Error reading database");
		}
	}

	synchronized void writeDatabase() {
		logger.info("writing database");
		JAXBContext ctx;
		try {
			ctx = JAXBContext.newInstance(CarDatabase.class);
			Marshaller marshaller = ctx.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(database, DATABASE_FILE);
		} catch (JAXBException e) {
			logger.severe("Error writing database");
		}

	}

	void initDatabase() {
		database = new CarDatabase();
		Engine suvEngine = new Engine().withFuelType(Engine.FuelType.DIESEL).withId(BigInteger.valueOf(1))
				.withNumberOfCylinders(6).withPowerInKw(150);
		database.engines.add(suvEngine);
		Engine racingEngine = new Engine().withFuelType(Engine.FuelType.GASOLINE).withId(BigInteger.valueOf(2))
				.withNumberOfCylinders(8).withPowerInKw(400);
		database.engines.add(racingEngine);
		Engine ecoEngine = new Engine().withFuelType(Engine.FuelType.GASOLINE).withId(BigInteger.valueOf(3))
				.withNumberOfCylinders(4).withPowerInKw(75);
		database.engines.add(ecoEngine);
		CommunicationSystem radioSystem = new CommunicationSystem().withId(BigInteger.valueOf(1)).withName("Radio")
				.withRadio(true).withIntercom(false).withNavigation(false);
		database.comSystems.add(radioSystem);
		CommunicationSystem comSystem = new CommunicationSystem().withId(BigInteger.valueOf(2))
				.withName("Intercom System").withRadio(true).withIntercom(true).withNavigation(false);
		database.comSystems.add(comSystem);
		CommunicationSystem navSystem = new CommunicationSystem().withId(BigInteger.valueOf(3))
				.withName("Navigation System").withRadio(true).withIntercom(true).withNavigation(true);
		database.comSystems.add(navSystem);

		Car macan = new Car().withId(BigInteger.valueOf(1)).withCommunicationSystem(navSystem).withEngine(suvEngine)
				.withLightSystem(LightSystem.LED).withModel("Porsche Macan").withReleaseDate(new Date());
		database.cars.add(macan);
		Car P911 = new Car().withId(BigInteger.valueOf(2)).withCommunicationSystem(comSystem).withEngine(racingEngine)
				.withLightSystem(LightSystem.XENON).withModel("Porsche 911").withReleaseDate(new Date());
		database.cars.add(P911);
		Car boxter = new Car().withId(BigInteger.valueOf(3)).withCommunicationSystem(comSystem).withEngine(ecoEngine)
				.withLightSystem(LightSystem.HALOGEN).withModel("Porsche Boxter").withReleaseDate(new Date());
		database.cars.add(boxter);
	}
}