package com.util.file;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ImageUtil {

	/**
	 * BASE64编码
	 * 
	 * @param imgFile
	 * @return
	 */
	// BASE64 编码
	private static BASE64Encoder encoder = new BASE64Encoder();

	public static String getImageBase64Str(String imgFile) {

		InputStream inputStream = null;
		byte[] data = null;
		try {

			inputStream = new FileInputStream(imgFile);
			data = new byte[inputStream.available()];
			inputStream.read(data);

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

//		System.out.println(encoder.encode(data));
		return encoder.encode(data);
		// System.out.println("--------------------------------------------");
		// return Base64.encode(data);
		// System.out.println(Base64.encode(data));
		// return null;

	}

	/**
	 * @Description: 将base64编码字符串转换为图片
	 * @Author:
	 * @CreateTime:
	 * @param imgStr
	 *            base64编码字符串
	 * @param path
	 *            图片路径-具体到文件
	 * @return
	 */
	public static boolean baseToImage(String imgStr, String path) {

		if (imgStr == null)
			return false;

		BASE64Decoder decoder = new BASE64Decoder();
		// OutputStream out = null;
		try {

			// 解密
			byte[] b = decoder.decodeBuffer(imgStr);
			// 处理数据
			for (int i = 0; i < b.length; i++) {

				if (b[i] < 0) {
					b[i] += 256;
				}

			}
			OutputStream out = new FileOutputStream(path);
			out.write(b);
			out.flush();
			out.close();
			// 解析成功
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			// 解析失败
			return false;

		}

	}

	// public static void main(String[] args) {
	//
	// String imgBase64 =
	// getImageBase64Str("C:\\Users\\Dong\\Desktop\\Art\\艺术照样品\\炳彭 (1).JPG");
	// System.out.println(imgBase64);
	// baseToImage(imgBase64, "D:/2.jpg");
	//
	// }

}
