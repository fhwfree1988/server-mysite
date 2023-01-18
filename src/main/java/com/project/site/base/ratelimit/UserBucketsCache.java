package com.project.site.base.ratelimit;

import com.project.site.base.model.TokenModel;
import io.github.bucket4j.Bucket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//singleton
public class UserBucketsCache {
	private static Map<String, ConcurrentHashMap<String, Bucket>> usersBuckets;

	static {
		usersBuckets = new ConcurrentHashMap<>();
	}

	public static Map<String, ConcurrentHashMap<String, Bucket>> getInstance(){
		/*if (usersBuckets == null)		{
			synchronized (RateLimitManager.class)
			{	if(usersBuckets==null)
				{
					usersBuckets = new HashMap<>();
				}
			}
		}*/
		return usersBuckets;

	}

	public static void put(String userId, TokenModel tokenModel, Bucket bucket){

		ConcurrentHashMap<String, Bucket> stringBucketEntry = new ConcurrentHashMap();
		stringBucketEntry.put(tokenModel.getServiceName(), bucket);

		getInstance().put(userId,stringBucketEntry );
	}
	public static void add(String userId, TokenModel tokenModel, Bucket bucket){
		ConcurrentHashMap<String, Bucket> stringBucketEntry = getInstance().get(userId);
		if (stringBucketEntry == null) {
			put(userId,tokenModel, bucket);
		} else if (stringBucketEntry.get(tokenModel.getServiceName()) == null){
			stringBucketEntry.put(tokenModel.getServiceName(), bucket);
			getInstance().put(userId,stringBucketEntry );
		}
	}

	public static Bucket getBucket(String userId, TokenModel tokenModel){
		ConcurrentHashMap<String, Bucket> stringBucketEntry = getInstance().get(userId);
		if(stringBucketEntry == null) {
			stringBucketEntry = new ConcurrentHashMap<String, Bucket>();
			getInstance().put(userId,stringBucketEntry );
		}

		return stringBucketEntry.get(tokenModel.getServiceName());
	}


}
