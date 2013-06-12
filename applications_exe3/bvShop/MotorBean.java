package bvShop;

public class MotorBean {

	String MCc;
	String MNo_cylinders;
	String MPs;
	
	public MotorBean() {
	}
	
	public MotorBean(String mcs,String mno_cylinders, String mps) {
		MCc = mcs;
		MNo_cylinders = mno_cylinders;
		MPs = mps;
	}

	public String getMCc() {
		return MCc;
	}
	public void setMCc(String mCc) {
		MCc = mCc;
	}
	public String getMNo_cylinders() {
		return MNo_cylinders;
	}
	public void setMNo_cylinders(String mNo_cylinders) {
		MNo_cylinders = mNo_cylinders;
	}
	public String getMPs() {
		return MPs;
	}
	public void setMPs(String mPs) {
		MPs = mPs;
	}


	public String toString() {
		return MCc + " " + MNo_cylinders + " " + MPs;
}
	
}
