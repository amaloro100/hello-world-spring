package com.examples.spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.examples.spring.model.Persona;

@Component
public class PersonValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
        return Persona.class.equals(clazz);
    }

	@Override
	public void validate(Object object, Errors errors) {
		Persona persona = (Persona) object;
		
		if (persona.getProvincia() == null || persona.getProvincia().getId() == 0) {
            errors.rejectValue("provincia", "province.selectAnOption");
        }
		if (persona.getNombre().equals("Pepe")) {
            errors.rejectValue("nombre", "nombre.pepe");
        }
		if (!persona.getTelefono().startsWith("6") && !persona.getTelefono().startsWith("7")) {
			errors.rejectValue("telefono", "phone.error");
		}
		if (persona.getGithubProfile().equals("alberto") && persona.getEmail().startsWith("alberto")) {
			errors.rejectValue("githubProfile", "gitHubProfile.errorEmail");
		}
		if (!persona.getPass().equals(persona.getRepass())){
			errors.rejectValue("pass", "repass.errorrepass");
		}
		
		if (persona.getUsername().equals(persona.getPass())){
			errors.rejectValue("pass", "userpass.error");
		}
		
		

}
}
