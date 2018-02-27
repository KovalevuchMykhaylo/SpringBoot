package com.shop.entity;

public enum WorkQualification {
	
	TRAINEE("TRAINEE"), JUNIOR("JUNIOR"), MIDDLE("MIDDLE"), SENIOR("SENIOR");
	

	private String qaulification;

	public String getQaulification() {
		return qaulification;
	}

	private WorkQualification(String qaulification) {
		this.qaulification = qaulification;
	}
	
	
}
