package com.seva.user.model;

public class UserDetails {
	
	private SrUser sruser = null;
	private SpUserC spuserc = null;
	private SpUserM spuserm = null;
	private SpUserN spusern = null;
	private boolean isNewUser;
	private boolean isProvider;
	private boolean verifiedStatus; 
	
	public SrUser getSruser() {
		return sruser;
	}
	public void setSruser(SrUser sruser) {
		this.sruser = sruser;
	}

	public boolean isNewUser() {
		return isNewUser;
	}
	public void setNewUser(boolean isNewUser) {
		this.isNewUser = isNewUser;
	}
	public boolean isProvider() {
		return isProvider;
	}
	public void setProvider(boolean isProvider) {
		this.isProvider = isProvider;
	}
	public SpUserC getSpuserc() {
		return spuserc;
	}
	public void setSpuserc(SpUserC spuserc) {
		this.spuserc = spuserc;
	}
	public SpUserM getSpuserm() {
		return spuserm;
	}
	public void setSpuserm(SpUserM spuserm) {
		this.spuserm = spuserm;
	}
	public SpUserN getSpusern() {
		return spusern;
	}
	public void setSpusern(SpUserN spusern) {
		this.spusern = spusern;
	}
	public boolean isVerifiedStatus() {
		return verifiedStatus;
	}
	public void setVerifiedStatus(boolean verifiedStatus) {
		this.verifiedStatus = verifiedStatus;
	}

}
