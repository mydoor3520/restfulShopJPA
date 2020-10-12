package com.jhpak.restshop.user;

import com.jhpak.restshop.Post.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@JsonIgnoreProperties(value={"password"})
//@JsonFilter("UserInfo")
@ApiModel(description = "사용자 상세 정보 도메인 객체")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Length(min=2, message = "Name은 두 글자 이상입니다.")    //사이즈에 대한 제약조건
    @ApiModelProperty(notes = "사용자 이름")
    private String name;
    @Past           //Date타입일 경우 과거의 타입으로만 미래 날짜는 쓸 수 없도록 함
    @ApiModelProperty(notes = "사용자 등록일")
    private Date joinDate;
    @ApiModelProperty(notes = "사용자 패스워드")
    private String password;
    @ApiModelProperty(notes = "사용자 주민번호")
    private String ssn;

    //한명의 사용자가 여러개의 post를 사용함
    @OneToMany(mappedBy = "user")   //post에 선언 되어 있는 변수값을 적어줘야 함
    private List<Post> posts;

    public User(int i, String kenneth, Date date, String pass1, String ssn) {
        this.id = id;
        this.name = name;
        this.joinDate = date;
        this.password = pass1;
        this.ssn = ssn;
    }
}
