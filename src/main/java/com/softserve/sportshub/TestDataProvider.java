package com.softserve.sportshub;

import com.softserve.sportshub.role.Role;
import com.softserve.sportshub.role.RoleDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class TestDataProvider {

    private final RoleDao roleDao;

    @Autowired
    private TestDataProvider testDataProvider;

    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        event.getApplicationContext().getBean(TestDataProvider.class).addRoles(); // tak też można zamiast self-inject
        testDataProvider.addRoles();
    }

    @Transactional
    public void addRoles() {
        Role role = new Role("USER");
        Role adminRole = new Role("ADMIN");
        roleDao.save(role);
        roleDao.save(adminRole);
    }
}