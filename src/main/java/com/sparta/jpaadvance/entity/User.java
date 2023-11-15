package com.sparta.jpaadvance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //FK의 주인 지정
//    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST) //Default=LAZY, Cascade Persistence Option 적용
    @OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST,CascadeType.REMOVE}) //Cascade Persistence Option 적용
    //DB에 직접적 저장x //관계를 표시하기 위한 하나의 방법
    private List<Food> foodList = new ArrayList<>();

    public void addFoodList(Food food) {
        this.foodList.add(food);
        food.setUser(this); // FK 설정!
    }
}