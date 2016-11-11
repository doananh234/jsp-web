package com.servlet;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import org.apache.commons.fileupload.FileItem;

import java.util.Date;
import java.util.List;
/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/uploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isMTC = ServletFileUpload.isMultipartContent(request);
		if (isMTC) {
			try {
				String absoluteDiskPath = getServletContext().getRealPath("/assets");
				List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				String nameFile="img";
//				DateTime now = DateTime.;
//				java.util.Date date = now.;
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
				Date date = new Date();
				nameFile += dateFormat.format(date).toString();
				System.out.println(nameFile);
				for (FileItem fileItem : items) {
					nameFile += new File(fileItem.getName()).getName();
					fileItem.write(new File(absoluteDiskPath + File.separator + nameFile)); 
				}
				System.out.println(absoluteDiskPath + File.separator + nameFile);
				request.setAttribute("message", "upload  success");
				response.getWriter().write("assets/"+nameFile);
			} catch (Exception e) {
				// TODO: handle exception
				response.getWriter().write(e.toString());
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
