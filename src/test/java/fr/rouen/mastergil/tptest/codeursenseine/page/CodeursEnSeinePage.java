package fr.rouen.mastergil.tptest.codeursenseine.page;

import org.fluentlenium.core.FluentPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CodeursEnSeinePage extends FluentPage {
    public String getUrl() {
        return "http://www.codeursenseine.com/2015/";
    }

    public void isAt() {
        assertThat(title()).isEqualTo("Accueil - Codeurs en Seine");
    }
}
