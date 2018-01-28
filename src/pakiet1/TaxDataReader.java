package pakiet1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaxDataReader {
	
	private static double amountProfit;
	private static ContractType typeContract;
	private static InputStreamReader inputStreamReader;
	private static BufferedReader bufferedReader;
	
	public TaxDataReader()
	{
		Init();
	}
	
	private static void Init()
	{
		inputStreamReader = new InputStreamReader(System.in);
		bufferedReader = new BufferedReader(inputStreamReader);	
	}
	
	public void readAmountProfit()
	{
		System.out.println("Podaj kwotê dochodu:");
		try {
			amountProfit = Double.parseDouble(bufferedReader.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readContractType()
	{
		System.out.println("Typ umowy: (P)raca, (Z)lecenie:");
		
		try {
			switch(bufferedReader.readLine().charAt(0))
			{
			case 'P':
				typeContract = ContractType.UoP;
				break;
			case 'Z':
				typeContract = ContractType.UoD;
				break;
			default:
				typeContract = ContractType.Unknown;
			}
		} catch (IOException e) {
			
			typeContract = ContractType.Unknown;
		}
	}
	
	public String getContractTypeString()
	{
		String contractTypeString = "Nieznany typ umowy";
		
		switch(typeContract)
		{
		case UoP:
			contractTypeString = "Umowa o pracê";
			break;
		case UoD:
			contractTypeString = "Umowa-zlecenie";
			break;
		default:
			break;
		}
		
		return contractTypeString;
	}
	
	public ContractType getContractType()
	{
		return typeContract;
	}
	
	public double getAmountProfit()
	{
		return amountProfit;
	}
	
	public void printAmountProfit()
	{
		System.out.println(getAmountProfit());
	}
	
	public void printContractType()
	{
		System.out.println(getContractType());
	}
}