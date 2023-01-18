package com.project.site.base.ratelimit.TokenListService;

import com.project.site.base.ratelimit.TimeUnit;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class  TokenListServiceImpleHashMap implements TokenListService<String,TokenEntity> {

    private static ConcurrentHashMap<String ,TokenEntity> tokenList = new ConcurrentHashMap<String ,TokenEntity>() {
        {
            this.put("a1", new TokenEntity(1,"/token","token@token1",5, TimeUnit.MINUTES.getCode(),2,true));
            this.put("c2",  new TokenEntity(1,"/login","login@token2",5, TimeUnit.MINUTES.getCode(),2,true));
            this.put("b3",  new TokenEntity(1,"/product/{id}","product-id@token3",5, TimeUnit.MINUTES.getCode(),2,true));
        }
    };

    public TokenEntity getToken(String key){
        return tokenList.get(key);
    }
}
