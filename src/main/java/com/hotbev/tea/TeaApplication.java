package com.hotbev.tea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@EnableJpaRepositories
public class TeaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeaApplication.class, args);
    }

}

/*
VEXING:

The line "(exclude = HiberanteJpaAutoConfiguration.class)" must be sustained ,else the runtime error (500)
and thus exception will follow, when visiting /boot/getAllTeas:
Servlet.service() for servlet [dispatcherServlet] in context with path [/boot] threw exception [Request processing failed; nested exception is java.lang.ClassCastException: org.springframework.orm.jpa.EntityManagerHolder
cannot be cast to org.springframework.orm.hibernate5.SessionHolder] with root cause ...

 */