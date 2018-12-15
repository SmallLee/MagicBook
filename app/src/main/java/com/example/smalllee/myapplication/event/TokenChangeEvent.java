package com.example.smalllee.myapplication.event;

/**
 * Created by smallLee on 2018/12/14.
 *
 */

public class TokenChangeEvent extends BaseEvent<String> {
    public TokenChangeEvent(){}
    public TokenChangeEvent(String data) {
        super(data);
    }
}
