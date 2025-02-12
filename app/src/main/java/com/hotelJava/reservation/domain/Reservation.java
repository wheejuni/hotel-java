package com.hotelJava.reservation.domain;

import com.hotelJava.common.embeddable.CheckDate;
import com.hotelJava.common.util.BaseTimeEntity;
import com.hotelJava.member.domain.Member;
import com.hotelJava.payment.domain.PaymentType;
import com.hotelJava.room.domain.Room;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Reservation extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String reservationNo;

  private String accommodationName;

  private String roomName;

  @Embedded private CheckDate checkDate;

  private LocalDateTime paymentDateTime;

  private int numberOfGuests;

  @Enumerated(EnumType.STRING)
  private PaymentType paymentType;

  private String phoneNumber;

  @Enumerated(EnumType.STRING)
  private ReservationStatus status;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "room_id")
  private Room room;
}
