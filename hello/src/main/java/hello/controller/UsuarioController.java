package hello.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hello.UsuarioRepository;
import hello.model.Usuario;

@Controller
public class UsuarioController {
	@Autowired
	private UsuarioRepository ur;

	
	/*@RequestMapping(value="/cadastrarUsuarios")
	public String form(){
		return "usuarios/formUsuarios";
	} */
	
	@RequestMapping(value="/cadastrarUsuarios", method=RequestMethod.GET)
	public String form(){
		return "usuarios/formUsuarios";
	}
	
	@RequestMapping(value="/cadastrarUsuarios", method=RequestMethod.POST)
	public String form(Usuario usuario){
		ur.save(usuario);
		return "redirect:/cadastrarUsuarios";
	}
	
	@RequestMapping("/listaUsuarios")
	public ModelAndView listaUsuarios(){
		
		ModelAndView mv = new ModelAndView("usuarios/listaUsuarios");
		
		Iterable<Usuario> usuarios = ur.findAll();
		//ur.findById(null)
		
		mv.addObject("usuarios", usuarios);
		return mv;
	}


}
