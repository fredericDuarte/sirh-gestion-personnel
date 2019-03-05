package dev.sgp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// recupere la valeur d'un parametre dont le nom est matricule
		String matricule = req.getParameter("matricule");

		if (matricule == null) {
			// 500 //throw new ServletException("Un matricule est attendu");
			resp.sendError(400, "Un matricule est attendu");
		} else {
			resp.setContentType("text/html");

			// code HTML ecrit dans le corps de la reponse
			resp.getWriter().write(
					"<h1>Edition des collaborateurs</h1>" + "<ul>" + "<li>Matricule=" + matricule + "</li>" + "</ul>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String matricule = req.getParameter("matricule");
		String titre = req.getParameter("titre");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");

		resp.setContentType("text/html");

		if ((matricule == null) || (titre == null) || (nom == null) || (prenom == null)) {

			// 500 //throw new ServletException("Les paramètres suivants sont incorrects.");
			resp.sendError(400, "Les paramètres suivants sont incorrects.");

		} else {

			// code HTML ecrit dans le corps de la reponse
			resp.getWriter()
					.write("<h1>Creation d'un collaborateurs</h1>" + "<ul>" + "<li>Matricule=" + matricule + "</li>"
							+ "<li>Titre=" + titre + "</li>" + "<li>Nom=" + nom + "</li>" + "<li>Prénom=" + prenom
							+ "</li>" + "</ul>");
		}

	}

}
