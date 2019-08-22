package projsw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import projsw.entities.Disciplina;
import projsw.entities.DtoDisciplina;
import projsw.tools.ComparatorDisciplina;

@Service
public class DisciplinaService {

	private HashMap<Integer, Disciplina> disciplinas = new HashMap<Integer, Disciplina>();
	private int key = 1;
	private ArrayList<Integer> keys = new ArrayList<Integer>();
	
	public Disciplina criarDisciplina(DtoDisciplina disciplina) {
		Disciplina novaDisciplina = new Disciplina(key,disciplina.getNome(), disciplina.getNota());
		disciplinas.put(key, novaDisciplina);
		keys.add(key);
		key++;
		return novaDisciplina;
	}
	
	public ArrayList<Disciplina> listarDisciplinas(){
		ArrayList<Disciplina> lista = new ArrayList<Disciplina>(); 
		keys.forEach((chave) -> lista.add(disciplinas.get(chave)));
		return(lista);
		
	}
	
	public Disciplina disciplinaPorId(int id) {
		return disciplinas.get(id);
	}
	
	public Disciplina atualizarNome(int id, String nome) {
		if (!keys.contains(id)) {
			return null;
		}
		else {
		Disciplina disciplinaAtualizada = disciplinas.get(id);
		disciplinaAtualizada.setNome(nome);
		disciplinas.put(id, disciplinaAtualizada);
		return disciplinaAtualizada;
		}
	}

	public Disciplina atualizarNota(int id, double nota) {
		if (!keys.contains(id)) {
			return null;
		}
		else {
		Disciplina disciplinaAtualizada = disciplinas.get(id);
		disciplinaAtualizada.setNota(nota);
		disciplinas.put(id, disciplinaAtualizada);
		return disciplinaAtualizada;
		}
	}

	public Disciplina removeDisciplina(int id) {
		Disciplina disciplina = disciplinas.get(id);
		disciplinas.remove(id);
		keys.remove(id-1);
		return disciplina;
	}

	public ArrayList<Disciplina> rankingDisciplinas() {
		ArrayList<Disciplina> lista = this.listarDisciplinas();
		Collections.sort(lista, new ComparatorDisciplina());
		return lista;
	}

	public ArrayList<Disciplina> criarVariasDisciplinas(ArrayList<DtoDisciplina> lista) {
		ArrayList<Disciplina> adicionadas = new ArrayList<Disciplina>();
		lista.forEach((disciplina) -> adicionadas.add(this.criarDisciplina(disciplina)));
		return adicionadas;
	}
	
	public ArrayList<Integer> pegarKeys(){
		return keys;
	}
}
