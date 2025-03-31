package com.nhnacademy.gateway.filter;

import com.nhnacademy.gateway.repository.TokenRepository;
import com.nhnacademy.gateway.util.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter implements WebFilter {

    private  final JwtProvider jwtProvider;
    private final TokenRepository tokenRepository;



    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String path = exchange.getRequest().getPath().toString();


        if(path.startsWith("/auth/login")|| path.startsWith("/auth/signup")){
            return chain.filter(exchange);
        }

//        String token =

        return null;
    }


}
