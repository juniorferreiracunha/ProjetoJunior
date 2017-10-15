package br.estacio.model;

public enum ProfileType {

	USER("USER"), SALESMAN("SALESMAN"), SYSADMIN("SYSADMIN");
	private String userProfileType;

	private ProfileType(String userProfileType) {
		this.userProfileType = userProfileType;
	}

	public String getUserProfileType() {
		return userProfileType;
	}

}
