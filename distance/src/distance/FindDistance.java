package distance;

import java.net.*;
import java.io.*;

public class FindDistance {
	private static String API_KEY = "AIzaSyC2lK-ksS3EzEJEd7ALJVOG0sN-TQsGhto";
	private static String BASE_URL = "https://maps.googleapis.com/maps/api/distancematrix/json?";
	private static String ORIGIN = "7011 Sherbourne Lane, San Diego, CA";
	private static String DESTINATION = "11108 Adobe Circle, IRVINE,CA";

	public static void main(String args[]) throws IOException {
		double kmToM = 0.621371;
		String[] originSplit = ORIGIN.split(",");
		String[] destinationSplit = DESTINATION.split(",");
		String ecodedURL = BASE_URL + "origins="
				+ URLEncoder.encode(originSplit[0], "UTF-8") + ","
				+ URLEncoder.encode(originSplit[1], "UTF-8") + ","
				+ URLEncoder.encode(originSplit[2], "UTF-8") + "&destinations="
				+ URLEncoder.encode(destinationSplit[0], "UTF-8") + ","
				+ URLEncoder.encode(destinationSplit[1], "UTF-8") + ","
				+ URLEncoder.encode(destinationSplit[2], "UTF-8")
				+ "&mode=driving&key=" + API_KEY;
		URL url = new URL(ecodedURL);
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					url.openStream(), "UTF-8"));
			String str;
			String distance;
			double milesTemp;
			String miles;
			String temp;
			while ((str = in.readLine()) != null) {
				if (str.contains("text")) {
					distance = str.trim().split(":")[1];
					distance = distance.substring(2,distance.lastIndexOf("\""));
					System.out.println(distance);
					temp = distance.split(" ")[0]; 
					milesTemp = Double.parseDouble(temp);
					milesTemp *= kmToM;
					miles = milesTemp + " miles";
					System.out.println(miles);
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
