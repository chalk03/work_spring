package com.koitt.board.service;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.koitt.board.model.Board;
import com.koitt.board.model.FileException;

@Service
public class FileServiceImpl implements FileService{

	private static final String UPLOAD_FOLDER = "/upload";

	@Override
	public void add(HttpServletRequest request, MultipartFile attachment, Board board) throws FileException {
		try {
			// 최상위 경로 밑에 upload 폴더 경로를 가져온다.
			String path = request.getServletContext().getRealPath(UPLOAD_FOLDER);

			// MultipartFile 객체에서 파일명을 가져온다.
			String originalName = attachment.getOriginalFilename();

			// upload 폴더가 없다면, upload 폴더 생성
			File directory = new File(path);
			if (!directory.exists()) {
				directory.mkdir();
			}

			// attachment 객체를 이용하여, 파일을 서버에 전송
			if (attachment != null && !attachment.isEmpty()) {
				/*
				 * 중복된 파일명을 피하기 위해 시간값을 파일명에 붙이는 작업
				 */
				// 원래 파일명에서 확장자의 시작하는 부분을 찾는다.
				Integer idx = originalName.lastIndexOf(".");
				
				// 원래 파일명에서 확장자 부분을 뺀 나머지 부분을 name변수에 저장
				String name = originalName.substring(0, idx);
				
				// 원래 파일명에서 파일 확장자 부분만 ext 변수에 저장
				String ext = originalName.substring(idx, originalName.length());
				
				// 파일명 + 현재 시간값을 16진수로 변환한 값 + 확장자 
				String uploadFilename = name 
						+ Long.toHexString(System.currentTimeMillis())
						+ ext;
				
				/*
				 * transferTo 파라미터로 전달한 파일경로로 attachment 객체에 담겨있는 파일내용을 업로드한다.
				 */
				attachment.transferTo(new File(path, uploadFilename));
				
				/*
				 * 추후 파일을 다운받았을 때 글자깨짐을 방지하기 위해
				 * URL 인코딩하기 (UTF-8 같은 파일명의 실제 인코딩 방식을 뜻한다.)
				 */
				uploadFilename = URLEncoder.encode(uploadFilename, "UTF-8");
				
				/*
				 * 파일명을 데이터베이스에 저장하기 위해 board 객체에 파일명을 담는다.
				 */
				board.setAttachment(uploadFilename);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new FileException(e.getMessage());
		}
	}

	@Override
	public void remove(HttpServletRequest request, String filename) {

	}

}
