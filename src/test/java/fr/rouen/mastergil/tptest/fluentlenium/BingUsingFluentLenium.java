package fr.rouen.mastergil.tptest.fluentlenium;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BingUsingFluentLenium extends FluentTest {

    @Test
    public void title_of_bing_should_contain_search_query_name() {
        //GIVEN
        goTo("http://www.bing.com");
        //WHEN
        fill("#sb_form_q").with("Selenium");
        submit("#sb_form_go");
        //THEN
        assertThat(title()).contains("Selenium");
    }
}