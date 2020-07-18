package com.mandala.activitiesperhour.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HourlyActivityDetails", schema = "public")
public class ActivityEntity implements Serializable {
	private static final long serialVersionUID = -2343243243242432341L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rownum;
	private String date;
	private String hour;
	private String activitydescription;
	private String utilisationtype;

	public ActivityEntity() {

	}

	public ActivityEntity(String date, String hour, String activitydescription, String utilisationtype) {
		this.date = date;
		this.hour = hour;
		this.activitydescription = activitydescription;
		this.utilisationtype = utilisationtype;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getActivitydescription() {
		return activitydescription;
	}

	public void setActivitydescription(String activitydescription) {
		this.activitydescription = activitydescription;
	}

	public String getUtilisationtype() {
		return utilisationtype;
	}

	public void setUtilisationtype(String utilisationtype) {
		this.utilisationtype = utilisationtype;
	}
}
