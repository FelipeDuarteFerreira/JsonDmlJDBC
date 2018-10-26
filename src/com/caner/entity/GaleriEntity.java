package com.caner.entity;

public class GaleriEntity {

	private int carId;
	private String carName;
	private int carModel;
	private String carColour;

	public GaleriEntity() {

	}

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

	public GaleriEntity(int carId, String carName, int carModel, String carColour) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.carModel = carModel;
		this.carColour = carColour;
	}

	@Override
	public String toString() {
		return "GaleriEntity [carId=" + carId + ", carName=" + carName + ", carModel=" + carModel + ", carColour="
				+ carColour + "]";
	}

}