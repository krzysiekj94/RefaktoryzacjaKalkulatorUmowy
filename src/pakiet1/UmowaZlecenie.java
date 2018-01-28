package pakiet1;
public class UmowaZlecenie extends Umowa {

	double m_podatekPotracony;
	
	public UmowaZlecenie( double podstawaBrutto )
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
		m_kwotaWolnaOdPodatku = 0;
	}
	
	private void UstawKosztyUzyskania() {
		m_kosztyUzyskania = ( m_obliczonaPodstawa * 20) / 100;
	}
	
	public void UstawPodatekPotracony(){
		m_podatekPotracony = m_dzaliczkaNaPod;
	}

	public void Drukuj(){
		
		String tekstDoDruku = "";
		
		tekstDoDruku += "UMOWA-ZLECENIE" + "\n";
		tekstDoDruku += "Podstawa wymiaru sk³adek " + m_PodstawaSkladek + "\n";
		tekstDoDruku += "Sk³adka na ubezpieczenie emerytalne " + m_df00.format(m_skladkaEmerytalna) + "\n";
		tekstDoDruku += "Sk³adka na ubezpieczenie rentowe    " + m_df00.format(m_skladkaRentowa) + "\n";
		tekstDoDruku += "Sk³adka na ubezpieczenie chorobowe  " + m_df00.format(m_skladkaChorobowa) + "\n";
		tekstDoDruku += "Podstawa wymiaru sk³adki na ubezpieczenie zdrowotne: " +  m_obliczonaPodstawa + "\n";
		tekstDoDruku += "Sk³adka na ubezpieczenie zdrowotne: 9% = " +  m_df00.format(m_skladkaZdrowotna1) + " 7,75% = " + m_df00.format(m_skladkaZdrowotna2) + "\n";
		tekstDoDruku += "Koszty uzyskania przychodu (sta³e) " + m_kosztyUzyskania + "\n";
		tekstDoDruku += "Podstawa opodatkowania " + (m_obliczonaPodstawa - m_kosztyUzyskania) + " zaokr¹glona " + m_df.format(m_obliczonaPodstawa - m_kosztyUzyskania) + "\n";
		tekstDoDruku += "Zaliczka na podatek dochodowy 18 % = " + m_dzaliczkaNaPod + "\n";
		tekstDoDruku += "Podatek potr¹cony = "+ m_df00.format(m_podatekPotracony) + "\n";
		tekstDoDruku += "Zaliczka do urzêdu skarbowego = " + m_df00.format(m_ZaliczkaDoUS) + " po zaokr¹gleniu = " + m_df.format(m_ZaliczkaDoUS) + "\n";
		tekstDoDruku += "\n";
		tekstDoDruku += "Pracownik otrzyma wynagrodzenie netto w wysokoœci = " + m_df00.format(m_wynagrodzenie);
		
		System.out.println(tekstDoDruku);
	}
}
