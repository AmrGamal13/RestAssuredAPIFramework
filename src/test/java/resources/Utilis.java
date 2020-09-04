package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

//that class contains the request builder
public class Utilis {
	//for logging everything in case if there are multiple dataset (reuisng the same object) so it's static
	public static RequestSpecification requestbuild;

	public RequestSpecification requestspecificationgroup() throws IOException 
	{
		//in body we will pass the object of our main class (AddPlaceAPI_Request_Serialization)
		//RestAssured.baseURI = "https://rahulshettyacademy.com";
		//request spec builder for the request includes(baseUri, content type , queryparam)
		//response spec builder includes assertion of the status code & content type


		//we create a logging file to log the request and the response instead of using.log().all()
		//if statement here for logging everything in case if there are multiple dataset
		if (requestbuild == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			requestbuild = new RequestSpecBuilder().setBaseUri(GetGlobalVariable("BaseUri"))
					.addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))//logging the request
					.addFilter(ResponseLoggingFilter.logResponseTo(log))//logging the response
					.setContentType(ContentType.JSON).build();

			return requestbuild;
		}

		return requestbuild;
	}

	//we use the global vraiable here to set the variables that don't change in a properties file and reat it
	public static String GetGlobalVariable(String key) throws IOException 
	{

		Properties prop = new Properties();
		//read the properties file
		FileInputStream fis = new FileInputStream("/Users/adelmostafa/Documents/RestAssuredAPIFramework/src/test/java/resources/globalVariables.properties");
		prop.load(fis);
		//pass the name of the key inside the properties file that you want to get the value of
		String value = prop.getProperty(key);
		return value;
	}
}
