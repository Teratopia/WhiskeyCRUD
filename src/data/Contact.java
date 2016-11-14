package data;

import javax.validation.constraints.Size;

public class Contact {
	
	@Size(min=2, max=100)
	private String name;
	
	@Size(min=2, max=200)
	private String address;
	
	@Size(min=2, max=100)
	private String city;
	
	@Size(min=2, max=100)
	private String state;
	private String country;
	
	@Size(min=2, max=100)
	private String zip;
	
	@Size(min=2, max=100)
	private String phone;
	
	@Size(min=7, max=16)
	private String url;
	
	public Contact(){}

	public Contact(String name, String address, String city, String state, String country, String zip, String phone,
			String url) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.phone = phone;
		this.url = url;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + "," + address + "," + city + "," + state + ","
				+ country + "," + zip + "," + phone + "," + url;
	}
	
	

}
