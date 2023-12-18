package com.example.usermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UploadFileDto {

    private String fileName;
    private String fileType;
    private long fileSize;

}
