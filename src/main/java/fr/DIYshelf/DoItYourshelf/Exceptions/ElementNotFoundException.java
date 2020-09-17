package fr.DIYshelf.DoItYourshelf.Exceptions;

public class ElementNotFoundException extends RuntimeException {
	public ElementNotFoundException(String errorMessage) {
        super(errorMessage);
	}
}
