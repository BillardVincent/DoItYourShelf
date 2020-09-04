package fr.DIYshelf.DoItYourshelf.ElementsMock;

import java.util.HashSet;
import java.util.Set;

import fr.DIYshelf.DoItYourshelf.Beans.Project;

public class ProjectRandGen {

	public Project ProjectMocked(String var) {
		Project Project = new Project();
			Project.setName("name"+var);
			
	
		
return Project;
}
	
	public Set<Project> ListProject(int nProjects){
		Set<Project> Projects = new HashSet<Project>();
		for (int i = 0; i <nProjects; i++) {
			Project Project = ProjectMocked(String.valueOf(i));
			Projects.add(Project);
		}
		return Projects;
	}
	
}
