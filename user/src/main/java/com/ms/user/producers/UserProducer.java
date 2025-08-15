package com.ms.user.producers;

import com.ms.user.dtos.EmailRecordDto;
import com.ms.user.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel userModel){
        UUID userId = userModel.getId();
        String emailTo = userModel.getEmail();
        String subject = "Cadastro realizado com sucesso!";
        String text = userModel.getName() + ", seja bem vindo(a)!";

        EmailRecordDto emailRecordDto = new EmailRecordDto(
            userId, emailTo, subject, text
        );

        rabbitTemplate.convertAndSend("", routingKey, emailRecordDto);
    }
}
