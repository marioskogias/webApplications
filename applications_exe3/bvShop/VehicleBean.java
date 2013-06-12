package bvShop;

public class VehicleBean {
	String VModel;
	String VManufacturer;
	String VYear;
	public	MotorBean VMotor;

	/** The following non-argument constructor MUST be always present */
	/** for this class to be a Java Bean */
	public VehicleBean() {
	}

	/** Another constructor CAN also be always present */
	/**
	 * the following initializes all properties whenever a new object is
	 * instantiated (with 'new') -
	 */
	public VehicleBean(String model, String manu, String year,MotorBean motor) {
		this.VModel = model;
		this.VManufacturer = manu;
		this.VYear = year;
		this.VMotor = motor;
	}

	/** get & set methods for all properties MUST be present */
	public String getVModel() {
		return VModel;
	}

	public void setVModel(String model) {
		this.VModel = model;
	}

	public String getVManufacturer() {
		return VManufacturer;
	}

	public void setVManufacturer(String manu) {
		this.VManufacturer = manu;
	}

	public String getVYear() {
		return VYear;
	}

	public void setVYear(String year) {
		this.VYear = year;
	}
	
	public MotorBean getVMotor() {
		return VMotor;
	}

	public void setVMotor(MotorBean motor) {
		this.VMotor = motor;
	}

	// toString is an in-built method for every Java object. Outputs an
	// informative string
	public String toString() {
		return "'" + VModel + "' by " + VManufacturer + " (" + VYear + ") and motor " + VMotor;
	}
}
