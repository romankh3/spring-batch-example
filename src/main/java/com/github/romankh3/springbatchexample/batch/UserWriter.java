package com.github.romankh3.springbatchexample.batch;

import com.github.romankh3.springbatchexample.model.User;
import com.github.romankh3.springbatchexample.repository.UserRepository;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserWriter implements ItemWriter<User> {

    private static final Logger LOGGER = Logger.getLogger(UserWriter.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Override
    public void write(List<? extends User> users) throws Exception {
        LOGGER.info("Data saved for users: " + users);
        users.forEach(userRepository::save);
    }
}
