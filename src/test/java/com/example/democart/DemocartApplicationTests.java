package com.example.democart;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest

public class DemocartApplicationTests{
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;
	ObjectMapper om = new ObjectMapper();
	Response response;

	@Before
	public void setUp(){
		mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void saveCart() throws Exception {
		Cart cart = new Cart();
		cart.setId(10);
		cart.setProducts("test product");
		cart.setProductCode("TP");
		cart.setCouponCode("15OFF");
		cart.setTotalprice(50);
		cart.setDiscountedprice(42);
		String jsonRequest = om.writeValueAsString(cart);
		MvcResult result = mockMvc.perform(post("/cart").content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Response response = om.readValue(resultContent, Response.class);
		Assert.assertTrue(response.isStatus() == Boolean.TRUE);
	}

}
