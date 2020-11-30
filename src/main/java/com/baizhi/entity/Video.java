package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
@Table(name = "yx_video")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video implements Serializable {
    @Id
    private String id;

    private String title;

    private String biref;
    @Column(name = "cover_path")
    private String coverPath;
    @Column(name = "upload_time")
    private Date uploadTime;
    @Column(name = "video_path")
    private String videoPath;

    private Integer likeCount;

    private Integer playCount;

    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "group_id")
    private Integer groupId;


}