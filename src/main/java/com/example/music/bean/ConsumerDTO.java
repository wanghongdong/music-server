package com.example.music.bean;

import com.example.music.domain.Consumer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class ConsumerDTO extends Consumer implements Serializable {

    private String birthStr;

}