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
		out.println("上传文件的类型为："+part.getContentType()+"<br/>");
		out.println("上传文件的大小为："+part.getSize()+"<br/>");
		Collection<String> headerNames = part.getHeaderNames();
		for (String headerName : headerNames)
		{
			out.println(headerName + "--->" + part.getHeader(headerName) + "<br/>");
		}
		out.println("上传成功！系统正在分析，请稍候……");
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//可以方便地修改日期格式
		String nowtime = dateFormat.format( now ); 
		String fileNameInfo = part.getHeader("content-disposition");
		String fileName = fileNameInfo.substring(fileNameInfo.indexOf("filename=\"") + 10 ,  fileNameInfo.length()-1);
		part.write(getServletContext().getRealPath("/uploadFiles/") + nowtime + fileName);								
		System.out.println(getServletContext().getRealPath("/uploadFiles/") + nowtime + fileName);
		request.setAttribute("localpath",getServletContext().getRealPath("/uploadFiles/") + nowtime + fileName);
		request.getRequestDispatcher("/wait.jsp").forward(request,response);	
	} 
}
