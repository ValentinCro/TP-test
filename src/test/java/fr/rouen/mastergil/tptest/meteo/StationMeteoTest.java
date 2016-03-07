package fr.rouen.mastergil.tptest.meteo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StationMeteoTest {

    @Mock
    private IWeatherProvider iWeatherProvider;

    @InjectMocks
    private StationMeteo stationMeteo;

    @Test
    public void forecast_for_Paris() throws Exception {
        //Given
        when(iWeatherProvider.getForecastByCity(eq("Rouen,FR"))).thenReturn(Arrays.asList(new Prevision().setDate(new Date())));
        //When
        final List<Prevision> previsions = stationMeteo.majPrevision("Rouen,FR");
        //Then
        assertThat(previsions).hasSize(1);
    }


}