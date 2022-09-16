package com.ll.exam.upload.app.home.controller;


import com.ll.exam.upload.app.member.entity.Member;
import com.ll.exam.upload.app.member.service.MemberService;
import com.ll.exam.upload.app.security.dto.MemberContext;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;

    @RequestMapping("/")
    public String main() {
        return "home/main";
    }

    @GetMapping("/about")
    public String showAbout() {
        return "home/about";
    }


    // 로그인한 상태에서만 접근 가능!!
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/currentUserOrigin")
    @ResponseBody
    public Principal currentUserOrigin(Principal principal) {
        return principal;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/currentUser")
    @ResponseBody
    public MemberContext currentUser(@AuthenticationPrincipal MemberContext memberContext) {
        return memberContext;
    }
}
