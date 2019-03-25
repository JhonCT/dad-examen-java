package dadexamen.dadexamen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*")
@RestController
public class EmployeesController {

	@GetMapping("/employees")
	public JsonNode getEmployees() throws Exception {
		JsonNode actualObj = null;

		StringBuilder result = new StringBuilder();
		URL url = new URL("http://dummy.restapiexample.com/api/v1/employees");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String output = null;

		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		rd.close();

		ObjectMapper mapper = new ObjectMapper();

		actualObj = mapper.readTree(result.toString());

		System.out.println(actualObj);

		return actualObj;
	}
}
