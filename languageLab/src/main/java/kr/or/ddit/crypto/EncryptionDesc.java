package kr.or.ddit.crypto;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/**
 * encode/decode
 *  encoding(부호화) : 전송이나 저장을 위해 매체(media)가 이해할 수 있는 방식으로 데이터의 표현 방식을 바꾸는 작업
 *  					ex) Base64(byte -> text), URLEncoding(percent encoding)
 * encrypt/decrypt
 *  encryption(암호화) : 권한(key) 없는 사용자가 snipping 하거나 spooping 하는 걸 막기 위해 데이터 표현을 바꾸는 작업 - 아무나 이해할 수 없도록 막겠다
 *  - 단방향 암호화(hash 함수) : 암호화된 이후 평문 복원이 불가능한 방식(비밀번호 암호화에 활용)
 *  						다양한 길이의 입력 데이터에 만들어지는 결과 데이터의 길이가 동일한 경우
 *  		ex) SHA-512
 *  - 양방향 암호화 : 암호문에서 원래 평문으로 복호화가 가능한 방식
 *  	- 대칭키 방식 : 하나의 비밀키로 암호화와 복호화에 모두 사용(ebook), 장점 속도 빠름 단점 키가 노출될 수 있음
 *  		ex) AES(128, 256)
 *  	- 비대칭키 방식 : 공개키와 개인키, 한 쌍의 키로 암호화와 복호화에 다른 키를 사용하는 방식(전자서명), 장점 키 노출 가능성 적음 단점 느림
 *  		ex) RSA(2048)
 *  	=> 대칭키, 비대칭키 섞어서 만드는 게 HTTPS
 */
public class EncryptionDesc {
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
		// 단방향 암호화 알고리즘
		String plain = "java";
//		encryptAESTest(plain);
		
		KeyPairGenerator pairGen = KeyPairGenerator.getInstance("RSA");
		pairGen.initialize(2048);
		KeyPair keyPair = pairGen.generateKeyPair();
		PrivateKey privateKey = keyPair.getPrivate(); // 키의 소유자만 가지는
		PublicKey publicKey = keyPair.getPublic(); // 공개키
		
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		byte[] input = plain.getBytes();
		byte[] encrypted = cipher.doFinal(input);
		String encoded = Base64.getEncoder().encodeToString(encrypted);
		System.out.println(encoded);
		
		byte[] decoded = Base64.getDecoder().decode(encoded); // decoded = encrypted
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		byte[] decrypted = cipher.doFinal(decoded); // decrypted = input
		System.out.println(new String(decrypted));
	}
	
	private static void encryptAESTest(String plain) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String ivValueText = "초기화벡터";
		
		MessageDigest md = MessageDigest.getInstance("MD5"); // 128bit
		byte[] iv = md.digest(ivValueText.getBytes());
		IvParameterSpec ivSpec = new IvParameterSpec(iv);
		
		// JCA - Java Crypto API
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // AES : 블럭암호화 방식
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(256); // 128bit 짜리 키를 생성해!
		SecretKey key = keyGen.generateKey(); // 키 생성
		cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec );
		
		byte[] input = plain.getBytes();
		byte[] encrypted = cipher.doFinal(input);
		String encoded = Base64.getEncoder().encodeToString(encrypted); // DB에 넣을 수 있는 암호화된 java
		
		System.out.println(encoded);
		
		byte[] decoded = Base64.getDecoder().decode(encoded);
		
		cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
		byte[] decrypted = cipher.doFinal(decoded); // decoded = encrypted, decrypted = input
		System.out.println(new String(decrypted));
	}
	
	// 단방향 암호화
	private static String encryptSha512(String plain) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512"); // 해쉬함수
			byte[] input = plain.getBytes();
			byte[] encrypted = md.digest(input);
//			System.out.println(encrypted.length);
			String encoded = Base64.getEncoder().encodeToString(encrypted); // DB에 넣음
//			System.out.println(encoded);
			return encoded;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void encodeTest() throws UnsupportedEncodingException {
		String plain = "원문데이터";
		String base64Encoded = Base64.getEncoder().encodeToString(plain.getBytes());
		System.out.println(base64Encoded);
		System.out.println(new String(Base64.getDecoder().decode(base64Encoded)));
		String urlEncoded = URLEncoder.encode(plain, "UTF-8");
		System.out.println(urlEncoded);
		System.out.println(URLDecoder.decode(urlEncoded, "UTF-8"));
	}
}
