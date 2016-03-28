package fr.rouen.mastergil.tptest.devoxx2016.page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class SpeakerListSearchResultPage extends FluentPage {
    @Override
    public void isAt() {
        assertThat(url()).startsWith("http://cfp.devoxx.fr/2016/search?q=");
    }

    public FluentWebElement getSpeakerName() {
        return findFirst("div.panel");
    }
}