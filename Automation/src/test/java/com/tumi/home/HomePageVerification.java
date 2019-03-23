package com.tumi.home;

import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tumi.utilities.GenericMethods;


public class HomePageVerification extends GenericMethods {

	public static HttpURLConnection huc = null;
	public static String respCode;
	public static String currenturl = "";

	/**
	 * skurry
	 */
	@Test
	public static void verifyHomePageResponse() {

		List<WebElement> links = driver.findElements(By.tagName("a"));

		Iterator<WebElement> it = links.iterator();

		while (it.hasNext()) {

			currenturl = it.next().getAttribute("href");
			if (currenturl == null || currenturl.isEmpty()) {
				logger.log(Status.INFO,"URL is either not configured for anchor tag or it is empty");
				continue;
			}

			try {
				huc = (HttpURLConnection) (new URL(currenturl).openConnection());

				huc.setRequestMethod("HEAD");

				fixUntrustCertificate();

				huc.connect();

				respCode = huc.getResponseMessage();

				if (respCode.equals("OK")) {
					logger.log(Status.INFO,currenturl + "Server Response Code: "+ respCode);
				}else {
					logger.log(Status.FAIL,currenturl + "Server Response Code: "+ respCode);
				}
			} catch (Exception e) {
			}
		}
	}

	public static void fixUntrustCertificate() throws KeyManagementException, NoSuchAlgorithmException {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		} };
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	}

}