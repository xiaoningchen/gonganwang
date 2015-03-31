package login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class Login {
	public   void login(){
		String msg = "123";
		Properties properties = new Properties();
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String id = properties.getProperty("id");
		String name = properties.getProperty("name");
		String phone = properties.getProperty("phone");
		HttpClient httpclient = new DefaultHttpClient();
		String url = "http://localhost:8080/mvc/test.jsp";
		HttpPost httpPost = new HttpPost(url);
		BasicNameValuePair pair1 = new BasicNameValuePair("id", id);
		BasicNameValuePair pair2 = new BasicNameValuePair("name", name);
		BasicNameValuePair pair3 = new BasicNameValuePair("phone", phone);
		ArrayList<BasicNameValuePair> pairs = new ArrayList<BasicNameValuePair>();
		pairs.add(pair1);
		pairs.add(pair2);
		pairs.add(pair3);
		try {
			HttpEntity requestEntity = new UrlEncodedFormEntity(pairs, "UTF-8");
			httpPost.setEntity(requestEntity);
			try {
				httpclient.execute(httpPost);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Login login = new Login();
		login.login();
	}
}
