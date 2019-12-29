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
public interface UserRepository extends MongoRepository<User, String>{

}
