package fr.rouen.mastergil.tptest.nwx.page;

import org.fluentlenium.core.FluentPage;

import static org.assertj.core.api.Assertions.assertThat;

public class NwxPage extends FluentPage {
    public String getUrl() {
        return "http://www.nwx.fr/membres";
    }

    public void isAt() {
        assertThat(title()).isEqualTo("Membres | #NWX : association Normandie Web Xperts");
    }
}
