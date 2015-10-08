package distance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class getAddress {
	private static String API_KEY = "AIzaSyC2lK-ksS3EzEJEd7ALJVOG0sN-TQsGhto";
	private static String BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json?";
	private static String LAT = "33.646600";
	private static String LNG = "-117.834397";
	
	
	public static void main(String args[]) throws IOException{
		String combinedURL = BASE_URL + "latlng=" + LAT + ","+ LNG + "&key=" + API_KEY;
		System.out.println(combinedURL);
		URL url = new URL(combinedURL);
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					url.openStream(), "UTF-8"));
			String str;
			String address;
			while ((str = in.readLine()) != null) {
				if (str.contains("formatted_address")) {
					address = str.split(":")[1].trim();
					address = address.substring(2,address.lastIndexOf("\""));
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}