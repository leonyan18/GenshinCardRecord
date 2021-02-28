package com.yan.genshincard.entity;

import lombok.Data;

import java.util.List;

/**
 * @author yan
 */
@Data
public class Response {
    private String message;
    private Integer retcode;
    private Object data;
}
