package com.github.messenger4j.send.message.template.common;

import com.github.messenger4j.internal.Lists;
import com.github.messenger4j.send.message.template.button.Button;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.net.URL;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

/**
 * @author Max Grabenhorst
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode
public final class Element {

    private final String title;

    private final String subtitle;
    private final URL imageUrl;
    private final DefaultAction defaultAction;
    private final List<Button> buttons;

    Element(String title,
            String subtitle,
            URL imageUrl,
            DefaultAction defaultAction,
            List<Button> buttons) {

        this.title = title;
        this.subtitle = subtitle;
        this.imageUrl = imageUrl;
        this.defaultAction = defaultAction;
        this.buttons = Lists.immutableList(buttons);

    }

    public static ElementBuilder builder(String title) {
        return new ElementBuilder(title);
    }

    public String title() {
        return title;
    }

    public Optional<String> subtitle() {
        return ofNullable(subtitle);
    }

    public Optional<URL> imageUrl() {
        return ofNullable(imageUrl);
    }

    public Optional<DefaultAction> defaultAction() {
        return ofNullable(defaultAction);
    }

    public Optional<List<Button>> buttons() {
        return ofNullable(buttons);
    }
}
