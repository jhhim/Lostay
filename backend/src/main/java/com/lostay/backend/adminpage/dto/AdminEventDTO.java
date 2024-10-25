package com.lostay.backend.adminpage.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.lostay.backend.event.entity.Event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminEventDTO {

	private Long eventNo;
	private String eventTitle;
	private LocalDateTime eventCreateAt;
	private LocalDateTime eventEndAt;
	private MultipartFile eventThumbnail;
	private MultipartFile eventImg;
	
}