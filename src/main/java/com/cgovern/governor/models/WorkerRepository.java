/**
 * 
 */
package com.cgovern.governor.models;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author vamsiravi
 *
 */
public interface WorkerRepository  extends MongoRepository<Worker, String>{

}
