package com.arroba.dominio;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tbl_chat")
public class Chat {
    @Id
    @Column(name = "codChat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codChat;
    @ManyToOne
    @JoinColumn(name = "User1_codUser")
    private User User1;
    @ManyToOne
    @JoinColumn(name = "User2_codUser")
    private User User2;

    @OneToMany(mappedBy = "chat")
    private List<Message> messages;

    public Chat() {
    }

    public Chat(Integer codChat, User user1, User user2) {
        this.codChat = codChat;
        User1 = user1;
        User2 = user2;
    }

    public Integer getCodChat() {
        return codChat;
    }

    public void setCodChat(Integer codChat) {
        this.codChat = codChat;
    }

    public User getUser1() {
        return User1;
    }

    public void setUser1(User user1) {
        User1 = user1;
    }

    public User getUser2() {
        return User2;
    }

    public void setUser2(User user2) {
        User2 = user2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return Objects.equals(codChat, chat.codChat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codChat);
    }

    @Override
    public String toString() {
        return "Chat{" +
                "codChat=" + codChat +
//                ", message=" + message +
                '}';
    }
}
