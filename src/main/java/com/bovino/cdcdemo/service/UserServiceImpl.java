package com.bovino.cdcdemo.service;

import com.bovino.cdcdemo.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static List<User> list = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        if(list.isEmpty()) {
            User user = new User();
            user.setId(1);
            user.setLogin("login 1");
            user.setName("name 1");
            list.add(user);

            User user2 = new User();
            user2.setId(2);
            user2.setLogin("login 2");
            user2.setName("name 2");
            list.add(user2);
        }
        return list;
    }

    @Override
    public User getUserById(Integer id) {
        Predicate<User> byIdPredicate = person -> person.getId().intValue() == id.intValue();
        List<User> resultList = list.stream().filter(byIdPredicate).collect(Collectors.toList());
        if(!resultList.isEmpty()){
          return resultList.get(0);
        } else {
          // there is no user with such id. raise an exception?
          return null;
        }
    }

    @Override
    public User saveNewUser(User user) {
        // add in the list and get max id+1
        int lastElemIndex = getAllUsers().size() - 1;
        User lastUserInTheList = getAllUsers().get(lastElemIndex);
        Integer lastUserId = lastUserInTheList.getId();
        user.setId(lastUserId+1);
        list.add(user);
        return user;
    }

    /* @Override
    public ResponseEntity<Void> deleteUser(Integer[] ids) {
        for(Integer id: ids){
            User userFound = getUserById(id);
            List<User> resultList = getAllUsers();
            resultList.remove(userFound);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    } */

    @Override
    public ResponseEntity<Void> deleteUser(Integer id) {
        User userFound = getUserById(id);
        List<User> resultList = getAllUsers();
        resultList.remove(userFound);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
