package com.example.msscbeerservice.bootstrap;


import com.example.msscbeerservice.domain.Beer;
import com.example.msscbeerservice.repositories.BeerRepository;
import com.example.msscbeerservice.web.model.BeerStyleEnum;
import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BeerLoader implements CommandLineRunner {

  private BeerRepository beerRepository;

  public BeerLoader(BeerRepository beerRepository) {
    this.beerRepository = beerRepository;
  }

  @Override
  public void run(String... args) {
    loadBeerObjects();
  }

  private void loadBeerObjects() {
    if( beerRepository.count() == 0)
    {
      beerRepository.save( Beer.builder()
          .beerName("Yeungling")
          .beerStyle(BeerStyleEnum.ALE.name())
          .quantityToBrew(50)
          .minOnHand(12)
          .upc(337010000001L)
          .price(new BigDecimal("12.95"))
          .build());

      beerRepository.save(Beer.builder()
          .id(UUID.randomUUID())
          .beerName("Galaxy Cat")
          .beerStyle(BeerStyleEnum.IPA.name())
          .upc(337010000002L)
          .price(new BigDecimal("5.00"))
          .build());
    }
  }
}
