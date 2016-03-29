package fr.rouen.mastergil.tptest.nwx;

import fr.rouen.mastergil.tptest.nwx.page.NwxPage;
import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by valentin on 3/29/16.
 */
public class NwxTest extends FluentTest {

    @Page
    NwxPage nwxPage;

    @Test
    public void validResultWithEntryJeuVideo (){
        //GIVEN
        goTo("http://www.nwx.fr/membres");
        //WHEN
        fillSelect("#edit-metiers").withValue("21");
        //THEN
        assertThat(find("#node-284").find("h1").find("span").contains("GAMIT"));
    }

    @Test
    public void validTitleWithPage() {
        // When
        nwxPage.go();
        // then
        nwxPage.isAt();
    }
}
