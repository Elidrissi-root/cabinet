package com.patientManagement.web;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.patientManagement.dao.PatientDao;
import com.patientManagement.beans.Patient;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.patientManagement.dao.PatientDao;
import com.patientManagement.beans.Patient;

/**
 * Servlet implementation class PatientServlet
 */
@WebServlet("/")
public class PatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientDao patientDao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		patientDao = new PatientDao();
	}
    public PatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println("action "+action);

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertPatient(request, response);
				break;
			case "/delete":
				deletePatient(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updatePatient(request, response);
				break;
			default:
				listPatient(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		
	}
	private void listPatient(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Patient> listPatient = patientDao.selectAllPatients();
		listPatient.forEach(System.out::println);
		request.setAttribute("listPatient", listPatient);
		RequestDispatcher dispatcher = request.getRequestDispatcher("patient-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("patient-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Patient existingPatient = patientDao.selectPatient(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("patient-form.jsp");
		request.setAttribute("patient", existingPatient);
		dispatcher.forward(request, response);

	}

	private void insertPatient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		System.out.println("call insert");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String addresse = request.getParameter("addresse");
		String sexe = request.getParameter("sexe");
		//int numTel = Integer.parseInt(request.getParameter("numTel"));
	    //	int numTel =10;
		String numTel = request.getParameter("numTel");
		System.out.println("call insert"+request.getParameter("dateNaissance"));
		   Date dateNaissance;
	         try {
	             dateNaissance = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dateNaissance"));
	         } catch (ParseException e) {
	             dateNaissance = new Date();
	         }
		
		Patient newPatient = new Patient(nom, prenom , addresse , sexe , numTel , dateNaissance);
		patientDao.insertPatient(newPatient);
		response.sendRedirect("list");
	}

	private void updatePatient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String addresse = request.getParameter("addresse");
		String sexe = request.getParameter("sexe");
		//int numTel = Integer.parseInt(request.getParameter("numTel"));
		String numTel = request.getParameter("numTel");
         Date dateNaissance;
         try {
             dateNaissance = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dateNaissance"));
         } catch (ParseException e) {
             dateNaissance = new Date();
         }

		Patient book = new Patient(id, nom, prenom, addresse, sexe , numTel , dateNaissance);
		patientDao.updatePatient(book);
		response.sendRedirect("list");
	}

	private void deletePatient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		patientDao.deletePatient(id);
		response.sendRedirect("list");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
