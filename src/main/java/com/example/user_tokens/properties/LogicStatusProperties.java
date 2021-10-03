package com.example.user_tokens.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Map;

@Getter
@RequiredArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "logic-status")
public class LogicStatusProperties {

    private final Map<String, String> logicStatuses;
    private final String defaultMessage;
}
