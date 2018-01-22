package fileoperation;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.util.Date;
import java.text.SimpleDateFormat; 

@WebServlet(name="upload", urlPatterns= {"/upload"})
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		Part part = request.getPart("file");
		out.println("�ϴ��ļ�������Ϊ��"+part.getContentType()+"<br/>");
		out.println("�ϴ��ļ��Ĵ�СΪ��"+part.getSize()+"<br/>");
		Collection<String> headerNames = part.getHeaderNames();
		for (String headerName : headerNames)
		{
			out.println(headerName + "--->" + part.getHeader(headerName) + "<br/>");
		}
		out.println("�ϴ��ɹ���ϵͳ���ڷ��������Ժ򡭡�");
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//���Է�����޸����ڸ�ʽ
		String nowtime = dateFormat.format( now ); 
		String fileNameInfo = part.getHeader("content-disposition");
		String fileName = fileNameInfo.substring(fileNameInfo.indexOf("filename=\"") + 10 ,  fileNameInfo.length()-1);
		part.write(getServletContext().getRealPath("/uploadFiles/") + nowtime + fileName);								
		System.out.println(getServletContext().getRealPath("/uploadFiles/") + nowtime + fileName);
		request.setAttribute("localpath",getServletContext().getRealPath("/uploadFiles/") + nowtime + fileName);
		request.getRequestDispatcher("/wait.jsp").forward(request,response);	
	} 
}
