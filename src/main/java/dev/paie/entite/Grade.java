package dev.paie.entite;

import java.math.BigDecimal;


public class Grade {
	
	private Integer id;
	public Grade() {
		super();
	}
	private String code;
	private BigDecimal nbHeuresBase;
	private BigDecimal tauxBase;
	
	public Grade(int id, String code, BigDecimal nbHeuresBase, BigDecimal tauxBase) {
		this.id=id;
		this.code=code;
		this.nbHeuresBase=nbHeuresBase;
		this.tauxBase=tauxBase;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getNbHeuresBase() {
		return nbHeuresBase;
	}
	public void setNbHeuresBase(BigDecimal nbHeuresBase) {
		this.nbHeuresBase = nbHeuresBase;
	}
	public BigDecimal getTauxBase() {
		return tauxBase;
	}
	public void setTauxBase(BigDecimal tauxBase) {
		this.tauxBase = tauxBase;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
