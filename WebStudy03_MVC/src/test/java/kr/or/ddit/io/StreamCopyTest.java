package kr.or.ddit.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class StreamCopyTest {
	private File targetFile;
	private File destFile;
	
	// test를 실행하기 전에!
	@Before
	public void setUp() {
		targetFile = new File("D:/contents/movies/target.mp4");
		destFile = new File("d:/target.mp4");
	}
	
	//@Test // 7.840 초
	public void copyTest1() throws IOException {
		try(
			FileInputStream fis = new FileInputStream(targetFile);
			FileOutputStream fos = new FileOutputStream(destFile);
		) {
			// eof, eos를 만날 때까지 읽어들이기
			int tmp = -1;
			while ((tmp=fis.read())!=-1) {
				fos.write(tmp);
			}
		}
	}
	
	//@Test // 0.007 초
	public void copyTest2() throws IOException {
		try(
			FileInputStream fis = new FileInputStream(targetFile);
			FileOutputStream fos = new FileOutputStream(destFile);
		) {
			// eof, eos를 만날 때까지 읽어들이기
			byte[] buffer = new byte[1024];
			int length = -1;
			int count = 1;
			while ((length=fis.read(buffer))!=-1) {
				if(count++ == 1) {
					Arrays.fill(buffer, (byte)0); // 영상의 앞부분이 짤림
				}
				fos.write(buffer, 0, length);
			}
		}
	}
	
	@Test // 0.031 초
	public void copyTest3() throws IOException {
		try(
			FileInputStream fis = new FileInputStream(targetFile);
			FileOutputStream fos = new FileOutputStream(destFile);
				
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
		) {
			// eof, eos를 만날 때까지 읽어들이기
			int tmp = -1;
			while ((tmp=bis.read())!=-1) {
				bos.write(tmp);
			}
		}
	}
}
