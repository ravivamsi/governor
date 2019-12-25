/**
 * 
 */
package com.servec.governor.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vamsiravi
 *
 */
@Repository
public interface StageRepository extends MongoRepository<Stage, String> {

}
