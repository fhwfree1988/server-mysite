package com.project.site.base.ratelimit.TokenListService;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.boot.model.relational.Loggable;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Entity
//@Table(name = "TOKENENTITY")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")

public class TokenEntity {

    //@Id
    //@GeneratedValue
    //@Column(name = "PLT_DANA_SERVICES_ID")
    private  long id;

    //@Column(name = "SERVICE_NAME")
    private String serviceName;

    //@Column(name = "TOKEN")
    private String token;

    //@Column(name = "CALL_SERVICE_LIMIT")
    private Integer callServiceLimit;

    //@Column(name = "CONSUME_BUCKET_TIME_UNIT")
    private Integer consumeBucketTimeUnit;

    //@Column(name = "CONSUME_BUCKET_DURATION")
    private Integer consumeBucketDuration;

    //@Getter(onMethod_ = { @Column(name = "LOGICALLY_DELETED") })
    private Boolean isActive;

}