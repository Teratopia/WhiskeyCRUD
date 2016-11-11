package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("add.do")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Add.jsp");
		return mv;
	}

	@RequestMapping(path = "newDram.do", method = RequestMethod.POST)
	public ModelAndView newDram(Dram dram) {
		System.out.println("1: in newDram");
		List<Dram> whiskeys = whiskeyDao.getWhiskeys();
		whiskeys.add(dram);
		System.out.println("2: " + whiskeys.get(whiskeys.size() - 1));
		whiskeyDao.setWhiskeys(whiskeys);
		System.out.println("3: " + dram.toString());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");

		return mv;
	}

	@RequestMapping(path = "sortDrams.do", params = "select", method = RequestMethod.GET)
	public ModelAndView sortDrams(@RequestParam("select") String select) {

		System.out.println("in sortDram");

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
		}

		// RowID,Distillery,Body,Sweetness,Smoky,Medicinal,Tobacco,Honey,
		// Spicy,Winey,Nutty,Malty,Fruity,Floral,Postcode, Latitude, Longitude

		int count = 1;
		while (holders.size() != 0) {
			String name = ((holders.get(holders.firstKey())));
			holders.remove(holders.firstKey());
			for (Dram dram : drams) {
				if (dram.getName().equals(name)) {
					revSortedDrams.add(dram);
					break;
				}
			}
			count++;
		}
		System.out.println(count);

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
	public ModelAndView locateDist(@RequestParam("dramName") String name){
		Dram dram = new Dram();
		for (Dram dram1 : whiskeyDao.getWhiskeys()){
			
			if(dram1.getName().equals(name)){
				dram = dram1;
			}
			
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Location.jsp");
		mv.addObject("dram", dram);
		
		return mv;
	}

}
