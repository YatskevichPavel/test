package by.itacademy.jd2.firstapp;

import java.time.LocalDateTime;

public class Feedback {
    public String text;
    public LocalDateTime time;

    public Feedback(String text) {
        this.text = text;
        time = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return  text + '\'' + time;
    }
}