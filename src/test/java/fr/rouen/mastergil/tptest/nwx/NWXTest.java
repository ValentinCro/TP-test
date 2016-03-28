package fr.rouen.mastergil.tptest.nwx;

import fr.rouen.mastergil.tptest.devoxx2016.page.SpeakerListPage;
import fr.rouen.mastergil.tptest.devoxx2016.page.SpeakerListSearchResultPage;
import fr.rouen.mastergil.tptest.nwx.page.MembersPage;
import fr.rouen.mastergil.tptest.nwx.page.MembersResultPage;
import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

/**
 * Created by rudy on 28/03/16.
 */
public class NWXTest extends FluentTest {

    @Page
    MembersPage membersPage;

    @Page
    MembersResultPage membersResultPage;


    @Test
    public void findMemberVideoGame() {
        //Given
        membersPage.go();
        membersPage.isAt();
        final String company = "GAMIT";
        //When
        membersPage.filter("21");
        //Then

        membersResultPage.isAt();
        assertThat(membersResultPage.getMembers()).hasText(company);
    }

}
