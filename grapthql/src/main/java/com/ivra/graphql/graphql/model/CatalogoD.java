package com.ivra.graphql.graphql.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CatalogoD implements Serializable{
	
	private static final long serialVersionUID = 3409223565395875014L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long processDate;
	private String relCatId;
	private String fullDesc;
	private String shortDesc;
	private String screenDesc;
	private String abbreviation;
	
	public CatalogoD() {
		super();
	}

	public CatalogoD(Long processDate, String relCatId, String fullDesc,
			String shortDesc, String screenDesc, String abbreviation) {
		super();
		this.processDate = processDate;
		this.relCatId = relCatId;
		this.fullDesc = fullDesc;
		this.shortDesc = shortDesc;
		this.screenDesc = screenDesc;
		this.abbreviation = abbreviation;
	}

	public Long getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Long processDate) {
		this.processDate = processDate;
	}

	public String getRelCatId() {
		return relCatId;
	}

	public void setRelCatId(String relCatId) {
		this.relCatId = relCatId;
	}

	public String getFullDesc() {
		return fullDesc;
	}

	public void setFullDesc(String fullDesc) {
		this.fullDesc = fullDesc;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getScreenDesc() {
		return screenDesc;
	}

	public void setScreenDesc(String screenDesc) {
		this.screenDesc = screenDesc;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
