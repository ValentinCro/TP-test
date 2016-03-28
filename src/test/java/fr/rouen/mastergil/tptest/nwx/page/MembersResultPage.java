package fr.rouen.mastergil.tptest.nwx.page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by rudy on 28/03/16.
 */
public class MembersResultPage extends FluentPage {
    @Override
    public void isAt() {
        assertThat(url()).startsWith("http://www.nwx.fr/membres?metiers=");
    }

    public FluentWebElement getMembers() {
        return findFirst(".view-content");
    }
}
