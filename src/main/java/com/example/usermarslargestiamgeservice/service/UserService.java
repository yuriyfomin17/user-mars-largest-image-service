package com.example.usermarslargestiamgeservice.service;

import com.example.usermarslargestiamgeservice.dto.CommandDTO;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    public boolean isIncorrectCommand(CommandDTO commandDTO) {
        return Objects.isNull(commandDTO) || commandDTO.sol() == 0 || Objects.isNull(commandDTO.camera());
    }
}
