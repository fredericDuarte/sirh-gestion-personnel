package dev.sgp.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.*;

public class AjouterCollaborateurController extends HttpServlet {

	private static final Logger LOG = LoggerFactory.getLogger(AjouterCollaborateurController.class);
	Properties prop = new Properties();
	InputStream input = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// utilisation du service

		req.getRequestDispatcher("/WEB-INF/views/collab/nouveauCollaborateurs.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CollaborateurService service = Constantes.COLLAB_SERVICE;
		DepartementService dptService = Constantes.DPT_SERVICE;
		Collaborateur user = new Collaborateur();

		// enregistre le nom et prenom
		user.setNom(req.getParameter("nom"));
		user.setPrenom(req.getParameter("prenom"));

		// récupére le chemin du fichier properties dans le fichier web.xml
		String file = getInitParameter("proper");
		// obtenir le chemin complet avec le fichier propertie
		File propFile = new File(getServletContext().getRealPath(file));
		try {

			input = new FileInputStream(propFile);
			if (!propFile.exists()) {
				LOG.info("properties not found, " + propFile.getAbsolutePath());
			}
			prop.load(input);

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// genere l'adresse email
		user.setEmailPro(req.getParameter("prenom") + "." + req.getParameter("nom") + prop.getProperty("domaine"));
		user.setAdresse(req.getParameter("adresse"));

		// date de naissance
		user.setDateDeNaissance(LocalDate.parse(req.getParameter("dateNaissance")));
		// sécurité social
		user.setNumeroSecuriteSociale(req.getParameter("secu"));
		// vérifie si le numéro de sécu fait 15 chiffres
		if (req.getParameter("secu").length() != 15) {
			resp.sendError(400, "Le numéro de sécurité social doit comporter 15 chiffres");

		}
		// génére la date de création, l'avatar et le matricule
		user.setDateHeureCreation(ZonedDateTime.now(ZoneId.systemDefault()));
		user.setPhoto(getServletContext().getRealPath("/image/default.png"));
		user.setMatricule("M0" + service.listerCollaborateurs().size());
		user.setActif(true);
		// stocke dans la liste
		service.sauvegarderCollaborateur(user);

		LOG.info("Collab = " + user.getNom() + " " + user.getDateDeNaissance());

		req.setAttribute("listeNoms", service.listerCollaborateurs());
		req.setAttribute("listeDpt", dptService.listerDepartements());
		req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(req, resp);

	}

}
