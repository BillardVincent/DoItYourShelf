package fr.DIYshelf.DoItYourshelf.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.DIYshelf.DoItYourshelf.Beans.Article;
import fr.DIYshelf.DoItYourshelf.Beans.Project;
import fr.DIYshelf.DoItYourshelf.Beans.QuantityOfArticle;
import fr.DIYshelf.DoItYourshelf.Beans.User;
import fr.DIYshelf.DoItYourshelf.Repositories.ProjectRepository;
import fr.DIYshelf.DoItYourshelf.Ressources.ConstantStrings;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private Population population;
	
	
	public void createStorageProject (User user) {
		Project storageProject = new Project();
		String name = ConstantStrings.STORAGEROOTPROJECT + user.getId();
		storageProject.setName(name);
		storageProject.setStorage(true);
		storageProject.setUser(user);
		projectRepository.save(storageProject);

		
		storageProject.setQuantityOfArticles(population.exemplesQuantity(user, storageProject));
		System.out.println("retour sur ProjectService");
		projectRepository.save(storageProject);
		

		
	}


	public List<QuantityOfArticle> getArticlesFromProjectStock(int userId) {
		Project storageProject = projectRepository.findByName(ConstantStrings.STORAGEROOTPROJECT + userId).orElse(null);
				
		List<QuantityOfArticle> list =storageProject.getQuantityOfArticles();

		return list;
	}


	public Project getProjectStock(int userId) {
 
		return projectRepository.findByName(ConstantStrings.STORAGEROOTPROJECT + userId).orElse(null);
	}

	public Optional<Project> getProjectById(int id) {
		return projectRepository.findById(id);
	}
}
