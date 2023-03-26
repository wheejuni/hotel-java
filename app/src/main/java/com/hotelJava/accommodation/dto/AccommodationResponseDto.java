package com.hotelJava.accommodation.dto;

import com.hotelJava.accommodation.domain.Accommodation;
import com.hotelJava.accommodation.domain.AccommodationPicture;
import com.hotelJava.accommodation.domain.Address;
import lombok.*;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class AccommodationResponseDto {

  private String name;

  private Address address;

  private String type;

  private int price;

  private double rating;

  private String phoneNumber;

  private AccommodationPicture picture;

  private String description;

  // TODO: [Entity => dto] ModelMapper와 생성자 장단점
  public static AccommodationResponseDto of(Accommodation accommodation) {
    return AccommodationResponseDto.builder()
            .name(accommodation.getName())
            .address(accommodation.getAddress())
            .type(accommodation.getType().getValue())
            .price(0) // TODO: 숙소의 가장 싼 룸의 가격을 가져와야함
            .rating(accommodation.getRating())
            .phoneNumber(accommodation.getPhoneNumber())
            .picture(accommodation.getAccommodationPicture())
            .description(accommodation.getDescription())
            .build();
  }
}
