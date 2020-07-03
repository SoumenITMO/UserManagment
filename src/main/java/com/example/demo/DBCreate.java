package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;

@Component
public class DBCreate implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        File myObj = new File("seedDB");
        try {
            if(myObj.createNewFile()) {
                seedDB();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void seedDB() {

        jdbcTemplate.execute("USE tjtest");
        String CREAT_USER_SQL = "CREATE TABLE `user` ( `user_id` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "`user_name` VARCHAR(50) NOT NULL, `user_password` VARCHAR(50) NOT NULL ,`" +
                "firstname` VARCHAR(100) NOT NULL, `lastname` VARCHAR(100) NOT NULL, " +
                "`email` VARCHAR(100) NOT NULL, `address` VARCHAR(100) NOT NULL," +
                "`phone` VARCHAR(100) NOT NULL, `user_type` int(4) NOT NULL)";

        String CREAT_MODULE_SQL = "CREATE TABLE `modules` ( `module_id` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "`module_name` VARCHAR(50) NOT NULL)";

        String CREAT_MODULE_MAPPER_SQL = "CREATE TABLE `modules_mapper` ( `mapper_id` int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "`module_id` int(4) NOT NULL, `user_id` int(4) NOT NULL)";

        jdbcTemplate.execute(CREAT_USER_SQL);
        jdbcTemplate.execute(CREAT_MODULE_SQL);
        jdbcTemplate.execute(CREAT_MODULE_MAPPER_SQL);

        jdbcTemplate.execute("insert into user values(0,'admin', '@dmin124', 'Admin', 'Admin', 'admin@gmail.com', 'GOA', '+918445884624',0)");
        jdbcTemplate.execute("insert into user values(0,'soumen23', 'soumen98', 'Soumen', 'Banerjee', 'soumen@gmail.com', 'GOA', '+918765084624',1)");
        jdbcTemplate.execute("insert into user values(0,'vicky8', 'viky123', 'Vicky', 'Vicky', 'vikn@hotmail.com', 'Delhi', '+911761080624',1)");
        jdbcTemplate.execute("insert into user values(0,'alex58', 'maria51', 'Alexy', 'Kochitkov', 'sash@inbox.ru', 'SPB', '+78700194356',1)");
        jdbcTemplate.execute("insert into user values(0,'masha41', 'maria8', 'Maria', 'Shemashko', 'nika85@inbox.ru', 'MOSK', '+77755128097',1)");

        jdbcTemplate.execute("insert into modules values(0,'Module 1')");
        jdbcTemplate.execute("insert into modules values(0,'Module 2')");
        jdbcTemplate.execute("insert into modules values(0,'Module 3')");
        jdbcTemplate.execute("insert into modules values(0,'Module 4')");
        jdbcTemplate.execute("insert into modules values(0,'Module 5')");
        jdbcTemplate.execute("insert into modules values(0,'Module 6')");
        jdbcTemplate.execute("insert into modules values(0,'Module 7')");
        jdbcTemplate.execute("insert into modules values(0,'Module 8')");
        jdbcTemplate.execute("insert into modules values(0,'Module 9')");
        jdbcTemplate.execute("insert into modules values(0,'Module 10')");

        jdbcTemplate.execute("insert into modules_mapper values(0, 1, 2)");
        jdbcTemplate.execute("insert into modules_mapper values(0, 2, 2)");
        jdbcTemplate.execute("insert into modules_mapper values(0, 3, 2)");
        jdbcTemplate.execute("insert into modules_mapper values(0, 4, 2)");
        jdbcTemplate.execute("insert into modules_mapper values(0, 5, 2)");

        jdbcTemplate.execute("insert into modules_mapper values(0, 3, 3)");
        jdbcTemplate.execute("insert into modules_mapper values(0, 10, 3)");
        jdbcTemplate.execute("insert into modules_mapper values(0, 9, 3)");
        jdbcTemplate.execute("insert into modules_mapper values(0, 2, 3)");
        jdbcTemplate.execute("insert into modules_mapper values(0, 1, 3)");
        jdbcTemplate.execute("insert into modules_mapper values(0, 1, 5)");
        jdbcTemplate.execute("insert into modules_mapper values(0, 9, 4)");
    }
}
