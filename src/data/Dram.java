package data;

//RowID,Distillery,Body,Sweetness,Smoky,Medicinal,Tobacco,Honey,
//Spicy,Winey,Nutty,Malty,Fruity,Floral,Postcode, Latitude, Longitude

public class Dram {
	
	private String name;
	private String body;
	private String sweet;
	private String smoke;
	private String medic;
	private String tobac;
	private String honey;
	private String spice;
	private String wine;
	private String nut;
	private String malt;
	private String fruit;
	private String flor;
	
	public Dram(){}
	
	public Dram(String name, String body, String sweet, String smoke, String medic, String tobac, String honey,
			String spice, String wine, String nut, String malt, String fruit, String flor) {
		super();
		this.name = name;
		this.body = body;
		this.sweet = sweet;
		this.smoke = smoke;
		this.medic = medic;
		this.tobac = tobac;
		this.honey = honey;
		this.spice = spice;
		this.wine = wine;
		this.nut = nut;
		this.malt = malt;
		this.fruit = fruit;
		this.flor = flor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSweet() {
		return sweet;
	}
	public void setSweet(String sweet) {
		this.sweet = sweet;
	}
	public String getSmoke() {
		return smoke;
	}
	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}
	public String getMedic() {
		return medic;
	}
	public void setMedic(String medic) {
		this.medic = medic;
	}
	public String getTobac() {
		return tobac;
	}
	public void setTobac(String tobac) {
		this.tobac = tobac;
	}
	public String getHoney() {
		return honey;
	}
	public void setHoney(String honey) {
		this.honey = honey;
	}
	public String getSpice() {
		return spice;
	}
	public void setSpice(String spice) {
		this.spice = spice;
	}
	public String getWine() {
		return wine;
	}
	public void setWine(String wine) {
		this.wine = wine;
	}
	public String getNut() {
		return nut;
	}
	public void setNut(String nut) {
		this.nut = nut;
	}
	public String getMalt() {
		return malt;
	}
	public void setMalt(String malt) {
		this.malt = malt;
	}
	public String getFruit() {
		return fruit;
	}
	public void setFruit(String fruit) {
		this.fruit = fruit;
	}
	public String getFlor() {
		return flor;
	}
	public void setFlor(String flor) {
		this.flor = flor;
	}
	
	@Override
	public String toString() {
		return "New," + name + "," + body + "," + sweet + "," + smoke + "," + medic
				+ "," + tobac + "," + honey + "," + spice + "," + wine + "," + nut
				+ "," + malt + "," + fruit + "," + flor;
	}
	
	
	

}
