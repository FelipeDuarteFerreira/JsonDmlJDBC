package com.caner.ws;

import javax.ws.rs.FormParam;

public class GaleriParam {

	@FormParam("carId")
	private int carId;

	@FormParam("carName")
	private String carName;

	@FormParam("carModel")
	private int carModel;

	@FormParam("carColour")
	private String carColour;

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getCarModel() {
		return carModel;
	}

	public void setCarModel(int carModel) {
		this.carModel = carModel;
	}

	public String getCarColour() {
		return carColour;
	}

	public void setCarColour(String carColour) {
		this.carColour = carColour;
	}

	@Override
	public String toString() {
		return "GaleriParam [carId=" + carId + ", carName=" + carName + ", carModel=" + carModel + ", carColour="
				+ carColour + "]";
	}

}
