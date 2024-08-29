package com.collectFingers.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="fingerprints")
public class FingerPrint {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO )
   @Column(name="finger_id")
   private Long fingerId;

   @Lob
   @Column(name = "iso_data", columnDefinition = "BLOB")
   private byte[] isoData;

    @Lob
    @Column(name = "raw_data", columnDefinition = "BLOB")
    private byte[] rawData;

    @Column(name = "height")
    private int  height;

    @Column(name = "width")
    private int  width;

}
