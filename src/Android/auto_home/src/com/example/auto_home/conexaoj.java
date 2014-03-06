package com.example.auto_home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.net.URI;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;

public class conexaoj extends Activity {

	public static final int HTTP_TIMEOUT = 30 * 100;
	private static HttpClient httpClient;

	private static HttpClient getHttpClient() {

		if (httpClient == null) {
			httpClient = new DefaultHttpClient();
			{
				final HttpParams httpParams = httpClient.getParams();
				HttpConnectionParams.setConnectionTimeout(httpParams,
						HTTP_TIMEOUT);
				HttpConnectionParams.setSoTimeout(httpParams, HTTP_TIMEOUT);
				ConnManagerParams.setTimeout(httpParams, HTTP_TIMEOUT);
			}
			return httpClient;
		}
		return httpClient;
	}

	public static String executaHttpPost(String url,ArrayList<NameValuePair> parametrosPost)  throws Exception{
		
		BufferedReader bufferdReader = null;
		try {
			HttpClient client = getHttpClient();
			HttpPost httpPost = new HttpPost(url);
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parametrosPost);
			httpPost.setEntity(formEntity);
			HttpResponse httpResponse = client.execute(httpPost);
			bufferdReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			StringBuffer satringBuffer = new StringBuffer("");
			String line = "";
			String LS = System.getProperty("line.separator");
			while ((line = bufferdReader.readLine()) != null) {
				satringBuffer.append(line + LS);
			}
			bufferdReader.close();
			String resultado = satringBuffer.toString();
			return resultado;

		} finally {
			if (bufferdReader != null) {
				try {
					bufferdReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}

	}
}

