package com.hannilsolutions.msm.web.rest;

import com.hannilsolutions.msm.service.DTO.MsmDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/microservice")
public class SendMailController {

    @PostMapping("/send_msm")
    public ResponseEntity<?> sendMsm(@RequestBody MsmDTO msm) {
        Map<String, Object> response = new HashMap<>();

        try {
            List<MsmDTO> result = new ArrayList<>();

            result.add(msm);

            response.put("response", result);

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("response", e.getMessage());

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
