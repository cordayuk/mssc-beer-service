package com.example.msscbeerservice.repositories;

import com.example.msscbeerservice.domain.Beer;
import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

}
