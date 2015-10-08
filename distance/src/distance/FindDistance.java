package distance;

import java.net.*;
import java.io.*;

public class FindDistance {
	//Change the API_KEY to your own, if you don't and keep using this one, it'll eventually
	//or might max out on you
	//This file should have eventually be connected to the LatLng one to get Origin and Destination
	private static String API_KEY = "AIzaSyC2lK-ksS3EzEJEd7ALJVOG0sN-TQsGhto";
	private static String BASE_URL = "https://maps.googleapis.com/maps/api/distancematrix/json?";
	private static String ORIGIN = "7011 Sherbourne Lane, San Diego, CA";
	private static String DESTINATION = "11108 Adobe Circle, IRVINE,CA";

	public static void main(String args[]) throws IOException {
		double kmToM = 0.621371; 
		//URL's are annoying in the sense that encoding screws up commas so the string was split
		//but the part inside still needs to be encoded for the space, feel free to try out if it would work 
		//without a space between each word in the URL
		//this is by no way the cleanest way to do this but at the same time I can't remember exactly
		//how to make functions in Java at this particular moment. Also in this case I would have ended up
		//with potentially two for loops. It probably would be useful to clean and reuse the adding part
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
		System.out.println(url);
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					url.openStream(), "UTF-8"));
			String str;
			String distance;
			double milesTemp;
			String miles;
			String temp;
			//this is all about reading it in like .txt file
			//most of this is converting km to miles as well manipulating strings to doubles and whatnot
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
