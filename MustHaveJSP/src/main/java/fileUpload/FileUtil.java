package fileUpload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

public class FileUtil {

	public static String uploadFile(HttpServletRequest req, String sDirectory) throws ServletException, IOException {
		Part part = req.getPart("ofile");
		String partHeader = part.getHeader("content-disposition");
		String[] phArr = partHeader.split("filename=");
		String originalFileName = phArr[1].trim().replace("\"", "");
		if (!originalFileName.isEmpty()) {
			part.write(sDirectory + File.separator + originalFileName);
		}
		return originalFileName;
	}
	
	public static String renameFile(String sDirectory, String fileName) {
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
		String newFileName = now + ext;
		File oldFile = new File(sDirectory + File.separator + fileName);
		File newFile = new File(sDirectory + File.separator + newFileName);
		oldFile.renameTo(newFile);
		
		return newFileName;
	}
	
	public static ArrayList<String> multipleFile(HttpServletRequest req, String sDirectory) throws ServletException, IOException {
		
		ArrayList<String> listFileName = new ArrayList<>();
		Collection<Part> parts = req.getParts();
		for (Part part : parts) {
			if (!part.getName().equals("ofile")) continue;
			
			String partHeader = part.getHeader("content-disposition");
			String[] phArr = partHeader.split("filename=");
			String originalFileName = phArr[1].trim().replace("\"", "");
			if(!originalFileName.isEmpty()) {
				part.write(sDirectory + File.separator + originalFileName);
			}
			listFileName.add(originalFileName);
		}
		return listFileName;
	}
	
	public static void download(HttpServletRequest req, HttpServletResponse resp, String directory, String sfileName, String ofileName) {
		String sDirectory = req.getServletContext().getRealPath(directory);
		
		try {
			File file = new File(sDirectory, sfileName);
			InputStream iStream = new FileInputStream(file);
			
			String client = req.getHeader("User-Agent");
			if(client.indexOf("WOW64") == -1) {
				ofileName = new String(ofileName.getBytes("UTF-8"), "ISO-8859-1");
			} else {

				ofileName = new String(ofileName.getBytes("KSC5601"), "ISO-8859-1");
			}
			
			resp.reset();
			resp.setContentType("application/octet-stream");
			resp.setHeader("Content-Disposition", "attachment; filename=\"" + ofileName + "\"");
			resp.setHeader("Content-Length", "" + file.length());
			
			OutputStream oStream = resp.getOutputStream();
			
			byte b[] = new byte[(int)file.length()];
			int readBuffer = 0;
			while ((readBuffer = iStream.read(b))>0) {
				oStream.write(b, 0, readBuffer);
			}
			iStream.close();
			oStream.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외가 발생하였습니다.");
			e.printStackTrace();
		}
	}
	
	public static void deleteFile(HttpServletRequest req, String directory, String filename) {
		String sDirectory = req.getServletContext().getRealPath(directory);
		File file = new File(sDirectory + File.separator + filename);
		if (file.exists()) {
			file.delete();
		}
	}
}
