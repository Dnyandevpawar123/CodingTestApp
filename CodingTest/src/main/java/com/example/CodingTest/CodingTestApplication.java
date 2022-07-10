package com.example.CodingTest;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodingTestApplication {

	public static void main(String[] args) {
		JSONParser jsonParser =new JSONParser();
		
		try {
			FileReader reader= new FileReader("src/main/resources/json.json");
			Object obj =jsonParser.parse(reader);
			JSONObject jsonObj =(JSONObject) obj;
			JSONArray arr = (JSONArray) jsonObj.get("player");
			System.out.println("Details of foreign Players");
			for(int i=0;i<arr.size();i++)
			{
				JSONObject players =(JSONObject) arr.get(i);
				if(!players.get("country").equals("India"))
				{
					System.out.println("Name:  "+players.get("name")+",  Country:"+players.get("country"));
				}
			}
			System.out.println();
			System.out.println("Detail of Wicket keepe");
			for(int i=0;i<arr.size();i++)
			{
				JSONObject players =(JSONObject) arr.get(i);
				if(players.get("role").equals("Wicket-keeper"))
				{
					System.out.println("Name:  "+players.get("name")+"  Role:"+players.get("role"));
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
