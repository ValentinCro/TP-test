package fr.rouen.mastergil.tptest.devoxx2016;


import fr.rouen.mastergil.tptest.devoxx2016.page.SpeakerListPage;
import fr.rouen.mastergil.tptest.devoxx2016.page.SpeakerListSearchResultPage;
import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DevoxxTest extends FluentTest {

    @Page
    SpeakerListPage speakerListPage;

    @Page
    SpeakerListSearchResultPage speakerListSearchResultPage;



    @Test
    public void findSpearker() {
        //Given
        speakerListPage.go();
        speakerListPage.isAt();
        final String speakerName = "Youen Chéné";
        //When
        speakerListPage.selectionneSpeaker(speakerName);
        //Then
        speakerListSearchResultPage.isAt();
        assertThat(speakerListSearchResultPage.getSpeakerName()).hasText(speakerName);
    }

    @Test
    public void findNoSpearker() {
        //Given
        speakerListPage.go();
        speakerListPage.isAt();
        final String speakerName = "Rudy";
        //When
        speakerListPage.selectionneSpeaker(speakerName);
        //Then
        speakerListSearchResultPage.isAt();
        assertThat(speakerListSearchResultPage.getSpeakerName()).hasText("");
    }



}