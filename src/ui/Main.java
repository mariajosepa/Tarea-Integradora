package ui;
import model.*; 
import java.util.*;


public class Main { 

	    public static final double DESIGN_STAGE = 1300000;
		public static final double POST_CONSTRUCTION = 2600000;
		public static final double PAINT = 980000;


		static Scanner input = new Scanner (System.in);
		static  int numberMaterials = getNumberMaterials(input);
		
		
		static String [] designStage = new String [numberMaterials];
		static String [] postConstruction = new String[numberMaterials];
		static String [] paint = new String[numberMaterials];

	  
	   static Double [] homeCenter = new Double[numberMaterials];
	   static Double [] ferreteriaCentro = new Double[numberMaterials];
	   static Double [] ferreteriaBarrio = new Double [numberMaterials];

	   static Double [] bestPrice = new Double[numberMaterials];

	    
		static String material = "";
		static double precioMaterial = 0.0;

		static boolean repeat = true;
		static int option = 0;
		static String answer = "";
		static String [] bestPlace = new String [numberMaterials] "";
		static Operation op = new Operation();



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

		
	public static void main(String [] args){
	
		Scanner input = new Scanner (System.in);


		System.out.println("Ingrese las siguientes caracteristicas del material");


			for (int i = 0; repeat == true; i++){

			System.out.println("Material: " +i+1);
			System.out.println(); 
			System.out.println("Obra negra  [1]");
			System.out.println("Obra blanca [2]");
			System.out.println("Pintura     [3]");
			option = input.nextInt();

			switch(option) {

				case 1 :

					System.out.println("Ingrese el nombre del material");
					designStage[i]=input.next();

					break;

				case 2 :

					System.out.println("Ingrese el nombre del material");
					postConstruction[i]=input.next();
					break;

				case 3 :

					System.out.println("Ingrese el nombre del material");
					paint[i]=input.next();

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
				repeat = false ;	

			}

			for (int x = 0; x < numberMaterials;x++){

				bestPrice[x] = op.bestPrice(homeCenter[x],ferreteriaCentro[x],ferreteriaBarrio[x]);

			
				if (bestPrice[x]==0){

					bestPlace [x] = "Home Center,Ferreteria del Centro, Ferreteria del Bariio";
				}

				if (bestPrice[x] == homeCenter[x]) {

					bestPlace [x] = "Home Center";
				}

				if (bestPrice[x] == ferreteriaCentro[x]){

					bestPlace [x] = "Ferreteria del Centro";
				}

				if (bestPrice[x] == ferreteriaBarrio[x]){

					bestPlace [x] = "Ferreteria del Barrio";
				}

				if (bestPrice[x]==ferreteriaBarrio[x] && bestPrice[x] == ferreteriaCentro[x]){

					bestPlace[x]= "Ferreteria del Barrio y Ferreteria del Centro";

				}

				if (bestPrice[x]==ferreteriaBarrio[x] && bestPrice[x] == homeCenter[x]){

					bestPlace[x]= "Ferreteria del Barrio y Ferreteria del Centro";

				}

				if (bestPrice[x]==ferreteriaCentro[x] && bestPrice[x] == homeCenter[x]){

					bestPlace[x]= "Ferreteria del Barrio y Ferreteria del Centro";

				}
	

	

	



			}





	
	}

}
