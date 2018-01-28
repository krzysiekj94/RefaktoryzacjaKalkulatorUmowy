package pakiet1;

import java.text.DecimalFormat;

public class Umowa {

	protected double m_kosztyUzyskania;
	protected double m_skladkaEmerytalna;
	protected double m_skladkaRentowa;
	protected double m_skladkaChorobowa;
	protected double m_skladkaZdrowotna1;
	protected double m_skladkaZdrowotna2;
	protected double m_kwotaWolnaOdPodatku;
	protected double m_ZaliczkaDoUS;
	protected double m_PodstawaSkladek;
	protected double m_wynagrodzenie;
	protected double m_obliczonaPodstawa;
	protected double m_dzaliczkaNaPod;
	protected DecimalFormat m_df;
	protected DecimalFormat m_df00;
	
	public Umowa(double podstawaSkladek)
	{
		m_df00 = new DecimalFormat("#.00");
		m_df = new DecimalFormat("#");
		m_obliczonaPodstawa = 0;
		m_dzaliczkaNaPod = 0;
		m_skladkaEmerytalna = 0;
		m_skladkaRentowa = 0;
		m_skladkaChorobowa = 0;
		m_skladkaZdrowotna1 = 0;
		m_skladkaZdrowotna2 = 0;
		m_kwotaWolnaOdPodatku = 46.33;
		m_ZaliczkaDoUS = 0;
		m_wynagrodzenie = 0;
		m_PodstawaSkladek = podstawaSkladek;
		
		ObliczPodstawe();
		ObliczUbezpieczenia();
	}
	
	public void ObliczPodstawe() {
		
		m_skladkaEmerytalna = (m_PodstawaSkladek * 9.76) / 100;
		m_skladkaRentowa = (m_PodstawaSkladek * 1.5) / 100;
		m_skladkaChorobowa = (m_PodstawaSkladek * 2.45) / 100;
		m_obliczonaPodstawa = (m_PodstawaSkladek - m_skladkaEmerytalna - m_skladkaRentowa - m_skladkaChorobowa);
	}
	
	public void ObliczUbezpieczenia() {
		m_skladkaZdrowotna1 = ( m_obliczonaPodstawa * 9) / 100;
		m_skladkaZdrowotna2 = ( m_obliczonaPodstawa * 7.75) / 100;
	}
	
	public void ObliczWynagrodzenie()
	{
		double zaliczkaUSPrzyblizona = Double.parseDouble(m_df.format(m_ZaliczkaDoUS));
		m_wynagrodzenie = m_PodstawaSkladek - ((m_skladkaEmerytalna + m_skladkaRentowa + m_skladkaChorobowa) + m_skladkaZdrowotna1 + zaliczkaUSPrzyblizona);
	}
	
	
	public void ObliczPodatek() {
		
		double podstawaOpodatkowania = Double.parseDouble(m_df.format(m_obliczonaPodstawa - m_kosztyUzyskania));		
		m_dzaliczkaNaPod = ( ( podstawaOpodatkowania ) * 18) / 100;
	}
	
	public void ObliczZaliczke() {
		m_ZaliczkaDoUS = m_dzaliczkaNaPod - m_skladkaZdrowotna2 - m_kwotaWolnaOdPodatku;
	}
}