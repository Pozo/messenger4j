package com.github.messenger4j.send.message.template.common;

import com.github.messenger4j.send.message.template.button.Button;
import lombok.NonNull;

import java.net.URL;
import java.util.List;

public class ElementBuilder {
    private final String title;

    private String subtitle;
    private URL imageUrl;
    private DefaultAction defaultAction;
    private List<Button> buttons;

    ElementBuilder(@NonNull String title) {
        this.title = title;
    }

    public ElementBuilder setSubtitle(String subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    public ElementBuilder setImageUrl(URL imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public ElementBuilder setDefaultAction(DefaultAction defaultAction) {
        this.defaultAction = defaultAction;
        return this;
    }

    public ElementBuilder setButtons(List<Button> buttons) {
        this.buttons = buttons;
        return this;
    }

    public Element createElement() {
        return new Element(title, subtitle, imageUrl, defaultAction, buttons);
    }
}