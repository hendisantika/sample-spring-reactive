package sample.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.model.Message;
import sample.model.MessageAcknowledgement;
import sample.service.CompletableFutureService;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/controller")
public class CompletableFutureController {

    private final CompletableFutureService aService;

    @Autowired
    public CompletableFutureController(CompletableFutureService aService) {
        this.aService = aService;
    }

    @PostMapping("/handleMessageFuture")
    public CompletableFuture<MessageAcknowledgement> handleMessage(@RequestBody Message message) {
        return this.aService.handleMessage(message);
    }

}
