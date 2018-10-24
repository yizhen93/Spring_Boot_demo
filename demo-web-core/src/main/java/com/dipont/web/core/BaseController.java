package com.dipont.web.core;

import org.springframework.web.bind.annotation.RestController;

import com.dipont.common.exception.BadRequestException;
import com.dipont.common.exception.BaseException;
import com.dipont.common.exception.NotContentException;
import com.dipont.common.exception.NotFoundException;

@RestController
public class BaseController {
    //private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public NormalResultDTO handleException(Exception ex){
//        if (ex != null) {
//            logger.error(ex.getMessage(), ex);
//        }
        if (ex instanceof Exception) {
            if (ex instanceof BaseException) {
                if (ex instanceof NotContentException) {
                    return new NormalResultDTO(((BaseException) ex).getErrorCode(), ((BaseException) ex).getErrorMessage(), null);
                } else if (ex instanceof BadRequestException) {
                    return new NormalResultDTO(((BaseException) ex).getErrorCode(), ((BaseException) ex).getErrorMessage(), null);
                } else if (ex instanceof NotFoundException) {
                    return new NormalResultDTO(((BaseException) ex).getErrorCode(), ((BaseException) ex).getErrorMessage(), null);
                } 
            }
            return new NormalResultDTO("500", ex.getMessage(), null);
        }
        return new NormalResultDTO("500", ex.getMessage(), null);
    }
}
