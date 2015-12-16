package com.mibeez.hubBe.controllers;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;

public class HwController {

    private static GpioPinDigitalOutput pin;
    private GpioController gpio;

    public HwController(){
        gpio = GpioFactory.getInstance();
    }

    @RequestMapping("/")
    public String Ack(){
        return "Hub Be is Running!";
    }

    @RequestMapping("/light1")
    public String lightGpio01(){
        if(pin == null) {
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED_01", PinState.LOW);
        }

        pin.toggle();
        return pin.getState().toString();
    }

    @RequestMapping("/light2")
    public String lightGpio02(){
        if(pin == null) {
            GpioController gpio = GpioFactory.getInstance();
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "MyLED_02", PinState.LOW);
        }

        pin.toggle();
        return pin.getState().toString();
    }
}
