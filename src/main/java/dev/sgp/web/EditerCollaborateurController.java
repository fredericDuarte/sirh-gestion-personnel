package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<String, String> paramUrl;
	private boolean isfull = true;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// recupere la valeur d'un parametre dont le nom est matricule
		String matricule = req.getParameter("matricule");

		if (matricule == null) {
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

		paramUrl = new HashMap<String, String>();

		paramUrl.put("matricule", req.getParameter("matricule"));
		paramUrl.put("titre", req.getParameter("titre"));
		paramUrl.put("nom", req.getParameter("nom"));
		paramUrl.put("prenom", req.getParameter("prenom"));

		resp.setContentType("text/html");
		isfullParamter(paramUrl);
		if (!isfull) {
			resp.sendError(400, "Les paramètres suivants sont incorrects." + isfullParamter(paramUrl)

			);

		} else {

			resp.getWriter().write(forfullParamter(paramUrl));
		}

	}

	protected String isfullParamter(HashMap<String, String> param) {
		String chaine = "";
		for (Entry<String, String> par : param.entrySet()) {
			if (par.getValue() == null) {
				chaine += par.getKey() + " , ";
				this.isfull = false;
			}
		}

		return chaine;

	}

	protected String forfullParamter(HashMap<String, String> param) {
		String chaine = "Creation d’un collaborateur /n";
		for (Entry<String, String> par : param.entrySet()) {

			chaine += par.getKey() + " = " + par.getValue() + " , ";

		}

		return chaine;

	}

}
