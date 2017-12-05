package groceryapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * The initial logic was copied from a StackOverflow site search for Apache
 * HttpClient: http://hc.apache.org/httpclient-3.x/
 *
 * This code reads in a file that has comma separated values xxx,xxxxxxxx,xxx
 * The characters before the 1st comma are the groceryApp tag id. The characters
 * between the commas are the Walmart ItemId The characters after the 2nd comma
 * are the price that we find manually if we know that Walmart's json data does
 * not contain a price
 *
 * Here is how to read it from a file:
 * https://www.mkyong.com/java/json-simple-example-read-and-write-json/
 */
public class GetWalmartPriceDataSaveToFile {

	public static HttpClient httpClient;

	public static void main(String[] args) throws InterruptedException {

		// Figure out where we will write the output JSON files:
		String basePath = new File("").getAbsolutePath();
		String outputBasePath = basePath + "/src/main/resources/walmart-input-json-for-db-init";
		String inputBasePath = basePath + "/src/main/resources/walmart-input-for-api-lookup";
		System.out.println(basePath);

		// Now read in the input csv file. We will read the data on
		// each line into an arraylist and parse thru it later
		String inputFileName = inputBasePath + "/Walmart_Lookup_ItemIds_Gene.csv";
		ArrayList<String> tagProductIdPriceList = new ArrayList<String>();

		try {
			FileReader fr = new FileReader(inputFileName);
			BufferedReader br = new BufferedReader(fr);
			String s;
			while ((s = br.readLine()) != null) {
				tagProductIdPriceList.add(s);
				System.out.println(s);
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Now, for each item in the arraylist, there is a Walmart itemid
		// We need to call the Walmart Lookup API to get data (in JSON format)
		// about that item. We will write out that JSON data to a file
		// for each item id. Another program will use it to update
		// our Store Item data.
		// We've strung together a tag id, an item id, and potentially a
		// price (if we know the json data is missing a price).
		// Parse out that data from the arraylist entry and pass it
		// to the callWalmartProductAPI function

		// String url2 =
		// "http://api.walmartlabs.com/v1/items/16213260?format=json&apiKey=r8tk9fjzba6cekkc65qp69xy";
		String urlPartA = "http://api.walmartlabs.com/v1/items/";
		String urlPartB = "?format=json&apiKey=r8tk9fjzba6cekkc65qp69xy";

		// we only need to create this one time
		httpClient = HttpClientBuilder.create().build();

		for (String tagProductIdPrice : tagProductIdPriceList) {
			int firstCommaLoc = tagProductIdPrice.indexOf(',');
			int secondCommaLoc = tagProductIdPrice.indexOf(',', firstCommaLoc + 1);
			String tag = tagProductIdPrice.substring(0, firstCommaLoc);
			String productId = tagProductIdPrice.substring(firstCommaLoc + 1, secondCommaLoc);
			String price = tagProductIdPrice.substring(secondCommaLoc + 1);
			String urlWithProductId = urlPartA + productId + urlPartB;
			Thread.sleep(2000); // if you make too many calls/sec, the API errors for this license
			callWalmartProductAPI(urlWithProductId, productId, tag, price, outputBasePath);
		}

	}

	public static void callWalmartProductAPI(String url, String productId, String tag, String price, String basePath) {

		HttpGet request = new HttpGet(url);

		HttpResponse response = null;
		try {
			response = httpClient.execute(request);
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (response.getStatusLine().getStatusCode() != 200) {
			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
		}

		HttpEntity entity = response.getEntity();

		String retSrc = null;
		if (entity != null) {
			try {
				retSrc = EntityUtils.toString(entity);
				// System.out.println(retSrc);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		JSONParser parser = new JSONParser();

		// Use the tag id from the input csv file to add a JSON
		// key/value pair to our output with the tag
		// If there is a price in the csv, add it to the output JSON too.
		// Notice that we name our JSON fields that we add with "groceryApp"
		// to uniquely identify them as coming from our app and not Walmart's.
		Object obj = null;
		try {
			obj = parser.parse(retSrc);
			((JSONObject) obj).put("groceryAppTagId", tag);
			if (!price.isEmpty()) {
				((JSONObject) obj).put("groceryAppPrice", new Double(price));
			}
		} catch (ParseException e1) {
			e1.printStackTrace();
		} catch (org.json.simple.parser.ParseException e1) {
			e1.printStackTrace();
		}

		// Note - we append the file name that we create with .txt
		// because it is easier to read in a text editor
		try {
			String outputFileNamePartA = basePath + "/wmpriceitem";
			String outputFileNamePartB = ".json.txt";
			String outputFileName = outputFileNamePartA + productId + outputFileNamePartB;
			FileWriter file = new FileWriter(outputFileName);
			file.write(obj.toString());
			file.flush();
			// System.out.println("Successfully Copied JSON Object to File...");
			// System.out.println("\nJSON Object: " + obj);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// Save below in case we want to add it back for debugging at some point.
	/*
	 * JSONObject jsonObject = (JSONObject) obj; System.out.println(jsonObject);
	 * 
	 * String name = (String) jsonObject.get("name"); System.out.println(name);
	 * 
	 * System.out.println("----------------------------------------");
	 * System.out.println(response.getStatusLine()); Header[] headers =
	 * response.getAllHeaders(); for (int i = 0; i < headers.length; i++) {
	 * System.out.println(headers[i]); }
	 * System.out.println("----------------------------------------");
	 */
}
