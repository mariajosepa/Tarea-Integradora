package ui;
import model.*; 
import java.util.*;


public class Main { 

	    public static final double DESIGN_STAGE = 1300000;
		public static final double POST_CONSTRUCTION = 2600000;
		public static final double PAINT = 980000;

	public static int getNumberMaterials(Scanner input){

		int numberMaterials;

		System.out.println("Ingrese el numero de materiales que necesita");
		numberMaterials = input.nextInt();
		input.nextLine();

		return numberMaterials; 
	}

	public static String getLocation(Scanner input){

		String location;

		System.out.println("Ingrese su ubicacion [n][c][s]");
		location = input.next();

		return location;

	}

	public static String getName(){

		Scanner input = new Scanner (System.in);

		System.out.println("Ingrese nombre del material:");
		String name = input.next();

		return name;

		}

	public static int getCategory(){

		Scanner input = new Scanner (System.in);

		System.out.println("Obra negra  [1]");
		System.out.println("Obra blanca [2]");
		System.out.println("Pintura     [3]");
		int category = input.nextInt();

		return category;

	}

	public static void main(String [] args){

		Scanner input = new Scanner (System.in);

		int numberMaterials = getNumberMaterials(input);
		

		String [] designStage = new String [numberMaterials];
		String [] postConstruction = new String[numberMaterials];
		String [] paint = new String[numberMaterials];

	  
	    Double [] homeCenter = new Double[numberMaterials];
	    Double [] ferreteriaCentro = new Double[numberMaterials];
	    Double [] ferreteriaBarrio = new Double [numberMaterials];

	    Double [] bestPrice = new Double[numberMaterials];
        String [] bestPlace = new String [numberMaterials];
	    
		String material = "";
		String name = "";
		double materialPrice = 0.0;

		boolean repeat = true;
		int category = 0;
		String answer = "";
		
		Operation op = new Operation();


			for (int i = 0; i=true; i++){

			category = getCategory();

			System.out.print("Material "+ (i+1) + " ");

			switch(category) {

				case 1 :

					name = getName();
					designStage[i]=name;

					break;

				case 2 :

					name = getName();
					postConstruction[i]=name;
					break;

				case 3 :

					name = getName();
					paint[i]=name;

					break;

				default : 
					System.out.println("Esa opcion no existe");
					i = 0;

			}

					System.out.println("Ingrese precio del material en Home Center");
					homeCenter[i]=input.nextDouble();

					System.out.println("Ingrese precio del material en Ferreteria del Centro");
					ferreteriaCentro[i]=input.nextDouble();

					System.out.println("Ingrese precio del material en Ferreteria del Barrio");
					ferreteriaBarrio[i]=input.nextDouble();



			System.out.println("Desea ingresar otro material [s] [n]");
			answer = input.next();

			if (answer.equals("n"))
				 repeat = false;
			}

		

			for (int x = 0; x < numberMaterials;x++){

				bestPrice[x] = op.bestPrice(homeCenter[x],ferreteriaCentro[x],ferreteriaBarrio[x]);

				bestPlace[x] = op.bestPlace(bestPrice[x], homeCenter[x], ferreteriaBarrio[x], ferreteriaCentro[x]);


			}





	
	}

}
