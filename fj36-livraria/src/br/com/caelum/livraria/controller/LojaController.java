package br.com.caelum.livraria.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import br.com.caelum.livraria.modelo.Livro;

@Controller
@RequestMapping("/loja")
public class LojaController {

	@PersistenceContext
	EntityManager entityManager;

	@RequestMapping("/livro")
	public String form(@RequestParam(value = "id", required = true) Integer id, Model modelo) {
		Livro livro = entityManager.find(Livro.class, id);
		modelo.addAttribute("livro", livro);
		return "loja/formulario";
	}

	@RequestMapping("/index")
	public String index(Model modelo) {
		List<Livro> livros = this.entityManager.createQuery("select livro from Livro livro", Livro.class)
				.getResultList();
		modelo.addAttribute("livros", livros);
		return "loja/index";
	}

	@ResponseBody
	@RequestMapping(value = "/livros/mais-vendidos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String livrosMaisVendidos() {

		List<Livro> lisvros = this.entityManager.createQuery("select livro from Livro livro", Livro.class)
				.getResultList();

		XStream xStream = new XStream(new JettisonMappedXmlDriver());
		String json = xStream.toXML(lisvros);
		return json;
	}

}
