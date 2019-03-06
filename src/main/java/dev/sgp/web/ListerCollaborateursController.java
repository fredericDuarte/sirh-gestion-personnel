package dev.sgp.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;

public class ListerCollaborateursController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// recuperation du service
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	private DepartementService dptService = Constantes.DPT_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// utilisation du service
		//List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();

		req.setAttribute("listeNoms", collabService.listerCollaborateurs());
		req.setAttribute("listeDpt", dptService.listerDepartements());
		req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(req, resp);
	}

}
