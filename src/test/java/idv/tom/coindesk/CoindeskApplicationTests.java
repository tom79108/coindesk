package idv.tom.coindesk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;

import idv.tom.coindesk.entity.CoinDeskDataEntity;

@Rollback
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CoindeskApplicationTests {
	
	final String baseurl = "http://localhost:8080/ws/";
	
	TestRestTemplate restTemplate;
	
    @Test
    void TestCoinDeskAPIAboutDBSelect() {
    	System.out.println("=====================================================");
    	System.out.println("Test Select");
    	TestRestTemplate selectTemplate = new TestRestTemplate();
		ResponseEntity<String> selectGetResponse = selectTemplate.getForEntity(baseurl + "CoinDeskAPI/{coinname}", String.class, "");
		System.out.println(selectGetResponse.getBody());
		Assertions.assertEquals(HttpStatus.OK, selectGetResponse.getStatusCode());
		System.out.println("-----------------------------------------------------");
		System.out.println("Test Insert");
		TestRestTemplate insertTemplate = new TestRestTemplate();
	    HttpEntity<CoinDeskDataEntity> insertRequest = new HttpEntity<>(null);
	    insertTemplate.put(baseurl + "CoinDeskAPI/{coinname}&{coincname}&{rate}", insertRequest, "NTD", "新台幣", "10000.12345");
	    System.out.println("-----------------------------------------------------");
		System.out.println("Test Update");
		TestRestTemplate updateTemplate = new TestRestTemplate();
		HttpEntity<CoinDeskDataEntity> updateRequest = new HttpEntity<>(null);
		ResponseEntity<String> postResponse = updateTemplate.postForEntity(baseurl + "CoinDeskAPI/{coinname}&{coincname}&{rate}", updateRequest, String.class, "NTD", "新台幣", "20000.54321");
		System.out.println(postResponse.getBody());
		Assertions.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
		System.out.println("-----------------------------------------------------");
    	TestRestTemplate deleteTemplate = new TestRestTemplate();
		System.out.println("Test Delete");
		deleteTemplate.delete(baseurl + "CoinDeskAPI/{coinname}", "NTD");
		System.out.println("-----------------------------------------------------");
    	System.out.println("Test call");
    	TestRestTemplate callTemplate = new TestRestTemplate();
		ResponseEntity<String> callGetResponse = callTemplate.getForEntity(baseurl + "OldAPIData/", String.class);
		System.out.println(callGetResponse.getBody());
		Assertions.assertEquals(HttpStatus.OK, callGetResponse.getStatusCode());
		System.out.println("-----------------------------------------------------");
    	System.out.println("Test copy");
		TestRestTemplate copyTemplate = new TestRestTemplate();
		HttpEntity<CoinDeskDataEntity> Request = new HttpEntity<>(null);
		ResponseEntity<String> copyPostResponse = copyTemplate.postForEntity(baseurl + "OldAPIToNewAPI/", Request, String.class);
		System.out.println(copyPostResponse.getBody());
		Assertions.assertEquals(HttpStatus.OK, copyPostResponse.getStatusCode());
		System.out.println("=====================================================");
    }
}

