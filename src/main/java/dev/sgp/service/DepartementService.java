package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Departement;

public class DepartementService {

	List<Departement> listDpt = new ArrayList<>();

	public DepartementService() {

		listDpt.add(new Departement("Comptabilite"));
		listDpt.add(new Departement("Ressources Humaines"));
		listDpt.add(new Departement("Informatique"));
		listDpt.add(new Departement("Administratif"));

	}

	public List<Departement> listerDepartements() {
		return listDpt;
	}

	public void sauvegarderDepartement(Departement dpt) {
		listDpt.add(dpt);
	}

}
