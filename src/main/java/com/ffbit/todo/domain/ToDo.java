package com.ffbit.todo.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "todos")
@Access(AccessType.PROPERTY)
public class ToDo extends AbstractPersistable<Integer> {
    private String title;
    private Integer order;
    private Boolean done;

    @NotNull
    @Size(max = 512)
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotNull
    @Min(1)
    @Column(name = "`order`")
    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @NotNull
    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id='" + getId() + '\'' +
                "title='" + title + '\'' +
                ", order=" + order +
                ", done=" + done +
                '}';
    }

}
