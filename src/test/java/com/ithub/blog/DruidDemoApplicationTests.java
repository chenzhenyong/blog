package com.ithub.blog;

import com.ithub.blog.controller.UserController;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.Cookie;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DruidDemoApplicationTests {

	public MockHttpServletRequest request;

	@Autowired
	UserController userController;

	private CloseableHttpClient httpClient;

	@Before
	public void before() {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		httpClient = httpClientBuilder.build();
		HttpGet httpGet = new HttpGet(
				"http://android.myapp.com/myapp/app/comment.htm?" +
						"apkName=com.youcash.ZYWallet&apkCode=157&p=1&fresh=0.02709822286851704&contextData=");
	}

	@Test
	public void apiTest() {
		String cookieStr = "b2622b69eaf515ec78703fa02bb221cb1408b8690b8c8f575ffca8ab43fdc3fe4c7b6656b1f7752cdc7205069e94f0485f320589af88255757ad046d9976b598bfef3af8632b17d1db05eb8762b6ce175a9995749f6e959a0823627a0f06efb2a7d813286801b1c3bd421a02f55ab1c96f956c0e0b284f98a52a87eb55fb390417e44d8f4ab879187d2e5649bdda4366d1c58cbf4c1414c6f45e60bc94e507de277ef8f6f1958eaab7c37cada3a28991651c987d6324147c51169af74407c4c670a55fd8a00f11503c1c6ec77f3b96c992817673ad55a8378fc5cc97fa4010d5532f81cd6a6ee410e57718ea8e60b36746bb5650eb7d444900d25f90640728b2c5e6ade3267a0ca91e19c212c1b2452a6d1951eca98d98316b79cc3ad536774268db4a0bb58e8be3424db69ffd9686b96d4a34554a9482e2706061e9e8f75c1234d221cc08af15072b7d0f99f62ecd1216ac491af226ae0d7c16c005edaa75659d872d22ec03eff549ec5c8f13e4a10b26e2abf7056a5bf10df784e9865bc184dee6148119a747d1faec7913bbafad6c4715c82660fdb7a68319d44bc493054c";
		Cookie cookie = new Cookie("SSON", cookieStr);
		Cookie[] cookies = {cookie};
		HttpGet httpGet = new HttpGet(
				"http://android.myapp.com/myapp/app/comment.htm?" +
						"apkName=com.youcash.ZYWallet&apkCode=157&p=1&fresh=0.02709822286851704&contextData=");
		try {
			//执行get请求
			HttpResponse httpResponse = httpClient.execute(httpGet);
			//获取响应消息实体
			HttpEntity entity = httpResponse.getEntity();
			//响应状态
			System.out.println("status:" + httpResponse.getStatusLine());
			//判断响应实体是否为空
			if (entity != null) {
				System.out.println("contentEncoding:" + entity.getContentEncoding());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {                //关闭流并释放资源
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
