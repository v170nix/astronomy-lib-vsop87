package net.arwix.astronomy.vsop87;

import net.arwix.astronomy.core.Constants;
import net.arwix.astronomy.core.Position;
import net.arwix.astronomy.core.vector.SphericalVector;
import net.arwix.astronomy.core.vector.Vector;
import net.arwix.astronomy.core.vector.VectorType;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;


public class CVsopTest {

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
//        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
//        calendar.set(Calendar.YEAR, 2014);
//        calendar.set(Calendar.MONTH, 8);
//        calendar.set(Calendar.DAY_OF_MONTH, 17);
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        t = CalendarExtensions.getJT(calendar, true);
//        position = new Position(new CEarthData());
    }

    @Test
    public void testGeocentricEquatorialPositionMercuryA() throws Exception {
//        assertEquals("Epoch APPARENT", new CMercuryData().getEpoch(), Epoch.APPARENT);
//        assertEquals("IdObject", new CMercuryData().getIdObject(), VsopObject.MERCURY);
//        Vector vector = position.getGeocentricEquatorialPosition(t, new CMercuryData());
//        assertEquals("Mercury Geo Equatorial Position R.A. APPARENT", printLong(vector), "13:10:9.81");
//        assertEquals("Mercury Geo Equatorial Position DEC. APPARENT", printLat(vector), "-9 43 35.9");
//        assertEquals("Mercury Geo Equatorial Position r. APPARENT", getR(vector), "1.050329");
    }

    @Test
    public void testGeocentricEquatorialPositionVenusA() throws Exception {
//        assertEquals("Epoch APPARENT", new CVenusData().getEpoch(), Epoch.APPARENT);
//        assertEquals("IdObject", new CVenusData().getIdObject(), VsopObject.VENUS);
//        Vector vector = position.getGeocentricEquatorialPosition(t, new CVenusData());
//        assertEquals("Venus Geo Equatorial Position R.A. APPARENT", printLong(vector), "11:03:7.51");
//        assertEquals("Venus Geo Equatorial Position DEC. APPARENT", printLat(vector), "07 34 35.9");
//        assertEquals("Venus Geo Equatorial Position r. APPARENT", getR(vector), "1.686082");
    }

    @Test
    public void testGeocentricEquatorialPositionMarsA() throws Exception {
//        assertEquals("Epoch APPARENT", new CMarsData().getEpoch(), Epoch.APPARENT);
//        assertEquals("IdObject", new CMarsData().getIdObject(), VsopObject.MARS);
//        Vector vector = position.getGeocentricEquatorialPosition(t, new CMarsData());
//        assertEquals("Mars Geo Equatorial Position R.A. APPARENT", printLong(vector), "15:58:39.89");
//        assertEquals("Mars Geo Equatorial Position DEC. APPARENT", printLat(vector), "-21 59 24.1");
//        assertEquals("Mars Geo Equatorial Position r. APPARENT", getR(vector), "1.461305");
    }

    @Test
    public void testGeocentricEquatorialPositionJupiterA() throws Exception {
//        assertEquals("Epoch APPARENT", new CJupiterData().getEpoch(), Epoch.APPARENT);
//        assertEquals("IdObject", new CJupiterData().getIdObject(), VsopObject.JUPITER);
//        Vector vector = position.getGeocentricEquatorialPosition(t, new CJupiterData());
//        assertEquals("Jupiter Geo Equatorial Position R.A. APPARENT", printLong(vector), "09:03:54.59");
//        assertEquals("Jupiter Geo Equatorial Position DEC. APPARENT", printLat(vector), "17 16 52.6");
//        assertEquals("Jupiter Geo Equatorial Position r. APPARENT", getR(vector), "6.007494");
    }

    @Test
    public void testGeocentricEquatorialPositionSaturnA() throws Exception {
//        assertEquals("Epoch APPARENT", new CSaturnData().getEpoch(), Epoch.APPARENT);
//        assertEquals("IdObject", new CSaturnData().getIdObject(), VsopObject.SATURN);
//        Vector vector = position.getGeocentricEquatorialPosition(t, new CSaturnData());
//        assertEquals("Saturn Geo Equatorial Position R.A. APPARENT", printLong(vector), "15:09:27.10");
//        assertEquals("Saturn Geo Equatorial Position DEC. APPARENT", printLat(vector), "-15 34 14.0");
//        assertEquals("Saturn Geo Equatorial Position r. APPARENT", getR(vector), "10.472671");
    }

    @Test
    public void testGeocentricEquatorialPositionUranusA() throws Exception {
//        assertEquals("Epoch APPARENT", new CUranusData().getEpoch(), Epoch.APPARENT);
//        assertEquals("IdObject", new CUranusData().getIdObject(), VsopObject.URANUS);
//        Vector vector = position.getGeocentricEquatorialPosition(t, new CUranusData());
//        assertEquals("Uranus Geo Equatorial Position R.A. APPARENT", printLong(vector), "00:57:34.20");
//        assertEquals("Uranus Geo Equatorial Position DEC. APPARENT", printLat(vector), "05 23 26.8");
//        assertEquals("Uranus Geo Equatorial Position r. APPARENT", getR(vector), "19.075819");
    }

    @Test
    public void testGeocentricEquatorialPositionNeptuneA() throws Exception {
//        assertEquals("Epoch APPARENT", new CNeptuneData().getEpoch(), Epoch.APPARENT);
//        assertEquals("IdObject", new CNeptuneData().getIdObject(), VsopObject.NEPTUNE);
//        Vector vector = position.getGeocentricEquatorialPosition(t, new CNeptuneData());
//        assertEquals("Neptune Geo Equatorial Position R.A. APPARENT", printLong(vector), "22:31:4.76");
//        assertEquals("Neptune Geo Equatorial Position DEC. APPARENT", printLat(vector), "-10 07 23.7");
//        assertEquals("Neptune Geo Equatorial Position r. APPARENT", getR(vector), "29.015122");
    }

    @Test
    public void testHeliocentricEclipticPositionEarthA() throws Exception {
//        assertEquals("Epoch APPARENT", new CEarthData().getEpoch(), Epoch.APPARENT);
//        assertEquals("IdObject", new CEarthData().getIdObject(), VsopObject.EARTH);
//        Vector vector = position.getHeliocentricEclipticPosition(t, new CEarthData());
//        assertEquals("Earth Heliocentric Ecliptic Position Lon APPARENT", printLongH(vector), "353.8347");
//        assertEquals("Earth Heliocentric Ecliptic Position Lat. APPARENT", printLatH(vector), "0.0002");
//        assertEquals("Earth Heliocentric Ecliptic Position r. APPARENT", getR(vector), "1.005239");
    }

}