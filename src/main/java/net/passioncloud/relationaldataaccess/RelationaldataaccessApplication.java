package net.passioncloud.relationaldataaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

@SpringBootApplication
public class RelationaldataaccessApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(RelationaldataaccessApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RelationaldataaccessApplication.class, args);
	}

    @Autowired
    JdbcTemplate jdbcTemplate;


     @Override
    public void run(String... strings) throws Exception {
        log.info("Creating tables");

       // jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers(id VARCHAR(20), first_name VARCHAR(255), last_name VARCHAR(255))");

        // first
         String[] cust0 = { "CUST0000", "John", "Kiberu"};
        jdbcTemplate.update("INSERT INTO customers(id, first_name, last_name) VALUES(?,?,?)", cust0);

        // second
         String[] cust1 = { "CUST0001", "Simon", "Peter"};
         jdbcTemplate.update("INSERT INTO customers(id, first_name, last_name) VALUES(?,?,?)", cust1);

         String[] cust2 = { "CUST0002", "Marko", "Lwanga"};
         jdbcTemplate.update("INSERT INTO customers(id, first_name, last_name) VALUES(?,?,?)", cust2);

         jdbcTemplate.query("SELECT id, first_name, last_name FROM customers", (rs) -> {
             var c0 = new Customer(rs.getString("id"), rs.getString("first_name"), rs.getString("last_name"));
             System.out.println("Customer is " + c0);
         });
    }

}
