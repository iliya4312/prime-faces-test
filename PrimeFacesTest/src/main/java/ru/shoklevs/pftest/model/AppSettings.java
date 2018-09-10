package ru.shoklevs.pftest.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the APP_SETINGS database table.
 * 
 */
@Entity
@Table(name="APP_SETTINGS")
@NamedQuery(name="AppSettings.findAll", query="SELECT a FROM AppSettings a")
public class AppSettings implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=1024)
	private String name;

	@Column(length=1024)
	private String descr;

	@Column(name="\"VALUE\"", length=1024)
	private String value;

	public AppSettings() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}