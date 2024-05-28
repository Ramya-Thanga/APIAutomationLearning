package APIAutomationLearning;

import java.net.MalformedURLException;
import java.net.URL;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;

public class APIAutomationUnirest {
	
	public void UniRestGetRequestExample() throws MalformedURLException, UnirestException
	{
		//URL url = new URL("https://reqres.in/api/users");
		HttpResponse<JsonNode> jsonResponse= 
				Unirest.get("https://reqres.in/api/users/2").asJson();
		System.out.println("Status Code " +jsonResponse.getStatus());
		System.out.println("Status Message" + jsonResponse.getStatusText());
		System.out.println("Json Body" +jsonResponse.getBody());
	}
	
	public void UniRestPostRequestExample() throws UnirestException
	{
		HttpResponse<JsonNode> jsonResponse = Unirest.post("https://reqres.in/api/users/create").body("{\"id\":\"7039\",\"email\":\"ratest@test.in\",\"first_name\":\"RT\",\"last_name\":\"Test\"}").asJson();
		System.out.println("Status Code " +jsonResponse.getStatus());
		System.out.println("Status Message" + jsonResponse.getStatusText());
		System.out.println("Json Body" +jsonResponse.getBody());
	}
	
	public void UniRestPutRequestExample() throws UnirestException
	{
		HttpResponse<JsonNode> jsonResponse = Unirest.put("https://reqres.in/api/users/2").body("{\"id\":\"7039\",\"email\":\"ratest@test.in\",\"first_name\":\"RT\",\"last_name\":\"Test\"}").asJson();
		System.out.println("Status Code " +jsonResponse.getStatus());
		System.out.println("Status Message" + jsonResponse.getStatusText());
		System.out.println("Json Body" +jsonResponse.getBody());
	}
	
	public void UniRestDeleteRequestExample() throws UnirestException
	{
		HttpResponse<JsonNode> jsonResponse = Unirest.delete("https://reqres.in/api/users/2").body("{\"id\":\"7039\",\"email\":\"ratest@test.in\",\"first_name\":\"RT\",\"last_name\":\"Test\"}").asJson();
		System.out.println("Status Code " +jsonResponse.getStatus());
		System.out.println("Status Message" + jsonResponse.getStatusText());
		System.out.println("Json Body" +jsonResponse.getBody());
	}

	public static void main(String[] args) throws MalformedURLException, UnirestException {
		// TODO Auto-generated method stub
       APIAutomationUnirest example = new APIAutomationUnirest();
       //example.UniRestGetRequestExample();
      // example.UniRestPostRequestExample();
      // example.UniRestPutRequestExample();
       example.UniRestDeleteRequestExample();
	}

}
