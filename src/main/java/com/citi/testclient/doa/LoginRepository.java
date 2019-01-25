package com.citi.testclient.doa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.citi.testclient.model.UserDetails;
import com.citi.testclient.request.LoginRequest;

@Repository
public class LoginRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<UserDetails> findByUserName(LoginRequest loginRequest) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(loginRequest.getUserName()))
			 .addCriteria(Criteria.where("password").is(loginRequest.getPassword()));
		return mongoTemplate.find(query, UserDetails.class);



	}

}
