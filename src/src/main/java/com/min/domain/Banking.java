package com.min.domain;

import jakarta.persistence.Entity;

@Entity(name="bank")
public class Banking {

	private Integer bankId;
	private Integer accountNum;
	private String branchName;
	private int IFSCCode;
	private String locatedCity;

	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public int getIFSCCode() {
		return IFSCCode;
	}
	public void setIFSCCode(int iFSCCode) {
		IFSCCode = iFSCCode;
	}
	public String getLocatedCity() {
		return locatedCity;
	}
	public void setLocatedCity(String locatedCity) {
		this.locatedCity = locatedCity;
	}

	@Override
	public String toString() {
		return "Banking [bankId=" + bankId + ", accountNum=" + accountNum + ", branchName=" + branchName + ", IFSCCode="
				+ IFSCCode + ", locatedCity=" + locatedCity + "]";
	}
	
}
