package APIAutomationLearning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class APIAutomationLearning {

	public static void getMethodExample() throws IOException {
		// TODO Auto-generated method stub
		
		//URL url = new URL("http://dummy.restapiexample.com/api/v1/employees"); 
		URL url = new URL("https://reqres.in/api/users");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setRequestMethod("GET");
		conn.connect();
		
		int RespCode = conn.getResponseCode();
		System.out.println("Status Code is:" + RespCode);
		
		String RespStatus = conn.getResponseMessage();
		System.out.println("Status Message is:" + RespStatus);
		
		InputStream responseBody = conn.getInputStream();
		InputStreamReader ir = new InputStreamReader(responseBody);
		
		BufferedReader br = new BufferedReader(ir);
		String line;
		StringBuffer buff = new StringBuffer();
		while((line = br.readLine())!=null)
		{
			
			buff.append(line);
		}
		System.out.println(buff);

}
	public static void PostMethodExample() throws IOException
	{
		URL PostUrl = new URL("https://reqres.in/api/users/create");
		HttpURLConnection postConn = (HttpURLConnection) PostUrl.openConnection();
		
		postConn.setRequestMethod("POST");
		
		postConn.setRequestProperty("Content-Type", "application/json");
		postConn.setDoOutput(true);
		
		//String JSONBody = "{\"id\":\"7039\",\"employee_name\":\"RumsRajaT\",\"employee_salary\":\"320800\",\"employee_age\":\"27\"}";
		String JSONBody = "{\"id\":\"7039\",\"email\":\"ratest@test.in\",\"first_name\":\"RT\",\"last_name\":\"Test\"}";
		byte[] bodyBytes = JSONBody.getBytes();
		//postConn.connect();
		OutputStream outputStream = postConn.getOutputStream();
		outputStream.write(bodyBytes);
		
		System.out.println("Response Code:" + postConn.getResponseCode());
		System.out.println("Response Message:" + postConn.getResponseMessage());
		
		InputStream PostIR = postConn.getInputStream();
		InputStreamReader PostISR = new InputStreamReader(PostIR);
		
		BufferedReader postBR = new BufferedReader(PostISR);
		String PostLine;
		
		StringBuffer postBuffer = new StringBuffer();
		
		while((PostLine = postBR.readLine())!=null)
		{
			postBuffer.append(PostLine);
		}
		System.out.println(postBuffer);
	}
	
	public static void putRequest() throws IOException
	{
		URL url = new URL("https://reqres.in/api/users/2");
		
		HttpURLConnection putConn = (HttpURLConnection) url.openConnection();
		
		putConn.setRequestMethod("PUT");
		putConn.setRequestProperty("Content-Type", "application/json");
		
		putConn.setDoOutput(true);
		String JSONBody = "{\"id\":\"2\",\"email\":\"ratest@test.in\",\"first_name\":\"RT\",\"last_name\":\"Test\"}";
		
		byte[] bodyPutBytes = JSONBody.getBytes();
		
		OutputStream opStream = putConn.getOutputStream();
		opStream.write(bodyPutBytes);
		
		System.out.println("Response Code:" + putConn.getResponseCode());
		System.out.println("Response Message:" + putConn.getResponseMessage());
		
		InputStream PutIR = putConn.getInputStream();
		InputStreamReader PutISR = new InputStreamReader(PutIR);
		
		BufferedReader putBR = new BufferedReader(PutISR);
		String PutLine;
		
		StringBuffer putBuffer = new StringBuffer();
		
		while((PutLine = putBR.readLine())!=null)
		{
			putBuffer.append(PutLine);
		}
		System.out.println(putBuffer);
		
	}
	
	public static void main(String[] args) throws IOException 
	
	{
		APIAutomationLearning APIAuto = new APIAutomationLearning();
		//APIAuto.getMethodExample();
		//APIAuto.PostMethodExample();
		APIAuto.putRequest();
		
	} 
}