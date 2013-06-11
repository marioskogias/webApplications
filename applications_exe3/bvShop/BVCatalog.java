package bvShop;

import java.util.Hashtable;

public class BVCatalog {
	/** The vehicles as Hashtable */
	/** the car Model is the key for finding entries */
	private Hashtable<String,VehicleBean> catalog;

	public BVCatalog() {
		System.out.println("called the constructor");
		/** the old catalog remains */
		/** but now the catalog (Hashtable) will contain also beans !!! */
		catalog = new Hashtable<String,VehicleBean>();
		/** Some content - we NOW polulate with some objects!! */
		addV(new VehicleBean("Buick", "General Motors", "1948",new MotorBean()));
		addV(new VehicleBean("Mustang", "Ford", "1960",new MotorBean()));
		addV(new VehicleBean("4CV", "Citroen", "1950",new MotorBean()));
		addV(new VehicleBean("Jeep", "General Motors", "1942",new MotorBean()));
		addV(new VehicleBean("Beatle", "Volkswagen", "1938",new MotorBean()));
	}

	/** FIRST METHOD TO BE EXPOSED - addV */
	/** input argument is now a single ('complex') object !! */
	/** nothing is returned */
	public void addV(VehicleBean vObj) {
		if (vObj == null) {
			throw new IllegalArgumentException(
					"The object provided cannot be null.");
		}
		/** entry format for the Hashtable: key,data */
		/** vObj.getVModel gets the 'key' out of the bean object */
		catalog.put(vObj.getVModel(), vObj);
		System.out.println("Addition at server side: " + vObj.getVModel());
	}

	/** SECOND METHOD TO BE EXPOSED - getVehicleBean */
	/** input argument is a String */
	/** a ('complex') object is returned */
	public VehicleBean getVehicleBean(String model) {
		if (model == null) {
			throw new IllegalArgumentException("carModel cannot be null.");
		}
		// Return the requested vehicle - NOW AS AN OBJECT !!!!
		return (VehicleBean) catalog.get(model);
	}

	/** THIRD METHOD TO BE EXPOSED - listV */
	/** NO input argument - a whole table is returned */
	/** ... , and that with ('complex') objects as entries !!!! */
	public Hashtable<String,VehicleBean> listV() {
		return catalog;
	}

	/** FOURTH METHOD TO BE EXPOSED - delVehicleBean */
	/** input argument is a string */
	/** nothing is returned */

	public void delVehicleBean(String model) {
		
		catalog.remove(model);

	}
}
