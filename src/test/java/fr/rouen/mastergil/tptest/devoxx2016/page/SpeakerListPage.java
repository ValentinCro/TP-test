package fr.rouen.mastergil.tptest.devoxx2016.page;

import org.fluentlenium.assertj.FluentLeniumAssertions;
import org.fluentlenium.core.FluentPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by rudy on 28/03/16.
 */
public class SpeakerListPage extends FluentPage {

    @Override
    public String getUrl() {
        return "http://cfp.devoxx.fr/2016/index.html";
    }

    @Override
    public void isAt() {
        assertThat(title()).isEqualTo("Schedule ∞ Devoxx");
        FluentLeniumAssertions.assertThat(find("h3")).hasText("Devoxx France 2016");
        FluentLeniumAssertions.assertThat(findFirst("label")).hasText("Trouver un sujet ou un présentateur :");
    }

    public void selectionneSpeaker(String nomSpeaker) {
        fill("input.wpcf7-text").with(nomSpeaker);
        submit("form[name=search]");
    }
}