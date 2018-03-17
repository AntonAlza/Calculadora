package proyCalculadora.calculadora.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import proyCalculadora.calculadora.model.Calculadora;

@Controller
public class CalculadoraController {

	@GetMapping("/calculadora")
	public String initCreationForm(Model model) {
		model.addAttribute("calculadora", new Calculadora());
		return"calcFrm";
	}
	
	@PostMapping("/resultado")
	public String submitForm(@ModelAttribute Calculadora calculadora) {
		
		double num1 = calculadora.getNum1();
		double num2 = calculadora.getNum2();
		String msj = "";
		
		switch (calculadora.getOperacion()) {
		case '+':
			msj = "La suma de " +Math.round(num1)  + " y " +Math.round(num2)  + " es : " + (num1 + num2);
			break;
		case '-':
			msj = "La resta de " +Math.round(num1)  + " y " + Math.round(num2) + " es : " + (num1 - num2);
			break;
		case '*':
			msj = "La multiplicación de " +Math.round(num1)  + " y " + Math.round(num2) + " es : " + (num1 * num2);
			break;
		case '^':
			msj = "La raiz de " +Math.round(num1)  + " radicando " + Math.round(num2) + " es : " + (Math.pow(num1, 1/num2));
			break;
		case '/':
			
			//NO SE PUEDE DIVIDIR UN NUMERO ENTRE CERO
			if (num2 != 0) {
				
				msj = "La división de " + num1 + " y " + num2 + " es : " + (num1 / num2);
				
			}else {
				
				msj = "El segundo número debe ser diferente de cero";
				
			}
			
			break;
		default:
			
			msj = "Las operaciones válidas son suma (+), resta (-), multiplicación (*), divisón (/)";
			
			break;
		}
		
		calculadora.setMensaje(msj);
		
		return "resultFrm";
		
	}
}
