package com.nkxgen.spring.orm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employmentofferdocuments")
public class empoffdocuments {
	// Other code

	@Id
	@Column(name = "eofr_id")
	private Long eofrId;

	@Column(name = "eofd_docindex")
	private String eofdDocIndex;

	@Column(name = "eofd_idty_id")
	private String eofdIdtyId;

	empoffdocuments() {
	}

	public Long getEofrId() {
		return eofrId;
	}

	public void setEofrId(Long eofrId) {
		this.eofrId = eofrId;
	}

	public String getEofdDocIndex() {
		return eofdDocIndex;
	}

	public void setEofdDocIndex(String eofdDocIndex) {
		this.eofdDocIndex = eofdDocIndex;
	}

	public String getEofdIdtyId() {
		return eofdIdtyId;
	}

	public void setEofdIdtyId(String eofdIdtyId) {
		this.eofdIdtyId = eofdIdtyId;
	}

}
