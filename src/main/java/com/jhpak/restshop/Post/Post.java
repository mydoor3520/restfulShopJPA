package com.jhpak.restshop.Post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jhpak.restshop.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)  // post데이터가 필요로 하는 user 정보는 바로 생성되는 것이 아니기 때문에 user가 생성되기 까지 기다리고 가지고 옮을 뜻함
    @JsonIgnore
    private User user;
}
