package distance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class getAddress {
	private static String API_KEY = "AIzaSyC2lK-ksS3EzEJEd7ALJVOG0sN-TQsGhto"; //Replace with your own API_KEY from Google developers
	private static String BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json?"; //first part of URL you need. They'll have a reference for you in API
	//my temp values, this leads to my place in Irvine 
	private static String LAT = "33.646600"; 
	private static String LNG = "-117.834397";
	
	
	public static void main(String args[]) throws IOException{
		//This format will change depending on what you're doing realistically you should have 
		//encoding do this but Java gave me a headache
		String combinedURL = BASE_URL + "latlng=" + LAT + ","+ LNG + "&key=" + API_KEY;
		System.out.println(combinedURL); //just to print out url and check
		URL url = new URL(combinedURL);
		//this is all to read the JSON from the URL, it's more like a .txt file in this case
		//you can try to figure out how to create a JSONObject and using the keys
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