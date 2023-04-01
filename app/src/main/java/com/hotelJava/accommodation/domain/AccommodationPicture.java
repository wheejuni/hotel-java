package com.hotelJava.accommodation.domain;

import com.hotelJava.common.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AccommodationPicture extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String originFileName;

    private String saveFileName;

    private String extension;

    private String fullPath;

    private long fileSize;

    @OneToOne(mappedBy = "accommodationPicture")
    private Accommodation accommodation;
}
