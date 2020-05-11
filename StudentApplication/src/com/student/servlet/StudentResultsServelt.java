package com.student.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentResultsServelt extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String studentName = req.getParameter("name");
		Integer subject1 = Integer.parseInt(req.getParameter("subject1"));
		Integer subject2 = Integer.parseInt(req.getParameter("subject2"));
		Integer subject3 = Integer.parseInt(req.getParameter("subject3"));
		Integer subject4 = Integer.parseInt(req.getParameter("subject4"));
		Integer subject5 = Integer.parseInt(req.getParameter("subject5"));
		
		int totalMarks = subject1 + subject2 + subject3 + subject4 + subject5;
		float average = totalMarks/5f;
		req.setAttribute("name", studentName);
		req.setAttribute("subject1", subject1);
		req.setAttribute("subject2", subject2);
		req.setAttribute("subject3", subject3);
		req.setAttribute("subject4", subject4);
		req.setAttribute("subject5", subject5);
		req.setAttribute("totalmarks", totalMarks);
		req.setAttribute("average", average);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("resultsdisplay.jsp");
		requestDispatcher.forward(req, resp);
	}
}
