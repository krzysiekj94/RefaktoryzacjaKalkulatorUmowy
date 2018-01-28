package pakiet1;

public class TaxCalculator {
	
	public static double podstawa = 0;
	public static ContractType typUmowy = ContractType.Unknown;


	public static void main(String[] args) {
		
		TaxDataReader taxDataReader = new TaxDataReader();
		
		taxDataReader.readAmountProfit();
		taxDataReader.readContractType();
		
		podstawa = taxDataReader.getAmountProfit();
		typUmowy = taxDataReader.getContractType();
				
		switch(typUmowy)
		{
		
		case UoP:
			UmowaOPrace umowaOprace = new UmowaOPrace( podstawa );
			umowaOprace.Drukuj();
			break;
			
		case UoD:
			UmowaZlecenie umowaZlecenie = new UmowaZlecenie( podstawa );
			umowaZlecenie.Drukuj();
			break;
			
		default:
			System.out.println("Nieznany typ umowy!");
			break;
		}
	}
}
