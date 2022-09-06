package com.ll.exam.upload.app.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/join")
    public String createMemberForm() {
        return "/member/join";
    }

    @PostMapping("/join")
    @ResponseBody
    public String createMember() {

        return "가입 완료!";
    }
}
