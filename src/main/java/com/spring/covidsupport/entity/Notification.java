package com.spring.covidsupport.entity;

import javafx.scene.media.SubtitleTrack;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "notification")
@NoArgsConstructor
@AllArgsConstructor
public class Notification extends Base{
    private Long orderId;
    private Integer readNoti;
    private String ownerName;
    private String code;
    private int cartStatus;


    private static Notification instance;

    public static Notification newInstance() {
        if(instance != null) {
            return instance;
        }
        return new Notification();
    }
}
