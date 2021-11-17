package com.feng.house.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Data
public class RecommendRes {
private int id;
private String addressDetail;
private String homeowners;

@JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
private LocalDateTime updateTime;
}
