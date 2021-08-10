package com.comcast.POJOClass;

public class ProjLib {

	
	public String createdBy;
	public String status;
	public int teamSize;
	public String projectName;
	public ProjLib(String createdBy, String status, int teamSize, String projectName) {
		this.createdBy = "Mohammed_Hamza_K";
		this.status = "onGoing";
		this.teamSize = 100;
		this.projectName = "PojoProject";
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
	
}
