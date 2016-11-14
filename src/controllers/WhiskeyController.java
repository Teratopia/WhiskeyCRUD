package controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.Contact;
import data.Dram;
import data.WhiskeyDAO;

@Controller
public class WhiskeyController {

	@Autowired
	private WhiskeyDAO whiskeyDao;

	@RequestMapping("browse.do")
	public ModelAndView browse() {
		ModelAndView mv = new ModelAndView();
		List<Dram> drams = whiskeyDao.getWhiskeys();
		mv.setViewName("Browse.jsp");
		mv.addObject("drams", drams);
		return mv;
	}

	@RequestMapping(path = "add.do", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Add.jsp");

		return mv;
	}

	@RequestMapping(path = "newDram.do", method = RequestMethod.POST)
	public ModelAndView newDram(Dram dram) {
		List<Dram> whiskeys = whiskeyDao.getWhiskeys();
		whiskeys.add(dram);
		whiskeyDao.setWhiskeys(whiskeys);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Location.jsp");
		mv.addObject("dram", dram);

		return mv;
	}

	@RequestMapping(path = "sortDrams.do", params = "select", method = RequestMethod.GET)
	public ModelAndView sortDrams(@RequestParam("select") String select) {

		List<Dram> drams = whiskeyDao.getDrams();
		TreeMap<String, String> holders = new TreeMap<>();
		List<Dram> revSortedDrams = new ArrayList<>();
		List<Dram> sortedDrams = new ArrayList<>();
		int i = 0;

		switch (select) {
		case ("name"):
			for (Dram dram : drams) {
				holders.put(dram.getName() + i++, dram.getName());
			}
			break;
		case ("body"):
			for (Dram dram : drams) {
				holders.put(dram.getBody() + i++, dram.getName());
			}
			break;
		case ("sweet"):
			for (Dram dram : drams) {
				holders.put(dram.getSweet() + i++, dram.getName());
			}
			break;
		case ("smoke"):
			for (Dram dram : drams) {
				holders.put(dram.getSmoke() + i++, dram.getName());
			}
			break;
		case ("medic"):
			for (Dram dram : drams) {
				holders.put(dram.getMedic() + i++, dram.getName());
			}
			break;
		case ("tobac"):
			for (Dram dram : drams) {
				holders.put(dram.getTobac() + i++, dram.getName());
			}
			break;
		case ("honey"):
			for (Dram dram : drams) {
				holders.put(dram.getHoney() + i++, dram.getName());
			}
			break;
		case ("spice"):
			for (Dram dram : drams) {
				holders.put(dram.getSpice() + i++, dram.getName());
			}
			break;
		case ("wine"):
			for (Dram dram : drams) {
				holders.put(dram.getWine() + i++, dram.getName());
			}
			break;
		case ("nut"):
			for (Dram dram : drams) {
				holders.put(dram.getNut() + i++, dram.getName());
			}
			break;
		case ("malt"):
			for (Dram dram : drams) {
				holders.put(dram.getMalt() + i++, dram.getName());
			}
			break;
		case ("fruit"):
			for (Dram dram : drams) {
				holders.put(dram.getFruit() + i++, dram.getName());
			}
			break;
		case ("flor"):
			for (Dram dram : drams) {
				holders.put(dram.getFlor() + i++, dram.getName());
			}
			break;
		default: 
		}

		// RowID,Distillery,Body,Sweetness,Smoky,Medicinal,Tobacco,Honey,
		// Spicy,Winey,Nutty,Malty,Fruity,Floral,Postcode, Latitude, Longitude

		while (holders.size() != 0) {
			String name = ((holders.get(holders.firstKey())));
			holders.remove(holders.firstKey());
			for (Dram dram : drams) {
				if (dram.getName().equals(name)) {
					revSortedDrams.add(dram);
					break;
				}
			}
		}

		if (!select.equals("name")) {
			for (int index = revSortedDrams.size() - 1; index > 0; index--) {
				sortedDrams.add(revSortedDrams.get(index));
			}
		} else {
			sortedDrams = revSortedDrams;
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("Browse.jsp");
		mv.addObject("sortedDrams", sortedDrams);

		return mv;

	}

	@RequestMapping(path = "Location.do", params = "dramName", method = RequestMethod.GET)
	public ModelAndView locateDist(@RequestParam("dramName") String name) {
		Dram dram = new Dram();
		for (Dram dram1 : whiskeyDao.getWhiskeys()) {
			if (dram1.getName().equals(name)) {
				dram = dram1;
			}
		}

		ModelAndView mv = new ModelAndView();

		for (Contact contact : whiskeyDao.getContacts()) {
			if (contact.getName().equals(name)) {
				mv = addContact(contact);
				break;
			} else {
				mv.setViewName("Location.jsp");
				mv.addObject("dram", dram);
			}
		}

		return mv;
	}

	@RequestMapping(path = "addContact.do", method = RequestMethod.GET)
	public ModelAndView addContact(Contact contact) {

		System.out.println(contact.toString());
		try {
			FileWriter fw = new FileWriter("/Users/Jolteon/Desktop/WhiskeyContacts/WhiskeyContacts.csv");
			PrintWriter pw = new PrintWriter(fw);

			for (Contact contact2 : whiskeyDao.getContacts()) {
				pw.println(contact2);
			}

			pw.println(contact);

			pw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		Dram dram = new Dram();

		for (Dram dram1 : whiskeyDao.getDrams()) {

			if (dram1.getName().equals(contact.getName())) {
				dram = dram1;
			}

		}

		String gUrl = makeGMapString(contact);

		System.out.println("Dram: " + dram);
		System.out.println(contact);
		System.out.println("gmap Link: " + gUrl);

		List<Contact> contacts = whiskeyDao.getContacts();
		contacts.add(contact);
		whiskeyDao.setContacts(contacts);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("LocationPlus.jsp");
		mv.addObject("contact", contact);
		mv.addObject("dram", dram);
		mv.addObject("gUrl", gUrl);

		return mv;
	}

	public String makeGMapString(Contact contact) {

		// https://www.google.com/maps/embed/v1/place?key=YOUR_API_KEY
		// &q=Fairmont+Empress,Victoria+BC
		// &attribution_source=Google+Maps+Embed+API
		// &attribution_web_url=http://www.fairmont.com/empress-victoria/
		// &attribution_ios_deep_link_id=comgooglemaps://?daddr=Fairmont+Empress,+Victoria,+BC

		// https://www.google.com/maps?q=1200+Pennsylvania+Ave+SE,+Washington,+District+of+Columbia,+20003

		String base = "https://www.google.com/maps/embed/v1/place?key=AIzaSyBai9RCT_s_yO9KpNpV650lnLk4PpH8JAE&&q=";
		String end = "&zoom=10";
		String retString = "";
		boolean testUrl = (contact.getUrl() != null && !contact.getUrl().equals("Website URL"));
		boolean testAdd = (contact.getAddress() != null && !contact.getAddress().equals("Address"));
		boolean testCity = (contact.getCity() != null && !contact.getCity().equals("City"));
		boolean testState = (contact.getState() != null && !contact.getState().equals("State"));
		boolean testCountry = (contact.getCountry() != null && !contact.getCountry().equals("Country"));
		String add = contact.getAddress().replaceAll(" ", "+");
		String city = contact.getCity().replaceAll(" ", "+");
		String state = contact.getState().replaceAll(" ", "+");
		String country = contact.getCountry().replaceAll(" ", "+");
		String name = contact.getName().replaceAll(" ", "+");

		if (testUrl && testCountry && testState && testCity && testAdd) {
			String address = add + "," + city + "," + state + "," + country;

			retString = base + address + "&attribution_source=Google+Maps+Embed+API&attribution_web_url="
					+ contact.getUrl() + "&attribution_ios_deep_link_id=comgooglemaps://?daddr=" + address + end;

		} else if (testCountry && testState && testCity && testAdd) {

			retString = base + add + "," + city + "," + state + "," + country + end;

		} else if (testCountry && testCity && testAdd) {

			retString = base + add + "," + city + "," + country + end;

		} else if (testCountry && testCity) {

			retString = base + "," + city + "," + country + end;
		} else {

			retString = "https://www.google.com/maps/embed/v1/place?key=AIzaSyBai9RCT_s_yO9KpNpV650lnLk4PpH8JAE&&q=$"
					+ name + ",+UK&zoom=10";

		}

		return retString;
	}

	@RequestMapping("tasteSort.do")
	public ModelAndView tasteSort(@RequestParam("checks") String s) {
		List<Dram> drams = whiskeyDao.getWhiskeys();
		TreeMap<String, String> returnMap = new TreeMap<>();
		String[] tokens = s.split(",");
		int modifier = 0;

		for (Dram dram : drams) {
			String name = dram.getName();
			int sum = 0;
			int count = 0;

			for (String string : tokens) {
				switch (string) {
				case ("body"):
					sum += Integer.parseInt(dram.getBody());
					count++;
					break;
				case ("sweet"):
					sum += Integer.parseInt(dram.getSweet());
					count++;
					break;
				case ("smoke"):
					sum += Integer.parseInt(dram.getSmoke());
					count++;
					break;
				case ("medic"):
					sum += Integer.parseInt(dram.getMedic());
					count++;
					break;
				case ("tobac"):
					sum += Integer.parseInt(dram.getTobac());
					count++;
					break;
				case ("honey"):
					sum += Integer.parseInt(dram.getHoney());
					count++;
					break;
				case ("spice"):
					sum += Integer.parseInt(dram.getSpice());
					count++;
					break;
				case ("wine"):
					sum += Integer.parseInt(dram.getWine());
					count++;
					break;
				case ("nut"):
					sum += Integer.parseInt(dram.getNut());
					count++;
					break;
				case ("malt"):
					sum += Integer.parseInt(dram.getMalt());
					count++;
					break;
				case ("fruit"):
					sum += Integer.parseInt(dram.getFruit());
					count++;
					break;
				case ("flor"):
					sum += Integer.parseInt(dram.getFlor());
					count++;
					break;
				}
			}

			double average = ((double) (sum) / (double) (count));
			String aveString = "" + average + modifier++;
			returnMap.put(aveString, name);
			// System.out.println(name+" : "+aveString);
		}

		// System.out.print("Ave: "+returnMap.firstKey());
		// System.out.println(" Name: "+name);
		List<String> unsortedTasteDrams = new ArrayList<>();
		List<Dram> revSortedDrams = new ArrayList<>();
		while (returnMap.size() != 0) {
			String name = ((returnMap.get(returnMap.firstKey())));
			unsortedTasteDrams.add(returnMap.firstKey());
			returnMap.remove(returnMap.firstKey());
			for (Dram dram : drams) {
				if (dram.getName().equals(name)) {
					revSortedDrams.add(dram);
					// System.out.println(dram.toString());
					break;
				}
			}
		}

		List<Dram> sortedDrams = new ArrayList<>();
		for (int index = revSortedDrams.size() - 1; index > 0; index--) {
			sortedDrams.add(revSortedDrams.get(index));
		}

		List<String> tasteDrams = new ArrayList<>();
		for (int k = unsortedTasteDrams.size() - 1; k > -1; k--) {
			tasteDrams.add(unsortedTasteDrams.get(k).substring(0, 3));
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("Browse.jsp");
		mv.addObject("sortedDrams", sortedDrams);
		mv.addObject("tasteDrams", tasteDrams);

		return mv;
	}

	@RequestMapping(path = "update.do", method = RequestMethod.GET)
	public ModelAndView updateDram(@RequestParam("name2") String s) {
		removeDram(s);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Add.jsp");
		mv.addObject("updateName", s);

		return mv;
	}

	@RequestMapping(path = "delete.do", method = RequestMethod.GET)
	public ModelAndView deleteDram(@RequestParam("name2") String s) {
		ModelAndView mv = new ModelAndView();
		removeDram(s);
		mv.setViewName("Browse.jsp");
		return mv;
	}

	public void removeDram(String s) {
		List<Dram> whiskeys = whiskeyDao.getWhiskeys();
		for (Dram dram2 : whiskeys) {
			if (dram2.getName().equals(s)) {
				whiskeys.remove(dram2);
				break;
			}
		}
		whiskeyDao.setWhiskeys(whiskeys);
	}

}