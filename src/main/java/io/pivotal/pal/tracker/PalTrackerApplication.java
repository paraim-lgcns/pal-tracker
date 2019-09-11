package io.pivotal.pal.tracker;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class PalTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }
//    @Bean
//    public TimeEntryRepository timeEntryRepository()
//    {
//        return new InMemoryTimeEntryRepository();
//    }

    @Bean
    public TimeEntryRepository timeEntryRepository(DataSource dataSource){
        // 아래와 같은 방식으로 datasource 삽입 시 pcf의 env에 선언된 database 에는 SPRING_DATASOURCE_URL 변수가 없어서 찾을 수가 없음
        //그래서 위와 같이 변수로 받아오도록 선언하면 스프링이 알아서 찾아서 온다고 함!!!! awesome~!!!!
        //MysqlDataSource dataSource = new MysqlDataSource();
        //dataSource.setUrl(System.getenv("SPRING_DATASOURCE_URL"));
        return new JdbcTimeEntryRepository(dataSource);
    }
}