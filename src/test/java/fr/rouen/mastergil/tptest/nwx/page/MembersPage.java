package fr.rouen.mastergil.tptest.nwx.page;

import org.fluentlenium.assertj.FluentLeniumAssertions;
import org.fluentlenium.core.FluentPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by rudy on 28/03/16.
 */
public class MembersPage extends FluentPage {

    @Override
    public String getUrl() {
        return "http://www.nwx.fr/membres";
    }

    @Override
    public void isAt() {
        assertThat(title()).isEqualTo("Membres | #NWX : association Normandie Web Xperts");
        FluentLeniumAssertions.assertThat(find("h1")).hasText("MEMBRES");
        FluentLeniumAssertions.assertThat(findFirst("#block-block-10")).hasText("L’association est composée de professionnels et entreprises du web, d'écoles et d'institutionnels privés et publics.");
    }

    public void filter(String id) {
        click("select[id='edit-metiers'] option[value='" + id + "']");
    }

}
