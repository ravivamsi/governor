/**
 * 
 */
package com.cgovern.governor.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vamsiravi
 *
 */
@Repository
public interface PipelineRepository extends MongoRepository<Pipeline, String> {

}
