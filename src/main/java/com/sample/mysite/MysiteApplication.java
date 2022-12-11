package com.sample.mysite;

import com.sample.mysite.config.DataInsertion.RunData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//@ComponentScan("com.sample.mysite")
@SpringBootApplication
@ComponentScan("com")
@EntityScan("com")
@EnableJpaRepositories("com")
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class MysiteApplication/* implements CommandLineRunner */{

    public static void main(String[] args) {
        SpringApplication.run(MysiteApplication.class, args);
    }

    /*@Autowired
    private UserRepository userRepository;

    @Override
    public void run(String...args) throws Exception {
        this.userRepository.save(new User("Ramesh", "Fadatare", "ramesh@gmail.com"));
        this.userRepository.save(new User("Tom", "Cruise", "tom@gmail.com"));
        this.userRepository.save(new User("Tony", "Stark", "tony@gmail.com"));
    }*/

    @Bean
    public CommandLineRunner loadData(RunData runData){
        return (args) -> {
            runData.loadData();

        };
    }

    /*@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }*/
    /*@Bean*/
    /*public CommandLineRunner loadData(UserRepository userRepository, ReservationRepository reservationRepository){
        return (args) ->{
            User user = User.builder().name("Foad").build();
            userRepository.save(user);

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Reservation reservation = Reservation.builder()
                    .reservationDate(localDate)
                    .startTime(LocalTime.of(12, 00))
                    .endTime(LocalTime.of(13, 00))
                    .user(user)
                    .amenityType(Types.AmenityType.POOL)
                    .build();

            reservationRepository.save(reservation);
        };
    }*/
}
