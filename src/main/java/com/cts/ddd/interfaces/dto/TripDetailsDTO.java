package com.cts.ddd.interfaces.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TripDetailsDTO {
	
	private String travelTime;
    
    private Date travelDate;

    private String travelStatus;
    
    private String vehicleNo;
    
    private String fromLocation;
    
	private String toLocation;
	
	private String employeeName;
	
	private String customerName;
	
	private String vehicleType;

	private Integer seater;
	    
	private BigDecimal travelCost;
	
	public String getTravelTime() {
		return travelTime;
	}
	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}
	public Date getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
	public String getTravelStatus() {
		return travelStatus;
	}
	public void setTravelStatus(String travelStatus) {
		this.travelStatus = travelStatus;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	
	
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Integer getSeater() {
		return seater;
	}
	public void setSeater(Integer seater) {
		this.seater = seater;
	}
	public BigDecimal getTravelCost() {
		return travelCost;
	}
	public void setTravelCost(BigDecimal travelCost) {
		this.travelCost = travelCost;
	}
	@Override
	public String toString() {
		return "TripDetailsDTO [travelTime=" + travelTime + ", travelDate=" + travelDate + ", travelStatus="
				+ travelStatus + ", vehicleNo=" + vehicleNo + ", fromLocation=" + fromLocation + ", toLocation="
				+ toLocation + ", firstName=" + employeeName + ", lastName=" + customerName + "]";
	}
	

}
