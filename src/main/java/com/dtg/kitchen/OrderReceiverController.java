package com.dtg.kitchen;

import com.dtg.kitchen.messaging.rabbit.RabbitOrderReceiver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderReceiverController {

    private final RabbitOrderReceiver rabbitOrderReceiver;

    @GetMapping("/receive")
    public String receiveOrder(Model model){
        //Use RabbitMq
        TacoOrder anotherOrder = rabbitOrderReceiver.receiveOrder();
        if(anotherOrder != null){
            model.addAttribute("order", anotherOrder);
            return "receiveOrder";
        }
        return "noOrder";
    }
}
