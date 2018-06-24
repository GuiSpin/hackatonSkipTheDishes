package com.vanhack.api.skip.hackatonskipthedishesmain.repository;

import com.vanhack.api.skip.hackatonskipthedishesmain.domain.NearbySearchResponse;
import org.springframework.data.repository.CrudRepository;

public interface NearbySearchRepository extends CrudRepository<NearbySearchResponse, Long> {
}
