package com.springproject.auth.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ATTRIBUTES")
public class Attribute implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static final String OPERATING_SYSTEM = "Operating System";
	public static final String MODEL = "Model";
	
	
	
	@Id   
    @Column(name="ATRIBUTE_ID")
    private Long atributeId;
	
    @Column(name="ATRIBUTE_NAME")
    private String atributeName;
	
	@Column(name = "FINGERPRINT")
    private boolean fingerprint;

	public Long getAtributeId() {
		return atributeId;
	}

	public void setAtributeId(Long atributeId) {
		this.atributeId = atributeId;
	}

	public String getAtributeName() {
		return atributeName;
	}

	public void setAtributeName(String atributeName) {
		this.atributeName = atributeName;
	}

	public boolean isFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(boolean fingerprint) {
		this.fingerprint = fingerprint;
	}   

}