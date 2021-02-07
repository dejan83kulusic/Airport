package com.dejan.model;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Airport {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String username;
	    private String city;
	    private String country;
	    private double latitude;
	    private double longitude;
	    private double altitude;
	    private Date date;
	    private TimeZone olsonTime;
	    private String type;
	    private String source;
	   
	    

		public Airport(String username, String city, String country, double latitude, double longitude,
				double altitude, Date date, TimeZone olsonTime, String type, String source) {
			super();
		
			this.username = username;
			this.city = city;
			this.country = country;
			this.latitude = latitude;
			this.longitude = longitude;
			this.altitude = altitude;
			this.date = date;
			this.olsonTime = olsonTime;
			this.type = type;
			this.source = source;
		
		}

		

		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

	

		public String getName() {
			return username;
		}

		public void setName(String username) {
			this.username = username;
		}

		public String getity() {
			return city;
		}

		public void setMainCity(String city) {
			this.city = city;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public double getLatitude() {
			return latitude;
		}

		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}

		public double getLongitude() {
			return longitude;
		}

		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}

		public double getAltitude() {
			return altitude;
		}

		public void setAltitude(double altitude) {
			this.altitude = altitude;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public TimeZone getOlsonTime() {
			return olsonTime;
		}

		public void setOlsonTime(TimeZone olsonTime) {
			this.olsonTime = olsonTime;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

	

	

}
