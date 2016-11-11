package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class WhiskeyDAOImpl implements WhiskeyDAO {
	private static final String FILE_NAME = "/WEB-INF/whiskey.csv";
	private static final String FILE_NAME2 = "/Users/Jolteon/Desktop/WhiskeyContacts/WhiskeyContacts.csv";
	private List<Dram> whiskeys = new ArrayList<>();
	private List<Contact> contacts = new ArrayList<>();

	@Autowired
	private WebApplicationContext wac;

	// RowID,Distillery,Body,Sweetness,Smoky,Medicinal,Tobacco,Honey,
	// Spicy,Winey,Nutty,Malty,Fruity,Floral,Postcode, Latitude, Longitude

	@PostConstruct
	public void init() {

		if (whiskeys.size() == 0) {
			try (InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
					BufferedReader br = new BufferedReader(new InputStreamReader(is));) {
				String line = br.readLine();
				while ((line = br.readLine()) != null) {
					String[] tokens = line.split(",");
					String name = tokens[1];
					String body = tokens[2];
					String sweet = tokens[3];
					String smoke = tokens[4];
					String medic = tokens[5];
					String tobac = tokens[6];
					String honey = tokens[7];
					String spice = tokens[8];
					String wine = tokens[9];
					String nut = tokens[10];
					String malt = tokens[11];
					String fruit = tokens[12];
					String flor = tokens[13];

					whiskeys.add(new Dram(name, body, sweet, smoke, medic, tobac, honey, spice, wine, nut, malt, fruit,
							flor));
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			if (contacts.size() == 0) {
				try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME2))) {

					String line;
					while ((line = br.readLine()) != null) {
						String[] tokens = line.split(",");
						String name = tokens[0];
						String address = tokens[1];
						String city = tokens[2];
						String state = tokens[3];
						String country = tokens[4];
						String zip = tokens[5];
						String phone = tokens[6];
						String url = tokens[7];

						contacts.add(new Contact(name, address, city, state, country, zip, phone, url));
					}

				} catch (IOException e) {
					System.out.println(e);
				}

			}

		}

	}

	@Override
	public List<Dram> getDrams() {
		init();
		return whiskeys;
	}

	@Override
	public List<Dram> getWhiskeys() {
		return whiskeys;
	}

	@Override
	public void setWhiskeys(List<Dram> whiskeys) {
		this.whiskeys = whiskeys;
	}

	@Override
	public List<Contact> getContacts() {
		return contacts;
	}

	@Override
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}
