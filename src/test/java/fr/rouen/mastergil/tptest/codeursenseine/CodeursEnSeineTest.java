package fr.rouen.mastergil.tptest.codeursenseine;

import fr.rouen.mastergil.tptest.codeursenseine.page.CodeursEnSeinePage;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

import org.fluentlenium.adapter.FluentTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by rudy on 28/03/16.
 */
public class CodeursEnSeineTest extends FluentTest {

    @Page
    CodeursEnSeinePage codeursEnSeinePage;


    @Test
    public void validTitle() {
        //When
        goTo("http://www.codeursenseine.com/2015/");
        //Then
        assertThat(title()).isEqualTo("Accueil - Codeurs en Seine");
    }

    @Test
    public void validTitleWithPage() {
        // When
        codeursEnSeinePage.go();
        // then
        codeursEnSeinePage.isAt();
    }

}
