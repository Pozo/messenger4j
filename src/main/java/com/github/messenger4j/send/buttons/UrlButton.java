package com.github.messenger4j.send.buttons;

import com.github.messenger4j.common.WebviewHeightRatio;
import java.net.URL;
import java.util.Optional;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * @author Max Grabenhorst
 * @since 0.6.0
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class UrlButton extends Button {

    private final String title;
    private final URL url;
    private final WebviewHeightRatio webviewHeightRatio;
    private final Boolean messengerExtensions;
    private final String fallbackUrl;

    private UrlButton(Builder builder) {
        super(ButtonType.WEB_URL);
        title = builder.title;
        url = builder.url;
        webviewHeightRatio = builder.webviewHeightRatio;
        messengerExtensions = builder.messengerExtensions;
        fallbackUrl = builder.fallbackUrl;
    }

    @Override
    public boolean isUrlButton() {
        return true;
    }

    @Override
    public UrlButton asUrlButton() {
        return this;
    }

    public String title() {
        return title;
    }

    public URL url() {
        return url;
    }

    public Optional<WebviewHeightRatio> webviewHeightRatio() {
        return Optional.ofNullable(webviewHeightRatio);
    }

    public Optional<Boolean> messengerExtensions() {
        return Optional.ofNullable(messengerExtensions);
    }

    public Optional<String> fallbackUrl() {
        return Optional.ofNullable(fallbackUrl);
    }

    /**
     * @author Max Grabenhorst
     * @since 0.6.0
     */
    public static final class Builder {

        private final String title;
        private final URL url;
        private WebviewHeightRatio webviewHeightRatio;
        private Boolean messengerExtensions;
        private String fallbackUrl;
        private final ListBuilder listBuilder;

        Builder(String title, URL url, ListBuilder listBuilder) {
            this.title = title;
            this.url = url;
            this.listBuilder = listBuilder;
        }

        public Builder webviewHeightRatio(@NonNull WebviewHeightRatio webviewHeightRatio) {
            this.webviewHeightRatio = webviewHeightRatio;
            return this;
        }

        public Builder messengerExtensions(boolean messengerExtensions) {
            this.messengerExtensions = messengerExtensions;
            return this;
        }

        public Builder fallbackUrl(@NonNull String fallbackUrl) {
            this.fallbackUrl = fallbackUrl;
            return this;
        }

        public ListBuilder toList() {
            return this.listBuilder.addButtonToList(new UrlButton(this));
        }
    }
}