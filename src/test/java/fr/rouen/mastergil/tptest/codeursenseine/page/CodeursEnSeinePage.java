package fr.rouen.mastergil.tptest.codeursenseine.page;

import org.fluentlenium.core.FluentPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by rudy on 28/03/16.
 */
public class CodeursEnSeinePage extends FluentPage {

    @Override
    public String getUrl() {
        return "http://www.codeursenseine.com/2015/";
    }

    @Override
    public void isAt() {
        assertThat(title()).isEqualTo("Accueil - Codeurs en Seine");
    }

}
