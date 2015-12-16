package com.mibeez.hubBe.controllers;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;

public class HwController {

    private static GpioPinDigitalOutput pin;

    @RequestMapping("/")
    public String Ack(){
        return "Hub Be is Running!";
    }

    @RequestMapping("/light")
    public String light(){
        if(pin == null) {
            GpioController gpio = GpioFactory.getInstance();
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
        }

        pin.toggle();
        return pin.getState().toString();
    }
}
