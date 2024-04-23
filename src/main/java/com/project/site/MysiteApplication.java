package com.project.site;

import com.project.site.Modules.CompositRelation.modelTable.ModelTableEntity;
import com.project.site.Modules.CompositRelation.mainTable.CompositionID;
import com.project.site.Modules.CompositRelation.mainTable.MainTableEntity;
import com.project.site.Modules.CompositRelation.mainTable.services.MainTableService;
import com.project.site.Modules.CompositRelation.modelTable.services.ModelTableService;
import com.project.site.Modules.CompositRelation.secTable.SecTableEntity;
import com.project.site.Modules.CompositRelation.secTable.services.SecTableService;
import com.project.site.Modules.Product.model.entity.Product;
import com.project.site.config.DataInsertion.RunData;
//import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//import javax.persistence.EntityManager;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

//@SpringBootApplication
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//@ComponentScan("com.sample.mysite")
@SpringBootApplication
@ComponentScan("com")
@EntityScan("com")
//@EnableMongoRepositories("com")
@EnableJpaRepositories("com")
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class MysiteApplication extends SpringBootServletInitializer/*implements CommandLineRunner*/ {

   /* @Autowired
    MainTableService mainTableService;

    @Autowired
    ModelTableService modelTableService;

    @Autowired
    SecTableService secTableService;*/

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

            /*ModelTableEntity modelTable = new ModelTableEntity();
            modelTable.setId(1000L);
            modelTable.setName("model table");
            modelTable = modelTableService.saveModelTable(modelTable);

            CompositionID mainID = new CompositionID();
            mainID.setId1(1L);
            mainID.setModelTable(modelTable);

            MainTableEntity mainTable = new MainTableEntity();
            mainTable.setId(mainID);
            mainTable.setName("main table");
            mainTable = mainTableService.saveMainTable(mainTable);
            mainTableService.crCount();
            mainTableService.crJoin();*/
            /*
            SecTableEntity secTableEntity = new SecTableEntity();
            secTableEntity.setMainTable(mainTable);
            secTableEntity = secTableService.saveSecTable(secTableEntity);

            secTableEntity.getMainTable();*/
        };
    }

   /* @Override
    public void run(String... args) throws Exception {
        Session session = entityManager.unwrap(Session.class);
        session.isConnected();
        Transaction trx = session.beginTransaction();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MainTableEntity> criteriaQuery = criteriaBuilder.createQuery(MainTableEntity.class);
        Criteria criteria = session.createCriteria(MainTableEntity.class);

        criteria = criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.groupProperty("id"))
                        .add(Projections.rowCount()));

        List result = criteria.list();
        trx.commit();
        System.out.println(result.get(0));
    }*/

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

    //added for war
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MysiteApplication.class);
    }
}

