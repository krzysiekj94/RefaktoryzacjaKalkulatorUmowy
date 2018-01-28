package pakiet1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ObliczeniaTests {

	@Test
	public void obliczKosztyUzyskania() {
		
		double podstawa = 100;
		double wartoscKosztowUzyskania = ( podstawa * 20 ) / 100;
		double wartoscOczekiwana = 20;
		
		Assert.assertEquals(wartoscOczekiwana, wartoscKosztowUzyskania, 0.001);
	}
	
	@Test
	public void obliczZaliczke() {
		
		double wartoscOczekiwanaZaliczkiUS = 100; 
		double zaliczkaNaPodstawie = 200;
		double wartoscDrugiejSkladkiZdrowotnej = 50;
		double wartoscKwotyZmniejszonej = 50;
		double wartoscObliczeniaZaliczki = zaliczkaNaPodstawie - wartoscDrugiejSkladkiZdrowotnej - wartoscKwotyZmniejszonej;
		
		Assert.assertEquals(wartoscOczekiwanaZaliczkiUS, wartoscObliczeniaZaliczki, 0.001);
	}

	@Test
	public void testObliczaniaPodatku() {
		
		double podstawa = 100;
		double wartoscOczekiwaniaPodatku = 18;
		double wartoscObliczaniaPodatku = (podstawa * 18) / 100;
		
		Assert.assertEquals(wartoscOczekiwaniaPodatku, wartoscObliczaniaPodatku, 0.001 );
	}

	@Test
	public void testObliczaniaPodstawy() {
		
		double podstawaWartoscPoczatkowa = 100;
		double podstawaWartoscOczekiwana = 0.0;
		double wartoscObliczona = 86.29;
		
		double wartoscSkladkiEmerytalnej = ( podstawaWartoscPoczatkowa * 9.76 ) / 100;
		double wartoscSkladkiRentowej = (podstawaWartoscPoczatkowa * 1.5) / 100;
		double wartoscUbezpieczeniaChorobowego = (podstawaWartoscPoczatkowa * 2.45) / 100;
		
		podstawaWartoscOczekiwana = (podstawaWartoscPoczatkowa 
									- wartoscSkladkiEmerytalnej	
									- wartoscSkladkiRentowej
									- wartoscUbezpieczeniaChorobowego);
		
		Assert.assertEquals(wartoscObliczona, podstawaWartoscOczekiwana, 0.001);
		
	}
	
	@Test
	public void testObliczaniaSkladkiEmerytalnej()
	{
		double podstawa = 100;
		double wartoscOczekiwanaSkladkiEmerytalnej = 9.76;
		double wartoscSkladkiEmerytalnej = ( podstawa * 9.76 ) / 100;
		
		Assert.assertEquals(wartoscOczekiwanaSkladkiEmerytalnej, wartoscSkladkiEmerytalnej, 0.001);
	}
	
	@Test
	public void testObliczaniaSkladkiRentowej()
	{
		double podstawa = 100;
		double wartoscOczekiwanaSkladkiRentowej = 1.5;
		double wartoscSkladkiRentowej = (podstawa * 1.5) / 100;
		
		Assert.assertEquals(wartoscOczekiwanaSkladkiRentowej, wartoscSkladkiRentowej, 0.001);
	}
	
	@Test
	public void testObliczaniaUbezpieczeniaChorobowego()
	{
		double podstawa = 100;
		double wartoscOczekiwanaUbezpieczeniaChorobowego = 2.45;
		double wartoscUbezpieczeniaChorobowego = (podstawa * 2.45) / 100;
		
		Assert.assertEquals(wartoscOczekiwanaUbezpieczeniaChorobowego, wartoscUbezpieczeniaChorobowego, 0.001);
	}
	
	@Test
	public void testObliczaniaPierwszejSkladkiZdrowotnej()
	{
		double podstawa = 100;
		double wartoscSkladkiZdrowotnej = (podstawa * 9) / 100;
		double wartoscOczekiwanaSkladkiZdrowotnej = 9;
		
		Assert.assertEquals(wartoscOczekiwanaSkladkiZdrowotnej, wartoscSkladkiZdrowotnej, 0.001);
	}
	
	public void testObliczaniaDrugiejSkladkiZdrowotnej()
	{
		double podstawa = 100;
		double wartoscSkladkiZdrowotnej = (podstawa * 7.75) / 100;
		double wartoscOczekiwanaSkladkiZdrowotnej = 7.75;
		
		Assert.assertEquals(wartoscOczekiwanaSkladkiZdrowotnej, wartoscSkladkiZdrowotnej, 0.001);
	}
}