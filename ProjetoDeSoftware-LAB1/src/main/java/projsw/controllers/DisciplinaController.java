package projsw.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import projsw.entities.Disciplina;
import projsw.entities.DtoDisciplina;
import projsw.entities.Nome;
import projsw.entities.Nota;
import projsw.services.DisciplinaService;

@RestController
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;
	
	@PostMapping("/api/disciplinas")
	public ResponseEntity<Disciplina> criarDisciplina(@RequestBody DtoDisciplina disciplina){
		return new ResponseEntity<Disciplina>(disciplinaService.criarDisciplina(disciplina), HttpStatus.OK);
	}
	
	@GetMapping("/api/disciplinas")
	public ResponseEntity<ArrayList<Disciplina>> listarDisciplinas(){
		return new ResponseEntity<ArrayList<Disciplina>>(disciplinaService.listarDisciplinas(), HttpStatus.OK);
	}
	
	@GetMapping("/api/disciplinas/{id}")
	public ResponseEntity<Disciplina> disciplinaPorId(@PathVariable int id){
		Disciplina disciplina = disciplinaService.disciplinaPorId(id);
		if(disciplina == null) {
			return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		}
		else {
		return new ResponseEntity<Disciplina>(disciplina, HttpStatus.OK);
		}
	}
	
	@PutMapping("/api/disciplinas/{id}/nome")
	public ResponseEntity<Disciplina> atualizarNome(@PathVariable int id, @RequestBody Nome nome){
		Disciplina disciplina = disciplinaService.atualizarNome(id, nome.getNome());
		if(disciplina == null) {
			return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		}
		else {
		return new ResponseEntity<Disciplina>(disciplina, HttpStatus.OK);
		}
	}
	
	@PutMapping("/api/disciplinas/{id}/nota")
	public ResponseEntity<Disciplina> atualizarNota(@PathVariable int id, @RequestBody Nota nota){
		Disciplina disciplina = disciplinaService.atualizarNota(id, nota.getNota());
		if(disciplina == null) {
			return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		}
		else {
		return new ResponseEntity<Disciplina>(disciplina, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("api/disciplinas/{id}")
	public ResponseEntity<Disciplina> removeDisciplina(@PathVariable int id){
		Disciplina disciplina  = disciplinaService.removeDisciplina(id);
		if(disciplina == null) {
			return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		}
		else {
		return new ResponseEntity<Disciplina>(disciplina, HttpStatus.OK);
		}
	}
	
	@GetMapping("/api/disciplinas/ranking")
	public ResponseEntity<ArrayList<Disciplina>> rankingDisciplinas(){
		return new ResponseEntity<ArrayList<Disciplina>>(disciplinaService.rankingDisciplinas(), HttpStatus.OK);
	}
	
	@PostMapping("api/disciplinas/lista")
	public ResponseEntity<ArrayList<Disciplina>> criarVariasDisciplinas(@RequestBody ArrayList<DtoDisciplina> lista){
		return new ResponseEntity<ArrayList<Disciplina>>(disciplinaService.criarVariasDisciplinas(lista), HttpStatus.OK);
	}
	
	@GetMapping("api/disciplinas/keys")
	public ResponseEntity<ArrayList<Integer>> keys(){
		return new ResponseEntity<ArrayList<Integer>>(disciplinaService.pegarKeys(), HttpStatus.OK);
	}
}
