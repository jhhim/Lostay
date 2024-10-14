package com.lostay.backend.room.entity;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.lostay.backend.hotel.entity.Hotel;
import com.lostay.backend.payment.entity.Payment;
import com.lostay.backend.reservation.entity.Reservation;
import com.lostay.backend.review.entity.Review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roomNo;   					// 객실넘버	
	
	@JoinColumn(name = "hotelNo", nullable = false)
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Hotel hotel;					// 호텔넘버 외래키
	private String roomName;					// 객실명
	private int roomPeopleMax;				// 객실인원(최대수) - 검색 시
	private String roomPeopleInfo;			// 객실인원(기준) - 문자열로 기준인원/최대인원 보여줄 시
	private int roomCount;						// 객실 수
	private String roomThumbnail;				// 객실썸네일
	@Lob
	private String roomImg;					// 객실이미지
	private int roomPrice;						// 객실가격
	private int roomDiscount;					// 객실할인율
	private String roomAmenities;				// 객실편의시설
	private String roomIntroduction;			// 객실소개(정보)
	private Time roomCheckinTime;	// 객실체크인시간
	private Time roomCheckoutTime;	// 객실체크아웃시간
	
	@OneToOne(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // room 엔티티와의 관계 설정
	@ToString.Exclude  // 순환 참조 방지
	private Payment payments; // 예약 목록
	
	@OneToMany(mappedBy = "room",cascade = CascadeType.ALL, fetch = FetchType.LAZY ) // room 엔티티와의 관계 설정
	@ToString.Exclude  // 순환 참조 방지
	private Set<Review> reviews; // 리뷰 목록
}
