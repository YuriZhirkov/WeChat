package com.example.wechar;

import common.ApiResponse;
import common.SimpleApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/wechar/test/")
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);
    @RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse hello() {
            try {
                return new SimpleApiResponse(ApiResponse.CODE_SUCCESS, "", 12);
            } catch (Exception e) {
                logger.error("/wechar/test/hello error, message:{}", e.getMessage());
                return new ApiResponse(ApiResponse.CODE_OTHER, "");
            }
    }

}
