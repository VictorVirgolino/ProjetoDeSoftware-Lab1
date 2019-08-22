package projsw.tools;

import java.util.Comparator;

import projsw.entities.Disciplina;

public class ComparatorDisciplina implements Comparator<Disciplina>{
	
		public int compare(Disciplina a, Disciplina b) {
			if(a.getNota() < b.getNota()) return 1;
			if(a.getNota() > b.getNota()) return -1;
			return 0;
		}

}
