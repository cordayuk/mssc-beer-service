package com.example.msscbeerservice.web.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.msscbeerservice.web.model.BeerDto;
import com.example.msscbeerservice.web.model.BeerStyleEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  void getBeerById() throws Exception {
    mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void saveNewBeer() throws Exception {
    BeerDto beerDto = getValidBeerDto();
    String beerDtoJson = objectMapper.writeValueAsString(beerDto);

    mockMvc.perform(post("/api/v1/beer/").contentType(MediaType.APPLICATION_JSON)
    .content(beerDtoJson)).andExpect(status().isCreated());
  }

  @Test
  void updateNewBeer() throws Exception {
    BeerDto beerDto = getValidBeerDto();
    String beerDtoJson = objectMapper.writeValueAsString(beerDto);

    mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID()).contentType(MediaType.APPLICATION_JSON).content(beerDtoJson))
        .andExpect(status().isNoContent());

  }

  private BeerDto getValidBeerDto()
  {
    return BeerDto.builder().beerName("Beer").beerStyle(BeerStyleEnum.IPA).price(new BigDecimal(
        "2.99")).upc(99999999L).quantityInStock(10).build();
  }
}