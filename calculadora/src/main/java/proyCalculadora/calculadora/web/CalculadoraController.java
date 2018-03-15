package proyCalculadora.calculadora.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import proyCalculadora.calculadora.model.Calculadora;

@Controller
public class CalculadoraController {

	@GetMapping("/new")
	public String initCreationForm(Model model) {
		model.addAttribute("calculadora", new Calculadora());
		return"calcFrm";
	}
	
	@PostMapping("/new")
	public String submitForm(@ModelAttribute Calculadora calculadora) {
		return "resultFrm";
		
	}
}
