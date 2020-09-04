package fr.DIYshelf.DoItYourshelf.DTO.request;

import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String eMail;
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
  
    public String getUsername() {
        return name;
    }
 
    public void setUsername(String username) {
        this.name = username;
    }
 
    public String getEmail() {
        return eMail;
    }
 
    public void setEmail(String email) {
        this.eMail = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}
