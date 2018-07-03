package com.czy.druiddemo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Map.Entry;

/**
* @author: Chenzhenyong
* @description:
* @date: Created in 18:30 2018/5/8
*/
public class HttpUtil {
	private static final String CHARSET = "utf-8";//"UTF-8"; // 字符编码集

	public static String doHttpPost(String url, Map<String, String> req) {
		StringBuffer sb = new StringBuffer();
		for(Entry<String, String> entry : req.entrySet()){
			sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
		}
		return doHttpPost(url, sb.toString());
	}
	
	/**
	 * HTTP POST
	 * 
	 * @param url
	 *            请求地址
	 * @param req
	 *            请求参数，格式：name1=value1&name2=value2...
	 * @return 应答参数
	 */
	public static String doHttpPost(String url, String req) {


		PrintWriter outPrintWriter = null;
		BufferedReader inBufferedReader = null;
		try {
			URLConnection urlConnection = new URL(url).openConnection(); // 打开和URL之间的连接
			// 设置通用的请求属性
			urlConnection.setRequestProperty("accept", "*/*");
			urlConnection.setRequestProperty("connection", "Keep-Alive");
			urlConnection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 必须设置如下两行
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(true);
			urlConnection.setConnectTimeout(30000);
			urlConnection.setReadTimeout(30000);

			urlConnection.connect(); // 建立实际的连接

			outPrintWriter = new PrintWriter(urlConnection.getOutputStream()); // 获取URLConnection对象对应的输出流
			outPrintWriter.print(req); // 发送请求参数
			outPrintWriter.flush(); // flush输出流的缓冲
			inBufferedReader = new BufferedReader(new InputStreamReader(
					urlConnection.getInputStream(), CHARSET)); // 定义BufferedReader输入流来读取URL的响应
			String line = "";
			String response = "";
			while ((line = inBufferedReader.readLine()) != null) {
				response += line;
			}
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} finally {
			try {
				if (outPrintWriter != null) {
					outPrintWriter.close();
				}
				if (inBufferedReader != null) {
					inBufferedReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
     *
	 * @param urlPath
     * @param cookie
     * @return
     */
	public static String doPost(String urlPath, String cookie) {
		URL url = null;
		try {
			url = new URL(urlPath);
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("SSON", cookie);
			conn.setDoInput(true);
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}