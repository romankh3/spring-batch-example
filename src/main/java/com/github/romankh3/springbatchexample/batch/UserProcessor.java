package com.github.romankh3.springbatchexample.batch;

import com.github.romankh3.springbatchexample.model.User;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class UserProcessor implements ItemProcessor<User, User> {

    private static final Map<String, String> DEPT_NAMES = new HashMap<>();
    private static final Logger LOGGER = Logger.getLogger(UserProcessor.class.getName());

    public UserProcessor() {
        DEPT_NAMES.put("001", "Technologies");
        DEPT_NAMES.put("002", "Operations");
        DEPT_NAMES.put("003", "Accounts");
    }

    @Override
    public User process(User user) throws Exception {
        String deptCode = user.getDept();
        String dept = DEPT_NAMES.get(deptCode);
        user.setDept(dept);
        user.setTime(new Date());
        LOGGER.info(String.format("Converted from [%s] to [%s]", deptCode, dept));
        return user;
    }
}
