package com.project.site.base.ratelimit;

import com.project.site.base.model.TokenModel;
import com.project.site.base.ratelimit.TokenListService.TokenEntity;
import com.project.site.base.ratelimit.TokenListService.TokenListServiceImpleHashMap;
import com.project.site.base.ratelimit.TokenListService.TokenListService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RateLimiterManager {

	private final TokenListService<String,TokenEntity> tokenListService;

	public RateLimiterManager(TokenListServiceImpleHashMap tokenListService) {
		this.tokenListService = tokenListService;
	}

	public Bucket getUserServiceBucket(String userId , TokenModel tokenModel){
		Bucket bucket = getUserBucket(userId, tokenModel);
		if (bucket == null) {
			bucket = addUserBuckets(userId, tokenModel);
		}
		return bucket;
	}

	private Bucket addUserBuckets(String userId, TokenModel tokenModel ){
		TokenEntity tokenEntity = getServiceByName(tokenModel.getServiceName());
		Bucket bucket = createBucket(tokenEntity);
		UserBucketsCache.add(userId,tokenModel, bucket);
		return bucket;
	}
	private TokenEntity getServiceByName(String serviceName) {
		TokenEntity tokenEntity = tokenListService.getToken(serviceName);
		return tokenEntity;
	}
	private Bucket getUserBucket(String userId,TokenModel tokenModel){
		return UserBucketsCache.getBucket(userId,tokenModel);
	}

	private Bucket createBucket(TokenEntity danaService) {
		Integer capacity = danaService.getCallServiceLimit();
		int bucketDuration = danaService.getConsumeBucketDuration();
		TimeUnit timeUnit = TimeUnit.getType(danaService.getConsumeBucketDuration());
		Duration duration = getDuration(timeUnit,bucketDuration);
		Bandwidth limit = Bandwidth.classic(capacity, Refill.greedy(capacity, duration));
		Bucket bucket = Bucket.builder()
				.addLimit(limit)
				.build();
		return bucket;
	}
	private Duration getDuration(TimeUnit timeUnit, int bucketDuration){
		if(timeUnit.getCode() == TimeUnit.DAY.getCode())
			return Duration.ofDays(bucketDuration);
		else if(timeUnit.getCode() == TimeUnit.HOURS.getCode())
			return Duration.ofHours(bucketDuration);
		else if(timeUnit.getCode() == TimeUnit.MINUTES.getCode())
			return Duration.ofMinutes(bucketDuration);

		return Duration.ofDays(bucketDuration);
	}

}
