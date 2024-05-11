package com.crio.CoderHack.coderhack.Repository;

import com.crio.CoderHack.coderhack.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;


@org.springframework.stereotype.Repository
public interface UserRepository extends MongoRepository<User, BigInteger> {
    // Additional custom query methods can be defined here



}