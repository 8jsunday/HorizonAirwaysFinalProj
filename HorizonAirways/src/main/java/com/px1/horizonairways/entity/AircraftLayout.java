package com.px1.horizonairways.entity;

public class AircraftLayout {

	private int firstClassRows;
	private int businessClassRows;
	private int economyClassRows;
	private int[] firstClassSeatArrangement;
	private int[] businessClassSeatArrangement;
	private int[] economyClassSeatArrangement;

	public AircraftLayout(int firstClassRows, int businessClassRows, int economyClassRows, int[] firstClassSeatArrangement,
			int[] businessClassSeatArrangement, int[] economyClassSeatArrangement) {

		this.firstClassRows = firstClassRows;
		this.businessClassRows = businessClassRows;
		this.economyClassRows = economyClassRows;
		this.firstClassSeatArrangement = firstClassSeatArrangement;
		this.businessClassSeatArrangement = businessClassSeatArrangement;
		this.economyClassSeatArrangement = economyClassSeatArrangement;
	}

	public AircraftLayout() {
	}

	public int getFirstClassRows() {
		return firstClassRows;
	}

	public void setFirstClassRows(int firstClassRows) {
		this.firstClassRows = firstClassRows;
	}

	public int getBusinessClassRows() {
		return businessClassRows;
	}

	public void setBusinessClassRows(int businessClassRows) {
		this.businessClassRows = businessClassRows;
	}

	public int getEconomyClassRows() {
		return economyClassRows;
	}

	public void setEconomyClassRows(int economyClassRows) {
		this.economyClassRows = economyClassRows;
	}

	public int[] getFirstClassSeatArrangement() {
		return firstClassSeatArrangement;
	}

	public void setFirstClassSeatArrangement(String firstClassSeatArrangement) {
		
		String[] s = firstClassSeatArrangement.split(":");
		int[] newArray = new int[s.length];
		
		for (int i = 0; i < s.length; i++) {
			
			newArray[i] = Integer.parseInt(s[i]);
		}
		
		this.firstClassSeatArrangement = newArray;
	}

	public int[] getBusinessClassSeatArrangement() {
		return businessClassSeatArrangement;
	}

	public void setBusinessClassSeatArrangement(String businessClassSeatArrangement) {
		
		String[] s = businessClassSeatArrangement.split(":");
		int[] newArray = new int[s.length];
		
		for (int i = 0; i < s.length; i++) {
			
			newArray[i] = Integer.parseInt(s[i]);
		}
		
		this.businessClassSeatArrangement = newArray;
	}

	public int[] getEconomyClassSeatArrangement() {
		return economyClassSeatArrangement;
	}

	public void setEconomyClassSeatArrangement(String economyClassSeatArrangement) {
		
		String[] s = economyClassSeatArrangement.split(":");
		int[] newArray = new int[s.length];
		
		for (int i = 0; i < s.length; i++) {
			
			newArray[i] = Integer.parseInt(s[i]);
		}
		
		this.economyClassSeatArrangement = newArray;
	}

	@Override
	public String toString() {
		
		StringBuffer str = new StringBuffer();
		str.append("FirstClassRows: ").append(this.firstClassRows).append("\n");
		str.append("BusinessClassRows: ").append(this.businessClassRows).append("\n");
		str.append("EconomyClassRows): ").append(this.economyClassRows).append("\n");
		str.append("FirstClassSeatArrangement: ").append(this.firstClassSeatArrangement).append("\n");
		str.append("BusinessClassSeatArrangement: ").append(this.businessClassSeatArrangement).append("\n");
		str.append("EconomyClassSeatArrangement: ").append(this.economyClassSeatArrangement).append("\n");
		
		return str.toString();
	}

}
