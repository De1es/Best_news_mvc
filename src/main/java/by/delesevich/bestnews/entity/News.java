package by.delesevich.bestnews.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="news")
public class News {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column (name = "n_id")
  private Integer id;

  @Column (name = "n_title")
  @NotNull(message = "Title must be not null")
  @Size(min=10, max = 100, message = "Title must contain from 10 to 100 chars")
  private String title;

  @Column (name = "n_brief")
  @NotNull(message = "Brief must be not null")
  @Size(min=50, max = 500, message = "Brief must contain from 50 to 500 chars")
  private String brief;

  @Column (name = "n_content")
  @NotNull(message = "Content must be not null")
  @Size(min=50, max = 4000, message = "Content must contain from 50 to 4000 chars")
  private String content;

  @Column (name = "n_date")
  private Timestamp date;
}
