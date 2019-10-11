package com.shop.olx_pets.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Response {

    @Id
    @GeneratedValue
    private Long id;

    // The one who leaves the review
    @ManyToOne(fetch = FetchType.LAZY,
               cascade = CascadeType.REFRESH)
    @JoinColumn(name = "reviewer_id",
                nullable = false,
                referencedColumnName = "id")
    private User reviewer;

    // The one about whom the review was written
    @ManyToOne(fetch = FetchType.LAZY,
               cascade = CascadeType.REFRESH)
    @JoinColumn(name = "author_id",
                nullable = false,
                referencedColumnName = "id")
    private User author;

    private String response;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime posted;
}
