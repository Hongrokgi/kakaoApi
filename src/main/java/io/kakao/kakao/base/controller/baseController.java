package io.kakao.kakao.base.controller;

import io.kakao.kakao.base.service.AuthService;
import io.kakao.kakao.base.service.CustomMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class baseController {
    @Autowired
    AuthService authService;

    @Autowired
    CustomMessageService customMessageService;

    @GetMapping("/")
    public String serviceStart(String code) {
        if(authService.getKakaoAuthToken(code)) {
            customMessageService.sendMyMessage();
            return "메시지 전송 성공";
        }else {
            return "토큰 발급 실패";
        }
    }
}
