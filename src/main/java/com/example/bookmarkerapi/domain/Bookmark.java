package com.example.bookmarkerapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.helpers.BasicMarker;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Table(name = "bookmarks")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bookmark {

  @Id
  @SequenceGenerator(name = "bm_id_seq_gen", sequenceName = "bm_id_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bm_id_seq_gen")
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String url;

  private Instant createdAt;

  public Bookmark(String title, String url) {
    this.title = title;
    this.url = url;
  }
}
