package fr.DIYshelf.DoItYourshelf.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.DIYshelf.DoItYourshelf.Beans.Format;
import fr.DIYshelf.DoItYourshelf.DTO.request.FormatRequest;
import fr.DIYshelf.DoItYourshelf.Services.FormatsAndUnitsService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
@RequestMapping("/other")
public class OtherController {
	
	@Autowired
	private FormatsAndUnitsService fnUServ;
	

	@GetMapping(value="/formatsandunits")
	public List<Format> getFormatsAndUnisList () {
				List <Format> fnUList=  new ArrayList<Format>();
				System.out.println(fnUServ.getAllFormat().size());

				fnUList = fnUServ.getAllFormat();
				System.out.println(fnUList.size());
				for (Format format : fnUList) {
					System.out.println(format);
				
				}
		return fnUList;
	}
	
	
	@PostMapping(value="/createFormat")
	public void createFormat(@RequestBody FormatRequest formatFromFront) {
			Format format = new Format();
			format.setName(formatFromFront.name);
			format.setUnit(formatFromFront.unit);
		fnUServ.save(format);
		
	}
}
