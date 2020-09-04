package resources;

import java.util.ArrayList;
import java.util.List;

import POJO.AddPlaceAPI_Request_Serialization;

public class TestDataBuild {
	
	
	public AddPlaceAPI_Request_Serialization addPlacePlayload(String name , String language , String address) {
	
		POJO.AddPlaceAPI_Request_Serialization add = new POJO.AddPlaceAPI_Request_Serialization();
		POJO.location loc = new POJO.location();
		loc.setLat(-38.383494);
		loc.setLat(33.427362);
		add.setAccuracy(50);
		add.setName(name);
		add.setPhone_number("(+91) 983 893 3937");
		add.setAddress(address);
		add.setWebsite("http://google.com");
		add.setLanguage(language);
		List<String> mylist = new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		add.setTypes(mylist);
		add.setLocation(loc);
		
		return add;
	}

}
