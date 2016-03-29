package fr.rouen.mastergil.tptest.cpfDevoxx;

import fr.rouen.mastergil.tptest.cpfDevoxx.page.CpfDevoxxPage;
import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withText;

/**
 * Created by valentin on 3/29/16.
 */
public class CpfDevoxxTest extends FluentTest {

    @Page
    CpfDevoxxPage cpfDevoxxPage;


    @Test
    public void validResultWithEntryYouenChene (){
        //GIVEN
        goTo("https://cfp.devoxx.fr/2016/index.html");
        //WHEN
        fill("input").with("Youen Chéné");
        submit("search");
        //THEN
        assertThat(find(".panel").contains("Youen Chéné"));

    }

    @Test
    public void validResultWithEntryRudy (){
        //GIVEN
        goTo("https://cfp.devoxx.fr/2016/index.html");
        //WHEN
        fill("input").with("rudy");
        submit("search");
        //THEN
        assertThat(find(".panel").find("dl").isEmpty());
    }

    @Test
    public void validTitleWithPage() {
        // When
        cpfDevoxxPage.go();
        // then
        cpfDevoxxPage.isAt();
    }
}
