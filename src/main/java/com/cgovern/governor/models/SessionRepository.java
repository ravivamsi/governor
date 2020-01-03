/**
 * 
 */
package com.cgovern.governor.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * @author vamsiravi
 *
 */
public interface SessionRepository extends MongoRepository<Session, String> {

	@Query("{ 'username' : ?0 }")
	Session findSessionByUsername(String username);

}
