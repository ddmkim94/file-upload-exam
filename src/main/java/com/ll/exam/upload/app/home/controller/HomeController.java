package com.ll.exam.upload.app.home.controller;


import com.ll.exam.upload.app.member.entity.Member;
import com.ll.exam.upload.app.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;

    @RequestMapping("/")
    public String main(Principal principal, Model model) {
        Member loginedMember = null;
        String profile = "";

        if(principal != null && principal.getName() != null) {
            loginedMember = memberService.getMemberByUsername(principal.getName());
        }

        if(loginedMember != null) {
            profile = loginedMember.getProfileImgUrl();
        }

        model.addAttribute("loginedMember", loginedMember);
        model.addAttribute("profile", profile);

        return "home/main";
    }

    @RequestMapping("/test/upload")
    public String uploadForm() {
        return "home/test/upload";
    }
}
