package com.koitt.book.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.koitt.book.model.Book;
import com.koitt.book.model.FileException;

@Service
public class FileServiceImpl implements FileService{

	private static final String UPLOAD_FOLDER = "/upload";

	@Override
	public void add(HttpServletRequest request, MultipartFile attachment, Book book) throws FileException {
		try {
			String path = request.getServletContext().getRealPath(UPLOAD_FOLDER);

			String originalName = attachment.getOriginalFilename();

			File directory = new File(path);
			if (!directory.exists()) {
				directory.mkdir();
			}

			if (attachment != null && !attachment.isEmpty()) {
				Integer idx = originalName.lastIndexOf(".");
				String name = originalName.substring(0, idx);
				String ext = originalName.substring(idx, originalName.length());
				String uploadFilename = name 
						+ Long.toHexString(System.currentTimeMillis())
						+ ext;
				attachment.transferTo(new File(path, uploadFilename));
				uploadFilename = URLEncoder.encode(uploadFilename, "UTF-8");
				book.setAttachment(uploadFilename);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new FileException(e.getMessage());
		}

	}

	@Override
	public void remove(HttpServletRequest request, String filename) throws FileException {
		String path = request.getServletContext().getRealPath(UPLOAD_FOLDER);

		if (filename != null && !filename.trim().isEmpty()) {
			// filename 디코딩
			try {
				filename = URLDecoder.decode(filename, "UTF-8");

			} catch (Exception e) {
				throw new FileException(e.getMessage());
			}

			// 서버에 저장된 파일을 불러와서 객체화 시킴
			File file = new File(path, filename);

			// 만약 파일이 존재하면 파일을 삭제한다.
			if (file.exists()) {
				file.delete();
			}
		}
	}

	@Override
	public void download(HttpServletRequest request, HttpServletResponse response, 
			String filename) throws FileException {

		// 서버에 저장된 파일 경로 불러오기
		String directory = request.getServletContext().getRealPath(UPLOAD_FOLDER);

		// 요청한 파일명으로 실제 파일을 객체화 하기
		File file = new File(directory, filename);

		FileInputStream fis = null;
		BufferedOutputStream bos = null;
		try {
			// 파일 객체를 이용하여 파일을 읽어들인다.
			fis = new FileInputStream(file);

			// 다운로드 할 때 한글 깨짐현상 처리
			filename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");

			/*
			 *  클라이언트(브라우저)에게 응답할 헤더정보를 보낸다.
			 */
			// MIME TYPE: https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/MIME_types
			response.setContentType("application/octet-stream");

			// 내려받을 파일명 정보를 전달하기위해 사용
			response.setHeader("Content-Disposition", "attachment; filename=" + filename + ";");

			// 파일 전송 인코딩 타입: binary는 2진수로 전송하겠다는 뜻
			response.setHeader("Content-Transfer-Encoding", "binary");

			// 파일의 크기를 전송: fis.available()는 현재 읽어들인 파일의 크기를 리턴
			response.setHeader("Content-Length", Integer.toString(fis.available()));

			/*
			 * 파일 캐싱(caching) 방지
			 * 같은 파일을 내려받더라도 브라우저가 항상 새로운 파일이라고 인식하기 위해
			 */
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "-1");

			// OutputStream을 이용하여 읽어들인 파일을 클라이언트(브라우저)로 전송
			bos = new BufferedOutputStream(response.getOutputStream());

			int length = 0;
			byte[] buff = new byte[1024];	// 1024 byte = 1 kilo byte 단위로 전송

			// 서버에 있는 파일을 읽어서 클라이언트에게 파일을 전송
			while ((length = fis.read(buff)) > 0) {
				bos.write(buff, 0, length);
			}

			// 버퍼에 남아있는 정보를 보내준다.
			bos.flush();

			bos.close();
			fis.close();

		} catch (Exception e) {
			throw new FileException(e.getMessage());	
		}
	}

	@Override
	public String getImgPath(HttpServletRequest request, String filename) {
		String contextPath = request.getContextPath();

		if (filename != null && !filename.trim().isEmpty()) {
			int idx = filename.lastIndexOf(".");
			String ext = filename.substring(idx, filename.length());

			switch (ext) {
			case ".jpg":
			case ".jpeg":
			case ".png":
				return contextPath + UPLOAD_FOLDER + "/" + filename;
			}
		}

		return null;
	}
}
