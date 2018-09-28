package edu.nd.sarec.railwaycrossing.model.infrastructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;
import edu.nd.sarec.railwaycrossing.model.vehicles.Car;

public class TJunction {

	HashMap<String, Collection<Car>> roadLists;

	public TJunction () {
		roadLists = new HashMap<String, Collection<Car>>();
		buildSubRoadLists();
	}

	private void buildSubRoadLists() {
		roadLists.put("NE", new Vector<Car>());
		roadLists.put("NW", new Vector<Car>());
		roadLists.put("EW", new Vector<Car>());
		roadLists.put("SE", new Vector<Car>());
		roadLists.put("SW", new Vector<Car>());

	}

	public HashMap<String, Collection<Car>> getSubRoadLists() {
		return roadLists;
	}
	
	public Collection<Car> getSubRoadList(String name) {
		return roadLists.get(name);
	}
	
}