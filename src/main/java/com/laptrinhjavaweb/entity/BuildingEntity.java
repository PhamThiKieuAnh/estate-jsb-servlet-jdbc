package com.laptrinhjavaweb.entity;

import java.util.Date;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;
import com.laptrinhjavaweb.annotation.Table;
@Entity
@Table (name="building")
public class BuildingEntity {
	@Column (name = "id")
	private Long id;
	@Column (name = "name")
	private String name ;
	@Column (name = "ward")
	private String ward ;
	@Column (name="street")
	private String street;
	@Column (name = "structure")
	private String structure;
	@Column (name = "numberofbasement")
	private Integer numberOfBasement;
	@Column (name = "floorarea")
	private Integer floorarea;
	@Column (name = "direction")
	private String direction;
	@Column(name= "level")
	private String level;
	@Column (name = "rentareadescription")
	private String rentAreaDescription;
	@Column (name = "district")
	private String district;
	@Column (name = "rentcost")
	private Integer rentCost;
	@Column (name = "costdescription")
	private String costDescription;
	@Column (name = "servicecost")
	private String serviceCost;
	@Column (name = "carcost")
	private String carCost;
	@Column (name= "motocost")
	private String motoCost;
	@Column (name = "overtimecost")
	private String overtimeCost	;
	@Column (name = "type")
	private String type;
	@Column (name = "electictbill")
	private String electrictBill;
	@Column (name = "deposit")
	private String deposit;
	@Column (name= "payment")
	private String payment;
	@Column (name = "timerent")
	private String timeRent;
	@Column(name="timedecorator" )
	private String timeDecorator;
	@Column (name = "managername")
	private String managerName;
	@Column	(name="managerPhone" )
	private String managerPhone;
	@Column (name="createddate")
	private Date createdDate;
	@Column( name ="modifieddate" )
	private Date modifiedDate;
	@Column (name ="createby" )
	private String createBy;
	@Column( name = "modifiedby")
	private String modifiedBy;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public Integer getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getRentAreaDescription() {
		return rentAreaDescription;
	}
	public void setRentAreaDescription(String rentAreaDescription) {
		this.rentAreaDescription = rentAreaDescription;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Integer getRentCost() {
		return rentCost;
	}
	public void setRentCost(Integer rentCost) {
		this.rentCost = rentCost;
	}
	public String getCostDescription() {
		return costDescription;
	}
	public void setCostDescription(String costDescription) {
		this.costDescription = costDescription;
	}
	public String getServiceCost() {
		return serviceCost;
	}
	public void setServiceCost(String serviceCost) {
		this.serviceCost = serviceCost;
	}
	public String getCarCost() {
		return carCost;
	}
	public void setCarCost(String carCost) {
		this.carCost = carCost;
	}
	public String getMotoCost() {
		return motoCost;
	}
	public void setMotoCost(String motoCost) {
		this.motoCost = motoCost;
	}
	public String getOvertimeCost() {
		return overtimeCost;
	}
	public void setOvertimeCost(String overtimeCost) {
		this.overtimeCost = overtimeCost;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getElectrictBill() {
		return electrictBill;
	}
	public void setElectrictBill(String electrictBill) {
		this.electrictBill = electrictBill;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getTimeRent() {
		return timeRent;
	}
	public void setTimeRent(String timeRent) {
		this.timeRent = timeRent;
	}
	public String getTimeDecorator() {
		return timeDecorator;
	}
	public void setTimeDecorator(String timeDecorator) {
		this.timeDecorator = timeDecorator;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerPhone() {
		return managerPhone;
	}
	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Long getId() {
		return id;
	}
	
}
