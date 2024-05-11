package com.crio.CoderHack.coderhack.Service;


import com.crio.CoderHack.coderhack.DTO.Badges;
import com.crio.CoderHack.coderhack.DTO.UserRequestDTO;
import com.crio.CoderHack.coderhack.DTO.UserResponseDTO;
import com.crio.CoderHack.coderhack.Model.User;
import com.crio.CoderHack.coderhack.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service

public class UserService {


    @Autowired
    private UserRepository repository;


    public User getUserById(BigInteger userId) {
        Optional<User> userOptional = repository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            repository.save(user);
            return user;
        } else {

            return null;
        }
    }

    public UserResponseDTO registerUser(UserRequestDTO userRequestDto) {

        Optional<User> userOP = repository.findById(userRequestDto.getUserID());
        if(userOP.isPresent()) return mapToResponse(userOP.get());

        User user = User.builder()
                .userID(userRequestDto.getUserID())
                .Score(0)
                .badges(Badges.NA)
                .Username(userRequestDto.getUsername())
                .build();

        repository.save(user);
        return mapToResponse(user);
    }
    private UserResponseDTO mapToResponse(User user){
        return UserResponseDTO.builder()
                .UserID(user.getUserID())
                        .Score(user.getScore())
                                .username(user.getUsername()).build();
    }
    public User updateScore(BigInteger userId, int score) {
        Optional<User> userOptional = repository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setScore(score);

            if( 1 <= score && score < 30 ) user.setBadges(Badges.Code_Ninja);
            if(  30 <= score  && score< 60 )user.setBadges(Badges.Code_Champ);
            if( 60 <= score  && score<= 100 )user.setBadges(Badges.Code_Master);
            repository.save(user);
            return user;
        } else {

            return null;
        }
    }

    public boolean deregisterUser(BigInteger userId) {
        Optional<User> userOptional = repository.findById(userId);
        if(userOptional.isPresent()) {
            repository.deleteById(userId);
            return true;
        }
        return false;
    }


    public List<User> getAllUsers() {
        List<User> users = repository.findAll(Sort.by(Sort.Direction.DESC, "Score"));

        return users;

    }
}


