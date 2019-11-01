package com.umitkirtil.demos.vaadinflow2neo4jspringsec;

import com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.entity.Ogrenci;
import com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.entity.Role;
import com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.entity.User;
import com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.repository.OgrenciRepository;
import com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.repository.RoleRepository;
import com.umitkirtil.demos.vaadinflow2neo4jspringsec.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@EnableJpaAuditing
public class Vaadinflow2neo4jspringsecApplication {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    OgrenciRepository ogrenciRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(Vaadinflow2neo4jspringsecApplication.class, args);
    }

    @PostConstruct
    public void init() {
        User userOgretmen = userRepository.findUserByEmail("umitkirtil@gmail.com");

        if (userOgretmen == null) {
            Role role = new Role();
            role.setRole("ogretmen");
            roleRepository.save(role);

            User user = new User();
            user.setEmail("umitkirtil@gmail.com");
            user.setPasswordHash(passwordEncoder.encode("111"));
            user.setFirstName("Umit");
            user.setLastName("KIRTIL");
            user.setGradeLevel(0);
            user.getRoles().add(role);
            user.setTc("34471386028");

            role.getUsers().add(user);
            userRepository.save(user);

            Role roleOgrenci = new Role();
            roleOgrenci.setRole("ogrenci");
            roleRepository.save(roleOgrenci);

            User userOgrenci1 = new User();
            userOgrenci1.setTc("34471386029");
            userOgrenci1.setEmail("ogrenci1@gmail.com");
            userOgrenci1.setPasswordHash(passwordEncoder.encode("111"));
            userOgrenci1.setFirstName("Öğrenci 1");
            userOgrenci1.setLastName("Öğrenci");
            userOgrenci1.setGradeLevel(1);
            userOgrenci1.setTel("533 133 62 15");
            userOgrenci1.getRoles().add(roleOgrenci);
            userRepository.save(userOgrenci1);

            Ogrenci ogrenci1 = new Ogrenci();
            ogrenci1.setUser(userOgrenci1);
            ogrenciRepository.save(ogrenci1);
            // burada bi ogrenci felan da oluşturda yeğenim sıkıntı çıkmasın.
        } else {
            System.out.println("Dummy DB Atlandı.");
        }
    }
}