package com.phoenix.qpproject.controller;

import com.phoenix.qpproject.dto.MemberDTO;
import com.phoenix.qpproject.mapper.MemberMapper;
import com.phoenix.qpproject.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/")
public class AuthenticationController {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    public MemberService memberService;

    @RequestMapping(method = RequestMethod.GET)
    public String login() {
        return "/pages/authentication/card/login";
    }

    @RequestMapping(value = "authentication/register", method = RequestMethod.GET)
    public String registerDefault() {
        return "/pages/authentication/card/register";
    }

    @RequestMapping(value = "authentication/forgotPassword", method = RequestMethod.GET)
    public String forgotPassword() {
        return "/pages/authentication/card/forgot-password";
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        return "/pages/quiz/quiz_form";
    }

    @GetMapping(value="/memberList")
    public List<MemberDTO> getMemberList(Model model) {
        List<MemberDTO> memberList = memberService.getMemberList();

        System.out.println("회원 목록을 요청합니다: "+memberList.toString());

        model.addAttribute("title", "회원목록조회");
        model.addAttribute("memberList", memberList);

        return memberList;
    }
}