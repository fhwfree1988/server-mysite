package com.project.site.Modules.Product.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

@Entity
//@Document
/*@Getter
@Setter*/
@Data

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private String date;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false,unique = true,nullable = false)
    /*@Column(unique = true,nullable = false)*/
    private Long id;

    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    @SequenceGenerator(name = "productNo",sequenceName = "productNo",initialValue = 3000)
    /*@GenericGenerator(name = "productNo2",strategy = "increment")*/
    @GeneratedValue(strategy =  GenerationType.SEQUENCE ,generator = "productNo")
    @Column(unique = true)
    private Long productNo;

    @Column()
    private String productName;

    @Column()
    private boolean isActive;

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    private Set<ProductCost> productCostSet;

    /*@Column()
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ONE")
    @SequenceGenerator(name = "ONE", sequenceName = "ONE", allocationSize =1)
    private Long seq;*/

    /*@Generated(GenerationTime.INSERT)*/
    /*@Column(name = "column_name", insertable = false)*/
    /*@Column(columnDefinition = "integer auto_increment")
    private Integer orderID;*/

    /*@GeneratorType(type = MyGenerator.class, when = GenerationTime.INSERT)
    @Column(name = "dat_auto")
    private Long auto;*/

    public Date getSubmissionDateConverted(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.parse(this.date);
    }

    public void setSubmissionDate(Date date, String timezone) {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        this.date = dateFormat.format(date);
    }

}

//class MyGenerator implements ValueGenerator<Long>
//{
//    public String generateValue(Session session, Object owner)
//    {
//        /*return (
//                (BigInteger) session
//                        .createNativeQuery("select nextval('TST_DATA_SEQ')")
//                        .getSingleResult()
//
//        ).longValue();*/
//        /*LocalDate localDate = LocalDate.now();
//        return localDate.getYear() + localDate.getMonth() + localDate.getDayOfMonth();*/
//        return "";
//    }
//}