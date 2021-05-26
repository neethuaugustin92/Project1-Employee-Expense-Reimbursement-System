package com.project1.model;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;
public class ERS_REIMBURSEMENT {
	
	//variables
	
	private int REIMB_ID;
	private int REIMB_AMOUNT;
	//private double REIMB_AMOUNT;
	Timestamp REIMB_RESOLVED;
	Timestamp REIMB_SUBMITTED;
	String REIMB_DESCRIPTION;
	//Blob REIMB_RECEIPT;
	String  REIMB_RECEIPT;
	private int  REIMB_AUTHOR ;
	private int EIMB_RESOLVER ;
	private int REIMB_STATUS_ID ;
	private int REIMB_TYPE_ID;
	private List<String> REIMBURSEMENT;
	
	
	//getters and setters 
	public int getREIMB_ID() {
		return REIMB_ID;
	}
	public void setREIMB_ID(int rEIMB_ID) {
		REIMB_ID = rEIMB_ID;
	}
	public int getREIMB_AMOUNT() {
		return REIMB_AMOUNT;
	}
	public void setREIMB_AMOUNT(int rEIMB_AMOUNT) {
		REIMB_AMOUNT = rEIMB_AMOUNT;
	}
	public Timestamp getREIMB_RESOLVED() {
		return REIMB_RESOLVED;
	}
	public void setREIMB_RESOLVED(Timestamp rEIMB_RESOLVED) {
		REIMB_RESOLVED = rEIMB_RESOLVED;
	}
	public Timestamp getREIMB_SUBMITTED() {
		return REIMB_SUBMITTED;
	}
	public void setREIMB_SUBMITTED(Timestamp rEIMB_SUBMITTED) {
		REIMB_SUBMITTED = rEIMB_SUBMITTED;
	}
	public String getREIMB_DESCRIPTION() {
		return REIMB_DESCRIPTION;
	}
	public void setREIMB_DESCRIPTION(String rEIMB_DESCRIPTION) {
		REIMB_DESCRIPTION = rEIMB_DESCRIPTION;
	}
	public String getREIMB_RECEIPT() {
		return REIMB_RECEIPT;
	}
	public void setREIMB_RECEIPT(String rEIMB_RECEIPT) {
		REIMB_RECEIPT = rEIMB_RECEIPT;
	}
	public int getREIMB_AUTHOR() {
		return REIMB_AUTHOR;
	}
	public void setREIMB_AUTHOR(int rEIMB_AUTHOR) {
		REIMB_AUTHOR = rEIMB_AUTHOR;
	}
	public int getEIMB_RESOLVER() {
		return EIMB_RESOLVER;
	}
	public void setEIMB_RESOLVER(int eIMB_RESOLVER) {
		EIMB_RESOLVER = eIMB_RESOLVER;
	}
	public int getREIMB_STATUS_ID() {
		return REIMB_STATUS_ID;
	}
	public void setREIMB_STATUS_ID(int rEIMB_STATUS_ID) {
		REIMB_STATUS_ID = rEIMB_STATUS_ID;
	}
	public int getREIMB_TYPE_ID() {
		return REIMB_TYPE_ID;
	}
	public void setREIMB_TYPE_ID(int rEIMB_TYPE_ID) {
		REIMB_TYPE_ID = rEIMB_TYPE_ID;
	}
	
	
	public List<String> getColorList() {
		return REIMBURSEMENT;
	}

	public void setColorList(List<String> REIMBURSEMENT) {
		this.REIMBURSEMENT = REIMBURSEMENT;
	}
	
	
	//Constructor 
public ERS_REIMBURSEMENT() {
		
	}
	
	
	public ERS_REIMBURSEMENT(int rEIMB_ID, int rEIMB_AMOUNT, Timestamp rEIMB_RESOLVED, Timestamp rEIMB_SUBMITTED,
			String rEIMB_DESCRIPTION, String rEIMB_RECEIPT, int rEIMB_AUTHOR, int eIMB_RESOLVER, int rEIMB_STATUS_ID,
			int rEIMB_TYPE_ID,List<String> REIMBURSEMENT) {
		super();
		this.REIMB_ID = rEIMB_ID;
		this.REIMB_AMOUNT = rEIMB_AMOUNT;
		this.REIMB_RESOLVED = rEIMB_RESOLVED;
		this.REIMB_SUBMITTED = rEIMB_SUBMITTED;
		this.REIMB_DESCRIPTION = rEIMB_DESCRIPTION;
		this.REIMB_RECEIPT = rEIMB_RECEIPT;
		this.REIMB_AUTHOR = rEIMB_AUTHOR;
		this.EIMB_RESOLVER = eIMB_RESOLVER;
		this.REIMB_STATUS_ID = rEIMB_STATUS_ID;
		this.REIMB_TYPE_ID = rEIMB_TYPE_ID;
	}
	public ERS_REIMBURSEMENT( int rEIMB_AMOUNT, Timestamp rEIMB_RESOLVED, Timestamp rEIMB_SUBMITTED,
			String rEIMB_DESCRIPTION, String rEIMB_RECEIPT, int rEIMB_AUTHOR, int eIMB_RESOLVER, int rEIMB_STATUS_ID,
			int rEIMB_TYPE_ID,List<String> REIMBURSEMENT) {
		super();
		
		this.REIMB_AMOUNT = rEIMB_AMOUNT;
		this.REIMB_RESOLVED = rEIMB_RESOLVED;
		this.REIMB_SUBMITTED = rEIMB_SUBMITTED;
		this.REIMB_DESCRIPTION = rEIMB_DESCRIPTION;
		this.REIMB_RECEIPT = rEIMB_RECEIPT;
		this.REIMB_AUTHOR = rEIMB_AUTHOR;
		this.EIMB_RESOLVER = eIMB_RESOLVER;
		this.REIMB_STATUS_ID = rEIMB_STATUS_ID;
		this.REIMB_TYPE_ID = rEIMB_TYPE_ID;
	}
	
	public ERS_REIMBURSEMENT( int rEIMB_AMOUNT, Timestamp rEIMB_RESOLVED, Timestamp rEIMB_SUBMITTED,
			String rEIMB_DESCRIPTION, int rEIMB_AUTHOR, int eIMB_RESOLVER, int rEIMB_STATUS_ID,
			int rEIMB_TYPE_ID) {
		super();
		
		this.REIMB_AMOUNT = rEIMB_AMOUNT;
		this.REIMB_RESOLVED = rEIMB_RESOLVED;
		this.REIMB_SUBMITTED = rEIMB_SUBMITTED;
		this.REIMB_DESCRIPTION = rEIMB_DESCRIPTION;
		//REIMB_RECEIPT = rEIMB_RECEIPT;
		this.REIMB_AUTHOR = rEIMB_AUTHOR;
		this.EIMB_RESOLVER = eIMB_RESOLVER;
		this.REIMB_STATUS_ID = rEIMB_STATUS_ID;
		this.REIMB_TYPE_ID = rEIMB_TYPE_ID;
	}
	
	
	//tostring
	
	@Override
	public String toString() {
		return "ERS_REIMBURSEMENT [REIMB_ID=" + REIMB_ID + ", REIMB_AMOUNT=" + REIMB_AMOUNT + ", REIMB_RESOLVED="
				+ REIMB_RESOLVED + ", REIMB_SUBMITTED=" + REIMB_SUBMITTED + ", REIMB_DESCRIPTION=" + REIMB_DESCRIPTION
				+ ", REIMB_RECEIPT=" + REIMB_RECEIPT + ", REIMB_AUTHOR=" + REIMB_AUTHOR + ", EIMB_RESOLVER="
				+ EIMB_RESOLVER + ", REIMB_STATUS_ID=" + REIMB_STATUS_ID + ", REIMB_TYPE_ID=" + REIMB_TYPE_ID
				+ ", REIMBURSEMENT=" + REIMBURSEMENT + "]";
	}

}
