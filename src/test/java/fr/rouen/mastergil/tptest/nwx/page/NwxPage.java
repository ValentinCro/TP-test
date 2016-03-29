package fr.rouen.mastergil.tptest.nwx.page;

import org.fluentlenium.core.FluentPage;

import static org.assertj.core.api.Assertions.assertThat;

public class NwxPage extends FluentPage {
    public String getUrl() {
        return "https://cfp.devoxx.fr/2016/index.html";
    }

    public void isAt() {
        assertThat(title()).isEqualTo("Schedule ∞ Devoxx");
    }
}
