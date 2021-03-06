/*
 *
 * BVAdderlister.java
 *
 */

import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.soap.Constants;
import org.apache.soap.Fault;
import org.apache.soap.SOAPException;
import org.apache.soap.encoding.SOAPMappingRegistry;
import org.apache.soap.encoding.soapenc.BeanSerializer;
import org.apache.soap.rpc.Call;
import org.apache.soap.rpc.Parameter;
import org.apache.soap.rpc.Response;
import org.apache.soap.util.xml.QName;
import java.util.Scanner;

import bvShop.VehicleBean;
import bvShop.MotorBean;

public class BVAdderLister {

	public Call call;
	public URL url;

	public BVAdderLister(String address) {

		/*add the target url*/
		try {
			url = new URL(address);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		SOAPMappingRegistry reg = new SOAPMappingRegistry();
		BeanSerializer serializer = new BeanSerializer();

		reg.mapTypes(Constants.NS_URI_SOAP_ENC,
				new QName("urn:VBean_xmlns","vObj"),
				VehicleBean.class, serializer, serializer);

		reg.mapTypes(Constants.NS_URI_SOAP_ENC,
				new QName("urn:MBean_xmlns","mObj"),
				MotorBean.class, serializer, serializer);
		
		//Build the Call object
		call = new Call();
		//How to map, where to send, method to call, encoding "style"
		call.setSOAPMappingRegistry(reg);
		call.setTargetObjectURI("urn:BVehicleCatalog");
		call.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC); 


	}

	public void add(String model,String manufacturer,String year, String MCs,String MNo_cylinders, String MPs) {
		MotorBean motor = new MotorBean(MCs,MNo_cylinders,MPs);
		VehicleBean vObj = new VehicleBean(model, manufacturer, year,motor);

		this.call.setMethodName("addV");

		System.out.println("Adding vehicle model '" + model + "' by " + manufacturer);
		// Set up the parameters of the call
		Vector params = new Vector();
		//in the instructions given to the 'Serializer' - see Depl. Descr.
		params.addElement(new Parameter("vObj", VehicleBean.class, vObj, null)); 
		this.call.setParams(params);
		// Invoke the call
		try {
			Response response;
			response = call.invoke(this.url, "");
			//We do not expect something back, unless there is a fault!!
			if (!response.generatedFault())
				System.out.println("Server reported NO FAULT while adding vehicle");
			else { 
				Fault fault = response.getFault();
				System.out.println("Server reported FAULT while adding:");
				System.out.println(fault.getFaultString());
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void list() {

		/* Another method is now called*/
		this.call.setMethodName("listV"); 

		/* NO parameters here !!*/
		/*(we cannot have a call with arguments as before)*/ 
		this.call.setParams(null); 

		// Invoke the call; here we expect something back !!
		try {
			Response response;
			response = this.call.invoke(this.url, ""); 

			/*Extract the value returned in the form of a 'Parameter' Object*/
			Parameter returnValue = response.getReturnValue();
			

			/*Cast the 'Parameter' Object onto a Hashtabel Object*/
			Hashtable<String,VehicleBean> catalog = (Hashtable<String,VehicleBean>)returnValue.getValue();
			Enumeration e = catalog.keys();
			while (e.hasMoreElements()) {
				String VModel = (String)e.nextElement();
				VehicleBean vo = (VehicleBean)catalog.get(VModel);
				System.out.println(" '" + vo.getVModel() + "' by " + vo.getVManufacturer() +
						", year " + vo.getVYear() + " with MCs = " + vo.VMotor.getMCc() + " , MNo_cylinders = " 
						+ vo.VMotor.getMNo_cylinders() + " and MPs = "+ vo.VMotor.getMPs());
			} 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}	

	public void deleteCar(String model) {

		this.call.setMethodName("delVehicleBean");

		Vector params = new Vector();
		params.addElement(new Parameter("model", String.class, model, null)); 
		call.setParams(params);

		try {
			Response response;
			response = this.call.invoke(this.url, ""); 

			//We do not expect something back, unless there is a fault!!
			if (!response.generatedFault())
				System.out.println("Server reported NO FAULT while deleting vehicle");
			else { 
				Fault fault = response.getFault();
				System.out.println("Server reported FAULT while deleting:");
				System.out.println(fault.getFaultString());
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getModel(String model) {


		this.call.setMethodName("getVehicleBean"); 

		Vector params = new Vector();
		params.addElement(new Parameter("model", String.class, model, null)); 
		this.call.setParams(params); 

		// Invoke the call; here we expect something back !!
		try {
			Response response;
			response = this.call.invoke(this.url, ""); 

			/*Extract the value returned in the form of a 'Parameter' Object*/
			Parameter returnValue = response.getReturnValue();
			
			/*Cast the 'Parameter' Object onto a Hashtabel Object*/
			VehicleBean vo = (VehicleBean)returnValue.getValue();

			System.out.println(" '" + vo.getVModel() + "' by " + vo.getVManufacturer() +
					", year " + vo.getVYear() + " with MCs = " + vo.VMotor.getMCc() + " , MNo_cylinders = " + 
					vo.VMotor.getMNo_cylinders() + " and MPs = "+ vo.VMotor.getMPs());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {

		/*create the object - get the link from the terminal*/
		BVAdderLister adderlister = new BVAdderLister(args[0]);
		
		System.out.println("Hello user and welcome to our web application client");
		System.out.println("-----------------------------------------------------");
		System.out.println("Press Ctrl+C to exit");
		
		while(true) {
			
			System.out.println("Please tell me what to do:");
			System.out.println("Press 1 to list all the vehicles");
			System.out.println("Press 2 to delete a vehicle");
			System.out.println("Press 3 to get a specific model");
			System.out.println("Press 4 to add a vehicle");

			try {
				Scanner in = new Scanner(System.in);
				int val = in.nextInt();
				String line;

				switch (val) {
					
					case 1:
						System.out.println();
						adderlister.list();
						System.out.println("-----------------------------------------------------");
						break;

					case 2:
						System.out.println("Give the model name");
						line = in.nextLine();
						line = in.nextLine();
						adderlister.deleteCar(line);
						System.out.println("-----------------------------------------------------");
						break;

					case 3:
						System.out.println("Give the model name");
						line = in.nextLine();
						line = in.nextLine();
						adderlister.getModel(line);
						System.out.println("-----------------------------------------------------");
						break;

					case 4:
						System.out.println("Give model name, manufacturer, year, MCc, MNo_cylinders, MPs in one line separated by space");
						line = in.nextLine();
						line = in.nextLine();
						String splits[] = line.split(" ");
						adderlister.add(splits[0],splits[1],splits[2],splits[3],splits[4],splits[5]);
						System.out.println("-----------------------------------------------------");
						break;
			
			}

			} catch (Exception e) {
					System.out.println("An error occured");
					System.exit(1);

			}





		}
	}
}
