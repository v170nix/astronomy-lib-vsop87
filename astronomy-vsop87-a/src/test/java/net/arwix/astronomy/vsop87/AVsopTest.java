package net.arwix.astronomy.vsop87;

import net.arwix.astronomy.core.Constants;
import net.arwix.astronomy.core.Epoch;
import net.arwix.astronomy.core.Position;
import net.arwix.astronomy.core.calendar.CalendarExtensions;
import net.arwix.astronomy.core.vector.SphericalVector;
import net.arwix.astronomy.core.vector.Vector;
import net.arwix.astronomy.core.vector.VectorType;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

public class AVsopTest {

    private double t;
    private Position position;

    static private String printLongH(Vector p) {
        SphericalVector vector = (SphericalVector) p.getVectorOfType(VectorType.SPHERICAL);
        return String.format(Locale.ENGLISH, "%1$02.4f", Math.toDegrees(vector.phi));
    }

    static private String printLatH(Vector p) {
        SphericalVector vector = (SphericalVector) p.getVectorOfType(VectorType.SPHERICAL);
        return String.format(Locale.ENGLISH, "%1$02.4f", Math.toDegrees(vector.theta));
    }

    static private String printLong(Vector p) {
        SphericalVector vector = (SphericalVector) p.getVectorOfType(VectorType.SPHERICAL);

        double hours = (Constants.DEG * vector.phi / 15.0);

        final int hour = (int) hours;
        final double minutes = (hours - hour) * 60.0;
        final int minute = (int) minutes;
        final double seconds = (minutes - minute) * 60.0;

        return String.format(Locale.ENGLISH, "%1$02d:%2$02d:%3$.2f", hour, minute, seconds);
    }

    static private String printLat(Vector p) {
        SphericalVector vector = (SphericalVector) p.getVectorOfType(VectorType.SPHERICAL);

        int g = (int) Math.toDegrees(vector.theta);
        double mm = (Math.toDegrees(vector.theta) - g) * 60.0;
        int m = (int) mm;
        double s = (mm - m) * 60.0;
        return String.format(Locale.ENGLISH, "%1$02d %2$02d %3$.1f", g, Math.abs(m), Math.abs(s));
    }

    static private String getR(Vector p) {
        SphericalVector vector = (SphericalVector) p.getVectorOfType(VectorType.SPHERICAL);
        return String.format(Locale.ENGLISH, "%1$.6f", vector.r);
    }

    @Before
    public void setUp() throws Exception {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(Calendar.YEAR, 2014);
        calendar.set(Calendar.MONTH, 8);
        calendar.set(Calendar.DAY_OF_MONTH, 17);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        t = CalendarExtensions.getJT(calendar, true);
        position = new Position(new AEarthData());
    }

    @Test
    public void testGeocentricEquatorialPositionMercuryA() throws Exception {
        assertEquals("Epoch J2000", new AMercuryData().getEpoch(), Epoch.J2000);
        assertEquals("IdObject", new AMercuryData().getIdObject(), VsopObject.MERCURY);
        Vector vector = position.getGeocentricEquatorialPosition(t, new AMercuryData());
        assertEquals("Mercury Geo Equatorial Position R.A. J2000", printLong(vector), "13:09:24.26");
        assertEquals("Mercury Geo Equatorial Position DEC. J2000", printLat(vector), "-9 39 1.5");
        assertEquals("Mercury Geo Equatorial Position r. J2000", getR(vector), "1.050373");
    }

    @Test
    public void testGeocentricEquatorialPositionVenusA() throws Exception {
        assertEquals("Epoch J2000", new AVenusData().getEpoch(), Epoch.J2000);
        assertEquals("IdObject", new AVenusData().getIdObject(), VsopObject.VENUS);
        Vector vector = position.getGeocentricEquatorialPosition(t, new AVenusData());
        assertEquals("Venus Geo Equatorial Position R.A. J2000", printLong(vector), "11:02:22.56");
        assertEquals("Venus Geo Equatorial Position DEC. J2000", printLat(vector), "07 39 18.4");
        assertEquals("Venus Geo Equatorial Position r. J2000", getR(vector), "1.686050");
    }

    @Test
    public void testGeocentricEquatorialPositionMarsA() throws Exception {
        assertEquals("Epoch J2000", new AMarsData().getEpoch(), Epoch.J2000);
        assertEquals("IdObject", new AMarsData().getIdObject(), VsopObject.MARS);
        Vector vector = position.getGeocentricEquatorialPosition(t, new AMarsData());
        assertEquals("Mars Geo Equatorial Position R.A. J2000", printLong(vector), "15:57:47.84");
  //      vector = AstronomyMatrix.INSTANCE.createPrecession(Constants.T_J2000, t, AstronomyMatrix.Coordinates.EQUATORIAL).times(AstronomyMatrix.INSTANCE.createNutation(t)).times(vector);

        assertEquals("Mars Geo Equatorial Position DEC. J2000", printLat(vector), "-21 57 1.7");
        assertEquals("Mars Geo Equatorial Position r. J2000", getR(vector), "1.461438");
    }

    @Test
    public void testGeocentricEquatorialPositionJupiterA() throws Exception {
        assertEquals("Epoch J2000", new AJupiterData().getEpoch(), Epoch.J2000);
        assertEquals("IdObject", new AJupiterData().getIdObject(), VsopObject.JUPITER);
        Vector vector = position.getGeocentricEquatorialPosition(t, new AJupiterData());
        assertEquals("Jupiter Geo Equatorial Position R.A. J2000", printLong(vector), "09:03:5.82");
        assertEquals("Jupiter Geo Equatorial Position DEC. J2000", printLat(vector), "17 20 27.4");
        assertEquals("Jupiter Geo Equatorial Position r. J2000", getR(vector), "6.007100");
    }

    @Test
    public void testGeocentricEquatorialPositionSaturnA() throws Exception {
        assertEquals("Epoch J2000", new ASaturnData().getEpoch(), Epoch.J2000);
        assertEquals("IdObject", new ASaturnData().getIdObject(), VsopObject.SATURN);
        Vector vector = position.getGeocentricEquatorialPosition(t, new ASaturnData());
        assertEquals("Saturn Geo Equatorial Position R.A. J2000", printLong(vector), "15:08:38.12");
        assertEquals("Saturn Geo Equatorial Position DEC. J2000", printLat(vector), "-15 31 2.1");
        assertEquals("Saturn Geo Equatorial Position r. J2000", getR(vector), "10.473512");
    }

    @Test
    public void testGeocentricEquatorialPositionUranusA() throws Exception {
        assertEquals("Epoch J2000", new AUranusData().getEpoch(), Epoch.J2000);
        assertEquals("IdObject", new AUranusData().getIdObject(), VsopObject.URANUS);
        Vector vector = position.getGeocentricEquatorialPosition(t, new AUranusData());
        assertEquals("Uranus Geo Equatorial Position R.A. J2000", printLong(vector), "00:56:46.91");
        assertEquals("Uranus Geo Equatorial Position DEC. J2000", printLat(vector), "05 18 33.3");
        assertEquals("Uranus Geo Equatorial Position r. J2000", getR(vector), "19.075160");
    }

    @Test
    public void testGeocentricEquatorialPositionNeptuneA() throws Exception {
        assertEquals("Epoch J2000", new ANeptuneData().getEpoch(), Epoch.J2000);
        assertEquals("IdObject", new ANeptuneData().getIdObject(), VsopObject.NEPTUNE);
        Vector vector = position.getGeocentricEquatorialPosition(t, new ANeptuneData());
        assertEquals("Neptune Geo Equatorial Position R.A. J2000", printLong(vector), "22:30:16.67");
        assertEquals("Neptune Geo Equatorial Position DEC. J2000", printLat(vector), "-10 12 8.7");
        assertEquals("Neptune Geo Equatorial Position r. J2000", getR(vector), "29.016063");
    }

    @Test
    public void testHeliocentricEclipticPositionEarthA() throws Exception {
        assertEquals("Epoch J2000", new AEarthData().getEpoch(), Epoch.J2000);
        assertEquals("IdObject", new AEarthData().getIdObject(), VsopObject.EARTH);
        Vector vector = position.getHeliocentricEclipticPosition(t, new AEarthData());
        assertEquals("Earth Heliocentric Ecliptic Position Lon J2000", printLongH(vector), "353.8347");
        assertEquals("Earth Heliocentric Ecliptic Position Lat. J2000", printLatH(vector), "0.0002");
        assertEquals("Earth Heliocentric Ecliptic Position r. J2000", getR(vector), "1.005239");
    }

}