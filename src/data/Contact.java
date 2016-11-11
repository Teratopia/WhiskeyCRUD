package data;

public class Contact {
	
	private String name;
	private String address;
	private String city;
	private String state;
	private String country;
	private String zip;
	private String phone;
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
