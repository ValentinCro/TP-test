package fr.rouen.mastergil.tptest.meteo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StationMeteoTest {

    @Mock
    private OpenWeatherMapProvider openWeatherMapProvider;

    @InjectMocks
    private StationMeteo stationMeteo;

    @Before
    public void setUp() {
        Prevision prevision = new Prevision();
        List<Prevision> list = new ArrayList<Prevision>();
        list.add(prevision);
        when(openWeatherMapProvider.getForecastByCity("Rouen")).thenReturn(list);
    }

    @Test
    public void majPrevisionAppelGetForecastByCityEtRetourneUneListeDePrevision() throws Exception {
        //Given
        //Then
        List<Prevision> previsions = stationMeteo.majPrevision("Rouen");
        //When
        assertThat(previsions.size()).isEqualTo(1);
    }
}