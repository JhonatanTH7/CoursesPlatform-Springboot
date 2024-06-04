package com.Platform.Courses.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Platform.Courses.api.dto.request.MessageRequest;
import com.Platform.Courses.api.dto.response.message.MessageResponse;
import com.Platform.Courses.infrastructure.abstract_services.IMessageService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/message")
@AllArgsConstructor
public class MessageController {

    @Autowired
    private final IMessageService iMessageService;

    @PostMapping(path = "/create")
    public ResponseEntity<MessageResponse> create(
            @Validated @RequestBody MessageRequest request) {
        return ResponseEntity.ok(this.iMessageService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<MessageResponse>> getAllMessagesBetweenTwoUsers(
            @RequestParam Long userId1,
            @RequestParam Long userId2) {
        return ResponseEntity.ok(this.iMessageService.findMessagesBetweenTwoUsers(userId1, userId2));
    }
}
