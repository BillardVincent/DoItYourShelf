package fr.DIYshelf.DoItYourshelf.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.DIYshelf.DoItYourshelf.Beans.Format;
import fr.DIYshelf.DoItYourshelf.Repositories.FormatRepository;

@Service
public class FormatsAndUnitsService {
	@Autowired
	FormatRepository formatRepo;
	
	public Optional<Format> getFormat(int formatId) {
		Optional<Format> format = formatRepo.findById(formatId);
		return format;
	}


	public List<String> findAllFormatName() {
		
		return formatRepo.findAllFormatName();
	}

	public void save(Format format) {
		formatRepo.save(format);
	}

	public List<Format> getAllFormat() {
		return formatRepo.findAll();
	}


	
	
	
	
	
}