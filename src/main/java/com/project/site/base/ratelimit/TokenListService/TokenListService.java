package com.project.site.base.ratelimit.TokenListService;

public interface TokenListService<KEY,TOKENMODEL> {
    TOKENMODEL getToken(KEY key);
}
