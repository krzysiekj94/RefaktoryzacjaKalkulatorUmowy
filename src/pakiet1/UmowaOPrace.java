package pakiet1;
public class UmowaOPrace extends Umowa {

	double m_podatekPotracony;
	
	public UmowaOPrace( double podstawaBrutto )
	{
		super( podstawaBrutto );
	
		UstawKwoteWolnaOdPodatku();
		UstawKosztyUzyskania();
		ObliczPodatek();
		UstawPodatekPotracony();
		ObliczZaliczke();
		ObliczWynagrodzenie();
	}
	
	private void UstawKwoteWolnaOdPodatku(){
		m_kwotaWolnaOdPodatku = 46.33;
	}
	
	private void UstawKosztyUzyskania() {
		m_kosztyUzyskania = 111.25;
	}
	
	public void UstawPodatekPotracony()
	{
		m_podatekPotracony = m_dzaliczkaNaPod - m_kwotaWolnaOdPodatku;
	}
	
	public void Drukuj()
	{
		String tekstDoDruku = "";
		
		tekstDoDruku  = "UMOWA O PRAC�\n";
		tekstDoDruku += "Podstawa wymiaru sk�adek " + m_PodstawaSkladek + "\n";
		tekstDoDruku += "Sk�adka na ubezpieczenie emerytalne " + m_df00.format(m_skladkaEmerytalna) + "\n";
		tekstDoDruku += "Sk�adka na ubezpieczenie rentowe    " + m_df00.format(m_skladkaRentowa) + "\n";
		tekstDoDruku += "Sk�adka na ubezpieczenie chorobowe  " + m_df00.format(m_skladkaChorobowa) + "\n";
		tekstDoDruku += "Podstawa wymiaru sk�adki na ubezpieczenie zdrowotne: " + m_obliczonaPodstawa + "\n";
		tekstDoDruku += "Sk�adka na ubezpieczenie zdrowotne: 9% = " + m_df00.format(m_skladkaZdrowotna1);
		tekstDoDruku += " 7,75% = " + m_df00.format(m_skladkaZdrowotna2) + "\n";
		tekstDoDruku += "Koszty uzyskania przychodu w sta�ej wysoko�ci " + m_kosztyUzyskania + "\n";
		tekstDoDruku += "Podstawa opodatkowania " + (m_obliczonaPodstawa - m_kosztyUzyskania) + " zaokr�glona " + m_df.format(m_obliczonaPodstawa - m_kosztyUzyskania) + "\n";
		tekstDoDruku += "Zaliczka na podatek dochodowy 18 % = " + m_dzaliczkaNaPod + "\n";
		tekstDoDruku += "Kwota wolna od podatku = " + m_kwotaWolnaOdPodatku + "\n";
		tekstDoDruku += "Podatek potr�cony = " + m_df00.format(m_podatekPotracony) + "\n";
		tekstDoDruku += "Zaliczka do urz�du skarbowego = " + m_df00.format(m_ZaliczkaDoUS) + " po zaokr�gleniu = " + m_df.format(m_ZaliczkaDoUS) + "\n";
		tekstDoDruku += "\n";
		tekstDoDruku += "Pracownik otrzyma wynagrodzenie netto w wysoko�ci = " + m_df00.format(m_wynagrodzenie);
		
		System.out.println(tekstDoDruku);
	}
}
