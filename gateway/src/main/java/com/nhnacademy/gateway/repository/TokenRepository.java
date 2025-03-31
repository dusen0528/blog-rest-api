package com.nhnacademy.gateway.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class TokenRepository {

    private final RedisTemplate<String, String> redisTemplate;

    @Value("${jwt.secret}")
    private String secretKey;
    // 블랙리스트에 토큰 추가
    public void addToBlacklist(String token, long expiration){
        redisTemplate.opsForValue().set(token, "blacklisted", expiration, TimeUnit.MILLISECONDS);
    }

    // 블랙리스트 여부 확인
    public boolean isBlacklisted(String token){
        return Boolean.TRUE.equals(redisTemplate.hasKey(token));
    }



    // 리프레쉬 토큰 저장
    public void storeRefreshToken(String userId, String refreshToken){
        redisTemplate.opsForValue().set(userId, refreshToken, 7, TimeUnit.DAYS);
    }

    // 리프레쉬 토큰 조회
    public String getRefreshToken(String userId){
        return redisTemplate.opsForValue().get(userId);
    }

    public void deleteRefreshToken(String userId){

    }

}
