package com.arroba.dominio;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_message")
public class Message {
    @Id
    @Column(name = "codMessage")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codMessage;
    @ManyToOne
    @JoinColumn(name = "codUser")
    private User remetente;
    @ManyToOne
    @JoinColumn(name = "codChat")
    private Chat chat;
    private String descMensagem;

    public Message() {
    }

    public Message(Integer codMessage, User remetente, Chat chat, String descMensagem) {
        this.codMessage = codMessage;
        this.remetente = remetente;
        this.chat = chat;
        this.descMensagem = descMensagem;
    }

    public Integer getCodMessage() {
        return codMessage;
    }

    public void setCodMessage(Integer codMessage) {
        this.codMessage = codMessage;
    }

    public User getRemetente() {
        return remetente;
    }

    public void setRemetente(User remetente) {
        this.remetente = remetente;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public String getDescMensagem() {
        return descMensagem;
    }

    public void setDescMensagem(String descMensagem) {
        this.descMensagem = descMensagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(remetente, message.remetente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(remetente);
    }

    @Override
    public String toString() {
        return "Message{" +
                "codMessage=" + codMessage +
                ", remetente=" + remetente +
                ", chat=" + chat +
                ", descMensagem='" + descMensagem + '\'' +
                '}';
    }
}
