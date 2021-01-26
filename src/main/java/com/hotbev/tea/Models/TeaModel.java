package com.hotbev.tea.Models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "teas")
@Entity
public class TeaModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column
    protected String description;

    @Column
    protected String name;

    @Column
    protected String source;



    public TeaModel(String description, String name, String source) {
        this.description = description;
          this.name=name;
        this.source = source;
    }

    public TeaModel() {
    }


}
