/**
 * 
 */
package com.cgovern.governor.models;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author vamsiravi
 *
 */
public interface SessionRepository extends MongoRepository<Session, String> {

}
